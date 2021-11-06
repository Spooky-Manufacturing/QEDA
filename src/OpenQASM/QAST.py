# pylint: disable=too-few-public-methods
class Variable:
    """The Variable base class.
    
    Used to define variables in the parser.
    """
    def __init_subclass__(cls, value, ttype=int):
        cls.value = value
        cls.type = ttype

    def eval(cls):
        return cls.value


class ClassicalDeclaration:
    """Base class for classical declarations.

    classicalDeclaration = 
    | singleDesignatorDeclaration
    | noDesignatorDeclaration
    | bitDeclaration
    | complexDeclaration
    """

class Program:
    """
    program =
    | header
    | header globalStatement(s) | statement(s)
    """
    def __init__(self, header, globalStatements=None, Statements=None):
        self.globalStatements = globalStatements
        self.statements =  Statements
        self.header = header

    def eval(self):
        x = {
            'globals':[],
            'locals':[],
            'header':None
        }
        if self.header!=None:
            x['header']=self.header.eval()
        for gs in self.globalStatements:
            if gs!=None:
                x['globals'].append(gs)#.eval())
        for s in self.statements:
            if s!=None:
                x['locals'].append(s)#.eval())
        


class Header:
    """
    header = 
    | version? include* io*"""
    def __init__(self, version, include=None, io=None):
        self.version = version
        self.include = include
        self.io = io

class Version:
    """version
    | 'OPENQASM' ( Integer | RealNumber ) ;
    value <= Integer | RealNumber
    """
    def __init__(self, value):
        self.value = value

class Include:
    """
    include
    | 'include' StringLiteral ;
    """    
    def __init__(self, stringLiteral):
        self.value = stringLiteral

class IoIdentifier:
    """ioIdentifier
    | 'input'
    | 'output'
    """
    def __init__(self, inp="input"):
        self.inp=inp
    
    def eval(self):
        return self.inp

class Io:
    """io = 
    | ioIdentifier classicalType Identifier SEMICOLON
    """
    def __init__(self, ioId, classicalType, identifier):
        self.portType = ioId
        self.ctype = classicalType
        self.id = identifier

    def eval(self):
        x={
            'io':self.portType.eval(),
            'type':self.ctype.eval(),
            'id':self.id.eval()
        }
        return x

class GlobalStatement:
    """The base class for global statements.
    
    globalStatement =
    | subroutineDefinition
    | externDeclaration
    | quantumGateDefinition
    | calibration
    | quantumDeclarationStatement  // qubits are declared globally
    | pragma
    """

class Statement:
    """The base class for local statements.

    statement =
    | expressionStatement
    | assignmentStatement
    | classicalDeclarationStatement
    | branchingStatement
    | loopStatement
    | endStatement
    | aliasStatement
    | quantumStatement    
    """

class QuantumDeclarationStatement(GlobalStatement):
    """
    quantumDeclarationStatement =
    | quantumDeclaration ;
    """
    def __init__(self, quantumDeclaration):
        self.decl = quantumDeclaration

    def eval(self):
        x = {
            'type': 'quantumDeclaration',
        }
        if self.decl!=None:
            x['decl']=self.decl.eval()
        return x

class ClassicalDeclarationStatement(Statement):
    """
    classicalDeclarationStatement =
    | classicalDeclaration ;
    | constantDeclaration ;
    """
    def __init__(self, declaration):
        self.declaration = declaration

    def eval(self):
        x = {
            'type': 'classicalDeclaration',
            'decl': None
        }
        if self.declaration!=None:
            x['decl']=self.declaration.eval()
        return x
class ClassicalAssignment:
    """
    classicalAssignment =
    | Identifier designator? assignmentOperator expression
    """
    def __init__(self, identifier, designator, operator, expression):
        self.id = identifier
        self.designator = designator
        self.op = operator
        self.expr = expression

    def eval(self):
        x = {
            'type': "classicalAssignment",
            'id': self.id.eval(),
            'op': self.op.eval()
        }
        if self.designator!=None:
            x['des']=self.designator.eval()
        if self.expr!=None:
            x['expr']=self.expr.eval()
        return x

class AssignmentStatement(Statement):
    """
    assignmentStatement =
    | classicalAssignment ;
    | quantumMeasurementAssignment ;
    """
    def __init__(self, assignment):
        self.assignment = assignment

    def eval(self):
        x = {
            'type': 'assignmentStatement',
            'assign': self.assignment.eval()
        }
        return x
        
class ReturnSignature:
    """
    returnSignature = 
    | ARROW classicalType
    """
    def __init__(self, classicalType):
        self.type = classicalType

    def eval(self):
        return self.type.eval()

# Types & Casting
class Designator:
    """
    designator = 
    | { expression }
    """
    def __init__(self, expression):
        self.expression = expression

    def eval(self):
        if self.expression != None:
            return self.expression.eval()

class IdentifierList:
    """
    identifierList = 
    | Identifier,
    | Identifier, Identifier ...
    """
    def __init__(self, idList):
        self.idList = idList

    def eval(self):
        return [x.eval() for x in self.idList]

# Quantum Types

class QuantumDeclaration:
    """
    quantumDeclaration = 
    | 'qreg' Identifier designator?
    | 'qubit' designator? Identifier
    """
    def __init__(self, identifier, designator, qtype="qubit"):
        self.qtype = qtype
        self.id = identifier
        self.designator = designator

    def eval(self):
        x={
            'type': 'quantumDeclaration',
            'qtype':'',
            'id':''
        }
        if self.qtype!=None:
            x['qtype']=self.qtype
        if self.id!=None:
            x['id']=self.id.eval()
        if self.designator!=None:
            if type(self.designator)!=type([]):
                x['designator']=self.designator.eval()
            else:
                x['designators']=[]
                for each in self.designator:
                    if each!=None:
                        x['designator'].append(each.eval())
        return x

