import java.time.LocalDateTime;

public class DatatypeDemo {
    public static void main(String[] args) {
        // Cú pháp khai báo biến
        // <Kiểu dữ liệu> <Tên biến> [= <Giá trị khởi tạo>];

        // DATA TYPE: Kiểu dữ liê
        // Kiểu số nguyên: byte (1), short (2), int (4), long(8)
        // Giá trị mặc định = 0
        int age = 20;
        System.out.println("age = " + age);

        // Kiểu số thực: float(4), double (8)
        // Giá trị mặc định = 0
        double score = 9.99;
        System.out.println("score = " + score);

        // Kiểu ký tự: char(2)
        // Giá trị mặc định: '\u0000'
        char c = 'A';
        System.out.println("c = " + c);

        // Kiểu chuỗi : String
        // Giá trị mặc định: null
        String name = "Cong";
        System.out.println("name = " + name);

        // Kiểu đúng / sai: boolean
        // Giá trị mặc định: false
        boolean isRunning = true;
        System.out.println("isRunning = " + isRunning);

        // Kiểu thời gian: LocalDate, LocalTime, LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        // Kiểu enum: Tập hợp hữu hạn các trạng thái
        Gender gender = Gender.MALE;
        System.out.println("gender = " + gender);

        // Kiểu mảng: Array
        // Lưu trữ một danh sách các giá trị cùng loại
        // Lưu ý: chỉ số của mảng bắt đầu từ 0
        int [] scores1 = {1, 2, 3, 4, 5};
        int [] scores2 = new int[]{1, 2, 3, 4, 5};
        System.out.println("scores1[0] = " + scores1[0]);
        int length = scores1.length;
        System.out.println("scores1[length - 1] = " + scores1[length - 1]);
    }

    enum Gender{
        MALE, FEMALE
    }
}
