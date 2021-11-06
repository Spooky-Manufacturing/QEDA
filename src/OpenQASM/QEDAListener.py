import os
from antlr4 import Lexer, CommonTokenStream, ParseTreeWalker, FileStream
if __name__ is not None and "." in __name__:
    from .qasm3Parser import qasm3Parser
    from .qasm3Lexer import qasm3Lexer as Lexer
    from .qasm3Listener import qasm3Listener as Listener
else:
    from qasm3Parser import qasm3Parser
    from qasm3Lexer import qasm3Lexer as Lexer
    from qasm3Listener import qasm3Listener as Listener

from .QAST import *


def INCLUDE(file, path):
    f = path + '/' + file.getText().split('"')[1]
    input_stream = FileStream(fileName=f, encoding='utf-8')
    #open(f, 'r')
    # tokenize
    lexer = Lexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = qasm3Parser(stream)
    tree = parser.program()
    listener = QEDAListener()
    walker = ParseTreeWalker()
    walker.walk(listener, tree)
    return listener

class QEDAListener(Listener):
    def __init__(self, file=None):
        super()
        if file == None:
            self.file = os.getcwd()
        else:
            self.file = os.getcwd() + '/' + ''.join([x+'/' for x in file.split('/')[:-1]])
        self.HEADER = None
        self.BITS = []
        self.CONSTANTS = []
        self.QUBITS = []
        self.DECLARATIONS = []
        self.STMTS = []
        self.FUNCTIONS = []
        self.GLOBALS = []
        self.LOCALS = []
        self.file = "/" + self.file.strip("/")
        self.currentModifier = None
        self.modExpression = None

    def enterProgram(self, ctx: qasm3Parser.ProgramContext):
        self.HEADER=self.enterHeader(ctx.header())
        i=0
        while True:
            if ctx.globalStatement(i) is not None:
                x = self.enterGlobalStatement(ctx.globalStatement(i))
                if x!=None:
                    val = x.eval()
                    if val:
                        if val['type'] in ('subroutineDefinition', 'quantumGateDefinition'):
                            self.FUNCTIONS.append(val)
                        elif val['type'] in ('quantumDeclaration'):
                            self.QUBITS.append(val['decl'])
                    self.GLOBALS.append(x.eval())

            if ctx.statement(i) is not None:
                x = self.enterStatement(ctx.statement(i))
                if x!=None:
                    val = x.eval()
                   #print(val)
                    if val:
                        if val['type'] == 'classicalDeclaration':
                            # variable declaration
                            if 'decl' in val and val['decl']:
                                # Proper variable declared
                                if val['decl']['type'] == 'bit':
                                    # Bit declared
                                    self.BITS.append(val['decl'])
                                if val['decl']['type'] == 'constant':
                                    # Qubit declared
                                    self.CONSTANTS.append(val['decl'])
                            self.DECLARATIONS.append(val)
                        elif val['type'] in ('assignmentStatement',
                        'quantumInstruction', 'externOrSubroutineCall',
                        'timingStatement', 'aliasStatement', 'loopStatement',
                        'expressionStatement'):
                            print(val)
                            self.STMTS.append(val)
                        else:
                            print("{} not found".format(val['type']))
                    self.LOCALS.append(x.eval())
            else:
                break
            i+=1
        x = Program(self.HEADER, self.GLOBALS, self.LOCALS)
        return x

    # Enter a parse tree produced by qasm3Parser#header.
    def enterHeader(self, ctx:qasm3Parser.HeaderContext):
        pass

    # Enter a parse tree produced by qasm3Parser#version.
    def enterVersion(self, ctx:qasm3Parser.VersionContext):
        pass

    # Enter a parse tree produced by qasm3Parser#header.
    def enterInclude(self, ctx: qasm3Parser.IncludeContext):
        listener = INCLUDE(ctx.StringLiteral(), self.file)
        #self.HEADER += listener.HEADER
        self.BITS += listener.BITS
        self.CONSTANTS += listener.CONSTANTS
        self.QUBITS += listener.QUBITS
        self.DECLARATIONS += listener.DECLARATIONS
        self.STMTS += listener.STMTS
        self.FUNCTIONS += listener.FUNCTIONS
        self.GLOBALS += listener.GLOBALS
        self.LOCALS += listener.LOCALS

        # Enter a parse tree produced by qasm3Parser#ioIdentifier.
    def enterIoIdentifier(self, ctx:qasm3Parser.IoIdentifierContext):
        txt = ctx.getText()
        io = 'input'
        if 'input' in txt:
            io='input'
        elif 'output' in txt:
            io='output'
        return IoIdentifier(io)

    # Enter a parse tree produced by qasm3Parser#io.
    def enterIo(self, ctx:qasm3Parser.IoContext):
        io = self.enterIoIdentifier(ctx.ioIdentifier())
        ctype = self.enterClassicalType(ctx.classicalType())
        id = self.enterIdentifier(ctx.Identifier())
        return Io(io, ctype, id)

    # Enter a parse tree produced by qasm3Parser#globalStatement.
    def enterGlobalStatement(self, ctx:qasm3Parser.GlobalStatementContext):
        if ctx.subroutineDefinition()!=None:
            return self.enterSubroutineDefinition(ctx.subroutineDefinition())
        elif ctx.externDeclaration()!=None:
            return self.enterExternDeclaration(ctx.externDeclaration())
        elif ctx.quantumGateDefinition()!=None:
            return self.enterQuantumGateDefinition(ctx.quantumGateDefinition())
        elif ctx.calibration()!=None:
            return self.enterCalibration(ctx.calibration())
        elif ctx.quantumDeclarationStatement()!=None:
            return self.enterQuantumDeclarationStatement(ctx.quantumDeclarationStatement())
        elif ctx.pragma()!=None:
            return self.enterPragma(ctx.pragma())
        else:
            raise ValueError("Error in globalStatement with context\ntype: {}\nvalue: {}".format(type(ctx),ctx))

    # Enter a parse tree produced by qasm3Parser#statement.
    def enterStatement(self, ctx:qasm3Parser.StatementContext):
        if ctx.expressionStatement()!=None:
            return self.enterExpressionStatement(ctx.expressionStatement())
        elif ctx.assignmentStatement()!=None:
            return self.enterAssignmentStatement(ctx.assignmentStatement())
        elif ctx.classicalDeclarationStatement()!=None:
            return self.enterClassicalDeclarationStatement(ctx.classicalDeclarationStatement())
        elif ctx.branchingStatement()!=None:
            return self.enterBranchingStatement(ctx.branchingStatement())
        elif ctx.loopStatement()!=None:
            return self.enterLoopStatement(ctx.loopStatement())
        elif ctx.endStatement()!=None:
            return self.enterEndStatement(ctx.endStatement())
        elif ctx.aliasStatement()!=None:
            return self.enterAliasStatement(ctx.aliasStatement())
        elif ctx.quantumStatement()!=None:
            return self.enterQuantumStatement(ctx.quantumStatement())
        else:
            raise ValueError("Error in enterStatement with context\ntype: {}\nvalue: {}".format(type(ctx),ctx))

    # Enter a parse tree produced by qasm3Parser#quantumDeclarationStatement.
    def enterQuantumDeclarationStatement(self, ctx:qasm3Parser.QuantumDeclarationStatementContext):
        return QuantumDeclarationStatement(self.enterQuantumDeclaration(ctx.quantumDeclaration()))

    # Enter a parse tree produced by qasm3Parser#classicalDeclarationStatement.
    def enterClassicalDeclarationStatement(self, ctx:qasm3Parser.ClassicalDeclarationStatementContext):
        stmt = None
        if ctx.classicalDeclaration()!=None:
            stmt = self.enterClassicalDeclaration(ctx.classicalDeclaration())
        elif ctx.constantDeclaration()!=None:
            stmt = self.enterConstantDeclaration(ctx.constantDeclaration())
        else:
            return
        return ClassicalDeclarationStatement(stmt)

    # Enter a parse tree produced by qasm3Parser#classicalAssignment.
    def enterClassicalAssignment(self, ctx:qasm3Parser.ClassicalAssignmentContext):
        id = self.enterIdentifier(ctx.Identifier())
        operator = self.enterAssignmentOperator(ctx.assignmentOperator())
        exp=None
        if ctx.expression()!=None:
            exp = self.enterExpression(ctx.expression())
        des = None
        if ctx.designator()!=None:
            des = self.enterDesignator(ctx.designator())
        return ClassicalAssignment(id, des, operator, exp)

    # Enter a parse tree produced by qasm3Parser#assignmentStatement.
    def enterAssignmentStatement(self, ctx:qasm3Parser.AssignmentStatementContext):
        assign = None
        if ctx.classicalAssignment()!=None:
            assign=self.enterClassicalAssignment(ctx.classicalAssignment())
        elif ctx.quantumMeasurementAssignment()!=None:
            assign=self.enterQuantumMeasurementAssignment(ctx.quantumMeasurementAssignment())
        else:
            return
        return AssignmentStatement(assign)
        
    # Enter a parse tree produced by qasm3Parser#returnSignature.
    def enterReturnSignature(self, ctx:qasm3Parser.ReturnSignatureContext):
        if  ctx != None:
            ctype = self.enterClassicalType(ctx.classicalType())
            return ReturnSignature(ctype)
        else:
            return None

    def enterDesignator(self, ctx:qasm3Parser.DesignatorContext):
        if ctx.expression():
            exp = self.enterExpression(ctx.expression())
            des = Designator(exp)
            return des
        else:
            raise Exception("designator expression null")

    # Enter a parse tree produced by qasm3Parser#identifierList.
    def enterIdentifierList(self, ctx:qasm3Parser.IdentifierListContext):
        ids = []
        x=0
        while True:
            if ctx.Identifier(x) is not None:
                ids.append(self.enterIdentifier(ctx.Identifier(x)))
                x+=1
            else:
                break
        ilist = IdentifierList(idList=ids)
        return ilist

    # Enter a parse tree produced by qasm3Parser#quantumDeclaration.
    def enterQuantumDeclaration(self, ctx:qasm3Parser.QuantumDeclarationContext):
        qtype='qubit'
        id=self.enterIdentifier(ctx.Identifier())
        ids=None
        if 'qreg' in ctx.getText():
            qtype='qreg'
        if ctx.designator()!=None:
            ids=self.enterDesignator(ctx.designator())
        return QuantumDeclaration(id, ids, qtype)

    # Enter a parse tree produced by qasm3Parser#quantumArgument.
    def enterQuantumArgument(self, ctx:qasm3Parser.QuantumArgumentContext):
        qtype='qubit'
        id=self.enterIdentifier(ctx.Identifier())
        ids=None
        if 'qreg' in ctx.getText():
            qtype='qreg'
        if ctx.designator()!=None:
            ids=self.enterDesignator(ctx.designator())
        return QuantumArgument(id, ids, qtype)

    # Enter a parse tree produced by qasm3Parser#quantumArgumentList.
    def enterQuantumArgumentList(self, ctx:qasm3Parser.QuantumArgumentListContext):
        args = []
        if ctx.quantumArgument()!=None:
            i=0
            while True:
                if ctx.quantumArgument(i)!=None:
                    args.append(self.enterQuantumArgument(ctx.quantumArgument(i)))
                else:
                    break
                i+=1
        return QuantumArgumentList(args)

    # Enter a parse tree produced by qasm3Parser#bitType.
    def enterBitType(self, ctx:qasm3Parser.BitTypeContext):
        ctype = ctx.getText()
        return ctype


    # Enter a parse tree produced by qasm3Parser#singleDesignatorType.
    def enterSingleDesignatorType(self, ctx:qasm3Parser.SingleDesignatorTypeContext):
        ctype = ctx.getText()
        return ctype

    # Enter a parse tree produced by qasm3Parser#noDesignatorType.
    def enterNoDesignatorType(self, ctx:qasm3Parser.NoDesignatorTypeContext):
        ctype = 'bool'
        if ctx.timingType():
            ctype = 'timingType'
        return ctype

    # Enter a parse tree produced by qasm3Parser#classicalType.
    def enterClassicalType(self, ctx:qasm3Parser.ClassicalTypeContext):
        ctype = None
        designator = None
        if ctx.bitType():
            ctype = self.enterBitType(ctx.bitType())
        elif ctx.numericType():
            ctype = self.enterNumericType(ctx.numericType())
        elif ctx.noDesignatorType():
            ctype = self.enterNoDesignatorType(ctx.noDesignatorType())
        elif ctx.singleDesignatorType():
            ctype = self.enterSingleDesignatorType(ctx.singleDesignatorType())
        if ctx.designator():
            designator = self.enterDesignator(ctx.designator())
        a = ClassicalType(ctype, designator)
        return a

    # Enter a parse tree produced by qasm3Parser#numericType.
    def enterNumericType(self, ctx:qasm3Parser.NumericTypeContext):
        num = None
        stype = self.enterSingleDesignatorType(ctx.singleDesignatorType())
        des = self.enterDesignator(ctx.designator())
        num = NumericType(singleDesignatorType=stype, designator=des)
        return num

    # Enter a parse tree produced by qasm3Parser#constantDeclaration.
    def enterConstantDeclaration(self, ctx:qasm3Parser.ConstantDeclarationContext):
        id = self.enterIdentifier(ctx.Identifier())
        eqexp = self.enterEqualsExpression(ctx.equalsExpression())
        return ConstantDeclaration(id, eqexp)

    # Enter a parse tree produced by qasm3Parser#singleDesignatorDeclaration.
    def enterSingleDesignatorDeclaration(self, ctx:qasm3Parser.SingleDesignatorDeclarationContext):
        des = self.enterDesignator(ctx.designator())
        sdtype = self.enterSingleDesignatorType(ctx.singleDesignatorType())
        id = self.enterIdentifier(ctx.Identifier())
        exp = self.enterEqualsExpression(ctx.equalsExpression())
        sds = SingleDesignatorDeclaration(des, id, exp)
        return sds
    
    
    # Enter a parse tree produced by qasm3Parser#noDesignatorDeclaration.
    def enterNoDesignatorDeclaration(self, ctx:qasm3Parser.NoDesignatorDeclarationContext):
        des = self.enterNoDesignatorType(ctx.noDesignatorType())
        id = self.enterIdentifier(ctx.Identifier())
        exp = self.enterEqualsExpression(ctx.equalsExpression())
        nd = NoDesignatorDeclaration(des, id, exp)
        return nd

    # Enter a parse tree produced by qasm3Parser#bitDeclaration.
    def enterBitDeclaration(self, ctx:qasm3Parser.BitDeclarationContext):
        txt = ctx.getText()
        ttype = None
        equ = None
        des = None
        if 'bit' in txt:
            # create a bit
            ttype='bit'
        elif 'creg' in txt:
            # create creg
            ttype='creg'
        id = self.enterIdentifier(ctx.Identifier())
        if ctx.designator():
            des = self.enterDesignator(ctx.designator())
        if ctx.equalsExpression():
            equ = self.enterEqualsExpression(ctx.equalsExpression())
        bitdecl = BitDeclaration(id, des, equ, ttype=ttype)
        bitdecl.eval()
        return bitdecl

    # Enter a parse tree produced by qasm3Parser#complexDeclaration.
    def enterComplexDeclaration(self, ctx:qasm3Parser.ComplexDeclarationContext):
        id=None
        exp=[]
        nType=None
        if ctx.Identifier()!=None:
            id=self.enterIdentifier(ctx.Identifier())
        if ctx.equalsExpression()!=None:
            i=0
            while True:
                if ctx.equalsExpression(i)!=None:
                    exp.append(self.enterEqualsExpression(ctx.equalsExpression(i)))
                else:
                    break
                i+=1
        if ctx.numericType()!=None:
            nType=self.enterNumericType(ctx.numericType())
        return ComplexDeclaration(id,nType,exp)

    # Enter a parse tree produced by qasm3Parser#classicalDeclaration.
    def enterClassicalDeclaration(self, ctx:qasm3Parser.ClassicalDeclarationContext):
        if ctx.singleDesignatorDeclaration()!=None:
            return self.enterSingleDesignatorDeclaration(ctx.singleDesignatorDeclaration())
        if ctx.noDesignatorDeclaration()!=None:
            return self.enterNoDesignatorDeclaration(ctx.noDesignatorDeclaration())
        if ctx.bitDeclaration()!=None:
            return self.enterBitDeclaration(ctx.bitDeclaration())
        if ctx.complexDeclaration()!=None:
            return self.enterComplexDeclaration(ctx.complexDeclaration())

    # Enter a parse tree produced by qasm3Parser#classicalTypeList.
    def enterClassicalTypeList(self, ctx:qasm3Parser.ClassicalTypeListContext):
        x = []
        if ctx!=None and ctx.classicalType()!=None:
            i=0
            while True:
                if ctx.classicalType(i)!=None:
                    x.append(self.enterClassicalType(ctx.classicalType(i)))
                else:
                    break
                i+=1
        return x


    # Enter a parse tree produced by qasm3Parser#classicalArgument.
    def enterClassicalArgument(self, ctx:qasm3Parser.ClassicalArgumentContext):
        txt = ctx.getText()
        ctxType = None
        dType=None
        des=None
        id=None
        if 'creg' in txt:
            ctxType='creg'
        elif 'bit' in txt:
            ctxType='bit'
        elif 'complex'in txt:
            ctxType='complex'

        if ctx.singleDesignatorType()!=None:
            dType=self.enterSingleDesignatorType(ctx.singleDesignatorType())
        if ctx.designator()!=None:
            des=self.enterDesignator(ctx.designator())
        if ctx.Identifier()!=None:
            id=self.enterIdentifier(ctx.Identifier())
        return ClassicalArgument(dType, des, id, ctxType)

    # Enter a parse tree produced by qasm3Parser#classicalArgumentList.
    def enterClassicalArgumentList(self, ctx:qasm3Parser.ClassicalArgumentListContext):
        x = []
        if ctx.classicalArgument()!=None:
            i=0
            while True:
                if ctx.classicalArgument(i)!=None:
                    x.append(self.enterClassicalArgument(ctx.classicalArgument(i)))
                else:
                    break
                i+=1
        return ClassicalArgumentList(x)

    # Enter a parse tree produced by qasm3Parser#anyTypeArgument.
    def enterAnyTypeArgument(self, ctx:qasm3Parser.AnyTypeArgumentContext):
        arg = None
        if ctx.classicalArgument()!=None:
            arg=self.enterClassicalArgument(ctx.classicalArgument())
        elif ctx.quantumArgument()!=None:
            arg=self.enterQuantumArgument(ctx.quantumArgument())
        return AnyTypeArgument(arg)

    # Enter a parse tree produced by qasm3Parser#anyTypeArgumentList.
    def enterAnyTypeArgumentList(self, ctx:qasm3Parser.AnyTypeArgumentListContext):
        x=[]
        if ctx.anyTypeArgument()!=None:
            i=0
            while True:
                if ctx.anyTypeArgument(i)!=None:
                    x.append(self.enterAnyTypeArgument(ctx.anyTypeArgument(i)))
                else:
                    break
                i+=1
        return AnyTypeArgumentList(x)
    
    # Enter a parse tree produced by qasm3Parser#aliasStatement.
    def enterAliasStatement(self, ctx:qasm3Parser.AliasStatementContext):
        id=None
        value=None
        if ctx.Identifier()!=None:
            id=self.enterIdentifier(ctx.Identifier())
        if ctx.indexIdentifier()!=None:
            value=self.enterIndexIdentifier(ctx.indexIdentifier())
        return AliasStatement(id, value)
    
    # Enter a parse tree produced by qasm3Parser#indexIdentifier.
    def enterIndexIdentifier(self, ctx:qasm3Parser.IndexIdentifierContext):
        id=None
        indexes=[]
        exp=[]
        rangeDef=None
        if ctx.Identifier()!=None:
            id=self.enterIdentifier(ctx.Identifier())
        if ctx.indexIdentifier()!=None:
            i=0
            while True:
                if ctx.indexIdentifier(i)!=None:
                    indexes.append(self.enterIndexIdentifier(ctx.indexIdentifier(i)))
                else:
                    break
                i+=1
        if ctx.expressionList()!=None:
            exp=self.enterExpressionList(ctx.expressionList())
        if ctx.rangeDefinition()!=None:
            rangeDef=self.enterRangeDefinition(ctx.rangeDefinition())
        return IndexIdentifier(id, exp, indexes, rangeDef)
    
    # Enter a parse tree produced by qasm3Parser#indexIdentifierList.
    def enterIndexIdentifierList(self, ctx:qasm3Parser.IndexIdentifierListContext):
        ids=[]
        if ctx.indexIdentifier()!=None:
            if len(ctx.indexIdentifier()) > 0:
                i=0
                while True:
                    if ctx.indexIdentifier(i):
                        ids.append(self.enterIndexIdentifier(ctx.indexIdentifier(i)))
                    else:
                        break
                    i+=1
            else:
                ids.append(self.enterIndexIdentifier(ctx.indexIdentifier()))
        return IndexIdentifierList(ids)

    # Enter a parse tree produced by qasm3Parser#rangeDefinition.
    def enterRangeDefinition(self, ctx:qasm3Parser.RangeDefinitionContext):
        exp1=None
        exp2=None
        exp3=None
        if ctx.expression()!=None:
            if ctx.expression(0)!=None:
                exp1=self.enterExpression(ctx.expression(0))
            if ctx.expression(1)!=None:
                exp2=self.enterExpression(ctx.expression(1))
            if ctx.expression(2)!=None:
                exp3=self.enterExpression(ctx.expression(2))
        return RangeDefinition(exp1, exp2, exp3)
    
    # Enter a parse tree produced by qasm3Parser#quantumGateDefinition.
    def enterQuantumGateDefinition(self, ctx: qasm3Parser.QuantumGateDefinitionContext):
        signature = self.enterQuantumGateSignature(ctx.quantumGateSignature())
        block = self.enterQuantumBlock(ctx.quantumBlock())
        gate = QuantumGateDefinition(signature, block)
        return gate

    # Enter a parse tree produced by qasm3Parser#quantumGateSignature.
    def enterQuantumGateSignature(self, ctx:qasm3Parser.QuantumGateSignatureContext):
        name = self.enterQuantumGateName(ctx.quantumGateName())
        params = None
        ids = None
        if ctx.identifierList(0):
            params = self.enterIdentifierList(ctx.identifierList(0))
        if ctx.identifierList(1):
            ids = self.enterIdentifierList(ctx.identifierList(1))
        qgs = QuantumGateSignature(gateName=name, identifiers=ids, parameters=params)
        if qgs is not None and qgs.eval() is not None:
            return qgs
        return
    
    # Enter a parse tree produced by qasm3Parser#quantumGateName.
    def enterQuantumGateName(self, ctx:qasm3Parser.QuantumGateNameContext):
        return QuantumGateName(ctx.getText())

    # Enter a parse tree produced by qasm3Parser#quantumBlock.
    def enterQuantumBlock(self, ctx:qasm3Parser.QuantumBlockContext):
        stmts = []
        loops = []
        if len(ctx.quantumStatement()) > 0:
            i=0
            while True:
                if ctx.quantumStatement(i)!=None:
                    stmts.append(self.enterQuantumStatement(ctx.quantumStatement(i)))
                else:
                    break
                i+=1
        if len(ctx.quantumLoop()) > 0:
            i=0
            while True:
                if ctx.quantumLoop(i)!=None:
                    loops.append(self.enterQuantumLoop(ctx.quantumLoop(i)))
                else:
                    break
                i+=1
        block = QuantumBlock(statements=stmts, loops=loops)
        if block is not None and block.eval() is not None:
            return block
        return
        
    # Enter a parse tree produced by qasm3Parser#quantumLoop.
    def enterQuantumLoop(self, ctx:qasm3Parser.QuantumLoopContext):
        sig = self.enterLoopSignature(ctx.loopSignature())
        block = self.enterQuantumLoopBlock(ctx.quantumLoopBlock())
        return QuantumLoop(sig, block)

    # Enter a parse tree produced by qasm3Parser#quantumLoopBlock.
    def enterQuantumLoopBlock(self, ctx:qasm3Parser.quantumLoopBlock):
        stmt = []
        i=0
        while True:
            if ctx.quantumStatement(i) is not None:
                stmt.append(self.enterQuantumStatement(ctx.quantumStatement(i)))
                i+=1
            else:
                break
        return QuantumLoopBlock(statements=stmt)

    # Enter a parse tree produced by qasm3Parser#quantumStatement.
    def enterQuantumStatement(self, ctx:qasm3Parser.quantumStatement):
        ins = None
        if ctx.quantumInstruction() is not None:
            ins = self.enterQuantumInstruction(ctx.quantumInstruction())
        tim = None
        if ctx.timingStatement() is not None:
            tim = self.enterTimingStatement(ctx.timingStatement())
        qs = None
        if ins is not None:
            qs = QuantumStatement(quantumInstruction=ins)
        elif tim is not None:
            qs = QuantumStatement(timingStatement=tim)
        else:
            return
        return qs

    # Enter a parse tree produced by qasm3Parser#quantumInstruction.
    def enterQuantumInstruction(self, ctx:qasm3Parser.quantumInstruction):
        ins = None
        if ctx.quantumGateCall() is not None:
            ins = self.enterQuantumGateCall(ctx.quantumGateCall())
        elif ctx.quantumPhase() is not None:
            ins = self.enterQuantumPhase(ctx.quantumPhase())
        elif ctx.quantumMeasurement() is not None:
            ins = self.enterQuantumMeasurement(ctx.quantumMeasurement())
        elif ctx.quantumReset() is not None:
            ins = self.enterQuantumReset(ctx.quantumReset())
        elif ctx.quantumBarrier() is not None:
            ins = self.enterQuantumBarrier(ctx.quantumBarrier())
        else:
            return
        return QuantumInstruction(ins)
   
    # Enter a parse tree produced by qasm3Parser#quantumPhase.
    def enterQuantumPhase(self, ctx:qasm3Parser.quantumPhase):
        mods = []
        exp = None
        id_list = None
        if ctx.quantumGateModifier() is not None:
            i = 0
            while True:
                if ctx.quantumGateModifier(i) is not None:
                    mods.append(self.enterQuantumGateModifier(ctx.quantumGateModifier(i)))
                else:
                    break
                i+=1 
        exp = self.enterExpression(ctx.expression())
        id_list=None
        if ctx.indexIdentifierList()!=None:
            id_list = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        qp = QuantumPhase(exp, id_list, modifiers=mods)
        if qp is not None and qp.eval() is not None:
            return qp
        return

    # Enter a parse tree produced by qasm3Parser#quantumReset
    def enterQuantumReset(self, ctx:qasm3Parser.quantumReset):
        id_list = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        return QuantumReset(id_list)

    # Enter a parse tree produced by qasm3Parser#quantumMeasurement
    def enterQuantumMeasurement(self, ctx:qasm3Parser.quantumMeasurement):
        id = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        return QuantumMeasurement(id)

    # Enter a parse tree produced by qasm3Parser#quantumMeasurementAssignment
    def enterQuantumMeasurementAssignment(self, ctx:qasm3Parser.quantumMeasurementAssignment):
        qmeas = self.enterQuantumMeasurement(ctx.quantumMeasurement())
        id=None
        if ctx.indexIdentifierList()!=None:
            id = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        return QuantumMeasurementAssignment(qmeas, id)

    # Enter a parse tree produced by qasm3Parser#quantumBarrier
    def enterQuantumBarrier(self, ctx:qasm3Parser.quantumBarrier):
        idl = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        return QuantumBarrier(idl)

    # Enter a parse tree produced by qasm3Parser#quantumGateModifier
    def enterQuantumGateModifier(self, ctx:qasm3Parser.quantumGateModifier):
        mod = None
        if ctx.powModifier() is not None:
            mod = self.enterPowModifier(ctx.powModifier())
        if ctx.ctrlModifier() is not None:
            mod = self.enterCtrlModifier(ctx.ctrlModifier())
        return QuantumGateModifier(mod)

    # Enter a parse tree produced by qasm3Parser#PowModifier
    def enterPowModifier(self, ctx:qasm3Parser.PowModifierContext):
        exp = self.enterExpression(ctx.expression())
        return PowModifier(exp)
    
    # Enter a parse tree produced by qasm3Parser#CtrlModifier
    def enterCtrlModifier(self, ctx:qasm3Parser.CtrlModifierContext):
        txt = ctx.getText()
        neg = False
        exp = None
        if 'neg' in txt:
            neg=True
        if ctx.expression() is not None:
            exp = self.enterExpression(ctx.expression())
        return CtrlModifier(exp, neg)
    
    # Enter a parse tree produced by qasm3Parser#quantumGateCall
    def enterQuantumGateCall(self, ctx:qasm3Parser.quantumGateCall):
        name = self.enterQuantumGateName(ctx.quantumGateName())
        ids = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        exp = None
        mod = []
        if ctx.expressionList() is not None:
            exp = self.enterExpressionList(ctx.expressionList())
        if len(ctx.quantumGateModifier()) > 0:
            i=0
            while True:
                if ctx.quantumGateModifier(i) is not None:
                    mod.append(self.enterQuantumGateModifier(ctx.quantumGateModifier(i)))
                else:
                    break
                i+=1
        return QuantumGateCall(name, ids, expressionList=exp, quantumGateModifier=mod)

    # Enter a parse tree produced by qasm3Parser#expressionStatement.
    def enterExpressionStatement(self, ctx:qasm3Parser.ExpressionStatementContext):
        x=self.enterExpression(ctx.expression())
        return ExpressionStatement(x)

    def enterIdentifier(self, ctx):
        Ident = Identifier(ctx)
        return Ident


    # Enter a parse tree produced by qasm3Parser#expression.
    def enterExpression(self, ctx:qasm3Parser.ExpressionContext):
        exp1 = None
        if ctx.unaryExpression():
            return self.enterUnaryExpression(ctx.unaryExpression())
        elif ctx.expression():
            exp1 = self.enterExpression(ctx.expression())
            andxp = None
            if ctx.logicalAndExpression():
                andxp = self.enterLogicalAndExpression(ctx.logicalAndExpression())
            x = Expression(exp1, andxp)
            return x
        elif ctx.logicalAndExpression():
            a = self.enterLogicalAndExpression(ctx.logicalAndExpression())
            return a
        elif ctx.expressionTerminator()!=None:
            return self.enterExpressionTerminator(ctx.expressionTerminator())

    # Enter a parse tree produced by qasm3Parser#logicalAndExpression.
    def enterLogicalAndExpression(self, ctx:qasm3Parser.LogicalAndExpressionContext):
        log = None
        exp1 = None
        exp2 = None
        operator = '&&'
        if ctx != None:
            if ctx.logicalAndExpression:
                exp1 = self.enterLogicalAndExpression(ctx.logicalAndExpression())
                exp2 = self.enterBitOrExpression(ctx.bitOrExpression())
                if exp1 == None:
                    exp1 = exp2
                    exp2 = None
            elif ctx.bitOrExpression():
                exp1 = self.enterBitOrExpression(ctx.bitOrExpression())
            log = LogicalAndExpression(expression1=exp1, expression2=exp2, operator=operator)
            return log

    # Enter a parse tree produced by qasm3Parser#bitOrExpression.
    def enterBitOrExpression(self, ctx:qasm3Parser.BitOrExpressionContext):
        bit = None
        exp1 = None
        exp2 = None
        operator = '|'
        if ctx != None:
            if ctx.bitOrExpression():
                exp1 = self.enterBitOrExpression(ctx.bitOrExpression())
                exp2 = self.enterXOrExpression(ctx.xOrExpression())
            elif ctx.xOrExpression():
                exp1 = self.enterXOrExpression(ctx.xOrExpression())
            bit = BitOrExpression(expression1=exp1, expression2=exp2, operator=operator)
            return bit

    # Enter a parse tree produced by qasm3Parser#xOrExpression.
    def enterXOrExpression(self, ctx:qasm3Parser.XOrExpressionContext):
        xor = None
        exp1 = None
        exp2 = None
        operator = '^'
        if ctx != None:
            if ctx.xOrExpression():
                exp1 = self.enterXOrExpression(ctx.xOrExpression())
                exp2 = self.enterBitAndExpression(ctx.bitAndExpression())
            elif ctx.bitAndExpression():
                exp1 = self.enterBitAndExpression(ctx.bitAndExpression())
            xor = XorExpression(expression1=exp1, expression2=exp2, operator=operator)
            return xor
        

    # Enter a parse tree produced by qasm3Parser#bitAndExpression.
    def enterBitAndExpression(self, ctx:qasm3Parser.BitAndExpressionContext):
        bit = None
        exp1 = None
        exp2 = None
        operator = '&'
        if ctx != None:
            if ctx.bitAndExpression():
                exp1 = self.enterBitAndExpression(ctx.bitAndExpression())
                exp2 = self.enterEqualityExpression(ctx.equalityExpression())
            elif ctx.equalityExpression():
                exp1 = self.enterEqualityExpression(ctx.equalityExpression())
            bit = BitAndExpression(expression1=exp1, expression2=exp2, operator=operator)
            return bit

    # Enter a parse tree produced by qasm3Parser#equalityExpression.
    def enterEqualityExpression(self, ctx:qasm3Parser.EqualityExpressionContext):
        equ = None
        exp1 = None
        exp2 = None
        operator = None
        if ctx != None:
            if ctx.equalityExpression():
                exp1 = self.enterEqualityExpression(ctx.equalityExpression())
                exp2 = self.enterComparisonExpression(ctx.comparisonExpression())
                txt = ctx.getText()
                if "!=" in txt:
                    operator = "!="
                elif "==" in txt:
                    operator = "=="
            elif ctx.comparisonExpression():
                exp1 = self.enterComparisonExpression(ctx.comparisonExpression())
            equ = EqualityExpression(expression1=exp1, expression2=exp2, operator=operator)
            return equ

    # Enter a parse tree produced by qasm3Parser#comparisonExpression.
    def enterComparisonExpression(self, ctx:qasm3Parser.ComparisonExpressionContext):
        comp = None
        exp1 = None
        exp2 = None
        operator = None
        if ctx != None:
            if ctx.comparisonExpression():
                exp1 = self.enterComparisonExpression(ctx.comparisonExpression())
                exp2 = self.enterBitShiftExpression(ctx.bitShiftExpression())
                txt = ctx.getText()
                if '<=' in txt:
                    operator ='<='
                elif '>=' in txt:
                    operator ='>='
                elif '<' in txt:
                    operator ='<'
                elif '>' in txt:
                    operator ='>'
            elif ctx.bitShiftExpression():
                exp1 = self.enterBitShiftExpression(ctx.bitShiftExpression())
            comp = ComparisonExpression(expression1=exp1, expression2=exp2, operator=operator)
            return comp

    # Enter a parse tree produced by qasm3Parser#bitShiftExpression.
    def enterBitShiftExpression(self, ctx:qasm3Parser.BitShiftExpressionContext):
        bit = None
        exp1 = None
        exp2 = None
        operator = None
        if ctx != None:
            if ctx.bitShiftExpression():
                exp1 = self.enterBitShiftExpression(ctx.bitShiftExpression())
                exp2 = self.enterAdditiveExpression(ctx.additiveExpression())
            else:
                exp1 = self.enterAdditiveExpression(ctx.additiveExpression())

            if '<<' in ctx.getText():
                operator = '<<'
            else: 
                operator = '>>'
            bit = BitShiftExpression(expression1=exp1, expression2=exp2, operator=operator)
            return bit
        
    # Enter a parse tree produced by qasm3Parser#additiveExpression.
    def enterAdditiveExpression(self, ctx:qasm3Parser.AdditiveExpressionContext):
        add = None
        exp1 = None
        exp2 = None
        operator = None
        if ctx != None:
            if ctx.additiveExpression():
                exp1 = self.enterAdditiveExpression(ctx.additiveExpression())
                exp2 = self.enterMultiplicativeExpression(ctx.multiplicativeExpression())
                if '+' in ctx.getText():
                    operator = "+"
                else:
                    operator = "-"
            else:
                exp1 = self.enterMultiplicativeExpression(ctx.multiplicativeExpression())
            add = AdditiveExpression(expression1=exp1, expression2=exp2, operator=operator)
            return add

    # Enter a parse tree produced by qasm3Parser#multiplicativeExpression.
    def enterMultiplicativeExpression(self, ctx:qasm3Parser.MultiplicativeExpressionContext):
        mul = None
        exp1 = None
        exp2 = None
        operator =None
        if ctx != None:
            if ctx.powerExpression():
                exp1 = self.enterPowerExpression(ctx.powerExpression())
            elif ctx.unaryExpression():
                exp1 = self.enterUnaryExpression(ctx.unaryExpression())

            if ctx.multiplicativeExpression():
                exp2 = exp1
                exp1 = self.enterMultiplicativeExpression(ctx.multiplicativeExpression())

            if ctx.MUL():
                operator ="*"
            elif ctx.DIV():
                operator = "/"
            elif ctx.MOD:
                operator ="%"
            mul = MultiplicativeExpression(expression1=exp1, expression2=exp2, operator=operator)
            return mul

    # Enter a parse tree produced by qasm3Parser#unaryExpression.
    def enterUnaryExpression(self, ctx:qasm3Parser.UnaryExpressionContext):
        exp1 = self.enterPowerExpression(ctx.powerExpression())
        unary = UnaryExpression(exp1, operator=ctx.unaryOperator().getText())
        return unary

    # Enter a parse tree produced by qasm3Parser#powerExpression.
    def enterPowerExpression(self, ctx:qasm3Parser.PowerExpressionContext):
        pwr = None
        exp1 = self.enterExpressionTerminator(ctx.expressionTerminator())
        exp2 = None
        if ctx != None:
            if ctx.powerExpression():
                exp2 = self.enterPowerExpression(ctx.powerExpression())
            pwr = PowerExpression(exp1, exp2)
            return pwr

    # Enter a parse tree produced by qasm3Parser#expressionTerminator.
    def enterExpressionTerminator(self, ctx:qasm3Parser.ExpressionTerminatorContext):
        term = None
        constant = None
        integer = None
        realn = None
        imagn = None
        boolLit = None
        ident = None
        stringLit = None
        builtIn = None
        extern = None
        timingId = None
        expression = None
        terminator = None
        if ctx.Constant():
            constant = Constant(ctx.Constant())
        if ctx.Integer:
            integer = Integer(ctx.Integer())
        if ctx.RealNumber():
            realn = RealNumber(ctx.RealNumber())
        if ctx.ImagNumber():
            imagn = ImagNumber(ctx.ImagNumber())
        if ctx.booleanLiteral():
            boolLit = BooleanLiteral(ctx.booleanLiteral())
        if ctx.Identifier():
            ident = self.enterIdentifier(ctx.Identifier())
        if ctx.StringLiteral():
            stringLit = ctx.StringLiteral()
        if ctx.builtInCall():
            builtIn = self.enterBuiltInCall(ctx.builtInCall())
        if ctx.externOrSubroutineCall():
            extern = self.enterExternOrSubroutineCall(ctx.externOrSubroutineCall())
        if ctx.timingIdentifier():
            timingId = self.enterTimingIdentifier(ctx.timingIdentifier())
        if ctx.expression():
            expression = self.enterExpression(ctx.expression())
        if ctx.expressionTerminator():
            terminator = self.enterExpressionTerminator(ctx.expressionTerminator())
        term = ExpressionTerminator(constant, integer, realn, imagn, boolLit, ident, stringLit,
        builtIn, extern, timingId, expression, terminator)
        return term

    # Enter a parse tree produced by qasm3Parser#booleanLiteral.
    def enterBooleanLiteral(self, ctx:qasm3Parser.BooleanLiteralContext):
        pass

    # Enter a parse tree produced by qasm3Parser#builtInCall.
    def enterBuiltInCall(self, ctx:qasm3Parser.BuiltInCallContext):
        call = None
        operator = None
        exp_list = []
        if ctx.builtInMath():
            operator = self.enterBuiltInMath(ctx.builtInMath())
        elif ctx.castOperator():
            operator = self.enterCastOperator(ctx.castOperator())
        else:
            return
        exp_list = ctx.expressionList()
        call = BuiltInCall(operation=operator, expressionList=exp_list)
        if call is not None and call.eval() is not None:
            return call
        else:
            return

    # Enter a parse tree produced by qasm3Parser#builtInMath.
    def enterBuiltInMath(self, ctx:qasm3Parser.BuiltInMathContext):
        return ctx.getText()

    # Enter a parse tree produced by qasm3Parser#castOperator.
    def enterCastOperator(self, ctx:qasm3Parser.CastOperatorContext):
        operator = CastOperator(ctx.getText())

    # Enter a parse tree produced by qasm3Parser#expressionList.
    def enterExpressionList(self, ctx:qasm3Parser.ExpressionListContext):
        exp = []
        i=0
        while True:
            if ctx:
                if ctx.expression(i):
                    exp.append(self.enterExpression(ctx.expression(i)))
                    i+=1
                else:
                    break
            else:
                break
        return ExpressionList(exp)

    # Enter a parse tree produced by qasm3Parser#equalsExpression.
    def enterEqualsExpression(self, ctx:qasm3Parser.EqualsExpressionContext):
        if ctx is not None:
            exp = self.enterExpression(ctx.expression())
            return EqualsExpression(exp)
        else:
            return

    # Enter a parse tree produced by qasm3Parser#assignmentOperator.
    def enterAssignmentOperator(self, ctx:qasm3Parser.AssignmentOperatorContext):
        operator = ctx.getText()
        if operator == None:
            operator = "=="
        return AssignmentOperator(operator)

    # Enter a parse tree produced by qasm3Parser#setDeclaration.
    def enterSetDeclaration(self, ctx:qasm3Parser.SetDeclarationContext):
        id=None
        exp=None
        range=None
        if ctx.Identifier()!=None:
            id = self.enterIdentifier(ctx.Identifier())
        if ctx.expressionList()!=None:
            exp = self.enterExpressionList(ctx.expressionList())
        if ctx.rangeDefinition():
            range = self.enterRangeDefinition(ctx.rangeDefinition())
        return SetDeclaration(id, exp, range)

    # Enter a parse tree produced by qasm3Parser#programBlock.
    def enterProgramBlock(self, ctx:qasm3Parser.ProgramBlockContext):
        i=0
        stmts = []
        while True:
            if ctx.statement(i) is not None:
                stmts.append(self.enterStatement(ctx.statement(i)))
            else:
                break
            i+=1
        i=0
        while True:
            if ctx.controlDirective(i) is not None:
                stmts.append(self.enterControlDirective(ctx.controlDirective(i)))
            else:
                break
            i+=1
        return ProgramBlock(stmts)

    # Enter a parse tree produced by qasm3Parser#branchingStatement.
    def enterBranchingStatement(self, ctx:qasm3Parser.BranchingStatementContext):
        exp = self.enterExpression(ctx.expression())
        block1 = self.enterProgramBlock(ctx.programBlock(0))
        block2 = None
        if ctx.programBlock(1) is not None:
            block2 = self.enterProgramBlock(ctx.programBlock(1))
        return BranchingStatement(exp, block1, block2)

    # Enter a parse tree produced by qasm3Parser#loopSignature.
    def enterLoopSignature(self, ctx:qasm3Parser.LoopSignatureContext):
        id = ctx.Identifier()
        exp = None
        decl = None
        operator = None
        if ctx.expression():
            # while loop
            exp = self.enterExpression(ctx.expression())
            operator ='while'
        else:
            # for loop
            decl = self.enterSetDeclaration(ctx.setDeclaration())
            operator ='for'
        return LoopSignature(operator, id, exp, decl)

    # Enter a parse tree produced by qasm3Parser#loopStatement.
    def enterLoopStatement(self, ctx:qasm3Parser.LoopStatementContext):
        sig = self.enterLoopSignature(ctx.loopSignature())
        block = self.enterProgramBlock(ctx.programBlock())
        return LoopStatement(sig, block)

    # Enter a parse tree produced by qasm3Parser#endStatement.
    def enterEndStatement(self, ctx:qasm3Parser.EndStatementContext):
        return EndStatement()

    # Enter a parse tree produced by qasm3Parser#returnStatement.
    def enterReturnStatement(self, ctx:qasm3Parser.ReturnStatementContext):
        rval=None
        if ctx.expression() is not None:
            rval = self.enterExpression(ctx.expression())
        elif ctx.quantumMeasurement() is not None:
            rval = self.enterQuantumMeasurement(ctx.quantumMeasurement())
        return ReturnStatement(rval)

    # Enter a parse tree produced by qasm3Parser#controlDirective.
    def enterControlDirective(self, ctx:qasm3Parser.ControlDirectiveContext):
        txt = ctx.getText()
        ctrl = None
        if 'break' in txt:
            ctrl = 'break'
        elif 'continue' in txt:
            ctrl = 'continue'
        elif ctx.endStatement() is not None:
            ctrl = self.enterEndStatement(ctx.endStatement())
        elif ctx.returnStatement() is not None:
            ctrl = self.enterReturnStatement(ctx.returnStatement())
        return ControlDirective(ctrl)

    # Enter a parse tree produced by qasm3Parser#externDeclaration
    def enterExternDeclaration(self, ctx:qasm3Parser.ExternDeclarationContext):
        id = self.enterIdentifier(ctx.Identifier())
        clist = None
        rsig = None
        if ctx.classicalTypeList() != None:
            clist = self.enterClassicalTypeList(ctx.classicalTypeList())
        if ctx.returnSignature() != None:
            rsig = self.enterReturnSignature(ctx.returnSignature())
        return ExternDeclaration(id, clist, rsig)

    # Enter a parse tree produced by qasm3Parser#ExternOrSubroutineCall
    def enterExternOrSubroutineCall(self, ctx:qasm3Parser.ExternOrSubroutineCallContext):
        id = self.enterIdentifier(ctx.Identifier())
        exp_list=None
        exp_list = self.enterExpressionList(ctx.expressionList())
        x = ExternOrSubroutineCall(id, exp_list)
        return x

    # Enter a parse tree produced by qasm3Parser#subroutineDefinition
    def enterSubroutineDefinition(self, ctx:qasm3Parser.SubroutineDefinitionContext):
        id = None
        a_list = None
        return_signature = self.enterReturnSignature(ctx.returnSignature())
        s_block = None
        if ctx.Identifier() is not None:
            id = self.enterIdentifier(ctx.Identifier())
        if ctx.anyTypeArgumentList() is not None:
            a_list = self.enterAnyTypeArgumentList(ctx.anyTypeArgumentList())
        if ctx.subroutineBlock() is not None:
            s_block = self.enterSubroutineBlock(ctx.subroutineBlock())

        return SubroutineDefinition(id, a_list, return_signature, s_block)

    # Enter a parse tree produced by qasm3Parser#subroutineBlock
    def enterSubroutineBlock(self, ctx:qasm3Parser.SubroutineBlockContext):
        stmt = []
        return_state = None
        i=0
        while True:
            if ctx.statement(i) is not None:
                stmt.append(self.enterStatement(ctx.statement(i)))
            else:
                break
            i+=1
        if ctx.returnStatement() is not None:
            return_state = self.enterReturnStatement(ctx.returnStatement())
        return SubroutineBlock(stmt, return_state)

    # Enter a parse tree produced by qasm3Parser#pragma
    def enterPragma(self, ctx:qasm3Parser.PragmaContext):
        stmt = self.enterStatement(ctx.statement())
        return Pragma(stmt)

    # Enter a parse tree produced by qasm3Parser#timingType
    def enterTimingType(self, ctx:qasm3Parser.TimingTypeContext):
        ttype = ctx.getText()
        tt = TimingType()
        tt.ttype=ttype
        return tt
    # Enter a parse tree produced by qasm3Parser#timingBox
    def enterTimingBox(self, ctx:qasm3Parser.TimingBoxContext):
        des=[]
        if ctx.designator():
            i=0
            while True:
                if ctx.designator(i) is not None:
                    des.append(self.enterDesignator(ctx.designator(i)))
                else:
                    break
            i+=1

        qblock = self.enterQuantumBlock(ctx.quantumBlock())

        return TimingBox(des, qblock)

    # Enter a parse tree produced by qasm3Parser#timingIdentifier
    def enterTimingIdentifier(self, ctx:qasm3Parser.timingIdentifier):
        lit = None
        id = None
        qblock = None
        if "durationof" in ctx.getText():
            if ctx.Identifier() is not None:
                id = self.enterIdentifier(ctx.Identifier())
            elif ctx.quantumBlock() is not None:
                qblock = self.enterQuantumBlock(ctx.quantumBlock())
        else:
            lit = TimingLiteral(ctx.TimingLiteral().getText())
    
        return TimingIdentifier(lit, id, qblock)

    # Enter a parse tree produced by qasm3Parser#TimingInstructionName
    def enterTimingInstructionName(self, ctx:qasm3Parser.TimingInstructionNameContext):
        ti = TimingInstructionName()
        ti.ttype=ctx.getText()
        return ti
    # Enter a parse tree produced by qasm3Parser#TimingInstruction
    def enterTimingInstruction(self, ctx:qasm3Parser.TimingInstructionContext):
        name = self.enterTimingInstructionName(ctx.timingInstructionName())
        des = self.enterDesignator(ctx.designator())
        id_list = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        exp_list = None
        if ctx.expressionList() is not None:
            exp_list = self.enterExpressionList(ctx.expressionList())
        return TimingInstruction(name, des, id_list, exp_list)

    # Enter a parse tree produced by qasm3Parser#TimingStatement
    def enterTimingStatement(self, ctx:qasm3Parser.TimingStatementContext):
        stmt = None
        print(ctx.getText())
        if ctx.timingInstruction() is not None:
            stmt = self.enterTimingInstruction(ctx.timingInstruction())
        elif ctx.timingBox() is not None:
            stmt = self.enterTimingBox(ctx.timingBox())
        return TimingStatement(stmt)