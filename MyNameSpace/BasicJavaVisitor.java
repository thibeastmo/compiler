// Generated from BasicJava.g4 by ANTLR 4.13.1
package MyNameSpace;
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
	 * Visit a parse tree produced by {@link BasicJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(BasicJavaParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#memberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDeclaration(BasicJavaParser.MemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(BasicJavaParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#attributeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeDeclaration(BasicJavaParser.AttributeDeclarationContext ctx);
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
	 * Visit a parse tree produced by {@link BasicJavaParser#builtInType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltInType(BasicJavaParser.BuiltInTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(BasicJavaParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(BasicJavaParser.StatementContext ctx);
}