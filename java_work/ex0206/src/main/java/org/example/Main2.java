package org.example;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

//      static 일떄...
//      ENUM_STUDY_DB.insert();

        ENUM_STUDY_DB enumStudyDb = new ENUM_STUDY_DB();

        while(true) {
            enumStudyDb.insert();
            enumStudyDb.select();

            Scanner scan = new Scanner(System.in);

            System.out.println("수정 하고 싶은 id ?");
            int temp = scan.nextInt();

            enumStudyDb.update(temp);
            enumStudyDb.select();

            System.out.println("삭제 하고 싶은 id ?");
            temp = scan.nextInt();

            enumStudyDb.delete(temp);
            enumStudyDb.select();
        }

    }

}
