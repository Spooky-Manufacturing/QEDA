# QCode

QCode is the Intermediate Representation (IR) used by the QEDA parser to decouple the parser from synthesizer. This document is draft version 1.0 of the QCode Specification. 

## Basics

QCode is a JSON formatted representation of the Abstract Syntax Tree produced by QEDA.

```json
QCode = {
    "globals": [
        
    ],
    "locals": [
        {
            "type": "localStatement",
            "stmt": {
                "type": "quantum",
                
            }
        }
    ]
}
```



## Statements

### Core Structure

```json
{
    "type": "statementType"
}
```

### Global Statement

```json
{
    "type": "globalStatement",
    "stmt": SubroutineDefinition | ExternDeclaration | QuantumGateDefinition | Calibration | QuantumDeclarationStatement | Pragma
}
```

### Statement (local)

```json
{
    "type": "localStatement",
    "stmt": ExpressionStatement | AssignmentStatement | ClassicalDeclarationStatement | BranchingStatement | LoopStatement | EndStatement | AliasStatement | QuantumStatement
}
```

### Expression Statements

```json
{
    "type": "expression",
    "expr": Expression
}
```

### Assignment Statement

```json
{
    "type": "assignment",
    "assign":Assignment
}
```

### Classical Declaration Statement

```json
{
    "type": "classicalDeclaration",
    "decl": Declaration
}
```

### Quantum Declaration Statement

```json
{
    "type": "quantumDeclaration",
    "decl": Declaration
}
```

### Branching Statement

```json
{
    "type": "branching",
    "if": {
        "expr": Expression,
        "block": ProgramBlock
    },
    "elseblock": ProgramBlock
}
```

### Loop Statement

```json
{
    "type": "loop",
    "sig": LoopSignature,
    "block": ProgramBlock
}
```

### End Statement

```json
{
    "type": "end"
}
```

### Alias Statement

```json
{
    "type": "alias",
    "id": Identifier,
    "indexId": IndexIdentifier
}
```

### Quantum Statement

```json
{
    "type": "quantum",
    "instruction": quantumInstruction | timingStatement
}
```

### Return Statement

```json
{
    "type": "return",
    "returns": Expression | quantumMeasurement
}
```

### Timing Statement

```json
{
    "type": "timing",
    "stmt": TimingInstruction | TimingBox
}
```

## Expressions

### Core Structure

```json
{
    "type": "typeOfExpression",
    "leftExpr": Expression,
    "rightExpr": Expression (optional)
}
```

### Logical And Expression

```json
{
    "type": "logicAnd",
    "leftExpr": Expression,
    "rightExpr": Expression (optional)
}
```

### Bit Or Expression

```json
{
    "type": "bitOr",
    "leftExpr": Expression,
    "rightExpr": Expression (optional)
}
```

### X Or Expression

```json
{
    "type": "xOr",
    "leftExpr": Expression,
    "rightExpr": Expression (optional)
}
```

### Bit And Expression

```json
{
    "type": "bitAnd",
    "leftExpr": Expression,
    "rightExpr": Expression (optional)
}
```

### Equality Expression

```json
{
    "type": "equality",
    "leftExpr": Expression,
    "rightExpr": Expression (optional),
    "op": "==" or "!="
}
```

### Comparison Expression

```json
{
    "type": "comparison",
    "leftExpr": Expression,
    "rightExpr": Expression (optional),
    "op": "<" or ">" or "<=" or ">="
}
```

### Bit Shift Expression

```json
{
    "type": "bitShift",
    "leftExpr": Expression,
    "rightExpr": Expression (optional),
    "op": ">>" or "<<"
}
```

### Additive Expression

```json
{
    "type": "add",
    "leftExpr": Expression,
    "rightExpr": Expression (optional)
}
```

### Multiplicative Expression

```json
{
    "type": "mul",
    "leftExpr": Expression,
    "rightExpr": Expression (optional),
    "op": "*" or "/" or "%"
}
```

### Unary Expression

```json
{
    "type": "unary",
    "leftExpr": Expression,
    "rightExpr": Expression (optional),
    "op": "~" or "!" or "-"
}
```

### Power Expression

```json
{
    "type": "power",
    "leftExpr": Expression,
    "rightExpr": Expression (optional)
}
```

## Declarations

### Core Structure

```json
{
    "type": "declarationType",
    "decl": Classical or Quantum
}
```

### Classical Declarations

```json
{
    "type": "classic",
    "decl": (see below)
}
```

#### Core Structure

```json
{
	"type": "classicalDeclarationType",
    "id": "Identifier",
    "expr": Expression
}
```

#### No Designator Declaration

```json
{
    "type": "noDesignator",
    "id": "Identifier",
    "dtype": noDesignatorType,
    "expr": Expression
}
```

#### Single Designator Declaration

```json
{
	"type": "single",
	"id": "Identifier",
	"designator": Designator
	"expr": Expression
}
```

#### Bit Declaration

```json
{
    "type": "bit",
    "id": "Identifier",
    "designator": Designator,
    "expr": Expression
}
```

#### Register Declaration

```json
{
    "type": "register",
    "id": "Identifier",
    "designator": Designator,
    "expr": Expression
}
```

#### Complex Declaration

```json
{
    "type": "complex",
    "id": "Identifier",
    "nType": NumericType,
    "expr": Expression
}
```

#### Constant Declaration

