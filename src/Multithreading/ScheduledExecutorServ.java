package Multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServ {
    static boolean WITH_SLEEP = true;
    static boolean WITH_FIXED_RATE = true;

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorServ =
                Executors.newScheduledThreadPool(1);
        if (WITH_FIXED_RATE) {
            scheduledExecutorServ.scheduleAtFixedRate(new Testor2(9), 1, 2, TimeUnit.SECONDS);
        } else {
            scheduledExecutorServ.scheduleWithFixedDelay(new Testor2(9), 1, 2, TimeUnit.SECONDS);

        }
        if (WITH_SLEEP) {

            Thread.sleep(5000);
        }

        scheduledExecutorServ.shutdown();
        System.out.println("Main ends");
    }

}

class Testor2 implements Runnable {
    int i;

    Testor2(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        for (int j = 0; j < i; j++) {
            System.out.println(j + " THREAD : " + Thread.currentThread().getName());
        }
    }
}