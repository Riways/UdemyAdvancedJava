package Multithreading;

public class SleepAndJoin {
    final static boolean WITH_JOIN = false;
    final static boolean WITH_JOIN_MILLIS = false;
    final static boolean WITH_SLEEP = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread33 = new Thread(new TestRnblThread());

        thread33.setName("Thread33");
        thread33.start();
        if (WITH_JOIN) {
            System.out.println("From here method main will wait for the completion of execution thread33 ");
            thread33.join();
            System.out.println("Continue to execute method main");
            System.out.println(Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getName());

        } else if (WITH_JOIN_MILLIS) {
            System.out.println("From here method main will wait for the completion of execution thread33 ");
            thread33.join(1500);
            System.out.println("Continue to execute method main");
            System.out.println(Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getName());

        }
        for (int i = 0; i < 100; i++) {
            System.out.println("Method main " + i + " Thread name: " + Thread.currentThread().getName());
        }
        System.out.println("End of method main");
    }


}


