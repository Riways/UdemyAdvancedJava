package Multithreading;

public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread ut = new UserThread();
        Thread dt = new DaemonThread();
        dt.setDaemon(true);
        ut.start();
        dt.start();
        ut.join();
        //dt.join(); but we can force main thread to wait until daemon thread will be completed
        System.out.println("End of main thread." + '\n' + "Daemon thread wanna keep going, " +
                "but nobody cares: all User thread are completed and program completed too");
    }
}

class UserThread extends Thread{
    @Override
    public void run() {
        for (char i = 'A'; i <= 'Z'; i++) {
            try {
                sleep(300);
                System.out.println("UserThread : "  + i + " is daemon: " + this.isDaemon());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}class DaemonThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("DaemonThread : "  + i+ " is daemon: " + this.isDaemon());
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
