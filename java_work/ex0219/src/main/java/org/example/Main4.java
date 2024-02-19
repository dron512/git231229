package org.example;

import java.io.*;

public class Main4 {

    public static void main(String[] args) {
        // DB 서버가 필요없는 간단한 프로그램...
        try (
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(new FileOutputStream("main4.dat")))
        ){
            dos.writeDouble(10.20);
            dos.writeDouble(10.20);
            dos.writeDouble(10.20);
            dos.writeDouble(10.20);
            dos.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try (
                DataInputStream dis = new DataInputStream(
                        new BufferedInputStream(new FileInputStream("main4.dat")))
        ){
            double a = dis.readDouble();
            System.out.println(a);
            a = dis.readDouble();
            System.out.println(a);
            a = dis.readDouble();
            System.out.println(a);
            a = dis.readDouble();
            System.out.println(a);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
