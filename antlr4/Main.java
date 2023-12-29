public class Main {
    private int attribute;

    public Main(int initialValue) {
        this.attribute = initialValue;
    }

    public int sum(int x) {
        return attribute + x;
    }

    public int minus(int x) {
        return attribute - x;
    }

    public static void main(String[] args) {
        Main instance = new Main(5);
        int sumResult = instance.sum(4);
        System.out.println(sumResult);
        int minusResult = instance.minus(4);
        System.out.println(minusResult);
        boolean works = true;
        System.out.println(works);
        String text = "een tekst";
        System.out.println(text);
    }
}