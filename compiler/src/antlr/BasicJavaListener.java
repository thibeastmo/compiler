// Generated from BasicJava.g4 by ANTLR 4.9.3

package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BasicJavaParser}.
 */
public interface BasicJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Program}
	 * labeled alternative in {@link BasicJavaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgram(BasicJavaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link BasicJavaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgram(BasicJavaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#declarating}.
	 * @param ctx the parse tree
	 */
	void enterDeclarating(BasicJavaParser.DeclaratingContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#declarating}.
	 * @param ctx the parse tree
	 */
	void exitDeclarating(BasicJavaParser.DeclaratingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link BasicJavaParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(BasicJavaParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link BasicJavaParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(BasicJavaParser.DeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link BasicJavaParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(BasicJavaParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(BasicJavaParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(BasicJavaParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(BasicJavaParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddition(BasicJavaParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddition(BasicJavaParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(BasicJavaParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(BasicJavaParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(BasicJavaParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(BasicJavaParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(BasicJavaParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(BasicJavaParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBool(BasicJavaParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBool(BasicJavaParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Text}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterText(BasicJavaParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Text}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitText(BasicJavaParser.TextContext ctx);
}