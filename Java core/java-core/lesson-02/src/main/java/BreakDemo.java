public class BreakDemo {
    public static void main(String[] args) {
        String[] fruits = {"Cam", "Táo", "Đào"};
        for (String fruit : fruits) {
            System.out.println("Đang tìm kiếm...");
            if (fruit.equals("Táo")) {
                System.out.println("Đã tìm thấy");
                break;
            }
        }
    }
}
