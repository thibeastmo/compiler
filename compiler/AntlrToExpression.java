import BasicJavaBaseVisitor;
import java.util.List;
impot org.antlr.v4.runtime.Token;

public class AntlrToExpression extends BasicJavaBaseVisitor<Expression> {
    private List<String> vars; //stores all the variables declared in the program so far
    private List<String> semanticErrors;

	@Override 
    public T visitDeclarating(BasicJavaParser.DeclaratingContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public T visitDeclaration(BasicJavaParser.DeclarationContext ctx) {
        //ID() is a method generated to correspond to the token ID in the source grammar.
        Token idToken = ctx.ID().getSymbol(); // same as ctx.getChild(1).getSymbol()
        int line = idToken.getLine();
        int column = idToken.getCharPositionLine() + 1; //0 indexed +1
        String id = ctx.getChild(1);

        //Mainting vars list for semantic error reporting
        if (vars.contains(id)) {
            semanticErrors.add("Error: variable \"" + id + "\" already declared (line: " + line + ", column: " + column + ")");
        }
        else {
            vars.add(id);
        }
        String type = ctx.getChild(0).getText();
        String valueText = ctx.getChild(3).getText();
        if (type.equals("text")) {
            return new VariableDeclaration(id, type, valueText);
        }
        else if (type.equals("int")) {
            int value = Integer.parseInt(valueText);
            return new VariableDeclaration(id, type, value);
        }
        else {
            //boolean
            return new VariableDeclaration(id, type, valueText.equals("true"))
        }
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
        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));
        return new Addition(left, right);
    }
	@Override 
    public T visitVariable(BasicJavaParser.VariableContext ctx) {
        Token idToken = ctx.ID().getSymbol();
        String type = ctx.getChild(0).getText();
        String valueText = ctx.getChild(3).getText();

        String id = ctx.getChild(1).getText();
        if (!vars.contains(id)) {
            semanticErrors.add("Error: variable " + id + " not declared (line: "+line+", column: "+column+")")
        }
        return new Variable(id);
    }
	@Override 
    public T visitSubtraction(BasicJavaParser.SubtractionContext ctx) {
        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));
        return new Subtraction(left, right);
    }
	@Override 
    public T visitNumber(BasicJavaParser.NumberContext ctx) {
        String numText = ctx.getChild(1).getText();
        int num = Integer.parseInt(numText);
        return new Number(num);
    }
	@Override 
    public T visitBool(BasicJavaParser.BoolContext ctx) { 
        String boolText = ctx.getChild(1).getText();
        return boolText.equals("true");
    }
	@Override
    public T visitText(BasicJavaParser.TextContext ctx) { 
        return ctx.getChild(1).getText();
    }
}