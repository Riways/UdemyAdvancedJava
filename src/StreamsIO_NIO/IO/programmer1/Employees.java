package StreamsIO_NIO.IO.programmer1;

import java.io.Serializable;

public class Employees implements Serializable {
    String name;
    String surname;
    String department;
//    transient int age;
    transient double salary;
    Car car;

    public Employees(String name, String surname, String department,
      //               int age,
             double salary, Car car) {
        this.name = name;
        this.surname = surname;
        this.department = department;
   //     this.age = age;
        this.salary = salary;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                //", age=" + age +
                ", salary=" + salary +
                ", car=" + car +
                '}';
    }
}
