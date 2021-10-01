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
        pass

    def enterInclude(self, ctx: qasm3Parser.IncludeContext):
        pass
        #return super().enterInclude(ctx)

    def enterQuantumGateDefinition(self, ctx: qasm3Parser.QuantumGateDefinitionContext):
        signature = ctx.quantumGateSignature()
        block = ctx.quantumBlock()
        signature = QuantumGateSignature(signature.quantumGateName(), signature.identifierList())
        if(type(block.quantumStatement(0))!=type(None)):
            block = QuantumBlock(block.quantumStatement(0))
        else:
            block = QuantumBlock(QuantumLoop(0))
        gate = QuantumGateDefinition(signature, block)
        return super().enterQuantumGateDefinition(ctx)

    # Enter a parse tree produced by qasm3Parser#expression.
    def enterExpression(self, ctx:qasm3Parser.ExpressionContext):
        exp = None
        exp1 = None
        exp2 = None
        text = ctx.getText()
        op = None
        if(type(ctx.expressionTerminator()) != type(None)):
            pass#rint(ctx.expressionTerminator(), text)


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
            term = ExpressionTerminator(ctx.Identifier())
        elif(type(ctx.StringLiteral()) != type(term)):
            term = ExpressionTerminator(ctx.StringLiteral())
        elif(type(ctx.builtInCall()) != type(term)):
            term = ExpressionTerminator(ctx.builtInCall())
        elif(type(ctx.externOrSubroutineCall()) != type(term)):
            term = ExpressionTerminator(ctx.externOrSubroutineCall())
        elif(type(ctx.timingIdentifier()) != type(term)):
            term = ExpressionTerminator(ctx.timingIdentifier())
        elif(type(ctx.expression()) != type(term)):
            term = ExpressionTerminator(ctx.expression())
        elif(type(ctx.expressionTerminator()) != type(term)):
            term = ExpressionTerminator(ctx.expressionTerminator())
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
        print("Cast Operator", ctx.getText())
        op = CastOperator(ctx.getText())
        
    
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
        if(num!=None and num.eval() != None):
            return num
        else:
            return
    
    def enterDesignator(self, ctx:qasm3Parser.DesignatorContext):
        exp = self.enterExpression(ctx.expression())
        des = Designator(exp)
        if(des != None and des.eval() != None):
            return des
        return

    # Enter a parse tree produced by qasm3Parser#singleDesignatorDeclaration.
    def enterSingleDesignatorDeclaration(self, ctx:qasm3Parser.SingleDesignatorDeclarationContext):
        des = self.enterDesignator(ctx.designator())
        sdtype = self.enterSingleDesignatorType(ctx.singleDesignatorType())
        id = self.enterIdentifier(ctx.Identifier())
        exp = self.enterEqualsExpression(ctx.equalsExpression())
        sds = SingleDesignatorDeclaration(des, id, exp)
        if(sds!=None and sds.eval() != None):
            return sds
        return
    
    
        # Enter a parse tree produced by qasm3Parser#noDesignatorDeclaration.
    def enterNoDesignatorDeclaration(self, ctx:qasm3Parser.NoDesignatorDeclarationContext):
        des = self.enterNoDesignatorType(ctx.noDesignatorType())
        id = self.enterIdentifier(ctx.Identifier())
        print(ctx.equalsExpression())
        exp = self.enterEqualsExpression(ctx.equalsExpression())
        nd = NoDesignatorDeclaration(des, id, exp)
        if(nd!=None and nd.eval() != None):
            return nd
        return

    # Enter a parse tree produced by qasm3Parser#bitDeclaration.
    def enterBitDeclaration(self, ctx:qasm3Parser.BitDeclarationContext):
        txt = ctx.getText()
        print(txt)
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
        if(bitdecl!=None):
            return bitdecl

    # Enter a parse tree produced by qasm3Parser#complexDeclaration.
    def enterComplexDeclaration(self, ctx:qasm3Parser.ComplexDeclarationContext):
        pass

    # Enter a parse tree produced by qasm3Parser#classicalDeclaration.
    def enterClassicalDeclaration(self, ctx:qasm3Parser.ClassicalDeclarationContext):
        pass

    # Enter a parse tree produced by qasm3Parser#classicalTypeList.
    def enterClassicalTypeList(self, ctx:qasm3Parser.ClassicalTypeListContext):
        pass


    # Enter a parse tree produced by qasm3Parser#classicalArgument.
    def enterClassicalArgument(self, ctx:qasm3Parser.ClassicalArgumentContext):
        pass

    # Enter a parse tree produced by qasm3Parser#classicalArgumentList.
    def enterClassicalArgumentList(self, ctx:qasm3Parser.ClassicalArgumentListContext):
        pass

    # Enter a parse tree produced by qasm3Parser#anyTypeArgument.
    def enterAnyTypeArgument(self, ctx:qasm3Parser.AnyTypeArgumentContext):
        pass

    # Enter a parse tree produced by qasm3Parser#anyTypeArgumentList.
    def enterAnyTypeArgumentList(self, ctx:qasm3Parser.AnyTypeArgumentListContext):
        pass
    
    # Enter a parse tree produced by qasm3Parser#aliasStatement.
    def enterAliasStatement(self, ctx:qasm3Parser.AliasStatementContext):
        pass
    
    # Enter a parse tree produced by qasm3Parser#indexIdentifier.
    def enterIndexIdentifier(self, ctx:qasm3Parser.IndexIdentifierContext):
        pass
    
    # Enter a parse tree produced by qasm3Parser#indexIdentifierList.
    def enterIndexIdentifierList(self, ctx:qasm3Parser.IndexIdentifierListContext):
        pass

    # Enter a parse tree produced by qasm3Parser#rangeDefinition.
    def enterRangeDefinition(self, ctx:qasm3Parser.RangeDefinitionContext):
        pass

    def enterIdentifier(self, ctx):
        Ident = Identifier(ctx)
        return Ident