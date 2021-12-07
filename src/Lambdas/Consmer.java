package Lambdas;

import Students.Student;
import Students.StudentClass;


import java.util.function.Consumer;

public class Consmer {
    public static void main(String[] args) {
        getGrades(StudentClass.studClass.get(1), student -> System.out.println(student.getGrade()));

        System.out.println("-----");
        StudentClass.studClass.forEach(student -> System.out.println(student.getGrade()));
    }
    static void getGrades(Student s, Consumer<Student> con){

            con.accept(s);

    }
}
