public class SwitchCaseDemo {
    public static void main(String[] args) {
        int month = 3;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Có 30 ngày");
                break;
            case 2:
                System.out.println("Có 28 ngày");
                break;
            default:
                System.out.println("Có 31 ngày");
        }
    }
}
