public class AntlrToProgram extends BasicJavaBaseVisitor<Program> {
	@Override
    public T visitProgram(BasicJavaParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }
}