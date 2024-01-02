package expression;

public class MethodCall extends Expression {
    public String methodId;
    public ArgumentList argumentList;

    public MethodCall(String methodId, ArgumentList argumentList) {
        this.methodId = methodId;
        this.argumentList = argumentList;
    }
}
