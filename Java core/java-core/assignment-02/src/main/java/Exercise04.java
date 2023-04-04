import java.util.Random;

public class Exercise04 {
    public static void question03() {
        String[] names = {"Mai Anh", "Phuong Thanh", "Hai", "Huy"};
//        [0, length)
//        [0, max)
        Random random = new Random();
        int index = random.nextInt(names.length);
        System.out.printf("names[%d] = %s", index, names[index]);
    }
}
