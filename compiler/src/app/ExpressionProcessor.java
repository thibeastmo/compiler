package app;

import expression.Expression;
import expression.Number;
import expression.VariableDeclaration;

import java.util.*;

import expression.*;

public class ExpressionProcessor {
    List<Expression> list;
    public Map<String, Object> values; //symbol table for storing values of variables

    public ExpressionProcessor(List<Expression> list) {
        this.list = list;
        values = new HashMap<>();
    }

    public List<String> getEvaluationResults() {
        List<String> evaluations = new ArrayList<>();

        for (Expression e: list) {
            if (e instanceof VariableDeclaration) {
                VariableDeclaration decl = (VariableDeclaration)e;
                values.put(decl.id, decl.value);
                System.out.println(decl.id + " declard with value " + decl.value);
            }
            else if (e != null) { //e instance of Number, text, Bool, Addition, Subtraction
                String input = e.toString();
                Object result = getEvalResult(e);
                String evaluation = input + " is " + result;
                evaluations.add(evaluation);
            }
        }

        return evaluations;
    }

    private Object getEvalResult(Expression e) {
        Object result = 0;

        if (e instanceof Number) {
            Number num = (Number) e;
            result = num.num;
        }
        else if (e instanceof Text) {
            result = (Text) e;
        }
        else if (e instanceof Bool) {
            result = (Bool) e;
        }
        else if (e instanceof Variable) {
            Variable var = (Variable) e;
            result = values.get(var.id);
        }
        else if (e instanceof Addition) {
            Addition add = (Addition) e;
            int left = (Integer)getEvalResult(add.left);
            int right = (Integer)getEvalResult(add.right);
            result = left + right;
        }
        else {
            Subtraction add = (Subtraction) e;
            int left = (Integer)getEvalResult(add.left);
            int right = (Integer)getEvalResult(add.right);
            result = left - right;
        }

        return result;
    }
}