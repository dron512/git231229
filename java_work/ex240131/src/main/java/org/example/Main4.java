package org.example;

public class Main4 {

    public static void main(String[] args) {
        Point org = new Point(10, 20);
//        Point org = new Point(10, 20);

        Point clo = null;
        try {
            clo = (Point) org.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(org);
        System.out.println(clo);

        org.setXpos(20);
        System.out.println(org);
        System.out.println(clo);
    }
}
