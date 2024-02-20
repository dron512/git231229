package org.example;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Path path = Paths.get("C:\\javastudy\\PathDemo.java");

        System.out.println(path.getRoot());
        System.out.println(path.getParent());
        System.out.println(path.getFileName());

        // 현재경로를 상대경로로 작성
        Path curpath = Paths.get("");

        if(curpath.isAbsolute())
            System.out.println(curpath);
        else{
            String temp = curpath.toAbsolutePath().toString();
            System.out.println(temp);
        }

        // 2진수... 01 byte 단위
        try (FileOutputStream fos = new FileOutputStream("D:\\Students\\java_work\\ex0220\\bb.dat")){
            fos.write(10);
            fos.write(20);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader(
                "https://github.com/dron512/git231229/blob/main/java_work/ex01/src/ex01/User.java")){
            int temp = fr.read();
            System.out.println(temp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}