package Multithreading;

public class TestRnblThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Method run " + i + " Thread name: " + Thread.currentThread().getName() + '\n' + "");
            if (i == 50 && SleepAndJoin.WITH_SLEEP && Thread.currentThread().getName().equals("Thread33")) {
                try {
                    Thread.sleep(3000);
                    System.out.println("thread 33 sleeps");
                } catch (Exception e) {
                    System.out.println("e = " + e);
                }
            }
        }
    }
}
