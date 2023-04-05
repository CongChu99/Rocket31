package entity;

public class Zed extends Champion implements Runnable{
    @Override
    public void makeSound() {
        System.out.println("Zed..........");
    }

    @Override
    public void run() {
        System.out.println("Zed can run...");
    }
}
