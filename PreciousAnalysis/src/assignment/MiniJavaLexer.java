package assignment;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

/**
 * Auto-generated MiniJava lexer tool.
 *
 * @author ANTLR 3.2.jar library.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class MiniJavaLexer extends Lexer {
    public static final int EOF = -1;
    public static final int T__51 = 51;
    public static final int T__52 = 52;
    public static final int T__53 = 53;
    public static final int T__54 = 54;
    public static final int T__55 = 55;
    public static final int T__56 = 56;
    public static final int T__57 = 57;
    public static final int T__58 = 58;
    public static final int T__59 = 59;
    public static final int T__60 = 60;
    public static final int T__61 = 61;
    public static final int T__62 = 62;
    public static final int T__63 = 63;
    public static final int T__64 = 64;
    public static final int T__65 = 65;
    public static final int T__66 = 66;
    public static final int T__67 = 67;
    public static final int T__68 = 68;
    public static final int T__69 = 69;
    public static final int T__70 = 70;
    public static final int ARRAYLENGTH_REFERENCE = 4;
    public static final int ARRAY_ASSIGN = 5;
    public static final int ARRAY_READ = 6;
    public static final int ARRAY_TYPE = 7;
    public static final int ASSIGN = 8;
    public static final int CLASS = 9;
    public static final int CONST = 10;
    public static final int DigitUS = 11;
    public static final int ELSE = 12;
    public static final int EXPR_LIST = 13;
    public static final int EXTENDS = 14;
    public static final int FALSE = 15;
    public static final int FILE = 16;
    public static final int IDENTIFIER = 17;
    public static final int IF = 18;
    public static final int INTARRAY_NEW = 19;
    public static final int INTEGER = 20;
    public static final int LINE_COMMENT = 21;
    public static final int LOGIC_AND = 22;
    public static final int LOGIC_OR = 23;
    public static final int LT = 24;
    public static final int Letter = 25;
    public static final int MAIN_CLASS = 26;
    public static final int MAIN_METHOD = 27;
    public static final int METHOD_BODY = 28;
    public static final int METHOD_CALL = 29;
    public static final int METHOD_DECL = 30;
    public static final int METHOD_LIST = 31;
    public static final int MINUS = 32;
    public static final int MULT = 33;
    public static final int NEW = 34;
    public static final int PARAM = 35;
    public static final int PARAM_LIST = 36;
    public static final int PLUS = 37;
    public static final int RETURN = 38;
    public static final int STMNT_LIST = 39;
    public static final int SUFFIX_PART = 40;
    public static final int SYSOUT = 41;
    public static final int THIS = 42;
    public static final int TRUE = 43;
    public static final int TYPE_REF = 44;
    public static final int UNARY_NOT = 45;
    public static final int VAR_DECL = 46;
    public static final int VAR_LIST = 47;
    public static final int VAR_REF = 48;
    public static final int WHILE = 49;
    public static final int WS = 50;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[]{};
    }

    public MiniJavaLexer() {}

    public MiniJavaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }

    public MiniJavaLexer(CharStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String getGrammarFileName() { return "/Users/margot/Downloads/MiniJava.g"; }

    // $ANTLR start "CLASS"
    public final void mCLASS() throws RecognitionException {
        try {
            int _type = CLASS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:6:7: ( 'class' )
            // /Users/margot/Downloads/MiniJava.g:6:9: 'class'
            {
                match("class");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "CLASS"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:7:6: ( 'else' )
            // /Users/margot/Downloads/MiniJava.g:7:8: 'else'
            {
                match("else");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "EXTENDS"
    public final void mEXTENDS() throws RecognitionException {
        try {
            int _type = EXTENDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:8:9: ( 'extends' )
            // /Users/margot/Downloads/MiniJava.g:8:11: 'extends'
            {
                match("extends");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "EXTENDS"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:9:7: ( 'false' )
            // /Users/margot/Downloads/MiniJava.g:9:9: 'false'
            {
                match("false");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:10:4: ( 'if' )
            // /Users/margot/Downloads/MiniJava.g:10:6: 'if'
            {
                match("if");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "LOGIC_AND"
    public final void mLOGIC_AND() throws RecognitionException {
        try {
            int _type = LOGIC_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:11:11: ( '&&' )
            // /Users/margot/Downloads/MiniJava.g:11:13: '&&'
            {
                match("&&");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "LOGIC_AND"

    // $ANTLR start "LOGIC_OR"
    public final void mLOGIC_OR() throws RecognitionException {
        try {
            int _type = LOGIC_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:12:10: ( '||' )
            // /Users/margot/Downloads/MiniJava.g:12:12: '||'
            {
                match("||");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "LOGIC_OR"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:13:4: ( '<' )
            // /Users/margot/Downloads/MiniJava.g:13:6: '<'
            {
                match('<');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:14:7: ( '-' )
            // /Users/margot/Downloads/MiniJava.g:14:9: '-'
            {
                match('-');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:15:6: ( '*' )
            // /Users/margot/Downloads/MiniJava.g:15:8: '*'
            {
                match('*');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "MULT"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:16:6: ( '+' )
            // /Users/margot/Downloads/MiniJava.g:16:8: '+'
            {
                match('+');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "SYSOUT"
    public final void mSYSOUT() throws RecognitionException {
        try {
            int _type = SYSOUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:17:8: ( 'System.out.println' )
            // /Users/margot/Downloads/MiniJava.g:17:10: 'System.out.println'
            {
                match("System.out.println");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "SYSOUT"

    // $ANTLR start "THIS"
    public final void mTHIS() throws RecognitionException {
        try {
            int _type = THIS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:18:6: ( 'this' )
            // /Users/margot/Downloads/MiniJava.g:18:8: 'this'
            {
                match("this");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "THIS"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:19:6: ( 'true' )
            // /Users/margot/Downloads/MiniJava.g:19:8: 'true'
            {
                match("true");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "UNARY_NOT"
    public final void mUNARY_NOT() throws RecognitionException {
        try {
            int _type = UNARY_NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:20:11: ( '!' )
            // /Users/margot/Downloads/MiniJava.g:20:13: '!'
            {
                match('!');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "UNARY_NOT"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:21:7: ( 'while' )
            // /Users/margot/Downloads/MiniJava.g:21:9: 'while'
            {
                match("while");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:22:7: ( '(' )
            // /Users/margot/Downloads/MiniJava.g:22:9: '('
            {
                match('(');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:23:7: ( ')' )
            // /Users/margot/Downloads/MiniJava.g:23:9: ')'
            {
                match(')');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:24:7: ( ',' )
            // /Users/margot/Downloads/MiniJava.g:24:9: ','
            {
                match(',');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:25:7: ( '.' )
            // /Users/margot/Downloads/MiniJava.g:25:9: '.'
            {
                match('.');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:26:7: ( ';' )
            // /Users/margot/Downloads/MiniJava.g:26:9: ';'
            {
                match(';');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:27:7: ( '=' )
            // /Users/margot/Downloads/MiniJava.g:27:9: '='
            {
                match('=');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:28:7: ( 'String' )
            // /Users/margot/Downloads/MiniJava.g:28:9: 'String'
            {
                match("String");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:29:7: ( '[' )
            // /Users/margot/Downloads/MiniJava.g:29:9: '['
            {
                match('[');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:30:7: ( ']' )
            // /Users/margot/Downloads/MiniJava.g:30:9: ']'
            {
                match(']');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:31:7: ( 'boolean' )
            // /Users/margot/Downloads/MiniJava.g:31:9: 'boolean'
            {
                match("boolean");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:32:7: ( 'int' )
            // /Users/margot/Downloads/MiniJava.g:32:9: 'int'
            {
                match("int");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:33:7: ( 'length' )
            // /Users/margot/Downloads/MiniJava.g:33:9: 'length'
            {
                match("length");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:34:7: ( 'main' )
            // /Users/margot/Downloads/MiniJava.g:34:9: 'main'
            {
                match("main");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:35:7: ( 'new' )
            // /Users/margot/Downloads/MiniJava.g:35:9: 'new'
            {
                match("new");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:36:7: ( 'public' )
            // /Users/margot/Downloads/MiniJava.g:36:9: 'public'
            {
                match("public");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:37:7: ( 'return' )
            // /Users/margot/Downloads/MiniJava.g:37:9: 'return'
            {
                match("return");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:38:7: ( 'static' )
            // /Users/margot/Downloads/MiniJava.g:38:9: 'static'
            {
                match("static");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:39:7: ( 'void' )
            // /Users/margot/Downloads/MiniJava.g:39:9: 'void'
            {
                match("void");


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:40:7: ( '{' )
            // /Users/margot/Downloads/MiniJava.g:40:9: '{'
            {
                match('{');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:41:7: ( '}' )
            // /Users/margot/Downloads/MiniJava.g:41:9: '}'
            {
                match('}');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:212:9: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt2 = 2;
            int LA2_0 = input.LA(1);

            if ((LA2_0 == '0')) {
                alt2 = 1;
            } else if (((LA2_0 >= '1' && LA2_0 <= '9'))) {
                alt2 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1:
                    // /Users/margot/Downloads/MiniJava.g:212:11: '0'
                {
                    match('0');

                }
                break;
                case 2:
                    // /Users/margot/Downloads/MiniJava.g:213:4: '1' .. '9' ( '0' .. '9' )*
                {
                    matchRange('1', '9');

                    // /Users/margot/Downloads/MiniJava.g:213:13: ( '0' .. '9' )*
                    loop1:
                    do {
                        int alt1 = 2;
                        int LA1_0 = input.LA(1);

                        if (((LA1_0 >= '0' && LA1_0 <= '9'))) {
                            alt1 = 1;
                        }


                        switch (alt1) {
                            case 1:
                                // /Users/margot/Downloads/MiniJava.g:
                            {
                                if ((input.LA(1) >= '0' && input.LA(1) <= '9')) {
                                    input.consume();
                                } else {
                                    MismatchedSetException mse = new MismatchedSetException(null, input);
                                    recover(mse);
                                    throw mse;
                                }


                            }
                            break;

                            default:
                                break loop1;
                        }
                    } while (true);


                }
                break;

            }
            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:217:2: ( Letter ( Letter | DigitUS )* )
            // /Users/margot/Downloads/MiniJava.g:217:4: Letter ( Letter | DigitUS )*
            {
                mLetter();


                // /Users/margot/Downloads/MiniJava.g:217:11: ( Letter | DigitUS )*
                loop3:
                do {
                    int alt3 = 2;
                    int LA3_0 = input.LA(1);

                    if (((LA3_0 >= '0' && LA3_0 <= '9') || (LA3_0 >= 'A' && LA3_0 <= 'Z') || LA3_0 == '_' || (LA3_0 >= 'a' && LA3_0 <= 'z'))) {
                        alt3 = 1;
                    }


                    switch (alt3) {
                        case 1:
                            // /Users/margot/Downloads/MiniJava.g:
                        {
                            if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
                                input.consume();
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }


                        }
                        break;

                        default:
                            break loop3;
                    }
                } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // /Users/margot/Downloads/MiniJava.g:222:8: ( 'a' .. 'z' | 'A' .. 'Z' )
            // /Users/margot/Downloads/MiniJava.g:
            {
                if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
                    input.consume();
                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }


            }


        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "DigitUS"
    public final void mDigitUS() throws RecognitionException {
        try {
            // /Users/margot/Downloads/MiniJava.g:228:2: ( '0' .. '9' | '_' )
            // /Users/margot/Downloads/MiniJava.g:
            {
                if ((input.LA(1) >= '0' && input.LA(1) <= '9') || input.LA(1) == '_') {
                    input.consume();
                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }


            }


        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "DigitUS"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:232:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /Users/margot/Downloads/MiniJava.g:232:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
                if ((input.LA(1) >= '\t' && input.LA(1) <= '\n') || (input.LA(1) >= '\f' && input.LA(1) <= '\r') || input.LA(1) == ' ') {
                    input.consume();
                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }


                _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/margot/Downloads/MiniJava.g:237:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /Users/margot/Downloads/MiniJava.g:237:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
                match("//");


                // /Users/margot/Downloads/MiniJava.g:237:12: (~ ( '\\n' | '\\r' ) )*
                loop4:
                do {
                    int alt4 = 2;
                    int LA4_0 = input.LA(1);

                    if (((LA4_0 >= '\u0000' && LA4_0 <= '\t') || (LA4_0 >= '\u000B' && LA4_0 <= '\f') || (LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF'))) {
                        alt4 = 1;
                    }


                    switch (alt4) {
                        case 1:
                            // /Users/margot/Downloads/MiniJava.g:
                        {
                            if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t') || (input.LA(1) >= '\u000B' && input.LA(1) <= '\f') || (input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF')) {
                                input.consume();
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }


                        }
                        break;

                        default:
                            break loop4;
                    }
                } while (true);


                // /Users/margot/Downloads/MiniJava.g:237:26: ( '\\r' )?
                int alt5 = 2;
                int LA5_0 = input.LA(1);

                if ((LA5_0 == '\r')) {
                    alt5 = 1;
                }
                switch (alt5) {
                    case 1:
                        // /Users/margot/Downloads/MiniJava.g:237:26: '\\r'
                    {
                        match('\r');

                    }
                    break;

                }


                match('\n');

                _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "LINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // /Users/margot/Downloads/MiniJava.g:1:8: ( CLASS | ELSE | EXTENDS | FALSE | IF | LOGIC_AND | LOGIC_OR | LT | MINUS | MULT | PLUS | SYSOUT | THIS | TRUE | UNARY_NOT | WHILE | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | INTEGER | IDENTIFIER | WS | LINE_COMMENT )
        int alt6 = 40;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1:
                // /Users/margot/Downloads/MiniJava.g:1:10: CLASS
            {
                mCLASS();


            }
            break;
            case 2:
                // /Users/margot/Downloads/MiniJava.g:1:16: ELSE
            {
                mELSE();


            }
            break;
            case 3:
                // /Users/margot/Downloads/MiniJava.g:1:21: EXTENDS
            {
                mEXTENDS();


            }
            break;
            case 4:
                // /Users/margot/Downloads/MiniJava.g:1:29: FALSE
            {
                mFALSE();


            }
            break;
            case 5:
                // /Users/margot/Downloads/MiniJava.g:1:35: IF
            {
                mIF();


            }
            break;
            case 6:
                // /Users/margot/Downloads/MiniJava.g:1:38: LOGIC_AND
            {
                mLOGIC_AND();


            }
            break;
            case 7:
                // /Users/margot/Downloads/MiniJava.g:1:48: LOGIC_OR
            {
                mLOGIC_OR();


            }
            break;
            case 8:
                // /Users/margot/Downloads/MiniJava.g:1:57: LT
            {
                mLT();


            }
            break;
            case 9:
                // /Users/margot/Downloads/MiniJava.g:1:60: MINUS
            {
                mMINUS();


            }
            break;
            case 10:
                // /Users/margot/Downloads/MiniJava.g:1:66: MULT
            {
                mMULT();


            }
            break;
            case 11:
                // /Users/margot/Downloads/MiniJava.g:1:71: PLUS
            {
                mPLUS();


            }
            break;
            case 12:
                // /Users/margot/Downloads/MiniJava.g:1:76: SYSOUT
            {
                mSYSOUT();


            }
            break;
            case 13:
                // /Users/margot/Downloads/MiniJava.g:1:83: THIS
            {
                mTHIS();


            }
            break;
            case 14:
                // /Users/margot/Downloads/MiniJava.g:1:88: TRUE
            {
                mTRUE();


            }
            break;
            case 15:
                // /Users/margot/Downloads/MiniJava.g:1:93: UNARY_NOT
            {
                mUNARY_NOT();


            }
            break;
            case 16:
                // /Users/margot/Downloads/MiniJava.g:1:103: WHILE
            {
                mWHILE();


            }
            break;
            case 17:
                // /Users/margot/Downloads/MiniJava.g:1:109: T__51
            {
                mT__51();


            }
            break;
            case 18:
                // /Users/margot/Downloads/MiniJava.g:1:115: T__52
            {
                mT__52();


            }
            break;
            case 19:
                // /Users/margot/Downloads/MiniJava.g:1:121: T__53
            {
                mT__53();


            }
            break;
            case 20:
                // /Users/margot/Downloads/MiniJava.g:1:127: T__54
            {
                mT__54();


            }
            break;
            case 21:
                // /Users/margot/Downloads/MiniJava.g:1:133: T__55
            {
                mT__55();


            }
            break;
            case 22:
                // /Users/margot/Downloads/MiniJava.g:1:139: T__56
            {
                mT__56();


            }
            break;
            case 23:
                // /Users/margot/Downloads/MiniJava.g:1:145: T__57
            {
                mT__57();


            }
            break;
            case 24:
                // /Users/margot/Downloads/MiniJava.g:1:151: T__58
            {
                mT__58();


            }
            break;
            case 25:
                // /Users/margot/Downloads/MiniJava.g:1:157: T__59
            {
                mT__59();


            }
            break;
            case 26:
                // /Users/margot/Downloads/MiniJava.g:1:163: T__60
            {
                mT__60();


            }
            break;
            case 27:
                // /Users/margot/Downloads/MiniJava.g:1:169: T__61
            {
                mT__61();


            }
            break;
            case 28:
                // /Users/margot/Downloads/MiniJava.g:1:175: T__62
            {
                mT__62();


            }
            break;
            case 29:
                // /Users/margot/Downloads/MiniJava.g:1:181: T__63
            {
                mT__63();


            }
            break;
            case 30:
                // /Users/margot/Downloads/MiniJava.g:1:187: T__64
            {
                mT__64();


            }
            break;
            case 31:
                // /Users/margot/Downloads/MiniJava.g:1:193: T__65
            {
                mT__65();


            }
            break;
            case 32:
                // /Users/margot/Downloads/MiniJava.g:1:199: T__66
            {
                mT__66();


            }
            break;
            case 33:
                // /Users/margot/Downloads/MiniJava.g:1:205: T__67
            {
                mT__67();


            }
            break;
            case 34:
                // /Users/margot/Downloads/MiniJava.g:1:211: T__68
            {
                mT__68();


            }
            break;
            case 35:
                // /Users/margot/Downloads/MiniJava.g:1:217: T__69
            {
                mT__69();


            }
            break;
            case 36:
                // /Users/margot/Downloads/MiniJava.g:1:223: T__70
            {
                mT__70();


            }
            break;
            case 37:
                // /Users/margot/Downloads/MiniJava.g:1:229: INTEGER
            {
                mINTEGER();


            }
            break;
            case 38:
                // /Users/margot/Downloads/MiniJava.g:1:237: IDENTIFIER
            {
                mIDENTIFIER();


            }
            break;
            case 39:
                // /Users/margot/Downloads/MiniJava.g:1:248: WS
            {
                mWS();


            }
            break;
            case 40:
                // /Users/margot/Downloads/MiniJava.g:1:251: LINE_COMMENT
            {
                mLINE_COMMENT();


            }
            break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
            "\1\uffff\4\42\6\uffff\2\42\1\uffff\1\42\10\uffff\10\42\6\uffff\4" +
                    "\42\1\74\22\42\1\uffff\1\117\10\42\1\130\5\42\1\136\2\42\1\uffff" +
                    "\2\42\1\143\1\144\3\42\1\150\1\uffff\3\42\1\154\1\155\1\uffff\1" +
                    "\42\1\157\2\42\2\uffff\1\162\2\42\1\uffff\3\42\2\uffff\1\42\1\uffff" +
                    "\1\42\1\172\1\uffff\1\42\1\174\1\175\1\176\1\177\1\u0080\2\uffff" +
                    "\1\u0081\6\uffff";
    static final String DFA6_eofS =
            "\u0082\uffff";
    static final String DFA6_minS =
            "\1\11\2\154\1\141\1\146\6\uffff\1\164\1\150\1\uffff\1\150\10\uffff" +
                    "\1\157\1\145\1\141\1\145\1\165\1\145\1\164\1\157\6\uffff\1\141\1" +
                    "\163\1\164\1\154\1\60\1\164\1\163\1\162\1\151\1\165\1\151\1\157" +
                    "\1\156\1\151\1\167\1\142\1\164\1\141\1\151\1\163\2\145\1\163\1\uffff" +
                    "\1\60\1\164\1\151\1\163\1\145\2\154\1\147\1\156\1\60\1\154\1\165" +
                    "\1\164\1\144\1\163\1\60\1\156\1\145\1\uffff\1\145\1\156\2\60\2\145" +
                    "\1\164\1\60\1\uffff\1\151\1\162\1\151\2\60\1\uffff\1\144\1\60\1" +
                    "\155\1\147\2\uffff\1\60\1\141\1\150\1\uffff\1\143\1\156\1\143\2" +
                    "\uffff\1\163\1\uffff\1\56\1\60\1\uffff\1\156\5\60\2\uffff\1\60\6" +
                    "\uffff";
    static final String DFA6_maxS =
            "\1\175\1\154\1\170\1\141\1\156\6\uffff\1\171\1\162\1\uffff\1\150" +
                    "\10\uffff\1\157\1\145\1\141\1\145\1\165\1\145\1\164\1\157\6\uffff" +
                    "\1\141\1\163\1\164\1\154\1\172\1\164\1\163\1\162\1\151\1\165\1\151" +
                    "\1\157\1\156\1\151\1\167\1\142\1\164\1\141\1\151\1\163\2\145\1\163" +
                    "\1\uffff\1\172\1\164\1\151\1\163\1\145\2\154\1\147\1\156\1\172\1" +
                    "\154\1\165\1\164\1\144\1\163\1\172\1\156\1\145\1\uffff\1\145\1\156" +
                    "\2\172\2\145\1\164\1\172\1\uffff\1\151\1\162\1\151\2\172\1\uffff" +
                    "\1\144\1\172\1\155\1\147\2\uffff\1\172\1\141\1\150\1\uffff\1\143" +
                    "\1\156\1\143\2\uffff\1\163\1\uffff\1\56\1\172\1\uffff\1\156\5\172" +
                    "\2\uffff\1\172\6\uffff";
    static final String DFA6_acceptS =
            "\5\uffff\1\6\1\7\1\10\1\11\1\12\1\13\2\uffff\1\17\1\uffff\1\21\1" +
                    "\22\1\23\1\24\1\25\1\26\1\30\1\31\10\uffff\1\43\1\44\1\45\1\46\1" +
                    "\47\1\50\27\uffff\1\5\22\uffff\1\33\10\uffff\1\36\5\uffff\1\2\4" +
                    "\uffff\1\15\1\16\3\uffff\1\35\3\uffff\1\42\1\1\1\uffff\1\4\2\uffff" +
                    "\1\20\6\uffff\1\14\1\27\1\uffff\1\34\1\37\1\40\1\41\1\3\1\32";
    static final String DFA6_specialS =
            "\u0082\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\43\1\uffff\2\43\22\uffff\1\43\1\15\4\uffff\1\5\1\uffff\1" +
                    "\17\1\20\1\11\1\12\1\21\1\10\1\22\1\44\12\41\1\uffff\1\23\1" +
                    "\7\1\24\3\uffff\22\42\1\13\7\42\1\25\1\uffff\1\26\3\uffff\1" +
                    "\42\1\27\1\1\1\42\1\2\1\3\2\42\1\4\2\42\1\30\1\31\1\32\1\42" +
                    "\1\33\1\42\1\34\1\35\1\14\1\42\1\36\1\16\3\42\1\37\1\6\1\40",
            "\1\45",
            "\1\46\13\uffff\1\47",
            "\1\50",
            "\1\51\7\uffff\1\52",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\54\4\uffff\1\53",
            "\1\55\11\uffff\1\56",
            "",
            "\1\57",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\137",
            "\1\140",
            "",
            "\1\141",
            "\1\142",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\145",
            "\1\146",
            "\1\147",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\151",
            "\1\152",
            "\1\153",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\156",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\160",
            "\1\161",
            "",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\163",
            "\1\164",
            "",
            "\1\165",
            "\1\166",
            "\1\167",
            "",
            "",
            "\1\170",
            "",
            "\1\171",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\173",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }

        public String getDescription() {
            return "1:1: Tokens : ( CLASS | ELSE | EXTENDS | FALSE | IF | LOGIC_AND | LOGIC_OR | LT | MINUS | MULT | PLUS | SYSOUT | THIS | TRUE | UNARY_NOT | WHILE | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | INTEGER | IDENTIFIER | WS | LINE_COMMENT );";
        }
    }


}