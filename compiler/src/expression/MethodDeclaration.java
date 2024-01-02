package expression;

public class MethodDeclaration extends Expression {
    public String id;
    public String type;
    public Expression methodDeclarationParameterList;
    public Expression statement;

    public MethodDeclaration(String id, String type, Expression methodDeclarationParameterList, Expression statement) {
        this.id = id;
        this.type = type;
        this.methodDeclarationParameterList = methodDeclarationParameterList;
        this.statement = statement;
    }
}
