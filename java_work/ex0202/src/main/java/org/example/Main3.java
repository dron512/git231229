package org.example;

import java.util.TreeSet;

public class Main3 {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet1 = new TreeSet<>();
        treeSet1.add(10);
        treeSet1.add(20);
        treeSet1.add(30);
        treeSet1.add(5);

        System.out.println(treeSet1);

        TreeSet<String> treeSet2 = new TreeSet<>();
        treeSet2.add("aa");
        treeSet2.add("bb");
        treeSet2.add("zz");
        treeSet2.add("cc");

        System.out.println(treeSet2);
    }
}
