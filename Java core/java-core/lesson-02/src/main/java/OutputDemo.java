import java.util.Locale;

public class OutputDemo {
    public static void main(String[] args) {
//        System.out.println();
//        Tự động xuống dòng
        System.out.println("Hello");
        System.out.println("Java");

//        System.out.print();
//        display: inline
        System.out.print("Hello");
        System.out.print("Java");
        System.out.println();

//        System.out.printf("");
//        Print format
//        %s: String
//        %c: character
//        %d: decimal
//        %f: float-point
        int year = 2023;
        int month = 3;
        int day = 31;
        System.out.print(year + " - " + month + " - " + day);
        System.out.println();
        System.out.printf("%d - %d - %d", year, month, day);
//        %5s: Căn lề phải (Thêm dấu cách bên trái)
//        %-5s: Căn lề trái (Thêm dấu cách bên phải)
        System.out.println();
        System.out.printf("%5s", "abc");
        System.out.println();
        System.out.printf("%-5s", "abc");
//        %05d:
        System.out.println();
        System.out.printf("%05d", 11);
//        %5f
        System.out.println();
        System.out.printf("%5.1f", 9.75);
//        %,d
        System.out.println();
        System.out.printf("%,d", 1000000000);
        System.out.println();
        System.out.printf(new Locale("vi"), "%,d", 1000000000);

    }
}
