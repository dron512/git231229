package org.example;

class SuperCls{
    static int count = 0;
}
class SubCls extends SuperCls{
    public static void setCount(){
        count = 100;
    }
}
public class Main3 {
    public static void main(String[] args) {
        //변수든 메서드든 메모리상에 올려 놓고 써야한다...

        System.out.println(SuperCls.count);
        System.out.println(SubCls.count);

        SuperCls.count = 200;

        System.out.println(SuperCls.count);
        System.out.println(SubCls.count);

//        SubCls sc = new SubCls();
//        sc.setCount();
        SubCls.setCount();
        System.out.println(SuperCls.count);
        System.out.println(SubCls.count);
    }
}
