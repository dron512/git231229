package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();


//        list.add(10);
//        list.add("String");

        list.add(new Apple("사과"));

        System.out.println(list);


    }
}
