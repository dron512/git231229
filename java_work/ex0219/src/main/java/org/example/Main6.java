package org.example;

import java.io.FileReader;
import java.io.FileWriter;

public class Main6 {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("bb.txt")){
            for(char i='A';i<'Z'+1;i++){
                fw.write(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try(FileReader fr = new FileReader("bb.txt")){
            int ch;
            while (true){
                ch = fr.read();
                if(ch==-1)
                    break;
                System.out.println((char)ch);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
