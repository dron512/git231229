package org.example;

public class Main {
    public static void main(String[] args) {


        Person p1 = new Person("Park");
        Person p2 = new Person("Yoon");

        p1 = null;
        p2 = null;

        // Oracle 이거 쓰지마...
        System.gc();    // 가비지 콜렉션 작동해서 힙영역 직접 삭제해라
        System.runFinalization();   // 소멸시에 호출되는 함수 실행해라

        System.out.println("End of Program");

    }
}