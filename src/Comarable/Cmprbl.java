package Comarable;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cmprbl {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, 12, "Adas", "Economics");
        Employee emp2 = new Employee(211, 32,"GGdasd", "Economics");
        Employee emp3 = new Employee(32, 21,"Bdasd", "Economics");
        Employee emp4 = new Employee(41, 65,"BDdsad", "Economics");
        Employee emp5 = new Employee(123, 19,"CCdas", "Economics");
        ArrayList <Employee> list1 = new ArrayList<>();
        list1.add(emp1);
        list1.add(emp2);
        list1.add(emp3);
        list1.add(emp4);
        list1.add(emp5);
        for (Employee emp : list1){
            System.out.println(emp);
        }
        System.out.println("----------");
        Collections.sort(list1, new EmpIdCmprtr());
        for (Employee emp : list1){
            System.out.println(emp);
        }
        System.out.println("----------");
        Collections.reverse(list1);
        for (Employee emp : list1){
            System.out.println(emp);
        }
        System.out.println("----------");
        Collections.sort(list1, new EmpAgeCmprtr());
        for (Employee emp : list1){
            System.out.println(emp);
        }
        System.out.println("----------");
        Collections.reverse(list1);
        for (Employee emp : list1){
            System.out.println(emp);
        }
    }
}

class Employee implements Comparable<Employee> {
    int id;
    int age;
    String name;
    String course;

    public Employee(int id, int age, String name, String course) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.hashCode() - o.name.hashCode();
    }
}

class EmpIdCmprtr implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.id - o2.id;
    }
}
class EmpAgeCmprtr implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.age - o2.age;
    }
}
