package org.example;

import java.util.StringTokenizer;

public class Main8 {

    public static void main(String[] args) {
        String a = "오후:08:22";

        StringTokenizer st = new StringTokenizer(a,":");
        while (st.hasMoreTokens()){
            String temp = st.nextToken();
            System.out.println(temp);
        }

        String[] arr = a.split(":");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);

        String[] brr = arr;



    }
}

