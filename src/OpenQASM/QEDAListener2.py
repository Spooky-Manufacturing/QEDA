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

from .ad import *


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
        self.GATES = []
        self.file = "/" + self.file.strip("/")
        self.currentModifier = None
        self.modExpression = None

    def enterProgram(self, ctx: qasm3Parser.ProgramContext):
        self.HEADER=self.enterHeader(ctx.header())
        self.GLOBALS=[] # Global Statements
        self.LOCALS=[] # Localized Statements
        i=0
        while True:
            if(ctx.statement(i) != None):
                x = self.enterStatement(ctx.statement(i))
                if(x!=None):
                    self.LOCALS.append(x.eval())
            else:
                break
            i+=1
        i=0
        while True:
            if(ctx.globalStatement(i) != None):
                x = self.enterGlobalStatement(ctx.globalStatement(i))
                if(x!=None):
                    self.GLOBALS.append(x.eval())
            else:
                break
            i+=1
        x = Program(self.HEADER, self.GLOBALS, self.LOCALS)
        x.eval()

    # Enter a parse tree produced by qasm3Parser#header.
    def enterHeader(self, ctx:qasm3Parser.HeaderContext):
        pass

    # Enter a parse tree produced by qasm3Parser#version.
    def enterVersion(self, ctx:qasm3Parser.VersionContext):
        pass

    # Enter a parse tree produced by qasm3Parser#header.
    def enterInclude(self, ctx: qasm3Parser.IncludeContext):
        return super().enterInclude(ctx)

        # Enter a parse tree produced by qasm3Parser#ioIdentifier.
    def enterIoIdentifier(self, ctx:qasm3Parser.IoIdentifierContext):
        txt = ctx.getText()
        io = 'input'
        if('input' in txt):
            io='input'
        elif('output' in txt):
            io='output'
        return IoIdentifier(io)
        pass

    # Enter a parse tree produced by qasm3Parser#io.
    def enterIo(self, ctx:qasm3Parser.IoContext):
        io = self.enterIoIdentifier(ctx.ioIdentifier())
        ctype = self.enterClassicalType(ctx.classicalType())
        id = self.enterIdentifier(ctx.Identifier())
        return Io(io, ctype, id)
        pass

    # Enter a parse tree produced by qasm3Parser#globalStatement.
    def enterGlobalStatement(self, ctx:qasm3Parser.GlobalStatementContext):
        if(ctx.subroutineDefinition()!=None):
            return self.enterSubroutineDefinition(ctx.subroutineDefinition())
        elif(ctx.externDeclaration()!=None):
            return self.enterExternDeclaration(ctx.externDeclaration())
        elif(ctx.quantumGateDefinition()!=None):
            return self.enterQuantumGateDefinition(ctx.quantumGateDefinition())
        elif(ctx.calibration()!=None):
            return self.enterCalibration(ctx.calibration())
        elif(ctx.quantumDeclarationStatement()!=None):
            return self.enterQuantumDeclarationStatement(ctx.quantumDeclarationStatement())
        elif(ctx.pragma()!=None):
            return self.enterPragma(ctx.pragma())
        else:
            raise ValueError("Error in globalStatement with context\ntype: {}\nvalue: {}".format(type(ctx),ctx))

    # Enter a parse tree produced by qasm3Parser#statement.
    def enterStatement(self, ctx:qasm3Parser.StatementContext):
        if(ctx.expressionStatement()!=None):
            return self.enterExpressionStatement(ctx.expressionStatement())
        elif(ctx.assignmentStatement()!=None):
            return self.enterAssignmentStatement(ctx.assignmentStatement())
        elif(ctx.classicalDeclarationStatement()!=None):
            return self.enterClassicalDeclarationStatement(ctx.classicalDeclarationStatement())
        elif(ctx.branchingStatement()!=None):
            return self.enterBranchingStatement(ctx.branchingStatement())
        elif(ctx.loopStatement()!=None):
            return self.enterLoopStatement(ctx.loopStatement())
        elif(ctx.endStatement()!=None):
            return self.enterEndStatement(ctx.endStatement())
        elif(ctx.aliasStatement()!=None):
            return self.enterAliasStatement(ctx.aliasStatement())
        elif(ctx.quantumStatement()!=None):
            return self.enterQuantumStatement(ctx.quantumStatement())
        else:
            raise ValueError("Error in enterStatement with context\ntype: {}\nvalue: {}".format(type(ctx),ctx))

    # Enter a parse tree produced by qasm3Parser#quantumDeclarationStatement.
    def enterQuantumDeclarationStatement(self, ctx:qasm3Parser.QuantumDeclarationStatementContext):
        return QuantumDeclarationStatement(self.enterQuantumDeclaration(ctx.quantumDeclaration()))

    # Enter a parse tree produced by qasm3Parser#classicalDeclarationStatement.
    def enterClassicalDeclarationStatement(self, ctx:qasm3Parser.ClassicalDeclarationStatementContext):
        stmt = None
        if(ctx.classicalDeclaration()!=None):
            stmt = self.enterClassicalDeclaration(ctx.classicalDeclaration())
        elif(ctx.constantDeclaration()!=None):
            stmt = self.enterConstantDeclaration(ctx.constantDeclaration())
        else:
            return
        return ClassicalDeclarationStatement(stmt)

    # Enter a parse tree produced by qasm3Parser#classicalAssignment.
    def enterClassicalAssignment(self, ctx:qasm3Parser.ClassicalAssignmentContext):
        id = self.enterIdentifier(ctx.Identifier())
        op = self.enterAssignmentOperator(ctx.assignmentOperator())
        exp=None
        if(ctx.expression()!=None):
            exp = self.enterExpression(ctx.expression())
        des = None
        if(ctx.designator()!=None):
            des = self.enterDesignator(ctx.designator())
        return ClassicalAssignment(id, des, op, exp)

    # Enter a parse tree produced by qasm3Parser#assignmentStatement.
    def enterAssignmentStatement(self, ctx:qasm3Parser.AssignmentStatementContext):
        assign = None
        if(ctx.classicalAssignment()!=None):
            assign=self.enterClassicalAssignment(ctx.classicalAssignment())
        elif(ctx.quantumMeasurementAssignment()!=None):
            assign=self.enterQuantumMeasurementAssignment(ctx.quantumMeasurementAssignment())
        else:
            return
        return AssignmentStatement(assign)
        
    # Enter a parse tree produced by qasm3Parser#returnSignature.
    def enterReturnSignature(self, ctx:qasm3Parser.ReturnSignatureContext):
        ctype = self.enterClassicalType(ctx.classicalType())
        return ReturnSignature(ctype)

    def enterDesignator(self, ctx:qasm3Parser.DesignatorContext):
        exp = self.enterExpression(ctx.expression())
        des = Designator(exp)
        return des

    # Enter a parse tree produced by qasm3Parser#identifierList.
    def enterIdentifierList(self, ctx:qasm3Parser.IdentifierListContext):
        ids = []
        x=0
        while True:
            if(ctx.Identifier(x) != None):
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
        if('qreg' in ctx.getText()):
            qtype='qreg'
        if(ctx.designator()!=None):
            ids=self.enterDesignator(ctx.designator())
        return QuantumDeclaration(id, ids, qtype)

    # Enter a parse tree produced by qasm3Parser#quantumArgument.
    def enterQuantumArgument(self, ctx:qasm3Parser.QuantumArgumentContext):
        qtype='qubit'
        id=self.enterIdentifier(ctx.Identifier())
        ids=None
        if('qreg' in ctx.getText()):
            qtype='qreg'
        if(ctx.designator()!=None):
            ids=self.enterDesignator(ctx.designator())
        return QuantumArgument(id, ids, qtype)

    # Enter a parse tree produced by qasm3Parser#quantumArgumentList.
    def enterQuantumArgumentList(self, ctx:qasm3Parser.QuantumArgumentListContext):
        args = []
        if(ctx.quantumArgument()!=None):
            i=0
            while True:
                if(ctx.quantumArgument(i)!=None):
                    args.append(self.enterQuantumArgument(ctx.quantumArgument(i)))
                else:
                    break
                i+=1
        return QuantumArgumentList(args)

    # Enter a parse tree produced by qasm3Parser#bitType.
    def enterBitType(self, ctx:qasm3Parser.BitTypeContext):
        bt = BitType()
        bt.ttype = ctx.getText()
        return bt


    # Enter a parse tree produced by qasm3Parser#singleDesignatorType.
    def enterSingleDesignatorType(self, ctx:qasm3Parser.SingleDesignatorTypeContext):
        sdt = SingleDesignatorType()
        sdt.ttype = ctx.getText()
        return sdt

    # Enter a parse tree produced by qasm3Parser#noDesignatorType.
    def enterNoDesignatorType(self, ctx:qasm3Parser.NoDesignatorTypeContext):
        bit = None
        ctype = 'bool'
        if(ctx.timingType()):
            ctype = 'timingType'
        bit = NoDesignatorType()
        bit.ttype=ctype
        return bit

    # Enter a parse tree produced by qasm3Parser#classicalType.
    def enterClassicalType(self, ctx:qasm3Parser.ClassicalTypeContext):
        bit = None
        btype = None
        single = None
        numeric = None
        if(ctx.noDesignatorType()):
            bit = self.enterNoDesignatorType(ctx.noDesignatorType())
        elif(ctx.singleDesignatorType()):
            single = self.enterSingleDesignatorType(ctx.singleDesignatorType())
            designator = self.enterDesignator(ctx.designator())
        elif(ctx.bitType()):
            btype = self.enterBitType(ctx.bitType())
        

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
        if('bit' in txt):
            # create a bit
            ttype='bit'
        elif('creg' in txt):
            # create creg
            ttype='creg'
        id = self.enterIdentifier(ctx.Identifier())
        if(type(ctx.designator()) != type(None)):
            des = self.enterDesignator(ctx.designator())
        if(type(ctx.equalsExpression()) != type(None)):
            equ = self.enterEqualsExpression(ctx.equalsExpression())
        bitdecl = BitDeclaration(id, des, equ, ttype=ttype)
        bitdecl.eval()
        return bitdecl

    # Enter a parse tree produced by qasm3Parser#complexDeclaration.
    def enterComplexDeclaration(self, ctx:qasm3Parser.ComplexDeclarationContext):
        id=None
        exp=[]
        nType=None
        if(ctx.Identifier()!=None):
            id=self.enterIdentifier(ctx.Identifier())
        if(ctx.equalsExpression()!=None):
            i=0
            while True:
                if(ctx.equalsExpression(i)!=None):
                    exp.append(self.enterEqualsExpression(ctx.equalsExpression(i)))
                else:
                    break
                i+=1
        if(ctx.numericType()!=None):
            nType=self.enterNumericType(ctx.numericType())
        return ComplexDeclaration(id,nType,exp)

    # Enter a parse tree produced by qasm3Parser#classicalDeclaration.
    def enterClassicalDeclaration(self, ctx:qasm3Parser.ClassicalDeclarationContext):
        if(ctx.singleDesignatorDeclaration()!=None):
            return self.enterSingleDesignatorDeclaration(ctx.singleDesignatorDeclaration())
        if(ctx.noDesignatorDeclaration()!=None):
            return self.enterNoDesignatorDeclaration(ctx.noDesignatorDeclaration())
        if(ctx.bitDeclaration()!=None):
            return self.enterBitDeclaration(ctx.bitDeclaration())
        if(ctx.complexDeclaration()!=None):
            return self.enterComplexDeclaration(ctx.complexDeclaration())

    # Enter a parse tree produced by qasm3Parser#classicalTypeList.
    def enterClassicalTypeList(self, ctx:qasm3Parser.ClassicalTypeListContext):
        x = []
        if(ctx!=None and ctx.classicalType()!=None):
            i=0
            while True:
                if(ctx.classicalType(i)!=None):
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
        if('creg' in txt):
            ctxType='creg'
        elif('bit' in txt):
            ctxType='bit'
        elif('complex'in txt):
            ctxType='complex'

        if(ctx.singleDesignatorType()!=None):
            dType=self.enterSingleDesignatorType(ctx.singleDesignatorType())
        if(ctx.designator()!=None):
            des=self.enterDesignator(ctx.designator())
        if(ctx.Identifier()!=None):
            id=self.enterIdentifier(ctx.Identifier())
        return ClassicalArgument(dType, des, id, ctxType)

    # Enter a parse tree produced by qasm3Parser#classicalArgumentList.
    def enterClassicalArgumentList(self, ctx:qasm3Parser.ClassicalArgumentListContext):
        x = []
        if(ctx.classicalArgument()!=None):
            i=0
            while True:
                if(ctx.classicalArgument(i)!=None):
                    x.append(self.enterClassicalArgument(ctx.classicalArgument(i)))
                else:
                    break
                i+=1
        return ClassicalArgumentList(x)

    # Enter a parse tree produced by qasm3Parser#anyTypeArgument.
    def enterAnyTypeArgument(self, ctx:qasm3Parser.AnyTypeArgumentContext):
        arg = None
        if(ctx.classicalArgument()!=None):
            arg=self.enterClassicalArgument(ctx.classicalArgument())
        elif(ctx.quantumArgument()!=None):
            arg=self.enterQuantumArgument(ctx.quantumArgument())
        return AnyTypeArgument(arg)

    # Enter a parse tree produced by qasm3Parser#anyTypeArgumentList.
    def enterAnyTypeArgumentList(self, ctx:qasm3Parser.AnyTypeArgumentListContext):
        x=[]
        if(ctx.anyTypeArgument()!=None):
            i=0
            while True:
                if(ctx.anyTypeArgument(i)!=None):
                    x.append(self.enterAnyTypeArgument(ctx.anyTypeArgument(i)))
                else:
                    break
                i+=1
        return AnyTypeArgumentList(x)
    
    # Enter a parse tree produced by qasm3Parser#aliasStatement.
    def enterAliasStatement(self, ctx:qasm3Parser.AliasStatementContext):
        id=None
        value=None
        if(ctx.Identifier()!=None):
            id=self.enterIdentifier(ctx.Identifier())
        if(ctx.indexIdentifier()!=None):
            value=self.enterIndexIdentifier(ctx.indexIdentifier())
        return AliasStatement(id, value)
    
    # Enter a parse tree produced by qasm3Parser#indexIdentifier.
    def enterIndexIdentifier(self, ctx:qasm3Parser.IndexIdentifierContext):
        id=None
        indexes=[]
        exp=[]
        rangeDef=None
        if(ctx.Identifier()!=None):
            id=self.enterIdentifier(ctx.Identifier())
        if(ctx.indexIdentifier()!=None):
            i=0
            while True:
                if(ctx.indexIdentifier(i)!=None):
                    indexes.append(self.enterIndexIdentifier(ctx.indexIdentifier(i)))
                else:
                    break
                i+=1
        if(ctx.expressionList()!=None):
            exp=self.enterExpressionList(ctx.expressionList())
        if(ctx.rangeDefinition()!=None):
            rangeDef=self.enterRangeDefinition(ctx.rangeDefinition())
        return IndexIdentifier(id, exp, indexes, rangeDef)
    
    # Enter a parse tree produced by qasm3Parser#indexIdentifierList.
    def enterIndexIdentifierList(self, ctx:qasm3Parser.IndexIdentifierListContext):
        ids=[]
        if(ctx.indexIdentifier()!=None):
            if(len(ctx.indexIdentifier())>0):
                i=0
                while True:
                    if(ctx.indexIdentifier(i)):
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
        if(ctx.expression()!=None):
            if(ctx.expression(1)!=None):
                exp1=self.enterExpression(ctx.expression(1))
            if(ctx.expression(2)!=None):
                exp2=self.enterExpression(ctx.expression(2))
            if(ctx.expression(3)!=None):
                exp3=self.enterExpression(ctx.expression(3))
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
        if(ctx.identifierList(0)):
            params = self.enterIdentifierList(ctx.identifierList(0))
        if(ctx.identifierList(1)):
            ids = self.enterIdentifierList(ctx.identifierList(1))
        qgs = QuantumGateSignature(gateName=name, identifiers=ids, parameters=params)
        if(qgs != None and qgs.eval() != None):
            return qgs
        return
    
    # Enter a parse tree produced by qasm3Parser#quantumGateName.
    def enterQuantumGateName(self, ctx:qasm3Parser.QuantumGateNameContext):
        return QuantumGateName(ctx.getText())

    # Enter a parse tree produced by qasm3Parser#quantumBlock.
    def enterQuantumBlock(self, ctx:qasm3Parser.QuantumBlockContext):
        stmts = []
        loops = []
        if(len(ctx.quantumStatement()) > 0):
            i=0
            while True:
                if(ctx.quantumStatement(i)!=None):
                    stmts.append(self.enterQuantumStatement(ctx.quantumStatement(i)))
                else:
                    break
                i+=1
        if(len(ctx.quantumLoop()) > 0):
            i=0
            while True:
                if(ctx.quantumLoop(i)!=None):
                    loops.append(self.enterQuantumLoop(ctx.quantumLoop(i)))
                else:
                    break
                i+=1
        block = QuantumBlock(statements=stmts, loops=loops)
        if(block != None and block.eval() != None):
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
            if(ctx.quantumStatement(i) != None):
                stmt.append(self.enterQuantumStatement(ctx.quantumStatement(i)))
                i+=1
            else:
                break
        return QuantumLoopBlock(statements=stmt)

    # Enter a parse tree produced by qasm3Parser#quantumStatement.
    def enterQuantumStatement(self, ctx:qasm3Parser.quantumStatement):
        ins = None
        if(ctx.quantumInstruction() != None):
            ins = self.enterQuantumInstruction(ctx.quantumInstruction())
        tim = None
        if(ctx.timingStatement() != None):
            tim = self.enterTimingStatement(ctx.timingStatement())
        qs = None
        if(ins != None):
            qs = QuantumStatement(quantumInstruction=ins)
        elif(tim != None):
            qs = QuantumStatement(timingStatement=tim)
        else:
            return
        return qs

    # Enter a parse tree produced by qasm3Parser#quantumInstruction.
    def enterQuantumInstruction(self, ctx:qasm3Parser.quantumInstruction):
        ins = None
        if(ctx.quantumGateCall() != None):
            ins = self.enterQuantumGateCall(ctx.quantumGateCall())
        elif(ctx.quantumPhase() != None):
            ins = self.enterQuantumPhase(ctx.quantumPhase())
        elif(ctx.quantumMeasurement() != None):
            ins = self.enterQuantumMeasurement(ctx.quantumMeasurement())
        elif(ctx.quantumReset() != None):
            ins = self.enterQuantumReset(ctx.quantumReset())
        elif(ctx.quantumBarrier() != None):
            ins = self.enterQuantumBarrier(ctx.quantumBarrier())
        else:
            return
        return QuantumInstruction(ins)
   
    # Enter a parse tree produced by qasm3Parser#quantumPhase.
    def enterQuantumPhase(self, ctx:qasm3Parser.quantumPhase):
        mods = []
        exp = None
        idList = None
        if(ctx.quantumGateModifier() != None):
            i = 0
            while True:
                if(ctx.quantumGateModifier(i) != None):
                    mods.append(self.enterQuantumGateModifier(ctx.quantumGateModifier(i)))
                else:
                    break
                i+=1 
        exp = self.enterExpression(ctx.expression())
        idList=None
        if(ctx.indexIdentifierList()!=None):
            idList = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        qp = QuantumPhase(exp, idList, modifiers=mods)
        if(qp != None and qp.eval() != None):
            return qp
        return

    # Enter a parse tree produced by qasm3Parser#quantumReset
    def enterQuantumReset(self, ctx:qasm3Parser.quantumReset):
        idList = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        return QuantumReset(idList)

    # Enter a parse tree produced by qasm3Parser#quantumMeasurement
    def enterQuantumMeasurement(self, ctx:qasm3Parser.quantumMeasurement):
        id = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        return QuantumMeasurement(id)

    # Enter a parse tree produced by qasm3Parser#quantumMeasurementAssignment
    def enterQuantumMeasurementAssignment(self, ctx:qasm3Parser.quantumMeasurementAssignment):
        qmeas = self.enterQuantumMeasurement(ctx.quantumMeasurement())
        id=None
        if(ctx.indexIdentifierList()!=None):
            id = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        return QuantumMeasurementAssignment(qmeas, id)

    # Enter a parse tree produced by qasm3Parser#quantumBarrier
    def enterQuantumBarrier(self, ctx:qasm3Parser.quantumBarrier):
        idl = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        return QuantumBarrier(idl)

    # Enter a parse tree produced by qasm3Parser#quantumGateModifier
    def enterQuantumGateModifier(self, ctx:qasm3Parser.quantumGateModifier):
        mod = None
        if(ctx.powModifier() != None):
            mod = self.enterPowModifier(ctx.powModifier())
        if(ctx.ctrlModifier() != None):
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
        if('neg' in txt):
            neg=True
        if(ctx.expression() != None):
            exp = self.enterExpression(ctx.expression())
        return CtrlModifier(exp, neg)
    
    # Enter a parse tree produced by qasm3Parser#quantumGateCall
    def enterQuantumGateCall(self, ctx:qasm3Parser.quantumGateCall):
        name = self.enterQuantumGateName(ctx.quantumGateName())
        ids = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        exp = None
        mod = []
        if(ctx.expressionList() != None):
            exp = self.enterExpressionList(ctx.expressionList())
        if(len(ctx.quantumGateModifier())>0):
            i=0
            while True:
                if(ctx.quantumGateModifier(i) != None):
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
        if(ctx.expressionTerminator()!=None):
            return self.enterExpressionTerminator(ctx.expressionTerminator())
        elif(ctx.unaryExpression()!=None):
            return self.enterUnaryExpression(ctx.unaryExpression())
        elif(ctx.expression()!=None):
            exp1 = self.enterExpression(ctx.expression())
            orxp = None
            if(ctx.logicalAndExpression()!=None):
                orxp = self.enterLogicalAndExpression(ctx.logicalAndExpression())
            return Expression(exp1, orxp)
        elif(ctx.logicalAndExpression()):
            return self.enterLogicalAndExpression(ctx.logicalAndExpression())       

    # Enter a parse tree produced by qasm3Parser#logicalAndExpression.
    def enterLogicalAndExpression(self, ctx:qasm3Parser.LogicalAndExpressionContext):
        log = None
        exp1 = None
        exp2 = None
        op = '&&'
        if(type(ctx.logicalAndExpression()) != type(log)):
            exp1 = self.enterLogicalAndExpression(ctx.logicalAndExpression())
            exp2 = self.enterBitOrExpression(ctx.bitOrExpression())
        elif(type(ctx.bitOrExpression()) != type(log)):
            exp1 = self.enterBitOrExpression(ctx.bitOrExpression())
        else:
            return
        log = LogicalAndExpression(expression1=exp1, expression2=exp2, operator=op)
        if(log != None and log.eval() != None):
            return log
        else:
            return

    # Enter a parse tree produced by qasm3Parser#bitOrExpression.
    def enterBitOrExpression(self, ctx:qasm3Parser.BitOrExpressionContext):
        bit = None
        exp1 = None
        exp2 = None
        op = '|'
        if(type(ctx.bitOrExpression()) != type(None)):
            exp1 = self.enterBitOrExpression(ctx.bitOrExpression())
            exp2 = self.enterXOrExpression(ctx.xOrExpression())
        elif(type(ctx.xOrExpression()) != type(None)):
            exp1 = self.enterXOrExpression(ctx.xOrExpression())
        else:
            return
        bit = BitOrExpression(expression1=exp1, expression2=exp2, operator=op)
        if(bit != None and bit.eval() != None):
            return bit
        else:
            return


    # Enter a parse tree produced by qasm3Parser#xOrExpression.
    def enterXOrExpression(self, ctx:qasm3Parser.XOrExpressionContext):
        xor = None
        exp1 = None
        exp2 = None
        op = '^'
        if(type(ctx.xOrExpression()) != type(None)):
            exp1 = self.enterXOrExpression(ctx.xOrExpression())
            exp2 = self.enterBitAndExpression(ctx.bitAndExpression())
        elif(type(ctx.bitAndExpression()) != type(None)):
            exp1 = self.enterBitAndExpression(ctx.bitAndExpression())
        else:
            return
        xor = XorExpression(expression1=exp1, expression2=exp2, operator=op)
        if(xor != None and xor.eval() != None):
            return xor
        else:
            return 
    # Enter a parse tree produced by qasm3Parser#bitAndExpression.
    def enterBitAndExpression(self, ctx:qasm3Parser.BitAndExpressionContext):
        bit = None
        exp1 = None
        exp2 = None
        op = '&'
        if(type(ctx.bitAndExpression()) != type(None)):
            exp1 = self.enterBitAndExpression(ctx.bitAndExpression())
            exp2 = self.enterEqualityExpression(ctx.equalityExpression())
        elif(type(ctx.equalityExpression()) !=type(None)):
            exp1 = self.enterEqualityExpression(ctx.equalityExpression())
        else:
            return
        bit = BitAndExpression(expression1=exp1, expression2=exp2, operator=op)
        if(bit != None and bit.eval() != None):
            return bit
        else:
            return 

    # Enter a parse tree produced by qasm3Parser#equalityExpression.
    def enterEqualityExpression(self, ctx:qasm3Parser.EqualityExpressionContext):
        equ = None
        exp1 = None
        exp2 = None
        op = None
        if(type(ctx.equalityExpression()) != type(None)):
            exp1 = self.enterEqualityExpression(ctx.equalityExpression())
            exp2 = self.enterComparisonExpression(ctx.comparisonExpression())
            txt = ctx.getText()
            if("!=" in txt):
                op = "!="
            elif("==" in txt):
                op = "=="
        elif(type(ctx.comparisonExpression()) != type(None)):
            exp1 = self.enterComparisonExpression(ctx.comparisonExpression())
        else:
            return
        equ = EqualityExpression(expression1=exp1, expression2=exp2, operator=op)
        if(equ != None and equ.eval() != None):
            return equ
        else:
            return 

    # Enter a parse tree produced by qasm3Parser#comparisonExpression.
    def enterComparisonExpression(self, ctx:qasm3Parser.ComparisonExpressionContext):
        comp = None
        exp1 = None
        exp2 = None
        op = None
        if(type(ctx.comparisonExpression()) != type(comp)):
            exp1 = self.enterComparisonExpression(ctx.comparisonExpression())
            exp2 = self.enterBitShiftExpression(ctx.bitShiftExpression())
            txt = ctx.getText()
            if('<=' in txt):
                op='<='
            elif('>=' in txt):
                op='>='
            elif('<' in txt):
                op='<'
            elif('>' in txt):
                op='>'
        elif(type(ctx.bitShiftExpression()) != type(None)):
             exp1 = self.enterBitShiftExpression(ctx.bitShiftExpression())
        else:
            return

        comp = ComparisonExpression(expression1=exp1, expression2=exp2, operator=op)
        if(comp != None and comp.eval() != None):
            return comp
        else:
            return


    # Enter a parse tree produced by qasm3Parser#bitShiftExpression.
    def enterBitShiftExpression(self, ctx:qasm3Parser.BitShiftExpressionContext):
        bit = None
        exp1 = None
        exp2 = None
        op = None
        if(type(ctx.bitShiftExpression()) != type(bit)):
            exp1 = self.enterBitShiftExpression(ctx.bitShiftExpression())
            exp2 = self.enterAdditiveExpression(ctx.additiveExpression())
        else:
            exp1 = self.enterAdditiveExpression(ctx.additiveExpression())

        if('<<' in ctx.getText()):
            op = '<<'
        else: 
            op = '>>'
        bit = BitShiftExpression(expression1=exp1, expression2=exp2, operator=op)
        if(bit != None and bit.eval() != None):
            return bit
        else:
            return
    # Enter a parse tree produced by qasm3Parser#additiveExpression.
    def enterAdditiveExpression(self, ctx:qasm3Parser.AdditiveExpressionContext):
        add = None
        exp1 = None
        exp2 = None
        op = None
        
        if(type(ctx.additiveExpression()) != type(None)):
            exp1 = self.enterAdditiveExpression(ctx.additiveExpression())
            exp2 = self.enterMultiplicativeExpression(ctx.multiplicativeExpression())
            if('+' in ctx.getText()):
                op = "+"
            else:
                op = "-"
        else:
            exp1 = self.enterMultiplicativeExpression(ctx.multiplicativeExpression())
        add = AdditiveExpression(expression1=exp1, expression2=exp2, operator=op)
        if(add != None and add.eval() != None):
            return add
        else:
            return
    # Enter a parse tree produced by qasm3Parser#multiplicativeExpression.
    def enterMultiplicativeExpression(self, ctx:qasm3Parser.MultiplicativeExpressionContext):
        mul = None
        exp1 = None
        exp2 = None
        op=None
        if(type(ctx.powerExpression()) != type(mul)):
            exp1 = self.enterPowerExpression(ctx.powerExpression())
        elif(type(ctx.unaryExpression()) != type(mul)):
            exp1 = self.enterUnaryExpression(ctx.unaryExpression())

        if(type(ctx.multiplicativeExpression()) != type(mul)):
            exp2 = exp1
            exp1 = self.enterMultiplicativeExpression(ctx.multiplicativeExpression())

        if(type(ctx.MUL()) != type(mul)):
            op="*"
        elif(type(ctx.DIV()) != type(mul)):
            op = "/"
        elif(type(ctx.MOD()) != type(mul)):
            op="%"
        mul = MultiplicativeExpression(
            expression1=exp1, expression2=exp2,
            operator=op)
        if(mul != None and  mul.eval() != None):
            return mul
        else:
            return

    # Enter a parse tree produced by qasm3Parser#unaryExpression.
    def enterUnaryExpression(self, ctx:qasm3Parser.UnaryExpressionContext):
        unary = UnaryExpression(expression1=ctx.powerExpression(), operator=ctx.unaryOperator())
        return unary

    # Enter a parse tree produced by qasm3Parser#powerExpression.
    def enterPowerExpression(self, ctx:qasm3Parser.PowerExpressionContext):
        pwr = None
        term = self.enterExpressionTerminator(ctx.expressionTerminator())
        if(type(ctx.powerExpression()) != type(pwr)):
            pwr = PowerExpression(term, expression2=ctx.powerExpression(), operator="**")
        else:
            pwr = PowerExpression(term, operator="**")

        if(pwr.eval() == None):
            return None
        else:
            return pwr

    # Enter a parse tree produced by qasm3Parser#expressionTerminator.
    def enterExpressionTerminator(self, ctx:qasm3Parser.ExpressionTerminatorContext):
        term = None
        if(type(ctx.Constant()) != type(term)):
            term = ExpressionTerminator(ctx.Constant())
        elif(type(ctx.Integer) != type(term)):
            term = ExpressionTerminator(ctx.Integer())
        elif(type(ctx.RealNumber()) != type(term)):
            term = ExpressionTerminator(ctx.RealNumber())
        elif(type(ctx.ImagNumber()) != type(term)):
            term = ExpressionTerminator(ctx.ImagNumber())
        elif(type(ctx.booleanLiteral()) != type(term)):
            term = ExpressionTerminator(ctx.booleanLiteral())
        elif(type(ctx.Identifier()) != type(term)):
            term = ExpressionTerminator(self.enterIdentifier(ctx.Identifier()))
        elif(type(ctx.StringLiteral()) != type(term)):
            term = ExpressionTerminator(ctx.StringLiteral())
        elif(type(ctx.builtInCall()) != type(term)):
            term = ExpressionTerminator(self.enterBuiltInCall(ctx.builtInCall()))
        elif(type(ctx.externOrSubroutineCall()) != type(term)):
            term = ExpressionTerminator(self.enterExternOrSubroutineCall(ctx.externOrSubroutineCall()))
        elif(type(ctx.timingIdentifier()) != type(term)):
            term = ExpressionTerminator(self.enterTimingIdentifier(ctx.timingIdentifier()))
        elif(type(ctx.expression()) != type(term)):
            term = ExpressionTerminator(self.enterExpression(ctx.expression()))
        elif(type(ctx.expressionTerminator()) != type(term)):
            term = ExpressionTerminator(self.enterExpressionTerminator(ctx.expressionTerminator()))
        if(term.eval() == None):
            return None
        else:
            return term

    # Enter a parse tree produced by qasm3Parser#booleanLiteral.
    def enterBooleanLiteral(self, ctx:qasm3Parser.BooleanLiteralContext):
        pass

    # Enter a parse tree produced by qasm3Parser#builtInCall.
    def enterBuiltInCall(self, ctx:qasm3Parser.BuiltInCallContext):
        call = None
        op = None
        expList = []
        if(type(ctx.builtInMath()) != type(None)):
            op = self.enterBuiltInMath(ctx.builtInMath())
        elif(type(ctx.castOperator()) != type(None)):
            op = self.enterCastOperator(ctx.castOperator())
        else:
            return
        expList = ctx.expressionList()
        call = BuiltInCall(operation=op, expressionList=expList)
        if(call != None and call.eval() != None):
            return call
        else:
            return

    # Enter a parse tree produced by qasm3Parser#builtInMath.
    def enterBuiltInMath(self, ctx:qasm3Parser.BuiltInMathContext):
        return ctx.getText()

    # Enter a parse tree produced by qasm3Parser#castOperator.
    def enterCastOperator(self, ctx:qasm3Parser.CastOperatorContext):
        op = CastOperator(ctx.getText())

    # Enter a parse tree produced by qasm3Parser#expressionList.
    def enterExpressionList(self, ctx:qasm3Parser.ExpressionListContext):
        exp = []
        i=0
        while True:
            if(ctx.expression(i) != None):
                exp.append(self.enterExpression(ctx.expression(i)))
                i+=1
            else:
                break
        return ExpressionList(exp)

    # Enter a parse tree produced by qasm3Parser#equalsExpression.
    def enterEqualsExpression(self, ctx:qasm3Parser.EqualsExpressionContext):
        if(ctx != None):
            exp = self.enterExpression(ctx.expression())
            return EqualsExpression(exp)
        else:
            return

    # Enter a parse tree produced by qasm3Parser#assignmentOperator.
    def enterAssignmentOperator(self, ctx:qasm3Parser.AssignmentOperatorContext):
        op = ctx.getText()
        if(op == None):
            op = "=="
        return AssignmentOperator(op)

    # Enter a parse tree produced by qasm3Parser#setDeclaration.
    def enterSetDeclaration(self, ctx:qasm3Parser.SetDeclarationContext):
        id=None
        exp=None
        range=None
        if(ctx.Identifier()!=None):
            id = self.enterIdentifier(ctx.Identifier())
        if(ctx.expressionList()!=None):
            exp = self.enterExpressionList(ctx.expressionList())
        if(ctx.rangeDefinition()):
            range = self.enterRangeDefinition(ctx.rangeDefinition())
        return SetDeclaration(id, exp, range)

    # Enter a parse tree produced by qasm3Parser#programBlock.
    def enterProgramBlock(self, ctx:qasm3Parser.ProgramBlockContext):
        i=0
        stmts = []
        while True:
            if(ctx.statement(i) != None):
                stmts.append(self.enterStatement(ctx.statement(i)))
            else:
                break
            i+=1
        i=0
        while True:
            if(ctx.controlDirective(i) != None):
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
        if(ctx.programBlock(1) != None):
            block2 = self.enterProgramBlock(ctx.programBlock(1))
        return BranchingStatement(exp, block1, block2)

    # Enter a parse tree produced by qasm3Parser#loopSignature.
    def enterLoopSignature(self, ctx:qasm3Parser.LoopSignatureContext):
        id = ctx.Identifier()
        exp = None
        decl = None
        op = None
        if(ctx.expression()):
            # while loop
            exp = self.enterExpression(ctx.expression())
            op='while'
        else:
            # for loop
            decl = self.enterSetDeclaration(ctx.setDeclaration())
            op='for'
        return LoopSignature(op, id, exp, decl)

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
        if(ctx.expression() != None):
            rval = self.enterExpression(ctx.expression())
        elif(ctx.quantumMeasurement() != None):
            rval = self.enterQuantumMeasurement(ctx.quantumMeasurement())
        return ReturnStatement(rval)

    # Enter a parse tree produced by qasm3Parser#controlDirective.
    def enterControlDirective(self, ctx:qasm3Parser.ControlDirectiveContext):
        txt = ctx.getText()
        ctrl = None
        if('break' in txt):
            ctrl = 'break'
        elif('continue' in txt):
            ctrl = 'continue'
        elif(ctx.endStatement() != None):
            ctrl = self.enterEndStatement(ctx.endStatement())
        elif(ctx.returnStatement() != None):
            ctrl = self.enterReturnStatement(ctx.returnStatement())
        return ControlDirective(ctrl)

    # Enter a parse tree produced by qasm3Parser#externDeclaration
    def enterExternDeclaration(self, ctx:qasm3Parser.ExternDeclarationContext):
        id = self.enterIdentifier(ctx.Identifier())
        clist = self.enterClassicalTypeList(ctx.classicalTypeList())
        rsig = None
        if(ctx.returnSignature()!=None):
            rsig = self.enterReturnSignature(ctx.returnSignature())
        return ExternDeclaration(id, clist, rsig)

    # Enter a parse tree produced by qasm3Parser#ExternOrSubroutineCall
    def enterExternOrSubroutineCall(self, ctx:qasm3Parser.ExternOrSubroutineCallContext):
        id = self.enterIdentifier(ctx.Identifier())
        expList=None
        if(ctx.expressionList() != None):
            expList = self.enterExpressionList(ctx.expressionList())
        return ExternOrSubroutineCall(id, expList)

    # Enter a parse tree produced by qasm3Parser#subroutineDefinition
    def enterSubroutineDefinition(self, ctx:qasm3Parser.SubroutineDefinitionContext):
        id = None
        aList = None
        retSig = None
        sBlock = None
        if(ctx.Identifier() != None):
            id = self.enterIdentifier(ctx.Identifier())
        if(ctx.anyTypeArgumentList() != None):
            aList = self.enterAnyTypeArgumentList(ctx.anyTypeArgumentList())
        if(ctx.returnSignature() != None):
            retSig = self.enterReturnSignature(ctx.returnSignature())
        if(ctx.subroutineBlock() != None):
            sBlock = self.enterSubroutineBlock(ctx.subroutineBlock())

        return SubroutineDefinition(id, aList, retSig, sBlock)

    # Enter a parse tree produced by qasm3Parser#subroutineBlock
    def enterSubroutineBlock(self, ctx:qasm3Parser.SubroutineBlockContext):
        stmt = []
        retState = None
        i=0
        while True:
            if(ctx.statement(i) != None):
                stmt.append(self.enterStatement(ctx.statement(i)))
            else:
                break
            i+=1
        if(ctx.returnStatement() != None):
            retState = self.enterReturnStatement(ctx.returnStatement())
        return SubroutineBlock(stmt, retState)

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
        if(ctx.designator()):
            i=0
            while True:
                if(ctx.designator(i) != None):
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
        if("durationof" in ctx.getText()):
            if(ctx.Identifier() != None):
                id = self.enterIdentifier(ctx.Identifier())
            elif(ctx.quantumBlock() != None):
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
        idList = self.enterIndexIdentifierList(ctx.indexIdentifierList())
        expList = None
        if(ctx.expressionList() != None):
            expList = self.enterExpressionList(ctx.expressionList())
        return TimingInstruction(name, des, idList, expList)

    # Enter a parse tree produced by qasm3Parser#TimingStatement
    def enterTimingStatement(self, ctx:qasm3Parser.TimingStatementContext):
        stmt = None
        if(ctx.timingInstruction() != None):
            stmt = self.enterTimingInstruction(ctx.timingInstruction())
        elif(ctx.timingBox() != None):
            stmt = self.enterTimingBox(ctx.timingBox())
        return TimingStatement(stmt)
        