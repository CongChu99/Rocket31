public class BreakDemo {
    public static void main(String[] args) {
        String[] fruits = {"cam", "tao", "dao"};
        for (String fruit:fruits) {
            System.out.println("dang tim kiem...");
            if(fruit.equals("tao")) {
                System.out.println("da tim thay");
                break;
            }
        }
    }
}
