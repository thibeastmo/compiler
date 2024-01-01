package expression;

public class Text extends Expression {
    String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}