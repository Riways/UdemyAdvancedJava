package Strms;
import Students.*;

import java.util.*;
import java.util.stream.Collectors;

public class Col {
    public static void main(String[] args) {

        Map<Integer, List<Student>> integerStudentHashMap = new HashMap<>();
        integerStudentHashMap =StudentClass.studClass.stream().collect(Collectors.groupingBy(student -> student.getGrade()));

        integerStudentHashMap.forEach((x, a) -> System.out.println( a ));
        for (Integer key : integerStudentHashMap.keySet()) {
            System.out.println(integerStudentHashMap.get(key));
        }

    }
}
