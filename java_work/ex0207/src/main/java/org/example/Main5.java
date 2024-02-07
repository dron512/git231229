package org.example;

interface AA{
    public void aa(String s);
//    public void f1();
    default void bb(){
        System.out.println("몸체가 있는 메서드");
    }
    static void cc(){
        System.out.println("스태틱 메서드");
    }
}
//class AAA implements AA{
//    @Override
//    public void aa() {
//        System.out.println("제일 옛날 방법...");
//    }
//}
public class Main5 {
    public static void main(String[] args) {
        AA.cc();
//        AA aa = new AA() {
//            @Override
//            public void aa() {
//
//            }
//        };
//        AAA aaa = new AAA();
//        aa.bb();

        AA laa = (String s)->{
            System.out.println("test"+s);
        };

        AA laa1 = (s)->{
            System.out.println("test"+s);
        };

        laa.aa(" 아무거나");
        laa1.aa(" String 생략가능");

    }
}




