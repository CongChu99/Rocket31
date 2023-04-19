package utils;

import java.io.Closeable;
import java.util.Scanner;

public class ScannerUtils implements Closeable {
    private final Scanner scanner = new Scanner(System.in);

    public int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nhập lại.");
            }
        }
    }

    public int inputPositiveInt() {
        while (true) {
            try {
                int n = Integer.parseInt(scanner.nextLine());
                if (n > 0) return n;
                System.out.println("Nhập lại.");
            } catch (NumberFormatException e) {
                System.out.println("Nhập lại.");
            }
        }
    }

    public String inputString() {
        return scanner.nextLine()
                .trim()
                .replaceAll("\\s+", " ");
    }

    @Override
    public void close() {
        scanner.close();
    }
}
