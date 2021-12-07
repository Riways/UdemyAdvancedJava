package Colle.LinkedList;

public class ReverseLinkedListFromEnd {
    public static void main(String[] args) {
        node frst = null;
        node temp = frst;
        for (int i = 0; i < 100; i++) {
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

        node temp = frst;
        node previous = temp;
        node newFirst;
        while (temp.getNext() != null) {
            previous = temp;
            temp = temp.getNext();
        }

        newFirst = temp;
        newFirst.setNext(previous);
        while (frst.getNext().getNext() != frst) {
            temp = findFrontier(frst);
            previous.setNext(temp);
            previous = temp;
        }
        frst.setNext(null);
        return newFirst;
    }

    static node findFrontier(node frst) {
        node temp;
        node previous;
        temp = frst;
        while (temp.getNext() != null) {
            previous = temp;
            temp = temp.getNext();
            if (temp.getNext().getNext() == temp)
                return previous;
        }
        return temp;
    }

}




