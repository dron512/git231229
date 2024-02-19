package org.example;

import java.io.FileWriter;

public class Main5 {

    public static void main(String[] args) {
        try(FileWriter fw = new FileWriter("aa.txt")){
            fw.write('한');
            fw.write("\n");
            fw.write("문자열");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
