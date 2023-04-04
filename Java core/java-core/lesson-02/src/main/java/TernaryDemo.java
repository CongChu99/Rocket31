public class TernaryDemo {
    public static void main(String[] args) {
        int number = 11;
        String message = (number % 2 == 0)
                ? number + " là số chẵn"
                : number + " là số lẻ";
        System.out.println(message);
    }
}
