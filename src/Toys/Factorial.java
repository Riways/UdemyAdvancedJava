package Toys;

import java.math.BigInteger;

public class Factorial {
    static int num ;

    public Factorial(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        num = 3114214;
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 1; i < num; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
            System.out.print(Thread.currentThread().getName() + "  " + i + " : " + fact + '\n');
        }

    }
}
