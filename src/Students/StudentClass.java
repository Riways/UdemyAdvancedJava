package Students;

import java.util.ArrayList;

public class StudentClass {
    public static ArrayList<Student> studClass = new ArrayList<>();
    static {
        studClass.add(new Student(7,8,"Vanya"));
        studClass.add(new Student(5, 7, "Oleg"));
        studClass.add(new Student(4,8, "Andrei"));
        studClass.add(new Student(10,4,"Anton"));
        studClass.add(new Student(1,6, "Vasya"));
        studClass.add(new Student(6,9,"Kostya"));
        studClass.add(new Student(9, 7,"Ignat"));
        studClass.add(new Student(2, 7, "Petya"));
        studClass.add(new Student(8,9,"Sergei"));
        studClass.add(new Student(3,7,"Kolya"));
    }
}
