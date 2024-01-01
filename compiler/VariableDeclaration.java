public class VariableDeclaration extends Experession {
    public String id;
    public String type;
    public int value;

    public VariableDeclaration(String id, String type, int value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }
}