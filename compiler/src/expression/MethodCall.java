package expression;

public class MethodCall extends Expression {
    public Expression argumentList;

    public MethodCall(Expression argumentList) {
        this.argumentList = argumentList;
    }
}
