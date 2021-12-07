package Gnrcs;

import java.util.ArrayList;

public class Gnrk {
    B b = new B();
    ArrayList<A> list = new ArrayList<>();

    {
        list.add(b);
    }

    public static void main(String[] args) {
        Gnrk g = new Gnrk();

        System.out.println(g.b);
        B <Integer> brs =  new B<>();
        brs.stng = 2;
    }
}

class A {

}

class B < T extends Number> extends A {
    T stng ;
    public void abcaa( T tmplte){
        System.out.println(tmplte);
    }
}