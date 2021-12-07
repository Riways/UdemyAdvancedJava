package Lambdas;

import Students.Student;

import java.util.ArrayList;
import java.util.function.Supplier;

public class Splier {
    public static void main(String[] args) {
        ArrayList<Student> studList = new ArrayList<>();
        arLFilling(studList, () -> new Student(1, 5, "Gosha"));
        System.out.println(studList);
    }
    static void arLFilling(ArrayList<Student> arL, Supplier<Student> sup){
        for (int i =0; i < 3 ; i++){
            arL.add(sup.get());
        }
    }
}
