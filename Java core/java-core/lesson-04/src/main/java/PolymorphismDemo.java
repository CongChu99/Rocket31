import entity.Champion;
import entity.Yasuo;
import entity.Zed;

public class PolymorphismDemo {
    public static void main(String[] args) {
//        Polymorphism: Đa hình
        Champion yasuo = new Yasuo();
        Champion zed = new Zed();

        performAttack(yasuo);
        performAttack(zed);
    }

    private static void performAttack(Champion champion) {
        champion.attack();
    }
}
