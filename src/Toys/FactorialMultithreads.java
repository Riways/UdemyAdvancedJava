package Toys;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FactorialMultithreads {
    public static void main(String[] args) {
        ExecutorService facEx = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            facEx.execute(new FactorialRun(421412));
        }
        facEx.shutdown();
    }
}


class FactorialRun implements Runnable{
    int num;
    Integer a = 0;
    FactorialRun(int num){
        this.num = num;
    }
    BigInteger fact = BigInteger.valueOf(1);



    @Override
    public void run() {
        for (int i = 1; i < num; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
            a = a++;
            System.out.print(Thread.currentThread().getName() + "  " + i + " : " + fact + '\n' );
        }

    }
}

enum Day{T,A;}