package org.example;

import java.util.Arrays;

public class Main10 {

    public static void main(String[] args) {

        INum[] arr = new INum[3];
        INum[] brr = new INum[3];

        arr[0] = new INum(10);
        arr[1] = new INum(20);
        arr[2] = new INum(30);

        brr[0] = new INum(10);
        brr[1] = new INum(20);
        brr[2] = new INum(30);

        System.out.println(arr == brr);
        System.out.println(arr.equals(brr));

        System.out.println(Arrays.equals(arr,brr));

    }

}
