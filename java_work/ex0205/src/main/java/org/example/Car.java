package org.example;

import java.util.Comparator;

// alt + 1
// alt + insert
// java class 선택...
public class Car implements Comparable<Car> {
    private int disp;

    public int getDisp() {  return disp;  }

    public Car(int disp) {
        this.disp = disp;
    }
    @Override
    public String toString() {
        return "Car{" +
                "disp=" + disp +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return this.disp - o.disp;
    }
}
