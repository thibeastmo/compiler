package expression;

public class VariableDeclaration extends Expression {
    public String id;
    public String type;
    public Object value;
    public boolean reinitialized;

    public VariableDeclaration(String id, String type, Object value, boolean reinitialized) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.reinitialized = reinitialized;
    }
}