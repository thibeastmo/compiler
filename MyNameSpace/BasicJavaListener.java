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
}