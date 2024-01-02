package app;

import expression.Expression;
import expression.Number;
import expression.VariableDeclaration;

import java.io.IOException;
import java.util.*;

import expression.*;

public class ExpressionProcessor {
    public Map<String, Object> values; //symbol table for storing values of variables
    public List<MethodDeclaration> methods;

    public ExpressionProcessor() {
        values = new HashMap<>();
        methods = new ArrayList<>();
    }

    public List<String> getEvaluationResults(List<Expression> list, List<String> evaluations) throws Exception {
        for (Expression e: list) {
            if (e instanceof VariableDeclaration) {
                VariableDeclaration decl = (VariableDeclaration)e;
                Object result = null;
                if (decl.value instanceof Addition addition) {
                    result = getEvalResult(addition, evaluations);
                }
                else if (decl.value instanceof Subtraction subtraction) {
                    result = getEvalResult(subtraction, evaluations);
                }
                else if (decl.value instanceof MethodCall methodCall) {
                    result = getEvalResult(methodCall, evaluations);
                }
                else {
                    result = decl.value;
                }
                values.put(decl.id, result);
                System.out.println(decl.id + " declared with value " + result);
            }
            else if (e instanceof MethodDeclaration) {
                methods.add((MethodDeclaration) e);
            }
            else if (e != null) { //e instance of Number, text, Bool, Addition, Subtraction, MethodCall
                String input = e.toString();
                Object result = getEvalResult(e, evaluations);
                String evaluation = input + " is " + result;
                evaluations.add(evaluation);
            }
        }

        return evaluations;
    }

    private Object getEvalResult(Expression e, List<String> evaluationResults) throws Exception {
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
            int left = getIntegerFromExpression(add.left, evaluationResults);
            int right = getIntegerFromExpression(add.right, evaluationResults);
            result = left + right;
        }
        else if (e instanceof Subtraction){
            Subtraction add = (Subtraction) e;
            int left = getIntegerFromExpression(add.left, evaluationResults);
            int right = getIntegerFromExpression(add.right, evaluationResults);
            result = left - right;
        }
        else if (e instanceof MethodCall methodCall) { //method call -> here it makes a copy of the already existing variable and puts it in the same list as the original variable --> after that it gets the evalresult
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
            for (var statement : methodDeclaration.statements) {
                getEvalResult(statement, evaluationResults);
            }
        }
        else if (e instanceof IfDeclaration ifDeclaration) {
            boolean condition = isConditionTrue(ifDeclaration.condition, evaluationResults);
            if (condition) {
                for (var statement : ifDeclaration.ifStatements) {
                    getEvalResult(statement, evaluationResults);
                }
            }
            else {
                for (var statement : ifDeclaration.elseStatement) {
                    getEvalResult(statement, evaluationResults);
                }
            }
        }
        else if (e instanceof WhileDeclaration whileDeclaration) {
            boolean condition = isConditionTrue(whileDeclaration.condition, evaluationResults);
            while (condition) {
                evaluationResults = getEvaluationResults(whileDeclaration.statements, evaluationResults);
                condition = isConditionTrue(whileDeclaration.condition, evaluationResults);
            }
        }

        return result;
    }

    private Integer getIntegerFromExpression(Expression expression, List<String> evaluationResults) throws Exception {
        Object evalResultLeft = getEvalResult(expression, evaluationResults);
        if (evalResultLeft instanceof Number) {
            return ((Number)evalResultLeft).num;
        }
        return (Integer)evalResultLeft;
    }

    private Boolean isConditionTrue(Condition condition, List<String> evaluationResults) throws Exception {
        Object leftValue = getEvalResult(condition.left, evaluationResults);
        if (condition.right == null) {
            return (Boolean) leftValue;
        }
        if (leftValue == null) {
            throw new IOException("Left expression cannot be null");
        }
        Object rightValue = getEvalResult(condition.right, evaluationResults);
        if (rightValue == null) {
            throw new IOException("Left expression cannot be null");
        }
        if (leftValue instanceof Number || leftValue instanceof Integer) {
            int left = numberOrIntegerToInteger(leftValue);
            int right = numberOrIntegerToInteger(rightValue);
            return switch (condition.symbol) {
                case "<" -> left < right;
                case ">" -> left > right;
                case ">=" -> left >= right;
                case "<=" -> left <= right;
                case "==" -> left == right;
                case "!=" -> left != right;
                default -> throw new Exception("Condition does not exist");
            };
        }

        return switch (condition.symbol) {
            case "==" -> Objects.equals(leftValue, rightValue);
            case "!=" -> !Objects.equals(leftValue, rightValue);
            default -> throw new Exception("Condition does not exist or not suitable for these values");
        };
    }
    private Integer numberOrIntegerToInteger(Object x) {
        if (x instanceof Number y) return y.num;
        return (Integer) x;
    }
}