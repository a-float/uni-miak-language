// Generated from C:\Users\mati8\Desktop\Semestr5\MIAK\Lang\resources\Lang.g4 by ANTLR 4.9.3

package me.miak.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CONST=1, VAR=2, OR=3, AND=4, EQ=5, NEQ=6, GT=7, LT=8, GTEQ=9, LTEQ=10, 
		PLUS=11, MINUS=12, MULT=13, DIV=14, MOD=15, POW=16, NOT=17, HASH=18, THROUGH=19, 
		COL=20, SCOL=21, ASSIGN=22, OPAR=23, CPAR=24, OBRACE=25, CBRACE=26, OSQR=27, 
		CSQR=28, DQUOTE=29, ARROW=30, COMMA=31, RETURN=32, FOR=33, IN=34, IF=35, 
		ELIF=36, ELSE=37, WHILE=38, TRUE=39, FALSE=40, NULL=41, PRINT=42, DEBUG=43, 
		ID=44, INT=45, FLOAT=46, STRING=47, COMMENT=48, SPACE=49, OTHER=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"CONST", "VAR", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", 
			"PLUS", "MINUS", "MULT", "DIV", "MOD", "POW", "NOT", "HASH", "THROUGH", 
			"COL", "SCOL", "ASSIGN", "OPAR", "CPAR", "OBRACE", "CBRACE", "OSQR", 
			"CSQR", "DQUOTE", "ARROW", "COMMA", "RETURN", "FOR", "IN", "IF", "ELIF", 
			"ELSE", "WHILE", "TRUE", "FALSE", "NULL", "PRINT", "DEBUG", "ID", "INT", 
			"FLOAT", "STRING", "COMMENT", "SPACE", "OTHER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'const'", "'let'", "'or'", "'and'", "'=='", "'!='", "'>'", "'<'", 
			"'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'^'", "'not'", "'#'", 
			"'::'", "':'", "';'", "'='", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"'\"'", "'->'", "','", "'ret'", "'for'", "'in'", "'if'", "'elif'", "'else'", 
			"'while'", "'true'", "'false'", "'null'", "'print'", "'debug'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CONST", "VAR", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", 
			"PLUS", "MINUS", "MULT", "DIV", "MOD", "POW", "NOT", "HASH", "THROUGH", 
			"COL", "SCOL", "ASSIGN", "OPAR", "CPAR", "OBRACE", "CBRACE", "OSQR", 
			"CSQR", "DQUOTE", "ARROW", "COMMA", "RETURN", "FOR", "IN", "IF", "ELIF", 
			"ELSE", "WHILE", "TRUE", "FALSE", "NULL", "PRINT", "DEBUG", "ID", "INT", 
			"FLOAT", "STRING", "COMMENT", "SPACE", "OTHER"
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


	public LangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u012c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3"+
		" \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3%\3%\3&\3"+
		"&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3"+
		"*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\7-\u00f3\n-\f"+
		"-\16-\u00f6\13-\3.\6.\u00f9\n.\r.\16.\u00fa\3/\6/\u00fe\n/\r/\16/\u00ff"+
		"\3/\3/\7/\u0104\n/\f/\16/\u0107\13/\3/\3/\6/\u010b\n/\r/\16/\u010c\5/"+
		"\u010f\n/\3\60\3\60\3\60\3\60\7\60\u0115\n\60\f\60\16\60\u0118\13\60\3"+
		"\60\3\60\3\61\3\61\3\61\3\61\7\61\u0120\n\61\f\61\16\61\u0123\13\61\3"+
		"\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\2\2\64\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S"+
		"+U,W-Y.[/]\60_\61a\62c\63e\64\3\2\b\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;"+
		"\5\2\f\f\17\17$$\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0134\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2"+
		"\2\2\2e\3\2\2\2\3g\3\2\2\2\5m\3\2\2\2\7q\3\2\2\2\tt\3\2\2\2\13x\3\2\2"+
		"\2\r{\3\2\2\2\17~\3\2\2\2\21\u0080\3\2\2\2\23\u0082\3\2\2\2\25\u0085\3"+
		"\2\2\2\27\u0088\3\2\2\2\31\u008a\3\2\2\2\33\u008c\3\2\2\2\35\u008e\3\2"+
		"\2\2\37\u0090\3\2\2\2!\u0092\3\2\2\2#\u0094\3\2\2\2%\u0098\3\2\2\2\'\u009a"+
		"\3\2\2\2)\u009d\3\2\2\2+\u009f\3\2\2\2-\u00a1\3\2\2\2/\u00a3\3\2\2\2\61"+
		"\u00a5\3\2\2\2\63\u00a7\3\2\2\2\65\u00a9\3\2\2\2\67\u00ab\3\2\2\29\u00ad"+
		"\3\2\2\2;\u00af\3\2\2\2=\u00b1\3\2\2\2?\u00b4\3\2\2\2A\u00b6\3\2\2\2C"+
		"\u00ba\3\2\2\2E\u00be\3\2\2\2G\u00c1\3\2\2\2I\u00c4\3\2\2\2K\u00c9\3\2"+
		"\2\2M\u00ce\3\2\2\2O\u00d4\3\2\2\2Q\u00d9\3\2\2\2S\u00df\3\2\2\2U\u00e4"+
		"\3\2\2\2W\u00ea\3\2\2\2Y\u00f0\3\2\2\2[\u00f8\3\2\2\2]\u010e\3\2\2\2_"+
		"\u0110\3\2\2\2a\u011b\3\2\2\2c\u0126\3\2\2\2e\u012a\3\2\2\2gh\7e\2\2h"+
		"i\7q\2\2ij\7p\2\2jk\7u\2\2kl\7v\2\2l\4\3\2\2\2mn\7n\2\2no\7g\2\2op\7v"+
		"\2\2p\6\3\2\2\2qr\7q\2\2rs\7t\2\2s\b\3\2\2\2tu\7c\2\2uv\7p\2\2vw\7f\2"+
		"\2w\n\3\2\2\2xy\7?\2\2yz\7?\2\2z\f\3\2\2\2{|\7#\2\2|}\7?\2\2}\16\3\2\2"+
		"\2~\177\7@\2\2\177\20\3\2\2\2\u0080\u0081\7>\2\2\u0081\22\3\2\2\2\u0082"+
		"\u0083\7@\2\2\u0083\u0084\7?\2\2\u0084\24\3\2\2\2\u0085\u0086\7>\2\2\u0086"+
		"\u0087\7?\2\2\u0087\26\3\2\2\2\u0088\u0089\7-\2\2\u0089\30\3\2\2\2\u008a"+
		"\u008b\7/\2\2\u008b\32\3\2\2\2\u008c\u008d\7,\2\2\u008d\34\3\2\2\2\u008e"+
		"\u008f\7\61\2\2\u008f\36\3\2\2\2\u0090\u0091\7\'\2\2\u0091 \3\2\2\2\u0092"+
		"\u0093\7`\2\2\u0093\"\3\2\2\2\u0094\u0095\7p\2\2\u0095\u0096\7q\2\2\u0096"+
		"\u0097\7v\2\2\u0097$\3\2\2\2\u0098\u0099\7%\2\2\u0099&\3\2\2\2\u009a\u009b"+
		"\7<\2\2\u009b\u009c\7<\2\2\u009c(\3\2\2\2\u009d\u009e\7<\2\2\u009e*\3"+
		"\2\2\2\u009f\u00a0\7=\2\2\u00a0,\3\2\2\2\u00a1\u00a2\7?\2\2\u00a2.\3\2"+
		"\2\2\u00a3\u00a4\7*\2\2\u00a4\60\3\2\2\2\u00a5\u00a6\7+\2\2\u00a6\62\3"+
		"\2\2\2\u00a7\u00a8\7}\2\2\u00a8\64\3\2\2\2\u00a9\u00aa\7\177\2\2\u00aa"+
		"\66\3\2\2\2\u00ab\u00ac\7]\2\2\u00ac8\3\2\2\2\u00ad\u00ae\7_\2\2\u00ae"+
		":\3\2\2\2\u00af\u00b0\7$\2\2\u00b0<\3\2\2\2\u00b1\u00b2\7/\2\2\u00b2\u00b3"+
		"\7@\2\2\u00b3>\3\2\2\2\u00b4\u00b5\7.\2\2\u00b5@\3\2\2\2\u00b6\u00b7\7"+
		"t\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7v\2\2\u00b9B\3\2\2\2\u00ba\u00bb"+
		"\7h\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7t\2\2\u00bdD\3\2\2\2\u00be\u00bf"+
		"\7k\2\2\u00bf\u00c0\7p\2\2\u00c0F\3\2\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3"+
		"\7h\2\2\u00c3H\3\2\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7"+
		"\7k\2\2\u00c7\u00c8\7h\2\2\u00c8J\3\2\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb"+
		"\7n\2\2\u00cb\u00cc\7u\2\2\u00cc\u00cd\7g\2\2\u00cdL\3\2\2\2\u00ce\u00cf"+
		"\7y\2\2\u00cf\u00d0\7j\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7n\2\2\u00d2"+
		"\u00d3\7g\2\2\u00d3N\3\2\2\2\u00d4\u00d5\7v\2\2\u00d5\u00d6\7t\2\2\u00d6"+
		"\u00d7\7w\2\2\u00d7\u00d8\7g\2\2\u00d8P\3\2\2\2\u00d9\u00da\7h\2\2\u00da"+
		"\u00db\7c\2\2\u00db\u00dc\7n\2\2\u00dc\u00dd\7u\2\2\u00dd\u00de\7g\2\2"+
		"\u00deR\3\2\2\2\u00df\u00e0\7p\2\2\u00e0\u00e1\7w\2\2\u00e1\u00e2\7n\2"+
		"\2\u00e2\u00e3\7n\2\2\u00e3T\3\2\2\2\u00e4\u00e5\7r\2\2\u00e5\u00e6\7"+
		"t\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9\7v\2\2\u00e9V"+
		"\3\2\2\2\u00ea\u00eb\7f\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed\7d\2\2\u00ed"+
		"\u00ee\7w\2\2\u00ee\u00ef\7i\2\2\u00efX\3\2\2\2\u00f0\u00f4\t\2\2\2\u00f1"+
		"\u00f3\t\3\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2"+
		"\2\2\u00f4\u00f5\3\2\2\2\u00f5Z\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f9"+
		"\t\4\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\\\3\2\2\2\u00fc\u00fe\t\4\2\2\u00fd\u00fc\3\2\2\2"+
		"\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101"+
		"\3\2\2\2\u0101\u0105\7\60\2\2\u0102\u0104\t\4\2\2\u0103\u0102\3\2\2\2"+
		"\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u010f"+
		"\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u010a\7\60\2\2\u0109\u010b\t\4\2\2"+
		"\u010a\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010d\u010f\3\2\2\2\u010e\u00fd\3\2\2\2\u010e\u0108\3\2\2\2\u010f"+
		"^\3\2\2\2\u0110\u0116\5;\36\2\u0111\u0115\n\5\2\2\u0112\u0113\7$\2\2\u0113"+
		"\u0115\7$\2\2\u0114\u0111\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0118\3\2"+
		"\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0119\u011a\5;\36\2\u011a`\3\2\2\2\u011b\u011c\7\61\2\2"+
		"\u011c\u011d\7\61\2\2\u011d\u0121\3\2\2\2\u011e\u0120\n\6\2\2\u011f\u011e"+
		"\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0124\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125\b\61\2\2\u0125b\3\2\2\2"+
		"\u0126\u0127\t\7\2\2\u0127\u0128\3\2\2\2\u0128\u0129\b\62\2\2\u0129d\3"+
		"\2\2\2\u012a\u012b\13\2\2\2\u012bf\3\2\2\2\f\2\u00f4\u00fa\u00ff\u0105"+
		"\u010c\u010e\u0114\u0116\u0121\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}