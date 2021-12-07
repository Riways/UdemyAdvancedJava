package Lambdas;

import Students.StudentClass;

public class Cmprtr {
    public static void main(String[] args) {
       System.out.println(StudentClass.studClass);
       StudentClass.studClass.sort((student1, student2) -> student2.getId() - student1.getId());
       System.out.println(StudentClass.studClass);

    }
}
