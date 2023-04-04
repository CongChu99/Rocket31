public class DoWhileDemo {
    public static void main(String[] args) {
        String[] fruits = {"Cam", "Táo", "Đào"};
        int i = 0;
        do {
            System.out.println(fruits[i]);
            i = i + 1;
        } while (i < fruits.length);

        // Do while: chạy ít nhất một lần
    }
}
