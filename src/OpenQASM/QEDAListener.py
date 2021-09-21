import os
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .qasm3Parser import qasm3Parser
    from .qasm3Lexer import qasm3Lexer as Lexer
    from .qasm3Listener import qasm3Listener as Listener
else:
    from qasm3Parser import qasm3Parser
    from qasm3Lexer import qasm3Lexer as Lexer
    from qasm3Listener import qasm3Listener as Listener
from .QAST import Gate, U, CX


def INCLUDE(file):
    f = os.getcwd() + '/' + file.getText().split('"')[1]
    input_stream = FileStream(fileName=f, encoding='utf-8')
    #open(f, 'r')
    # tokenize
    lexer = Lexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = qasm3Parser(stream)
    tree = parser.program()
    listener = qasm3Listener()
    walker = ParseTreeWalker()
    walker.walk(listener, tree)
    return listener

class QEDAListener(Listener):
    def INCLUDE(self, file):
        f = self.file + "/" + file.getText().split('"')[1]
        input_stream = FileStream(fileName=f, encoding='utf-8')
        lexer = Lexer(input_stream)
        stream = CommonTokenStream(lexer)
        parser = qasm3Parser(stream)
        tree = parser.program()
        listener = QEDAListener()
        walker = ParseTreeWalker()
        walker.walk(listener, tree)
        return listener

    def __init__(self, file=None):
        super()
        if(file==None):
            self.file = os.getcwd()
        else:
            self.file = os.getcwd() + '/' + ''.join([x+'/' for x in file.split('/')[:-1]])
        self.QCODE = []
        self.GATES = [U(), CX()]
        self.file = "/" + self.file.strip("/")
        self.currentModifier = None
        self.modExpression = None
        print(self.file)

    def enterInclude(self, ctx: qasm3Parser.IncludeContext):
        return super().enterInclude(ctx)

    def _hasQGate(self, gid):
        for gate in self.GATES:
            if(gate != None):
                if(str(gid) == str(gate.name)):
                    return True
        return False

    def enterQuantumGateDefinition(self, ctx: qasm3Parser.QuantumGateDefinitionContext):
        gid = ctx.quantumGateSignature().quantumGateName().Identifier()
        if(self._hasQGate(gid)):
            raise Exception("Quantum Gate Definition Error: " + str(gid) + " already defined.")
        else:
            g = Gate()
            g.SetName(gid)
            self.GATES.append(g)
        return super().enterQuantumGateDefinition(ctx)

    def enterQuantumBlock(self, ctx: qasm3Parser.QuantumBlockContext):
        #print("BLOCK")
        return super().enterQuantumBlock(ctx)

    def enterQuantumGateCall(self, ctx: qasm3Parser.QuantumGateCallContext):
        # First we need to get the identifier of the gate
        gate_name = ctx.quantumGateName().Identifier()
        #print(ctx.getText())
        addNewGate = False
        if(type(gate_name) == type(None)):
            # Either built-in U or CX
            gate_name = ctx.quantumGateName().getText()
            # If built-in gate, we need to init a new gate
            addNewGate = True
        print(gate_name)
        # Now, we need to check if gate is defined
        # Undefined gates should raise an error
        try:
            assert self._hasQGate(gate_name)
        except AssertionError as e:
            print("Gate Name: " + str(gate_name) + " not defined")
            exit()
        # Now that we know the gate is available, we need to add
        # the gate to the proper qubit
        print(gate_name, ctx.quantumGateModifier())
        [print(x.Identifier()) for x in ctx.indexIdentifierList().indexIdentifier()]
        return super().enterQuantumGateCall(ctx)

    def exitQuantumGateCall(self, ctx: qasm3Parser.QuantumGateCallContext):
        #print("Exiting gate call")
        if(self.currentModifier != None):
            if(self.modExpression != None):
        #        print(self.modExpression.expression())
         #       print(self.modExpression.logicalAndExpression())
          #      print(self.modExpression.unaryExpression())
           #     print(self.modExpression.expressionTerminator())
                pass
        self.currentModifier = None
        self.modExpression = None
        return super().exitQuantumGateCall(ctx)

    def enterQuantumGateModifier(self, ctx: qasm3Parser.QuantumGateModifierContext):
        st = ctx.getText()
        if('inv' in st):
            self.currentModifier = 'inv'
        elif('pow' in st):
            self.currentModifier = 'pow'
            self.modExpression = ctx.powModifier().expression()
        elif("ctrl" in st):
            self.currentModifier = 'ctrl'
            self.modExpression = ctx.ctrlModifier().expression()
        elif("negctrl" in st):
            self.currentModifier = 'negctrl'
            self.modExpression = ctx.ctrlModifier().expression()
        else:
            raise NotImplementedError("Quantum Gate Modifier: {0} not implemented.".format(st))
        #print(self.currentModifier)
        return super().enterQuantumGateModifier(ctx)
