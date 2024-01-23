package org.example;

class SuperCls{
    public int a = 10;
    public void doA(){
        System.out.println("SuperCls doA");
    }
}

class SubCls extends SuperCls{
    public int b = 20;
    // 오버로딩... 매개변수가 다른 함수명이 동일해도 된다..
    @Override   //오버라이드 재정의
    public void doA(){
        System.out.println("SubCls doA");
    }
}

public class Main1 {
    public static void main(String[] args) {
        SuperCls sc = new SuperCls();
        sc.doA();

        SubCls subCls = new SubCls();
        subCls.doA();
    }
}
