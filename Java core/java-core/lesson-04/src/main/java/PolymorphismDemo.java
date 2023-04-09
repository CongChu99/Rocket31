import entity.Champion;
import entity.Flyable;
import entity.Yasuo;
import entity.Zed;

public class PolymorphismDemo {
    public static void main(String[] args) {
        // Polymorphism: Đa hình
        // int (4)   -> long (8)
        // Class con -> Class cha
        Champion yasuo = new Yasuo();
        Champion zed = new Zed();

        performAttack(yasuo);
        performAttack(zed);

        Flyable flyable1 = new Yasuo();
        // Flyable flyable2 = new Zed();
        performFly(flyable1);
    }

    public static void performFly(Flyable flyable) {
        flyable.fly();
    }

    public static void performAttack(Champion champion) {
        champion.attack();
    }
}
