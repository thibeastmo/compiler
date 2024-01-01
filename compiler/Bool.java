public class Bool extends Expression {
    boolean bool;

    public Number(boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toString() {
        return bool.toString();
    }
}