class QuantumArgument(QuantumDeclaration):
    """
    quantumArgument = 
    | 'qreg' Identifier designator?
    | 'qubit' designator? Identifier
    """
    pass

class QuantumArgumentList:
    """
    quantumArgumentList = 
    | quantumArgument,
    | quantumArgument, quantumArgument...
    """
    def __init__(self, qargList):
        self.qargs = qargList

# Classical Types

class Type:
    """
    Internal base class for simple types.
    """
    def __init_subclass__(cls, ttype):
        cls.ttype = ttype
    
    def eval(cls):
        x = {
            'type': 'classical'
        }
        if type(cls.ttype) not in [type(""), type(0), type(0.1)]:
            x['ttype'] = cls.ttype.eval()
        else:
            x['ttype'] = cls.ttype
        return x


class ClassicalType:
    """
    ClassicalType =
    | noDesignatorType
    | singleDesignatorType designator
    | bitType designator?
    | 'complex' [ numericType ]
    """
    def __init__(self, ctype=None, designator=None, numericType=None):
        self._internalType = 'classical'
        self.ctype = ctype
        self.designator = designator
        self.numeric = numericType

    def eval(self):
        x = {
            'type': self._internalType,
            'ctype': None,
            'designator': None
        }
        if self.ctype != None:
            if type(self.ctype)==type(""):
                x['ctype']=self.ctype
            else:
                x['ctype']=self.ctype.eval()
        if self.designator!=None:
            x['designator']=self.designator.eval()
        elif self.numeric!=None:
            x['designator']=self.numeric.eval()
        return x

class BitType(ClassicalType):
    """
    bitType = 
    | 'bit'
    | 'creg'
    """

class SingleDesignatorType(ClassicalType):
    """
    singleDesignatorType = 
    | 'int'
    | 'uint'
    | 'float'
    | 'angle'
    """

class NoDesignatorType(ClassicalType):
    """
    noDesignatorType = 
    | 'bool'
    | timingType
    """

# Numeric OpenQASM Types

class NumericType:
    """
    numericType = 
    | singleDesignatorType designator
    """
    def __init__(self, singleDesignatorType, designator):
        self.ctype = singleDesignatorType
        self.designator = designator

    def eval(self):
        x = {
            'type': 'classical',
        }
        if self.ctype!=None:
            if type(self.ctype) != type(""):
                x['ctype'] = self.ctype.eval()
            else:
                x['ctype'] = self.ctype
        if self.designator!=None:
            x['designator'] = self.designator.eval()
        return x
    
class ConstantDeclaration:
    """
    constantDeclaration
    | 'const' Identifier equalsExpression
    """
    def __init__(self, ident, exp):
        self.id = ident
        self.exp = exp

    def eval(self):
        x = {
            'type': 'constant',
            'id': self.id.eval(),
            'expr': self.exp.eval()
        }
        return x
class SingleDesignatorDeclaration(ClassicalDeclaration):
    """
    // if multiple variables declared at once, either none are assigned or all are assigned
    // prevents ambiguity w/ qubit arguments in subroutine calls
    singleDesignatorDeclaration =
    | singleDesignatorType designator Identifier equalsExpression?
    """
    def __init__(self, designator,identifier, expression):
        self.designator = designator
        self.id = identifier
        self.exp = expression

    def eval(self):
        x = {
            'type': 'singleDesignatorDeclaration',
            'id': self.id.eval()
        }
        if self.designator!=None:
            x['designator']=self.designator.eval()
        if self.exp!=None:
            x['expr']=self.exp.eval()
        return x

class NoDesignatorDeclaration(ClassicalDeclarationStatement):
    """
    noDesignatorDeclaration = 
    | noDesignatorType Identifier equalsExpression?
    """
    def __init__(self, dtype, identifier, expression=None):
        self.dtype = dtype
        self.id = identifier
        self.exp = expression

    def eval(self):
        x = {
            'type': 'noDesignatorDeclaration',
            'id': self.id.eval(),
        }
        if self.exp!=None:
            x['expr'] = self.exp.eval()
        if self.dtype!=None:
            x['dtype']=self.dtype
        return x
class BitDeclaration(ClassicalDeclarationStatement):
    """
    bitDeclaration = 
    | 'creg' Identifier designator? equalsExpression?
    | 'bit' designator? Identifier equalsExpression?
    """
    def __init__(self, identifier, designator=None, equalsExpression=None, ttype="bit"):
        self.id = identifier
        self.designator = designator
        self.ttype = ttype
        self.exp = equalsExpression

    def eval(self):
        x = {
            
            'type': self.ttype,
        }
        if self.id!=None:
            x['id'] = self.id.eval()
        if self.designator != None:
            x['designator'] = self.designator.eval()
        if self.exp != None:
            x['expr'] = self.exp.eval()
        return x

class ComplexDeclaration(ClassicalDeclarationStatement):
    """
    complexDeclaration = 
    | 'complex' [ numericType ] Identifier equalsExpression?
    """
    def __init__(self, identifier, numericType, expression):
        self.id = identifier
        self.num = numericType
        self.exp = expression

    def eval(self):
        x = {
            'type':'complexDeclaration',
            'id':'',
            'ntype':'',
            'exps':[]
        }
        if self.id!=None:
            x['id']=self.id.eval()
        if self.num!=None:
            x['ntype']=self.num.eval()
        if self.exp!=None:
            x['exps']=self.exp.eval()
        return x

