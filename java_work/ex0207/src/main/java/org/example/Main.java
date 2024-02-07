package org.example;

// enum -> 제한.. 정해진값을..
// 어노테이션 lOMBOK
// 가변형 매개변수 String ...aa

// 스태틱 메서드 에서는 스태틱 변수 사용 가능, heap 영역 변수 사용 X
// heap 메서드 이면 heap영역 변수 , 스태틱 변수 사용 가능
// 메모리 상에 올려놓고 사용해야된다...
class Outer {
    private static int num = 0;

    public static class Nested1 {
        public void add(int n) {
            Outer.num += n;
        }
    }
    public static class Nested2 {
        public int get() {
            int a = 10;
            return num + a;
        }
        public void doPrint(){
            System.out.println(num);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Outer.Nested1 ns1 = new Outer.Nested1();
        Outer.Nested2 ns2 = new Outer.Nested2();

        ns1.add(100);
        System.out.println(ns2.get());
        ns2.doPrint();

    }
}