package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CahedThreadPoool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();//CachedThreadPool allocates
        //as many threads as you need;
        for (int i = 0; i < 100000; i++) {
            executorService.execute(new Testor3(1000));
        }
        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);
        System.out.println("Main ends");
    }
}


class Testor3 implements Runnable {
    int i;

    Testor3(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        for (int j = 0; j < i; j++) {
            System.out.println(j + " THREAD : " + Thread.currentThread().getName());
        }
    }
}