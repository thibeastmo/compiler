public class Input {
    private int attribute;

    public Input(int initialValue) {
        this.attribute = initialValue;
    }

    public int sum(int x) {
        return x + attribute;
    }

    public static void main(String[] args) {
        Input instance = new Input(5);
        int result = instance.sum(4);
        System.out.println(result);
    }
}