class ClassicalTypeList:
    """
    classicalTypeList = 
    | classicalType,
    | classicalType, classicalType...
    """
    def __init__(self, classicalTypes):
        self.list = classicalTypes
    
    def eval(self):
        x=[]
        if self.list!=None:
            for each in self.list:
                if each!=None:
                    x.append(each.eval())
        return x

class AnyTypeArgument:
    """
    anyTypeArgument = 
    | classicalArgument
    | quantumArgument
    """
    def __init__(self, argument):
        self.arg = argument

    def eval(self):
        if self.arg!=None:
            return self.arg.eval()

class ClassicalArgument:
    """
    classicalArgument =
    |( singleDesignatorType designator |
       noDesignatorType
     ) Identifier
    | 'creg' Identifier designator?
    | 'bit' designator? Identifier
    | 'complex' LBRACKET numericType RBRACKET Identifier
    """
    def __init__(self, dtype=None, des=None, id=None, ctxType=None):
        self.ttype=ctxType
        self.dtype=dtype
        self.des=des
        self.id=id

    def eval(self):
        x={
            'type':'classicalArgument',
        }
        if self.ttype!=None:
            x['ttype']=self.ttype
        if self.dtype!=None:
            x['dtype']=self.dtype
        if self.des!=None:
            x['des']=self.des.eval()
        if self.id!=None:
            x['id']=self.id.eval()
        return x

class ClassicalArgumentList:
    def __init__(self, args):
        self.args = args

    def eval(self):
        x=[]
        if self.args!=None:
            for each in self.args:
                if each!=None:
                    x.append(each.eval())
        return x

class AnyTypeArgumentList:
    def __init__(self, args):
        self.args=args
    
    def eval(self):
        x=[]
        if self.args!=None:
            for each in self.args:
                if each!=None:
                    x.append(each.eval())
        return x
"""
Aliasing
"""
class AliasStatement:
    """
    aliasStatement = 
    | 'let' Identifier = indexIdentifier;
    """
    def __init__(self, identifier, indexIdentifier):
        self.id = identifier
        self.value = indexIdentifier

    def eval(self):
        x={
            'type':'aliasStatement',
            'id':'',
            'value':''
        }
        if self.id!=None:
            x['id']=self.id.eval()
        if self.value!=None:
            x['value']=self.value.eval()
        return x

"""
Register Concatenation & Slicing
"""
class IndexIdentifier:
    """
    indexIdentifier = 
    | Identifier rangeDefinition
    | Identifier [ expressionList ]?
    | indexIdentifier '||' indexIdentifier
    """
    def __init__(self, identifier, expressionList=None, indexes=None, rangeDef=None):
        self.id = identifier
        self.expList = expressionList
        self.ind = indexes
        self.range = rangeDef

    def eval(self):
        x={
            'id':'',
        }
        if self.id!=None:
            x['id']=self.id.eval()
        if self.range!=None:
            x['range']=self.range.eval()
        if self.expList!=None:
            if type(self.expList)!=type([]):
                x['exprList']=self.expList.eval()
            else:
                x['exprList']=self.expList
        if self.ind!=None:
            for i in range(len(self.ind)):
                x['index'+str(i+1)]=self.ind(i).eval()
        return x

class IndexIdentifierList:
    """
    indexIdentifierList =
    | indexIdentifier,
    | indexIdentifier, indexIdentifier...
    """
    def __init__(self, indexIdList):
        self.idList = indexIdList

    def eval(self):
        idlist = []
        if self.idList!=None:
            for each in self.idList:
                if each!=None:
                    idlist.append(each.eval())
        return idlist

class RangeDefinition:
    """
    rangeDefinition = 
    | [ expression1 : expression2 ]
    | [ expression1 : expression2 : expression3 ]
    """
    def __init__(self, expression1, expression2, expression3=None):
        self.exp1 = expression1
        self.exp2 = expression2
        self.exp3 = expression3

    def eval(self):
        x = {
            'type': 'rangeDef',
            'exp1':None,
            'exp2':None,
            'exp3':None
        }
        if self.exp1!=None:
            x['exp1']=self.exp1.eval()
        if self.exp2!=None:
            x['exp2']=self.exp2.eval()
        if self.exp3!=None:
            x['exp3']=self.exp3.eval()
        return x

# Gates & Built-In Quantum Instructions

class QuantumGateDefinition(GlobalStatement):
    """
    quantumGateDefinition = 
    | 'gate' quantumGateSignature quantumBlock
    """
    def __init__(self, signature, block):
        self.signature = signature
        self.block = block

    def eval(self):
        x = {
            'type': 'quantumGateDefinition',
            'sig':self.signature.eval(),
            'block':self.block.eval()
        }
        return x

class QuantumGateSignature:
    """
    quantumGateSignature = 
    | quantumGateName
    | quantumGateName identifierList
    | quantumGateName ( identifierList )
    | quantumGateName ( identifierList ) identifierList
    < quantumGateName (parameters) identifiers
    """
    def __init__(self, gateName, identifiers=None, parameters=None):
        self.name = gateName
        self.ids = identifiers
        self.params = parameters
        
    def eval(self):
        x = {
            'name':'',
            'ids':[],
            'params':[]
        }
        if self.name!=None:
            x['name']=self.name.eval()
        if self.ids!=None:
            x['ids']=self.ids.eval()
        if self.params!=None:
            x['params']=self.params.eval()
        return x

