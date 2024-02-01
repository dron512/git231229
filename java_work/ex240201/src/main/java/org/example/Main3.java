package org.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main3 {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        int n;
        for (Iterator<Integer> itr = list.iterator(); itr.hasNext(); ) {
            n = itr.next();
            System.out.println(n);
        }
        System.out.println();

        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            n = itr.next();
            System.out.println(n);
        }


    }
}
