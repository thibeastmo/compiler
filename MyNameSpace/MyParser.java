public class MyParser {
	private int attribute;

    public MyParser(int initialValue) {
        this.attribute = initialValue;
    }

    public int sum(int x) {
        return x + attribute;
    }

	public void loop() {
		int temp = this.attribute;
		System.out.println("looping:");
		for (int i = 0; i < temp; i++) {
			System.out.println(this.attribute-i);
		}
	}

    public static void main(String[] args) {
        MyParser instance = new MyParser(5);
        int result = instance.sum(4);
        System.out.println(result);
		boolean works = true;
        System.out.println(!works);
        String text = "een tekst";
        System.out.println(text);
		if (works) {
			instance.loop();
		}
    }
}