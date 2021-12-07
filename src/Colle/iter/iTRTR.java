package Colle.iter;

import Colle.ArrayList.ArL;
import Colle.LinkrfList.LL;

import java.util.Iterator;

public class iTRTR {
    public static void main(String[] args) {

        ArL A = new ArL();
        LL linkdLst = new LL();
        Iterator<String> AB = A.arList.iterator();
        while (AB.hasNext()) {
            System.out.println(AB.next());
        }
        Iterator<String> linkedListIterator1 = linkdLst.alinkdListrList.iterator();
        Iterator<String> linkedListIterator2 = linkdLst.alinkdListrList.listIterator();
    }
}
