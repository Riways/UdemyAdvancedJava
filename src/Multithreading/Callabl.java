package Multithreading;

import java.math.BigInteger;
import java.util.concurrent.*;

public class Callabl {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService5 = Executors.newFixedThreadPool(2);

        for (long i = 0; i < 2; i++) {
            Future<BigInteger> future = executorService5.submit(new FactorialByCallable(100));

            System.out.println(future.get());
        }
        executorService5.shutdown();
    }
}

class FactorialByCallable implements Callable<BigInteger> {
    int i;
    BigInteger factorial = BigInteger.valueOf(1);

    FactorialByCallable(int i) {
        this.i = i;
    }

    @Override
    public BigInteger call() throws Exception {
        System.out.println(i);
        for (int j = 1; j <= i; j++){
            System.out.print(j + " : ");
            factorial = factorial.multiply(BigInteger.valueOf(j));
            System.out.println(factorial);
            Thread.sleep(100);
        }

        return factorial;
    }
}