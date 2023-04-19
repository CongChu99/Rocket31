package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ERROR = "Giá trị không hợp lệ, vui lòng nhập lại.";

    public static int inputInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.err.println(ERROR);
            }
        }
    }

    public static int inputPositiveInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                int n = Integer.parseInt(input.trim());
                if (n > 0) {
                    return n;
                } else {
                    System.err.println(ERROR);
                }
            } catch (NumberFormatException e) {
                System.err.println(ERROR);
            }
        }
    }

    public static float inputFloat() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Float.parseFloat(input.trim());
            } catch (NumberFormatException e) {
                System.err.println(ERROR);
            }
        }
    }

    public static double inputDouble() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException e) {
                System.err.println(ERROR);
            }
        }
    }

    public static String inputString() {
        return scanner.nextLine()
                .trim()
                .replaceAll("\\s+", " ");
    }

    public static String inputEmail() {
        while (true) {
            String input = inputString();
            if (input.contains("@")) {
                return input;
            } else {
                System.err.println(ERROR);
            }
        }
    }

    public static String inputPassword() {
        while (true) {
            String input = inputString();
            int length = input.length();
            boolean valid = length >= 6 && length <= 12 && hasAnyUppercaseCharacters(input);
            if (valid) {
                return input;
            } else {
                System.err.println(ERROR);
            }
        }
    }

    private static boolean hasAnyUppercaseCharacters(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static String inputFullName() {
        while (true) {
            String input = inputString();
            boolean valid = hasAllAlphabeticCharacters(input);
            if (valid) {
                return input;
            } else {
                System.err.println(ERROR);
            }
        }
    }

    private static boolean hasAllAlphabeticCharacters(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isWhitespace(c)) {
                continue;
            }
            if (!Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }
}
