// Generated from BasicJava.g4 by ANTLR 4.9.3

package antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicJavaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, ID=19, INT=20, BOOL=21, TEXT=22, WS=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "ID", "INT", "BOOL", "TEXT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'function'", "'('", "')'", "'{'", "'}'", "'int'", 
			"'boolean'", "'text'", "'void'", "','", "'return'", "'if'", "'else'", 
			"'while'", "'-'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "ID", "INT", "BOOL", "TEXT", 
			"WS"
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


	public BasicJavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BasicJava.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u009c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\6\24y\n\24\r\24\16\24z\3\25\6\25~\n\25"+
		"\r\25\16\25\177\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u008b"+
		"\n\26\3\27\3\27\7\27\u008f\n\27\f\27\16\27\u0092\13\27\3\27\3\27\3\30"+
		"\6\30\u0097\n\30\r\30\16\30\u0098\3\30\3\30\3\u0090\2\31\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\3\2\5\6\2\60\60C\\aac|\3\2\62;\5\2\13\f\17\17"+
		"\"\"\2\u00a0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\3\61\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2\t>\3\2\2\2\13@\3"+
		"\2\2\2\rB\3\2\2\2\17D\3\2\2\2\21F\3\2\2\2\23J\3\2\2\2\25R\3\2\2\2\27W"+
		"\3\2\2\2\31\\\3\2\2\2\33^\3\2\2\2\35e\3\2\2\2\37h\3\2\2\2!m\3\2\2\2#s"+
		"\3\2\2\2%u\3\2\2\2\'x\3\2\2\2)}\3\2\2\2+\u008a\3\2\2\2-\u008c\3\2\2\2"+
		"/\u0096\3\2\2\2\61\62\7?\2\2\62\4\3\2\2\2\63\64\7=\2\2\64\6\3\2\2\2\65"+
		"\66\7h\2\2\66\67\7w\2\2\678\7p\2\289\7e\2\29:\7v\2\2:;\7k\2\2;<\7q\2\2"+
		"<=\7p\2\2=\b\3\2\2\2>?\7*\2\2?\n\3\2\2\2@A\7+\2\2A\f\3\2\2\2BC\7}\2\2"+
		"C\16\3\2\2\2DE\7\177\2\2E\20\3\2\2\2FG\7k\2\2GH\7p\2\2HI\7v\2\2I\22\3"+
		"\2\2\2JK\7d\2\2KL\7q\2\2LM\7q\2\2MN\7n\2\2NO\7g\2\2OP\7c\2\2PQ\7p\2\2"+
		"Q\24\3\2\2\2RS\7v\2\2ST\7g\2\2TU\7z\2\2UV\7v\2\2V\26\3\2\2\2WX\7x\2\2"+
		"XY\7q\2\2YZ\7k\2\2Z[\7f\2\2[\30\3\2\2\2\\]\7.\2\2]\32\3\2\2\2^_\7t\2\2"+
		"_`\7g\2\2`a\7v\2\2ab\7w\2\2bc\7t\2\2cd\7p\2\2d\34\3\2\2\2ef\7k\2\2fg\7"+
		"h\2\2g\36\3\2\2\2hi\7g\2\2ij\7n\2\2jk\7u\2\2kl\7g\2\2l \3\2\2\2mn\7y\2"+
		"\2no\7j\2\2op\7k\2\2pq\7n\2\2qr\7g\2\2r\"\3\2\2\2st\7/\2\2t$\3\2\2\2u"+
		"v\7-\2\2v&\3\2\2\2wy\t\2\2\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{"+
		"(\3\2\2\2|~\t\3\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2"+
		"\2\2\u0080*\3\2\2\2\u0081\u0082\7v\2\2\u0082\u0083\7t\2\2\u0083\u0084"+
		"\7w\2\2\u0084\u008b\7g\2\2\u0085\u0086\7h\2\2\u0086\u0087\7c\2\2\u0087"+
		"\u0088\7n\2\2\u0088\u0089\7u\2\2\u0089\u008b\7g\2\2\u008a\u0081\3\2\2"+
		"\2\u008a\u0085\3\2\2\2\u008b,\3\2\2\2\u008c\u0090\7$\2\2\u008d\u008f\13"+
		"\2\2\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u0091\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7$"+
		"\2\2\u0094.\3\2\2\2\u0095\u0097\t\4\2\2\u0096\u0095\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009b\b\30\2\2\u009b\60\3\2\2\2\b\2z\177\u008a\u0090\u0098\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}