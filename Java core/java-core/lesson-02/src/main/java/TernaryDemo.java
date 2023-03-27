public class TernaryDemo {
    public static void main(String[] args) {
        int number = 10;
        if (number % 2 == 0) {
            System.out.println(number + " la so chan ");
        } else {
            System.out.println(number + " la so le");
        }

        String message = (number % 2 == 0) ? number + " la so chan " : number + " la so le";
        System.out.println("message = " + message);
    }
}
