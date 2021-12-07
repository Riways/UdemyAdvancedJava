package Gnrcs.Game;

public class Test {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Ivan", 12);
        Schoolar schoolar2 = new Schoolar("Ignat", 13);

        Student student1 = new Student("Albert", 19);
        Student student2 = new Student("Andrey", 18);

        Employee employee1 = new Employee("Michail", 33);
        Employee employee2 = new Employee("Magomed", 43);

        Team <Schoolar> schoolarTeam = new Team("Drakoni");
        Team <Employee> employeeTeam = new Team("Nosorogi");
        Team <Student> studentTeam = new Team("Buldogi");

        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);

        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        Team <Schoolar> schoolarTeam2 = new Team<>("Maroderi");
        Schoolar schoolar3 = new Schoolar("Kostya", 11);
        Schoolar schoolar4 = new Schoolar("Korytko", 10);
        schoolarTeam2.addNewParticipant(schoolar3);
        schoolarTeam2.addNewParticipant(schoolar4);
        schoolarTeam.playWith(schoolarTeam2);

    }
}
