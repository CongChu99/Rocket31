public class Exercise01 {
    public static void question01() {
        Account account2 = new Account();
        if (account2.department == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là ...");
        }
    }

    public static void question02() {
        Account account2 = new Account();
        if (account2.groups.length == 0 || account2.groups == null) {
            System.out.println("Nhân viên này chưa có group");
        } else if (account2.groups.length == 1 || account2.groups.length == 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (account2.groups.length == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }

    public static void question11() {
        Department department1 = new Department();
        department1.id = 1;
        department1.name = "Sale";

        Department department2 = new Department();
        department2.id = 2;
        department2.name = "Marketing";

        Department[] departments = {department1, department2};

        for (int i = 0; i < departments.length; i++) {
            System.out.println("Thong tin department thu " + (i+1) + " la");
            System.out.println("Id: " + departments[i].id);
            System.out.println("Name: " + departments[i].name);

        }
    }
}
