package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("BOX","TOY","ROBOT","SAMPLE");
        list = new ArrayList<>(list);
        List<String> clist = Arrays.asList("BOX","TOY","ROBOT","SAMPLE");
        clist = new ArrayList<>(clist);

        list.addAll(clist);
        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        for(String temp :list){
            if(temp.length() > 3)
                list2.add(temp);
        }
        System.out.println(list2);

        List streamlist = list.stream()
                .filter( str -> str.length()>3)
                .collect(
                            ArrayList::new,
                            (objects, s) -> objects.add(s),
                            (lst1,lst2) -> lst1.addAll(list2)
                        );
        System.out.println(streamlist);

        List streamlist2 = list.stream()
                .filter( str -> str.length()>3)
                .collect(
                        Collectors.toList()
                );
        System.out.println(streamlist2);
    }
}
