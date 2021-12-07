package enums;

import java.util.Arrays;

enum WeekDays {
    MONDAY("bad"),
    TUESDAY("bad"),
    WEDNESDAY("so-so"),
    THURSDAY("so-so"), FRIDAY("good"), SATURDAY("good"), SUNDAY("good");
    String mood;
    private WeekDays(String mood){ //конструктор enum нельзя вызвать через new, он вызывается только при использовании
                                     //перечислений enum'a;
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }
}enum WeekDays2 {
    MONDAY("bad"),
    TUESDAY("bad"),
    WEDNESDAY("so-so"),
    THURSDAY("so-so"), FRIDAY("good"), SATURDAY("good"), SUNDAY("good");
    String mood;
    private WeekDays2(String mood){ //конструктор enum нельзя вызвать через new, он вызывается только при использовании
                                     //перечислений enum'a;
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }
}

public class EnumEx1 {


    public static void main(String[] args) {
        Today2 today = new Today2(WeekDays2.SATURDAY);
        Today today1 = new Today(WeekDays.SATURDAY);
        System.out.println(today1.weekDay.equals(today.weekDay)); //FALSE
         today.daysInfo();
        Today2 today2 = new Today2(WeekDays2.WEDNESDAY);
        today2.daysInfo();
        WeekDays [] weekDays = WeekDays.values();
        System.out.println(Arrays.toString(weekDays));
    }
}

class Today {
    WeekDays weekDay;

    public Today(WeekDays weekDay) {
        this.weekDay = weekDay;
    }
    void daysInfo(){
        switch (weekDay){
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("Go to work!");
                System.out.println(weekDay.getMood());
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Take a rest");
                System.out.println(weekDay.getMood());
                break;

        }
    }
}class Today2 {
    WeekDays2 weekDay;

    public Today2(WeekDays2 weekDay) {
        this.weekDay = weekDay;
    }
    void daysInfo(){
        switch (weekDay){
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("Go to work!");
                System.out.println(weekDay.getMood());
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Take a rest");
                System.out.println(weekDay.getMood());
                break;

        }
    }
}