public class StaticDemo {
    public static void main(String[] args) {
        Student studentA = new Student("Hải");
        System.out.println("studentA = " + studentA);
        Student studentB = new Student("Hùng");
        System.out.println("studentB = " + studentB);
        // static: property, method
        //1. Truy cập qua tên class (Không cần khởi tạo đối tượng)
        Student.college = "VTI school";

        // 2. Bộ nhớ chỉ được thu hồi khi chương trình kết thúc
        Student studentC = new Student("Dung");
        System.out.println("studentC = " + studentC);
    }
}
