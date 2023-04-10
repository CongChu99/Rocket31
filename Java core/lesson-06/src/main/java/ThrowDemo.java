public class ThrowDemo {
    public static void main(String[] args){
//        Throw: Chủ động ném ra lỗi
        int age = 10;
        try {
            if (age < 18) {
                throw new IllegalAccessException("Chưa đủ 18 tuổi");
            } else {
                System.out.println("Đã đủ 18 tuổi");
            }
        } catch (IllegalAccessException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
