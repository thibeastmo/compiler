package app;

import expression.Expression;
import expression.Number;
import expression.VariableDeclaration;

import java.io.IOException;
import java.util.*;

import expression.*;

public class ExpressionProcessor {
    List<Expression> list;
    public Map<String, Object> values; //symbol table for storing values of variables
    public List<MethodDeclaration> methods;

    public ExpressionProcessor(List<Expression> list) {
        this.list = list;
        values = new HashMap<>();
        methods = new ArrayList<>();
    }

    public List<String> getEvaluationResults() throws Exception {
        List<String> evaluations = new ArrayList<>();

        for (Expression e: list) {
            if (e instanceof VariableDeclaration) {
                VariableDeclaration decl = (VariableDeclaration)e;
                values.put(decl.id, decl.value);
                System.out.println(decl.id + " declared with value " + decl.value);
            }
            else if (e instanceof MethodDeclaration) {
                methods.add((MethodDeclaration) e);
            }
            else if (e != null) { //e instance of Number, text, Bool, Addition, Subtraction, MethodCall
                String input = e.toString();
                Object result = getEvalResult(e);
                String evaluation = input + " is " + result;
                evaluations.add(evaluation);
            }
        }

        return evaluations;
    }

    private Object getEvalResult(Expression e) throws Exception {
        Object result = 0;

        if (e instanceof Number || e instanceof Text || e instanceof Bool) {
            result = e;
        }
        else if (e instanceof Variable) {
            Variable var = (Variable) e;
            result = values.get(var.id);
        }
        else if (e instanceof Addition) {
            Addition add = (Addition) e;
            int left = getIntegerFromExpression(add.left);
            int right = getIntegerFromExpression(add.right);
            result = left + right;
        }
        else if (e instanceof Subtraction){
            Subtraction add = (Subtraction) e;
            int left = getIntegerFromExpression(add.left);
            int right = getIntegerFromExpression(add.right);
            result = left - right;
        }
        else if (e instanceof MethodCall) { //method call -> here it makes a copy of the already existing variable and puts it in the same list as the original variable --> after that it gets the evalresult
            MethodCall methodCall = (MethodCall) e;
            Optional<MethodDeclaration> optionalMethodDeclaration = methods.stream().filter(m -> m.id.equals(methodCall.methodId)).findFirst();
            if (optionalMethodDeclaration.isEmpty()) {
                System.err.println("Could not find method with id " + methodCall.methodId);
                return null;
            }
            var methodDeclaration = optionalMethodDeclaration.get();
            for (int i = 0; i < ((ArgumentList)methodCall.argumentList).arguments.size(); i++) {
                Variable var = (Variable) ((ArgumentList)methodCall.argumentList).arguments.get(i);
                Object argumentValue = values.get(var.id);
                Variable methodVar = (Variable) ((MethodDeclarationParameterList)methodDeclaration.methodDeclarationParameterList).parameters.get(i);
                values.put(methodVar.id, argumentValue);
            }
            result = getEvalResult(methodDeclaration.statement);
        }
        else if (e instanceof IfDeclaration ifDeclaration) {
            boolean condition = isConditionTrue(ifDeclaration.condition);
            if (condition) {
                result = getEvalResult(ifDeclaration.statement);
            }
            else {
                result = getEvalResult(ifDeclaration.elseStatement);
            }
        }
        else if (e instanceof WhileDeclaration whileDeclaration) {
            boolean condition = isConditionTrue(whileDeclaration.condition);
            while (condition) {
                result = getEvalResult(whileDeclaration.statement);
                condition = isConditionTrue(whileDeclaration.condition);
            }
        }

        return result;
    }

    private Integer getIntegerFromExpression(Expression expression) throws Exception {
        Object evalResultLeft = getEvalResult(expression);
        if (evalResultLeft instanceof Number) {
            return ((Number)evalResultLeft).num;
        }
        return (Integer)evalResultLeft;
    }

    private Boolean isConditionTrue(Condition condition) throws Exception {
        Object leftValue = getEvalResult(condition.left);
        if (condition.right == null) {
            return (Boolean) leftValue;
        }
        if (leftValue == null) {
            throw new IOException("Left expression cannot be null");
        }
        Object rightValue = getEvalResult(condition.right);
        if (rightValue == null) {
            throw new IOException("Left expression cannot be null");
        }
        return switch (condition.symbol) {
            case "<" -> ((Number) leftValue).num < ((Number) rightValue).num;
            case ">" -> ((Number) leftValue).num > ((Number) rightValue).num;
            case ">=" -> ((Number) leftValue).num >= ((Number) rightValue).num;
            case "<=" -> ((Number) leftValue).num <= ((Number) rightValue).num;
            case "==" -> Objects.equals(leftValue, rightValue);
            case "!=" -> !Objects.equals(leftValue, rightValue);
            default -> throw new Exception("");
        };
    }
}