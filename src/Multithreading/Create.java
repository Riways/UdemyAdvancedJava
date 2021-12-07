package Multithreading;

public class Create {


    public static void main(String[] args) {
        MyThread1 mt1 = new MyThread1();
        new Thread(new MyThread2()).start();
        mt1.start();
        for (int i = 0; i < 1000000; i++) {

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("MAIN");
            }
        }

    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        long fact = 1;
        for (int i = 1; i < 10; i++) {
            System.out.println("MT1 runned");
            if (Thread.currentThread().isInterrupted()) {
                    System.out.println("MT1" );
            }

        }
        Thread.currentThread().isInterrupted();
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("MT2");
            }

        }
    }
}