class QuantumGateName:
    """
    quantumGateName = 
    | 'U',
    | 'CX',
    | Identifier
    """
    def __init__(self, identifier="U"):
        self.id = identifier

    def eval(self):
        if type(self.id) != type("") and type(self.id) != type(None):
            return self.id.eval()
        return self.id

class QuantumBlock(Statement):
    """
    quantumBlock = 
    | { quantumStatement }
    | { quantumLoop }
    | { quantumStatement* | quantumLoop*}
    """
    def __init__(self, statements=None, loops=None):
        self.statements = statements
        self.loops = loops
    
    def eval(self):
        x={
            'type': 'quantumBlock',
            'stmts': []
        }
        if self.statements!=None:
            if type(self.statements)!=type([]):
                x['stmts']=self.statements.eval()
            else:
                for each in self.statements:
                    if each:
                        x['stmts'].append(each.eval())
        if self.loops!=None:
            if type(self.loops)!=type([]):
                x['loops']=self.loops.eval()
            else:
                x['loops']=[x.eval() for x in self.loops]
        return x

class QuantumLoop:
    """
    quantumLoop = 
    | loopSignature quantumLoopBlock
    """
    def __init__(self, loopSignature, quantumLoopBlock):
        self.signature = loopSignature
        self.block = quantumLoopBlock

    def eval(self):
        x={
            'type': 'quantumLoop',
            'sig':None,
            'block':None
        }
        if self.signature!=None:
            x['sig']=self.signature.eval()
        if self.block!=None:
            x['block']=self.block.eval()
        return x


class QuantumLoopBlock:
    """
    quantumLoopBlock = 
    | quantumStatement
    | { quantumStatement* }
    """
    def __init__(self, statements):
        self.statements = statements

    def eval(self):
        x=[]
        if self.statements!=None:
            for each in self.statements:
                if each!=None:
                    x.append(each.eval())
        return x

class QuantumStatement(Statement):
    """
    quantumStatement =
    | quantumInstruction ;
    | timingStatement
    """
    def __init__(self, quantumInstruction=None, timingStatement=None):
        self.quantumInstruction = quantumInstruction
        self.timingStatement = timingStatement

    def eval(self):
        x = None
        if self.quantumInstruction != None:
            x = self.quantumInstruction.eval()
        if self.timingStatement != None:
            x = self.timingStatement.eval()
        return x
    
class QuantumInstruction:
    """The base class for quantum instructions
    | quantumGateCall
    | quantumPhase
    | quantumMeasurement
    | quantumReset
    | quantumBarrier
    """
    def __init__(self, instruction):
        self.instruction = instruction

    def eval(self):
        x = {
            'type': 'quantumInstruction',
        }
        if self.instruction != None:
            x['instruction'] = self.instruction.eval()
        return x

class QuantumPhase(QuantumInstruction):
    """
    quantumPhase =
    quantumGateModifier* 'gphase' (expression) indexIdentifierList?
    """
    def __init__(self, expression, indexIdentifierList, modifiers=None):
        self.exp = expression
        self.indexId = indexIdentifierList
        self.mods = modifiers

    def eval(self):
        x={
            'type': 'quantumPhase',
            'expr':None,
            'indexIdList':None,
            'qGateMods':[]
        }
        if self.exp != None:
            x['expr']=self.exp.eval()
        if self.indexId != None:
            x['indexIdList']=self.indexId.eval()
        if self.mods!=None:
            for each in self.mods:
                if each!=None:
                    x['qGateMods'].append(each.eval())
        return x

class QuantumReset(QuantumInstruction):
    """
    quantumReset = 
    | 'reset' indexIdentifierList
    """
    def __init__(self, indexIdentifierList):
        self.instruction = "quantumReset"
        self.indexId = indexIdentifierList
    def eval(self):
        x = {
            'type':"quantumReset",
            'indexIdList':[]
        }
        if self.indexId != None:
            x['indexIdList']=self.indexId.eval()
        return x

class QuantumMeasurement(QuantumInstruction):
    """
    quantumMeasurement = 
    | 'measure' indexIdentifier
    """
    def __init__(self, indexIdentifier):
        self.indexId = indexIdentifier

    def eval(self):
        x = {
            'type':"quantumMeasure",
            'indexIdList':[]
        }
        if self.indexId != None:
            x['indexIdList']=self.indexId.eval()
        return x


class QuantumMeasurementAssignment(QuantumInstruction):
    """
    quantumMeasurementAssignment = 
    | quantumMeasurement -> indexIdentifier?
    | indexIdentifier = quantumMeasurement
    """
    def __init__(self, qmeas, indexId):
        self.indexId = indexId
        self.qmeas = qmeas

    def eval(self):
        x = {
            'type':"quantumMeasurementAssignment",
            'indexIdList':None,
            'qmeas':None
        }
        if self.indexId != None:
            x['indexIdList']=self.indexId.eval()
        if self.qmeas!=None:
            x['qmeas']=self.qmeas.eval()
        return x

class QuantumBarrier(QuantumInstruction):
    """
    quantumBarrier = 
    | 'barrier' indexIdentifierList?
    """
    def __init__(self, indexIdentifierList):
        self.indexId = indexIdentifierList
    def eval(self):
        x = {
            'type':"quantumBarrier",
        }
        if self.indexId != None:
            x['indexIdList'] = self.indexId.eval()
        return x

