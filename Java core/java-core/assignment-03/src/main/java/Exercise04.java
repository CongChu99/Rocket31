import java.util.Scanner;

public class Exercise04 {
    public static void question01() {
        // 'Nguyen            Van             Nam'.split(...)
        // => ['Nguyen', 'Van', 'Nam'].length
        // Gợi ý: split
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào xâu kí tự:");
        String s = scanner.nextLine();
        String[] words = s.split(" ");
        System.out.println("Số từ là: " + words.length);
    }

    public static void question03() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tên của bạn:");
        String name = scanner.next();
        // khoa -> k + hoa -> K + hoa -> Khoa
        // 0123
        // Khoa -> Khoa
        // Gợi ý: substring(), toUpperCase()
        // [start, end)
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
