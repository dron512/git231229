package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//속도가 느리다는.. 말을... 너무 많이 들어서.. 그래요..
// 1.4 1.5 1.6 1.8



public class Main5 {

    public static void main(String[] args) {
        List<Integer> list = List.of(10,20,30);
        System.out.println(list);

        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            int temp = itr.next();
            System.out.println(temp);
        }
        // 불변인지 확인...
        //list.add(50);

        List<Integer> list2 = new ArrayList<>(list);
        System.out.println(list2);

        list2.add(50);
        System.out.println(list2);
    }

}
