package expression;

public class Statement extends Expression {
    public Expression content;

    public Statement(Expression content) {
        this.content = content;
    }
}
