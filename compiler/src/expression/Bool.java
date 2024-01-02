package expression;

public class Bool extends Expression {
    public boolean bool;

    public Bool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toString() {
        return String.valueOf(bool);
    }
}