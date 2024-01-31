package org.example;

public class Main3 {

    public static void main(String[] args) {

        String str1 = new String("so simple");
        String str2 = new String("so simple");

        String str3 = "so simple";
        String str4 = "so simple";

        System.out.println(str1.equals(str2));
        System.out.println(str3 == str4);
    }
}
