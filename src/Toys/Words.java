package Toys;

import java.io.Serializable;

class Words implements Comparable<Words>, Serializable {
    private final int serialVersionUID = 1;
    Integer num;
    StringBuilder word;
    Integer counter;

    Words(StringBuilder word, Integer counter) {
        this.word = word;
        this.counter = counter;
    }


    @Override
    public int compareTo(Words o) {
        return o.counter - this.counter;
    }

    @Override
    public String toString() {

        return num + " Word = " + word +
                ", counter = " + counter +
                '\n';
    }
}
