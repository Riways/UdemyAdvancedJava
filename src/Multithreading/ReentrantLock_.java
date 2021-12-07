package Multithreading;



import java.util.concurrent.locks.Lock;

public class ReentrantLock_ {
    static final boolean WITH_TRYLOCK = true; // change

    public static void main(String[] args) {

        Lock lock = new java.util.concurrent.locks.ReentrantLock();
        Employee emp11= new Employee("Oleg", lock);
        Employee emp12= new Employee("Petya", lock);
        Employee emp13= new Employee("Vasya", lock);
        Employee emp14= new Employee("Kolya", lock);
        Employee emp15= new Employee("Anjela", lock);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Employee emp16= new Employee("Dima", lock);
        Employee emp17= new Employee("Sveta", lock);
        Employee emp18= new Employee("Kasya", lock);
    }
}

class Employee extends Thread{
    String name;
    Lock lock;
    Employee(String name, Lock lock){
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        if(ReentrantLock_.WITH_TRYLOCK){
            if(lock.tryLock()){
                System.out.println(name + " locked ATM");
                try {
                    sleep(3000);
                    System.out.println(name + " finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }else{
                System.out.println(name + " didn't want to wait");
            }
        }else {
            lock.lock();
            System.out.println(name + " locked ATM");
            try {
                sleep(3000);
                System.out.println(name + " finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}

