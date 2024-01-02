// Generated from BasicJava.g4 by ANTLR 4.9.3

package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BasicJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BasicJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link BasicJavaParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(BasicJavaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#declarating}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarating(BasicJavaParser.DeclaratingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link BasicJavaParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(BasicJavaParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(BasicJavaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(BasicJavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#methodDeclarationParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarationParameterList(BasicJavaParser.MethodDeclarationParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(BasicJavaParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(BasicJavaParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(BasicJavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(BasicJavaParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statement(BasicJavaParser.While_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(BasicJavaParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(BasicJavaParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(BasicJavaParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(BasicJavaParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(BasicJavaParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(BasicJavaParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Text}
	 * labeled alternative in {@link BasicJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(BasicJavaParser.TextContext ctx);
}