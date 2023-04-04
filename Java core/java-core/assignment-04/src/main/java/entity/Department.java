package entity;

public class Department {
    int id;
    String name;
    Account[] accounts;

    public Department() {
    }

    public Department(String nameDepartment) {
        this.name = nameDepartment;
        this.id = 0;
    }
}
