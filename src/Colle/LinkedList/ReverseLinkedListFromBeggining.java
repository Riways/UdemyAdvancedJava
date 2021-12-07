package Colle.LinkedList;

public class ReverseLinkedListFromBeggining {
    public static void main(String[] args) {
        node frst = null;
        node temp = frst;
        for (int i = 0; i < 1000; i++) {
            if (i == 0) {
                frst = new node(i);
                temp = frst;
            } else {
                temp.setNext(new node(i));
                temp = temp.getNext();
            }
        }
        goThrought(frst);
        frst = reverseList(frst);
        System.out.println("-----------------");
        goThrought(frst);
    }

    static void goThrought(node first) {
        node temp = first;
        do {
            System.out.println("Node #" + temp.number + " pointer to node #" + temp.getNext().number);
            temp = temp.getNext();
        }
        while (temp.getNext() != null);
        System.out.println("Node #" + temp.number + " is the last node");
    }

    static node reverseList(node frst) {

        node current = frst;
        node previous = null;
        node next = frst.getNext();
        while (current.getNext() != null) {
            current.setNext(previous);
            previous = current;
            current = next;
            next = current.getNext();
        }
        current.setNext(previous);
        return current;
    }
}
