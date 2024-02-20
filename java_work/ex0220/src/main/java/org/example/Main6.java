package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main6 {

    public static void main(String[] args) {
// io nio 썩어서 쓰는게 nio2...
        Path fp = Paths.get("nio2.dat");
        
        try (DataOutputStream dos = new DataOutputStream(Files.newOutputStream(fp))){
//        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("nio2.dat"))){
            dos.writeInt(10);
            dos.writeDouble(20.2);
        }catch (Exception e){
            e.printStackTrace();
        }

        try (DataInputStream dos = new DataInputStream(Files.newInputStream(fp))){
//        try (DataInputStream dos = new DataInputStream(new FileInputStream("nio2.dat"))){
            int temp = dos.readInt();
            System.out.println(temp);
            double temp1 = dos.readDouble();
            System.out.println(temp1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
