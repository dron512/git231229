package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main3 {

    public static void main(String[] args) {

        try( DataOutputStream dos = new DataOutputStream(new FileOutputStream("main3.dat")) ){
            dos.writeInt(10);
            dos.writeDouble(30.4);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try( DataInputStream dis = new DataInputStream(new FileInputStream("main3.dat")) ){
            int a = dis.readInt();
            double b = dis.readDouble();
            System.out.println(a);
            System.out.println(b);

//            byte [] bytes= new byte[4];

//            double a = dis.readDouble();
//            int b = dis.readInt();
//            System.out.println(a);
//            System.out.println(b);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
