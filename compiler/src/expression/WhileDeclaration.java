package expression;

public class WhileDeclaration extends Expression {
    public Condition condition;

    public Expression statement;

    public WhileDeclaration(Condition condition, Expression statement) {
        this.condition = condition;
        this.statement = statement;
    }
}
