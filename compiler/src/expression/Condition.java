package expression;

public class Condition extends Expression {
    public Expression left;
    public Expression right;
    public String symbol;

    public Condition(Expression left) {
        this.left = left;
    }

    public Condition(Expression left, Expression right, String symbol) {
        this.left = left;
        this.right = right;
        this.symbol = symbol;
    }
}
