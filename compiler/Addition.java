public class Addition extends Expression {
    public Expression left;
    public Experession right;
    
    public Addition(Experession left, Experession right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " + " + right.toString();
    }
}