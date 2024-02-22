package org.example;

public class Main3 {


    // $"hi = {hi}"
    public static void main(String[] args) {
        String a = "안녕하세요";
        String hi = String.format("hi = %s",a);
        System.out.println(hi);
    }
}
