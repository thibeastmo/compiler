package expression;

public class IfDeclaration extends Expression {
    public Condition condition;

    public Expression statement;

    public Expression elseStatement;

    public IfDeclaration(Condition condition, Expression statement, Expression elseStatement) {
        this.condition = condition;
        this.statement = statement;
        this.elseStatement = elseStatement;
    }
}
