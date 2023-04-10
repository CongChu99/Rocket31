public class FinalDemo {
    public static void main(String[] args) {
        // Final: property, method, class, parameter
        // 1. Không cho phép thay đổi giá trị
        final String name = "Duy";
        // name = "Cường";

        //2. Khoông cho phép lớp con ghi đè (final method)
        //3. Không cho phép kế thừa (final class )
    }

    public static int sum (int a, int b) {
        a = 5;
        return a + b;
    }
}



