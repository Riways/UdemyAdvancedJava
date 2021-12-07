package Multithreading;

import static java.lang.Math.sqrt;

public class Interrupt {
    public static void main(String[] args) {
        Thr thr = new Thr();
        thr.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thr.interrupt();
    }
}

class Thr extends Thread{
    double d = 0;
    @Override
    public void run() {
        for (double i = 0; i < 1000000; i++) {
            if(isInterrupted()){
                System.out.println("OK, we was interrupted " + '\n' + "our sum is : " + d);
                return;
            }
            try {
                sleep(1);
            } catch (InterruptedException e) {
                System.out.println("OK, we was interrupted when we was sleeping " + '\n' + "our sum is : " + d);
                return;
            }
            d += sqrt(i);

        }
        System.out.println(d);
    }
}