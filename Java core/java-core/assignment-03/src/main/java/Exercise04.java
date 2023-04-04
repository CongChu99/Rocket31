import java.util.Scanner;

public class Exercise04 {
    public static void question04() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tên của bạn:");
        String name = scanner.nextLine();
        int length = name.length();
        for (int i = 0; i < length; i++) {
            System.out.printf("Ký tự thứ %d là: %C%n", i + 1, name.charAt(i));
        }
    }
}
