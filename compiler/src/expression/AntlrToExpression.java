package expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import antlr.BasicJavaBaseVisitor;
import antlr.BasicJavaParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

public class AntlrToExpression extends BasicJavaBaseVisitor<Expression> {
    private Map<String, String> vars; //stores all the variables declared in the program so far
    private List<String> methods; //stores all the methods and variables in methods declared in the program so far -> not recursive
    private List<String> semanticErrors;

    public AntlrToExpression(List<String> semanticErrors) {
        vars = new HashMap<>();
        methods = new ArrayList<>();
        this.semanticErrors = semanticErrors; //semanticErrors of a parent node
    }

	@Override 
    public Expression visitDeclarating(BasicJavaParser.DeclaratingContext ctx) {
        return visitChildren(ctx);
    }
	@Override //visitDeclaration => visitVariableDeclaration
    public Expression visitDeclaration(BasicJavaParser.DeclarationContext ctx) {
        String type = null;
        String valueText = null;
        String id = null;
        boolean reinitialized = false;
        if (ctx.children.get(0) instanceof BasicJavaParser.TypeContext) {
            type = ctx.getChild(0).getText();
            valueText = ctx.getChild(3).getText();
            id = ctx.getChild(1).getText();
        }
        else {
            valueText = ctx.getChild(2).getText();
            id = ctx.getChild(0).getText();
            type = vars.get(id);
            reinitialized = true;
        }
        //ID() is a method generated to correspond to the token ID in the source grammar.
        Token idToken = ctx.ID().getSymbol(); // same as ctx.getChild(1).getSymbol()
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1; //0 indexed +1

        //Maintaining vars list for semantic error reporting
        if (vars.containsKey(id) && !reinitialized) {
            semanticErrors.add("Error: variable \"" + id + "\" already declared (line: " + line + ", column: " + column + ")");
        }
        else if (!vars.containsKey(id)){
            vars.put(id, type);
        }
        if (type.equals("text")) {
            return new VariableDeclaration(id, type, valueText, reinitialized);
        }
        else if (type.equals("int")) {
            final int calculationPart = reinitialized ? 2 : 3;
            Object value = new Number(0);
            //expression can either be addition or subtraction or integer
            ParseTree child = ctx.children.get(calculationPart);
            if (child instanceof BasicJavaParser.NumberContext) {
                value = new Number(Integer.parseInt(valueText));
            }
            else if (child instanceof BasicJavaParser.MethodCallContext) {
                value = visitMethodCall((BasicJavaParser.MethodCallContext) child); //TODO: create this for string and boolean
            }
            else {
                if (child instanceof BasicJavaParser.AdditionContext) {
                    value = visitAddition((BasicJavaParser.AdditionContext)child);
                }
                else {
                    value = visitSubtraction((BasicJavaParser.SubtractionContext)child);
                }
            }
            return new VariableDeclaration(id, type, value, reinitialized);
        }
        else {
            //boolean
            return new VariableDeclaration(id, type, valueText.equals("true"), reinitialized);
        }
    }
    @Override 
    public Expression visitMethodDeclaration(BasicJavaParser.MethodDeclarationContext ctx) {
        Token idToken = ctx.ID().getSymbol(); // same as ctx.getChild(1).getSymbol()
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1; //0 indexed +1
        String id = ctx.getChild(2).getText();
        //Maintaining methods list for semantic error reporting
        if (methods.contains(id)) {
            semanticErrors.add("Error: method \"" + id + "\" already declared (line: " + line + ", column: " + column + ")");
        }
        else {
            methods.add(id);
        }
        String type = ctx.getChild(1).getText();
        Expression methodDeclarationParameterListExpression = visitMethodDeclarationParameterList((BasicJavaParser.MethodDeclarationParameterListContext) ctx.getChild(4));
        //add variables in method before statement gets initialized
        for (Expression methodDeclarationParameterListExpressionItem : ((MethodDeclarationParameterList)methodDeclarationParameterListExpression).parameters) {
            String parameterId = methodDeclarationParameterListExpressionItem.toString();
            if (vars.containsKey(parameterId)) {
                semanticErrors.add("Error: variable \"" + id + "\" already declared (line: " + line + ", column: " + column + ")");
            }
            else {
                vars.put(parameterId, type);
            }
        }

        List<Expression> statements = new ArrayList<>();
        //TODO; 7 moet aangepast worden afhankelijk van aantal parameters
        int i = 7;
        for (; i < ctx.getChildCount() - 1; i++) {
            if (ctx.children.get(i) instanceof BasicJavaParser.StatementContext statementContext) {
                statements.add(visitStatement(statementContext));
            }
        }

        return new MethodDeclaration(id, type, methodDeclarationParameterListExpression, statements);
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
            if (child instanceof BasicJavaParser.TypeContext) {
                parameters.add(new Variable(ctx.children.get(i+1).getText()));
            }
        }
        return new MethodDeclarationParameterList(parameters);
    }
	@Override 
    public Expression visitMethodCall(BasicJavaParser.MethodCallContext ctx) {
        Expression argumentListExpression = visitArgumentList((BasicJavaParser.ArgumentListContext) ctx.children.get(2));
        String methodId = ctx.getChild(0).getText();
        return new MethodCall(methodId, argumentListExpression);
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
        return visit(ctx.children.get(0));
    }
	@Override 
    public Expression visitIf_statement(BasicJavaParser.If_statementContext ctx) {
        Condition conditionChild = (Condition) visitCondition(ctx.condition());

        BasicJavaParser.StatementContext statementContext = (BasicJavaParser.StatementContext) ctx.children.get(5);
        List<Expression> ifStatements = new ArrayList<>();
        List<Expression> elseStatements = new ArrayList<>();
        boolean firstOneFound = false;
        boolean beginElseStatements = false;
        for (int i = 5; i < ctx.getChildCount() - 1; i++) {
            if (ctx.children.get(i) instanceof BasicJavaParser.StatementContext) {
                if (!firstOneFound) {
                    firstOneFound = true;
                    elseStatements.add(visitStatement((BasicJavaParser.StatementContext) ctx.children.get(i)));
                }
                else if (beginElseStatements) {
                    elseStatements.add(visitStatement((BasicJavaParser.StatementContext) ctx.children.get(i)));
                    break;
                }
            }
            else if (firstOneFound) {
                beginElseStatements = true;
            }
        }
        return new IfDeclaration(conditionChild, ifStatements, elseStatements);
    }
	@Override
    public Expression visitWhile_statement(BasicJavaParser.While_statementContext ctx) {
        Condition conditionChild = (Condition) visitCondition(ctx.condition());

        List<Expression> statements = new ArrayList<>();
        for (int i = 5; i < ctx.getChildCount() - 1; i++) {
            BasicJavaParser.StatementContext statementContext = (BasicJavaParser.StatementContext) ctx.children.get(i);
            statements.add(visitStatement(statementContext));
        }
        return new WhileDeclaration(conditionChild, statements);
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
        if (!vars.containsKey(id)) {
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
    @Override
    public Expression visitCondition(BasicJavaParser.ConditionContext ctx) {
        Expression left = visit(ctx.getChild(0));
        if (ctx.getChildCount() > 2) {
            Expression right = visit(ctx.getChild(2));
            String symbol = ctx.getChild(1).getText();
            return new Condition(left, right, symbol);
        }
        return new Condition(left);
    }
}