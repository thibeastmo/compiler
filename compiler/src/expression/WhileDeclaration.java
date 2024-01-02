package expression;

public class WhileDeclaration extends Expression {
    public String id;

    public Expression statement;

    public WhileDeclaration(String id, Expression statement) {
        this.id = id;
        this.statement = statement;
    }
}
