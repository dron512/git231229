package org.example;

public class Ex06 {
    public static void type(Scale sc){
        switch (sc){
            case DO:
                System.out.println("도~~~~~");
                break;
        }
    }
    public static void main(String[] args) {
        type(Scale.DO);
        System.out.println(Scale.SI);
        System.out.println(Scale.DO);
//        type(Person.MAN);
    }
}
