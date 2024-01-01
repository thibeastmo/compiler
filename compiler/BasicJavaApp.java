import BasicJavaParser;
import BasicJavaLexer;
import org.antlr4.runtime.CharStream;
import org.antlr4.runtime.CharStreams;
import org.antlr4.runtime.CommonTokenStream;

public class BasicJavaApp {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.print("Usage: file name");
        }
        else {
            String fileName = args[0];
            BasicJavaParser parser = getParser(fileName);

            //tell ANTLR to build parse tree
            //parse from the start symbol 'prog'
            ParseTree antlrAST = parser.prog();
            //Create a visitor for converting the parse tree into Program/Expression objects
            AntlrToProgram progVisitor = new AntlrToProgram();
            Program prog = progVisitor.visit(antlrAST);

            if (progVisitor.semanticErrors.isEmpty()) {
                ExpressionProcessor ep = new ExpressionProcessor(prog.expressions);
                for (String evaluation : ep.getEvaluationResults()) {
                    System.out.println(evaluation);
                }
            }
            else {
                for (String err : progVisitor.semanticErrors) {
                    System.out.println(err);
                }
            }
        }
    }

    /*
    * Here the types of parser and lexer are specific to the grammar name BasicJava.g4
    */
    private static BasicJavaParser getParser(String fileName) {
        BasicJavaParser parser = null;

        try {
            CharStream input = CharStreams.fromFileName(fileName);
            BasicJavaLexer lexer = new BasicJavaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new BasicJavaParser(tokens);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return;
    }
}