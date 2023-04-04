import java.time.LocalDate;
import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        // [-2^31, 2^31-1]
        int n1 = random.nextInt();
        System.out.println("n1 = " + n1);
        // [0, max)
        int n2 = random.nextInt(100);
        System.out.println("n2 = " + n2);
        // [min, max]
        // min + [0, max - min + 1)
        // VD: [50, 100]
        int n3 = 50 + random.nextInt(100 - 50 + 1);
        System.out.println("n3 = " + n3);

        // VD: Random date
        // 0 -------- 1000 -------- 2000 --------> date (LocalDate)
        // 0 -------- 2000 -------- 4000 --------> day (int)
        // => random day: 3000 (int)
        // => random date: 1500 (LocalDate)
        LocalDate minDate = LocalDate.of(2003, 9, 23);
        LocalDate maxDate = LocalDate.now();
        int minDay = (int) minDate.toEpochDay();
        int maxDay = (int) maxDate.toEpochDay();
        int randomDay = minDay + random.nextInt(maxDay - minDay + 1);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        System.out.println("randomDate = " + randomDate);
    }
}
