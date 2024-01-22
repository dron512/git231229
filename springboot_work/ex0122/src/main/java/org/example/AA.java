package org.example;


public class AA {

    private int a = 10;

    private int b = 20;

    // alt + shift + s -> r 이클립스
    // alt + insert

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    // mysql jar 이클립스

    // maven 프로젝트 pom.xml 로 jar 파일을 관리합니다.

    public void doA(){
        System.out.println("AA doA"+a);
    }

    public static void doB(){
        System.out.println("AA doB");
    }
}
