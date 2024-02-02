package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // lIST...80%... HashMap 20%...
        Set<String> set = new HashSet<>();

        List<String> list = new LinkedList<>();
        list.add("test");
        String item = list.get(0);

        // java api 문서..
//        set.

        System.out.println(new String("BOX").hashCode());
        System.out.println(new String("BOX").hashCode());

        set.add(new String("BOX"));
        set.add("ROBOT");
        set.add(new String("BOX"));
        set.add("TOY");

        System.out.println(set);

        Iterator<String> itr =  set.iterator();
        while(itr.hasNext()){
            String temp = itr.next();
            System.out.println(temp);
        }
        System.out.println();
        for (String temp : set){
            System.out.println(temp);
        }


    }
}