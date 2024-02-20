package org.example;


class AA{

    public static AA aa = null;
    public static AA MakeAA(){
        if(aa == null) {
            aa = new AA();
            return aa;
        }
        else {
            return aa;
        }
    }
}
public class Main7 {
    public static void main(String[] args) {
//        AA a1 = AA.MakeAA();
//        System.out.println(a1);
//        AA a2 = AA.MakeAA();
//        System.out.println(a2);
//        AA a3 = AA.MakeAA();
//        System.out.println(a3);


        AA a1 = new AA();
        System.out.println(a1);

        AA a2 = new AA();
        System.out.println(a2);

        AA a3 = new AA();
        System.out.println(a3);

    }

}
