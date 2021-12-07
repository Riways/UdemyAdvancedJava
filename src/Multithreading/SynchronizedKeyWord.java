package Multithreading;

public class SynchronizedKeyWord {
    static boolean WITH_SYNCHRONIZED = true; //change to see differnce
    static volatile int counter = 0;


    public synchronized static void synchIncrement(){
        counter++;}
    public static void notSynchIncrement(){
        counter++;}
    public static void main(String[] args) throws InterruptedException {
        long time = System.currentTimeMillis();
        Thread thread11 = new Thread( new SynchThread1());
        Thread thread12 = new Thread( new SynchThread1());
        Thread thread13 = new Thread( new SynchThread1());
        thread11.start();
        thread12.start();
        thread13.start();
        thread11.join();
        thread12.join();
        thread13.join();
        System.out.println("counter: " + SynchronizedKeyWord.counter + '\n'+"Program completed in " +(System.currentTimeMillis() - time) + " millisenods");
    }

}


class SynchThread implements Runnable{
    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000000; i++) {
            if(SynchronizedKeyWord.WITH_SYNCHRONIZED){
                SynchronizedKeyWord.synchIncrement();
            }else{
                SynchronizedKeyWord.notSynchIncrement();
            }
        }
    }
}