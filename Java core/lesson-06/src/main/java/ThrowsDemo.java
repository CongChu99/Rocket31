public class ThrowsDemo {
    public static void main(String[] args) {
        // Throws: Lan truyền exception
        try {
            checkAge(10);
        } catch (InvalidAgeException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Chưa đủ 18 tuổi");
        } else {
            System.out.println("Đã đủ 18 tuổi");
        }
    }
}