```json
{
    "type": "constant",
    "id": "Identifier",
    "expr": Expression
}
```

### Quantum Declarations

```json
{
    "type": "quantum",
    "qtype": "qubit" or "qreg",
    "id": "Identifier",
    "designator": Designator 
}
```



## Types

### Classical Types

#### Core Structure

```json
{
    "type": "classical",
    "ctype": NoDesignatorType | SingleDesignatorType | BitType | NumericType
    "designator": Designator (optional)    
}
```

#### Bit Type

```json
{
    "type": "classical",
    "ctype": "bit" | "creg"
    "designator": Designator    
}
```

#### NoDesignatorType

```json
{
    "type": "classical",
    "ctype": "bool" | TimingType, 
}
```

#### SingleDesignatorType

```json
{
    "type": "classical",
    "ctype": "int" | "uint" | "float" | "angle",
    "designator": Designator    
}
```

#### TimingType

```json
{
    "type": "classical",
    "ctype": "duration" | "stretch"
}
```

#### Numeric Type

```json
{
    "type": "classical",
    "ctype": "int" | "uint" | "float" | "angle",
    "designator": Designator    
}
```

#### Classical Type List

```json
{
    "type": "classical",
    "ctypes": [ 
        classicalType1,
        classicalType2,
        ...
    ]
}
```

### Quantum Types

```json
{
    "type": "quantum",
}
```

## Arguments

### Any Type Argument

```json
{
    "type": "anyarg",
    "arg": ClassicalArgument | QuantumArgument
}
```

### Any Type Argument List

```json
{
    "type": "anyarglist",
    "args": [
        AnyTypeArgument1,
        AnyTypeArgument2,
        ...
    ]
}
```

### Classical Arguments

```json
{
    "type": "classicArg",
    "ctype": ClassicalType
}
```

### Classical Argument List

```json
{
    "type": "classicArgList",
    "ctypes": [
        ClassicalType1,
        ClassicalType2,
        ...
    ]
}
```

### Quantum Arguments

```json
{
    "type": "quantumArg",
    "qtype": QuantumType
}
```

### Quantum Arguments List

```json
{
    "type": "quantumArg",
    "qtype": [
        QuantumType1,
        QuantumType2,
        ...
	]
}
```

## Identifiers

### Index Identifiers

```json
{
    "type": "indexId",
    "id": "Identifier" (optional),
    "range": RangeDefinition (optional),
    "exprList": ExpressionList (optional),
    "index1": IndexIdentifier (optional),
    "index2": IndexIdentifier (optional)
}
```

### Index Identifier List

```json
{
    "type": "indexIdList",
    "indexes": [
        IndexIdentifier1,
        IndexIdentifier2,
        ...
    ]
}
```

## Object Definitions 

### Range Definition

```json
{
    "type": "rangeDef",
    "exp1": Expression,
    "exp2": Expression,
    "exp3": Expression (optional)
}
```

### Quantum Gate Definition

```json
{
    "type": "quantumGateDef",
    "sig": QuantumGateSignature,
    "block": QuantumBlock
}
```

### Subroutine Definition

```json
{
    "type": "subroutineDef",
    "id": "Identifier",
    "args": AnyTypeArgumentList,
    "retsig": ReturnSignature,
    "block": SubroutineBlock
}
```

### Calibration Definition

```json
{
    "type": "calibrationDefinition",
    "id": "Identifier",
    "cargs": CalibrationArgumentList,
    "idList": IdentifierList,
    "retSig": returnSignature,
    "body": .* (optional, any values)
}
```

## Blocks

### Quantum Block

```json
{
    "type": "quantumBlock",
    "stmts": QuantumStatement(s),
    "loops": QuantumLoop(s)
}
```

### Quantum Loop Block

```json
{
    "type": "quantumLoopBlock",
    "stmts": QuantumStatement(s)
}
```

### Program Block

```json
{
    "type": "programBlock",
    "stmts": Statement(s) | ControlDirective(s)
}
```

### Subroutine Block

```json
{
    "type": "subroutineBlock",
    "stmts": Statement,
    "ret": ReturnStatement
}
```

## Directives

## Instructions

### Quantum Instruction

```json
{
    "type": "quantumInstruction",
    "instruction": QuantumGateCall | QuantumPhase | QuantumMeasurement | QuantumReset | QuantumBarrier
}
```

### Quantum Gate Call

```json
{
    "type": "quantumGateCall",
    "gateName": quantumGateName,
    "exprList": ExpressionList,
    "indexIdList": IndexIdentifierList,
    "qgateMods": [
        QuantumGateModifier1,
        QuantumGateModifier2,
        ...
    ] (optional)
}
```

### Quantum Phase

```json
{
    "type": "quantumPhase",
    "expr": Expression,
    "indexIdList": IndexIdentifierList
    "qGateMods": [
        QuantumGateModifier1,
        QuantumGateModifier2,
        ...
    ] (optional)
}
```

### Quantum Measurement

```json
{
    "type": "measure",
    "indexId": IndexIdentifier
}
```

### Quantum Reset

```json
{
    "type": "reset",
    "indexIdList": IndexIdentifierList 
}
```

### Quantum Barrier

```json
{
    "type": "barrier",
    "indexIdList": IndexIdentifierList
}
```

## Quantum Gate Modifiers

```json
{
    'mod': 'inv' | 'pow' | 'ctrl' | 'negctrl',
    'exp': Expression (optional)
}
```

