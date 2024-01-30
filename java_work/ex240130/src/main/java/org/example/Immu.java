package org.example;

final class AA{
    private final int a;
    AA(int a) {
        this.a = a;
    }
    public int getA() {
        return a;
    }
}
public class Immu {
    public static void main(String[] args) {
        AA aa = new AA(100);
        System.out.println(aa.getA());
    }
}
