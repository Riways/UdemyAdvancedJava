package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolAndExecutorService {
    static boolean WITH_SHUTDOWN = true; /*if false, running don't stop
    because thread pool doesn't closed */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Testor(8));
        }
        if(WITH_SHUTDOWN) {
            executorService.shutdown();
        }
        executorService.awaitTermination(5, TimeUnit.SECONDS); // аналог join'a для thread pool
        System.out.println("Main ends");
    }
}

class Testor implements Runnable{
    int i;
    Testor(int i){
        this.i = i;
    }
    @Override
    public void run() {
        for (int j = 0; j < i; j++) {
            System.out.println(j + " THREAD : " + Thread.currentThread().getName());
        }
    }
}