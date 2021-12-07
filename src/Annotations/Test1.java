package Annotations;

public class Test1 {

}
class Emloyee{
    String name;
    double salary;

    public Emloyee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    @MyAnnotaion //пример использования собственной аннтоации
    public void increaseSalаry(){
        salary *= 2;
    }

    @Override
    public String toString() {
        return "Emloyee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

@interface MyAnnotaion{ // создание собственной аннотации

}