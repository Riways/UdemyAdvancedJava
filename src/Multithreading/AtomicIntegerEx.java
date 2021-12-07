package Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEx {
    static boolean WITH_ATOMIC = false; //change

    public static Integer nat = 0;
    public  static AtomicInteger at = new AtomicInteger(0);
    public static void increment(){
        if(WITH_ATOMIC){
            at.addAndGet(5);
        }else{
            nat+=5;
        }


    }

    public static void main(String[] args) throws InterruptedException {
        Thread a =new ThreadEx();
        Thread b =new ThreadEx();
        Thread c =new ThreadEx();
        a.join();
        b.join();
        c.join();
        if(WITH_ATOMIC){
            System.out.println(at);
        }else{
            System.out.println(nat);
        }

    }
}

class ThreadEx extends Thread{
    public ThreadEx() {
        this.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            AtomicIntegerEx.increment();
        }
    }
}