package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main4 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 9, 12, 24);
        int sum = 0;

        sum = doSum(item -> item % 2 == 0, list);
        System.out.println("sum = " + sum);

        sum = doSum(item -> item % 2 != 0, list);
        System.out.println("sum = " + sum);

        // stream.. java 1회독..
        // 2회독...
        // 3회독...

        sum = list.stream()
                .mapToInt(integer -> integer)
                .sum();
        System.out.println(sum);

        sum = list.stream()
                .filter(integer -> integer%2==0)
                .mapToInt(integer -> integer)
                .sum();
        System.out.println(sum);

        sum = 0;
        for( int i : list){
            if(i %2==0){
                sum+=i;
            }
        }
        System.out.println(sum);

        // int, double, long
        // byte, short
        Predicate<String> p = s -> { return true; };
    }

    private static int doSum(IntPredicate p, List<Integer> list) {
        int s = 0;

        for( int i: list){
            if(p.test(i))
                s+=i;
        }

        return s;
    }
}
