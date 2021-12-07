package Reflection;



public class Emloyee{
    public int id;
    public String name;
    public String department;
    private double salary;

    public Emloyee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Emloyee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    private void changeDepartment(String newDepartment){
        department = newDepartment;
        System.out.println("New department: " + department);
    }
    public void increaseSalary(){
        salary *= 2;
    }
}