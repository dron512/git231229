package org.example;

public class Count {
    private int cnt;

    synchronized public void incre(){
        cnt = cnt+1;
    }

    synchronized public void decre(){
        cnt = cnt-1;
    }

    public int getCnt() {
        return cnt;
    }
}
