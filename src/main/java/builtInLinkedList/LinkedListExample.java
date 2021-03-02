package builtInLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(24);
        System.out.println(list);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int elem = it.next();
            System.out.println(elem);
        }
        //list.add(2, 999);
        //System.out.println(list);

    }
}
