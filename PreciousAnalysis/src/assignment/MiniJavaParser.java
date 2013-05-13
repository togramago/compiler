package assignment;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteEarlyExitException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;

/**
 * Auto-generated MiniJava parser tool.
 * 
 * @author ANTLR 3.2.jar library.
 * 
 */
@SuppressWarnings({ "all", "warnings", "unchecked" })
public class MiniJavaParser extends Parser {
	public static final String[] tokenNames = new String[] { "<invalid>",
			"<EOR>", "<DOWN>", "<UP>", "ARRAYLENGTH_REFERENCE", "ARRAY_ASSIGN",
			"ARRAY_READ", "ARRAY_TYPE", "ASSIGN", "CLASS", "CONST", "DigitUS",
			"ELSE", "EXPR_LIST", "EXTENDS", "FALSE", "FILE", "IDENTIFIER",
			"IF", "INTARRAY_NEW", "INTEGER", "LINE_COMMENT", "LOGIC_AND",
			"LOGIC_OR", "LT", "Letter", "MAIN_CLASS", "MAIN_METHOD",
			"METHOD_BODY", "METHOD_CALL", "METHOD_DECL", "METHOD_LIST",
			"MINUS", "MULT", "NEW", "PARAM", "PARAM_LIST", "PLUS", "RETURN",
			"STMNT_LIST", "SUFFIX_PART", "SYSOUT", "THIS", "TRUE", "TYPE_REF",
			"UNARY_NOT", "VAR_DECL", "VAR_LIST", "VAR_REF", "WHILE", "WS",
			"'('", "')'", "','", "'.'", "';'", "'='", "'String'", "'['", "']'",
			"'boolean'", "'int'", "'length'", "'main'", "'new'", "'public'",
			"'return'", "'static'", "'void'", "'{'", "'}'" };

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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators

