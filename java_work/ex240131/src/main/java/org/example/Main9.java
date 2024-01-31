package org.example;

import java.util.Arrays;

public class Main9 {

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};

        int[] brr = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(brr));

        int[] crr = Arrays.copyOf(arr,3);
        System.out.println(Arrays.toString(crr));

        arr[0] = 100;
        System.out.println(Arrays.toString(brr));
        System.out.println(Arrays.toString(crr));
    }
}
