package org.example;

import java.util.ArrayList;

interface Printable{
    public void print();
}
class Paper{
    private String con;
    public Paper(String con) {
        this.con = con;
    }
    public Printable getPrinter(){
        class Printer implements Printable{
            @Override
            public void print() {
                System.out.println(con);
            }
        }
        return new Printer();
    }
    public Printable getPrinter1(){
        return new Printable(){
            @Override
            public void print() {
                System.out.println(con);
            }
        };
    }

    public Printable getPrinter2(){
        return ()->{
            System.out.println(con);
        };
    }

}
public class Main3 {
    public static void main(String[] args) {
        Paper p = new Paper("행복합니다...");
        Printable printable = p.getPrinter2();
        printable.print();
    }
}
