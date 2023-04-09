import entity.Animal;

public class AccessModifierDemo {
    public static void main(String[] args) {
        // public, default, protected, private
        // Áp dụng: class, property, method

        // public: Có thể truy cập từ mọi nơi
        // default: Chỉ truy cập được trong cùng package
        // protected: Chỉ truy cập được trong cùng package
        // hoặc trong lớp con
        // private: Chỉ truy cập được trong class đó
        Animal dog = new Animal("Shiba");
        // System.out.println("dog.name = " + dog.name);
    }
}
