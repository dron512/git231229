package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public Main() {
        fileWrite();
        fileRead();
    }

    private void fileRead() {
        FileInputStream fis = null;
//        Connection con = null;
        try {
//            con = DriverManager.getConnection()
            fis = new FileInputStream("date.dat");
            int dat = fis.read();
            System.out.println(dat);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        while(true){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("테스트");
//        }

    }

    private void fileWrite(){
        try {
            FileOutputStream fos = new FileOutputStream("date.dat");
            fos.write(7);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}