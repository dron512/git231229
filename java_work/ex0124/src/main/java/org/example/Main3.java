package org.example;

public class Main3 {

    public static void main(String[] args) {
        Print prn = new Print();
        prn.print();

        Printable printable = new Printable(){
            @Override
            public void print() {
                System.out.println("인터페이스");
            }
        };
        printable.print();

        Printable lamda1 = ()->{
            System.out.println("람다");
        };
        lamda1.print();

    }
}
