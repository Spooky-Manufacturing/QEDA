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
    | complex
    """
    pass

class Program:
    """
    program =
    | header
    | header globalStatement(s) | statement(s)
    """
    def __init__(self, header, globalStatements=None, Statements=None):
        self.globalStatements = [] = globalStatements
        self.statements = [] = Statements
        self.header = header

    def eval(self):
        for gs in self.globalStatements:
            gs.eval()
        for s in self.statements:
            s.eval()
        pass



class Header:
    """
    header = 
    | version? include* io*"""
    def __init__(self, version, include=None, io=None):
        self.version = version
        self.include = include
        self.io = io
        pass

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
    def __init__(self, ioId, classicalType, Identifier):
        self.portType = ioId
        self.ctype = classicalType
        self.id = Identifier

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
    pass

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
    pass

class QuantumDeclarationStatement(GlobalStatement):
    """
    quantumDeclarationStatement =
    | quantumDeclaration ;
    """
    def __init__(self, quantumDeclaration):
        self.decl = quantumDeclaration

class ClassicalDeclarationStatement(Statement):
    """
    classicalDeclarationStatement =
    | classicalDeclaration ;
    | constantDeclaration ;
    """
    def __init__(self, declaration):
        self.declaration = declaration

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

class AssignmentStatement(Statement):
    """
    assignmentStatement =
    | classicalAssignment ;
    | quantumMeasurementAssignment ;
    """
    def __init__(self, assignment):
        self.assignment = assignment

class ReturnSignature:
    """
    returnSignature = 
    | ARROW classicalType
    """
    def __init__(self, classicalType):
        self.type = classicalType

"""
Types & Casting
"""
class Designator:
    """
    designator = 
    | { expression }
    """
    def __init__(self, expression):
        self.expression = expression

    def eval(self):
        if(self.expression != None):
            return self.expression.eval()
        return

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
        pass

"""
Quantum Types
"""

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

"""
Classical Types
"""
class TYPE:
    """
    Internal base class for simple types.
    """
    def __init_subclass__(cls, ttype, t2=""):
        cls.ttype = ttype
    
    def eval(cls):
        if(type(cls.ttype) not in [type(""), type(0), type(0.1)]):
            return cls.ttype.eval()
        return cls.ttype

class BitType(TYPE, ttype='bit'):
    """
    bitType = 
    | 'bit'
    | 'creg'
    """
    pass
class SingleDesignatorType(TYPE, ttype="int"):
    """
    singleDesignatorType = 
    | 'int'
    | 'uint'
    | 'float'
    | 'angle'
    """
    pass

class NoDesignatorType(TYPE, ttype='bool'):
    """
    noDesignatorType = 
    | 'bool'
    | timingType
    """
    pass

class ClassicalType:
    """
    ClassicalType =
    | noDesignatorType
    | singleDesignatorType designator
    | bitType designator?
    | 'complex' [ numericType ]
    """
    def __init__(self, ctype, designator=None, numericType=None):
        self.ctype = ctype
        self.designator = designator
        self.numeric = numericType

    def eval(self):
        if(self.ctype != None):
            if(type(self.ctype) == type(SingleDesignatorType)):
                pass
            elif(self.designator==None):
                if(self.ctype=="bool"):
                    return bool
                else:
                    return self.ctype.eval()
            
        else:
            return None
        if(self.ctype == 'complex'):
            return self.numeric.eval()
        return self.ctype.eval(), self.designator

"""
Numeric OpenQASM Types
"""
class NumericType:
    """
    numericType = 
    | singleDesignatorType designator
    """
    def __init__(self, singleDesignatorType, designator):
        self.ttype = singleDesignatorType
        self.designator = designator

    def eval(self):
        return self.ttype.eval(), self.designator

class ConstantDeclaration:
    """
    constantDeclaration
    | 'const' Identifier equalsExpression
    """
    def __init__(self, ident, exp):
        self.id = ident
        self.exp = exp
        self.id.setValue = self.exp

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
        return

class NoDesignatorDeclaration(ClassicalDeclarationStatement):
    """
    noDesignatorDeclaration = 
    | noDesignatorType Identifier equalsExpression?
    """
    def __init__(self, dtype, identifier, expression):
        self.dtype = dtype
        self.id = identifier
        self.exp = expression

    def eval(self):
        try:
            d = self.dtype.eval()
            id = self.id.eval()
            exp = self.exp.eval()
            return d,id,exp
        except:
            return
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
        print(self.id.eval(), self.designator, self.ttype, self.exp)

class ComplexDeclaration(ClassicalDeclarationStatement):
    """
    complexDeclaration = 
    | 'complex' [ numericType ] Identifier equalsExpression?
    """
    def __init__(self, identifier, numericType, expression):
        self.id = identifier
        self.num = numericType
        self.exp = expression

class ClassicalTypeList:
    """
    classicalTypeList = 
    | classicalType,
    | classicalType, classicalType...
    """
    def __init__(self, classicalTypes):
        self.list = classicalTypes
    
    def eval(self):
        return [x.eval for x in self.list]

class AnyTypeArgument:
    """
    anyTypeArgument = 
    | classicalArgument
    | quantumArgument
    """
    def __init__(self, argument):
        self.arg = argument

    def eval(self):
        return self.arg.eval()

"""
Aliasing
"""
class AliasStatment:
    """
    aliasStatement = 
    | 'let' Identifier = indexIdentifier;
    """
    def __init__(self, identifier, indexIdentifier):
        self.id = identifier
        self.value = indexIdentifier

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
    def __init__(self, identifier, expressionList=None, indexId1=None, indexId2=None):
        self.id = identifier
        self.expList = expressionList
        self.index1 = indexId1
        self.index2 = indexId2

class IndexIdentifierList:
    """
    indexIdentifierList =
    | indexIdentifier,
    | indexIdentifier, indexIdentifier...
    """
    def __init__(self, indexIdList):
        self.idList = indexIdList

    def eval(self):
        return [x.eval() for x in self.idList]

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

"""
Gates & Built-In Quantum Instructions
"""
class QuantumGateDefinition(GlobalStatement):
    """
    quantumGateDefinition = 
    | 'gate' quantumGateSignature quantumBlock
    """
    def __init__(self, signature, block):
        self.signature = signature
        self.block = block

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
        print(self.name.eval(), self.ids, self.params)
        return self.name

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
        if(type(self.id) != type("") and type(self.id) != type(None)):
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
        print(self.statements, self.loops)
        return self.statements

class QuantumLoop:
    """
    quantumLoop = 
    | loopSignature quantumLoopBlock
    """
    def __init__(self, loopSignature, quantumLoopBlock):
        self.signature = loopSignature
        self.block = quantumLoopBlock

class QuantumLoopBlock:
    """
    quantumLoopBlock = 
    | quantumStatement
    | { quantumStatement* }
    """
    def __init__(self, statements):
        self.statements = statements

class QuantumStatement(Statement):
    """
    quantumStatement =
    | quantumInstruction ;
    | timingStatement
    """
    def __init__(self, quantumInstruction=None, timingStatement=None):
        self.quantumInstruction = quantumInstruction
        self.timingStatement = timingStatement

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
        if(self.instruction != None):
            return self.instruction.eval()

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
        print(self.exp.eval(), self.indexId.eval())
        return self.exp.eval(), self.indexId.eval()

class QuantumReset(QuantumInstruction):
    """
    quantumReset = 
    | 'reset' indexIdentifierList
    """
    def __init__(self, indexIdentifierList):
        self.indexId = indexIdentifierList

class QuantumMeasurement(QuantumInstruction):
    """
    quantumMeasurement = 
    | 'measure' indexIdentifier
    """
    def __init__(self, indexIdentifier):
        self.indexId = indexIdentifier

class QuantumMeasurementAssignment(QuantumInstruction):
    """
    quantumMeasurementAssignment = 
    | quantumMeasurement -> indexIdentifier?
    | indexIdentifier = quantumMeasurement
    """
    def __init__(self, qmeas, indexId):
        self.indexId = indexId

    def eval(self):
        return self.indexId

class QuantumBarrier(QuantumInstruction):
    """
    quantumBarrier = 
    | 'barrier' indexIdentifierList?
    """
    def __init__(self, indexIdentifierList):
        self.indexId = indexIdentifierList
    def eval(self):
        return [x.eval() for x in self.indexId]

class QuantumGateModifier:
    """The base class for quantum gate modifiers.
    quantumGateModifier = 
    | 'inv' '@'
    | powModifier '@'
    | ctrlModifier '@'
    """
    def __init__(self, modifier):
        self.mod = modifier

    def eval(self):
        return self.mod.eval()

class PowModifier(QuantumGateModifier):
    """
    powModifier = 
    | 'pow' ( expression )
    """
    def __init__(self, expression):
        self.mod = 'pow'
        self.exp = expression

class CtrlModifier(QuantumGateModifier):
    """
    ctrlModifier = 
    | 'ctrl' ( expression )
    | 'negctrl' ( expression )
    """
    def __init__(self, expression, neg=False):
        if(neg):
            self.mod = 'negctrl'
        else:
            self.mod = 'ctrl'
        self.exp = expression

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

"""
Classical Instructions
"""
class ExpressionStatement:
    """
    expressionStatement = 
    | expression ;
    """
    def __init__(self, expression):
        self.exp = expression

class BaseExpression:
    """The base expression class"""

    def __init__(self, expression1, expression2=None, operator=None):
        self.exp1 = expression1
        self.exp2 = expression2
        self.op = operator
        #print(self, self.exp1, self.exp2, self.op)


    def eval(self):
        return self

class Expression(BaseExpression):
    """
    expression =
    | expressionTerminator
    | unaryExpression
    | logicalAndExpression
    | expression '||' logicalAndExpression
    """
    def __init__(self, expression, orExpression):
        self.expr = expression
        self.orxpr = orExpression

    def eval(self):
        if(type(self.orxpr) == type(None)):
            return self.expr.eval()
        else:
            try:
                a = self.expr.eval()
                b = self.orxpr.eval()
                return a or b
            except Exception as e:
                return 0

class LogicalAndExpression(BaseExpression):
    """
    logicalAndExpression = 
    | bitOrexpression
    | logicalAndExpression '&&' bitOrExpression
    """
    def eval(self):
        if(type(self.exp2) != type(None)):
            return self.exp1.eval() and self.exp2.eval()
        elif(type(self.exp1) != type(None)):
            return self.exp1.eval()
        return

class BitOrExpression(BaseExpression):
    """
    bitOrExpression =
    | xOrExpression
    | bitOrExpression '|' xOrExpression
    """
    def eval(self):
        if(type(self.exp2) != type(None)):
            return self.exp1.eval() | self.exp2.eval()
        elif(type(self.exp1) != type(None)):
            return self.exp1.eval()
        return

class XorExpression(BaseExpression):
    """
    xOrExpression = 
    | bitAndExpression
    | xOrExpressoin '^' bitAndExpression
    """
    def eval(self):
        if(type(self.exp2) != type(None)):
            return self.exp1.eval() ^ self.exp2.eval()
        elif(type(self.exp1) != type(None)):
            return self.exp1.eval()
        else:
            return

class BitAndExpression(BaseExpression):
    """
    bitAndExpression = 
    | equalityExpression
    | bitAndExpression '&' equalityExpression
    """
    def eval(self):
        if(type(self.exp2) != type(None)):
            return self.exp1.eval() & self.exp2.eval()
        elif(type(self.exp1) != type(None)):
            return self.exp1.eval()
        else:
            return

class EqualityExpression(BaseExpression):
    """
    equalityExpression = 
    | comparisonExpression
    | equalityExpression == comparisonExpression
    | equalityExpression != comparisonExpression
    """
    def eval(self):
        if(type(self.exp2) != type(None) and type(self.exp1) != type(None)):
            if(self.op == "!="):
                return self.exp1.eval() != self.exp2.eval()
            else:
                return self.exp1.eval() == self.exp2.eval()
        elif(type(self.exp1) != type(None)):
            return self.exp1.eval()
        else:
            return

class ComparisonExpression(BaseExpression):
    """
    comparisonExpression =
    | bitShiftExpression
    | comparisonExpression (<|>|>=|<=) bitShiftExpression
    """
    def eval(self):
        if(type(self.exp2) != type(None)):
            if(self.op == "<"):
                return self.exp1.eval() < self.exp2.eval()
            elif(self.op == ">"):
                return self.exp1.eval() > self.exp2.eval()
            elif(self.op == ">="):
                return self.exp1.eval() >= self.exp2.eval()
            elif(self.op == "<="):
                return self.exp1.eval() <= self.exp2.eval()
        elif(type(self.exp1) != type(None)):
            return self.exp1.eval()
        else:
            return

class BitShiftExpression(BaseExpression):
    """
    bitShiftExpression = 
    | additiveExpression
    | bitShiftExpression ( '<<' | '>>' ) additiveExpression
    """
    def eval(self):
        if(type(self.exp2) != type(None)):
            if(self.op == "<<"):
                return self.exp1.eval() << self.exp2.eval()
            else:
                return self.exp1.eval() >> self.exp2.eval()
        elif(type(self.exp1) != type(None)):
            return self.exp1.eval()
        else:
            return

class AdditiveExpression(BaseExpression):
    """
    additiveExpression = 
    | multiplicativeExpression
    | additiveExpression ( + | - ) multiplicativeExpression
    """
    def eval(self):
        if(type(self.exp2) != type(None) and type(self.exp1) != type(None)):
            if(self.op == '-'):
                return self.exp1.eval() - self.exp2.eval()
            elif(self.op == '+'):
                return self.exp1.eval() + self.exp2.eval()
        elif(type(self.exp1) != type(None)):
            #print("TYPE", type(self.exp1))
            return self.exp1.eval()
        else:
            return

class MultiplicativeExpression(BaseExpression):
    """
    multiplicativeExpression = 
    | powerExpression
    | unaryExpression
    | multiplicativeExpression ( * | / | % ) powerExpression
    | multiplicativeExpression ( * | / | % ) unaryExpression
    """
    def eval(self):
        if(type(self.exp2) != type(None)):
            if (self.op == "*"):
                return self.exp1.eval() * self.exp2.eval()
            elif(self.op == "/"):
                return self.exp1.eval() / self.exp2.eval()
            elif(self.op == "%"):
                return eslf.exp1.eval() % self.exp2.eval()
        elif(type(self.exp1) != type(None)):
            return self.exp1.eval()
        else:
            return None

class UnaryExpression(BaseExpression):
    """
    unaryExpression =
    | unaryOperator powerExpression
    """
    def eval(self):
        if(self.op == '~'):
            return self.exp1.eval() + 1
        elif(self.op == '!'):
            return not self.exp1.eval()
        elif(self.op == '-'):
            return self.exp1.eval() * -1

class PowerExpression(BaseExpression):
    """
    powerExpression
    | expressionTerminator
    | expressionTerminator '**' powerExpression
    """
    def eval(self):
#        print(self.exp1, self.exp2)
        if(type(self.exp2) != type(None)):
            return self.exp1.eval() ** self.exp2.eval()
        elif(type(self.exp1) != type(None)):
            return self.exp1.eval()
        else:
            return


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
    def __init__(self, value):
        #print(value)
        self.value = value
        self._valueDecoder()

    def _valueDecoder(self):
        vtype = type(self.value)
        if("antlr4.tree.Tree.TerminalNodeImpl" in str(vtype)):
            self.value = self.value.getText()
            if(self.value in ['pi','PI','π']):
                self.value = 3.141519
            elif(self.value in ['tau', 'TAU', '𝜏']):
                self.value = 3.141519 * 2.0
            elif(self.value in ['euler', 'EULER', 'ℇ']):
                self.value = 2.71828
            else:
                if(int(self.value) == float(self.value)):
                    self.value = int(self.value)
                else:
                    self.value = float(self.value)

    def eval(self):
        if(type(self.value) in [type(0), type(0.5), type("")]):
            return self.value
        elif(type(self.value)==type(None)):
            return
        else:
            return self.value.eval()

class BooleanLiteral(Variable, value='true', ttype=bool):
    """
    booleanLiteral =
    | 'true'
    | 'false'
    """
    def eval(self):
        if(self.value == 'true'):
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
        print(self.op, self.expList)
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
        return self

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
        return [x.eval() for x in self.expressions]

class EqualsExpression:
    """
    equalsExpression = 
    | = expression
    """
    def __init__(self, expression):
        self.exp = expression

    def eval(self):
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
        if(type(self.op) == type("")):
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
        if(self.id != None):
            return self.id.eval()
        if(self.exp != None):
            return self.exp.eval()
        if(self.range != None):
            return self.range.eval()
        else:
            return None

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
        self.statements.eval()

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
        pass

class LoopSignature:
    """
    loopSignature = 
    | 'for' Identifier 'in' setDeclaration
    | 'while' ( expression )
    """
    def __init__(self, op, id=None, exp=None, decl=None):
        self.id = id
        self.exp = exp
        self.decl = decl

    def eval(self):
        pass

class LoopStatement(Statement):
    """
    loopStatement =
    | loopSignature programBlock
    """
    def __init__(self, signature, block):
        self.signature = signature
        self.block = block

    def eval(self):
        pass

class EndStatement(Statement):
    """
    endStatement =
    | 'end' ;
    """
    def eval(self):
        return

class ReturnStatement(Statement):
    """
    returnStatement =
    | 'return' expression ;
    | 'return' quantumMeasurement ;
    """
    def __init__(self, retval):
        self.retval = retval

    def eval(self):
        return retval.eval()

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
        if(self.directive == 'break'):
            pass
        if(self.directive == 'continue'):
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
        pass

class ExternOrSubroutineCall:
    """
    externOrSubroutingCall =
    | Identifier ( expressionList? )
    """
    def __init__(self, id, expList):
        self.id = id
        self.expList = expList

    def eval(self):
        return self.expList.eval()

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
        pass

class SubroutineBlock:
    """
    subroutineBlock =
    | { statement* returnStatement? }
    """
    def __init__(self, statement, ret):
        self.statement = statement
        self.ret = ret

    def eval(self):
        pass

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

class TimingType(TYPE, ttype='duration'):
    """
    timingType = 
    | 'duration'
    | 'stretch'
    """
    pass

class TimingBox:
    """
    timingBox =
    | 'box' designator quantumBlock
    """
    def __init__(self, designator, qblock):
        self.des = designator
        self.block = qblock

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
        pass

class TimingInstructionName(TYPE, ttype='delay'):
    """
    timingInstructionName =
    |'delay'
    |'rotary'
    """
    pass

class TimingInstruction:
    """
    timingInstruction =
    | timingInstrucionName designator indexIdentifierList
    | timingInstructionName ( expressionList ) designator indexIdentifierList
    """
    def __init__(self, designator, indexIdList, expressionlist=None):
        self.designator = designator
        self.idxIdList = indexIdList
        self.expList = expressionlist

    def eval(self):
        pass

class TimingStatement:
    """
    TimingStatement = 
    | timingInstruction ;
    | timingBox
    """
    def __init__(self, statement):
        self.statement = statement

    def eval(self):
        self.statement.eval()


class Identifier:
    """
    The Identifier class
    """
    def __init__(self, id):
        self.id = id.getText()

    def eval(self):
        return self.id