import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        Department department1 = new Department();
        department1.id = 1;
        department1.name = "Giám đốc";
        System.out.println("department1.id = " + department1.id);
        System.out.println("department1.name = " + department1.name);

        Department department2 = new Department();
        department2.id = 2;
        department2.name = "Bảo vệ";

        Department department3 = new Department();
        department3.id = 3;
        department3.name = "Kinh doanh";

        Position position1 = new Position();
        position1.id = 1;
        position1.name = Position.PositionName.DEVELOPER;
        System.out.println("position1.id = " + position1.id);
        System.out.println("position1.name = " + position1.name);

        Account account1 = new Account();
        account1.id = 1;
        account1.email = "khoa.nv@gmail.com";
        account1.username = "khoa.nv";
        account1.fullName = "Nguyễn Văn Khoa";
        account1.department = department1;
        account1.position = position1;
        account1.createdDate = LocalDate.of(2020, 9, 30);
        System.out.println("account1.department.name = " + account1.department.name);
        System.out.println("account1.position.name = " + account1.position.name);
    }
}
