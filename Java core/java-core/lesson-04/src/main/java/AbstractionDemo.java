import entity.Champion;
import entity.Yasuo;
import entity.Zed;

public class AbstractionDemo {
    public static void main(String[] args) {
        // Abstraction: Tính trừu tượng
        // 1. abstract class
        //     - Trừu tượng ko hoàn toàn (<= 100%)
        //     - Dùng: class, method
        // 2. interface
        //     - Trừu tượng hoàn toàn (100%)
        //     - property: public static final
        //     - method: public abstract
        //     - Từ khóa: implements
        //     - Đa kế thừa
        Yasuo yasuo = new Yasuo();
        Zed zed = new Zed();
        yasuo.makeSound();
        zed.makeSound();
        // Champion champion = new Champion();
    }
}
