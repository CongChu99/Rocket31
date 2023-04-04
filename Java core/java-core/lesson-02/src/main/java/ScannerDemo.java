import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào tên của bạn:");
        String name = scanner.next();
        System.out.println("name = " + name);

        System.out.println("Nhập vào tuổi của bạn");
        int age = scanner.nextInt();
        System.out.println("age = " + age);

        // ăn bỏ kí tự \r\n
        scanner.nextLine();

        System.out.println("Nhập vào địa chỉ của bạn:");
        String address = scanner.nextLine();
        System.out.println("address = " + address);

        // scanner.has...: Kiểm tra đầu vào
        // scanner.hasNextInt();
    }
}
