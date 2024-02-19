package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main7 {

    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("ccc.txt")) ){
            bw.write("공부를 하기 위해서 돈이 필요한 건 아니다.");
            bw.write("그런거 같아요.");
            bw.newLine();
            bw.write("하하하...");
        }catch (Exception e){
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader(new FileReader("aaa.txt"))){
            while(true) {
                String txt = br.readLine();
                if(txt ==null)
                    break;
                System.out.println(txt);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
