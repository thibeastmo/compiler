import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create an input stream from a file or string
        CharStream input = CharStreams.fromFileName("Input.java");

        // Create a lexer
        BasicJavaLexer lexer = new BasicJavaLexer(input);

        // Create a token stream from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create a parser
        BasicJavaParser parser = new BasicJavaParser(tokens);

        // Parse the input and get the parse tree
        ParseTree tree = parser.compilationUnit();

        // Optionally, use a listener or visitor to process the parse tree
        MyListener listener = new MyListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
    }
}