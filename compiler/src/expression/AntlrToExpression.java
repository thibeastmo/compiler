package expression;

import java.util.ArrayList;
import java.util.List;

import antlr.BasicJavaBaseVisitor;
import antlr.BasicJavaParser;
import org.antlr.v4.runtime.Token;

public class AntlrToExpression extends BasicJavaBaseVisitor<Expression> {
    private List<String> vars; //stores all the variables declared in the program so far
    private List<String> semanticErrors;

    public AntlrToExpression(List<String> semanticErrors) {
        vars = new ArrayList<>();
        this.semanticErrors = semanticErrors; //semanticErrors of a parent node
    }

	@Override 
    public Expression visitDeclarating(BasicJavaParser.DeclaratingContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public Expression visitDeclaration(BasicJavaParser.DeclarationContext ctx) {
        //ID() is a method generated to correspond to the token ID in the source grammar.
        Token idToken = ctx.ID().getSymbol(); // same as ctx.getChild(1).getSymbol()
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1; //0 indexed +1
        String id = ctx.getChild(1).getText();

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
            return new VariableDeclaration(id, type, valueText.equals("true"));
        }
    }
    @Override 
    public Expression visitMethodDeclaration(BasicJavaParser.MethodDeclarationContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public Expression visitType(BasicJavaParser.TypeContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public Expression visitMethodDeclarationParameterList(BasicJavaParser.MethodDeclarationParameterListContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public Expression visitMethodCall(BasicJavaParser.MethodCallContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public Expression visitArgumentList(BasicJavaParser.ArgumentListContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public Expression visitStatement(BasicJavaParser.StatementContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public Expression visitIf_statement(BasicJavaParser.If_statementContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public Expression visitWhile_statement(BasicJavaParser.While_statementContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public Expression visitAddition(BasicJavaParser.AdditionContext ctx) {
        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));
        return new Addition(left, right);
    }
	@Override 
    public Expression visitVariable(BasicJavaParser.VariableContext ctx) {
        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1; //0 indexed +1

        String id = ctx.getChild(1).getText();
        if (!vars.contains(id)) {
            semanticErrors.add("Error: variable " + id + " not declared (line: "+line+", column: "+column+")");
        }
        return new Variable(id);
    }
	@Override 
    public Expression visitSubtraction(BasicJavaParser.SubtractionContext ctx) {
        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));
        return new Subtraction(left, right);
    }
	@Override 
    public Expression visitNumber(BasicJavaParser.NumberContext ctx) {
        String numText = ctx.getChild(1).getText();
        int num = Integer.parseInt(numText);
        return new Number(num);
    }
	@Override 
    public Expression visitBool(BasicJavaParser.BoolContext ctx) { 
        String boolText = ctx.getChild(1).getText();
        return new Bool(boolText.equals("true"));
    }
	@Override
    public Expression visitText(BasicJavaParser.TextContext ctx) { 
        return new Text(ctx.getChild(1).getText());
    }
}