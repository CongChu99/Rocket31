public class OperatorDemo {
    public static void main(String[] args) {
        // Arithmetic operators
        int a = 10;
        int b = 10;
        // +, -, *, /, %
        a = a + 10;
        System.out.println(a);
        // +=, -=, *=, /=, %=
        a += 10;
        System.out.println(a);
        // ++, --
        a++;
        System.out.println(a);
        ++a;
        System.out.println(a);

        b = b + ++a;
        // a = a + 1;
        // b = b + a;
        System.out.println("b = " + b);
        System.out.println("a = " + a);

        b = b + a++;
        // b = b + a;
        // a = a + 1;
        System.out.println("b = " + b);
        System.out.println("a = " + a);

        // Relational operators
        // ==, >, >=, <, <=, !=

        // Logic operators
        // &&, ||, !
    }
}