	public MiniJavaParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public MiniJavaParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}

	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}

	public String[] getTokenNames() {
		return MiniJavaParser.tokenNames;
	}

	public String getGrammarFileName() {
		return "/Users/margot/Downloads/MiniJava.g";
	}

	public static class goal_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "goal"
	// /Users/margot/Downloads/MiniJava.g:88:1: goal : mainClass (
	// classDeclaration )* -> ^( FILE mainClass ( classDeclaration )* ) ;
	public final MiniJavaParser.goal_return goal() throws RecognitionException {
		MiniJavaParser.goal_return retval = new MiniJavaParser.goal_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		MiniJavaParser.mainClass_return mainClass1 = null;

		MiniJavaParser.classDeclaration_return classDeclaration2 = null;

		RewriteRuleSubtreeStream stream_mainClass = new RewriteRuleSubtreeStream(
				adaptor, "rule mainClass");
		RewriteRuleSubtreeStream stream_classDeclaration = new RewriteRuleSubtreeStream(
				adaptor, "rule classDeclaration");
		try {
			// /Users/margot/Downloads/MiniJava.g:88:6: ( mainClass (
			// classDeclaration )* -> ^( FILE mainClass ( classDeclaration )* )
			// )
			// /Users/margot/Downloads/MiniJava.g:88:8: mainClass (
			// classDeclaration )*
			{
				pushFollow(FOLLOW_mainClass_in_goal343);
				mainClass1 = mainClass();

				state._fsp--;

				stream_mainClass.add(mainClass1.getTree());

				// /Users/margot/Downloads/MiniJava.g:88:18: ( classDeclaration
				// )*
				loop1: do {
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if ((LA1_0 == CLASS)) {
						alt1 = 1;
					}

					switch (alt1) {
					case 1:
					// /Users/margot/Downloads/MiniJava.g:88:19:
					// classDeclaration
					{
						pushFollow(FOLLOW_classDeclaration_in_goal346);
						classDeclaration2 = classDeclaration();

						state._fsp--;

						stream_classDeclaration
								.add(classDeclaration2.getTree());

					}
						break;

					default:
						break loop1;
					}
				} while (true);

				// AST REWRITE
				// elements: classDeclaration, mainClass
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 88:38: -> ^( FILE mainClass ( classDeclaration )* )
				{
					// /Users/margot/Downloads/MiniJava.g:88:41: ^( FILE
					// mainClass ( classDeclaration )* )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(FILE, "FILE"),
								root_1);

						adaptor.addChild(root_1, stream_mainClass.nextTree());

						// /Users/margot/Downloads/MiniJava.g:88:58: (
						// classDeclaration )*
						while (stream_classDeclaration.hasNext()) {
							adaptor.addChild(root_1,
									stream_classDeclaration.nextTree());

						}
						stream_classDeclaration.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "goal"

	public static class mainClass_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "mainClass"
	// /Users/margot/Downloads/MiniJava.g:90:1: mainClass : CLASS identifier '{'
	// 'public' 'static' 'void' 'main' '(' 'String' '[' ']' identifier ')' '{'
	// statement '}' '}' -> ^( MAIN_CLASS identifier ^( MAIN_METHOD ^(
	// PARAM_LIST ) statement ) ) ;
	public final MiniJavaParser.mainClass_return mainClass()
			throws RecognitionException {
		MiniJavaParser.mainClass_return retval = new MiniJavaParser.mainClass_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token CLASS3 = null;
		Token char_literal5 = null;
		Token string_literal6 = null;
		Token string_literal7 = null;
		Token string_literal8 = null;
		Token string_literal9 = null;
		Token char_literal10 = null;
		Token string_literal11 = null;
		Token char_literal12 = null;
		Token char_literal13 = null;
		Token char_literal15 = null;
		Token char_literal16 = null;
		Token char_literal18 = null;
		Token char_literal19 = null;
		MiniJavaParser.identifier_return identifier4 = null;

		MiniJavaParser.identifier_return identifier14 = null;

		MiniJavaParser.statement_return statement17 = null;

		CommonTree CLASS3_tree = null;
		CommonTree char_literal5_tree = null;
		CommonTree string_literal6_tree = null;
		CommonTree string_literal7_tree = null;
		CommonTree string_literal8_tree = null;
		CommonTree string_literal9_tree = null;
		CommonTree char_literal10_tree = null;
		CommonTree string_literal11_tree = null;
		CommonTree char_literal12_tree = null;
		CommonTree char_literal13_tree = null;
		CommonTree char_literal15_tree = null;
		CommonTree char_literal16_tree = null;
		CommonTree char_literal18_tree = null;
		CommonTree char_literal19_tree = null;
		RewriteRuleTokenStream stream_67 = new RewriteRuleTokenStream(adaptor,
				"token 67");
		RewriteRuleTokenStream stream_69 = new RewriteRuleTokenStream(adaptor,
				"token 69");
		RewriteRuleTokenStream stream_68 = new RewriteRuleTokenStream(adaptor,
				"token 68");
		RewriteRuleTokenStream stream_59 = new RewriteRuleTokenStream(adaptor,
				"token 59");
		RewriteRuleTokenStream stream_CLASS = new RewriteRuleTokenStream(
				adaptor, "token CLASS");
		RewriteRuleTokenStream stream_58 = new RewriteRuleTokenStream(adaptor,
				"token 58");
		RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor,
				"token 57");
		RewriteRuleTokenStream stream_51 = new RewriteRuleTokenStream(adaptor,
				"token 51");
		RewriteRuleTokenStream stream_65 = new RewriteRuleTokenStream(adaptor,
				"token 65");
		RewriteRuleTokenStream stream_52 = new RewriteRuleTokenStream(adaptor,
				"token 52");
		RewriteRuleTokenStream stream_70 = new RewriteRuleTokenStream(adaptor,
				"token 70");
		RewriteRuleTokenStream stream_63 = new RewriteRuleTokenStream(adaptor,
				"token 63");
		RewriteRuleSubtreeStream stream_statement = new RewriteRuleSubtreeStream(
				adaptor, "rule statement");
		RewriteRuleSubtreeStream stream_identifier = new RewriteRuleSubtreeStream(
				adaptor, "rule identifier");
		try {
			// /Users/margot/Downloads/MiniJava.g:91:2: ( CLASS identifier '{'
			// 'public' 'static' 'void' 'main' '(' 'String' '[' ']' identifier
			// ')' '{' statement '}' '}' -> ^( MAIN_CLASS identifier ^(
			// MAIN_METHOD ^( PARAM_LIST ) statement ) ) )
			// /Users/margot/Downloads/MiniJava.g:91:4: CLASS identifier '{'
			// 'public' 'static' 'void' 'main' '(' 'String' '[' ']' identifier
			// ')' '{' statement '}' '}'
			{
				CLASS3 = (Token) match(input, CLASS,
						FOLLOW_CLASS_in_mainClass369);
				stream_CLASS.add(CLASS3);

				pushFollow(FOLLOW_identifier_in_mainClass371);
				identifier4 = identifier();

				state._fsp--;

				stream_identifier.add(identifier4.getTree());

				char_literal5 = (Token) match(input, 69,
						FOLLOW_69_in_mainClass373);
				stream_69.add(char_literal5);

				string_literal6 = (Token) match(input, 65,
						FOLLOW_65_in_mainClass375);
				stream_65.add(string_literal6);

				string_literal7 = (Token) match(input, 67,
						FOLLOW_67_in_mainClass377);
				stream_67.add(string_literal7);

				string_literal8 = (Token) match(input, 68,
						FOLLOW_68_in_mainClass379);
				stream_68.add(string_literal8);

				string_literal9 = (Token) match(input, 63,
						FOLLOW_63_in_mainClass381);
				stream_63.add(string_literal9);

				char_literal10 = (Token) match(input, 51,
						FOLLOW_51_in_mainClass383);
				stream_51.add(char_literal10);

				string_literal11 = (Token) match(input, 57,
						FOLLOW_57_in_mainClass385);
				stream_57.add(string_literal11);

				char_literal12 = (Token) match(input, 58,
						FOLLOW_58_in_mainClass389);
				stream_58.add(char_literal12);

				char_literal13 = (Token) match(input, 59,
						FOLLOW_59_in_mainClass391);
				stream_59.add(char_literal13);

				pushFollow(FOLLOW_identifier_in_mainClass393);
				identifier14 = identifier();

				state._fsp--;

				stream_identifier.add(identifier14.getTree());

				char_literal15 = (Token) match(input, 52,
						FOLLOW_52_in_mainClass395);
				stream_52.add(char_literal15);

				char_literal16 = (Token) match(input, 69,
						FOLLOW_69_in_mainClass397);
				stream_69.add(char_literal16);

				pushFollow(FOLLOW_statement_in_mainClass399);
				statement17 = statement();

				state._fsp--;

				stream_statement.add(statement17.getTree());

				char_literal18 = (Token) match(input, 70,
						FOLLOW_70_in_mainClass401);
				stream_70.add(char_literal18);

				char_literal19 = (Token) match(input, 70,
						FOLLOW_70_in_mainClass403);
				stream_70.add(char_literal19);

				// AST REWRITE
				// elements: identifier, statement
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 93:3: -> ^( MAIN_CLASS identifier ^( MAIN_METHOD ^(
				// PARAM_LIST ) statement ) )
				{
					// /Users/margot/Downloads/MiniJava.g:93:6: ^( MAIN_CLASS
					// identifier ^( MAIN_METHOD ^( PARAM_LIST ) statement ) )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(MAIN_CLASS,
										"MAIN_CLASS"), root_1);

						adaptor.addChild(root_1, stream_identifier.nextTree());

						// /Users/margot/Downloads/MiniJava.g:93:30: ^(
						// MAIN_METHOD ^( PARAM_LIST ) statement )
						{
							CommonTree root_2 = (CommonTree) adaptor.nil();
							root_2 = (CommonTree) adaptor.becomeRoot(
									(CommonTree) adaptor.create(MAIN_METHOD,
											"MAIN_METHOD"), root_2);

							// /Users/margot/Downloads/MiniJava.g:93:44: ^(
							// PARAM_LIST )
							{
								CommonTree root_3 = (CommonTree) adaptor.nil();
								root_3 = (CommonTree) adaptor.becomeRoot(
										(CommonTree) adaptor.create(PARAM_LIST,
												"PARAM_LIST"), root_3);

								adaptor.addChild(root_2, root_3);
							}

							adaptor.addChild(root_2,
									stream_statement.nextTree());

							adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "mainClass"
	public static class classDeclaration_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "classDeclaration"
	// /Users/margot/Downloads/MiniJava.g:96:1: classDeclaration : CLASS
	// identifier ( extendsClause )? '{' varDeclarationList
	// methodDeclarationList '}' -> ^( CLASS identifier ( extendsClause )?
	// varDeclarationList methodDeclarationList ) ;
	public final MiniJavaParser.classDeclaration_return classDeclaration()
			throws RecognitionException {
		MiniJavaParser.classDeclaration_return retval = new MiniJavaParser.classDeclaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token CLASS20 = null;
		Token char_literal23 = null;
		Token char_literal26 = null;
		MiniJavaParser.identifier_return identifier21 = null;

		MiniJavaParser.extendsClause_return extendsClause22 = null;

		MiniJavaParser.varDeclarationList_return varDeclarationList24 = null;

		MiniJavaParser.methodDeclarationList_return methodDeclarationList25 = null;

		CommonTree CLASS20_tree = null;
		CommonTree char_literal23_tree = null;
		CommonTree char_literal26_tree = null;
		RewriteRuleTokenStream stream_69 = new RewriteRuleTokenStream(adaptor,
				"token 69");
		RewriteRuleTokenStream stream_CLASS = new RewriteRuleTokenStream(
				adaptor, "token CLASS");
		RewriteRuleTokenStream stream_70 = new RewriteRuleTokenStream(adaptor,
				"token 70");
		RewriteRuleSubtreeStream stream_methodDeclarationList = new RewriteRuleSubtreeStream(
				adaptor, "rule methodDeclarationList");
		RewriteRuleSubtreeStream stream_extendsClause = new RewriteRuleSubtreeStream(
				adaptor, "rule extendsClause");
		RewriteRuleSubtreeStream stream_varDeclarationList = new RewriteRuleSubtreeStream(
				adaptor, "rule varDeclarationList");
		RewriteRuleSubtreeStream stream_identifier = new RewriteRuleSubtreeStream(
				adaptor, "rule identifier");
		try {
			// /Users/margot/Downloads/MiniJava.g:97:2: ( CLASS identifier (
			// extendsClause )? '{' varDeclarationList methodDeclarationList '}'
			// -> ^( CLASS identifier ( extendsClause )? varDeclarationList
			// methodDeclarationList ) )
			// /Users/margot/Downloads/MiniJava.g:97:4: CLASS identifier (
			// extendsClause )? '{' varDeclarationList methodDeclarationList '}'
			{
				CLASS20 = (Token) match(input, CLASS,
						FOLLOW_CLASS_in_classDeclaration437);
				stream_CLASS.add(CLASS20);

				pushFollow(FOLLOW_identifier_in_classDeclaration439);
				identifier21 = identifier();

				state._fsp--;

				stream_identifier.add(identifier21.getTree());

				// /Users/margot/Downloads/MiniJava.g:97:21: ( extendsClause )?
				int alt2 = 2;
				int LA2_0 = input.LA(1);

				if ((LA2_0 == EXTENDS)) {
					alt2 = 1;
				}
				switch (alt2) {
				case 1:
				// /Users/margot/Downloads/MiniJava.g:97:21: extendsClause
				{
					pushFollow(FOLLOW_extendsClause_in_classDeclaration441);
					extendsClause22 = extendsClause();

					state._fsp--;

					stream_extendsClause.add(extendsClause22.getTree());

				}
					break;

				}

				char_literal23 = (Token) match(input, 69,
						FOLLOW_69_in_classDeclaration444);
				stream_69.add(char_literal23);

				pushFollow(FOLLOW_varDeclarationList_in_classDeclaration448);
				varDeclarationList24 = varDeclarationList();

				state._fsp--;

				stream_varDeclarationList.add(varDeclarationList24.getTree());

				pushFollow(FOLLOW_methodDeclarationList_in_classDeclaration450);
				methodDeclarationList25 = methodDeclarationList();

				state._fsp--;

				stream_methodDeclarationList.add(methodDeclarationList25
						.getTree());

				char_literal26 = (Token) match(input, 70,
						FOLLOW_70_in_classDeclaration452);
				stream_70.add(char_literal26);

				// AST REWRITE
				// elements: varDeclarationList, CLASS, methodDeclarationList,
				// extendsClause, identifier
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 99:3: -> ^( CLASS identifier ( extendsClause )?
				// varDeclarationList methodDeclarationList )
				{
					// /Users/margot/Downloads/MiniJava.g:99:6: ^( CLASS
					// identifier ( extendsClause )? varDeclarationList
					// methodDeclarationList )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								stream_CLASS.nextNode(), root_1);

						adaptor.addChild(root_1, stream_identifier.nextTree());

						// /Users/margot/Downloads/MiniJava.g:99:25: (
						// extendsClause )?
						if (stream_extendsClause.hasNext()) {
							adaptor.addChild(root_1,
									stream_extendsClause.nextTree());

						}
						stream_extendsClause.reset();

						adaptor.addChild(root_1,
								stream_varDeclarationList.nextTree());

						adaptor.addChild(root_1,
								stream_methodDeclarationList.nextTree());

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "classDeclaration"

	public static class extendsClause_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "extendsClause"
	// /Users/margot/Downloads/MiniJava.g:102:1: extendsClause : EXTENDS
	// identifier -> ^( EXTENDS ^( TYPE_REF identifier ) ) ;
	public final MiniJavaParser.extendsClause_return extendsClause()
			throws RecognitionException {
		MiniJavaParser.extendsClause_return retval = new MiniJavaParser.extendsClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EXTENDS27 = null;
		MiniJavaParser.identifier_return identifier28 = null;

		CommonTree EXTENDS27_tree = null;
		RewriteRuleTokenStream stream_EXTENDS = new RewriteRuleTokenStream(
				adaptor, "token EXTENDS");
		RewriteRuleSubtreeStream stream_identifier = new RewriteRuleSubtreeStream(
				adaptor, "rule identifier");
		try {
			// /Users/margot/Downloads/MiniJava.g:103:2: ( EXTENDS identifier ->
			// ^( EXTENDS ^( TYPE_REF identifier ) ) )
			// /Users/margot/Downloads/MiniJava.g:103:4: EXTENDS identifier
			{
				EXTENDS27 = (Token) match(input, EXTENDS,
						FOLLOW_EXTENDS_in_extendsClause483);
				stream_EXTENDS.add(EXTENDS27);

				pushFollow(FOLLOW_identifier_in_extendsClause485);
				identifier28 = identifier();

				state._fsp--;

				stream_identifier.add(identifier28.getTree());

				// AST REWRITE
				// elements: identifier, EXTENDS
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 103:23: -> ^( EXTENDS ^( TYPE_REF identifier ) )
				{
					// /Users/margot/Downloads/MiniJava.g:103:26: ^( EXTENDS ^(
					// TYPE_REF identifier ) )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								stream_EXTENDS.nextNode(), root_1);

						// /Users/margot/Downloads/MiniJava.g:103:36: ^(
						// TYPE_REF identifier )
						{
							CommonTree root_2 = (CommonTree) adaptor.nil();
							root_2 = (CommonTree) adaptor.becomeRoot(
									(CommonTree) adaptor.create(TYPE_REF,
											"TYPE_REF"), root_2);

							adaptor.addChild(root_2,
									stream_identifier.nextTree());

							adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "extendsClause"

	public static class varDeclarationList_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "varDeclarationList"
	// /Users/margot/Downloads/MiniJava.g:106:1: varDeclarationList : (
	// varDeclaration )* -> ^( VAR_LIST ( varDeclaration )* ) ;
	public final MiniJavaParser.varDeclarationList_return varDeclarationList()
			throws RecognitionException {
		MiniJavaParser.varDeclarationList_return retval = new MiniJavaParser.varDeclarationList_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		MiniJavaParser.varDeclaration_return varDeclaration29 = null;

		RewriteRuleSubtreeStream stream_varDeclaration = new RewriteRuleSubtreeStream(
				adaptor, "rule varDeclaration");
		try {
			// /Users/margot/Downloads/MiniJava.g:107:2: ( ( varDeclaration )*
			// -> ^( VAR_LIST ( varDeclaration )* ) )
			// /Users/margot/Downloads/MiniJava.g:107:4: ( varDeclaration )*
			{
				// /Users/margot/Downloads/MiniJava.g:107:4: ( varDeclaration )*
				loop3: do {
					int alt3 = 2;
					switch (input.LA(1)) {
					case IDENTIFIER: {
						int LA3_2 = input.LA(2);

						if ((LA3_2 == IDENTIFIER)) {
							int LA3_5 = input.LA(3);

							if ((LA3_5 == 55)) {
								alt3 = 1;
							}

						}

					}
						break;
					case 61: {
						int LA3_3 = input.LA(2);

						if ((LA3_3 == 58)) {
							int LA3_6 = input.LA(3);

							if ((LA3_6 == 59)) {
								int LA3_8 = input.LA(4);

								if ((LA3_8 == IDENTIFIER)) {
									int LA3_5 = input.LA(5);

									if ((LA3_5 == 55)) {
										alt3 = 1;
									}

								}

							}

						} else if ((LA3_3 == IDENTIFIER)) {
							int LA3_5 = input.LA(3);

							if ((LA3_5 == 55)) {
								alt3 = 1;
							}

						}

					}
						break;
					case 60: {
						int LA3_4 = input.LA(2);

						if ((LA3_4 == IDENTIFIER)) {
							int LA3_5 = input.LA(3);

							if ((LA3_5 == 55)) {
								alt3 = 1;
							}

						}

					}
						break;

					}

					switch (alt3) {
					case 1:
					// /Users/margot/Downloads/MiniJava.g:107:4: varDeclaration
					{
						pushFollow(FOLLOW_varDeclaration_in_varDeclarationList508);
						varDeclaration29 = varDeclaration();

						state._fsp--;

						stream_varDeclaration.add(varDeclaration29.getTree());

					}
						break;

					default:
						break loop3;
					}
				} while (true);

				// AST REWRITE
				// elements: varDeclaration
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 107:20: -> ^( VAR_LIST ( varDeclaration )* )
				{
					// /Users/margot/Downloads/MiniJava.g:107:23: ^( VAR_LIST (
					// varDeclaration )* )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(VAR_LIST,
										"VAR_LIST"), root_1);

						// /Users/margot/Downloads/MiniJava.g:107:34: (
						// varDeclaration )*
						while (stream_varDeclaration.hasNext()) {
							adaptor.addChild(root_1,
									stream_varDeclaration.nextTree());

						}
						stream_varDeclaration.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "varDeclarationList"

	public static class varDeclaration_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "varDeclaration"
	// /Users/margot/Downloads/MiniJava.g:110:1: varDeclaration : type
	// identifier ';' -> ^( VAR_DECL ^( TYPE_REF type ) identifier ) ;
	public final MiniJavaParser.varDeclaration_return varDeclaration()
			throws RecognitionException {
		MiniJavaParser.varDeclaration_return retval = new MiniJavaParser.varDeclaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal32 = null;
		MiniJavaParser.type_return type30 = null;

		MiniJavaParser.identifier_return identifier31 = null;

		CommonTree char_literal32_tree = null;
		RewriteRuleTokenStream stream_55 = new RewriteRuleTokenStream(adaptor,
				"token 55");
		RewriteRuleSubtreeStream stream_type = new RewriteRuleSubtreeStream(
				adaptor, "rule type");
		RewriteRuleSubtreeStream stream_identifier = new RewriteRuleSubtreeStream(
				adaptor, "rule identifier");
		try {
			// /Users/margot/Downloads/MiniJava.g:111:2: ( type identifier ';'
			// -> ^( VAR_DECL ^( TYPE_REF type ) identifier ) )
			// /Users/margot/Downloads/MiniJava.g:111:4: type identifier ';'
			{
				pushFollow(FOLLOW_type_in_varDeclaration529);
				type30 = type();

				state._fsp--;

				stream_type.add(type30.getTree());

				pushFollow(FOLLOW_identifier_in_varDeclaration531);
				identifier31 = identifier();

				state._fsp--;

				stream_identifier.add(identifier31.getTree());

				char_literal32 = (Token) match(input, 55,
						FOLLOW_55_in_varDeclaration533);
				stream_55.add(char_literal32);

				// AST REWRITE
				// elements: type, identifier
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 111:24: -> ^( VAR_DECL ^( TYPE_REF type ) identifier )
				{
					// /Users/margot/Downloads/MiniJava.g:111:27: ^( VAR_DECL ^(
					// TYPE_REF type ) identifier )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(VAR_DECL,
										"VAR_DECL"), root_1);

						// /Users/margot/Downloads/MiniJava.g:111:38: ^(
						// TYPE_REF type )
						{
							CommonTree root_2 = (CommonTree) adaptor.nil();
							root_2 = (CommonTree) adaptor.becomeRoot(
									(CommonTree) adaptor.create(TYPE_REF,
											"TYPE_REF"), root_2);

							adaptor.addChild(root_2, stream_type.nextTree());

							adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_identifier.nextTree());

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "varDeclaration"

	public static class methodDeclarationList_return extends
			ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "methodDeclarationList"
	// /Users/margot/Downloads/MiniJava.g:114:1: methodDeclarationList : (
	// methodDeclaration )* -> ^( METHOD_LIST ( methodDeclaration )* ) ;
	public final MiniJavaParser.methodDeclarationList_return methodDeclarationList()
			throws RecognitionException {
		MiniJavaParser.methodDeclarationList_return retval = new MiniJavaParser.methodDeclarationList_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		MiniJavaParser.methodDeclaration_return methodDeclaration33 = null;

		RewriteRuleSubtreeStream stream_methodDeclaration = new RewriteRuleSubtreeStream(
				adaptor, "rule methodDeclaration");
		try {
			// /Users/margot/Downloads/MiniJava.g:115:2: ( ( methodDeclaration
			// )* -> ^( METHOD_LIST ( methodDeclaration )* ) )
			// /Users/margot/Downloads/MiniJava.g:115:4: ( methodDeclaration )*
			{
				// /Users/margot/Downloads/MiniJava.g:115:4: ( methodDeclaration
				// )*
				loop4: do {
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if ((LA4_0 == IDENTIFIER || (LA4_0 >= 60 && LA4_0 <= 61) || LA4_0 == 65)) {
						alt4 = 1;
					}

					switch (alt4) {
					case 1:
					// /Users/margot/Downloads/MiniJava.g:115:4:
					// methodDeclaration
					{
						pushFollow(FOLLOW_methodDeclaration_in_methodDeclarationList559);
						methodDeclaration33 = methodDeclaration();

						state._fsp--;

						stream_methodDeclaration.add(methodDeclaration33
								.getTree());

					}
						break;

					default:
						break loop4;
					}
				} while (true);

				// AST REWRITE
				// elements: methodDeclaration
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 115:23: -> ^( METHOD_LIST ( methodDeclaration )* )
				{
					// /Users/margot/Downloads/MiniJava.g:115:26: ^( METHOD_LIST
					// ( methodDeclaration )* )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(METHOD_LIST,
										"METHOD_LIST"), root_1);

						// /Users/margot/Downloads/MiniJava.g:115:40: (
						// methodDeclaration )*
						while (stream_methodDeclaration.hasNext()) {
							adaptor.addChild(root_1,
									stream_methodDeclaration.nextTree());

						}
						stream_methodDeclaration.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "methodDeclarationList"

	public static class methodDeclaration_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "methodDeclaration"
	// /Users/margot/Downloads/MiniJava.g:118:1: methodDeclaration : ( 'public'
	// )? type identifier '(' ( param ( ',' param )* )? ')' '{'
	// varDeclarationList ( statement )* 'return' expression ';' '}' -> ^(
	// METHOD_DECL ^( TYPE_REF type ) identifier ^( PARAM_LIST ( param )* ) ^(
	// METHOD_BODY varDeclarationList ^( STMNT_LIST ( statement )* ^( RETURN
	// expression ) ) ) ) ;
	public final MiniJavaParser.methodDeclaration_return methodDeclaration()
			throws RecognitionException {
		MiniJavaParser.methodDeclaration_return retval = new MiniJavaParser.methodDeclaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal34 = null;
		Token char_literal37 = null;
		Token char_literal39 = null;
		Token char_literal41 = null;
		Token char_literal42 = null;
		Token string_literal45 = null;
		Token char_literal47 = null;
		Token char_literal48 = null;
		MiniJavaParser.type_return type35 = null;

		MiniJavaParser.identifier_return identifier36 = null;

		MiniJavaParser.param_return param38 = null;

		MiniJavaParser.param_return param40 = null;

		MiniJavaParser.varDeclarationList_return varDeclarationList43 = null;

		MiniJavaParser.statement_return statement44 = null;

		MiniJavaParser.expression_return expression46 = null;

		CommonTree string_literal34_tree = null;
		CommonTree char_literal37_tree = null;
		CommonTree char_literal39_tree = null;
		CommonTree char_literal41_tree = null;
		CommonTree char_literal42_tree = null;
		CommonTree string_literal45_tree = null;
		CommonTree char_literal47_tree = null;
		CommonTree char_literal48_tree = null;
		RewriteRuleTokenStream stream_66 = new RewriteRuleTokenStream(adaptor,
				"token 66");
		RewriteRuleTokenStream stream_69 = new RewriteRuleTokenStream(adaptor,
				"token 69");
		RewriteRuleTokenStream stream_55 = new RewriteRuleTokenStream(adaptor,
				"token 55");
		RewriteRuleTokenStream stream_51 = new RewriteRuleTokenStream(adaptor,
				"token 51");
		RewriteRuleTokenStream stream_65 = new RewriteRuleTokenStream(adaptor,
				"token 65");
		RewriteRuleTokenStream stream_52 = new RewriteRuleTokenStream(adaptor,
				"token 52");
		RewriteRuleTokenStream stream_70 = new RewriteRuleTokenStream(adaptor,
				"token 70");
		RewriteRuleTokenStream stream_53 = new RewriteRuleTokenStream(adaptor,
				"token 53");
		RewriteRuleSubtreeStream stream_statement = new RewriteRuleSubtreeStream(
				adaptor, "rule statement");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_param = new RewriteRuleSubtreeStream(
				adaptor, "rule param");
		RewriteRuleSubtreeStream stream_varDeclarationList = new RewriteRuleSubtreeStream(
				adaptor, "rule varDeclarationList");
		RewriteRuleSubtreeStream stream_type = new RewriteRuleSubtreeStream(
				adaptor, "rule type");
		RewriteRuleSubtreeStream stream_identifier = new RewriteRuleSubtreeStream(
				adaptor, "rule identifier");
		try {
			// /Users/margot/Downloads/MiniJava.g:119:2: ( ( 'public' )? type
			// identifier '(' ( param ( ',' param )* )? ')' '{'
			// varDeclarationList ( statement )* 'return' expression ';' '}' ->
			// ^( METHOD_DECL ^( TYPE_REF type ) identifier ^( PARAM_LIST (
			// param )* ) ^( METHOD_BODY varDeclarationList ^( STMNT_LIST (
			// statement )* ^( RETURN expression ) ) ) ) )
			// /Users/margot/Downloads/MiniJava.g:119:4: ( 'public' )? type
			// identifier '(' ( param ( ',' param )* )? ')' '{'
			// varDeclarationList ( statement )* 'return' expression ';' '}'
			{
				// /Users/margot/Downloads/MiniJava.g:119:4: ( 'public' )?
				int alt5 = 2;
				int LA5_0 = input.LA(1);

				if ((LA5_0 == 65)) {
					alt5 = 1;
				}
				switch (alt5) {
				case 1:
				// /Users/margot/Downloads/MiniJava.g:119:4: 'public'
				{
					string_literal34 = (Token) match(input, 65,
							FOLLOW_65_in_methodDeclaration580);
					stream_65.add(string_literal34);

				}
					break;

				}

				pushFollow(FOLLOW_type_in_methodDeclaration583);
				type35 = type();

				state._fsp--;

				stream_type.add(type35.getTree());

				pushFollow(FOLLOW_identifier_in_methodDeclaration585);
				identifier36 = identifier();

				state._fsp--;

				stream_identifier.add(identifier36.getTree());

				char_literal37 = (Token) match(input, 51,
						FOLLOW_51_in_methodDeclaration587);
				stream_51.add(char_literal37);

				// /Users/margot/Downloads/MiniJava.g:119:34: ( param ( ','
				// param )* )?
				int alt7 = 2;
				int LA7_0 = input.LA(1);

				if ((LA7_0 == IDENTIFIER || (LA7_0 >= 60 && LA7_0 <= 61))) {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
				// /Users/margot/Downloads/MiniJava.g:119:35: param ( ',' param
				// )*
				{
					pushFollow(FOLLOW_param_in_methodDeclaration590);
					param38 = param();

					state._fsp--;

					stream_param.add(param38.getTree());

					// /Users/margot/Downloads/MiniJava.g:119:41: ( ',' param )*
					loop6: do {
						int alt6 = 2;
						int LA6_0 = input.LA(1);

						if ((LA6_0 == 53)) {
							alt6 = 1;
						}

						switch (alt6) {
						case 1:
						// /Users/margot/Downloads/MiniJava.g:119:42: ',' param
						{
							char_literal39 = (Token) match(input, 53,
									FOLLOW_53_in_methodDeclaration593);
							stream_53.add(char_literal39);

							pushFollow(FOLLOW_param_in_methodDeclaration595);
							param40 = param();

							state._fsp--;

							stream_param.add(param40.getTree());

						}
							break;

						default:
							break loop6;
						}
					} while (true);

				}
					break;

				}

				char_literal41 = (Token) match(input, 52,
						FOLLOW_52_in_methodDeclaration602);
				stream_52.add(char_literal41);

				char_literal42 = (Token) match(input, 69,
						FOLLOW_69_in_methodDeclaration606);
				stream_69.add(char_literal42);

				pushFollow(FOLLOW_varDeclarationList_in_methodDeclaration608);
				varDeclarationList43 = varDeclarationList();

				state._fsp--;

				stream_varDeclarationList.add(varDeclarationList43.getTree());

				// /Users/margot/Downloads/MiniJava.g:120:26: ( statement )*
				loop8: do {
					int alt8 = 2;
					int LA8_0 = input.LA(1);

					if (((LA8_0 >= IDENTIFIER && LA8_0 <= IF)
							|| LA8_0 == SYSOUT || LA8_0 == WHILE || LA8_0 == 69)) {
						alt8 = 1;
					}

					switch (alt8) {
					case 1:
					// /Users/margot/Downloads/MiniJava.g:120:27: statement
					{
						pushFollow(FOLLOW_statement_in_methodDeclaration611);
						statement44 = statement();

						state._fsp--;

						stream_statement.add(statement44.getTree());

					}
						break;

					default:
						break loop8;
					}
				} while (true);

				string_literal45 = (Token) match(input, 66,
						FOLLOW_66_in_methodDeclaration615);
				stream_66.add(string_literal45);

				pushFollow(FOLLOW_expression_in_methodDeclaration617);
				expression46 = expression();

				state._fsp--;

				stream_expression.add(expression46.getTree());

				char_literal47 = (Token) match(input, 55,
						FOLLOW_55_in_methodDeclaration619);
				stream_55.add(char_literal47);

				char_literal48 = (Token) match(input, 70,
						FOLLOW_70_in_methodDeclaration621);
				stream_70.add(char_literal48);

				// AST REWRITE
				// elements: identifier, varDeclarationList, type, param,
				// expression, statement
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 121:3: -> ^( METHOD_DECL ^( TYPE_REF type ) identifier ^(
				// PARAM_LIST ( param )* ) ^( METHOD_BODY varDeclarationList ^(
				// STMNT_LIST ( statement )* ^( RETURN expression ) ) ) )
				{
					// /Users/margot/Downloads/MiniJava.g:121:6: ^( METHOD_DECL
					// ^( TYPE_REF type ) identifier ^( PARAM_LIST ( param )* )
					// ^( METHOD_BODY varDeclarationList ^( STMNT_LIST (
					// statement )* ^( RETURN expression ) ) ) )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(METHOD_DECL,
										"METHOD_DECL"), root_1);

						// /Users/margot/Downloads/MiniJava.g:121:20: ^(
						// TYPE_REF type )
						{
							CommonTree root_2 = (CommonTree) adaptor.nil();
							root_2 = (CommonTree) adaptor.becomeRoot(
									(CommonTree) adaptor.create(TYPE_REF,
											"TYPE_REF"), root_2);

							adaptor.addChild(root_2, stream_type.nextTree());

							adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_identifier.nextTree());

						// /Users/margot/Downloads/MiniJava.g:121:48: ^(
						// PARAM_LIST ( param )* )
						{
							CommonTree root_2 = (CommonTree) adaptor.nil();
							root_2 = (CommonTree) adaptor.becomeRoot(
									(CommonTree) adaptor.create(PARAM_LIST,
											"PARAM_LIST"), root_2);

							// /Users/margot/Downloads/MiniJava.g:121:61: (
							// param )*
							while (stream_param.hasNext()) {
								adaptor.addChild(root_2,
										stream_param.nextTree());

							}
							stream_param.reset();

							adaptor.addChild(root_1, root_2);
						}

						// /Users/margot/Downloads/MiniJava.g:121:69: ^(
						// METHOD_BODY varDeclarationList ^( STMNT_LIST (
						// statement )* ^( RETURN expression ) ) )
						{
							CommonTree root_2 = (CommonTree) adaptor.nil();
							root_2 = (CommonTree) adaptor.becomeRoot(
									(CommonTree) adaptor.create(METHOD_BODY,
											"METHOD_BODY"), root_2);

							adaptor.addChild(root_2,
									stream_varDeclarationList.nextTree());

							// /Users/margot/Downloads/MiniJava.g:121:102: ^(
							// STMNT_LIST ( statement )* ^( RETURN expression )
							// )
							{
								CommonTree root_3 = (CommonTree) adaptor.nil();
								root_3 = (CommonTree) adaptor.becomeRoot(
										(CommonTree) adaptor.create(STMNT_LIST,
												"STMNT_LIST"), root_3);

								// /Users/margot/Downloads/MiniJava.g:121:115: (
								// statement )*
								while (stream_statement.hasNext()) {
									adaptor.addChild(root_3,
											stream_statement.nextTree());

								}
								stream_statement.reset();

								// /Users/margot/Downloads/MiniJava.g:121:126:
								// ^( RETURN expression )
								{
									CommonTree root_4 = (CommonTree) adaptor
											.nil();
									root_4 = (CommonTree) adaptor.becomeRoot(
											(CommonTree) adaptor.create(RETURN,
													"RETURN"), root_4);

									adaptor.addChild(root_4,
											stream_expression.nextTree());

									adaptor.addChild(root_3, root_4);
								}

								adaptor.addChild(root_2, root_3);
							}

							adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "methodDeclaration"

	public static class param_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "param"
	// /Users/margot/Downloads/MiniJava.g:124:1: param : type identifier -> ^(
	// PARAM ^( TYPE_REF type ) identifier ) ;
	public final MiniJavaParser.param_return param()
			throws RecognitionException {
		MiniJavaParser.param_return retval = new MiniJavaParser.param_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		MiniJavaParser.type_return type49 = null;

		MiniJavaParser.identifier_return identifier50 = null;

		RewriteRuleSubtreeStream stream_type = new RewriteRuleSubtreeStream(
				adaptor, "rule type");
		RewriteRuleSubtreeStream stream_identifier = new RewriteRuleSubtreeStream(
				adaptor, "rule identifier");
		try {
			// /Users/margot/Downloads/MiniJava.g:124:7: ( type identifier -> ^(
			// PARAM ^( TYPE_REF type ) identifier ) )
			// /Users/margot/Downloads/MiniJava.g:124:9: type identifier
			{
				pushFollow(FOLLOW_type_in_param674);
				type49 = type();

				state._fsp--;

				stream_type.add(type49.getTree());

				pushFollow(FOLLOW_identifier_in_param676);
				identifier50 = identifier();

				state._fsp--;

				stream_identifier.add(identifier50.getTree());

				// AST REWRITE
				// elements: type, identifier
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 124:25: -> ^( PARAM ^( TYPE_REF type ) identifier )
				{
					// /Users/margot/Downloads/MiniJava.g:124:28: ^( PARAM ^(
					// TYPE_REF type ) identifier )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(PARAM, "PARAM"),
								root_1);

						// /Users/margot/Downloads/MiniJava.g:124:36: ^(
						// TYPE_REF type )
						{
							CommonTree root_2 = (CommonTree) adaptor.nil();
							root_2 = (CommonTree) adaptor.becomeRoot(
									(CommonTree) adaptor.create(TYPE_REF,
											"TYPE_REF"), root_2);

							adaptor.addChild(root_2, stream_type.nextTree());

							adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_identifier.nextTree());

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "param"

	public static class type_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "type"
	// /Users/margot/Downloads/MiniJava.g:127:1: type : ( identifier | 'int' '['
	// ']' -> ^( ARRAY_TYPE 'int' ) | 'int' | 'boolean' );
	public final MiniJavaParser.type_return type() throws RecognitionException {
		MiniJavaParser.type_return retval = new MiniJavaParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal52 = null;
		Token char_literal53 = null;
		Token char_literal54 = null;
		Token string_literal55 = null;
		Token string_literal56 = null;
		MiniJavaParser.identifier_return identifier51 = null;

		CommonTree string_literal52_tree = null;
		CommonTree char_literal53_tree = null;
		CommonTree char_literal54_tree = null;
		CommonTree string_literal55_tree = null;
		CommonTree string_literal56_tree = null;
		RewriteRuleTokenStream stream_59 = new RewriteRuleTokenStream(adaptor,
				"token 59");
		RewriteRuleTokenStream stream_58 = new RewriteRuleTokenStream(adaptor,
				"token 58");
		RewriteRuleTokenStream stream_61 = new RewriteRuleTokenStream(adaptor,
				"token 61");

		try {
			// /Users/margot/Downloads/MiniJava.g:127:7: ( identifier | 'int'
			// '[' ']' -> ^( ARRAY_TYPE 'int' ) | 'int' | 'boolean' )
			int alt9 = 4;
			switch (input.LA(1)) {
			case IDENTIFIER: {
				alt9 = 1;
			}
				break;
			case 61: {
				int LA9_2 = input.LA(2);

				if ((LA9_2 == 58)) {
					alt9 = 2;
				} else if ((LA9_2 == IDENTIFIER)) {
					alt9 = 3;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 9,
							2, input);

					throw nvae;

				}
			}
				break;
			case 60: {
				alt9 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 9, 0,
						input);

				throw nvae;

			}

			switch (alt9) {
			case 1:
			// /Users/margot/Downloads/MiniJava.g:127:9: identifier
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_identifier_in_type702);
				identifier51 = identifier();

				state._fsp--;

				adaptor.addChild(root_0, identifier51.getTree());

			}
				break;
			case 2:
			// /Users/margot/Downloads/MiniJava.g:128:4: 'int' '[' ']'
			{
				string_literal52 = (Token) match(input, 61,
						FOLLOW_61_in_type707);
				stream_61.add(string_literal52);

				char_literal53 = (Token) match(input, 58, FOLLOW_58_in_type709);
				stream_58.add(char_literal53);

				char_literal54 = (Token) match(input, 59, FOLLOW_59_in_type711);
				stream_59.add(char_literal54);

				// AST REWRITE
				// elements: 61
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 128:18: -> ^( ARRAY_TYPE 'int' )
				{
					// /Users/margot/Downloads/MiniJava.g:128:21: ^( ARRAY_TYPE
					// 'int' )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(ARRAY_TYPE,
										"ARRAY_TYPE"), root_1);

						adaptor.addChild(root_1, stream_61.nextNode());

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}
				break;
			case 3:
			// /Users/margot/Downloads/MiniJava.g:129:4: 'int'
			{
				root_0 = (CommonTree) adaptor.nil();

				string_literal55 = (Token) match(input, 61,
						FOLLOW_61_in_type724);
				string_literal55_tree = (CommonTree) adaptor
						.create(string_literal55);
				adaptor.addChild(root_0, string_literal55_tree);

			}
				break;
			case 4:
			// /Users/margot/Downloads/MiniJava.g:130:4: 'boolean'
			{
				root_0 = (CommonTree) adaptor.nil();

				string_literal56 = (Token) match(input, 60,
						FOLLOW_60_in_type729);
				string_literal56_tree = (CommonTree) adaptor
						.create(string_literal56);
				adaptor.addChild(root_0, string_literal56_tree);

			}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "type"

	public static class expression_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "expression"
	// /Users/margot/Downloads/MiniJava.g:133:1: expression : orExpr ;
	public final MiniJavaParser.expression_return expression()
			throws RecognitionException {
		MiniJavaParser.expression_return retval = new MiniJavaParser.expression_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		MiniJavaParser.orExpr_return orExpr57 = null;

		try {
			// /Users/margot/Downloads/MiniJava.g:134:2: ( orExpr )
			// /Users/margot/Downloads/MiniJava.g:134:4: orExpr
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_orExpr_in_expression740);
				orExpr57 = orExpr();

				state._fsp--;

				adaptor.addChild(root_0, orExpr57.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "expression"

	public static class arrayLengthReference_return extends
			ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "arrayLengthReference"
	// /Users/margot/Downloads/MiniJava.g:138:1: arrayLengthReference : '.'
	// 'length' ;
	public final MiniJavaParser.arrayLengthReference_return arrayLengthReference()
			throws RecognitionException {
		MiniJavaParser.arrayLengthReference_return retval = new MiniJavaParser.arrayLengthReference_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal58 = null;
		Token string_literal59 = null;

		CommonTree char_literal58_tree = null;
		CommonTree string_literal59_tree = null;

		try {
			// /Users/margot/Downloads/MiniJava.g:139:2: ( '.' 'length' )
			// /Users/margot/Downloads/MiniJava.g:139:4: '.' 'length'
			{
				root_0 = (CommonTree) adaptor.nil();

				char_literal58 = (Token) match(input, 54,
						FOLLOW_54_in_arrayLengthReference755);
				char_literal58_tree = (CommonTree) adaptor
						.create(char_literal58);
				adaptor.addChild(root_0, char_literal58_tree);

				string_literal59 = (Token) match(input, 62,
						FOLLOW_62_in_arrayLengthReference757);
				string_literal59_tree = (CommonTree) adaptor
						.create(string_literal59);
				adaptor.addChild(root_0, string_literal59_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "arrayLengthReference"

	public static class expressionList_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "expressionList"
	// /Users/margot/Downloads/MiniJava.g:142:1: expressionList : ( expression (
	// ',' expression )* )? -> ^( EXPR_LIST ( expression )* ) ;
	public final MiniJavaParser.expressionList_return expressionList()
			throws RecognitionException {
		MiniJavaParser.expressionList_return retval = new MiniJavaParser.expressionList_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal61 = null;
		MiniJavaParser.expression_return expression60 = null;

		MiniJavaParser.expression_return expression62 = null;

		CommonTree char_literal61_tree = null;
		RewriteRuleTokenStream stream_53 = new RewriteRuleTokenStream(adaptor,
				"token 53");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				adaptor, "rule expression");
		try {
			// /Users/margot/Downloads/MiniJava.g:143:2: ( ( expression ( ','
			// expression )* )? -> ^( EXPR_LIST ( expression )* ) )
			// /Users/margot/Downloads/MiniJava.g:143:4: ( expression ( ','
			// expression )* )?
			{
				// /Users/margot/Downloads/MiniJava.g:143:4: ( expression ( ','
				// expression )* )?
				int alt11 = 2;
				int LA11_0 = input.LA(1);

				if ((LA11_0 == FALSE || LA11_0 == IDENTIFIER
						|| LA11_0 == INTEGER
						|| (LA11_0 >= THIS && LA11_0 <= TRUE)
						|| LA11_0 == UNARY_NOT || LA11_0 == 51 || LA11_0 == 64)) {
					alt11 = 1;
				}
				switch (alt11) {
				case 1:
				// /Users/margot/Downloads/MiniJava.g:143:5: expression ( ','
				// expression )*
				{
					pushFollow(FOLLOW_expression_in_expressionList770);
					expression60 = expression();

					state._fsp--;

					stream_expression.add(expression60.getTree());

					// /Users/margot/Downloads/MiniJava.g:143:16: ( ','
					// expression )*
					loop10: do {
						int alt10 = 2;
						int LA10_0 = input.LA(1);

						if ((LA10_0 == 53)) {
							alt10 = 1;
						}

						switch (alt10) {
						case 1:
						// /Users/margot/Downloads/MiniJava.g:143:17: ','
						// expression
						{
							char_literal61 = (Token) match(input, 53,
									FOLLOW_53_in_expressionList773);
							stream_53.add(char_literal61);

							pushFollow(FOLLOW_expression_in_expressionList775);
							expression62 = expression();

							state._fsp--;

							stream_expression.add(expression62.getTree());

						}
							break;

						default:
							break loop10;
						}
					} while (true);

				}
					break;

				}

				// AST REWRITE
				// elements: expression
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 143:36: -> ^( EXPR_LIST ( expression )* )
				{
					// /Users/margot/Downloads/MiniJava.g:143:39: ^( EXPR_LIST (
					// expression )* )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(EXPR_LIST,
										"EXPR_LIST"), root_1);

						// /Users/margot/Downloads/MiniJava.g:143:51: (
						// expression )*
						while (stream_expression.hasNext()) {
							adaptor.addChild(root_1,
									stream_expression.nextTree());

						}
						stream_expression.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "expressionList"

	public static class statement_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "statement"
	// /Users/margot/Downloads/MiniJava.g:146:1: statement : ( '{' ( statement
	// )* '}' -> ^( STMNT_LIST ( statement )* ) | IF ^ '(' ! expression ')' !
	// statement ELSE ! statement | WHILE ^ '(' ! expression ')' ! statement |
	// SYSOUT ^ '(' ! expression ')' ! ';' !| identifier '=' expression ';' ->
	// ^( ASSIGN ^( VAR_REF identifier ) expression ) | identifier '['
	// expression ']' '=' expression ';' -> ^( ARRAY_ASSIGN ^( VAR_REF
	// identifier ) expression expression ) );
	public final MiniJavaParser.statement_return statement()
			throws RecognitionException {
		MiniJavaParser.statement_return retval = new MiniJavaParser.statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal63 = null;
		Token char_literal65 = null;
		Token IF66 = null;
		Token char_literal67 = null;
		Token char_literal69 = null;
		Token ELSE71 = null;
		Token WHILE73 = null;
		Token char_literal74 = null;
		Token char_literal76 = null;
		Token SYSOUT78 = null;
		Token char_literal79 = null;
		Token char_literal81 = null;
		Token char_literal82 = null;
		Token char_literal84 = null;
		Token char_literal86 = null;
		Token char_literal88 = null;
		Token char_literal90 = null;
		Token char_literal91 = null;
		Token char_literal93 = null;
		MiniJavaParser.statement_return statement64 = null;

		MiniJavaParser.expression_return expression68 = null;

		MiniJavaParser.statement_return statement70 = null;

		MiniJavaParser.statement_return statement72 = null;

		MiniJavaParser.expression_return expression75 = null;

		MiniJavaParser.statement_return statement77 = null;

		MiniJavaParser.expression_return expression80 = null;

		MiniJavaParser.identifier_return identifier83 = null;

		MiniJavaParser.expression_return expression85 = null;

		MiniJavaParser.identifier_return identifier87 = null;

		MiniJavaParser.expression_return expression89 = null;

		MiniJavaParser.expression_return expression92 = null;

		CommonTree char_literal63_tree = null;
		CommonTree char_literal65_tree = null;
		CommonTree IF66_tree = null;
		CommonTree char_literal67_tree = null;
		CommonTree char_literal69_tree = null;
		CommonTree ELSE71_tree = null;
		CommonTree WHILE73_tree = null;
		CommonTree char_literal74_tree = null;
		CommonTree char_literal76_tree = null;
		CommonTree SYSOUT78_tree = null;
		CommonTree char_literal79_tree = null;
		CommonTree char_literal81_tree = null;
		CommonTree char_literal82_tree = null;
		CommonTree char_literal84_tree = null;
		CommonTree char_literal86_tree = null;
		CommonTree char_literal88_tree = null;
		CommonTree char_literal90_tree = null;
		CommonTree char_literal91_tree = null;
		CommonTree char_literal93_tree = null;
		RewriteRuleTokenStream stream_69 = new RewriteRuleTokenStream(adaptor,
				"token 69");
		RewriteRuleTokenStream stream_59 = new RewriteRuleTokenStream(adaptor,
				"token 59");
		RewriteRuleTokenStream stream_58 = new RewriteRuleTokenStream(adaptor,
				"token 58");
		RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor,
				"token 56");
		RewriteRuleTokenStream stream_55 = new RewriteRuleTokenStream(adaptor,
				"token 55");
		RewriteRuleTokenStream stream_70 = new RewriteRuleTokenStream(adaptor,
				"token 70");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_statement = new RewriteRuleSubtreeStream(
				adaptor, "rule statement");
		RewriteRuleSubtreeStream stream_identifier = new RewriteRuleSubtreeStream(
				adaptor, "rule identifier");
		try {
			// /Users/margot/Downloads/MiniJava.g:147:2: ( '{' ( statement )*
			// '}' -> ^( STMNT_LIST ( statement )* ) | IF ^ '(' ! expression ')'
			// ! statement ELSE ! statement | WHILE ^ '(' ! expression ')' !
			// statement | SYSOUT ^ '(' ! expression ')' ! ';' !| identifier '='
			// expression ';' -> ^( ASSIGN ^( VAR_REF identifier ) expression )
			// | identifier '[' expression ']' '=' expression ';' -> ^(
			// ARRAY_ASSIGN ^( VAR_REF identifier ) expression expression ) )
			int alt13 = 6;
			switch (input.LA(1)) {
			case 69: {
				alt13 = 1;
			}
				break;
			case IF: {
				alt13 = 2;
			}
				break;
			case WHILE: {
				alt13 = 3;
			}
				break;
			case SYSOUT: {
				alt13 = 4;
			}
				break;
			case IDENTIFIER: {
				int LA13_5 = input.LA(2);

				if ((LA13_5 == 56)) {
					alt13 = 5;
				} else if ((LA13_5 == 58)) {
					alt13 = 6;
				} else {
					NoViableAltException nvae = new NoViableAltException("",
							13, 5, input);

					throw nvae;

				}
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 13, 0,
						input);

				throw nvae;

			}

			switch (alt13) {
			case 1:
			// /Users/margot/Downloads/MiniJava.g:147:4: '{' ( statement )* '}'
			{
				char_literal63 = (Token) match(input, 69,
						FOLLOW_69_in_statement800);
				stream_69.add(char_literal63);

				// /Users/margot/Downloads/MiniJava.g:147:8: ( statement )*
				loop12: do {
					int alt12 = 2;
					int LA12_0 = input.LA(1);

					if (((LA12_0 >= IDENTIFIER && LA12_0 <= IF)
							|| LA12_0 == SYSOUT || LA12_0 == WHILE || LA12_0 == 69)) {
						alt12 = 1;
					}

					switch (alt12) {
					case 1:
					// /Users/margot/Downloads/MiniJava.g:147:8: statement
					{
						pushFollow(FOLLOW_statement_in_statement802);
						statement64 = statement();

						state._fsp--;

						stream_statement.add(statement64.getTree());

					}
						break;

					default:
						break loop12;
					}
				} while (true);

				char_literal65 = (Token) match(input, 70,
						FOLLOW_70_in_statement805);
				stream_70.add(char_literal65);

				// AST REWRITE
				// elements: statement
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 147:23: -> ^( STMNT_LIST ( statement )* )
				{
					// /Users/margot/Downloads/MiniJava.g:147:26: ^( STMNT_LIST
					// ( statement )* )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(STMNT_LIST,
										"STMNT_LIST"), root_1);

						// /Users/margot/Downloads/MiniJava.g:147:39: (
						// statement )*
						while (stream_statement.hasNext()) {
							adaptor.addChild(root_1,
									stream_statement.nextTree());

						}
						stream_statement.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}
				break;
			case 2:
			// /Users/margot/Downloads/MiniJava.g:148:4: IF ^ '(' ! expression
			// ')' ! statement ELSE ! statement
			{
				root_0 = (CommonTree) adaptor.nil();

				IF66 = (Token) match(input, IF, FOLLOW_IF_in_statement819);
				IF66_tree = (CommonTree) adaptor.create(IF66);
				root_0 = (CommonTree) adaptor.becomeRoot(IF66_tree, root_0);

				char_literal67 = (Token) match(input, 51,
						FOLLOW_51_in_statement822);

				pushFollow(FOLLOW_expression_in_statement825);
				expression68 = expression();

				state._fsp--;

				adaptor.addChild(root_0, expression68.getTree());

				char_literal69 = (Token) match(input, 52,
						FOLLOW_52_in_statement827);

				pushFollow(FOLLOW_statement_in_statement830);
				statement70 = statement();

				state._fsp--;

				adaptor.addChild(root_0, statement70.getTree());

				ELSE71 = (Token) match(input, ELSE, FOLLOW_ELSE_in_statement832);

				pushFollow(FOLLOW_statement_in_statement835);
				statement72 = statement();

				state._fsp--;

				adaptor.addChild(root_0, statement72.getTree());

			}
				break;
			case 3:
			// /Users/margot/Downloads/MiniJava.g:149:4: WHILE ^ '(' !
			// expression ')' ! statement
			{
				root_0 = (CommonTree) adaptor.nil();

				WHILE73 = (Token) match(input, WHILE,
						FOLLOW_WHILE_in_statement840);
				WHILE73_tree = (CommonTree) adaptor.create(WHILE73);
				root_0 = (CommonTree) adaptor.becomeRoot(WHILE73_tree, root_0);

				char_literal74 = (Token) match(input, 51,
						FOLLOW_51_in_statement843);

				pushFollow(FOLLOW_expression_in_statement846);
				expression75 = expression();

				state._fsp--;

				adaptor.addChild(root_0, expression75.getTree());

				char_literal76 = (Token) match(input, 52,
						FOLLOW_52_in_statement848);

				pushFollow(FOLLOW_statement_in_statement851);
				statement77 = statement();

				state._fsp--;

				adaptor.addChild(root_0, statement77.getTree());

			}
				break;
			case 4:
			// /Users/margot/Downloads/MiniJava.g:150:4: SYSOUT ^ '(' !
			// expression ')' ! ';' !
			{
				root_0 = (CommonTree) adaptor.nil();

				SYSOUT78 = (Token) match(input, SYSOUT,
						FOLLOW_SYSOUT_in_statement856);
				SYSOUT78_tree = (CommonTree) adaptor.create(SYSOUT78);
				root_0 = (CommonTree) adaptor.becomeRoot(SYSOUT78_tree, root_0);

				char_literal79 = (Token) match(input, 51,
						FOLLOW_51_in_statement859);

				pushFollow(FOLLOW_expression_in_statement862);
				expression80 = expression();

				state._fsp--;

				adaptor.addChild(root_0, expression80.getTree());

				char_literal81 = (Token) match(input, 52,
						FOLLOW_52_in_statement864);

				char_literal82 = (Token) match(input, 55,
						FOLLOW_55_in_statement867);

			}
				break;
			case 5:
			// /Users/margot/Downloads/MiniJava.g:151:4: identifier '='
			// expression ';'
			{
				pushFollow(FOLLOW_identifier_in_statement873);
				identifier83 = identifier();

				state._fsp--;

				stream_identifier.add(identifier83.getTree());

				char_literal84 = (Token) match(input, 56,
						FOLLOW_56_in_statement875);
				stream_56.add(char_literal84);

				pushFollow(FOLLOW_expression_in_statement877);
				expression85 = expression();

				state._fsp--;

				stream_expression.add(expression85.getTree());

				char_literal86 = (Token) match(input, 55,
						FOLLOW_55_in_statement879);
				stream_55.add(char_literal86);

				// AST REWRITE
				// elements: identifier, expression
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 151:34: -> ^( ASSIGN ^( VAR_REF identifier ) expression )
				{
					// /Users/margot/Downloads/MiniJava.g:151:37: ^( ASSIGN ^(
					// VAR_REF identifier ) expression )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(ASSIGN, "ASSIGN"),
								root_1);

						// /Users/margot/Downloads/MiniJava.g:151:46: ^( VAR_REF
						// identifier )
						{
							CommonTree root_2 = (CommonTree) adaptor.nil();
							root_2 = (CommonTree) adaptor.becomeRoot(
									(CommonTree) adaptor.create(VAR_REF,
											"VAR_REF"), root_2);

							adaptor.addChild(root_2,
									stream_identifier.nextTree());

							adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_expression.nextTree());

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}
				break;
			case 6:
			// /Users/margot/Downloads/MiniJava.g:152:4: identifier '['
			// expression ']' '=' expression ';'
			{
				pushFollow(FOLLOW_identifier_in_statement898);
				identifier87 = identifier();

				state._fsp--;

				stream_identifier.add(identifier87.getTree());

				char_literal88 = (Token) match(input, 58,
						FOLLOW_58_in_statement900);
				stream_58.add(char_literal88);

				pushFollow(FOLLOW_expression_in_statement902);
				expression89 = expression();

				state._fsp--;

				stream_expression.add(expression89.getTree());

				char_literal90 = (Token) match(input, 59,
						FOLLOW_59_in_statement904);
				stream_59.add(char_literal90);

				char_literal91 = (Token) match(input, 56,
						FOLLOW_56_in_statement906);
				stream_56.add(char_literal91);

				pushFollow(FOLLOW_expression_in_statement908);
				expression92 = expression();

				state._fsp--;

				stream_expression.add(expression92.getTree());

				char_literal93 = (Token) match(input, 55,
						FOLLOW_55_in_statement910);
				stream_55.add(char_literal93);

				// AST REWRITE
				// elements: expression, identifier, expression
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 152:53: -> ^( ARRAY_ASSIGN ^( VAR_REF identifier ) expression
				// expression )
				{
					// /Users/margot/Downloads/MiniJava.g:152:56: ^(
					// ARRAY_ASSIGN ^( VAR_REF identifier ) expression
					// expression )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(ARRAY_ASSIGN,
										"ARRAY_ASSIGN"), root_1);

						// /Users/margot/Downloads/MiniJava.g:152:71: ^( VAR_REF
						// identifier )
						{
							CommonTree root_2 = (CommonTree) adaptor.nil();
							root_2 = (CommonTree) adaptor.becomeRoot(
									(CommonTree) adaptor.create(VAR_REF,
											"VAR_REF"), root_2);

							adaptor.addChild(root_2,
									stream_identifier.nextTree());

							adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_expression.nextTree());

						adaptor.addChild(root_1, stream_expression.nextTree());

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "statement"

	public static class orExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "orExpr"
	// /Users/margot/Downloads/MiniJava.g:156:1: orExpr : andExpr ( LOGIC_OR ^
	// andExpr )* ;
	public final MiniJavaParser.orExpr_return orExpr()
			throws RecognitionException {
		MiniJavaParser.orExpr_return retval = new MiniJavaParser.orExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LOGIC_OR95 = null;
		MiniJavaParser.andExpr_return andExpr94 = null;

		MiniJavaParser.andExpr_return andExpr96 = null;

		CommonTree LOGIC_OR95_tree = null;

		try {
			// /Users/margot/Downloads/MiniJava.g:156:9: ( andExpr ( LOGIC_OR ^
			// andExpr )* )
			// /Users/margot/Downloads/MiniJava.g:156:11: andExpr ( LOGIC_OR ^
			// andExpr )*
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_andExpr_in_orExpr939);
				andExpr94 = andExpr();

				state._fsp--;

				adaptor.addChild(root_0, andExpr94.getTree());

				// /Users/margot/Downloads/MiniJava.g:156:19: ( LOGIC_OR ^
				// andExpr )*
				loop14: do {
					int alt14 = 2;
					int LA14_0 = input.LA(1);

					if ((LA14_0 == LOGIC_OR)) {
						alt14 = 1;
					}

					switch (alt14) {
					case 1:
					// /Users/margot/Downloads/MiniJava.g:156:21: LOGIC_OR ^
					// andExpr
					{
						LOGIC_OR95 = (Token) match(input, LOGIC_OR,
								FOLLOW_LOGIC_OR_in_orExpr943);
						LOGIC_OR95_tree = (CommonTree) adaptor
								.create(LOGIC_OR95);
						root_0 = (CommonTree) adaptor.becomeRoot(
								LOGIC_OR95_tree, root_0);

						pushFollow(FOLLOW_andExpr_in_orExpr946);
						andExpr96 = andExpr();

						state._fsp--;

						adaptor.addChild(root_0, andExpr96.getTree());

					}
						break;

					default:
						break loop14;
					}
				} while (true);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "orExpr"

	public static class andExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "andExpr"
	// /Users/margot/Downloads/MiniJava.g:159:1: andExpr : compareExpr (
	// LOGIC_AND ^ compareExpr )* ;
	public final MiniJavaParser.andExpr_return andExpr()
			throws RecognitionException {
		MiniJavaParser.andExpr_return retval = new MiniJavaParser.andExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LOGIC_AND98 = null;
		MiniJavaParser.compareExpr_return compareExpr97 = null;

		MiniJavaParser.compareExpr_return compareExpr99 = null;

		CommonTree LOGIC_AND98_tree = null;

		try {
			// /Users/margot/Downloads/MiniJava.g:159:9: ( compareExpr (
			// LOGIC_AND ^ compareExpr )* )
			// /Users/margot/Downloads/MiniJava.g:159:11: compareExpr (
			// LOGIC_AND ^ compareExpr )*
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_compareExpr_in_andExpr959);
				compareExpr97 = compareExpr();

				state._fsp--;

				adaptor.addChild(root_0, compareExpr97.getTree());

				// /Users/margot/Downloads/MiniJava.g:159:23: ( LOGIC_AND ^
				// compareExpr )*
				loop15: do {
					int alt15 = 2;
					int LA15_0 = input.LA(1);

					if ((LA15_0 == LOGIC_AND)) {
						alt15 = 1;
					}

					switch (alt15) {
					case 1:
					// /Users/margot/Downloads/MiniJava.g:159:25: LOGIC_AND ^
					// compareExpr
					{
						LOGIC_AND98 = (Token) match(input, LOGIC_AND,
								FOLLOW_LOGIC_AND_in_andExpr963);
						LOGIC_AND98_tree = (CommonTree) adaptor
								.create(LOGIC_AND98);
						root_0 = (CommonTree) adaptor.becomeRoot(
								LOGIC_AND98_tree, root_0);

						pushFollow(FOLLOW_compareExpr_in_andExpr966);
						compareExpr99 = compareExpr();

						state._fsp--;

						adaptor.addChild(root_0, compareExpr99.getTree());

					}
						break;

					default:
						break loop15;
					}
				} while (true);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "andExpr"

	public static class compareExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "compareExpr"
	// /Users/margot/Downloads/MiniJava.g:162:1: compareExpr : additiveExpr ( LT
	// ^ additiveExpr )? ;
	public final MiniJavaParser.compareExpr_return compareExpr()
			throws RecognitionException {
		MiniJavaParser.compareExpr_return retval = new MiniJavaParser.compareExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LT101 = null;
		MiniJavaParser.additiveExpr_return additiveExpr100 = null;

		MiniJavaParser.additiveExpr_return additiveExpr102 = null;

		CommonTree LT101_tree = null;

		try {
			// /Users/margot/Downloads/MiniJava.g:163:2: ( additiveExpr ( LT ^
			// additiveExpr )? )
			// /Users/margot/Downloads/MiniJava.g:163:4: additiveExpr ( LT ^
			// additiveExpr )?
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_additiveExpr_in_compareExpr982);
				additiveExpr100 = additiveExpr();

				state._fsp--;

				adaptor.addChild(root_0, additiveExpr100.getTree());

				// /Users/margot/Downloads/MiniJava.g:163:17: ( LT ^
				// additiveExpr )?
				int alt16 = 2;
				int LA16_0 = input.LA(1);

				if ((LA16_0 == LT)) {
					alt16 = 1;
				}
				switch (alt16) {
				case 1:
				// /Users/margot/Downloads/MiniJava.g:163:19: LT ^ additiveExpr
				{
					LT101 = (Token) match(input, LT,
							FOLLOW_LT_in_compareExpr986);
					LT101_tree = (CommonTree) adaptor.create(LT101);
					root_0 = (CommonTree) adaptor
							.becomeRoot(LT101_tree, root_0);

					pushFollow(FOLLOW_additiveExpr_in_compareExpr989);
					additiveExpr102 = additiveExpr();

					state._fsp--;

					adaptor.addChild(root_0, additiveExpr102.getTree());

				}
					break;

				}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "compareExpr"

	public static class additiveExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "additiveExpr"
	// /Users/margot/Downloads/MiniJava.g:167:1: additiveExpr : multExpr ( (
	// PLUS ^| MINUS ^) multExpr )* ;
	public final MiniJavaParser.additiveExpr_return additiveExpr()
			throws RecognitionException {
		MiniJavaParser.additiveExpr_return retval = new MiniJavaParser.additiveExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token PLUS104 = null;
		Token MINUS105 = null;
		MiniJavaParser.multExpr_return multExpr103 = null;

		MiniJavaParser.multExpr_return multExpr106 = null;

		CommonTree PLUS104_tree = null;
		CommonTree MINUS105_tree = null;

		try {
			// /Users/margot/Downloads/MiniJava.g:168:2: ( multExpr ( ( PLUS ^|
			// MINUS ^) multExpr )* )
			// /Users/margot/Downloads/MiniJava.g:168:4: multExpr ( ( PLUS ^|
			// MINUS ^) multExpr )*
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_multExpr_in_additiveExpr1006);
				multExpr103 = multExpr();

				state._fsp--;

				adaptor.addChild(root_0, multExpr103.getTree());

				// /Users/margot/Downloads/MiniJava.g:168:13: ( ( PLUS ^| MINUS
				// ^) multExpr )*
				loop18: do {
					int alt18 = 2;
					int LA18_0 = input.LA(1);

					if ((LA18_0 == MINUS || LA18_0 == PLUS)) {
						alt18 = 1;
					}

					switch (alt18) {
					case 1:
					// /Users/margot/Downloads/MiniJava.g:168:15: ( PLUS ^|
					// MINUS ^) multExpr
					{
						// /Users/margot/Downloads/MiniJava.g:168:15: ( PLUS ^|
						// MINUS ^)
						int alt17 = 2;
						int LA17_0 = input.LA(1);

						if ((LA17_0 == PLUS)) {
							alt17 = 1;
						} else if ((LA17_0 == MINUS)) {
							alt17 = 2;
						} else {
							NoViableAltException nvae = new NoViableAltException(
									"", 17, 0, input);

							throw nvae;

						}
						switch (alt17) {
						case 1:
						// /Users/margot/Downloads/MiniJava.g:168:16: PLUS ^
						{
							PLUS104 = (Token) match(input, PLUS,
									FOLLOW_PLUS_in_additiveExpr1011);
							PLUS104_tree = (CommonTree) adaptor.create(PLUS104);
							root_0 = (CommonTree) adaptor.becomeRoot(
									PLUS104_tree, root_0);

						}
							break;
						case 2:
						// /Users/margot/Downloads/MiniJava.g:168:22: MINUS ^
						{
							MINUS105 = (Token) match(input, MINUS,
									FOLLOW_MINUS_in_additiveExpr1014);
							MINUS105_tree = (CommonTree) adaptor
									.create(MINUS105);
							root_0 = (CommonTree) adaptor.becomeRoot(
									MINUS105_tree, root_0);

						}
							break;

						}

						pushFollow(FOLLOW_multExpr_in_additiveExpr1018);
						multExpr106 = multExpr();

						state._fsp--;

						adaptor.addChild(root_0, multExpr106.getTree());

					}
						break;

					default:
						break loop18;
					}
				} while (true);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "additiveExpr"

	public static class multExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "multExpr"
	// /Users/margot/Downloads/MiniJava.g:171:1: multExpr : unaryExpr ( MULT ^
	// unaryExpr )* ;
	public final MiniJavaParser.multExpr_return multExpr()
			throws RecognitionException {
		MiniJavaParser.multExpr_return retval = new MiniJavaParser.multExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MULT108 = null;
		MiniJavaParser.unaryExpr_return unaryExpr107 = null;

		MiniJavaParser.unaryExpr_return unaryExpr109 = null;

		CommonTree MULT108_tree = null;

		try {
			// /Users/margot/Downloads/MiniJava.g:171:9: ( unaryExpr ( MULT ^
			// unaryExpr )* )
			// /Users/margot/Downloads/MiniJava.g:171:11: unaryExpr ( MULT ^
			// unaryExpr )*
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_unaryExpr_in_multExpr1030);
				unaryExpr107 = unaryExpr();

				state._fsp--;

				adaptor.addChild(root_0, unaryExpr107.getTree());

				// /Users/margot/Downloads/MiniJava.g:171:21: ( MULT ^ unaryExpr
				// )*
				loop19: do {
					int alt19 = 2;
					int LA19_0 = input.LA(1);

					if ((LA19_0 == MULT)) {
						alt19 = 1;
					}

					switch (alt19) {
					case 1:
					// /Users/margot/Downloads/MiniJava.g:171:23: MULT ^
					// unaryExpr
					{
						MULT108 = (Token) match(input, MULT,
								FOLLOW_MULT_in_multExpr1034);
						MULT108_tree = (CommonTree) adaptor.create(MULT108);
						root_0 = (CommonTree) adaptor.becomeRoot(MULT108_tree,
								root_0);

						pushFollow(FOLLOW_unaryExpr_in_multExpr1037);
						unaryExpr109 = unaryExpr();

						state._fsp--;

						adaptor.addChild(root_0, unaryExpr109.getTree());

					}
						break;

					default:
						break loop19;
					}
				} while (true);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "multExpr"

	public static class unaryExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "unaryExpr"
	// /Users/margot/Downloads/MiniJava.g:174:1: unaryExpr : ( UNARY_NOT ^)?
	// primaryExpression ;
	public final MiniJavaParser.unaryExpr_return unaryExpr()
			throws RecognitionException {
		MiniJavaParser.unaryExpr_return retval = new MiniJavaParser.unaryExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token UNARY_NOT110 = null;
		MiniJavaParser.primaryExpression_return primaryExpression111 = null;

		CommonTree UNARY_NOT110_tree = null;

		try {
			// /Users/margot/Downloads/MiniJava.g:175:2: ( ( UNARY_NOT ^)?
			// primaryExpression )
			// /Users/margot/Downloads/MiniJava.g:175:4: ( UNARY_NOT ^)?
			// primaryExpression
			{
				root_0 = (CommonTree) adaptor.nil();

				// /Users/margot/Downloads/MiniJava.g:175:4: ( UNARY_NOT ^)?
				int alt20 = 2;
				int LA20_0 = input.LA(1);

				if ((LA20_0 == UNARY_NOT)) {
					alt20 = 1;
				}
				switch (alt20) {
				case 1:
				// /Users/margot/Downloads/MiniJava.g:175:5: UNARY_NOT ^
				{
					UNARY_NOT110 = (Token) match(input, UNARY_NOT,
							FOLLOW_UNARY_NOT_in_unaryExpr1053);
					UNARY_NOT110_tree = (CommonTree) adaptor
							.create(UNARY_NOT110);
					root_0 = (CommonTree) adaptor.becomeRoot(UNARY_NOT110_tree,
							root_0);

				}
					break;

				}

				pushFollow(FOLLOW_primaryExpression_in_unaryExpr1058);
				primaryExpression111 = primaryExpression();

				state._fsp--;

				adaptor.addChild(root_0, primaryExpression111.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "unaryExpr"

	public static class primaryExpression_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "primaryExpression"
	// /Users/margot/Downloads/MiniJava.g:178:1: primaryExpression :
	// primaryExpressionPrefix ( ( '[' indexExpr= expression ']' -> ^(
	// ARRAY_READ primaryExpressionPrefix $indexExpr) ) | ( arrayLengthReference
	// -> ^( ARRAYLENGTH_REFERENCE primaryExpressionPrefix ) ) | (
	// methodInvocation )+ -> ^( METHOD_CALL primaryExpressionPrefix ( ^(
	// SUFFIX_PART methodInvocation ) )+ ) | -> primaryExpressionPrefix ) ;
	public final MiniJavaParser.primaryExpression_return primaryExpression()
			throws RecognitionException {
		MiniJavaParser.primaryExpression_return retval = new MiniJavaParser.primaryExpression_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal113 = null;
		Token char_literal114 = null;
		MiniJavaParser.expression_return indexExpr = null;

		MiniJavaParser.primaryExpressionPrefix_return primaryExpressionPrefix112 = null;

		MiniJavaParser.arrayLengthReference_return arrayLengthReference115 = null;

		MiniJavaParser.methodInvocation_return methodInvocation116 = null;

		CommonTree char_literal113_tree = null;
		CommonTree char_literal114_tree = null;
		RewriteRuleTokenStream stream_59 = new RewriteRuleTokenStream(adaptor,
				"token 59");
		RewriteRuleTokenStream stream_58 = new RewriteRuleTokenStream(adaptor,
				"token 58");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_arrayLengthReference = new RewriteRuleSubtreeStream(
				adaptor, "rule arrayLengthReference");
		RewriteRuleSubtreeStream stream_primaryExpressionPrefix = new RewriteRuleSubtreeStream(
				adaptor, "rule primaryExpressionPrefix");
		RewriteRuleSubtreeStream stream_methodInvocation = new RewriteRuleSubtreeStream(
				adaptor, "rule methodInvocation");
		try {
			// /Users/margot/Downloads/MiniJava.g:179:2: (
			// primaryExpressionPrefix ( ( '[' indexExpr= expression ']' -> ^(
			// ARRAY_READ primaryExpressionPrefix $indexExpr) ) | (
			// arrayLengthReference -> ^( ARRAYLENGTH_REFERENCE
			// primaryExpressionPrefix ) ) | ( methodInvocation )+ -> ^(
			// METHOD_CALL primaryExpressionPrefix ( ^( SUFFIX_PART
			// methodInvocation ) )+ ) | -> primaryExpressionPrefix ) )
			// /Users/margot/Downloads/MiniJava.g:179:4: primaryExpressionPrefix
			// ( ( '[' indexExpr= expression ']' -> ^( ARRAY_READ
			// primaryExpressionPrefix $indexExpr) ) | ( arrayLengthReference ->
			// ^( ARRAYLENGTH_REFERENCE primaryExpressionPrefix ) ) | (
			// methodInvocation )+ -> ^( METHOD_CALL primaryExpressionPrefix (
			// ^( SUFFIX_PART methodInvocation ) )+ ) | ->
			// primaryExpressionPrefix )
			{
				pushFollow(FOLLOW_primaryExpressionPrefix_in_primaryExpression1070);
				primaryExpressionPrefix112 = primaryExpressionPrefix();

				state._fsp--;

				stream_primaryExpressionPrefix.add(primaryExpressionPrefix112
						.getTree());

				// /Users/margot/Downloads/MiniJava.g:180:3: ( ( '[' indexExpr=
				// expression ']' -> ^( ARRAY_READ primaryExpressionPrefix
				// $indexExpr) ) | ( arrayLengthReference -> ^(
				// ARRAYLENGTH_REFERENCE primaryExpressionPrefix ) ) | (
				// methodInvocation )+ -> ^( METHOD_CALL primaryExpressionPrefix
				// ( ^( SUFFIX_PART methodInvocation ) )+ ) | ->
				// primaryExpressionPrefix )
				int alt22 = 4;
				switch (input.LA(1)) {
				case 58: {
					alt22 = 1;
				}
					break;
				case 54: {
					int LA22_2 = input.LA(2);

					if ((LA22_2 == 62)) {
						alt22 = 2;
					} else if ((LA22_2 == IDENTIFIER)) {
						alt22 = 3;
					} else {
						NoViableAltException nvae = new NoViableAltException(
								"", 22, 2, input);

						throw nvae;

					}
				}
					break;
				case LOGIC_AND:
				case LOGIC_OR:
				case LT:
				case MINUS:
				case MULT:
				case PLUS:
				case 52:
				case 53:
				case 55:
				case 59: {
					alt22 = 4;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("",
							22, 0, input);

					throw nvae;

				}

				switch (alt22) {
				case 1:
				// /Users/margot/Downloads/MiniJava.g:181:7: ( '[' indexExpr=
				// expression ']' -> ^( ARRAY_READ primaryExpressionPrefix
				// $indexExpr) )
				{
					// /Users/margot/Downloads/MiniJava.g:181:7: ( '['
					// indexExpr= expression ']' -> ^( ARRAY_READ
					// primaryExpressionPrefix $indexExpr) )
					// /Users/margot/Downloads/MiniJava.g:181:8: '[' indexExpr=
					// expression ']'
					{
						char_literal113 = (Token) match(input, 58,
								FOLLOW_58_in_primaryExpression1084);
						stream_58.add(char_literal113);

						pushFollow(FOLLOW_expression_in_primaryExpression1088);
						indexExpr = expression();

						state._fsp--;

						stream_expression.add(indexExpr.getTree());

						char_literal114 = (Token) match(input, 59,
								FOLLOW_59_in_primaryExpression1090);
						stream_59.add(char_literal114);

						// AST REWRITE
						// elements: primaryExpressionPrefix, indexExpr
						// token labels:
						// rule labels: retval, indexExpr
						// token list labels:
						// rule list labels:
						// wildcard labels:
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								adaptor, "rule retval",
								retval != null ? retval.tree : null);
						RewriteRuleSubtreeStream stream_indexExpr = new RewriteRuleSubtreeStream(
								adaptor, "rule indexExpr",
								indexExpr != null ? indexExpr.tree : null);

						root_0 = (CommonTree) adaptor.nil();
						// 181:37: -> ^( ARRAY_READ primaryExpressionPrefix
						// $indexExpr)
						{
							// /Users/margot/Downloads/MiniJava.g:181:40: ^(
							// ARRAY_READ primaryExpressionPrefix $indexExpr)
							{
								CommonTree root_1 = (CommonTree) adaptor.nil();
								root_1 = (CommonTree) adaptor.becomeRoot(
										(CommonTree) adaptor.create(ARRAY_READ,
												"ARRAY_READ"), root_1);

								adaptor.addChild(root_1,
										stream_primaryExpressionPrefix
												.nextTree());

								adaptor.addChild(root_1,
										stream_indexExpr.nextTree());

								adaptor.addChild(root_0, root_1);
							}

						}

						retval.tree = root_0;

					}

				}
					break;
				case 2:
				// /Users/margot/Downloads/MiniJava.g:182:7: (
				// arrayLengthReference -> ^( ARRAYLENGTH_REFERENCE
				// primaryExpressionPrefix ) )
				{
					// /Users/margot/Downloads/MiniJava.g:182:7: (
					// arrayLengthReference -> ^( ARRAYLENGTH_REFERENCE
					// primaryExpressionPrefix ) )
					// /Users/margot/Downloads/MiniJava.g:182:8:
					// arrayLengthReference
					{
						pushFollow(FOLLOW_arrayLengthReference_in_primaryExpression1111);
						arrayLengthReference115 = arrayLengthReference();

						state._fsp--;

						stream_arrayLengthReference.add(arrayLengthReference115
								.getTree());

						// AST REWRITE
						// elements: primaryExpressionPrefix
						// token labels:
						// rule labels: retval
						// token list labels:
						// rule list labels:
						// wildcard labels:
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
								adaptor, "rule retval",
								retval != null ? retval.tree : null);

						root_0 = (CommonTree) adaptor.nil();
						// 182:29: -> ^( ARRAYLENGTH_REFERENCE
						// primaryExpressionPrefix )
						{
							// /Users/margot/Downloads/MiniJava.g:182:32: ^(
							// ARRAYLENGTH_REFERENCE primaryExpressionPrefix )
							{
								CommonTree root_1 = (CommonTree) adaptor.nil();
								root_1 = (CommonTree) adaptor.becomeRoot(
										(CommonTree) adaptor.create(
												ARRAYLENGTH_REFERENCE,
												"ARRAYLENGTH_REFERENCE"),
										root_1);

								adaptor.addChild(root_1,
										stream_primaryExpressionPrefix
												.nextTree());

								adaptor.addChild(root_0, root_1);
							}

						}

						retval.tree = root_0;

					}

				}
					break;
				case 3:
				// /Users/margot/Downloads/MiniJava.g:183:7: ( methodInvocation
				// )+
				{
					// /Users/margot/Downloads/MiniJava.g:183:7: (
					// methodInvocation )+
					int cnt21 = 0;
					loop21: do {
						int alt21 = 2;
						int LA21_0 = input.LA(1);

						if ((LA21_0 == 54)) {
							alt21 = 1;
						}

						switch (alt21) {
						case 1:
						// /Users/margot/Downloads/MiniJava.g:183:7:
						// methodInvocation
						{
							pushFollow(FOLLOW_methodInvocation_in_primaryExpression1128);
							methodInvocation116 = methodInvocation();

							state._fsp--;

							stream_methodInvocation.add(methodInvocation116
									.getTree());

						}
							break;

						default:
							if (cnt21 >= 1)
								break loop21;
							EarlyExitException eee = new EarlyExitException(21,
									input);
							throw eee;
						}
						cnt21++;
					} while (true);

					// AST REWRITE
					// elements: primaryExpressionPrefix, methodInvocation
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							adaptor, "rule retval",
							retval != null ? retval.tree : null);

					root_0 = (CommonTree) adaptor.nil();
					// 183:27: -> ^( METHOD_CALL primaryExpressionPrefix ( ^(
					// SUFFIX_PART methodInvocation ) )+ )
					{
						// /Users/margot/Downloads/MiniJava.g:183:30: ^(
						// METHOD_CALL primaryExpressionPrefix ( ^( SUFFIX_PART
						// methodInvocation ) )+ )
						{
							CommonTree root_1 = (CommonTree) adaptor.nil();
							root_1 = (CommonTree) adaptor.becomeRoot(
									(CommonTree) adaptor.create(METHOD_CALL,
											"METHOD_CALL"), root_1);

							adaptor.addChild(root_1,
									stream_primaryExpressionPrefix.nextTree());

							if (!(stream_methodInvocation.hasNext())) {
								throw new RewriteEarlyExitException();
							}
							while (stream_methodInvocation.hasNext()) {
								// /Users/margot/Downloads/MiniJava.g:183:68: ^(
								// SUFFIX_PART methodInvocation )
								{
									CommonTree root_2 = (CommonTree) adaptor
											.nil();
									root_2 = (CommonTree) adaptor
											.becomeRoot((CommonTree) adaptor
													.create(SUFFIX_PART,
															"SUFFIX_PART"),
													root_2);

									adaptor.addChild(root_2,
											stream_methodInvocation.nextTree());

									adaptor.addChild(root_1, root_2);
								}

							}
							stream_methodInvocation.reset();

							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;

				}
					break;
				case 4:
				// /Users/margot/Downloads/MiniJava.g:184:7:
				{
					// AST REWRITE
					// elements: primaryExpressionPrefix
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							adaptor, "rule retval",
							retval != null ? retval.tree : null);

					root_0 = (CommonTree) adaptor.nil();
					// 184:7: -> primaryExpressionPrefix
					{
						adaptor.addChild(root_0,
								stream_primaryExpressionPrefix.nextTree());

					}

					retval.tree = root_0;

				}
					break;

				}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "primaryExpression"

	public static class methodInvocation_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "methodInvocation"
	// /Users/margot/Downloads/MiniJava.g:188:1: methodInvocation : '.' !
	// identifier '(' ! expressionList ')' !;
	public final MiniJavaParser.methodInvocation_return methodInvocation()
			throws RecognitionException {
		MiniJavaParser.methodInvocation_return retval = new MiniJavaParser.methodInvocation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal117 = null;
		Token char_literal119 = null;
		Token char_literal121 = null;
		MiniJavaParser.identifier_return identifier118 = null;

		MiniJavaParser.expressionList_return expressionList120 = null;

		CommonTree char_literal117_tree = null;
		CommonTree char_literal119_tree = null;
		CommonTree char_literal121_tree = null;

		try {
			// /Users/margot/Downloads/MiniJava.g:189:2: ( '.' ! identifier '('
			// ! expressionList ')' !)
			// /Users/margot/Downloads/MiniJava.g:189:4: '.' ! identifier '(' !
			// expressionList ')' !
			{
				root_0 = (CommonTree) adaptor.nil();

				char_literal117 = (Token) match(input, 54,
						FOLLOW_54_in_methodInvocation1172);

				pushFollow(FOLLOW_identifier_in_methodInvocation1175);
				identifier118 = identifier();

				state._fsp--;

				adaptor.addChild(root_0, identifier118.getTree());

				char_literal119 = (Token) match(input, 51,
						FOLLOW_51_in_methodInvocation1177);

				pushFollow(FOLLOW_expressionList_in_methodInvocation1180);
				expressionList120 = expressionList();

				state._fsp--;

				adaptor.addChild(root_0, expressionList120.getTree());

				char_literal121 = (Token) match(input, 52,
						FOLLOW_52_in_methodInvocation1182);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "methodInvocation"

	public static class primaryExpressionPrefix_return extends
			ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "primaryExpressionPrefix"
	// /Users/margot/Downloads/MiniJava.g:193:1: primaryExpressionPrefix : (
	// INTEGER -> ^( CONST INTEGER ) | TRUE -> ^( CONST TRUE ) | FALSE -> ^(
	// CONST FALSE ) | THIS | '(' ! expression ')' !| 'new' 'int' '[' expression
	// ']' -> ^( INTARRAY_NEW expression ) | 'new' identifier '(' ')' -> ^( NEW
	// identifier ) | identifier -> ^( VAR_REF identifier ) );
	public final MiniJavaParser.primaryExpressionPrefix_return primaryExpressionPrefix()
			throws RecognitionException {
		MiniJavaParser.primaryExpressionPrefix_return retval = new MiniJavaParser.primaryExpressionPrefix_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INTEGER122 = null;
		Token TRUE123 = null;
		Token FALSE124 = null;
		Token THIS125 = null;
		Token char_literal126 = null;
		Token char_literal128 = null;
		Token string_literal129 = null;
		Token string_literal130 = null;
		Token char_literal131 = null;
		Token char_literal133 = null;
		Token string_literal134 = null;
		Token char_literal136 = null;
		Token char_literal137 = null;
		MiniJavaParser.expression_return expression127 = null;

		MiniJavaParser.expression_return expression132 = null;

		MiniJavaParser.identifier_return identifier135 = null;

		MiniJavaParser.identifier_return identifier138 = null;

		CommonTree INTEGER122_tree = null;
		CommonTree TRUE123_tree = null;
		CommonTree FALSE124_tree = null;
		CommonTree THIS125_tree = null;
		CommonTree char_literal126_tree = null;
		CommonTree char_literal128_tree = null;
		CommonTree string_literal129_tree = null;
		CommonTree string_literal130_tree = null;
		CommonTree char_literal131_tree = null;
		CommonTree char_literal133_tree = null;
		CommonTree string_literal134_tree = null;
		CommonTree char_literal136_tree = null;
		CommonTree char_literal137_tree = null;
		RewriteRuleTokenStream stream_INTEGER = new RewriteRuleTokenStream(
				adaptor, "token INTEGER");
		RewriteRuleTokenStream stream_59 = new RewriteRuleTokenStream(adaptor,
				"token 59");
		RewriteRuleTokenStream stream_58 = new RewriteRuleTokenStream(adaptor,
				"token 58");
		RewriteRuleTokenStream stream_51 = new RewriteRuleTokenStream(adaptor,
				"token 51");
		RewriteRuleTokenStream stream_64 = new RewriteRuleTokenStream(adaptor,
				"token 64");
		RewriteRuleTokenStream stream_52 = new RewriteRuleTokenStream(adaptor,
				"token 52");
		RewriteRuleTokenStream stream_FALSE = new RewriteRuleTokenStream(
				adaptor, "token FALSE");
		RewriteRuleTokenStream stream_TRUE = new RewriteRuleTokenStream(
				adaptor, "token TRUE");
		RewriteRuleTokenStream stream_61 = new RewriteRuleTokenStream(adaptor,
				"token 61");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(
				adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_identifier = new RewriteRuleSubtreeStream(
				adaptor, "rule identifier");
		try {
			// /Users/margot/Downloads/MiniJava.g:194:2: ( INTEGER -> ^( CONST
			// INTEGER ) | TRUE -> ^( CONST TRUE ) | FALSE -> ^( CONST FALSE ) |
			// THIS | '(' ! expression ')' !| 'new' 'int' '[' expression ']' ->
			// ^( INTARRAY_NEW expression ) | 'new' identifier '(' ')' -> ^( NEW
			// identifier ) | identifier -> ^( VAR_REF identifier ) )
			int alt23 = 8;
			switch (input.LA(1)) {
			case INTEGER: {
				alt23 = 1;
			}
				break;
			case TRUE: {
				alt23 = 2;
			}
				break;
			case FALSE: {
				alt23 = 3;
			}
				break;
			case THIS: {
				alt23 = 4;
			}
				break;
			case 51: {
				alt23 = 5;
			}
				break;
			case 64: {
				int LA23_6 = input.LA(2);

				if ((LA23_6 == 61)) {
					alt23 = 6;
				} else if ((LA23_6 == IDENTIFIER)) {
					alt23 = 7;
				} else {
					NoViableAltException nvae = new NoViableAltException("",
							23, 6, input);

					throw nvae;

				}
			}
				break;
			case IDENTIFIER: {
				alt23 = 8;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 23, 0,
						input);

				throw nvae;

			}

			switch (alt23) {
			case 1:
			// /Users/margot/Downloads/MiniJava.g:194:4: INTEGER
			{
				INTEGER122 = (Token) match(input, INTEGER,
						FOLLOW_INTEGER_in_primaryExpressionPrefix1197);
				stream_INTEGER.add(INTEGER122);

				// AST REWRITE
				// elements: INTEGER
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 194:12: -> ^( CONST INTEGER )
				{
					// /Users/margot/Downloads/MiniJava.g:194:15: ^( CONST
					// INTEGER )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(CONST, "CONST"),
								root_1);

						adaptor.addChild(root_1, stream_INTEGER.nextNode());

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}
				break;
			case 2:
			// /Users/margot/Downloads/MiniJava.g:195:4: TRUE
			{
				TRUE123 = (Token) match(input, TRUE,
						FOLLOW_TRUE_in_primaryExpressionPrefix1210);
				stream_TRUE.add(TRUE123);

				// AST REWRITE
				// elements: TRUE
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 195:10: -> ^( CONST TRUE )
				{
					// /Users/margot/Downloads/MiniJava.g:195:13: ^( CONST TRUE
					// )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(CONST, "CONST"),
								root_1);

						adaptor.addChild(root_1, stream_TRUE.nextNode());

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}
				break;
			case 3:
			// /Users/margot/Downloads/MiniJava.g:196:4: FALSE
			{
				FALSE124 = (Token) match(input, FALSE,
						FOLLOW_FALSE_in_primaryExpressionPrefix1224);
				stream_FALSE.add(FALSE124);

				// AST REWRITE
				// elements: FALSE
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 196:10: -> ^( CONST FALSE )
				{
					// /Users/margot/Downloads/MiniJava.g:196:13: ^( CONST FALSE
					// )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(CONST, "CONST"),
								root_1);

						adaptor.addChild(root_1, stream_FALSE.nextNode());

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}
				break;
			case 4:
			// /Users/margot/Downloads/MiniJava.g:197:4: THIS
			{
				root_0 = (CommonTree) adaptor.nil();

				THIS125 = (Token) match(input, THIS,
						FOLLOW_THIS_in_primaryExpressionPrefix1237);
				THIS125_tree = (CommonTree) adaptor.create(THIS125);
				adaptor.addChild(root_0, THIS125_tree);

			}
				break;
			case 5:
			// /Users/margot/Downloads/MiniJava.g:198:4: '(' ! expression ')' !
			{
				root_0 = (CommonTree) adaptor.nil();

				char_literal126 = (Token) match(input, 51,
						FOLLOW_51_in_primaryExpressionPrefix1242);

				pushFollow(FOLLOW_expression_in_primaryExpressionPrefix1245);
				expression127 = expression();

				state._fsp--;

				adaptor.addChild(root_0, expression127.getTree());

				char_literal128 = (Token) match(input, 52,
						FOLLOW_52_in_primaryExpressionPrefix1247);

			}
				break;
			case 6:
			// /Users/margot/Downloads/MiniJava.g:199:4: 'new' 'int' '['
			// expression ']'
			{
				string_literal129 = (Token) match(input, 64,
						FOLLOW_64_in_primaryExpressionPrefix1253);
				stream_64.add(string_literal129);

				string_literal130 = (Token) match(input, 61,
						FOLLOW_61_in_primaryExpressionPrefix1255);
				stream_61.add(string_literal130);

				char_literal131 = (Token) match(input, 58,
						FOLLOW_58_in_primaryExpressionPrefix1257);
				stream_58.add(char_literal131);

				pushFollow(FOLLOW_expression_in_primaryExpressionPrefix1259);
				expression132 = expression();

				state._fsp--;

				stream_expression.add(expression132.getTree());

				char_literal133 = (Token) match(input, 59,
						FOLLOW_59_in_primaryExpressionPrefix1261);
				stream_59.add(char_literal133);

				// AST REWRITE
				// elements: expression
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 199:35: -> ^( INTARRAY_NEW expression )
				{
					// /Users/margot/Downloads/MiniJava.g:199:38: ^(
					// INTARRAY_NEW expression )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor.becomeRoot(
								(CommonTree) adaptor.create(INTARRAY_NEW,
										"INTARRAY_NEW"), root_1);

						adaptor.addChild(root_1, stream_expression.nextTree());

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}
				break;
			case 7:
			// /Users/margot/Downloads/MiniJava.g:200:4: 'new' identifier '('
			// ')'
			{
				string_literal134 = (Token) match(input, 64,
						FOLLOW_64_in_primaryExpressionPrefix1274);
				stream_64.add(string_literal134);

				pushFollow(FOLLOW_identifier_in_primaryExpressionPrefix1276);
				identifier135 = identifier();

				state._fsp--;

				stream_identifier.add(identifier135.getTree());

				char_literal136 = (Token) match(input, 51,
						FOLLOW_51_in_primaryExpressionPrefix1278);
				stream_51.add(char_literal136);

				char_literal137 = (Token) match(input, 52,
						FOLLOW_52_in_primaryExpressionPrefix1280);
				stream_52.add(char_literal137);

				// AST REWRITE
				// elements: identifier
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 200:29: -> ^( NEW identifier )
				{
					// /Users/margot/Downloads/MiniJava.g:200:32: ^( NEW
					// identifier )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor
								.becomeRoot(
										(CommonTree) adaptor.create(NEW, "NEW"),
										root_1);

						adaptor.addChild(root_1, stream_identifier.nextTree());

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}
				break;
			case 8:
			// /Users/margot/Downloads/MiniJava.g:201:4: identifier
			{
				pushFollow(FOLLOW_identifier_in_primaryExpressionPrefix1293);
				identifier138 = identifier();

				state._fsp--;

				stream_identifier.add(identifier138.getTree());

				// AST REWRITE
				// elements: identifier
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
						adaptor, "rule retval", retval != null ? retval.tree
								: null);

				root_0 = (CommonTree) adaptor.nil();
				// 201:15: -> ^( VAR_REF identifier )
				{
					// /Users/margot/Downloads/MiniJava.g:201:18: ^( VAR_REF
					// identifier )
					{
						CommonTree root_1 = (CommonTree) adaptor.nil();
						root_1 = (CommonTree) adaptor
								.becomeRoot((CommonTree) adaptor.create(
										VAR_REF, "VAR_REF"), root_1);

						adaptor.addChild(root_1, stream_identifier.nextTree());

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "primaryExpressionPrefix"

	public static class identifier_return extends ParserRuleReturnScope {
		CommonTree tree;

		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "identifier"
	// /Users/margot/Downloads/MiniJava.g:206:1: identifier : IDENTIFIER ;
	public final MiniJavaParser.identifier_return identifier()
			throws RecognitionException {
		MiniJavaParser.identifier_return retval = new MiniJavaParser.identifier_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENTIFIER139 = null;

		CommonTree IDENTIFIER139_tree = null;

		try {
			// /Users/margot/Downloads/MiniJava.g:207:2: ( IDENTIFIER )
			// /Users/margot/Downloads/MiniJava.g:207:4: IDENTIFIER
			{
				root_0 = (CommonTree) adaptor.nil();

				IDENTIFIER139 = (Token) match(input, IDENTIFIER,
						FOLLOW_IDENTIFIER_in_identifier1317);
				IDENTIFIER139_tree = (CommonTree) adaptor.create(IDENTIFIER139);
				adaptor.addChild(root_0, IDENTIFIER139_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);

		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "identifier"

	// Delegated rules

	public static final BitSet FOLLOW_mainClass_in_goal343 = new BitSet(
			new long[] { 0x0000000000000202L });
	public static final BitSet FOLLOW_classDeclaration_in_goal346 = new BitSet(
			new long[] { 0x0000000000000202L });
	public static final BitSet FOLLOW_CLASS_in_mainClass369 = new BitSet(
			new long[] { 0x0000000000020000L });
	public static final BitSet FOLLOW_identifier_in_mainClass371 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000020L });
	public static final BitSet FOLLOW_69_in_mainClass373 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000002L });
	public static final BitSet FOLLOW_65_in_mainClass375 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000008L });
	public static final BitSet FOLLOW_67_in_mainClass377 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000010L });
	public static final BitSet FOLLOW_68_in_mainClass379 = new BitSet(
			new long[] { 0x8000000000000000L });
	public static final BitSet FOLLOW_63_in_mainClass381 = new BitSet(
			new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_51_in_mainClass383 = new BitSet(
			new long[] { 0x0200000000000000L });
	public static final BitSet FOLLOW_57_in_mainClass385 = new BitSet(
			new long[] { 0x0400000000000000L });
	public static final BitSet FOLLOW_58_in_mainClass389 = new BitSet(
			new long[] { 0x0800000000000000L });
	public static final BitSet FOLLOW_59_in_mainClass391 = new BitSet(
			new long[] { 0x0000000000020000L });
	public static final BitSet FOLLOW_identifier_in_mainClass393 = new BitSet(
			new long[] { 0x0010000000000000L });
	public static final BitSet FOLLOW_52_in_mainClass395 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000020L });
	public static final BitSet FOLLOW_69_in_mainClass397 = new BitSet(
			new long[] { 0x0002020000060000L, 0x0000000000000020L });
	public static final BitSet FOLLOW_statement_in_mainClass399 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000040L });
	public static final BitSet FOLLOW_70_in_mainClass401 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000040L });
	public static final BitSet FOLLOW_70_in_mainClass403 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_CLASS_in_classDeclaration437 = new BitSet(
			new long[] { 0x0000000000020000L });
	public static final BitSet FOLLOW_identifier_in_classDeclaration439 = new BitSet(
			new long[] { 0x0000000000004000L, 0x0000000000000020L });
	public static final BitSet FOLLOW_extendsClause_in_classDeclaration441 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000020L });
	public static final BitSet FOLLOW_69_in_classDeclaration444 = new BitSet(
			new long[] { 0x3000000000020000L, 0x0000000000000042L });
	public static final BitSet FOLLOW_varDeclarationList_in_classDeclaration448 = new BitSet(
			new long[] { 0x3000000000020000L, 0x0000000000000042L });
	public static final BitSet FOLLOW_methodDeclarationList_in_classDeclaration450 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000040L });
	public static final BitSet FOLLOW_70_in_classDeclaration452 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_EXTENDS_in_extendsClause483 = new BitSet(
			new long[] { 0x0000000000020000L });
	public static final BitSet FOLLOW_identifier_in_extendsClause485 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_varDeclaration_in_varDeclarationList508 = new BitSet(
			new long[] { 0x3000000000020002L });
	public static final BitSet FOLLOW_type_in_varDeclaration529 = new BitSet(
			new long[] { 0x0000000000020000L });
	public static final BitSet FOLLOW_identifier_in_varDeclaration531 = new BitSet(
			new long[] { 0x0080000000000000L });
	public static final BitSet FOLLOW_55_in_varDeclaration533 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_methodDeclaration_in_methodDeclarationList559 = new BitSet(
			new long[] { 0x3000000000020002L, 0x0000000000000002L });
	public static final BitSet FOLLOW_65_in_methodDeclaration580 = new BitSet(
			new long[] { 0x3000000000020000L });
	public static final BitSet FOLLOW_type_in_methodDeclaration583 = new BitSet(
			new long[] { 0x0000000000020000L });
	public static final BitSet FOLLOW_identifier_in_methodDeclaration585 = new BitSet(
			new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_51_in_methodDeclaration587 = new BitSet(
			new long[] { 0x3010000000020000L });
	public static final BitSet FOLLOW_param_in_methodDeclaration590 = new BitSet(
			new long[] { 0x0030000000000000L });
	public static final BitSet FOLLOW_53_in_methodDeclaration593 = new BitSet(
			new long[] { 0x3000000000020000L });
	public static final BitSet FOLLOW_param_in_methodDeclaration595 = new BitSet(
			new long[] { 0x0030000000000000L });
	public static final BitSet FOLLOW_52_in_methodDeclaration602 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000020L });
	public static final BitSet FOLLOW_69_in_methodDeclaration606 = new BitSet(
			new long[] { 0x3002020000060000L, 0x0000000000000024L });
	public static final BitSet FOLLOW_varDeclarationList_in_methodDeclaration608 = new BitSet(
			new long[] { 0x0002020000060000L, 0x0000000000000024L });
	public static final BitSet FOLLOW_statement_in_methodDeclaration611 = new BitSet(
			new long[] { 0x0002020000060000L, 0x0000000000000024L });
	public static final BitSet FOLLOW_66_in_methodDeclaration615 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_expression_in_methodDeclaration617 = new BitSet(
			new long[] { 0x0080000000000000L });
	public static final BitSet FOLLOW_55_in_methodDeclaration619 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000040L });
	public static final BitSet FOLLOW_70_in_methodDeclaration621 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_type_in_param674 = new BitSet(
			new long[] { 0x0000000000020000L });
	public static final BitSet FOLLOW_identifier_in_param676 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_identifier_in_type702 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_61_in_type707 = new BitSet(
			new long[] { 0x0400000000000000L });
	public static final BitSet FOLLOW_58_in_type709 = new BitSet(
			new long[] { 0x0800000000000000L });
	public static final BitSet FOLLOW_59_in_type711 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_61_in_type724 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_60_in_type729 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_orExpr_in_expression740 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_54_in_arrayLengthReference755 = new BitSet(
			new long[] { 0x4000000000000000L });
	public static final BitSet FOLLOW_62_in_arrayLengthReference757 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_expressionList770 = new BitSet(
			new long[] { 0x0020000000000002L });
	public static final BitSet FOLLOW_53_in_expressionList773 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_expression_in_expressionList775 = new BitSet(
			new long[] { 0x0020000000000002L });
	public static final BitSet FOLLOW_69_in_statement800 = new BitSet(
			new long[] { 0x0002020000060000L, 0x0000000000000060L });
	public static final BitSet FOLLOW_statement_in_statement802 = new BitSet(
			new long[] { 0x0002020000060000L, 0x0000000000000060L });
	public static final BitSet FOLLOW_70_in_statement805 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IF_in_statement819 = new BitSet(
			new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_51_in_statement822 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_expression_in_statement825 = new BitSet(
			new long[] { 0x0010000000000000L });
	public static final BitSet FOLLOW_52_in_statement827 = new BitSet(
			new long[] { 0x0002020000060000L, 0x0000000000000020L });
	public static final BitSet FOLLOW_statement_in_statement830 = new BitSet(
			new long[] { 0x0000000000001000L });
	public static final BitSet FOLLOW_ELSE_in_statement832 = new BitSet(
			new long[] { 0x0002020000060000L, 0x0000000000000020L });
	public static final BitSet FOLLOW_statement_in_statement835 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_WHILE_in_statement840 = new BitSet(
			new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_51_in_statement843 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_expression_in_statement846 = new BitSet(
			new long[] { 0x0010000000000000L });
	public static final BitSet FOLLOW_52_in_statement848 = new BitSet(
			new long[] { 0x0002020000060000L, 0x0000000000000020L });
	public static final BitSet FOLLOW_statement_in_statement851 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_SYSOUT_in_statement856 = new BitSet(
			new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_51_in_statement859 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_expression_in_statement862 = new BitSet(
			new long[] { 0x0010000000000000L });
	public static final BitSet FOLLOW_52_in_statement864 = new BitSet(
			new long[] { 0x0080000000000000L });
	public static final BitSet FOLLOW_55_in_statement867 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_identifier_in_statement873 = new BitSet(
			new long[] { 0x0100000000000000L });
	public static final BitSet FOLLOW_56_in_statement875 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_expression_in_statement877 = new BitSet(
			new long[] { 0x0080000000000000L });
	public static final BitSet FOLLOW_55_in_statement879 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_identifier_in_statement898 = new BitSet(
			new long[] { 0x0400000000000000L });
	public static final BitSet FOLLOW_58_in_statement900 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_expression_in_statement902 = new BitSet(
			new long[] { 0x0800000000000000L });
	public static final BitSet FOLLOW_59_in_statement904 = new BitSet(
			new long[] { 0x0100000000000000L });
	public static final BitSet FOLLOW_56_in_statement906 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_expression_in_statement908 = new BitSet(
			new long[] { 0x0080000000000000L });
	public static final BitSet FOLLOW_55_in_statement910 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_andExpr_in_orExpr939 = new BitSet(
			new long[] { 0x0000000000800002L });
	public static final BitSet FOLLOW_LOGIC_OR_in_orExpr943 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_andExpr_in_orExpr946 = new BitSet(
			new long[] { 0x0000000000800002L });
	public static final BitSet FOLLOW_compareExpr_in_andExpr959 = new BitSet(
			new long[] { 0x0000000000400002L });
	public static final BitSet FOLLOW_LOGIC_AND_in_andExpr963 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_compareExpr_in_andExpr966 = new BitSet(
			new long[] { 0x0000000000400002L });
	public static final BitSet FOLLOW_additiveExpr_in_compareExpr982 = new BitSet(
			new long[] { 0x0000000001000002L });
	public static final BitSet FOLLOW_LT_in_compareExpr986 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_additiveExpr_in_compareExpr989 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_multExpr_in_additiveExpr1006 = new BitSet(
			new long[] { 0x0000002100000002L });
	public static final BitSet FOLLOW_PLUS_in_additiveExpr1011 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_MINUS_in_additiveExpr1014 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_multExpr_in_additiveExpr1018 = new BitSet(
			new long[] { 0x0000002100000002L });
	public static final BitSet FOLLOW_unaryExpr_in_multExpr1030 = new BitSet(
			new long[] { 0x0000000200000002L });
	public static final BitSet FOLLOW_MULT_in_multExpr1034 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_unaryExpr_in_multExpr1037 = new BitSet(
			new long[] { 0x0000000200000002L });
	public static final BitSet FOLLOW_UNARY_NOT_in_unaryExpr1053 = new BitSet(
			new long[] { 0x00080C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_primaryExpression_in_unaryExpr1058 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_primaryExpressionPrefix_in_primaryExpression1070 = new BitSet(
			new long[] { 0x0440000000000002L });
	public static final BitSet FOLLOW_58_in_primaryExpression1084 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_expression_in_primaryExpression1088 = new BitSet(
			new long[] { 0x0800000000000000L });
	public static final BitSet FOLLOW_59_in_primaryExpression1090 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_arrayLengthReference_in_primaryExpression1111 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_methodInvocation_in_primaryExpression1128 = new BitSet(
			new long[] { 0x0040000000000002L });
	public static final BitSet FOLLOW_54_in_methodInvocation1172 = new BitSet(
			new long[] { 0x0000000000020000L });
	public static final BitSet FOLLOW_identifier_in_methodInvocation1175 = new BitSet(
			new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_51_in_methodInvocation1177 = new BitSet(
			new long[] { 0x00182C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_expressionList_in_methodInvocation1180 = new BitSet(
			new long[] { 0x0010000000000000L });
	public static final BitSet FOLLOW_52_in_methodInvocation1182 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INTEGER_in_primaryExpressionPrefix1197 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TRUE_in_primaryExpressionPrefix1210 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FALSE_in_primaryExpressionPrefix1224 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_THIS_in_primaryExpressionPrefix1237 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_51_in_primaryExpressionPrefix1242 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_expression_in_primaryExpressionPrefix1245 = new BitSet(
			new long[] { 0x0010000000000000L });
	public static final BitSet FOLLOW_52_in_primaryExpressionPrefix1247 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_64_in_primaryExpressionPrefix1253 = new BitSet(
			new long[] { 0x2000000000000000L });
	public static final BitSet FOLLOW_61_in_primaryExpressionPrefix1255 = new BitSet(
			new long[] { 0x0400000000000000L });
	public static final BitSet FOLLOW_58_in_primaryExpressionPrefix1257 = new BitSet(
			new long[] { 0x00082C0000128000L, 0x0000000000000001L });
	public static final BitSet FOLLOW_expression_in_primaryExpressionPrefix1259 = new BitSet(
			new long[] { 0x0800000000000000L });
	public static final BitSet FOLLOW_59_in_primaryExpressionPrefix1261 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_64_in_primaryExpressionPrefix1274 = new BitSet(
			new long[] { 0x0000000000020000L });
	public static final BitSet FOLLOW_identifier_in_primaryExpressionPrefix1276 = new BitSet(
			new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_51_in_primaryExpressionPrefix1278 = new BitSet(
			new long[] { 0x0010000000000000L });
	public static final BitSet FOLLOW_52_in_primaryExpressionPrefix1280 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_identifier_in_primaryExpressionPrefix1293 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IDENTIFIER_in_identifier1317 = new BitSet(
			new long[] { 0x0000000000000002L });

}