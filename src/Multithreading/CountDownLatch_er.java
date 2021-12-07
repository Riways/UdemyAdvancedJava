package Multithreading;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatch_er {
    static private void cleaning(CountDownLatch countDownLatch){
        try {
            System.out.println(
                    "Cleaner starts to clean market" + '\n'
            );
            Thread.sleep(2000);
            System.out.println('\n' +"Market clean "+ '\n');
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }
    static private void staffCameToWork(CountDownLatch countDownLatch){
        try {
            Thread.sleep(4000);
            System.out.println("Staff came to work" + '\n');
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }
    static private void opener(CountDownLatch countDownLatch){
        try {
            Thread.sleep(2000);
            System.out.println("Market is opened " + '\n');
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }


    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Customer("Kolya", countDownLatch);
        new Customer("Katya", countDownLatch);
        new Customer("Petya", countDownLatch);
        new Customer("Vasya", countDownLatch);
        new Customer("Nadya", countDownLatch);
        new Customer("Sasha", countDownLatch);
        new Customer("Tanya", countDownLatch);
        new Customer("Olya", countDownLatch);
        new Customer("Nastya", countDownLatch);
        new Customer("Gena", countDownLatch);
        cleaning(countDownLatch);
        staffCameToWork(countDownLatch);
        opener(countDownLatch);
    }
}


class Customer extends Thread {
    String name;
    CountDownLatch cdl;

    public Customer(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " came to market, but it closed");
            cdl.await();
            Random r = new Random();
            Thread.sleep(r.nextInt(7000));
            System.out.println(name + " finished shopping");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.run();
    }
}