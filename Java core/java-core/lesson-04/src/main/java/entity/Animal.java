package entity;

public class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("Milu")) {
            System.out.println("Không muốn làm Milu");
        } else {
            this.name = name;
        }
    }

    public Animal() {
        System.out.println("Bạn vừa tạo 1 animal");
        System.out.println("Constructor 0 tham số");
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("Bạn vừa tạo 1 animal");
        System.out.println("Constructor 1 tham số");
    }
}
