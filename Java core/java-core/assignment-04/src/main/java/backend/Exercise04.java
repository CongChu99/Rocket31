package backend;

import entity.Student;

public class Exercise04 {
    public static void question01() {
        Student student = new Student();
        student.setScore(6.5);
        student.showInfo();
        student.plusScore(3);
        student.showInfo();
    }
}
