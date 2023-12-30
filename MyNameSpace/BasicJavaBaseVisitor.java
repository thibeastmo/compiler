// Generated from BasicJava.g4 by ANTLR 4.13.1
package MyNameSpace;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link BasicJavaVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
@SuppressWarnings("CheckReturnValue")
public class BasicJavaBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements BasicJavaVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitClassDeclaration(BasicJavaParser.ClassDeclarationContext ctx) { return visitChildren(ctx); }
}