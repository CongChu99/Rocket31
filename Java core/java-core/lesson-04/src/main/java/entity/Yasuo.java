package entity;

public class Yasuo extends Champion implements Flyable, Runnable {
    @Override
    public void makeSound() {
        System.out.println("Yasuo.........");
    }

    @Override
    public void fly() {
        System.out.println("Yasuo can fly...");
    }

    @Override
    public void run() {
        System.out.println("Yasuo can run...");
    }
}