class QuantumGateModifier:
    """The base class for quantum gate modifiers.
    quantumGateModifier = 
    | 'inv' '@'
    | powModifier '@'
    | ctrlModifier '@'
    """
    def __init__(self, modifier):
        self.mod = modifier
        self.expression = None

    def eval(self):
        x = {
            'mod': None,
            'exp': None
        }
        if self.mod!=None:
            if type(self.mod)!=type(''):
                x['mod']=self.mod.eval()
            else:
                x['mod']=self.mod
            if self.expression!=None:
                x['expression']=self.expression.eval()
        return x

class PowModifier(QuantumGateModifier):
    """
    powModifier = 
    | 'pow' ( expression )
    """
    def __init__(self, expression):
        self.mod = 'pow'
        self.expression = expression

class CtrlModifier(QuantumGateModifier):
    """
    ctrlModifier = 
    | 'ctrl' ( expression )
    | 'negctrl' ( expression )
    """
    def __init__(self, expression, neg=False):
        if neg:
            self.mod = 'negctrl'
        else:
            self.mod = 'ctrl'
        self.expression = expression

class QuantumGateCall(QuantumInstruction):
    """
    quantumGateCall = 
    | quantumGateName indexIdentifierList
    | quantumGateName ( expressionList ) indexIdentifierList
    | quantumGateModifier* quantumGateName indexIdentifierList
    | quantumGateModifier* quantumGateName ( expressionList ) indexIdentifierList
    """
    def __init__(self, quantumGateName, indexIdentifierList, expressionList=None, quantumGateModifier=None):
        self.qgMod = quantumGateModifier
        self.name = quantumGateName
        self.expList = expressionList
        self.indexId = indexIdentifierList

    def eval(self):
        x = {
            'type':'quantumGateCall',
            'name':'',
            'mods':[],
            'exps':[],
            'indexIdList':[]
        }
        if self.qgMod!=None: 
            for each in self.qgMod:
                x['mods'].append(each.eval())
        if self.name!=None:
            x['name']=self.name.eval()
        if self.expList!=None:
            x['exps']=self.expList.eval()
        if self.indexId!=None:
            x['indexIdList']=self.indexId.eval()
        return x

# Classical Instructions

class ExpressionStatement:
    """
    expressionStatement = 
    | expression ;
    """
    def __init__(self, expression):
        self.exp = expression

    def eval(self):
        x = {
            'type': 'expressionStatement'
        }
        if self.exp!=None:
            x['expr'] = self.exp.eval()
        return x

class BaseExpression:
    """The base expression class"""

    def __init__(self, expression1, expression2=None, operator=None):
        self.exp1 = expression1
        self.exp2 = expression2
        self.op = operator

    def eval(self):
        x = {
            'type': str(self.__class__.__name__),
        }
        if self.exp1:
            x['exp1'] = self.exp1.eval()
            if self.exp2:
                x['exp2'] = self.exp2.eval()
        elif self.exp2:
            return self.exp2.eval()
        x['op'] = self.op
        return x

class Expression(BaseExpression):
    """
    expression =
    | expressionTerminator
    | unaryExpression
    | logicalAndExpression
    | expression '||' logicalAndExpression
    """

    def eval(self):
        x = {
            'type': "expression",
        }
        if self.exp2:
            x['exp2'] = self.exp2.eval()
            if self.exp1:
                x['exp1'] = self.exp1.eval()
            return x
        else:
            return self.exp1.eval()

class LogicalAndExpression(BaseExpression):
    """
    logicalAndExpression = 
    | bitOrexpression
    | logicalAndExpression '&&' bitOrExpression
    """
    def eval(self):
        if self.exp1:
            if self.exp2:
                try:
                   return self.exp1.eval() and self.exp2.eval()
                except:
                    return super().eval()
            return self.exp1.eval()
        return self.exp2.eval()
        
class BitOrExpression(BaseExpression):
    """
    bitOrExpression =
    | xOrExpression
    | bitOrExpression '|' xOrExpression
    """
    def eval(self):
        if self.exp1:
            if self.exp2:
                try:
                    return self.exp1.eval() or self.exp2.eval()
                except:
                    return super().eval()
            return self.exp1.eval()
        return self.exp2.eval()

class XorExpression(BaseExpression):
    """
    xOrExpression = 
    | bitAndExpression
    | xOrExpression '^' bitAndExpression
    """
    def eval(self):
        if self.exp2:
            try:
                return int(round(self.exp1.eval())) ^ int(round(self.exp2.eval()))
            except:
                return super().eval()
        return self.exp1.eval()

class BitAndExpression(BaseExpression):
    """
    bitAndExpression = 
    | equalityExpression
    | bitAndExpression '&' equalityExpression
    """
    def eval(self):
        if self.exp1:
            if self.exp2:
                try:
                    return self.exp1.eval() & self.exp2.eval()
                except:
                    return super().eval()
            return self.exp1.eval()
        return self.exp2.eval()

class EqualityExpression(BaseExpression):
    """
    equalityExpression = 
    | comparisonExpression
    | equalityExpression == comparisonExpression
    | equalityExpression != comparisonExpression
    """
    def eval(self):
        if self.exp1:
            if self.exp2:
                try:
                    if self.op == '==':
                        return self.exp1.eval() == self.exp2.eval()
                    elif self.op == '!=':
                        return self.exp1.eval() != self.exp2.eval()
                except:
                    return super().eval()
            return self.exp1.eval()
        return self.exp2.eval()

