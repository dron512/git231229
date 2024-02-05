package org.example;

import java.util.*;

class MyComparator implements Comparator<Car>{
    @Override
    public int compare(Car o1, Car o2) {
        return o2.getDisp() -o1.getDisp();
    }
}
public class Ex03 {
    public static void main(String[] args) {
        List<Car> list = Arrays.asList(new Car(4000),
                                        new Car(1200),
                                         new Car(1800));
        list = new ArrayList<>(list);

        Collections.sort(list, new MyComparator());
        Collections.sort(list, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getDisp() - o1.getDisp();
            }
        });
        Collections.sort(list,
            (Car o1, Car o2) ->{
                return o2.getDisp() - o1.getDisp();
            }
        );

        System.out.println(list);
    }
}
