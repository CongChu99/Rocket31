public class MethodDemo {
    public static void main(String[] args) {
        int c = sum(10, 100);
        System.out.println("c = " + c);

        demo();
    }

    static void demo() {
        System.out.println("demo");
    }

    static int sum(int a, int b) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        return  a + b;
    }
}
