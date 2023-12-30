// Generated from BasicJava.g4 by ANTLR 4.13.1
package MyNameSpace;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BasicJavaParser}.
 */
public interface BasicJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(BasicJavaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(BasicJavaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(BasicJavaParser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(BasicJavaParser.MemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(BasicJavaParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(BasicJavaParser.ConstructorDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link BasicJavaParser#builtInType}.
	 * @param ctx the parse tree
	 */
	void enterBuiltInType(BasicJavaParser.BuiltInTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#builtInType}.
	 * @param ctx the parse tree
	 */
	void exitBuiltInType(BasicJavaParser.BuiltInTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicJavaParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(BasicJavaParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicJavaParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(BasicJavaParser.ParameterListContext ctx);
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
}