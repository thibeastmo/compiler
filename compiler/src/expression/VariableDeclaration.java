package expression;

public class VariableDeclaration extends Expression {
    public String id;
    public String type;
    public Object value;

    public VariableDeclaration(String id, String type, Object value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }
}