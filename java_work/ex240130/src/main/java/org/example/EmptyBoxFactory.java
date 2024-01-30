package org.example;

public class EmptyBoxFactory {

    public static <T> Box<T> makeBox(){
        Box<T> box = new Box<T>();
        return box;
    }

    public static void outBox(Box<? extends Toy> box, Toy n){
        Toy toy = box.getObj();
        System.out.println(box);
//        box.setObj(new Toy());
    }

    public static void inBox(Box<? super Toy> box, Toy n){
//        Toy toy = box.getObj();
//        System.out.println(box);
        box.setObj(new Toy());
    }

    // 오버로딩이 안되서
//    public static <T> void peekBox(Box<T> box,int a){
//        System.out.println(box);
//    }

    public static void peekBox(Box<?> box,String a){
        System.out.println(box);
    }

}
