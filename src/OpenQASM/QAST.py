class QCODE:
    """Holds the entire QAST"""
    def __init__(self):
        self.GATES = []
        self.STATEMENTS = []
        self.VARS = []
        self.GLOBALS = []

class BinaryOp:
    def __init__(self, op, left, right):
        self.token = self.op = op
        self.left = left
        self.right = right

class Sum(BinaryOp):
    def eval(self):
        i = self.left.eval() + self.right.eval()
        return i

class Sub(BinaryOp):
    def eval(self):
        i = self.left.eval() - self.right.eval()
        return i

class Mul(BinaryOp):
    def eval(self):
        i = self.left.eval() * self.right.eval()
        return i

class Div(BinaryOp):
    def eval(self):
        i = self.left.eval() / self.right.eval()
        return i

class QuantumDeclaration:
    def __init__(self, ttype, identifier, designator):
        self.ttype = ttype
        self.id = identifier
        self.designator = designator
        pass

class QuantumArgument(QuantumDeclaration):
    def __init__(self, ttype, identifier, designator):
        super().__init__(ttype, identifier, designator)

class IdentifierList:
    def __init__(self, ids):
        self.identifiers = ids

    def Eval(self):
        return self.identifiers

    def IterEval(self):
        yield self.identifiers

class QuantumArgumentList:
    def __init__(self, *args):
        self.arguments = args

    def Eval(self):
        return self.arguments

    def IterEval(self):
        yield self.arguments

class Statement:
    def __init__(self):
        pass

class Component:
    def __init__(self):
        self.name = None
        self.footprint = None
        self.qid = None
        self.successProbability = 0.9

    def set_probability(self):
        pass

    def get_component_from_libs(self, lib, component):
        pass

    def get_component_from_decomposition(self, unitary):
        pass

class QCode:
    def __init__(self):
        self.qubits = []
        pass

    def AddQubit(self, qubit=None):
        if(qubit == None):
            if(len(self.qubits)!=0):
                qubit = Qubit(qid=len(self.qubits)-1)
            else:
                qubit = Qubit(qid=0)
        try:
            qubit.left = self.qubits[len(self.qubits)-2]
            qubit.left.right = qubit
            qubit.right = self.qubits[len(self.qubits)] or None
        except Exception as e:
            print(e)
        self.qubits.append(qubit)

class Qubit:
    def __init__(self, qid=0, left=None, right=None):
        self.qid = qid
        self.left = left
        self.right = right
        self.components = {
            0:"SPS"
        }
    def calculate_probabilities(self):
        pass

class Gate:
    def __init__(self, name=None, fp=None, comp=None):
        """
        Base class for quantum gates.
        name = string = unique identifier for gate
        fp = string = footprint for pcb
        """
        self.name = name
        self.footprint = fp
        self.component = comp
        pass

    def SetName(self, name):
        self.name = name

    def SetFootprint(self, fp):
        self.fp = fp
    
    def SetComponent(self, comp):
        self.component = comp

    def Eval(self):
        pass

class U(Gate):
    def __init__(self):
        self.name = "U"
        self.fp = None
        self.comp = None

    def Eval(self):
        super()
        pass

class CX(Gate):
    def __init__(self):
        self.name = "CX"
        self.fp = "CX"
        self.comp = "CX"

    def Eval(self):
        super()
        pass
