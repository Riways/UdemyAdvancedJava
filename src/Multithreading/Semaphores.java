package Multithreading;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Semaphores {
    static boolean WITHOUT_START_IN_CONSTRUCTOR = false; //Starting thread from constructor

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);
        new Person("Katya", sem);
        new Person("Kolya", sem);
        new Person("Petya", sem);
        new Person("Vasya", sem);
        new Person("Nadya", sem);
        new Person("Sasha", sem);
        new Person("Tanya", sem);
        new Person("Olya", sem);
        new Person("Nastya", sem);
        new Person("Gena", sem);
    }

}

class Person extends Thread{
    String name;
    Semaphore semaphore;
    Person(String name, Semaphore semaphore){
        this.name = name;
        this.semaphore = semaphore;
        if(!Semaphores.WITHOUT_START_IN_CONSTRUCTOR){
            this.start();
        }

    }


    @Override
    public void run() {
        try {
            System.out.println(name + " tries to make a call ");
            semaphore.acquire();
            System.out.println(name + " calls");
            Random r = new Random();
            int rand = r.nextInt(10000);
            Thread.sleep(rand);
            System.out.println("Call time: " + rand/1000 + " seconds" + '\n');
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(name + " finished call");
            semaphore.release();
        }
    }
}
