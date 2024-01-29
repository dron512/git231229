package org.example;


class EBox<T extends Number>{
    private T t;
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
}

public class Main5 {

    public static void main(String[] args) {
        EBox<Integer> eBox1 = new EBox<>();
        eBox1.setT(100);
        System.out.println(eBox1.getT());
    }
}
