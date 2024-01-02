package expression;

import java.util.List;

public class ArgumentList extends Expression{
    public List<Expression> arguments;

    public ArgumentList(List<Expression> arguments) {
        this.arguments = arguments;
    }
}
