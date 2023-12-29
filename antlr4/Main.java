public class Main {
    private int attribute;

    public Main(int initialValue) {
        this.attribute = initialValue;
    }

    public int sum(int x) {
        return x + attribute;
    }

    public static void main(String[] args) {
        Main instance = new Main(5);
        int result = instance.sum(4);
        System.out.println(result);
    }
}