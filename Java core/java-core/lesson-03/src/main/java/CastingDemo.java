public class CastingDemo {
    public static void main(String[] args) {
//        narrowing();

        int a = 1;
        int b = 2;
        System.out.println("a / b = " + (a / b));
        System.out.println("a / b = " + (a / (float) b));
    }

    public static void narrowing() {
//        byte (1) <- short (2) <- int (4) <- long (8)
        long n1 = 8000000000L;
        System.out.println("n1 = " + n1);
        int n2 = (int) n1;
        System.out.println("n2 = " + n2);
    }

    public static void widening() {
//        byte (1) -> short (2) -> int (4) -> long(8)
        int n1 = 10;
        System.out.println("n1 = " + n1);
        long n2 = n1;
        System.out.println("n2 = " + n2);
    }
}