class ComparisonExpression(BaseExpression):
    """
    comparisonExpression =
    | bitShiftExpression
    | comparisonExpression (<|>|>=|<=) bitShiftExpression
    """
    def eval(self):
        if self.exp1:
            if self.exp2:
                try:
                    if self.op == '<':
                        return self.exp1.eval() < self.exp2.eval()
                    elif self.op == '>':
                        return self.exp1.eval() > self.exp2.eval()
                    elif self.op == '<=':
                        return self.exp1.eval() <= self.exp2.eval()
                    elif self.op == '>=':
                        return self.exp1.eval() >= self.exp2.eval()
                except:
                    return super().eval()
            return self.exp1.eval()
        return self.exp2.eval()

class BitShiftExpression(BaseExpression):
    """
    bitShiftExpression = 
    | additiveExpression
    | bitShiftExpression ( '<<' | '>>' ) additiveExpression
    """
    def eval(self):
        if self.exp1:
            if self.exp2:
                try:
                    if self.op == '>>':
                        return self.exp1.eval() >> self.exp2.eval()
                    elif self.op == '<<':
                        return self.exp1.eval() << self.exp2.eval()
                except:
                    return super().eval()
            return self.exp1.eval()
        return self.exp2.eval()

class AdditiveExpression(BaseExpression):
    """
    additiveExpression = 
    | multiplicativeExpression
    | additiveExpression ( + | - ) multiplicativeExpression
    """
    def eval(self):
        if self.exp1:
            if self.exp2:
                try:
                    if self.op == '+':
                        return self.exp1.eval() + self.exp2.eval()
                    elif self.op == '-':
                        return self.exp1.eval() - self.exp2.eval()
                except:
                    return super().eval()
            return self.exp1.eval()
        return self.exp2.eval()

class MultiplicativeExpression(BaseExpression):
    """
    multiplicativeExpression = 
    | powerExpression
    | unaryExpression
    | multiplicativeExpression ( * | / | % ) powerExpression
    | multiplicativeExpression ( * | / | % ) unaryExpression
    """
    def eval(self):
        if self.exp1:
            if self.exp2:
                try:
                    if self.op == '*':
                        return self.exp1.eval() * self.exp2.eval()
                    elif self.op == '/':
                        return self.exp1.eval() / self.exp2.eval()
                    elif self.op == '%':
                        return self.exp1.eval() % self.exp2.eval()
                except:
                    return super().eval()
            return self.exp1.eval()
        return self.exp2.eval()

class UnaryExpression(BaseExpression):
    """
    unaryExpression =
    | unaryOperator powerExpression
    """
    def eval(self):
        if self.exp1:
            try:
                if self.exp1.eval() == '~':
                    return ~self.exp2.eval()
                elif self.exp1.eval() == '-':
                    return -1 * self.exp2.eval()
                elif self.exp1.eval() ==  '!':
                    return not self.exp2.eval()
            except:
                return super().eval()
        return self.exp1.eval()

class PowerExpression:
    """
    powerExpression
    | expressionTerminator
    | expressionTerminator '**' powerExpression
    """
    def __init__(self, term, expression=None):
        self.term = term
        self.expression = expression

    def eval(self):
        if self.expression:
            try:
                return self.term.eval() ** self.expression.eval()
            except:
                return super().eval()

        return self.term.eval()

class ExpressionTerminator:
    """
    expressionTerminator = 
    | Constant
    | Integer
    | RealNumber
    | ImagNumber
    | booleanLiteral
    | Identifier
    | StringLiteral
    | builtInCall
    | externOrSubroutineCall
    | timingIdentifier
    | ( expression )
    | expressionTerminator [ expression ] 
    ;
    """
    def __init__(self, constant=None, integer=None, realn=None, imagn=None,
    boolLit=None, ident=None, stringLit=None, builtIn=None, extern=None, timingId=None, expression=None, terminator=None):
        self.constant = constant
        self.integer = integer
        self.realn = realn
        self.imagn = imagn
        self.boolLit = boolLit
        self.ident = ident
        self.stringLit = stringLit
        self.builtIn = builtIn
        self.extern = extern
        self.timingId = timingId
        self.expression = expression
        self.terminator = terminator

    def eval(self):
        x = {
        }
        if self.extern:
           return self.extern.eval()

        elif self.terminator:
            x['type'] = 'terminator'
            x['term'] = self.terminator
            if self.expression:
                x['expr'] = self.expression
                return x
            else:
                return self.terminator.eval()
        elif self.constant:
#            x['constant'] = self.constant.eval()
            return self.constant.eval()
        elif self.integer:
#            x['int'] = self.integer.eval()
            return self.integer.eval()
        elif self.realn:
#            x['realn'] = self.realn.eval()
            return self.realn.eval()
        elif self.imagn:
#            x['imagn'] = self.imagn.eval()
            return self.imagn.eval()
        elif self.boolLit:
#            x['boolLit'] = self.boolLit.eval()
            return self.boolLit
        elif self.ident:
#            x['ident'] = self.ident.eval()
            return self.ident.eval()
        elif self.expression:
#            x['expr'] = self.expression.eval()
            return self.expression.eval()

        return x            

class BooleanLiteral(Variable, value='true', ttype=bool):
    """
    booleanLiteral =
    | 'true'
    | 'false'
    """
    def eval(self):
        if self.value == 'true':
            return True
        else:
            return False

