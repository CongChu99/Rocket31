import entity.Animal;

public class EncapsulationDemo {
    public static void main(String[] args) {
        Animal dog = new Animal("Shiba");
        System.out.println("dog.getName() = " + dog.getName());

        dog.setName("Milu");
        System.out.println("dog.getName() = " + dog.getName());
    }
}
