import java.time.LocalDate;
import java.util.Random;

public class Exercise04 {
    public static void question03() {
        String[] names = {"Mai Anh", "Phuong Thanh", "Hai", "Huy"};
        // [0, length)
        // [0, max)
        Random random = new Random();
        int index = random.nextInt(names.length);
        System.out.printf("names[%d] = %s", index, names[index]);
    }

    public static void question06() {
        Random random = new Random();
        LocalDate maxDate = LocalDate.now();
        int minDay = 0;
        int maxDay = (int) maxDate.toEpochDay();
        int randomDay = minDay + random.nextInt(maxDay - minDay + 1);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        System.out.println("randomDate = " + randomDate);
    }
}
