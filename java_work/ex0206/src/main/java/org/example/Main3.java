package org.example;

public class Main3 {

    public static void showAll(String... aa){
        for(String temp:aa){
            System.out.println(temp);
        }
    }
    public static void main(String[] args) {
        showAll("BOX");
        System.out.println();
        showAll("BOX","SHOW");
        System.out.println();
        showAll("BOX","SHOW","ALL");
    }
}
