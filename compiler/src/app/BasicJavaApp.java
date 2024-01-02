package app;

import antlr.BasicJavaLexer;
import antlr.BasicJavaParser;
import expression.AntlrToProgram;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class BasicJavaApp {
    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            args = new String[1];
            args[0] = "./src/app/tests/test1.txt"; //to test faster
        }
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

        return parser;
    }
}