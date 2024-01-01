public class AntlrToExpression extends BasicJavaBaseVisitor<Expression> {
	@Override 
    public T visitDeclarating(BasicJavaParser.DeclaratingContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public T visitDeclaration(BasicJavaParser.DeclarationContext ctx) {
        return visitChildren(ctx);
    }
    @Override 
    public T visitMethodDeclaration(BasicJavaParser.MethodDeclarationContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public T visitType(BasicJavaParser.TypeContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public T visitMethodDeclarationParameterList(BasicJavaParser.MethodDeclarationParameterListContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public T visitMethodCall(BasicJavaParser.MethodCallContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public T visitArgumentList(BasicJavaParser.ArgumentListContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public T visitStatement(BasicJavaParser.StatementContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public T visitIf_statement(BasicJavaParser.If_statementContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public T visitWhile_statement(BasicJavaParser.While_statementContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public T visitAddition(BasicJavaParser.AdditionContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public T visitVariable(BasicJavaParser.VariableContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public T visitSubtraction(BasicJavaParser.SubtractionContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public T visitNumber(BasicJavaParser.NumberContext ctx) {
        String numText = ctx.getChild(0).getText();
        int num = Integer.parseInt(numText);
        return new Number(num);
    }
	@Override 
    public T visitBool(BasicJavaParser.BoolContext ctx) { 
        String boolText = ctx.getChild(0).getText();
        return boolText.equals("true") ? true : false;
    }
	@Override
    public T visitText(BasicJavaParser.TextContext ctx) { 
        return ctx.getChild(0).getText();
    }
}