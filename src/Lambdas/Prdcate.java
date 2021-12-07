package Lambdas;

import Students.*;

import java.util.ArrayList;
import java.util.function.Predicate;


public class Prdcate {
    public static void main(String[] args) {
        studInfo(StudentClass.studClass, s -> s.getGrade() > 8);
        Predicate<Student> pr1 = student -> student.getGrade() > 7;
        Predicate<Student> pr2 = student -> student.getGrade() < 7;
        System.out.println("------------");
        studInfo(StudentClass.studClass, pr1);
        System.out.println("------------");
        studInfo(StudentClass.studClass, pr1.or(pr2));
    }
    static void studInfo(ArrayList<Student> arL, Predicate<Student> pr){
        for(Student s : arL){
            if (pr.test(s)){
                System.out.println(s);
            }
        }
    }
}
