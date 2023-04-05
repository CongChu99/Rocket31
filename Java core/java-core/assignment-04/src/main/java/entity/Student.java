package entity;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private String hometown;
    private double score;

    public Student() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao name:");
        name = scanner.nextLine();
        System.out.println("Nhap vap hometown:");
        hometown = scanner.nextLine();
        score = 0.0;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void plusScore(double value) {
        this.score += + value;
    }

    public void showInfo() {
        String rank;
        if (score < 4.0) {
            rank = "Yeu";
        } else if (score < 6.0) {
            rank = "TB";
        } else if (score < 8.0) {
            rank = "Kha";
        } else {
            rank = "Gioi";
        }
        System.out.printf("%s: %s%n", name, rank);
    }
}
