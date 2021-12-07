package Multithreading;


public class NotifyAndWait2 {
    static final long begin = System.currentTimeMillis();
    public volatile static boolean WORK = true;
    static long counter = 0;

    public static void main(String[] args) {
        Market2 market = new Market2();
        Thread producer2 = new Thread(new Producer2(market));
        Thread consumer2 = new Thread(new Consumer2(market));
        //Thread timer = new Thread(new WorkTime2(market));
        producer2.start();
        consumer2.start();
        //timer.start();
    }

}


class Market2 {
    volatile int bread = 0;

    public synchronized void end() {
        System.out.println(System.currentTimeMillis() - NotifyAndWait.begin);
        System.out.println("Market closed");
        NotifyAndWait.WORK = false;
        System.out.println(NotifyAndWait2.counter);

    }

    public synchronized void putBread() {
        while (NotifyAndWait2.WORK && System.currentTimeMillis() - NotifyAndWait2.begin <= 10000) {
            if (bread >= 5) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            bread++;
            NotifyAndWait2.counter++;
            System.out.println("Producer put bread in market" + '\n' + "Count of bread in market: " + bread);
            notify();

        }
    }

    public synchronized void getBread() {
        while (NotifyAndWait2.WORK && System.currentTimeMillis() - NotifyAndWait2.begin <= 10000) {
            if (bread < 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            bread--;
            NotifyAndWait2.counter++;
            System.out.println("Consumer takes bread" + '\n' + "Count of bread in market: " + bread);
            notify();

        }
    }
}

class Producer2 implements Runnable {
    Market2 market;

    Producer2(Market2 market) {
        this.market = market;
    }

    @Override
    public void run() {
        if (System.currentTimeMillis() - NotifyAndWait2.begin >= 10000) {

        } else {
            market.putBread();
        }
    }
}

class Consumer2 implements Runnable {
    Market2 market;

    Consumer2(Market2 market) {
        this.market = market;
    }

    @Override
    public void run() {
        if (System.currentTimeMillis() - NotifyAndWait2.begin >= 10000) {

        } else {
            market.getBread();
        }
    }
}

//class WorkTime2 implements Runnable {
//    Market2 market;
//
//    WorkTime2(Market2 market) {
//        this.market = market;
//    }
//
//    @Override
//    public void run() {
//        market.loop();
//    }
//}
