package expression;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class MethodDeclarationParameterList extends Expression {
    public List<Expression> parameters;
    public MethodDeclarationParameterList(List<Expression> parameters) {
        this.parameters = parameters;
    }
}
