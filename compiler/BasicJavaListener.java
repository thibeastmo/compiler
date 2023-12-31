// Generated from BasicJava.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BasicJavaParser}.
 */
public interface BasicJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(BasicJavaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(BasicJavaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(BasicJavaParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(BasicJavaParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#attributeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAttributeDeclaration(BasicJavaParser.AttributeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#attributeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAttributeDeclaration(BasicJavaParser.AttributeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(BasicJavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(BasicJavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(BasicJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(BasicJavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#methodDeclarationParameterList}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarationParameterList(BasicJavaParser.MethodDeclarationParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#methodDeclarationParameterList}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarationParameterList(BasicJavaParser.MethodDeclarationParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(BasicJavaParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(BasicJavaParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(BasicJavaParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(BasicJavaParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(BasicJavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(BasicJavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(BasicJavaParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(BasicJavaParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(BasicJavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(BasicJavaParser.ExpressionContext ctx);
}