package Lambdas;

import Students.Student;
import Students.StudentClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Function;

public class Functn {
    public static void main(String[] args) {
        LinkedList<Integer> LL = new LinkedList<>();
        printGrades(StudentClass.studClass, LL, student -> student.getGrade());
        System.out.println(LL);
    }

    static void printGrades(ArrayList<Student> arL, LinkedList<Integer> LL, Function<Student, Integer> fun) {
        for (Student student : arL) {

            LL.add(fun.apply(student));
            ;
        }
    }
}
