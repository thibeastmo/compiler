package expression;

import java.util.List;

public class MethodDeclaration extends Expression {
    public String id;
    public String type;
    public Expression methodDeclarationParameterList;
    public List<Expression> statements;

    public MethodDeclaration(String id, String type, Expression methodDeclarationParameterList, List<Expression> statements) {
        this.id = id;
        this.type = type;
        this.methodDeclarationParameterList = methodDeclarationParameterList;
        this.statements = statements;
    }
}