class BuiltInCall:
    """
    builtInCall = 
    | builtInMath ( expressionList )
    | castOperator ( expressionList )
    """
    def __init__(self, operation, expressionList):
        self.op = operation
        self.expList = expressionList

    def eval(self):
        return self

class BuiltInMath:
    """
    builtInMath =
    | 'sin'
    | 'cos'
    | 'tan'
    | 'exp'
    | 'ln'
    | 'sqrt'
    | 'rotl'
    | 'rotr'
    | 'popcount'
    """
    def __init__(self, operation):
        self.operation = operation
    
    def eval(self):
        return self.operation

class CastOperator:
    """
    castOperator = 
    | classicalType
    """
    def __init__(self, ctype):
        self.ctype = ClassicalType(ctype)
    
    def eval(self):
        return self.ctype.eval()

class ExpressionList:
    """
    expressionList = 
    | expression,
    | expression, expression...
    """
    def __init__(self, expressions):
        self.expressions = expressions

    def eval(self):
        exp = 0
        if self.expressions:
            exp = []
            for each in self.expressions:
                if each:
                    exp.append(each.eval())
        return exp

class EqualsExpression:
    """
    equalsExpression = 
    | = expression
    """
    def __init__(self, expression):
        self.exp = expression

    def eval(self):
        if self.exp!=None:
            return self.exp.eval()

class AssignmentOperator:
    """
    assignmentOperator
    | EQUALS | =
    | '+=' | '-=' | '*=' | '/=' | '&=' | '|='
    | '~=' | '^=' | '<<=' | '>>=' | '%='
    | '**='
    """
    def __init__(self, operator):
        self.op = operator

    def eval(self):
        if type(self.op) == type(""):
            return self.op
        return self.op.eval()

class SetDeclaration:
    """
    setDeclaration =
    | { expressionList }
    | rangeDefinition
    | Identifier
    """
    def __init__(self, Identifier=None, expList=None, rangeDef=None):
        self.id = Identifier
        self.exp = expList
        self.range = rangeDef

    def eval(self):
        x = {
            'type': 'range',
            'range': None
        }
        if self.id != None:
            x['range'] = self.id.eval()
        if self.exp != None:
            x['range'] = self.exp.eval()
        if self.range != None:
            x['range'] = self.range.eval()
        
        return x

class ProgramBlock:
    """
    programBlock
    | statement 
    | controlDirective
    | { ( statement | controlDirective )* }
    """
    def __init__(self, statements):
        self.statements = statements

    def eval(self):
        x=[]
        if self.statements!=None:
            for each in self.statements:
                if each!=None:
                    x.append(each.eval())
        return x
class BranchingStatement(Statement):
    """
    branchingStatement = 
    | 'if' ( expression ) programBlock
    | 'if' ( expression ) programBlock 'else' programBlock
    """
    def __init__(self, exp, block1, elseBlock):
        self.exp = exp
        self.block1 = block1
        self.elseBlock = elseBlock

    def eval(self):
        x = {
            'type': 'branching',
            'if': {}
        }

        if self.exp != None:
            x['if']['expr'] = self.exp.eval(),
        if self.block1 != None:
            x['if']['block'] = self.block1.eval()
        if self.elseBlock!=None:
            x['elseBlock'] = self.elseBlock.eval()

class LoopSignature:
    """
    loopSignature = 
    | 'for' Identifier 'in' setDeclaration
    | 'while' ( expression )
    """
    def __init__(self, op, id=None, exp=None, decl=None):
        self.id = id
        self.op = op
        self.exp = exp
        self.decl = decl

    def eval(self):
        x = {
            'type': 'loopSignature',
            'op': self.op
        }
        if self.id!=None:
            x['id'] = self.id.getText()
        if self.exp != None:
            x['expr'] = self.exp.eval()
        if self.decl != None:
            x['decl'] = self.decl.eval()
        return x

class LoopStatement(Statement):
    """
    loopStatement =
    | loopSignature programBlock
    """
    def __init__(self, signature, block):
        self.signature = signature
        self.block = block

    def eval(self):
        x = {
            'type': 'loopStatement',
            'sig':'',
            'block':''
        }
        if self.signature!=None:
            x['sig']=self.signature.eval()
        if self.block!=None:
            x['block']=self.block.eval()
        return x

class EndStatement(Statement):
    """
    endStatement =
    | 'end' ;
    """
    def eval(self):
        x = { 'type': 'endState,emt' }
        return x

class ReturnStatement(Statement):
    """
    returnStatement =
    | 'return' expression ;
    | 'return' quantumMeasurement ;
    """
    def __init__(self, retval):
        self.retval = retval

    def eval(self):
        x = {
            'type': 'returnStatement',
            'ret': None
        }
        if self.retval:
            x['ret'] = self.retval.eval()
        return x

class ControlDirective(Statement):
    """
    controlDirective =
    | 'break' ;
    | 'continue' ;
    | endStatement
    | returnStatement
    """
    def __init__(self, directive):
        self.directive = directive

    def eval(self):
        if self.directive == 'break':
            pass
        if self.directive == 'continue':
            pass
        return self.directive.eval()

class ExternDeclaration:
    """
    externDeclaration =
    | 'extern' Identifier ( classicalTypeList ) returnSignature? ;
    """
    def __init__(self, identifier, ctypelist, retSig):
        self.id = identifier
        self.clist = ctypelist
        self.ret = retSig

    def eval(self):
        x = {
            'type': 'externDeclaration',
            'id': self.id.eval(),
        }
        if self.clist:
            x['clist'] = []
            for each in self.clist:
                x['clist'].append(each.eval())
        if self.ret != None:
            x['retSig'] = self.ret.eval()
        return x

