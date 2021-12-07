package Toys;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class PriQu {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            double j  = Math.random();
            list.add(null);
            System.out.println(j);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(priorityQueue.poll());
        }
    }
}
