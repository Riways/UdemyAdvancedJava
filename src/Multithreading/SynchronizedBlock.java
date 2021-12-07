package Multithreading;

public class SynchronizedBlock {
    static boolean WITH_SYNCHRONIZED = true; //change to see differnce
    static int conter = 0;
    final  static Object lock = new Object();

    public  static void synchIncrement() {
        synchronized (lock){
                conter++;
        }
    }

    public static void notSynchIncrement() {
        conter++;
    }

    public static void main(String[] args) throws InterruptedException {
        long time = System.currentTimeMillis();
        Thread thread11 = new Thread(new SynchThread1());
        Thread thread12 = new Thread(new SynchThread1());
        Thread thread13 = new Thread(new SynchThread1());
        thread11.start();
        thread12.start();
        thread13.start();
        thread11.join();
        thread12.join();
        thread13.join();
        System.out.println("counter: " + SynchronizedBlock.conter + '\n' + "Program completed in " + (System.currentTimeMillis() - time) + " millisenods");
    }

}


class SynchThread1 implements Runnable {
    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000000; i++) {
            if (SynchronizedBlock.WITH_SYNCHRONIZED) {
                SynchronizedBlock.synchIncrement();
            } else {
                SynchronizedBlock.notSynchIncrement();
            }
        }
    }
}
