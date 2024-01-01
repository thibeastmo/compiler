public class Subtraction extends Expression {
    public Expression left;
    public Experession right;
    
    public Subtraction(Experession left, Experession right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " - " + right.toString();
    }
}