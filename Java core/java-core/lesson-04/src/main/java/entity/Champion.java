package entity;

public abstract class Champion {
    public int hp;
    public int attack;
    public int amor;

    public abstract void makeSound();

    public void attack() {
        System.out.println("Dame: " + attack);
    }
}
