public class Student {

    private int id;
    private String name;

    private static int count = 0;
    public static String college;

    public Student(String name) {
        count += 1;
        id = count;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

