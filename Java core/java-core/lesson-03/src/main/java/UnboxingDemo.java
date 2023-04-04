public class UnboxingDemo {
    public static void main(String[] args) {
        // Unboxing: Object -> Primitive
        Integer a = 100;

        int b = a.intValue();

        // Auto unboxing
        int c = a;

        // Convert String to number
        int n = Integer.parseInt("9");
    }
}
