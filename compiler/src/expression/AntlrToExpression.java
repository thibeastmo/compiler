package expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import antlr.BasicJavaBaseVisitor;
import antlr.BasicJavaParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

public class AntlrToExpression extends BasicJavaBaseVisitor<Expression> {
    private List<String> vars; //stores all the variables declared in the program so far
    private List<String> methods; //stores all the methods declared in the program so far
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

        //Maintaining vars list for semantic error reporting
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
            final int calculationPart = 3;
            int value = 0;
            //expression can either be addition or subtraction or integer
            ParseTree child = ctx.children.get(calculationPart);
            if (child instanceof BasicJavaParser.NumberContext) {
                value = Integer.parseInt(valueText);
            }
            else if (child instanceof BasicJavaParser.MethodCallContext) {
                return visitMethodCall((BasicJavaParser.MethodCallContext) child); //TODO: create this for string and boolean
            }
            else {
                if (child instanceof BasicJavaParser.AdditionContext) {
                    return visitAddition((BasicJavaParser.AdditionContext)child);
                }
                return visitSubtraction((BasicJavaParser.SubtractionContext)child);
            }
            return new VariableDeclaration(id, type, value);
        }
        else {
            //boolean
            return new VariableDeclaration(id, type, valueText.equals("true"));
        }
    }
    @Override 
    public Expression visitMethodDeclaration(BasicJavaParser.MethodDeclarationContext ctx) {
        Token idToken = ctx.ID().getSymbol(); // same as ctx.getChild(1).getSymbol()
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1; //0 indexed +1
        String id = ctx.getChild(1).getText();
        //Maintaining methods list for semantic error reporting
        if (methods.contains(id)) {
            semanticErrors.add("Error: method \"" + id + "\" already declared (line: " + line + ", column: " + column + ")");
        }
        else {
            methods.add(id);
        }
        String type = ctx.getChild(0).getText();
        Expression methodDeclarationParameterListExpression = visitMethodDeclarationParameterList((BasicJavaParser.MethodDeclarationParameterListContext) ctx.getChild(3));
        Expression statement = visitStatement((BasicJavaParser.StatementContext) ctx.getChild(7));

        return new MethodDeclaration(id, type, methodDeclarationParameterListExpression, statement);
    }
	@Override 
    public Expression visitType(BasicJavaParser.TypeContext ctx) {
        return visitChildren(ctx);
    }
	@Override 
    public Expression visitMethodDeclarationParameterList(BasicJavaParser.MethodDeclarationParameterListContext ctx) {
        List<Expression> parameters = new ArrayList<>();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.children.get(i);
            if (child instanceof BasicJavaParser.VariableContext) {
                parameters.add(visitVariable((BasicJavaParser.VariableContext) child));
            }
        }
        return new MethodDeclarationParameterList(parameters);
    }
	@Override 
    public Expression visitMethodCall(BasicJavaParser.MethodCallContext ctx) {
        Expression argumentListExpression = visitArgumentList((BasicJavaParser.ArgumentListContext) ctx.children.get(2));
        return new MethodCall(argumentListExpression);
    }
	@Override 
    public Expression visitArgumentList(BasicJavaParser.ArgumentListContext ctx) {
        List<Expression> arguments = new ArrayList<>();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.children.get(i);
            if (child instanceof BasicJavaParser.VariableContext) {
                arguments.add(visitVariable((BasicJavaParser.VariableContext) child));
            }
        }
        return new ArgumentList(arguments);
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

        String id = ctx.getChild(0).getText();
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
        String numText = ctx.getChild(0).getText();
        int num = Integer.parseInt(numText);
        return new Number(num);
    }
	@Override 
    public Expression visitBool(BasicJavaParser.BoolContext ctx) { 
        String boolText = ctx.getChild(0).getText();
        return new Bool(boolText.equals("true"));
    }
	@Override
    public Expression visitText(BasicJavaParser.TextContext ctx) { 
        return new Text(ctx.getChild(0).getText());
    }
}