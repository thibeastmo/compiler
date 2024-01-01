import java.util.List;

public class AntlrToProgram extends BasicJavaBaseVisitor<Program> {

    public List<String> semanticErrors; // to be accessed by the main application program
	@Override
    public T visitProgram(BasicJavaParser.ProgramContext ctx) {
        Program prog = new Program();

        semanticErrors = new ArrayList<>();
        AntlrToExpression basicJavaVisitor = new AntlrToExpression(semanticErrors);

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (i == ctx.getChildCount() - 1) {
                /* last child of the start symbol prog is EOF */
                // Do not visit this child and attempt to convert it to an Expression object
            }
            else {
                prog.addExpression(basicJavaVisitor.visit(ctx.getChild(i)));
            }
        }

        return prog;
    }
}