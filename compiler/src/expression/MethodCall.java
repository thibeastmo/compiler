package expression;

public class MethodCall extends Expression {
    public String methodId;
    public Expression argumentList;

    public MethodCall(String methodId, Expression argumentList) {
        this.methodId = methodId;
        this.argumentList = argumentList;
    }
}