class ExternOrSubroutineCall:
    """
    externOrSubroutineCall =
    | Identifier ( expressionList? )
    """
    def __init__(self, id, expList):
        self.id = id
        self.expList = expList

    def eval(self):
        x = {
            'type': 'externOrSubroutineCall',
            'id': self.id.eval(),
            'expList': []
        }
        if self.expList == []:
            for a in self.expList:
                if a:
                    x['explist'].append(a.eval())
        else:
            x['expList']=self.expList.eval()
        return x

"""
Subroutines
"""
class SubroutineDefinition:
    """
    subroutineDefinition =
    | 'def' Identifier ( anyTypeArgumentList )
    | returnSignature? subroutineBlock
    """
    def __init__(self, identifier=None, anyarg=None, ret=None, block=None):
        self.id = identifier
        self.anyarg=anyarg
        self.ret=ret
        self.block=block

    def eval(self):
        x = {
            'type': 'subroutineDefinition',
            'args': None,
            'retSig': None,
            'block': None
        }
        if self.id != None:
            x['id'] = self.id.eval()
        if self.anyarg != None:
            x['args'] = self.anyarg.eval()
        if self.ret != None:
            x['retSig'] = self.ret.eval()
        if self.block != None:
            x['block'] = self.block.eval()
        return x

class SubroutineBlock:
    """
    subroutineBlock =
    | { statement* returnStatement? }
    """
    def __init__(self, statement, ret):
        self.statement = statement
        self.ret = ret

    def eval(self):
        x = {
            'type': 'subroutineBlock',
        }
        if self.statement != None:
            if type(self.statement) == type([]):
                x['stmt'] = [x.eval() for x in self.statement]
            else:
                x['stmt'] = self.statement.eval()
        if self.ret != None:
            x['ret'] = self.ret.eval()
        return x

"""
Directives
"""

class Pragma:
    """
    pragma = 
    | '#pragma' { statement *}
    """
    def __init__(self, statement):
        self.statement = statement

    def eval(self):
        return self.statement.eval()

"""
Circuit Timing
"""

class TimingType(Type, ttype='duration'):
    """
    timingType = 
    | 'duration'
    | 'stretch'
    """
    pass

class TimingBox:
    """
    timingBox =
    | 'box' designator? quantumBlock
    """
    def __init__(self, designator, qblock):
        self.des = designator
        self.block = qblock

    def eval(self):
        if self.des!=None:
            if len(self.des) > 0:
                for each in self.des:
                    each.eval()
        if self.block != None:
            self.block.eval()

class TimingIdentifier:
    """
    timingIdentifier =
    | TimingLiteral
    | 'durationof' ( Identifier | quantumBlock )
    """
    def __init__(self, literal=None, id=None, block=None):
        self.lit = literal
        self.id = id
        self.block = block
    
    def eval(self):
        x = {
            'type': "timingIdentifier",
        }
        if self.id:
            x['id'] = self.id.eval()
        if self.lit:
            x['lit'] = self.lit
        if self.block:
            x['block'] = self.block.eval()

class TimingLiteral:
    """
    """
    def __init__(self, val):
        self.val = val

    def eval(self):
        return self.val

class TimingInstructionName(Type, ttype='delay'):
    """
    timingInstructionName =
    |'delay'
    |'rotary'
    """

class TimingInstruction:
    """
    timingInstruction =
    | timingInstrucionName designator indexIdentifierList
    | timingInstructionName ( expressionList ) designator indexIdentifierList
    """
    def __init__(self, name, designator, indexIdList, expressionlist=None):
        self.name = name
        self.designator = designator
        self.idxIdList = indexIdList
        self.expList = expressionlist

    def eval(self):
        x = {
            'name': self.name.eval()
        }
        if self.designator:
            x['designator'] = self.designator.eval()
        if self.idxIdList:
            x['indexIdList'] = self.idxIdList.eval()
        if self.expList:
            x['exprs'] = self.expList.eval()
        return x

class TimingStatement:
    """
    TimingStatement = 
    | timingInstruction ;
    | timingBox
    """
    def __init__(self, statement):
        self.statement = statement

    def eval(self):
        x = {
            'type': 'timingStatement',
            'stmt': self.statement.eval()
        }
        return x


class Identifier:
    """
    The Identifier class
    """
    def __init__(self, id):
        self.id = id.getText()

    def eval(self):
        return self.id

class Constant:
    def __init__(self, value):
        self.value = value.getText()
        self._valueDecoder()

    def _valueDecoder(self):
        if self.value in ['pi','PI','π']:
            self.value = 22/7
        elif self.value in ['tau', 'TAU', '𝜏']:
            self.value = 3.141519 * 2.0
        elif self.value in ['euler', 'EULER', 'ℇ']:
            self.value = 2.71828
        else:
            if int(self.value) == float(self.value):
                self.value = int(self.value)
            else:
                self.value = float(self.value)

    def eval(self):
        return self.value

class Integer:
    def __init__(self, value):
        self.value = value

    def eval(self):
        if self.value:
            return int(self.value.getText())
        return 0

class RealNumber:
    def __init__(self, value):
        self.value = value

    def eval(self):
        if self.value:
            return float(self.value.getText())
        return 0

class ImagNumber:
    def __init__(self, value):
        self.value = value

    def eval(self):
        if self.value:
            return float(self.value.getText().split("IMAG")[0])
        return 0