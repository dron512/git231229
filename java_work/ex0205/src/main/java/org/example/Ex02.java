package org.example;

import java.util.*;

public class Ex02 {
    public static void main(String[] args) {

        List<Car> list = Arrays.asList(
                        new Car(1800),
                        new Car(3000),
                        new Car(4000),
                        new Car(1200)
                    );

        Collections.sort(list);
        Collections.sort(list,
                new Comparator<Car>() {
                    @Override
                    public int compare(Car o1, Car o2) {
                        return ((Car)o1).getDisp() - ((Car)o2).getDisp();
                    }
                }
        );
//        Collections.sort(list,
//                (a,b) ->
//                    ((Car)a).getDisp() - ((Car)b).getDisp()
//                );

        System.out.println(list);
    }
}
