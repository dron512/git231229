package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main4 {

    public static void main(String[] args) throws Exception{

        Path org = Paths.get("nio.txt");
        if(!Files.exists(org))
            Files.createFile(org);

        Path dst = Paths.get("niocopy.txt");

        System.out.println(REPLACE_EXISTING);
        // 파일복사 해라 옵션으로는 존재하면 대체...
        Files.copy(org,dst, REPLACE_EXISTING);

        // 파일이동 해라... ctrl + x ,ctrl + y 잘라내서 붙이기....
        Files.move(Paths.get("aaa.txt"), Paths.get("bbb.txt"), REPLACE_EXISTING);

    }
}
