package expression;

public class IfDeclaration extends Expression {
    public String id;

    public Expression statement;

    public Expression elseStatement;

    public IfDeclaration(String id, Expression statement, Expression elseStatement) {
        this.id = id;
        this.statement = statement;
        this.elseStatement = elseStatement;
    }
}
