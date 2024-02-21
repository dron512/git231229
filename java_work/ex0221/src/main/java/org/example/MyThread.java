package org.example;

public class MyThread extends Thread{
    private String name;
    public MyThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {
//        main(null);
        for (int i = 0; i < 100; i++) {
            if(name.equals("athread")) {
                System.out.println("athread = " + i);
            }
            else{
                System.out.println("이름이 다른 쓰레드" + i);
            }
        }
    }

    public static void main(String[] args) {
        MyThread mt1 = new MyThread("athread");
        mt1.start();
        MyThread mt2 = new MyThread("다른쓰레드");
        mt2.start();
    }
}
