package Colle.LinkedList;

class node {

    int number;
    private node next = null;

    node(int number) {
        this.number = number;
    }

    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }
}