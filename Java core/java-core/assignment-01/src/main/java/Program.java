import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        Department department1 = new Department();
        department1.id = 1;
        department1.name = "Giám đốc";
        System.out.println("department1.name = " + department1.name);

        Department department2 = new Department();
        department2.id = 2;
        department2.name = "Bảo vệ";

        Department department3 = new Department();
        department3.id = 3;
        department3.name = "Kinh doanh";

        Position position1 = new Position();
        position1.id = 1;
        position1.name = PositionName.DEV;

        Account account1 = new Account();
        account1.id = 1;
        account1.userName = "Nam";
        account1.fullName = "Nguyễn Văn Nam";
        account1.email = "name.nv@gmail.com";
        account1.position = position1;
        account1.department = department2;
        account1.createDate = LocalDate.now();
        System.out.println("account1.email = " + account1.email);

        CategoryQuestion category1 = new CategoryQuestion();
        category1.id = 1;
        category1.name = "AAA";
        System.out.println("category1.name = " + category1.name);

        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Nhóm 1";
        group1.account = account1;
        group1.createDate = LocalDate.now();
        System.out.println("group1.account = " + group1.account);

        GroupAccount groupAccount1 = new GroupAccount();
        groupAccount1.account = account1;
        groupAccount1.group = group1;
        groupAccount1.joinDate = LocalDate.now();
        System.out.println("groupAccount1.joinDate = " + groupAccount1.joinDate);

        Exam exam1 = new Exam();
        exam1.id = 1;
        exam1.account = account1;
        exam1.code = "001";
        exam1.category = category1;
        exam1.duration = 12;
        exam1.title = "Python";
        exam1.createDate = LocalDate.now();
        System.out.println("exam1.duration = " + exam1.duration);

        TypeQuestion typeQuestion1 = new TypeQuestion();
        typeQuestion1.id = 1;
        typeQuestion1.name = "Tự luận";
        System.out.println("typeQuestion1.name = " + typeQuestion1.name);

        Question question1 = new Question();
        question1.id = 1;
        question1.content = "noSQL";
        question1.category = category1;
        question1.type = typeQuestion1;
        question1.account = account1;
        question1.createDate = LocalDate.of(2020, 9, 12);
        System.out.println("question1.content = " + question1.content);

        ExamQuestion examQuestion1 = new ExamQuestion();
        examQuestion1.exam = exam1;
        examQuestion1.question = question1;
        System.out.println("examQuestion1.question = " + examQuestion1.question);

        Answer answer1 = new Answer();
        answer1.id = 1;
        answer1.content = "Java Core";
        answer1.question = question1;
        answer1.isCorrect = true;
        System.out.println("answer1.content = " + answer1.content);
    }
}
