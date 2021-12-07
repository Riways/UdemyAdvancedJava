package Multithreading;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcerrentHashMapEx {


    public static void main(String[] args) throws InterruptedException {

        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        //HashMap<Integer, String> map= new HashMap<>(); change
        map.put(1, "Viktor");
        map.put(2, "Petya");
        map.put(3, "Vasya");
        map.put(4, "Oleg");
        map.put(5, "Andrei");
        System.out.println(map);
        Runnable runnable1 = () -> {
            Iterator<Integer> integerIterator = map.keySet().iterator();
            while (integerIterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = integerIterator.next();
                System.out.println(i + " : " + map.get(i));
            }
        };
        Runnable runnable2 = () -> {
            Iterator<Integer> integerIterator = map.keySet().iterator();

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(6, "Krevetka");

        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map);

    }
}
