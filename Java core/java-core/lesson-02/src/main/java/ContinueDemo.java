public class ContinueDemo {
    public static void main(String[] args) {
        String[] fruits = {"cam", "tao", "dao"};
        for (String fruit:fruits) {
            System.out.println("dang tim kiem...");
            if(!fruit.equals("tao")) {
                continue;
            }
            System.out.println("Da tim thay");
        }
    }
}
