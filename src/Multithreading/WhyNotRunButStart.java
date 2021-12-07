package Multithreading;



public class WhyNotRunButStart {

    final static boolean START_WITH_RUN = false; // change to see difference

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThred());
        if(START_WITH_RUN){
            thread.run();
            System.out.println("Method main current thread: " + Thread.currentThread().getName());
        }
        else{
            thread.start();
            System.out.println("Method main current thread: " + Thread.currentThread().getName());
        }
    }
}

class MyThred implements Runnable{
    @Override
    public void run() {
        System.out.println("Method run current thread: " + Thread.currentThread().getName());
    }
}