class Module:
    pass

class Expression:
    pass

class FunctionType:
    pass

class Statement:
    def __init__(self):

    pass

class FunctionDef(Statement)
    def __init__(self, name, args, body, returns, type_comment="")):
        pass

class Return(Statement):
    def __init__(self, value):
        pass

class Assign(Statement):
    def __init__(self, targets, value, type_comment=""):
            pass

class For(Statement):
    def __init__(self, target, iter, body, orelse, type_comment=""):
        pass

class While(Statement):
    def __init__(self, body, orelse):
        pass

class QuantumStatement(Statement):
    pass

class BranchingStatement(Statement):
    pass

class EndStatement(Statement):
    def __init__(self):
        pass

class BoolOp(Statement):
    def __init__(self, op, values):
        pass

class UnaryOp(Statement):
    def __init__(self, op, values):
        pass

class IfExp(Statement):
    def __init__(self, body, orelse):
        pass

class ClassDef(Statement):
    def __init__(self, bases, keywords, body):
        pass

class QuantumGateDef(Statement):
    def __init__(self, signature, block):
        pass

