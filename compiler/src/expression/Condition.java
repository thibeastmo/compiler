package expression;

public class Condition extends Expression {

    public Bool bool;

    public Condition(Bool bool) {
        this.bool = bool;
    }

    public boolean getBoolean() {
        return bool.bool;
    }
}
