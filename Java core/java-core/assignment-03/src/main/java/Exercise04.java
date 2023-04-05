import java.util.Scanner;

public class Exercise04 {
    public static  void question01() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao xau ky tu :");
        String s = scanner.nextLine();
        String[] words = s.split(" ");
        System.out.println("words = " + words.length);
    }

    public static  void question03() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao ten cua ban :");
        String name = scanner.next();
        String first = name.substring(0, 1).toUpperCase();
        String remain = name.substring(1);
        String newName = first + remain;
        System.out.println("newName = " + newName);
    }

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
