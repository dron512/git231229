package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex04 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("BOX", "ROBOT", "APPLE");
        list = new ArrayList<>(list);

        List<String> copyList = Arrays.asList(new String[list.size()]);
        Collections.copy( copyList, list);

//        Collections.copy(list,copyList);

        System.out.println("===================");
        System.out.println(copyList);
        System.out.println("===================");

        List<String> tlist = list.stream().filter(
                s -> s.length() == 5
        ).toList();

        List<Integer> olist = list.stream().map(
                s -> s.length()
        ).toList();

        copyList.set(0,"aaa");
        System.out.println(list);
        System.out.println(copyList);
        System.out.println(tlist);

        System.out.println(olist);


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("BOX")) {
                System.out.println(list.get(i));
            }
        }

        Collections.sort(list);
        System.out.println(list);

        int idx = Collections.binarySearch(list, "ROBOT");
        System.out.println(idx);

        System.out.println(list.get(idx));

    }
}
