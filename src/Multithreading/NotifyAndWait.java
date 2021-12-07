package Multithreading;

public class NotifyAndWait {
    static final long begin = System.currentTimeMillis();
    public volatile static boolean WORK = true;

    public static void main(String[] args) {
        Market market = new Market();
        Thread producer = new Thread(new Producer(market));
        Thread consumer = new Thread(new Consumer(market));
        Thread timer = new Thread(new WorkTime(market));
        producer.start();
        consumer.start();
        timer.start();
    }

}


class Market {
    volatile int bread = 0;

    public synchronized void loop() {
        while (NotifyAndWait.WORK) {
            if (System.currentTimeMillis() - NotifyAndWait.begin >= 10000) {
                System.out.println(System.currentTimeMillis() - NotifyAndWait.begin);
                System.out.println("Market closed");
                NotifyAndWait.WORK = false;
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public synchronized void putBread() {
        while (NotifyAndWait.WORK && System.currentTimeMillis() - NotifyAndWait.begin <= 10000) {
            if (bread >= 5) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            bread++;
            System.out.println("Producer put bread in market" + '\n' + "Count of bread in market: " + bread);
            notify();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void getBread() {
        while (NotifyAndWait.WORK && System.currentTimeMillis() - NotifyAndWait.begin <= 10000) {
            if (bread < 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            bread--;
            System.out.println("Consumer takes bread" + '\n' + "Count of bread in market: " + bread);
            notify();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {
    Market market;

    Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        if (System.currentTimeMillis() - NotifyAndWait.begin >= 10000) {
            market.loop();
        } else {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {
    Market market;

    Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        if (System.currentTimeMillis() - NotifyAndWait.begin >= 10000) {
            market.loop();
        } else {
            market.getBread();
        }
    }
}

class WorkTime implements Runnable {
    Market market;

    WorkTime(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        market.loop();
    }
}
