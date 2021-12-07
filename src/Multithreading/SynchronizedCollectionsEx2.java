package Multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedCollectionsEx2 {
    static boolean SYNCHRONIZED = true;
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> notSynchArrayList = new ArrayList<>();

        List<Integer> synchArrayList = Collections.synchronizedList(notSynchArrayList);
        for (int i = 0; i < 1000; i++) {
            synchArrayList.add(i);
        }
        Runnable runnable1 = () -> {
            if(SYNCHRONIZED) {
                synchronized (synchArrayList) {
                    Iterator<Integer> integerIterator = synchArrayList.iterator();
                    while (integerIterator.hasNext()) {
                        System.out.println(integerIterator.next());
                    }
                }
            }else{
                Iterator<Integer> integerIterator = synchArrayList.iterator();
                while (integerIterator.hasNext()) {
                    System.out.println(integerIterator.next());
                }
            }
        };
        Runnable runnable2 = () -> {
            synchArrayList.remove(10);
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(synchArrayList);
    }
}
