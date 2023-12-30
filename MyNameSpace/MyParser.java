import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class MyParser {
    public static void main(String[] args) {
        // Java ‘target’ incl. Visitor:
        CharStream charStream = CharStreams.fromFileName("File.java");
        BasicJavaLexer lexer = new BasicJavaLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BasicJavaParser parser = new BasicJavaParser(tokens);
        var context = parser.classDeclaration();
        System.out.println(context.toStringTree());
    }
}