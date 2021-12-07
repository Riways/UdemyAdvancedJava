package RegEx;

import java.util.EnumSet;

public class PrintfEx {
    static void employeeInfo(Employee emp){
        System.out.printf("%03d \t %-12s \t %-12s \t %,.1f \n"
        , emp.id , emp.name, emp.surname, emp.salary*(1+ emp.bonusPct));
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(1,"Vasya", "Petrov", 300, 0.1);
        Employee employee2 = new Employee(2,"Kasya", "Shoshoka", 200, 0.2);
        employeeInfo(employee1);
        employeeInfo(employee2);
    }
}

class Employee{
    int id;
    String name;
    String surname;
    int salary;
    double bonusPct;

    public Employee(int id, String name, String surname, int salary, double bonusPct) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.bonusPct = bonusPct;
    }
}