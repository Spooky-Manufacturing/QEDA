// Generated from /home/noah/Desktop/QEDA/src/OpenQASM/qasm3.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class qasm3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, T__84=85, T__85=86, T__86=87, 
		T__87=88, LBRACKET=89, RBRACKET=90, LBRACE=91, RBRACE=92, LPAREN=93, RPAREN=94, 
		COLON=95, SEMICOLON=96, DOT=97, COMMA=98, EQUALS=99, ARROW=100, PLUS=101, 
		MINUS=102, MUL=103, DIV=104, MOD=105, IMAG=106, ImagNumber=107, Constant=108, 
		Whitespace=109, Newline=110, Integer=111, Identifier=112, RealNumber=113, 
		TimingLiteral=114, StringLiteral=115, LineComment=116, BlockComment=117;
	public static final int
		RULE_program = 0, RULE_header = 1, RULE_version = 2, RULE_include = 3, 
		RULE_ioIdentifier = 4, RULE_io = 5, RULE_globalStatement = 6, RULE_statement = 7, 
		RULE_quantumDeclarationStatement = 8, RULE_classicalDeclarationStatement = 9, 
		RULE_classicalAssignment = 10, RULE_assignmentStatement = 11, RULE_returnSignature = 12, 
		RULE_designator = 13, RULE_identifierList = 14, RULE_quantumDeclaration = 15, 
		RULE_quantumArgument = 16, RULE_quantumArgumentList = 17, RULE_bitType = 18, 
		RULE_singleDesignatorType = 19, RULE_noDesignatorType = 20, RULE_classicalType = 21, 
		RULE_numericType = 22, RULE_constantDeclaration = 23, RULE_singleDesignatorDeclaration = 24, 
		RULE_noDesignatorDeclaration = 25, RULE_bitDeclaration = 26, RULE_complexDeclaration = 27, 
		RULE_classicalDeclaration = 28, RULE_classicalTypeList = 29, RULE_classicalArgument = 30, 
		RULE_classicalArgumentList = 31, RULE_anyTypeArgument = 32, RULE_anyTypeArgumentList = 33, 
		RULE_aliasStatement = 34, RULE_indexIdentifier = 35, RULE_indexIdentifierList = 36, 
		RULE_rangeDefinition = 37, RULE_quantumGateDefinition = 38, RULE_quantumGateSignature = 39, 
		RULE_quantumGateName = 40, RULE_quantumBlock = 41, RULE_quantumLoop = 42, 
		RULE_quantumLoopBlock = 43, RULE_quantumStatement = 44, RULE_quantumInstruction = 45, 
		RULE_quantumPhase = 46, RULE_quantumReset = 47, RULE_quantumMeasurement = 48, 
		RULE_quantumMeasurementAssignment = 49, RULE_quantumBarrier = 50, RULE_quantumGateModifier = 51, 
		RULE_powModifier = 52, RULE_ctrlModifier = 53, RULE_quantumGateCall = 54, 
		RULE_unaryOperator = 55, RULE_comparisonOperator = 56, RULE_equalityOperator = 57, 
		RULE_logicalOperator = 58, RULE_expressionStatement = 59, RULE_expression = 60, 
		RULE_logicalAndExpression = 61, RULE_bitOrExpression = 62, RULE_xOrExpression = 63, 
		RULE_bitAndExpression = 64, RULE_equalityExpression = 65, RULE_comparisonExpression = 66, 
		RULE_bitShiftExpression = 67, RULE_additiveExpression = 68, RULE_multiplicativeExpression = 69, 
		RULE_unaryExpression = 70, RULE_powerExpression = 71, RULE_expressionTerminator = 72, 
		RULE_booleanLiteral = 73, RULE_builtInCall = 74, RULE_builtInMath = 75, 
		RULE_castOperator = 76, RULE_expressionList = 77, RULE_equalsExpression = 78, 
		RULE_assignmentOperator = 79, RULE_setDeclaration = 80, RULE_programBlock = 81, 
		RULE_branchingStatement = 82, RULE_loopSignature = 83, RULE_loopStatement = 84, 
		RULE_endStatement = 85, RULE_returnStatement = 86, RULE_controlDirective = 87, 
		RULE_externDeclaration = 88, RULE_externOrSubroutineCall = 89, RULE_subroutineDefinition = 90, 
		RULE_subroutineBlock = 91, RULE_pragma = 92, RULE_timingType = 93, RULE_timingBox = 94, 
		RULE_timingIdentifier = 95, RULE_timingInstructionName = 96, RULE_timingInstruction = 97, 
		RULE_timingStatement = 98, RULE_calibration = 99, RULE_calibrationGrammarDeclaration = 100, 
		RULE_calibrationDefinition = 101, RULE_calibrationGrammar = 102, RULE_calibrationArgumentList = 103;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "header", "version", "include", "ioIdentifier", "io", "globalStatement", 
			"statement", "quantumDeclarationStatement", "classicalDeclarationStatement", 
			"classicalAssignment", "assignmentStatement", "returnSignature", "designator", 
			"identifierList", "quantumDeclaration", "quantumArgument", "quantumArgumentList", 
			"bitType", "singleDesignatorType", "noDesignatorType", "classicalType", 
			"numericType", "constantDeclaration", "singleDesignatorDeclaration", 
			"noDesignatorDeclaration", "bitDeclaration", "complexDeclaration", "classicalDeclaration", 
			"classicalTypeList", "classicalArgument", "classicalArgumentList", "anyTypeArgument", 
			"anyTypeArgumentList", "aliasStatement", "indexIdentifier", "indexIdentifierList", 
			"rangeDefinition", "quantumGateDefinition", "quantumGateSignature", "quantumGateName", 
			"quantumBlock", "quantumLoop", "quantumLoopBlock", "quantumStatement", 
			"quantumInstruction", "quantumPhase", "quantumReset", "quantumMeasurement", 
			"quantumMeasurementAssignment", "quantumBarrier", "quantumGateModifier", 
			"powModifier", "ctrlModifier", "quantumGateCall", "unaryOperator", "comparisonOperator", 
			"equalityOperator", "logicalOperator", "expressionStatement", "expression", 
			"logicalAndExpression", "bitOrExpression", "xOrExpression", "bitAndExpression", 
			"equalityExpression", "comparisonExpression", "bitShiftExpression", "additiveExpression", 
			"multiplicativeExpression", "unaryExpression", "powerExpression", "expressionTerminator", 
			"booleanLiteral", "builtInCall", "builtInMath", "castOperator", "expressionList", 
			"equalsExpression", "assignmentOperator", "setDeclaration", "programBlock", 
			"branchingStatement", "loopSignature", "loopStatement", "endStatement", 
			"returnStatement", "controlDirective", "externDeclaration", "externOrSubroutineCall", 
			"subroutineDefinition", "subroutineBlock", "pragma", "timingType", "timingBox", 
			"timingIdentifier", "timingInstructionName", "timingInstruction", "timingStatement", 
			"calibration", "calibrationGrammarDeclaration", "calibrationDefinition", 
			"calibrationGrammar", "calibrationArgumentList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'OPENQASM'", "'include'", "'input'", "'output'", "'qreg'", "'qubit'", 
			"'bit'", "'creg'", "'int'", "'uint'", "'float'", "'angle'", "'bool'", 
			"'complex'", "'const'", "'let'", "'||'", "'gate'", "'U'", "'CX'", "'gphase'", 
			"'reset'", "'measure'", "'barrier'", "'inv'", "'@'", "'pow'", "'ctrl'", 
			"'negctrl'", "'~'", "'!'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", 
			"'&&'", "'|'", "'^'", "'&'", "'<<'", "'>>'", "'**'", "'true'", "'false'", 
			"'sin'", "'cos'", "'tan'", "'exp'", "'ln'", "'sqrt'", "'rotl'", "'rotr'", 
			"'popcount'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'~='", 
			"'^='", "'<<='", "'>>='", "'%='", "'**='", "'if'", "'else'", "'for'", 
			"'in'", "'while'", "'end'", "'return'", "'break'", "'continue'", "'extern'", 
			"'def'", "'#pragma'", "'duration'", "'stretch'", "'box'", "'durationof'", 
			"'delay'", "'rotary'", "'defcalgrammar'", "'defcal'", "'\"openpulse\"'", 
			"'['", "']'", "'{'", "'}'", "'('", "')'", "':'", "';'", "'.'", "','", 
			"'='", "'->'", "'+'", "'-'", "'*'", "'/'", "'%'", "'im'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", 
			"LPAREN", "RPAREN", "COLON", "SEMICOLON", "DOT", "COMMA", "EQUALS", "ARROW", 
			"PLUS", "MINUS", "MUL", "DIV", "MOD", "IMAG", "ImagNumber", "Constant", 
			"Whitespace", "Newline", "Integer", "Identifier", "RealNumber", "TimingLiteral", 
			"StringLiteral", "LineComment", "BlockComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "qasm3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public qasm3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<GlobalStatementContext> globalStatement() {
			return getRuleContexts(GlobalStatementContext.class);
		}
		public GlobalStatementContext globalStatement(int i) {
			return getRuleContext(GlobalStatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			header();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (T__67 - 68)) | (1L << (T__69 - 68)) | (1L << (T__71 - 68)) | (1L << (T__72 - 68)) | (1L << (T__76 - 68)) | (1L << (T__77 - 68)) | (1L << (T__78 - 68)) | (1L << (T__79 - 68)) | (1L << (T__80 - 68)) | (1L << (T__81 - 68)) | (1L << (T__82 - 68)) | (1L << (T__83 - 68)) | (1L << (T__84 - 68)) | (1L << (T__85 - 68)) | (1L << (T__86 - 68)) | (1L << (LPAREN - 68)) | (1L << (MINUS - 68)) | (1L << (ImagNumber - 68)) | (1L << (Constant - 68)) | (1L << (Integer - 68)) | (1L << (Identifier - 68)) | (1L << (RealNumber - 68)) | (1L << (TimingLiteral - 68)) | (1L << (StringLiteral - 68)))) != 0)) {
				{
				setState(211);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__5:
				case T__17:
				case T__76:
				case T__77:
				case T__78:
				case T__85:
				case T__86:
					{
					setState(209);
					globalStatement();
					}
					break;
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__18:
				case T__19:
				case T__20:
				case T__21:
				case T__22:
				case T__23:
				case T__24:
				case T__26:
				case T__27:
				case T__28:
				case T__29:
				case T__30:
				case T__44:
				case T__45:
				case T__46:
				case T__47:
				case T__48:
				case T__49:
				case T__50:
				case T__51:
				case T__52:
				case T__53:
				case T__54:
				case T__67:
				case T__69:
				case T__71:
				case T__72:
				case T__79:
				case T__80:
				case T__81:
				case T__82:
				case T__83:
				case T__84:
				case LPAREN:
				case MINUS:
				case ImagNumber:
				case Constant:
				case Integer:
				case Identifier:
				case RealNumber:
				case TimingLiteral:
				case StringLiteral:
					{
					setState(210);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderContext extends ParserRuleContext {
		public VersionContext version() {
			return getRuleContext(VersionContext.class,0);
		}
		public List<IncludeContext> include() {
			return getRuleContexts(IncludeContext.class);
		}
		public IncludeContext include(int i) {
			return getRuleContext(IncludeContext.class,i);
		}
		public List<IoContext> io() {
			return getRuleContexts(IoContext.class);
		}
		public IoContext io(int i) {
			return getRuleContext(IoContext.class,i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(216);
				version();
				}
			}

			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(219);
				include();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__3) {
				{
				{
				setState(225);
				io();
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VersionContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public TerminalNode Integer() { return getToken(qasm3Parser.Integer, 0); }
		public TerminalNode RealNumber() { return getToken(qasm3Parser.RealNumber, 0); }
		public VersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_version; }
	}

	public final VersionContext version() throws RecognitionException {
		VersionContext _localctx = new VersionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_version);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(T__0);
			setState(232);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==RealNumber) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(233);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncludeContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(qasm3Parser.StringLiteral, 0); }
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__1);
			setState(236);
			match(StringLiteral);
			setState(237);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IoIdentifierContext extends ParserRuleContext {
		public IoIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ioIdentifier; }
	}

	public final IoIdentifierContext ioIdentifier() throws RecognitionException {
		IoIdentifierContext _localctx = new IoIdentifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ioIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IoContext extends ParserRuleContext {
		public IoIdentifierContext ioIdentifier() {
			return getRuleContext(IoIdentifierContext.class,0);
		}
		public ClassicalTypeContext classicalType() {
			return getRuleContext(ClassicalTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public IoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_io; }
	}

	public final IoContext io() throws RecognitionException {
		IoContext _localctx = new IoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_io);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			ioIdentifier();
			setState(242);
			classicalType();
			setState(243);
			match(Identifier);
			setState(244);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalStatementContext extends ParserRuleContext {
		public SubroutineDefinitionContext subroutineDefinition() {
			return getRuleContext(SubroutineDefinitionContext.class,0);
		}
		public ExternDeclarationContext externDeclaration() {
			return getRuleContext(ExternDeclarationContext.class,0);
		}
		public QuantumGateDefinitionContext quantumGateDefinition() {
			return getRuleContext(QuantumGateDefinitionContext.class,0);
		}
		public CalibrationContext calibration() {
			return getRuleContext(CalibrationContext.class,0);
		}
		public QuantumDeclarationStatementContext quantumDeclarationStatement() {
			return getRuleContext(QuantumDeclarationStatementContext.class,0);
		}
		public PragmaContext pragma() {
			return getRuleContext(PragmaContext.class,0);
		}
		public GlobalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalStatement; }
	}

	public final GlobalStatementContext globalStatement() throws RecognitionException {
		GlobalStatementContext _localctx = new GlobalStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_globalStatement);
		try {
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__77:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				subroutineDefinition();
				}
				break;
			case T__76:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				externDeclaration();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				quantumGateDefinition();
				}
				break;
			case T__85:
			case T__86:
				enterOuterAlt(_localctx, 4);
				{
				setState(249);
				calibration();
				}
				break;
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 5);
				{
				setState(250);
				quantumDeclarationStatement();
				}
				break;
			case T__78:
				enterOuterAlt(_localctx, 6);
				{
				setState(251);
				pragma();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public ClassicalDeclarationStatementContext classicalDeclarationStatement() {
			return getRuleContext(ClassicalDeclarationStatementContext.class,0);
		}
		public BranchingStatementContext branchingStatement() {
			return getRuleContext(BranchingStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public EndStatementContext endStatement() {
			return getRuleContext(EndStatementContext.class,0);
		}
		public AliasStatementContext aliasStatement() {
			return getRuleContext(AliasStatementContext.class,0);
		}
		public QuantumStatementContext quantumStatement() {
			return getRuleContext(QuantumStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				expressionStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				assignmentStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				classicalDeclarationStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				branchingStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
				loopStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(259);
				endStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(260);
				aliasStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(261);
				quantumStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumDeclarationStatementContext extends ParserRuleContext {
		public QuantumDeclarationContext quantumDeclaration() {
			return getRuleContext(QuantumDeclarationContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public QuantumDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumDeclarationStatement; }
	}

	public final QuantumDeclarationStatementContext quantumDeclarationStatement() throws RecognitionException {
		QuantumDeclarationStatementContext _localctx = new QuantumDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_quantumDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			quantumDeclaration();
			setState(265);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassicalDeclarationStatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public ClassicalDeclarationContext classicalDeclaration() {
			return getRuleContext(ClassicalDeclarationContext.class,0);
		}
		public ConstantDeclarationContext constantDeclaration() {
			return getRuleContext(ConstantDeclarationContext.class,0);
		}
		public ClassicalDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classicalDeclarationStatement; }
	}

	public final ClassicalDeclarationStatementContext classicalDeclarationStatement() throws RecognitionException {
		ClassicalDeclarationStatementContext _localctx = new ClassicalDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classicalDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__79:
			case T__80:
				{
				setState(267);
				classicalDeclaration();
				}
				break;
			case T__14:
				{
				setState(268);
				constantDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(271);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassicalAssignmentContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public ClassicalAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classicalAssignment; }
	}

	public final ClassicalAssignmentContext classicalAssignment() throws RecognitionException {
		ClassicalAssignmentContext _localctx = new ClassicalAssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_classicalAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(Identifier);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(274);
				designator();
				}
			}

			setState(277);
			assignmentOperator();
			setState(278);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public ClassicalAssignmentContext classicalAssignment() {
			return getRuleContext(ClassicalAssignmentContext.class,0);
		}
		public QuantumMeasurementAssignmentContext quantumMeasurementAssignment() {
			return getRuleContext(QuantumMeasurementAssignmentContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(280);
				classicalAssignment();
				}
				break;
			case 2:
				{
				setState(281);
				quantumMeasurementAssignment();
				}
				break;
			}
			setState(284);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnSignatureContext extends ParserRuleContext {
		public TerminalNode ARROW() { return getToken(qasm3Parser.ARROW, 0); }
		public ClassicalTypeContext classicalType() {
			return getRuleContext(ClassicalTypeContext.class,0);
		}
		public ReturnSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnSignature; }
	}

	public final ReturnSignatureContext returnSignature() throws RecognitionException {
		ReturnSignatureContext _localctx = new ReturnSignatureContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_returnSignature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(ARROW);
			setState(287);
			classicalType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DesignatorContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(qasm3Parser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(qasm3Parser.RBRACKET, 0); }
		public DesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator; }
	}

	public final DesignatorContext designator() throws RecognitionException {
		DesignatorContext _localctx = new DesignatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_designator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(LBRACKET);
			setState(290);
			expression(0);
			setState(291);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierListContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(qasm3Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(qasm3Parser.Identifier, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(qasm3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(qasm3Parser.COMMA, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_identifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(293);
					match(Identifier);
					setState(294);
					match(COMMA);
					}
					} 
				}
				setState(299);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(300);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public QuantumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumDeclaration; }
	}

	public final QuantumDeclarationContext quantumDeclaration() throws RecognitionException {
		QuantumDeclarationContext _localctx = new QuantumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_quantumDeclaration);
		int _la;
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				match(T__4);
				setState(303);
				match(Identifier);
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(304);
					designator();
					}
				}

				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				match(T__5);
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(308);
					designator();
					}
				}

				setState(311);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumArgumentContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public QuantumArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumArgument; }
	}

	public final QuantumArgumentContext quantumArgument() throws RecognitionException {
		QuantumArgumentContext _localctx = new QuantumArgumentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_quantumArgument);
		int _la;
		try {
			setState(324);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				match(T__4);
				setState(315);
				match(Identifier);
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(316);
					designator();
					}
				}

				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				match(T__5);
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(320);
					designator();
					}
				}

				setState(323);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumArgumentListContext extends ParserRuleContext {
		public List<QuantumArgumentContext> quantumArgument() {
			return getRuleContexts(QuantumArgumentContext.class);
		}
		public QuantumArgumentContext quantumArgument(int i) {
			return getRuleContext(QuantumArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(qasm3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(qasm3Parser.COMMA, i);
		}
		public QuantumArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumArgumentList; }
	}

	public final QuantumArgumentListContext quantumArgumentList() throws RecognitionException {
		QuantumArgumentListContext _localctx = new QuantumArgumentListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_quantumArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			quantumArgument();
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(327);
				match(COMMA);
				setState(328);
				quantumArgument();
				}
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BitTypeContext extends ParserRuleContext {
		public BitTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitType; }
	}

	public final BitTypeContext bitType() throws RecognitionException {
		BitTypeContext _localctx = new BitTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_bitType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleDesignatorTypeContext extends ParserRuleContext {
		public SingleDesignatorTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleDesignatorType; }
	}

	public final SingleDesignatorTypeContext singleDesignatorType() throws RecognitionException {
		SingleDesignatorTypeContext _localctx = new SingleDesignatorTypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_singleDesignatorType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoDesignatorTypeContext extends ParserRuleContext {
		public TimingTypeContext timingType() {
			return getRuleContext(TimingTypeContext.class,0);
		}
		public NoDesignatorTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noDesignatorType; }
	}

	public final NoDesignatorTypeContext noDesignatorType() throws RecognitionException {
		NoDesignatorTypeContext _localctx = new NoDesignatorTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_noDesignatorType);
		try {
			setState(340);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(338);
				match(T__12);
				}
				break;
			case T__79:
			case T__80:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				timingType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassicalTypeContext extends ParserRuleContext {
		public SingleDesignatorTypeContext singleDesignatorType() {
			return getRuleContext(SingleDesignatorTypeContext.class,0);
		}
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public NoDesignatorTypeContext noDesignatorType() {
			return getRuleContext(NoDesignatorTypeContext.class,0);
		}
		public BitTypeContext bitType() {
			return getRuleContext(BitTypeContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(qasm3Parser.LBRACKET, 0); }
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(qasm3Parser.RBRACKET, 0); }
		public ClassicalTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classicalType; }
	}

	public final ClassicalTypeContext classicalType() throws RecognitionException {
		ClassicalTypeContext _localctx = new ClassicalTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_classicalType);
		int _la;
		try {
			setState(355);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				singleDesignatorType();
				setState(343);
				designator();
				}
				break;
			case T__12:
			case T__79:
			case T__80:
				enterOuterAlt(_localctx, 2);
				{
				setState(345);
				noDesignatorType();
				}
				break;
			case T__6:
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(346);
				bitType();
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(347);
					designator();
					}
				}

				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(350);
				match(T__13);
				setState(351);
				match(LBRACKET);
				setState(352);
				numericType();
				setState(353);
				match(RBRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericTypeContext extends ParserRuleContext {
		public SingleDesignatorTypeContext singleDesignatorType() {
			return getRuleContext(SingleDesignatorTypeContext.class,0);
		}
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public NumericTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericType; }
	}

	public final NumericTypeContext numericType() throws RecognitionException {
		NumericTypeContext _localctx = new NumericTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_numericType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			singleDesignatorType();
			setState(358);
			designator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public EqualsExpressionContext equalsExpression() {
			return getRuleContext(EqualsExpressionContext.class,0);
		}
		public ConstantDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclaration; }
	}

	public final ConstantDeclarationContext constantDeclaration() throws RecognitionException {
		ConstantDeclarationContext _localctx = new ConstantDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constantDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(T__14);
			setState(361);
			match(Identifier);
			setState(362);
			equalsExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleDesignatorDeclarationContext extends ParserRuleContext {
		public SingleDesignatorTypeContext singleDesignatorType() {
			return getRuleContext(SingleDesignatorTypeContext.class,0);
		}
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public EqualsExpressionContext equalsExpression() {
			return getRuleContext(EqualsExpressionContext.class,0);
		}
		public SingleDesignatorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleDesignatorDeclaration; }
	}

	public final SingleDesignatorDeclarationContext singleDesignatorDeclaration() throws RecognitionException {
		SingleDesignatorDeclarationContext _localctx = new SingleDesignatorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_singleDesignatorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			singleDesignatorType();
			setState(365);
			designator();
			setState(366);
			match(Identifier);
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUALS) {
				{
				setState(367);
				equalsExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoDesignatorDeclarationContext extends ParserRuleContext {
		public NoDesignatorTypeContext noDesignatorType() {
			return getRuleContext(NoDesignatorTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public EqualsExpressionContext equalsExpression() {
			return getRuleContext(EqualsExpressionContext.class,0);
		}
		public NoDesignatorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noDesignatorDeclaration; }
	}

	public final NoDesignatorDeclarationContext noDesignatorDeclaration() throws RecognitionException {
		NoDesignatorDeclarationContext _localctx = new NoDesignatorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_noDesignatorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			noDesignatorType();
			setState(371);
			match(Identifier);
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUALS) {
				{
				setState(372);
				equalsExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BitDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public EqualsExpressionContext equalsExpression() {
			return getRuleContext(EqualsExpressionContext.class,0);
		}
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public BitDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitDeclaration; }
	}

	public final BitDeclarationContext bitDeclaration() throws RecognitionException {
		BitDeclarationContext _localctx = new BitDeclarationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_bitDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(375);
				match(T__7);
				setState(376);
				match(Identifier);
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(377);
					designator();
					}
				}

				}
				break;
			case T__6:
				{
				setState(380);
				match(T__6);
				setState(382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(381);
					designator();
					}
				}

				setState(384);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUALS) {
				{
				setState(387);
				equalsExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComplexDeclarationContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(qasm3Parser.LBRACKET, 0); }
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(qasm3Parser.RBRACKET, 0); }
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public EqualsExpressionContext equalsExpression() {
			return getRuleContext(EqualsExpressionContext.class,0);
		}
		public ComplexDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexDeclaration; }
	}

	public final ComplexDeclarationContext complexDeclaration() throws RecognitionException {
		ComplexDeclarationContext _localctx = new ComplexDeclarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_complexDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(T__13);
			setState(391);
			match(LBRACKET);
			setState(392);
			numericType();
			setState(393);
			match(RBRACKET);
			setState(394);
			match(Identifier);
			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUALS) {
				{
				setState(395);
				equalsExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassicalDeclarationContext extends ParserRuleContext {
		public SingleDesignatorDeclarationContext singleDesignatorDeclaration() {
			return getRuleContext(SingleDesignatorDeclarationContext.class,0);
		}
		public NoDesignatorDeclarationContext noDesignatorDeclaration() {
			return getRuleContext(NoDesignatorDeclarationContext.class,0);
		}
		public BitDeclarationContext bitDeclaration() {
			return getRuleContext(BitDeclarationContext.class,0);
		}
		public ComplexDeclarationContext complexDeclaration() {
			return getRuleContext(ComplexDeclarationContext.class,0);
		}
		public ClassicalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classicalDeclaration; }
	}

	public final ClassicalDeclarationContext classicalDeclaration() throws RecognitionException {
		ClassicalDeclarationContext _localctx = new ClassicalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_classicalDeclaration);
		try {
			setState(402);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(398);
				singleDesignatorDeclaration();
				}
				break;
			case T__12:
			case T__79:
			case T__80:
				enterOuterAlt(_localctx, 2);
				{
				setState(399);
				noDesignatorDeclaration();
				}
				break;
			case T__6:
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(400);
				bitDeclaration();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(401);
				complexDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassicalTypeListContext extends ParserRuleContext {
		public List<ClassicalTypeContext> classicalType() {
			return getRuleContexts(ClassicalTypeContext.class);
		}
		public ClassicalTypeContext classicalType(int i) {
			return getRuleContext(ClassicalTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(qasm3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(qasm3Parser.COMMA, i);
		}
		public ClassicalTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classicalTypeList; }
	}

	public final ClassicalTypeListContext classicalTypeList() throws RecognitionException {
		ClassicalTypeListContext _localctx = new ClassicalTypeListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_classicalTypeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(404);
					classicalType();
					setState(405);
					match(COMMA);
					}
					} 
				}
				setState(411);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(412);
			classicalType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassicalArgumentContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public SingleDesignatorTypeContext singleDesignatorType() {
			return getRuleContext(SingleDesignatorTypeContext.class,0);
		}
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public NoDesignatorTypeContext noDesignatorType() {
			return getRuleContext(NoDesignatorTypeContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(qasm3Parser.LBRACKET, 0); }
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(qasm3Parser.RBRACKET, 0); }
		public ClassicalArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classicalArgument; }
	}

	public final ClassicalArgumentContext classicalArgument() throws RecognitionException {
		ClassicalArgumentContext _localctx = new ClassicalArgumentContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_classicalArgument);
		int _la;
		try {
			setState(438);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__79:
			case T__80:
				enterOuterAlt(_localctx, 1);
				{
				setState(418);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
				case T__9:
				case T__10:
				case T__11:
					{
					setState(414);
					singleDesignatorType();
					setState(415);
					designator();
					}
					break;
				case T__12:
				case T__79:
				case T__80:
					{
					setState(417);
					noDesignatorType();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(420);
				match(Identifier);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(422);
				match(T__7);
				setState(423);
				match(Identifier);
				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(424);
					designator();
					}
				}

				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(427);
				match(T__6);
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(428);
					designator();
					}
				}

				setState(431);
				match(Identifier);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(432);
				match(T__13);
				setState(433);
				match(LBRACKET);
				setState(434);
				numericType();
				setState(435);
				match(RBRACKET);
				setState(436);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassicalArgumentListContext extends ParserRuleContext {
		public List<ClassicalArgumentContext> classicalArgument() {
			return getRuleContexts(ClassicalArgumentContext.class);
		}
		public ClassicalArgumentContext classicalArgument(int i) {
			return getRuleContext(ClassicalArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(qasm3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(qasm3Parser.COMMA, i);
		}
		public ClassicalArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classicalArgumentList; }
	}

	public final ClassicalArgumentListContext classicalArgumentList() throws RecognitionException {
		ClassicalArgumentListContext _localctx = new ClassicalArgumentListContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_classicalArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			classicalArgument();
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(441);
				match(COMMA);
				setState(442);
				classicalArgument();
				}
				}
				setState(447);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnyTypeArgumentContext extends ParserRuleContext {
		public ClassicalArgumentContext classicalArgument() {
			return getRuleContext(ClassicalArgumentContext.class,0);
		}
		public QuantumArgumentContext quantumArgument() {
			return getRuleContext(QuantumArgumentContext.class,0);
		}
		public AnyTypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyTypeArgument; }
	}

	public final AnyTypeArgumentContext anyTypeArgument() throws RecognitionException {
		AnyTypeArgumentContext _localctx = new AnyTypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_anyTypeArgument);
		try {
			setState(450);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__79:
			case T__80:
				enterOuterAlt(_localctx, 1);
				{
				setState(448);
				classicalArgument();
				}
				break;
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(449);
				quantumArgument();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnyTypeArgumentListContext extends ParserRuleContext {
		public List<AnyTypeArgumentContext> anyTypeArgument() {
			return getRuleContexts(AnyTypeArgumentContext.class);
		}
		public AnyTypeArgumentContext anyTypeArgument(int i) {
			return getRuleContext(AnyTypeArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(qasm3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(qasm3Parser.COMMA, i);
		}
		public AnyTypeArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyTypeArgumentList; }
	}

	public final AnyTypeArgumentListContext anyTypeArgumentList() throws RecognitionException {
		AnyTypeArgumentListContext _localctx = new AnyTypeArgumentListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_anyTypeArgumentList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(452);
					anyTypeArgument();
					setState(453);
					match(COMMA);
					}
					} 
				}
				setState(459);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			setState(460);
			anyTypeArgument();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public TerminalNode EQUALS() { return getToken(qasm3Parser.EQUALS, 0); }
		public IndexIdentifierContext indexIdentifier() {
			return getRuleContext(IndexIdentifierContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public AliasStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasStatement; }
	}

	public final AliasStatementContext aliasStatement() throws RecognitionException {
		AliasStatementContext _localctx = new AliasStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_aliasStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(T__15);
			setState(463);
			match(Identifier);
			setState(464);
			match(EQUALS);
			setState(465);
			indexIdentifier(0);
			setState(466);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexIdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public RangeDefinitionContext rangeDefinition() {
			return getRuleContext(RangeDefinitionContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(qasm3Parser.LBRACKET, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(qasm3Parser.RBRACKET, 0); }
		public List<IndexIdentifierContext> indexIdentifier() {
			return getRuleContexts(IndexIdentifierContext.class);
		}
		public IndexIdentifierContext indexIdentifier(int i) {
			return getRuleContext(IndexIdentifierContext.class,i);
		}
		public IndexIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexIdentifier; }
	}

	public final IndexIdentifierContext indexIdentifier() throws RecognitionException {
		return indexIdentifier(0);
	}

	private IndexIdentifierContext indexIdentifier(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IndexIdentifierContext _localctx = new IndexIdentifierContext(_ctx, _parentState);
		IndexIdentifierContext _prevctx = _localctx;
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_indexIdentifier, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(469);
				match(Identifier);
				setState(470);
				rangeDefinition();
				}
				break;
			case 2:
				{
				setState(471);
				match(Identifier);
				setState(476);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(472);
					match(LBRACKET);
					setState(473);
					expressionList();
					setState(474);
					match(RBRACKET);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(485);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IndexIdentifierContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_indexIdentifier);
					setState(480);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(481);
					match(T__16);
					setState(482);
					indexIdentifier(2);
					}
					} 
				}
				setState(487);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class IndexIdentifierListContext extends ParserRuleContext {
		public List<IndexIdentifierContext> indexIdentifier() {
			return getRuleContexts(IndexIdentifierContext.class);
		}
		public IndexIdentifierContext indexIdentifier(int i) {
			return getRuleContext(IndexIdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(qasm3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(qasm3Parser.COMMA, i);
		}
		public IndexIdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexIdentifierList; }
	}

	public final IndexIdentifierListContext indexIdentifierList() throws RecognitionException {
		IndexIdentifierListContext _localctx = new IndexIdentifierListContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_indexIdentifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			indexIdentifier(0);
			setState(493);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(489);
				match(COMMA);
				setState(490);
				indexIdentifier(0);
				}
				}
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeDefinitionContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(qasm3Parser.LBRACKET, 0); }
		public List<TerminalNode> COLON() { return getTokens(qasm3Parser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(qasm3Parser.COLON, i);
		}
		public TerminalNode RBRACKET() { return getToken(qasm3Parser.RBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public RangeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeDefinition; }
	}

	public final RangeDefinitionContext rangeDefinition() throws RecognitionException {
		RangeDefinitionContext _localctx = new RangeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_rangeDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			match(LBRACKET);
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__29) | (1L << T__30) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54))) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__82 - 80)) | (1L << (LPAREN - 80)) | (1L << (MINUS - 80)) | (1L << (ImagNumber - 80)) | (1L << (Constant - 80)) | (1L << (Integer - 80)) | (1L << (Identifier - 80)) | (1L << (RealNumber - 80)) | (1L << (TimingLiteral - 80)) | (1L << (StringLiteral - 80)))) != 0)) {
				{
				setState(497);
				expression(0);
				}
			}

			setState(500);
			match(COLON);
			setState(502);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__29) | (1L << T__30) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54))) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__82 - 80)) | (1L << (LPAREN - 80)) | (1L << (MINUS - 80)) | (1L << (ImagNumber - 80)) | (1L << (Constant - 80)) | (1L << (Integer - 80)) | (1L << (Identifier - 80)) | (1L << (RealNumber - 80)) | (1L << (TimingLiteral - 80)) | (1L << (StringLiteral - 80)))) != 0)) {
				{
				setState(501);
				expression(0);
				}
			}

			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(504);
				match(COLON);
				setState(505);
				expression(0);
				}
			}

			setState(508);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumGateDefinitionContext extends ParserRuleContext {
		public QuantumGateSignatureContext quantumGateSignature() {
			return getRuleContext(QuantumGateSignatureContext.class,0);
		}
		public QuantumBlockContext quantumBlock() {
			return getRuleContext(QuantumBlockContext.class,0);
		}
		public QuantumGateDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumGateDefinition; }
	}

	public final QuantumGateDefinitionContext quantumGateDefinition() throws RecognitionException {
		QuantumGateDefinitionContext _localctx = new QuantumGateDefinitionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_quantumGateDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			match(T__17);
			setState(511);
			quantumGateSignature();
			setState(512);
			quantumBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumGateSignatureContext extends ParserRuleContext {
		public QuantumGateNameContext quantumGateName() {
			return getRuleContext(QuantumGateNameContext.class,0);
		}
		public List<IdentifierListContext> identifierList() {
			return getRuleContexts(IdentifierListContext.class);
		}
		public IdentifierListContext identifierList(int i) {
			return getRuleContext(IdentifierListContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public QuantumGateSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumGateSignature; }
	}

	public final QuantumGateSignatureContext quantumGateSignature() throws RecognitionException {
		QuantumGateSignatureContext _localctx = new QuantumGateSignatureContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_quantumGateSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			quantumGateName();
			setState(520);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(515);
				match(LPAREN);
				setState(517);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(516);
					identifierList();
					}
				}

				setState(519);
				match(RPAREN);
				}
			}

			setState(522);
			identifierList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumGateNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public QuantumGateNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumGateName; }
	}

	public final QuantumGateNameContext quantumGateName() throws RecognitionException {
		QuantumGateNameContext _localctx = new QuantumGateNameContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_quantumGateName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			_la = _input.LA(1);
			if ( !(_la==T__18 || _la==T__19 || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(qasm3Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(qasm3Parser.RBRACE, 0); }
		public List<QuantumStatementContext> quantumStatement() {
			return getRuleContexts(QuantumStatementContext.class);
		}
		public QuantumStatementContext quantumStatement(int i) {
			return getRuleContext(QuantumStatementContext.class,i);
		}
		public List<QuantumLoopContext> quantumLoop() {
			return getRuleContexts(QuantumLoopContext.class);
		}
		public QuantumLoopContext quantumLoop(int i) {
			return getRuleContext(QuantumLoopContext.class,i);
		}
		public QuantumBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumBlock; }
	}

	public final QuantumBlockContext quantumBlock() throws RecognitionException {
		QuantumBlockContext _localctx = new QuantumBlockContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_quantumBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(LBRACE);
			setState(531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__71 - 70)) | (1L << (T__81 - 70)) | (1L << (T__83 - 70)) | (1L << (T__84 - 70)) | (1L << (Identifier - 70)))) != 0)) {
				{
				setState(529);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__18:
				case T__19:
				case T__20:
				case T__21:
				case T__22:
				case T__23:
				case T__24:
				case T__26:
				case T__27:
				case T__28:
				case T__81:
				case T__83:
				case T__84:
				case Identifier:
					{
					setState(527);
					quantumStatement();
					}
					break;
				case T__69:
				case T__71:
					{
					setState(528);
					quantumLoop();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(533);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(534);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumLoopContext extends ParserRuleContext {
		public LoopSignatureContext loopSignature() {
			return getRuleContext(LoopSignatureContext.class,0);
		}
		public QuantumLoopBlockContext quantumLoopBlock() {
			return getRuleContext(QuantumLoopBlockContext.class,0);
		}
		public QuantumLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumLoop; }
	}

	public final QuantumLoopContext quantumLoop() throws RecognitionException {
		QuantumLoopContext _localctx = new QuantumLoopContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_quantumLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			loopSignature();
			setState(537);
			quantumLoopBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumLoopBlockContext extends ParserRuleContext {
		public List<QuantumStatementContext> quantumStatement() {
			return getRuleContexts(QuantumStatementContext.class);
		}
		public QuantumStatementContext quantumStatement(int i) {
			return getRuleContext(QuantumStatementContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(qasm3Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(qasm3Parser.RBRACE, 0); }
		public QuantumLoopBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumLoopBlock; }
	}

	public final QuantumLoopBlockContext quantumLoopBlock() throws RecognitionException {
		QuantumLoopBlockContext _localctx = new QuantumLoopBlockContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_quantumLoopBlock);
		int _la;
		try {
			setState(548);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__26:
			case T__27:
			case T__28:
			case T__81:
			case T__83:
			case T__84:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(539);
				quantumStatement();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(540);
				match(LBRACE);
				setState(544);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (T__81 - 82)) | (1L << (T__83 - 82)) | (1L << (T__84 - 82)) | (1L << (Identifier - 82)))) != 0)) {
					{
					{
					setState(541);
					quantumStatement();
					}
					}
					setState(546);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(547);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumStatementContext extends ParserRuleContext {
		public QuantumInstructionContext quantumInstruction() {
			return getRuleContext(QuantumInstructionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public TimingStatementContext timingStatement() {
			return getRuleContext(TimingStatementContext.class,0);
		}
		public QuantumStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumStatement; }
	}

	public final QuantumStatementContext quantumStatement() throws RecognitionException {
		QuantumStatementContext _localctx = new QuantumStatementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_quantumStatement);
		try {
			setState(554);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__26:
			case T__27:
			case T__28:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(550);
				quantumInstruction();
				setState(551);
				match(SEMICOLON);
				}
				break;
			case T__81:
			case T__83:
			case T__84:
				enterOuterAlt(_localctx, 2);
				{
				setState(553);
				timingStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumInstructionContext extends ParserRuleContext {
		public QuantumGateCallContext quantumGateCall() {
			return getRuleContext(QuantumGateCallContext.class,0);
		}
		public QuantumPhaseContext quantumPhase() {
			return getRuleContext(QuantumPhaseContext.class,0);
		}
		public QuantumMeasurementContext quantumMeasurement() {
			return getRuleContext(QuantumMeasurementContext.class,0);
		}
		public QuantumResetContext quantumReset() {
			return getRuleContext(QuantumResetContext.class,0);
		}
		public QuantumBarrierContext quantumBarrier() {
			return getRuleContext(QuantumBarrierContext.class,0);
		}
		public QuantumInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumInstruction; }
	}

	public final QuantumInstructionContext quantumInstruction() throws RecognitionException {
		QuantumInstructionContext _localctx = new QuantumInstructionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_quantumInstruction);
		try {
			setState(561);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(556);
				quantumGateCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(557);
				quantumPhase();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(558);
				quantumMeasurement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(559);
				quantumReset();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(560);
				quantumBarrier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumPhaseContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public List<QuantumGateModifierContext> quantumGateModifier() {
			return getRuleContexts(QuantumGateModifierContext.class);
		}
		public QuantumGateModifierContext quantumGateModifier(int i) {
			return getRuleContext(QuantumGateModifierContext.class,i);
		}
		public IndexIdentifierListContext indexIdentifierList() {
			return getRuleContext(IndexIdentifierListContext.class,0);
		}
		public QuantumPhaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumPhase; }
	}

	public final QuantumPhaseContext quantumPhase() throws RecognitionException {
		QuantumPhaseContext _localctx = new QuantumPhaseContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_quantumPhase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) {
				{
				{
				setState(563);
				quantumGateModifier();
				}
				}
				setState(568);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(569);
			match(T__20);
			setState(570);
			match(LPAREN);
			setState(571);
			expression(0);
			setState(572);
			match(RPAREN);
			setState(574);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(573);
				indexIdentifierList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumResetContext extends ParserRuleContext {
		public IndexIdentifierListContext indexIdentifierList() {
			return getRuleContext(IndexIdentifierListContext.class,0);
		}
		public QuantumResetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumReset; }
	}

	public final QuantumResetContext quantumReset() throws RecognitionException {
		QuantumResetContext _localctx = new QuantumResetContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_quantumReset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			match(T__21);
			setState(577);
			indexIdentifierList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumMeasurementContext extends ParserRuleContext {
		public IndexIdentifierListContext indexIdentifierList() {
			return getRuleContext(IndexIdentifierListContext.class,0);
		}
		public QuantumMeasurementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumMeasurement; }
	}

	public final QuantumMeasurementContext quantumMeasurement() throws RecognitionException {
		QuantumMeasurementContext _localctx = new QuantumMeasurementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_quantumMeasurement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			match(T__22);
			setState(580);
			indexIdentifierList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumMeasurementAssignmentContext extends ParserRuleContext {
		public QuantumMeasurementContext quantumMeasurement() {
			return getRuleContext(QuantumMeasurementContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(qasm3Parser.ARROW, 0); }
		public IndexIdentifierListContext indexIdentifierList() {
			return getRuleContext(IndexIdentifierListContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(qasm3Parser.EQUALS, 0); }
		public QuantumMeasurementAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumMeasurementAssignment; }
	}

	public final QuantumMeasurementAssignmentContext quantumMeasurementAssignment() throws RecognitionException {
		QuantumMeasurementAssignmentContext _localctx = new QuantumMeasurementAssignmentContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_quantumMeasurementAssignment);
		int _la;
		try {
			setState(591);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(582);
				quantumMeasurement();
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ARROW) {
					{
					setState(583);
					match(ARROW);
					setState(584);
					indexIdentifierList();
					}
				}

				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(587);
				indexIdentifierList();
				setState(588);
				match(EQUALS);
				setState(589);
				quantumMeasurement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumBarrierContext extends ParserRuleContext {
		public IndexIdentifierListContext indexIdentifierList() {
			return getRuleContext(IndexIdentifierListContext.class,0);
		}
		public QuantumBarrierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumBarrier; }
	}

	public final QuantumBarrierContext quantumBarrier() throws RecognitionException {
		QuantumBarrierContext _localctx = new QuantumBarrierContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_quantumBarrier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			match(T__23);
			setState(595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(594);
				indexIdentifierList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumGateModifierContext extends ParserRuleContext {
		public PowModifierContext powModifier() {
			return getRuleContext(PowModifierContext.class,0);
		}
		public CtrlModifierContext ctrlModifier() {
			return getRuleContext(CtrlModifierContext.class,0);
		}
		public QuantumGateModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumGateModifier; }
	}

	public final QuantumGateModifierContext quantumGateModifier() throws RecognitionException {
		QuantumGateModifierContext _localctx = new QuantumGateModifierContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_quantumGateModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				{
				setState(597);
				match(T__24);
				}
				break;
			case T__26:
				{
				setState(598);
				powModifier();
				}
				break;
			case T__27:
			case T__28:
				{
				setState(599);
				ctrlModifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(602);
			match(T__25);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PowModifierContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public PowModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powModifier; }
	}

	public final PowModifierContext powModifier() throws RecognitionException {
		PowModifierContext _localctx = new PowModifierContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_powModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			match(T__26);
			setState(605);
			match(LPAREN);
			setState(606);
			expression(0);
			setState(607);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtrlModifierContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public CtrlModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctrlModifier; }
	}

	public final CtrlModifierContext ctrlModifier() throws RecognitionException {
		CtrlModifierContext _localctx = new CtrlModifierContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_ctrlModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			_la = _input.LA(1);
			if ( !(_la==T__27 || _la==T__28) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(614);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(610);
				match(LPAREN);
				setState(611);
				expression(0);
				setState(612);
				match(RPAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantumGateCallContext extends ParserRuleContext {
		public QuantumGateNameContext quantumGateName() {
			return getRuleContext(QuantumGateNameContext.class,0);
		}
		public IndexIdentifierListContext indexIdentifierList() {
			return getRuleContext(IndexIdentifierListContext.class,0);
		}
		public List<QuantumGateModifierContext> quantumGateModifier() {
			return getRuleContexts(QuantumGateModifierContext.class);
		}
		public QuantumGateModifierContext quantumGateModifier(int i) {
			return getRuleContext(QuantumGateModifierContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public QuantumGateCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantumGateCall; }
	}

	public final QuantumGateCallContext quantumGateCall() throws RecognitionException {
		QuantumGateCallContext _localctx = new QuantumGateCallContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_quantumGateCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) {
				{
				{
				setState(616);
				quantumGateModifier();
				}
				}
				setState(621);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(622);
			quantumGateName();
			setState(627);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(623);
				match(LPAREN);
				setState(624);
				expressionList();
				setState(625);
				match(RPAREN);
				}
			}

			setState(629);
			indexIdentifierList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(qasm3Parser.MINUS, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			_la = _input.LA(1);
			if ( !(_la==T__29 || _la==T__30 || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonOperatorContext extends ParserRuleContext {
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityOperatorContext extends ParserRuleContext {
		public EqualityOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityOperator; }
	}

	public final EqualityOperatorContext equalityOperator() throws RecognitionException {
		EqualityOperatorContext _localctx = new EqualityOperatorContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_equalityOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			_la = _input.LA(1);
			if ( !(_la==T__35 || _la==T__36) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalOperatorContext extends ParserRuleContext {
		public LogicalOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOperator; }
	}

	public final LogicalOperatorContext logicalOperator() throws RecognitionException {
		LogicalOperatorContext _localctx = new LogicalOperatorContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_logicalOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__37) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
			expression(0);
			setState(640);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionTerminatorContext expressionTerminator() {
			return getRuleContext(ExpressionTerminatorContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public LogicalAndExpressionContext logicalAndExpression() {
			return getRuleContext(LogicalAndExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 120;
		enterRecursionRule(_localctx, 120, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(643);
				expressionTerminator(0);
				}
				break;
			case 2:
				{
				setState(644);
				unaryExpression();
				}
				break;
			case 3:
				{
				setState(645);
				logicalAndExpression(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(653);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(648);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(649);
					match(T__16);
					setState(650);
					logicalAndExpression(0);
					}
					} 
				}
				setState(655);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicalAndExpressionContext extends ParserRuleContext {
		public BitOrExpressionContext bitOrExpression() {
			return getRuleContext(BitOrExpressionContext.class,0);
		}
		public LogicalAndExpressionContext logicalAndExpression() {
			return getRuleContext(LogicalAndExpressionContext.class,0);
		}
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		return logicalAndExpression(0);
	}

	private LogicalAndExpressionContext logicalAndExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, _parentState);
		LogicalAndExpressionContext _prevctx = _localctx;
		int _startState = 122;
		enterRecursionRule(_localctx, 122, RULE_logicalAndExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(657);
			bitOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(664);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalAndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalAndExpression);
					setState(659);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(660);
					match(T__37);
					setState(661);
					bitOrExpression(0);
					}
					} 
				}
				setState(666);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BitOrExpressionContext extends ParserRuleContext {
		public XOrExpressionContext xOrExpression() {
			return getRuleContext(XOrExpressionContext.class,0);
		}
		public BitOrExpressionContext bitOrExpression() {
			return getRuleContext(BitOrExpressionContext.class,0);
		}
		public BitOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitOrExpression; }
	}

	public final BitOrExpressionContext bitOrExpression() throws RecognitionException {
		return bitOrExpression(0);
	}

	private BitOrExpressionContext bitOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BitOrExpressionContext _localctx = new BitOrExpressionContext(_ctx, _parentState);
		BitOrExpressionContext _prevctx = _localctx;
		int _startState = 124;
		enterRecursionRule(_localctx, 124, RULE_bitOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(668);
			xOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(675);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BitOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitOrExpression);
					setState(670);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(671);
					match(T__38);
					setState(672);
					xOrExpression(0);
					}
					} 
				}
				setState(677);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class XOrExpressionContext extends ParserRuleContext {
		public BitAndExpressionContext bitAndExpression() {
			return getRuleContext(BitAndExpressionContext.class,0);
		}
		public XOrExpressionContext xOrExpression() {
			return getRuleContext(XOrExpressionContext.class,0);
		}
		public XOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xOrExpression; }
	}

	public final XOrExpressionContext xOrExpression() throws RecognitionException {
		return xOrExpression(0);
	}

	private XOrExpressionContext xOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XOrExpressionContext _localctx = new XOrExpressionContext(_ctx, _parentState);
		XOrExpressionContext _prevctx = _localctx;
		int _startState = 126;
		enterRecursionRule(_localctx, 126, RULE_xOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(679);
			bitAndExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(686);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new XOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_xOrExpression);
					setState(681);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(682);
					match(T__39);
					setState(683);
					bitAndExpression(0);
					}
					} 
				}
				setState(688);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BitAndExpressionContext extends ParserRuleContext {
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public BitAndExpressionContext bitAndExpression() {
			return getRuleContext(BitAndExpressionContext.class,0);
		}
		public BitAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitAndExpression; }
	}

	public final BitAndExpressionContext bitAndExpression() throws RecognitionException {
		return bitAndExpression(0);
	}

	private BitAndExpressionContext bitAndExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BitAndExpressionContext _localctx = new BitAndExpressionContext(_ctx, _parentState);
		BitAndExpressionContext _prevctx = _localctx;
		int _startState = 128;
		enterRecursionRule(_localctx, 128, RULE_bitAndExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(690);
			equalityExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(697);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BitAndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitAndExpression);
					setState(692);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(693);
					match(T__40);
					setState(694);
					equalityExpression(0);
					}
					} 
				}
				setState(699);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public ComparisonExpressionContext comparisonExpression() {
			return getRuleContext(ComparisonExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public EqualityOperatorContext equalityOperator() {
			return getRuleContext(EqualityOperatorContext.class,0);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		return equalityExpression(0);
	}

	private EqualityExpressionContext equalityExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, _parentState);
		EqualityExpressionContext _prevctx = _localctx;
		int _startState = 130;
		enterRecursionRule(_localctx, 130, RULE_equalityExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(701);
			comparisonExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(709);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqualityExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
					setState(703);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(704);
					equalityOperator();
					setState(705);
					comparisonExpression(0);
					}
					} 
				}
				setState(711);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ComparisonExpressionContext extends ParserRuleContext {
		public BitShiftExpressionContext bitShiftExpression() {
			return getRuleContext(BitShiftExpressionContext.class,0);
		}
		public ComparisonExpressionContext comparisonExpression() {
			return getRuleContext(ComparisonExpressionContext.class,0);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ComparisonExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonExpression; }
	}

	public final ComparisonExpressionContext comparisonExpression() throws RecognitionException {
		return comparisonExpression(0);
	}

	private ComparisonExpressionContext comparisonExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ComparisonExpressionContext _localctx = new ComparisonExpressionContext(_ctx, _parentState);
		ComparisonExpressionContext _prevctx = _localctx;
		int _startState = 132;
		enterRecursionRule(_localctx, 132, RULE_comparisonExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(713);
			bitShiftExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(721);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ComparisonExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_comparisonExpression);
					setState(715);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(716);
					comparisonOperator();
					setState(717);
					bitShiftExpression(0);
					}
					} 
				}
				setState(723);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BitShiftExpressionContext extends ParserRuleContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public BitShiftExpressionContext bitShiftExpression() {
			return getRuleContext(BitShiftExpressionContext.class,0);
		}
		public BitShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitShiftExpression; }
	}

	public final BitShiftExpressionContext bitShiftExpression() throws RecognitionException {
		return bitShiftExpression(0);
	}

	private BitShiftExpressionContext bitShiftExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BitShiftExpressionContext _localctx = new BitShiftExpressionContext(_ctx, _parentState);
		BitShiftExpressionContext _prevctx = _localctx;
		int _startState = 134;
		enterRecursionRule(_localctx, 134, RULE_bitShiftExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(725);
			additiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(732);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BitShiftExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitShiftExpression);
					setState(727);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(728);
					_la = _input.LA(1);
					if ( !(_la==T__41 || _la==T__42) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(729);
					additiveExpression(0);
					}
					} 
				}
				setState(734);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(qasm3Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(qasm3Parser.MINUS, 0); }
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 136;
		enterRecursionRule(_localctx, 136, RULE_additiveExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(736);
			multiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(743);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
					setState(738);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(739);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(740);
					multiplicativeExpression(0);
					}
					} 
				}
				setState(745);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public PowerExpressionContext powerExpression() {
			return getRuleContext(PowerExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode MUL() { return getToken(qasm3Parser.MUL, 0); }
		public TerminalNode DIV() { return getToken(qasm3Parser.DIV, 0); }
		public TerminalNode MOD() { return getToken(qasm3Parser.MOD, 0); }
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		return multiplicativeExpression(0);
	}

	private MultiplicativeExpressionContext multiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, _parentState);
		MultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 138;
		enterRecursionRule(_localctx, 138, RULE_multiplicativeExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(749);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__79:
			case T__80:
			case T__82:
			case LPAREN:
			case ImagNumber:
			case Constant:
			case Integer:
			case Identifier:
			case RealNumber:
			case TimingLiteral:
			case StringLiteral:
				{
				setState(747);
				powerExpression();
				}
				break;
			case T__29:
			case T__30:
			case MINUS:
				{
				setState(748);
				unaryExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(759);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
					setState(751);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(752);
					_la = _input.LA(1);
					if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (MUL - 103)) | (1L << (DIV - 103)) | (1L << (MOD - 103)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(755);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__6:
					case T__7:
					case T__8:
					case T__9:
					case T__10:
					case T__11:
					case T__12:
					case T__13:
					case T__44:
					case T__45:
					case T__46:
					case T__47:
					case T__48:
					case T__49:
					case T__50:
					case T__51:
					case T__52:
					case T__53:
					case T__54:
					case T__79:
					case T__80:
					case T__82:
					case LPAREN:
					case ImagNumber:
					case Constant:
					case Integer:
					case Identifier:
					case RealNumber:
					case TimingLiteral:
					case StringLiteral:
						{
						setState(753);
						powerExpression();
						}
						break;
					case T__29:
					case T__30:
					case MINUS:
						{
						setState(754);
						unaryExpression();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(761);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public PowerExpressionContext powerExpression() {
			return getRuleContext(PowerExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_unaryExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(762);
			unaryOperator();
			setState(763);
			powerExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PowerExpressionContext extends ParserRuleContext {
		public ExpressionTerminatorContext expressionTerminator() {
			return getRuleContext(ExpressionTerminatorContext.class,0);
		}
		public PowerExpressionContext powerExpression() {
			return getRuleContext(PowerExpressionContext.class,0);
		}
		public PowerExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powerExpression; }
	}

	public final PowerExpressionContext powerExpression() throws RecognitionException {
		PowerExpressionContext _localctx = new PowerExpressionContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_powerExpression);
		try {
			setState(770);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(765);
				expressionTerminator(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(766);
				expressionTerminator(0);
				setState(767);
				match(T__43);
				setState(768);
				powerExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionTerminatorContext extends ParserRuleContext {
		public TerminalNode Constant() { return getToken(qasm3Parser.Constant, 0); }
		public TerminalNode Integer() { return getToken(qasm3Parser.Integer, 0); }
		public TerminalNode RealNumber() { return getToken(qasm3Parser.RealNumber, 0); }
		public TerminalNode ImagNumber() { return getToken(qasm3Parser.ImagNumber, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public TerminalNode StringLiteral() { return getToken(qasm3Parser.StringLiteral, 0); }
		public BuiltInCallContext builtInCall() {
			return getRuleContext(BuiltInCallContext.class,0);
		}
		public ExternOrSubroutineCallContext externOrSubroutineCall() {
			return getRuleContext(ExternOrSubroutineCallContext.class,0);
		}
		public TimingIdentifierContext timingIdentifier() {
			return getRuleContext(TimingIdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public ExpressionTerminatorContext expressionTerminator() {
			return getRuleContext(ExpressionTerminatorContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(qasm3Parser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(qasm3Parser.RBRACKET, 0); }
		public ExpressionTerminatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionTerminator; }
	}

	public final ExpressionTerminatorContext expressionTerminator() throws RecognitionException {
		return expressionTerminator(0);
	}

	private ExpressionTerminatorContext expressionTerminator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionTerminatorContext _localctx = new ExpressionTerminatorContext(_ctx, _parentState);
		ExpressionTerminatorContext _prevctx = _localctx;
		int _startState = 144;
		enterRecursionRule(_localctx, 144, RULE_expressionTerminator, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(787);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(773);
				match(Constant);
				}
				break;
			case 2:
				{
				setState(774);
				match(Integer);
				}
				break;
			case 3:
				{
				setState(775);
				match(RealNumber);
				}
				break;
			case 4:
				{
				setState(776);
				match(ImagNumber);
				}
				break;
			case 5:
				{
				setState(777);
				booleanLiteral();
				}
				break;
			case 6:
				{
				setState(778);
				match(Identifier);
				}
				break;
			case 7:
				{
				setState(779);
				match(StringLiteral);
				}
				break;
			case 8:
				{
				setState(780);
				builtInCall();
				}
				break;
			case 9:
				{
				setState(781);
				externOrSubroutineCall();
				}
				break;
			case 10:
				{
				setState(782);
				timingIdentifier();
				}
				break;
			case 11:
				{
				setState(783);
				match(LPAREN);
				setState(784);
				expression(0);
				setState(785);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(796);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionTerminatorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expressionTerminator);
					setState(789);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(790);
					match(LBRACKET);
					setState(791);
					expression(0);
					setState(792);
					match(RBRACKET);
					}
					} 
				}
				setState(798);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BooleanLiteralContext extends ParserRuleContext {
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(799);
			_la = _input.LA(1);
			if ( !(_la==T__44 || _la==T__45) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuiltInCallContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public BuiltInMathContext builtInMath() {
			return getRuleContext(BuiltInMathContext.class,0);
		}
		public CastOperatorContext castOperator() {
			return getRuleContext(CastOperatorContext.class,0);
		}
		public BuiltInCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtInCall; }
	}

	public final BuiltInCallContext builtInCall() throws RecognitionException {
		BuiltInCallContext _localctx = new BuiltInCallContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_builtInCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(803);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
				{
				setState(801);
				builtInMath();
				}
				break;
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__79:
			case T__80:
				{
				setState(802);
				castOperator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(805);
			match(LPAREN);
			setState(806);
			expressionList();
			setState(807);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuiltInMathContext extends ParserRuleContext {
		public BuiltInMathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtInMath; }
	}

	public final BuiltInMathContext builtInMath() throws RecognitionException {
		BuiltInMathContext _localctx = new BuiltInMathContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_builtInMath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(809);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastOperatorContext extends ParserRuleContext {
		public ClassicalTypeContext classicalType() {
			return getRuleContext(ClassicalTypeContext.class,0);
		}
		public CastOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castOperator; }
	}

	public final CastOperatorContext castOperator() throws RecognitionException {
		CastOperatorContext _localctx = new CastOperatorContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_castOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(811);
			classicalType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(qasm3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(qasm3Parser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(813);
			expression(0);
			setState(818);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(814);
				match(COMMA);
				setState(815);
				expression(0);
				}
				}
				setState(820);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualsExpressionContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(qasm3Parser.EQUALS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EqualsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalsExpression; }
	}

	public final EqualsExpressionContext equalsExpression() throws RecognitionException {
		EqualsExpressionContext _localctx = new EqualsExpressionContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_equalsExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(821);
			match(EQUALS);
			setState(822);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(qasm3Parser.EQUALS, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(824);
			_la = _input.LA(1);
			if ( !(((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (T__55 - 56)) | (1L << (T__56 - 56)) | (1L << (T__57 - 56)) | (1L << (T__58 - 56)) | (1L << (T__59 - 56)) | (1L << (T__60 - 56)) | (1L << (T__61 - 56)) | (1L << (T__62 - 56)) | (1L << (T__63 - 56)) | (1L << (T__64 - 56)) | (1L << (T__65 - 56)) | (1L << (T__66 - 56)) | (1L << (EQUALS - 56)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetDeclarationContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(qasm3Parser.LBRACE, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(qasm3Parser.RBRACE, 0); }
		public RangeDefinitionContext rangeDefinition() {
			return getRuleContext(RangeDefinitionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public SetDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setDeclaration; }
	}

	public final SetDeclarationContext setDeclaration() throws RecognitionException {
		SetDeclarationContext _localctx = new SetDeclarationContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_setDeclaration);
		try {
			setState(832);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(826);
				match(LBRACE);
				setState(827);
				expressionList();
				setState(828);
				match(RBRACE);
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(830);
				rangeDefinition();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(831);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramBlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<ControlDirectiveContext> controlDirective() {
			return getRuleContexts(ControlDirectiveContext.class);
		}
		public ControlDirectiveContext controlDirective(int i) {
			return getRuleContext(ControlDirectiveContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(qasm3Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(qasm3Parser.RBRACE, 0); }
		public ProgramBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programBlock; }
	}

	public final ProgramBlockContext programBlock() throws RecognitionException {
		ProgramBlockContext _localctx = new ProgramBlockContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_programBlock);
		int _la;
		try {
			setState(845);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(834);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(835);
				controlDirective();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(836);
				match(LBRACE);
				setState(841);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (T__67 - 68)) | (1L << (T__69 - 68)) | (1L << (T__71 - 68)) | (1L << (T__72 - 68)) | (1L << (T__73 - 68)) | (1L << (T__74 - 68)) | (1L << (T__75 - 68)) | (1L << (T__79 - 68)) | (1L << (T__80 - 68)) | (1L << (T__81 - 68)) | (1L << (T__82 - 68)) | (1L << (T__83 - 68)) | (1L << (T__84 - 68)) | (1L << (LPAREN - 68)) | (1L << (MINUS - 68)) | (1L << (ImagNumber - 68)) | (1L << (Constant - 68)) | (1L << (Integer - 68)) | (1L << (Identifier - 68)) | (1L << (RealNumber - 68)) | (1L << (TimingLiteral - 68)) | (1L << (StringLiteral - 68)))) != 0)) {
					{
					setState(839);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
					case 1:
						{
						setState(837);
						statement();
						}
						break;
					case 2:
						{
						setState(838);
						controlDirective();
						}
						break;
					}
					}
					setState(843);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(844);
				match(RBRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BranchingStatementContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public List<ProgramBlockContext> programBlock() {
			return getRuleContexts(ProgramBlockContext.class);
		}
		public ProgramBlockContext programBlock(int i) {
			return getRuleContext(ProgramBlockContext.class,i);
		}
		public BranchingStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchingStatement; }
	}

	public final BranchingStatementContext branchingStatement() throws RecognitionException {
		BranchingStatementContext _localctx = new BranchingStatementContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_branchingStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(847);
			match(T__67);
			setState(848);
			match(LPAREN);
			setState(849);
			expression(0);
			setState(850);
			match(RPAREN);
			setState(851);
			programBlock();
			setState(854);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				{
				setState(852);
				match(T__68);
				setState(853);
				programBlock();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopSignatureContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public SetDeclarationContext setDeclaration() {
			return getRuleContext(SetDeclarationContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public LoopSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopSignature; }
	}

	public final LoopSignatureContext loopSignature() throws RecognitionException {
		LoopSignatureContext _localctx = new LoopSignatureContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_loopSignature);
		try {
			setState(865);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__69:
				enterOuterAlt(_localctx, 1);
				{
				setState(856);
				match(T__69);
				setState(857);
				match(Identifier);
				setState(858);
				match(T__70);
				setState(859);
				setDeclaration();
				}
				break;
			case T__71:
				enterOuterAlt(_localctx, 2);
				{
				setState(860);
				match(T__71);
				setState(861);
				match(LPAREN);
				setState(862);
				expression(0);
				setState(863);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopStatementContext extends ParserRuleContext {
		public LoopSignatureContext loopSignature() {
			return getRuleContext(LoopSignatureContext.class,0);
		}
		public ProgramBlockContext programBlock() {
			return getRuleContext(ProgramBlockContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(867);
			loopSignature();
			setState(868);
			programBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EndStatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public EndStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endStatement; }
	}

	public final EndStatementContext endStatement() throws RecognitionException {
		EndStatementContext _localctx = new EndStatementContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_endStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(870);
			match(T__72);
			setState(871);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public QuantumMeasurementContext quantumMeasurement() {
			return getRuleContext(QuantumMeasurementContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(873);
			match(T__73);
			setState(876);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__29:
			case T__30:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__79:
			case T__80:
			case T__82:
			case LPAREN:
			case MINUS:
			case ImagNumber:
			case Constant:
			case Integer:
			case Identifier:
			case RealNumber:
			case TimingLiteral:
			case StringLiteral:
				{
				setState(874);
				expression(0);
				}
				break;
			case T__22:
				{
				setState(875);
				quantumMeasurement();
				}
				break;
			case SEMICOLON:
				break;
			default:
				break;
			}
			setState(878);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ControlDirectiveContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public EndStatementContext endStatement() {
			return getRuleContext(EndStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ControlDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlDirective; }
	}

	public final ControlDirectiveContext controlDirective() throws RecognitionException {
		ControlDirectiveContext _localctx = new ControlDirectiveContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_controlDirective);
		int _la;
		try {
			setState(884);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__74:
			case T__75:
				enterOuterAlt(_localctx, 1);
				{
				setState(880);
				_la = _input.LA(1);
				if ( !(_la==T__74 || _la==T__75) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(881);
				match(SEMICOLON);
				}
				break;
			case T__72:
				enterOuterAlt(_localctx, 2);
				{
				setState(882);
				endStatement();
				}
				break;
			case T__73:
				enterOuterAlt(_localctx, 3);
				{
				setState(883);
				returnStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExternDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public ClassicalTypeListContext classicalTypeList() {
			return getRuleContext(ClassicalTypeListContext.class,0);
		}
		public ReturnSignatureContext returnSignature() {
			return getRuleContext(ReturnSignatureContext.class,0);
		}
		public ExternDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externDeclaration; }
	}

	public final ExternDeclarationContext externDeclaration() throws RecognitionException {
		ExternDeclarationContext _localctx = new ExternDeclarationContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_externDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(886);
			match(T__76);
			setState(887);
			match(Identifier);
			setState(888);
			match(LPAREN);
			setState(890);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0) || _la==T__79 || _la==T__80) {
				{
				setState(889);
				classicalTypeList();
				}
			}

			setState(892);
			match(RPAREN);
			setState(894);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(893);
				returnSignature();
				}
			}

			setState(896);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExternOrSubroutineCallContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ExternOrSubroutineCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externOrSubroutineCall; }
	}

	public final ExternOrSubroutineCallContext externOrSubroutineCall() throws RecognitionException {
		ExternOrSubroutineCallContext _localctx = new ExternOrSubroutineCallContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_externOrSubroutineCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(898);
			match(Identifier);
			setState(899);
			match(LPAREN);
			setState(901);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__29) | (1L << T__30) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54))) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__82 - 80)) | (1L << (LPAREN - 80)) | (1L << (MINUS - 80)) | (1L << (ImagNumber - 80)) | (1L << (Constant - 80)) | (1L << (Integer - 80)) | (1L << (Identifier - 80)) | (1L << (RealNumber - 80)) | (1L << (TimingLiteral - 80)) | (1L << (StringLiteral - 80)))) != 0)) {
				{
				setState(900);
				expressionList();
				}
			}

			setState(903);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubroutineDefinitionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public SubroutineBlockContext subroutineBlock() {
			return getRuleContext(SubroutineBlockContext.class,0);
		}
		public AnyTypeArgumentListContext anyTypeArgumentList() {
			return getRuleContext(AnyTypeArgumentListContext.class,0);
		}
		public ReturnSignatureContext returnSignature() {
			return getRuleContext(ReturnSignatureContext.class,0);
		}
		public SubroutineDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subroutineDefinition; }
	}

	public final SubroutineDefinitionContext subroutineDefinition() throws RecognitionException {
		SubroutineDefinitionContext _localctx = new SubroutineDefinitionContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_subroutineDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
			match(T__77);
			setState(906);
			match(Identifier);
			setState(907);
			match(LPAREN);
			setState(909);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0) || _la==T__79 || _la==T__80) {
				{
				setState(908);
				anyTypeArgumentList();
				}
			}

			setState(911);
			match(RPAREN);
			setState(913);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(912);
				returnSignature();
				}
			}

			setState(915);
			subroutineBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubroutineBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(qasm3Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(qasm3Parser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public SubroutineBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subroutineBlock; }
	}

	public final SubroutineBlockContext subroutineBlock() throws RecognitionException {
		SubroutineBlockContext _localctx = new SubroutineBlockContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_subroutineBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(917);
			match(LBRACE);
			setState(921);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (T__67 - 68)) | (1L << (T__69 - 68)) | (1L << (T__71 - 68)) | (1L << (T__72 - 68)) | (1L << (T__79 - 68)) | (1L << (T__80 - 68)) | (1L << (T__81 - 68)) | (1L << (T__82 - 68)) | (1L << (T__83 - 68)) | (1L << (T__84 - 68)) | (1L << (LPAREN - 68)) | (1L << (MINUS - 68)) | (1L << (ImagNumber - 68)) | (1L << (Constant - 68)) | (1L << (Integer - 68)) | (1L << (Identifier - 68)) | (1L << (RealNumber - 68)) | (1L << (TimingLiteral - 68)) | (1L << (StringLiteral - 68)))) != 0)) {
				{
				{
				setState(918);
				statement();
				}
				}
				setState(923);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(925);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__73) {
				{
				setState(924);
				returnStatement();
				}
			}

			setState(927);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PragmaContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(qasm3Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(qasm3Parser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public PragmaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma; }
	}

	public final PragmaContext pragma() throws RecognitionException {
		PragmaContext _localctx = new PragmaContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_pragma);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(929);
			match(T__78);
			setState(930);
			match(LBRACE);
			setState(934);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (T__67 - 68)) | (1L << (T__69 - 68)) | (1L << (T__71 - 68)) | (1L << (T__72 - 68)) | (1L << (T__79 - 68)) | (1L << (T__80 - 68)) | (1L << (T__81 - 68)) | (1L << (T__82 - 68)) | (1L << (T__83 - 68)) | (1L << (T__84 - 68)) | (1L << (LPAREN - 68)) | (1L << (MINUS - 68)) | (1L << (ImagNumber - 68)) | (1L << (Constant - 68)) | (1L << (Integer - 68)) | (1L << (Identifier - 68)) | (1L << (RealNumber - 68)) | (1L << (TimingLiteral - 68)) | (1L << (StringLiteral - 68)))) != 0)) {
				{
				{
				setState(931);
				statement();
				}
				}
				setState(936);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(937);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimingTypeContext extends ParserRuleContext {
		public TimingTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timingType; }
	}

	public final TimingTypeContext timingType() throws RecognitionException {
		TimingTypeContext _localctx = new TimingTypeContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_timingType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(939);
			_la = _input.LA(1);
			if ( !(_la==T__79 || _la==T__80) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimingBoxContext extends ParserRuleContext {
		public QuantumBlockContext quantumBlock() {
			return getRuleContext(QuantumBlockContext.class,0);
		}
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public TimingBoxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timingBox; }
	}

	public final TimingBoxContext timingBox() throws RecognitionException {
		TimingBoxContext _localctx = new TimingBoxContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_timingBox);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(941);
			match(T__81);
			setState(943);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(942);
				designator();
				}
			}

			setState(945);
			quantumBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimingIdentifierContext extends ParserRuleContext {
		public TerminalNode TimingLiteral() { return getToken(qasm3Parser.TimingLiteral, 0); }
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public QuantumBlockContext quantumBlock() {
			return getRuleContext(QuantumBlockContext.class,0);
		}
		public TimingIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timingIdentifier; }
	}

	public final TimingIdentifierContext timingIdentifier() throws RecognitionException {
		TimingIdentifierContext _localctx = new TimingIdentifierContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_timingIdentifier);
		try {
			setState(955);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TimingLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(947);
				match(TimingLiteral);
				}
				break;
			case T__82:
				enterOuterAlt(_localctx, 2);
				{
				setState(948);
				match(T__82);
				setState(949);
				match(LPAREN);
				setState(952);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(950);
					match(Identifier);
					}
					break;
				case LBRACE:
					{
					setState(951);
					quantumBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(954);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimingInstructionNameContext extends ParserRuleContext {
		public TimingInstructionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timingInstructionName; }
	}

	public final TimingInstructionNameContext timingInstructionName() throws RecognitionException {
		TimingInstructionNameContext _localctx = new TimingInstructionNameContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_timingInstructionName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(957);
			_la = _input.LA(1);
			if ( !(_la==T__83 || _la==T__84) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimingInstructionContext extends ParserRuleContext {
		public TimingInstructionNameContext timingInstructionName() {
			return getRuleContext(TimingInstructionNameContext.class,0);
		}
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public IndexIdentifierListContext indexIdentifierList() {
			return getRuleContext(IndexIdentifierListContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TimingInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timingInstruction; }
	}

	public final TimingInstructionContext timingInstruction() throws RecognitionException {
		TimingInstructionContext _localctx = new TimingInstructionContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_timingInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(959);
			timingInstructionName();
			setState(965);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(960);
				match(LPAREN);
				setState(962);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__29) | (1L << T__30) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54))) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__82 - 80)) | (1L << (LPAREN - 80)) | (1L << (MINUS - 80)) | (1L << (ImagNumber - 80)) | (1L << (Constant - 80)) | (1L << (Integer - 80)) | (1L << (Identifier - 80)) | (1L << (RealNumber - 80)) | (1L << (TimingLiteral - 80)) | (1L << (StringLiteral - 80)))) != 0)) {
					{
					setState(961);
					expressionList();
					}
				}

				setState(964);
				match(RPAREN);
				}
			}

			setState(967);
			designator();
			setState(968);
			indexIdentifierList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimingStatementContext extends ParserRuleContext {
		public TimingInstructionContext timingInstruction() {
			return getRuleContext(TimingInstructionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public TimingBoxContext timingBox() {
			return getRuleContext(TimingBoxContext.class,0);
		}
		public TimingStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timingStatement; }
	}

	public final TimingStatementContext timingStatement() throws RecognitionException {
		TimingStatementContext _localctx = new TimingStatementContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_timingStatement);
		try {
			setState(974);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__83:
			case T__84:
				enterOuterAlt(_localctx, 1);
				{
				setState(970);
				timingInstruction();
				setState(971);
				match(SEMICOLON);
				}
				break;
			case T__81:
				enterOuterAlt(_localctx, 2);
				{
				setState(973);
				timingBox();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalibrationContext extends ParserRuleContext {
		public CalibrationGrammarDeclarationContext calibrationGrammarDeclaration() {
			return getRuleContext(CalibrationGrammarDeclarationContext.class,0);
		}
		public CalibrationDefinitionContext calibrationDefinition() {
			return getRuleContext(CalibrationDefinitionContext.class,0);
		}
		public CalibrationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calibration; }
	}

	public final CalibrationContext calibration() throws RecognitionException {
		CalibrationContext _localctx = new CalibrationContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_calibration);
		try {
			setState(978);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__85:
				enterOuterAlt(_localctx, 1);
				{
				setState(976);
				calibrationGrammarDeclaration();
				}
				break;
			case T__86:
				enterOuterAlt(_localctx, 2);
				{
				setState(977);
				calibrationDefinition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalibrationGrammarDeclarationContext extends ParserRuleContext {
		public CalibrationGrammarContext calibrationGrammar() {
			return getRuleContext(CalibrationGrammarContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(qasm3Parser.SEMICOLON, 0); }
		public CalibrationGrammarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calibrationGrammarDeclaration; }
	}

	public final CalibrationGrammarDeclarationContext calibrationGrammarDeclaration() throws RecognitionException {
		CalibrationGrammarDeclarationContext _localctx = new CalibrationGrammarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_calibrationGrammarDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(980);
			match(T__85);
			setState(981);
			calibrationGrammar();
			setState(982);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalibrationDefinitionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(qasm3Parser.Identifier, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(qasm3Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(qasm3Parser.RBRACE, 0); }
		public TerminalNode LPAREN() { return getToken(qasm3Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(qasm3Parser.RPAREN, 0); }
		public ReturnSignatureContext returnSignature() {
			return getRuleContext(ReturnSignatureContext.class,0);
		}
		public CalibrationArgumentListContext calibrationArgumentList() {
			return getRuleContext(CalibrationArgumentListContext.class,0);
		}
		public CalibrationDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calibrationDefinition; }
	}

	public final CalibrationDefinitionContext calibrationDefinition() throws RecognitionException {
		CalibrationDefinitionContext _localctx = new CalibrationDefinitionContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_calibrationDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(984);
			match(T__86);
			setState(985);
			match(Identifier);
			setState(991);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(986);
				match(LPAREN);
				setState(988);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__29) | (1L << T__30) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54))) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__82 - 80)) | (1L << (LPAREN - 80)) | (1L << (MINUS - 80)) | (1L << (ImagNumber - 80)) | (1L << (Constant - 80)) | (1L << (Integer - 80)) | (1L << (Identifier - 80)) | (1L << (RealNumber - 80)) | (1L << (TimingLiteral - 80)) | (1L << (StringLiteral - 80)))) != 0)) {
					{
					setState(987);
					calibrationArgumentList();
					}
				}

				setState(990);
				match(RPAREN);
				}
			}

			setState(993);
			identifierList();
			setState(995);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(994);
				returnSignature();
				}
			}

			setState(997);
			match(LBRACE);
			setState(1001);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(998);
					matchWildcard();
					}
					} 
				}
				setState(1003);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
			}
			setState(1004);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalibrationGrammarContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(qasm3Parser.StringLiteral, 0); }
		public CalibrationGrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calibrationGrammar; }
	}

	public final CalibrationGrammarContext calibrationGrammar() throws RecognitionException {
		CalibrationGrammarContext _localctx = new CalibrationGrammarContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_calibrationGrammar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1006);
			_la = _input.LA(1);
			if ( !(_la==T__87 || _la==StringLiteral) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalibrationArgumentListContext extends ParserRuleContext {
		public ClassicalArgumentListContext classicalArgumentList() {
			return getRuleContext(ClassicalArgumentListContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public CalibrationArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calibrationArgumentList; }
	}

	public final CalibrationArgumentListContext calibrationArgumentList() throws RecognitionException {
		CalibrationArgumentListContext _localctx = new CalibrationArgumentListContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_calibrationArgumentList);
		try {
			setState(1010);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1008);
				classicalArgumentList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1009);
				expressionList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 35:
			return indexIdentifier_sempred((IndexIdentifierContext)_localctx, predIndex);
		case 60:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 61:
			return logicalAndExpression_sempred((LogicalAndExpressionContext)_localctx, predIndex);
		case 62:
			return bitOrExpression_sempred((BitOrExpressionContext)_localctx, predIndex);
		case 63:
			return xOrExpression_sempred((XOrExpressionContext)_localctx, predIndex);
		case 64:
			return bitAndExpression_sempred((BitAndExpressionContext)_localctx, predIndex);
		case 65:
			return equalityExpression_sempred((EqualityExpressionContext)_localctx, predIndex);
		case 66:
			return comparisonExpression_sempred((ComparisonExpressionContext)_localctx, predIndex);
		case 67:
			return bitShiftExpression_sempred((BitShiftExpressionContext)_localctx, predIndex);
		case 68:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 69:
			return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		case 72:
			return expressionTerminator_sempred((ExpressionTerminatorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean indexIdentifier_sempred(IndexIdentifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalAndExpression_sempred(LogicalAndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean bitOrExpression_sempred(BitOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean xOrExpression_sempred(XOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean bitAndExpression_sempred(BitAndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityExpression_sempred(EqualityExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean comparisonExpression_sempred(ComparisonExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean bitShiftExpression_sempred(BitShiftExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicativeExpression_sempred(MultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expressionTerminator_sempred(ExpressionTerminatorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3w\u03f7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\3\2\3\2\3\2"+
		"\7\2\u00d6\n\2\f\2\16\2\u00d9\13\2\3\3\5\3\u00dc\n\3\3\3\7\3\u00df\n\3"+
		"\f\3\16\3\u00e2\13\3\3\3\7\3\u00e5\n\3\f\3\16\3\u00e8\13\3\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u00ff\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0109\n\t\3\n\3\n"+
		"\3\n\3\13\3\13\5\13\u0110\n\13\3\13\3\13\3\f\3\f\5\f\u0116\n\f\3\f\3\f"+
		"\3\f\3\r\3\r\5\r\u011d\n\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\7\20\u012a\n\20\f\20\16\20\u012d\13\20\3\20\3\20\3\21\3\21"+
		"\3\21\5\21\u0134\n\21\3\21\3\21\5\21\u0138\n\21\3\21\5\21\u013b\n\21\3"+
		"\22\3\22\3\22\5\22\u0140\n\22\3\22\3\22\5\22\u0144\n\22\3\22\5\22\u0147"+
		"\n\22\3\23\3\23\3\23\7\23\u014c\n\23\f\23\16\23\u014f\13\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\5\26\u0157\n\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u015f\n\27\3\27\3\27\3\27\3\27\3\27\5\27\u0166\n\27\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\5\32\u0173\n\32\3\33\3\33\3\33"+
		"\5\33\u0178\n\33\3\34\3\34\3\34\5\34\u017d\n\34\3\34\3\34\5\34\u0181\n"+
		"\34\3\34\5\34\u0184\n\34\3\34\5\34\u0187\n\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\5\35\u018f\n\35\3\36\3\36\3\36\3\36\5\36\u0195\n\36\3\37\3\37\3"+
		"\37\7\37\u019a\n\37\f\37\16\37\u019d\13\37\3\37\3\37\3 \3 \3 \3 \5 \u01a5"+
		"\n \3 \3 \3 \3 \3 \5 \u01ac\n \3 \3 \5 \u01b0\n \3 \3 \3 \3 \3 \3 \3 "+
		"\5 \u01b9\n \3!\3!\3!\7!\u01be\n!\f!\16!\u01c1\13!\3\"\3\"\5\"\u01c5\n"+
		"\"\3#\3#\3#\7#\u01ca\n#\f#\16#\u01cd\13#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\5%\u01df\n%\5%\u01e1\n%\3%\3%\3%\7%\u01e6\n%\f%\16"+
		"%\u01e9\13%\3&\3&\3&\7&\u01ee\n&\f&\16&\u01f1\13&\3\'\3\'\5\'\u01f5\n"+
		"\'\3\'\3\'\5\'\u01f9\n\'\3\'\3\'\5\'\u01fd\n\'\3\'\3\'\3(\3(\3(\3(\3)"+
		"\3)\3)\5)\u0208\n)\3)\5)\u020b\n)\3)\3)\3*\3*\3+\3+\3+\7+\u0214\n+\f+"+
		"\16+\u0217\13+\3+\3+\3,\3,\3,\3-\3-\3-\7-\u0221\n-\f-\16-\u0224\13-\3"+
		"-\5-\u0227\n-\3.\3.\3.\3.\5.\u022d\n.\3/\3/\3/\3/\3/\5/\u0234\n/\3\60"+
		"\7\60\u0237\n\60\f\60\16\60\u023a\13\60\3\60\3\60\3\60\3\60\3\60\5\60"+
		"\u0241\n\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\5\63\u024c\n"+
		"\63\3\63\3\63\3\63\3\63\5\63\u0252\n\63\3\64\3\64\5\64\u0256\n\64\3\65"+
		"\3\65\3\65\5\65\u025b\n\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67"+
		"\3\67\3\67\3\67\5\67\u0269\n\67\38\78\u026c\n8\f8\168\u026f\138\38\38"+
		"\38\38\38\58\u0276\n8\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3=\3>\3>\3>"+
		"\3>\5>\u0289\n>\3>\3>\3>\7>\u028e\n>\f>\16>\u0291\13>\3?\3?\3?\3?\3?\3"+
		"?\7?\u0299\n?\f?\16?\u029c\13?\3@\3@\3@\3@\3@\3@\7@\u02a4\n@\f@\16@\u02a7"+
		"\13@\3A\3A\3A\3A\3A\3A\7A\u02af\nA\fA\16A\u02b2\13A\3B\3B\3B\3B\3B\3B"+
		"\7B\u02ba\nB\fB\16B\u02bd\13B\3C\3C\3C\3C\3C\3C\3C\7C\u02c6\nC\fC\16C"+
		"\u02c9\13C\3D\3D\3D\3D\3D\3D\3D\7D\u02d2\nD\fD\16D\u02d5\13D\3E\3E\3E"+
		"\3E\3E\3E\7E\u02dd\nE\fE\16E\u02e0\13E\3F\3F\3F\3F\3F\3F\7F\u02e8\nF\f"+
		"F\16F\u02eb\13F\3G\3G\3G\5G\u02f0\nG\3G\3G\3G\3G\5G\u02f6\nG\7G\u02f8"+
		"\nG\fG\16G\u02fb\13G\3H\3H\3H\3I\3I\3I\3I\3I\5I\u0305\nI\3J\3J\3J\3J\3"+
		"J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\5J\u0316\nJ\3J\3J\3J\3J\3J\7J\u031d\n"+
		"J\fJ\16J\u0320\13J\3K\3K\3L\3L\5L\u0326\nL\3L\3L\3L\3L\3M\3M\3N\3N\3O"+
		"\3O\3O\7O\u0333\nO\fO\16O\u0336\13O\3P\3P\3P\3Q\3Q\3R\3R\3R\3R\3R\3R\5"+
		"R\u0343\nR\3S\3S\3S\3S\3S\7S\u034a\nS\fS\16S\u034d\13S\3S\5S\u0350\nS"+
		"\3T\3T\3T\3T\3T\3T\3T\5T\u0359\nT\3U\3U\3U\3U\3U\3U\3U\3U\3U\5U\u0364"+
		"\nU\3V\3V\3V\3W\3W\3W\3X\3X\3X\5X\u036f\nX\3X\3X\3Y\3Y\3Y\3Y\5Y\u0377"+
		"\nY\3Z\3Z\3Z\3Z\5Z\u037d\nZ\3Z\3Z\5Z\u0381\nZ\3Z\3Z\3[\3[\3[\5[\u0388"+
		"\n[\3[\3[\3\\\3\\\3\\\3\\\5\\\u0390\n\\\3\\\3\\\5\\\u0394\n\\\3\\\3\\"+
		"\3]\3]\7]\u039a\n]\f]\16]\u039d\13]\3]\5]\u03a0\n]\3]\3]\3^\3^\3^\7^\u03a7"+
		"\n^\f^\16^\u03aa\13^\3^\3^\3_\3_\3`\3`\5`\u03b2\n`\3`\3`\3a\3a\3a\3a\3"+
		"a\5a\u03bb\na\3a\5a\u03be\na\3b\3b\3c\3c\3c\5c\u03c5\nc\3c\5c\u03c8\n"+
		"c\3c\3c\3c\3d\3d\3d\3d\5d\u03d1\nd\3e\3e\5e\u03d5\ne\3f\3f\3f\3f\3g\3"+
		"g\3g\3g\5g\u03df\ng\3g\5g\u03e2\ng\3g\3g\5g\u03e6\ng\3g\3g\7g\u03ea\n"+
		"g\fg\16g\u03ed\13g\3g\3g\3h\3h\3i\3i\5i\u03f5\ni\3i\3\u03eb\16Hz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u0092j\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|"+
		"~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096"+
		"\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae"+
		"\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6"+
		"\u00c8\u00ca\u00cc\u00ce\u00d0\2\26\4\2qqss\3\2\5\6\3\2\t\n\3\2\13\16"+
		"\4\2\25\26rr\3\2\36\37\4\2 !hh\3\2\"%\3\2&\'\4\2\23\23((\3\2,-\3\2gh\3"+
		"\2ik\3\2/\60\3\2\619\4\2:Eee\3\2MN\3\2RS\3\2VW\4\2ZZuu\2\u041b\2\u00d2"+
		"\3\2\2\2\4\u00db\3\2\2\2\6\u00e9\3\2\2\2\b\u00ed\3\2\2\2\n\u00f1\3\2\2"+
		"\2\f\u00f3\3\2\2\2\16\u00fe\3\2\2\2\20\u0108\3\2\2\2\22\u010a\3\2\2\2"+
		"\24\u010f\3\2\2\2\26\u0113\3\2\2\2\30\u011c\3\2\2\2\32\u0120\3\2\2\2\34"+
		"\u0123\3\2\2\2\36\u012b\3\2\2\2 \u013a\3\2\2\2\"\u0146\3\2\2\2$\u0148"+
		"\3\2\2\2&\u0150\3\2\2\2(\u0152\3\2\2\2*\u0156\3\2\2\2,\u0165\3\2\2\2."+
		"\u0167\3\2\2\2\60\u016a\3\2\2\2\62\u016e\3\2\2\2\64\u0174\3\2\2\2\66\u0183"+
		"\3\2\2\28\u0188\3\2\2\2:\u0194\3\2\2\2<\u019b\3\2\2\2>\u01b8\3\2\2\2@"+
		"\u01ba\3\2\2\2B\u01c4\3\2\2\2D\u01cb\3\2\2\2F\u01d0\3\2\2\2H\u01e0\3\2"+
		"\2\2J\u01ea\3\2\2\2L\u01f2\3\2\2\2N\u0200\3\2\2\2P\u0204\3\2\2\2R\u020e"+
		"\3\2\2\2T\u0210\3\2\2\2V\u021a\3\2\2\2X\u0226\3\2\2\2Z\u022c\3\2\2\2\\"+
		"\u0233\3\2\2\2^\u0238\3\2\2\2`\u0242\3\2\2\2b\u0245\3\2\2\2d\u0251\3\2"+
		"\2\2f\u0253\3\2\2\2h\u025a\3\2\2\2j\u025e\3\2\2\2l\u0263\3\2\2\2n\u026d"+
		"\3\2\2\2p\u0279\3\2\2\2r\u027b\3\2\2\2t\u027d\3\2\2\2v\u027f\3\2\2\2x"+
		"\u0281\3\2\2\2z\u0288\3\2\2\2|\u0292\3\2\2\2~\u029d\3\2\2\2\u0080\u02a8"+
		"\3\2\2\2\u0082\u02b3\3\2\2\2\u0084\u02be\3\2\2\2\u0086\u02ca\3\2\2\2\u0088"+
		"\u02d6\3\2\2\2\u008a\u02e1\3\2\2\2\u008c\u02ef\3\2\2\2\u008e\u02fc\3\2"+
		"\2\2\u0090\u0304\3\2\2\2\u0092\u0315\3\2\2\2\u0094\u0321\3\2\2\2\u0096"+
		"\u0325\3\2\2\2\u0098\u032b\3\2\2\2\u009a\u032d\3\2\2\2\u009c\u032f\3\2"+
		"\2\2\u009e\u0337\3\2\2\2\u00a0\u033a\3\2\2\2\u00a2\u0342\3\2\2\2\u00a4"+
		"\u034f\3\2\2\2\u00a6\u0351\3\2\2\2\u00a8\u0363\3\2\2\2\u00aa\u0365\3\2"+
		"\2\2\u00ac\u0368\3\2\2\2\u00ae\u036b\3\2\2\2\u00b0\u0376\3\2\2\2\u00b2"+
		"\u0378\3\2\2\2\u00b4\u0384\3\2\2\2\u00b6\u038b\3\2\2\2\u00b8\u0397\3\2"+
		"\2\2\u00ba\u03a3\3\2\2\2\u00bc\u03ad\3\2\2\2\u00be\u03af\3\2\2\2\u00c0"+
		"\u03bd\3\2\2\2\u00c2\u03bf\3\2\2\2\u00c4\u03c1\3\2\2\2\u00c6\u03d0\3\2"+
		"\2\2\u00c8\u03d4\3\2\2\2\u00ca\u03d6\3\2\2\2\u00cc\u03da\3\2\2\2\u00ce"+
		"\u03f0\3\2\2\2\u00d0\u03f4\3\2\2\2\u00d2\u00d7\5\4\3\2\u00d3\u00d6\5\16"+
		"\b\2\u00d4\u00d6\5\20\t\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6"+
		"\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\3\3\2\2\2"+
		"\u00d9\u00d7\3\2\2\2\u00da\u00dc\5\6\4\2\u00db\u00da\3\2\2\2\u00db\u00dc"+
		"\3\2\2\2\u00dc\u00e0\3\2\2\2\u00dd\u00df\5\b\5\2\u00de\u00dd\3\2\2\2\u00df"+
		"\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e6\3\2"+
		"\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e5\5\f\7\2\u00e4\u00e3\3\2\2\2\u00e5"+
		"\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\5\3\2\2\2"+
		"\u00e8\u00e6\3\2\2\2\u00e9\u00ea\7\3\2\2\u00ea\u00eb\t\2\2\2\u00eb\u00ec"+
		"\7b\2\2\u00ec\7\3\2\2\2\u00ed\u00ee\7\4\2\2\u00ee\u00ef\7u\2\2\u00ef\u00f0"+
		"\7b\2\2\u00f0\t\3\2\2\2\u00f1\u00f2\t\3\2\2\u00f2\13\3\2\2\2\u00f3\u00f4"+
		"\5\n\6\2\u00f4\u00f5\5,\27\2\u00f5\u00f6\7r\2\2\u00f6\u00f7\7b\2\2\u00f7"+
		"\r\3\2\2\2\u00f8\u00ff\5\u00b6\\\2\u00f9\u00ff\5\u00b2Z\2\u00fa\u00ff"+
		"\5N(\2\u00fb\u00ff\5\u00c8e\2\u00fc\u00ff\5\22\n\2\u00fd\u00ff\5\u00ba"+
		"^\2\u00fe\u00f8\3\2\2\2\u00fe\u00f9\3\2\2\2\u00fe\u00fa\3\2\2\2\u00fe"+
		"\u00fb\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\17\3\2\2"+
		"\2\u0100\u0109\5x=\2\u0101\u0109\5\30\r\2\u0102\u0109\5\24\13\2\u0103"+
		"\u0109\5\u00a6T\2\u0104\u0109\5\u00aaV\2\u0105\u0109\5\u00acW\2\u0106"+
		"\u0109\5F$\2\u0107\u0109\5Z.\2\u0108\u0100\3\2\2\2\u0108\u0101\3\2\2\2"+
		"\u0108\u0102\3\2\2\2\u0108\u0103\3\2\2\2\u0108\u0104\3\2\2\2\u0108\u0105"+
		"\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0107\3\2\2\2\u0109\21\3\2\2\2\u010a"+
		"\u010b\5 \21\2\u010b\u010c\7b\2\2\u010c\23\3\2\2\2\u010d\u0110\5:\36\2"+
		"\u010e\u0110\5\60\31\2\u010f\u010d\3\2\2\2\u010f\u010e\3\2\2\2\u0110\u0111"+
		"\3\2\2\2\u0111\u0112\7b\2\2\u0112\25\3\2\2\2\u0113\u0115\7r\2\2\u0114"+
		"\u0116\5\34\17\2\u0115\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3"+
		"\2\2\2\u0117\u0118\5\u00a0Q\2\u0118\u0119\5z>\2\u0119\27\3\2\2\2\u011a"+
		"\u011d\5\26\f\2\u011b\u011d\5d\63\2\u011c\u011a\3\2\2\2\u011c\u011b\3"+
		"\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\7b\2\2\u011f\31\3\2\2\2\u0120\u0121"+
		"\7f\2\2\u0121\u0122\5,\27\2\u0122\33\3\2\2\2\u0123\u0124\7[\2\2\u0124"+
		"\u0125\5z>\2\u0125\u0126\7\\\2\2\u0126\35\3\2\2\2\u0127\u0128\7r\2\2\u0128"+
		"\u012a\7d\2\2\u0129\u0127\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2"+
		"\2\2\u012b\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e"+
		"\u012f\7r\2\2\u012f\37\3\2\2\2\u0130\u0131\7\7\2\2\u0131\u0133\7r\2\2"+
		"\u0132\u0134\5\34\17\2\u0133\u0132\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u013b"+
		"\3\2\2\2\u0135\u0137\7\b\2\2\u0136\u0138\5\34\17\2\u0137\u0136\3\2\2\2"+
		"\u0137\u0138\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013b\7r\2\2\u013a\u0130"+
		"\3\2\2\2\u013a\u0135\3\2\2\2\u013b!\3\2\2\2\u013c\u013d\7\7\2\2\u013d"+
		"\u013f\7r\2\2\u013e\u0140\5\34\17\2\u013f\u013e\3\2\2\2\u013f\u0140\3"+
		"\2\2\2\u0140\u0147\3\2\2\2\u0141\u0143\7\b\2\2\u0142\u0144\5\34\17\2\u0143"+
		"\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\7r"+
		"\2\2\u0146\u013c\3\2\2\2\u0146\u0141\3\2\2\2\u0147#\3\2\2\2\u0148\u014d"+
		"\5\"\22\2\u0149\u014a\7d\2\2\u014a\u014c\5\"\22\2\u014b\u0149\3\2\2\2"+
		"\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e%\3"+
		"\2\2\2\u014f\u014d\3\2\2\2\u0150\u0151\t\4\2\2\u0151\'\3\2\2\2\u0152\u0153"+
		"\t\5\2\2\u0153)\3\2\2\2\u0154\u0157\7\17\2\2\u0155\u0157\5\u00bc_\2\u0156"+
		"\u0154\3\2\2\2\u0156\u0155\3\2\2\2\u0157+\3\2\2\2\u0158\u0159\5(\25\2"+
		"\u0159\u015a\5\34\17\2\u015a\u0166\3\2\2\2\u015b\u0166\5*\26\2\u015c\u015e"+
		"\5&\24\2\u015d\u015f\5\34\17\2\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2\2"+
		"\u015f\u0166\3\2\2\2\u0160\u0161\7\20\2\2\u0161\u0162\7[\2\2\u0162\u0163"+
		"\5.\30\2\u0163\u0164\7\\\2\2\u0164\u0166\3\2\2\2\u0165\u0158\3\2\2\2\u0165"+
		"\u015b\3\2\2\2\u0165\u015c\3\2\2\2\u0165\u0160\3\2\2\2\u0166-\3\2\2\2"+
		"\u0167\u0168\5(\25\2\u0168\u0169\5\34\17\2\u0169/\3\2\2\2\u016a\u016b"+
		"\7\21\2\2\u016b\u016c\7r\2\2\u016c\u016d\5\u009eP\2\u016d\61\3\2\2\2\u016e"+
		"\u016f\5(\25\2\u016f\u0170\5\34\17\2\u0170\u0172\7r\2\2\u0171\u0173\5"+
		"\u009eP\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\63\3\2\2\2\u0174"+
		"\u0175\5*\26\2\u0175\u0177\7r\2\2\u0176\u0178\5\u009eP\2\u0177\u0176\3"+
		"\2\2\2\u0177\u0178\3\2\2\2\u0178\65\3\2\2\2\u0179\u017a\7\n\2\2\u017a"+
		"\u017c\7r\2\2\u017b\u017d\5\34\17\2\u017c\u017b\3\2\2\2\u017c\u017d\3"+
		"\2\2\2\u017d\u0184\3\2\2\2\u017e\u0180\7\t\2\2\u017f\u0181\5\34\17\2\u0180"+
		"\u017f\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0184\7r"+
		"\2\2\u0183\u0179\3\2\2\2\u0183\u017e\3\2\2\2\u0184\u0186\3\2\2\2\u0185"+
		"\u0187\5\u009eP\2\u0186\u0185\3\2\2\2\u0186\u0187\3\2\2\2\u0187\67\3\2"+
		"\2\2\u0188\u0189\7\20\2\2\u0189\u018a\7[\2\2\u018a\u018b\5.\30\2\u018b"+
		"\u018c\7\\\2\2\u018c\u018e\7r\2\2\u018d\u018f\5\u009eP\2\u018e\u018d\3"+
		"\2\2\2\u018e\u018f\3\2\2\2\u018f9\3\2\2\2\u0190\u0195\5\62\32\2\u0191"+
		"\u0195\5\64\33\2\u0192\u0195\5\66\34\2\u0193\u0195\58\35\2\u0194\u0190"+
		"\3\2\2\2\u0194\u0191\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0193\3\2\2\2\u0195"+
		";\3\2\2\2\u0196\u0197\5,\27\2\u0197\u0198\7d\2\2\u0198\u019a\3\2\2\2\u0199"+
		"\u0196\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2"+
		"\2\2\u019c\u019e\3\2\2\2\u019d\u019b\3\2\2\2\u019e\u019f\5,\27\2\u019f"+
		"=\3\2\2\2\u01a0\u01a1\5(\25\2\u01a1\u01a2\5\34\17\2\u01a2\u01a5\3\2\2"+
		"\2\u01a3\u01a5\5*\26\2\u01a4\u01a0\3\2\2\2\u01a4\u01a3\3\2\2\2\u01a5\u01a6"+
		"\3\2\2\2\u01a6\u01a7\7r\2\2\u01a7\u01b9\3\2\2\2\u01a8\u01a9\7\n\2\2\u01a9"+
		"\u01ab\7r\2\2\u01aa\u01ac\5\34\17\2\u01ab\u01aa\3\2\2\2\u01ab\u01ac\3"+
		"\2\2\2\u01ac\u01b9\3\2\2\2\u01ad\u01af\7\t\2\2\u01ae\u01b0\5\34\17\2\u01af"+
		"\u01ae\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b9\7r"+
		"\2\2\u01b2\u01b3\7\20\2\2\u01b3\u01b4\7[\2\2\u01b4\u01b5\5.\30\2\u01b5"+
		"\u01b6\7\\\2\2\u01b6\u01b7\7r\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01a4\3\2"+
		"\2\2\u01b8\u01a8\3\2\2\2\u01b8\u01ad\3\2\2\2\u01b8\u01b2\3\2\2\2\u01b9"+
		"?\3\2\2\2\u01ba\u01bf\5> \2\u01bb\u01bc\7d\2\2\u01bc\u01be\5> \2\u01bd"+
		"\u01bb\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2"+
		"\2\2\u01c0A\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c5\5> \2\u01c3\u01c5"+
		"\5\"\22\2\u01c4\u01c2\3\2\2\2\u01c4\u01c3\3\2\2\2\u01c5C\3\2\2\2\u01c6"+
		"\u01c7\5B\"\2\u01c7\u01c8\7d\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01c6\3\2\2"+
		"\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01ce"+
		"\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01cf\5B\"\2\u01cfE\3\2\2\2\u01d0\u01d1"+
		"\7\22\2\2\u01d1\u01d2\7r\2\2\u01d2\u01d3\7e\2\2\u01d3\u01d4\5H%\2\u01d4"+
		"\u01d5\7b\2\2\u01d5G\3\2\2\2\u01d6\u01d7\b%\1\2\u01d7\u01d8\7r\2\2\u01d8"+
		"\u01e1\5L\'\2\u01d9\u01de\7r\2\2\u01da\u01db\7[\2\2\u01db\u01dc\5\u009c"+
		"O\2\u01dc\u01dd\7\\\2\2\u01dd\u01df\3\2\2\2\u01de\u01da\3\2\2\2\u01de"+
		"\u01df\3\2\2\2\u01df\u01e1\3\2\2\2\u01e0\u01d6\3\2\2\2\u01e0\u01d9\3\2"+
		"\2\2\u01e1\u01e7\3\2\2\2\u01e2\u01e3\f\3\2\2\u01e3\u01e4\7\23\2\2\u01e4"+
		"\u01e6\5H%\4\u01e5\u01e2\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7\u01e5\3\2\2"+
		"\2\u01e7\u01e8\3\2\2\2\u01e8I\3\2\2\2\u01e9\u01e7\3\2\2\2\u01ea\u01ef"+
		"\5H%\2\u01eb\u01ec\7d\2\2\u01ec\u01ee\5H%\2\u01ed\u01eb\3\2\2\2\u01ee"+
		"\u01f1\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0K\3\2\2\2"+
		"\u01f1\u01ef\3\2\2\2\u01f2\u01f4\7[\2\2\u01f3\u01f5\5z>\2\u01f4\u01f3"+
		"\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f8\7a\2\2\u01f7"+
		"\u01f9\5z>\2\u01f8\u01f7\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fc\3\2\2"+
		"\2\u01fa\u01fb\7a\2\2\u01fb\u01fd\5z>\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd"+
		"\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u01ff\7\\\2\2\u01ffM\3\2\2\2\u0200"+
		"\u0201\7\24\2\2\u0201\u0202\5P)\2\u0202\u0203\5T+\2\u0203O\3\2\2\2\u0204"+
		"\u020a\5R*\2\u0205\u0207\7_\2\2\u0206\u0208\5\36\20\2\u0207\u0206\3\2"+
		"\2\2\u0207\u0208\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020b\7`\2\2\u020a"+
		"\u0205\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020d\5\36"+
		"\20\2\u020dQ\3\2\2\2\u020e\u020f\t\6\2\2\u020fS\3\2\2\2\u0210\u0215\7"+
		"]\2\2\u0211\u0214\5Z.\2\u0212\u0214\5V,\2\u0213\u0211\3\2\2\2\u0213\u0212"+
		"\3\2\2\2\u0214\u0217\3\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216"+
		"\u0218\3\2\2\2\u0217\u0215\3\2\2\2\u0218\u0219\7^\2\2\u0219U\3\2\2\2\u021a"+
		"\u021b\5\u00a8U\2\u021b\u021c\5X-\2\u021cW\3\2\2\2\u021d\u0227\5Z.\2\u021e"+
		"\u0222\7]\2\2\u021f\u0221\5Z.\2\u0220\u021f\3\2\2\2\u0221\u0224\3\2\2"+
		"\2\u0222\u0220\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0225\3\2\2\2\u0224\u0222"+
		"\3\2\2\2\u0225\u0227\7^\2\2\u0226\u021d\3\2\2\2\u0226\u021e\3\2\2\2\u0227"+
		"Y\3\2\2\2\u0228\u0229\5\\/\2\u0229\u022a\7b\2\2\u022a\u022d\3\2\2\2\u022b"+
		"\u022d\5\u00c6d\2\u022c\u0228\3\2\2\2\u022c\u022b\3\2\2\2\u022d[\3\2\2"+
		"\2\u022e\u0234\5n8\2\u022f\u0234\5^\60\2\u0230\u0234\5b\62\2\u0231\u0234"+
		"\5`\61\2\u0232\u0234\5f\64\2\u0233\u022e\3\2\2\2\u0233\u022f\3\2\2\2\u0233"+
		"\u0230\3\2\2\2\u0233\u0231\3\2\2\2\u0233\u0232\3\2\2\2\u0234]\3\2\2\2"+
		"\u0235\u0237\5h\65\2\u0236\u0235\3\2\2\2\u0237\u023a\3\2\2\2\u0238\u0236"+
		"\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023b\3\2\2\2\u023a\u0238\3\2\2\2\u023b"+
		"\u023c\7\27\2\2\u023c\u023d\7_\2\2\u023d\u023e\5z>\2\u023e\u0240\7`\2"+
		"\2\u023f\u0241\5J&\2\u0240\u023f\3\2\2\2\u0240\u0241\3\2\2\2\u0241_\3"+
		"\2\2\2\u0242\u0243\7\30\2\2\u0243\u0244\5J&\2\u0244a\3\2\2\2\u0245\u0246"+
		"\7\31\2\2\u0246\u0247\5J&\2\u0247c\3\2\2\2\u0248\u024b\5b\62\2\u0249\u024a"+
		"\7f\2\2\u024a\u024c\5J&\2\u024b\u0249\3\2\2\2\u024b\u024c\3\2\2\2\u024c"+
		"\u0252\3\2\2\2\u024d\u024e\5J&\2\u024e\u024f\7e\2\2\u024f\u0250\5b\62"+
		"\2\u0250\u0252\3\2\2\2\u0251\u0248\3\2\2\2\u0251\u024d\3\2\2\2\u0252e"+
		"\3\2\2\2\u0253\u0255\7\32\2\2\u0254\u0256\5J&\2\u0255\u0254\3\2\2\2\u0255"+
		"\u0256\3\2\2\2\u0256g\3\2\2\2\u0257\u025b\7\33\2\2\u0258\u025b\5j\66\2"+
		"\u0259\u025b\5l\67\2\u025a\u0257\3\2\2\2\u025a\u0258\3\2\2\2\u025a\u0259"+
		"\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u025d\7\34\2\2\u025di\3\2\2\2\u025e"+
		"\u025f\7\35\2\2\u025f\u0260\7_\2\2\u0260\u0261\5z>\2\u0261\u0262\7`\2"+
		"\2\u0262k\3\2\2\2\u0263\u0268\t\7\2\2\u0264\u0265\7_\2\2\u0265\u0266\5"+
		"z>\2\u0266\u0267\7`\2\2\u0267\u0269\3\2\2\2\u0268\u0264\3\2\2\2\u0268"+
		"\u0269\3\2\2\2\u0269m\3\2\2\2\u026a\u026c\5h\65\2\u026b\u026a\3\2\2\2"+
		"\u026c\u026f\3\2\2\2\u026d\u026b\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u0270"+
		"\3\2\2\2\u026f\u026d\3\2\2\2\u0270\u0275\5R*\2\u0271\u0272\7_\2\2\u0272"+
		"\u0273\5\u009cO\2\u0273\u0274\7`\2\2\u0274\u0276\3\2\2\2\u0275\u0271\3"+
		"\2\2\2\u0275\u0276\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0278\5J&\2\u0278"+
		"o\3\2\2\2\u0279\u027a\t\b\2\2\u027aq\3\2\2\2\u027b\u027c\t\t\2\2\u027c"+
		"s\3\2\2\2\u027d\u027e\t\n\2\2\u027eu\3\2\2\2\u027f\u0280\t\13\2\2\u0280"+
		"w\3\2\2\2\u0281\u0282\5z>\2\u0282\u0283\7b\2\2\u0283y\3\2\2\2\u0284\u0285"+
		"\b>\1\2\u0285\u0289\5\u0092J\2\u0286\u0289\5\u008eH\2\u0287\u0289\5|?"+
		"\2\u0288\u0284\3\2\2\2\u0288\u0286\3\2\2\2\u0288\u0287\3\2\2\2\u0289\u028f"+
		"\3\2\2\2\u028a\u028b\f\3\2\2\u028b\u028c\7\23\2\2\u028c\u028e\5|?\2\u028d"+
		"\u028a\3\2\2\2\u028e\u0291\3\2\2\2\u028f\u028d\3\2\2\2\u028f\u0290\3\2"+
		"\2\2\u0290{\3\2\2\2\u0291\u028f\3\2\2\2\u0292\u0293\b?\1\2\u0293\u0294"+
		"\5~@\2\u0294\u029a\3\2\2\2\u0295\u0296\f\3\2\2\u0296\u0297\7(\2\2\u0297"+
		"\u0299\5~@\2\u0298\u0295\3\2\2\2\u0299\u029c\3\2\2\2\u029a\u0298\3\2\2"+
		"\2\u029a\u029b\3\2\2\2\u029b}\3\2\2\2\u029c\u029a\3\2\2\2\u029d\u029e"+
		"\b@\1\2\u029e\u029f\5\u0080A\2\u029f\u02a5\3\2\2\2\u02a0\u02a1\f\3\2\2"+
		"\u02a1\u02a2\7)\2\2\u02a2\u02a4\5\u0080A\2\u02a3\u02a0\3\2\2\2\u02a4\u02a7"+
		"\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\177\3\2\2\2\u02a7"+
		"\u02a5\3\2\2\2\u02a8\u02a9\bA\1\2\u02a9\u02aa\5\u0082B\2\u02aa\u02b0\3"+
		"\2\2\2\u02ab\u02ac\f\3\2\2\u02ac\u02ad\7*\2\2\u02ad\u02af\5\u0082B\2\u02ae"+
		"\u02ab\3\2\2\2\u02af\u02b2\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b0\u02b1\3\2"+
		"\2\2\u02b1\u0081\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b3\u02b4\bB\1\2\u02b4"+
		"\u02b5\5\u0084C\2\u02b5\u02bb\3\2\2\2\u02b6\u02b7\f\3\2\2\u02b7\u02b8"+
		"\7+\2\2\u02b8\u02ba\5\u0084C\2\u02b9\u02b6\3\2\2\2\u02ba\u02bd\3\2\2\2"+
		"\u02bb\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u0083\3\2\2\2\u02bd\u02bb"+
		"\3\2\2\2\u02be\u02bf\bC\1\2\u02bf\u02c0\5\u0086D\2\u02c0\u02c7\3\2\2\2"+
		"\u02c1\u02c2\f\3\2\2\u02c2\u02c3\5t;\2\u02c3\u02c4\5\u0086D\2\u02c4\u02c6"+
		"\3\2\2\2\u02c5\u02c1\3\2\2\2\u02c6\u02c9\3\2\2\2\u02c7\u02c5\3\2\2\2\u02c7"+
		"\u02c8\3\2\2\2\u02c8\u0085\3\2\2\2\u02c9\u02c7\3\2\2\2\u02ca\u02cb\bD"+
		"\1\2\u02cb\u02cc\5\u0088E\2\u02cc\u02d3\3\2\2\2\u02cd\u02ce\f\3\2\2\u02ce"+
		"\u02cf\5r:\2\u02cf\u02d0\5\u0088E\2\u02d0\u02d2\3\2\2\2\u02d1\u02cd\3"+
		"\2\2\2\u02d2\u02d5\3\2\2\2\u02d3\u02d1\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d4"+
		"\u0087\3\2\2\2\u02d5\u02d3\3\2\2\2\u02d6\u02d7\bE\1\2\u02d7\u02d8\5\u008a"+
		"F\2\u02d8\u02de\3\2\2\2\u02d9\u02da\f\3\2\2\u02da\u02db\t\f\2\2\u02db"+
		"\u02dd\5\u008aF\2\u02dc\u02d9\3\2\2\2\u02dd\u02e0\3\2\2\2\u02de\u02dc"+
		"\3\2\2\2\u02de\u02df\3\2\2\2\u02df\u0089\3\2\2\2\u02e0\u02de\3\2\2\2\u02e1"+
		"\u02e2\bF\1\2\u02e2\u02e3\5\u008cG\2\u02e3\u02e9\3\2\2\2\u02e4\u02e5\f"+
		"\3\2\2\u02e5\u02e6\t\r\2\2\u02e6\u02e8\5\u008cG\2\u02e7\u02e4\3\2\2\2"+
		"\u02e8\u02eb\3\2\2\2\u02e9\u02e7\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u008b"+
		"\3\2\2\2\u02eb\u02e9\3\2\2\2\u02ec\u02ed\bG\1\2\u02ed\u02f0\5\u0090I\2"+
		"\u02ee\u02f0\5\u008eH\2\u02ef\u02ec\3\2\2\2\u02ef\u02ee\3\2\2\2\u02f0"+
		"\u02f9\3\2\2\2\u02f1\u02f2\f\3\2\2\u02f2\u02f5\t\16\2\2\u02f3\u02f6\5"+
		"\u0090I\2\u02f4\u02f6\5\u008eH\2\u02f5\u02f3\3\2\2\2\u02f5\u02f4\3\2\2"+
		"\2\u02f6\u02f8\3\2\2\2\u02f7\u02f1\3\2\2\2\u02f8\u02fb\3\2\2\2\u02f9\u02f7"+
		"\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa\u008d\3\2\2\2\u02fb\u02f9\3\2\2\2\u02fc"+
		"\u02fd\5p9\2\u02fd\u02fe\5\u0090I\2\u02fe\u008f\3\2\2\2\u02ff\u0305\5"+
		"\u0092J\2\u0300\u0301\5\u0092J\2\u0301\u0302\7.\2\2\u0302\u0303\5\u0090"+
		"I\2\u0303\u0305\3\2\2\2\u0304\u02ff\3\2\2\2\u0304\u0300\3\2\2\2\u0305"+
		"\u0091\3\2\2\2\u0306\u0307\bJ\1\2\u0307\u0316\7n\2\2\u0308\u0316\7q\2"+
		"\2\u0309\u0316\7s\2\2\u030a\u0316\7m\2\2\u030b\u0316\5\u0094K\2\u030c"+
		"\u0316\7r\2\2\u030d\u0316\7u\2\2\u030e\u0316\5\u0096L\2\u030f\u0316\5"+
		"\u00b4[\2\u0310\u0316\5\u00c0a\2\u0311\u0312\7_\2\2\u0312\u0313\5z>\2"+
		"\u0313\u0314\7`\2\2\u0314\u0316\3\2\2\2\u0315\u0306\3\2\2\2\u0315\u0308"+
		"\3\2\2\2\u0315\u0309\3\2\2\2\u0315\u030a\3\2\2\2\u0315\u030b\3\2\2\2\u0315"+
		"\u030c\3\2\2\2\u0315\u030d\3\2\2\2\u0315\u030e\3\2\2\2\u0315\u030f\3\2"+
		"\2\2\u0315\u0310\3\2\2\2\u0315\u0311\3\2\2\2\u0316\u031e\3\2\2\2\u0317"+
		"\u0318\f\3\2\2\u0318\u0319\7[\2\2\u0319\u031a\5z>\2\u031a\u031b\7\\\2"+
		"\2\u031b\u031d\3\2\2\2\u031c\u0317\3\2\2\2\u031d\u0320\3\2\2\2\u031e\u031c"+
		"\3\2\2\2\u031e\u031f\3\2\2\2\u031f\u0093\3\2\2\2\u0320\u031e\3\2\2\2\u0321"+
		"\u0322\t\17\2\2\u0322\u0095\3\2\2\2\u0323\u0326\5\u0098M\2\u0324\u0326"+
		"\5\u009aN\2\u0325\u0323\3\2\2\2\u0325\u0324\3\2\2\2\u0326\u0327\3\2\2"+
		"\2\u0327\u0328\7_\2\2\u0328\u0329\5\u009cO\2\u0329\u032a\7`\2\2\u032a"+
		"\u0097\3\2\2\2\u032b\u032c\t\20\2\2\u032c\u0099\3\2\2\2\u032d\u032e\5"+
		",\27\2\u032e\u009b\3\2\2\2\u032f\u0334\5z>\2\u0330\u0331\7d\2\2\u0331"+
		"\u0333\5z>\2\u0332\u0330\3\2\2\2\u0333\u0336\3\2\2\2\u0334\u0332\3\2\2"+
		"\2\u0334\u0335\3\2\2\2\u0335\u009d\3\2\2\2\u0336\u0334\3\2\2\2\u0337\u0338"+
		"\7e\2\2\u0338\u0339\5z>\2\u0339\u009f\3\2\2\2\u033a\u033b\t\21\2\2\u033b"+
		"\u00a1\3\2\2\2\u033c\u033d\7]\2\2\u033d\u033e\5\u009cO\2\u033e\u033f\7"+
		"^\2\2\u033f\u0343\3\2\2\2\u0340\u0343\5L\'\2\u0341\u0343\7r\2\2\u0342"+
		"\u033c\3\2\2\2\u0342\u0340\3\2\2\2\u0342\u0341\3\2\2\2\u0343\u00a3\3\2"+
		"\2\2\u0344\u0350\5\20\t\2\u0345\u0350\5\u00b0Y\2\u0346\u034b\7]\2\2\u0347"+
		"\u034a\5\20\t\2\u0348\u034a\5\u00b0Y\2\u0349\u0347\3\2\2\2\u0349\u0348"+
		"\3\2\2\2\u034a\u034d\3\2\2\2\u034b\u0349\3\2\2\2\u034b\u034c\3\2\2\2\u034c"+
		"\u034e\3\2\2\2\u034d\u034b\3\2\2\2\u034e\u0350\7^\2\2\u034f\u0344\3\2"+
		"\2\2\u034f\u0345\3\2\2\2\u034f\u0346\3\2\2\2\u0350\u00a5\3\2\2\2\u0351"+
		"\u0352\7F\2\2\u0352\u0353\7_\2\2\u0353\u0354\5z>\2\u0354\u0355\7`\2\2"+
		"\u0355\u0358\5\u00a4S\2\u0356\u0357\7G\2\2\u0357\u0359\5\u00a4S\2\u0358"+
		"\u0356\3\2\2\2\u0358\u0359\3\2\2\2\u0359\u00a7\3\2\2\2\u035a\u035b\7H"+
		"\2\2\u035b\u035c\7r\2\2\u035c\u035d\7I\2\2\u035d\u0364\5\u00a2R\2\u035e"+
		"\u035f\7J\2\2\u035f\u0360\7_\2\2\u0360\u0361\5z>\2\u0361\u0362\7`\2\2"+
		"\u0362\u0364\3\2\2\2\u0363\u035a\3\2\2\2\u0363\u035e\3\2\2\2\u0364\u00a9"+
		"\3\2\2\2\u0365\u0366\5\u00a8U\2\u0366\u0367\5\u00a4S\2\u0367\u00ab\3\2"+
		"\2\2\u0368\u0369\7K\2\2\u0369\u036a\7b\2\2\u036a\u00ad\3\2\2\2\u036b\u036e"+
		"\7L\2\2\u036c\u036f\5z>\2\u036d\u036f\5b\62\2\u036e\u036c\3\2\2\2\u036e"+
		"\u036d\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0370\3\2\2\2\u0370\u0371\7b"+
		"\2\2\u0371\u00af\3\2\2\2\u0372\u0373\t\22\2\2\u0373\u0377\7b\2\2\u0374"+
		"\u0377\5\u00acW\2\u0375\u0377\5\u00aeX\2\u0376\u0372\3\2\2\2\u0376\u0374"+
		"\3\2\2\2\u0376\u0375\3\2\2\2\u0377\u00b1\3\2\2\2\u0378\u0379\7O\2\2\u0379"+
		"\u037a\7r\2\2\u037a\u037c\7_\2\2\u037b\u037d\5<\37\2\u037c\u037b\3\2\2"+
		"\2\u037c\u037d\3\2\2\2\u037d\u037e\3\2\2\2\u037e\u0380\7`\2\2\u037f\u0381"+
		"\5\32\16\2\u0380\u037f\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u0382\3\2\2\2"+
		"\u0382\u0383\7b\2\2\u0383\u00b3\3\2\2\2\u0384\u0385\7r\2\2\u0385\u0387"+
		"\7_\2\2\u0386\u0388\5\u009cO\2\u0387\u0386\3\2\2\2\u0387\u0388\3\2\2\2"+
		"\u0388\u0389\3\2\2\2\u0389\u038a\7`\2\2\u038a\u00b5\3\2\2\2\u038b\u038c"+
		"\7P\2\2\u038c\u038d\7r\2\2\u038d\u038f\7_\2\2\u038e\u0390\5D#\2\u038f"+
		"\u038e\3\2\2\2\u038f\u0390\3\2\2\2\u0390\u0391\3\2\2\2\u0391\u0393\7`"+
		"\2\2\u0392\u0394\5\32\16\2\u0393\u0392\3\2\2\2\u0393\u0394\3\2\2\2\u0394"+
		"\u0395\3\2\2\2\u0395\u0396\5\u00b8]\2\u0396\u00b7\3\2\2\2\u0397\u039b"+
		"\7]\2\2\u0398\u039a\5\20\t\2\u0399\u0398\3\2\2\2\u039a\u039d\3\2\2\2\u039b"+
		"\u0399\3\2\2\2\u039b\u039c\3\2\2\2\u039c\u039f\3\2\2\2\u039d\u039b\3\2"+
		"\2\2\u039e\u03a0\5\u00aeX\2\u039f\u039e\3\2\2\2\u039f\u03a0\3\2\2\2\u03a0"+
		"\u03a1\3\2\2\2\u03a1\u03a2\7^\2\2\u03a2\u00b9\3\2\2\2\u03a3\u03a4\7Q\2"+
		"\2\u03a4\u03a8\7]\2\2\u03a5\u03a7\5\20\t\2\u03a6\u03a5\3\2\2\2\u03a7\u03aa"+
		"\3\2\2\2\u03a8\u03a6\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03ab\3\2\2\2\u03aa"+
		"\u03a8\3\2\2\2\u03ab\u03ac\7^\2\2\u03ac\u00bb\3\2\2\2\u03ad\u03ae\t\23"+
		"\2\2\u03ae\u00bd\3\2\2\2\u03af\u03b1\7T\2\2\u03b0\u03b2\5\34\17\2\u03b1"+
		"\u03b0\3\2\2\2\u03b1\u03b2\3\2\2\2\u03b2\u03b3\3\2\2\2\u03b3\u03b4\5T"+
		"+\2\u03b4\u00bf\3\2\2\2\u03b5\u03be\7t\2\2\u03b6\u03b7\7U\2\2\u03b7\u03ba"+
		"\7_\2\2\u03b8\u03bb\7r\2\2\u03b9\u03bb\5T+\2\u03ba\u03b8\3\2\2\2\u03ba"+
		"\u03b9\3\2\2\2\u03bb\u03bc\3\2\2\2\u03bc\u03be\7`\2\2\u03bd\u03b5\3\2"+
		"\2\2\u03bd\u03b6\3\2\2\2\u03be\u00c1\3\2\2\2\u03bf\u03c0\t\24\2\2\u03c0"+
		"\u00c3\3\2\2\2\u03c1\u03c7\5\u00c2b\2\u03c2\u03c4\7_\2\2\u03c3\u03c5\5"+
		"\u009cO\2\u03c4\u03c3\3\2\2\2\u03c4\u03c5\3\2\2\2\u03c5\u03c6\3\2\2\2"+
		"\u03c6\u03c8\7`\2\2\u03c7\u03c2\3\2\2\2\u03c7\u03c8\3\2\2\2\u03c8\u03c9"+
		"\3\2\2\2\u03c9\u03ca\5\34\17\2\u03ca\u03cb\5J&\2\u03cb\u00c5\3\2\2\2\u03cc"+
		"\u03cd\5\u00c4c\2\u03cd\u03ce\7b\2\2\u03ce\u03d1\3\2\2\2\u03cf\u03d1\5"+
		"\u00be`\2\u03d0\u03cc\3\2\2\2\u03d0\u03cf\3\2\2\2\u03d1\u00c7\3\2\2\2"+
		"\u03d2\u03d5\5\u00caf\2\u03d3\u03d5\5\u00ccg\2\u03d4\u03d2\3\2\2\2\u03d4"+
		"\u03d3\3\2\2\2\u03d5\u00c9\3\2\2\2\u03d6\u03d7\7X\2\2\u03d7\u03d8\5\u00ce"+
		"h\2\u03d8\u03d9\7b\2\2\u03d9\u00cb\3\2\2\2\u03da\u03db\7Y\2\2\u03db\u03e1"+
		"\7r\2\2\u03dc\u03de\7_\2\2\u03dd\u03df\5\u00d0i\2\u03de\u03dd\3\2\2\2"+
		"\u03de\u03df\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0\u03e2\7`\2\2\u03e1\u03dc"+
		"\3\2\2\2\u03e1\u03e2\3\2\2\2\u03e2\u03e3\3\2\2\2\u03e3\u03e5\5\36\20\2"+
		"\u03e4\u03e6\5\32\16\2\u03e5\u03e4\3\2\2\2\u03e5\u03e6\3\2\2\2\u03e6\u03e7"+
		"\3\2\2\2\u03e7\u03eb\7]\2\2\u03e8\u03ea\13\2\2\2\u03e9\u03e8\3\2\2\2\u03ea"+
		"\u03ed\3\2\2\2\u03eb\u03ec\3\2\2\2\u03eb\u03e9\3\2\2\2\u03ec\u03ee\3\2"+
		"\2\2\u03ed\u03eb\3\2\2\2\u03ee\u03ef\7^\2\2\u03ef\u00cd\3\2\2\2\u03f0"+
		"\u03f1\t\25\2\2\u03f1\u00cf\3\2\2\2\u03f2\u03f5\5@!\2\u03f3\u03f5\5\u009c"+
		"O\2\u03f4\u03f2\3\2\2\2\u03f4\u03f3\3\2\2\2\u03f5\u00d1\3\2\2\2m\u00d5"+
		"\u00d7\u00db\u00e0\u00e6\u00fe\u0108\u010f\u0115\u011c\u012b\u0133\u0137"+
		"\u013a\u013f\u0143\u0146\u014d\u0156\u015e\u0165\u0172\u0177\u017c\u0180"+
		"\u0183\u0186\u018e\u0194\u019b\u01a4\u01ab\u01af\u01b8\u01bf\u01c4\u01cb"+
		"\u01de\u01e0\u01e7\u01ef\u01f4\u01f8\u01fc\u0207\u020a\u0213\u0215\u0222"+
		"\u0226\u022c\u0233\u0238\u0240\u024b\u0251\u0255\u025a\u0268\u026d\u0275"+
		"\u0288\u028f\u029a\u02a5\u02b0\u02bb\u02c7\u02d3\u02de\u02e9\u02ef\u02f5"+
		"\u02f9\u0304\u0315\u031e\u0325\u0334\u0342\u0349\u034b\u034f\u0358\u0363"+
		"\u036e\u0376\u037c\u0380\u0387\u038f\u0393\u039b\u039f\u03a8\u03b1\u03ba"+
		"\u03bd\u03c4\u03c7\u03d0\u03d4\u03de\u03e1\u03e5\u03eb\u03f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}