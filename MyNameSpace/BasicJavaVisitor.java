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
}