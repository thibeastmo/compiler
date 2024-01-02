package expression;

import java.util.List;

public class IfDeclaration extends Expression {
    public Condition condition;

    public List<Expression> ifStatements;

    public List<Expression> elseStatement;

    public IfDeclaration(Condition condition, List<Expression> ifStatements, List<Expression> elseStatement) {
        this.condition = condition;
        this.ifStatements = ifStatements;
        this.elseStatement = elseStatement;
    }
}
