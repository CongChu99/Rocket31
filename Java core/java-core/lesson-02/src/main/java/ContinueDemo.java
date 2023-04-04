public class ContinueDemo {
    public static void main(String[] args) {
        String[] fruits = {"Cam", "Táo", "Đào"};
        for (String fruit : fruits) {
            System.out.println("Đang tìm kiếm...");
            if (!fruit.equals("Táo")) {
                continue;
            }
            System.out.println("Đã tìm thấy");
        }
    }
}
