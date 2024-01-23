package org.example;

import java.util.ArrayList;
import java.util.List;

class AA{
    @Override
    public String toString() {
        return "AA{}";
    }
}
class BB extends AA {
    public void doBB(){}
    @Override
    public String toString() {
        return "BB{}";
    }
}
class CC extends AA{
    public void doCC(){}
    @Override
    public String toString() {
        return "CC{}";
    }
}
public class Main4 {
    public static void main(String[] args) {
        List<AA> list = new ArrayList<>();

        list.add(new BB());
        list.add(new CC());

        if( list.get(0) instanceof BB) {
            BB b1 = (BB) list.get(0);
            b1.doBB();
        }
        else if( list.get(0) instanceof CC){
            CC c1 = (CC) list.get(0);
            c1.doCC();
        }

//        if( list.get(1) instanceof CC) {
//            CC c1 = (CC) list.get(1);
//        }
//        else if( list.get(1) instanceof BB){
//            BB b1 =
//        }

    }
}
