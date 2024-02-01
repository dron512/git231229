package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ItemDB id = new ItemDB();
        List<Item> list = id.findAll();

        for (int i = 0; i < list.size(); i++) {
            Item temp = list.get(i);
            System.out.println(temp);
        }

        Collections.sort(list);
        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            Item temp = list.get(i);
            System.out.println(temp);
        }

//        System.out.println(list);


    }
}
