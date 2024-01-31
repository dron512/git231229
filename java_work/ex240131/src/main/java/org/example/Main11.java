package org.example;

import java.util.Arrays;

public class Main11 {

    public static void main(String[] args) {
        int arr[] = {30,10,20,50,1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        INum brr[] = new INum[5];
        brr[0] = new INum(30);
        brr[1] = new INum(10);
        brr[2] = new INum(50);
        brr[3] = new INum(1);
        brr[4] = new INum(3);

        Arrays.sort(brr);
//        Arrays.sort(brr, (o1, o2) -> ((INum)o1).getNum() - ((INum)o2).getNum());
        System.out.println(Arrays.toString(brr));
    }
}
