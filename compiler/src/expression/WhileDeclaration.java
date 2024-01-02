package expression;

import java.util.List;

public class WhileDeclaration extends Expression {
    public Condition condition;

    public List<Expression> statements;

    public WhileDeclaration(Condition condition, List<Expression> statements) {
        this.condition = condition;
        this.statements = statements;
    }
}
