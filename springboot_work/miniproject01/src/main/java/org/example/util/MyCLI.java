package org.example.util;

import org.example.mh.Member;

import java.util.Scanner;

public class MyCLI {

    public Member inputMember(){
        Scanner scan = new Scanner(System.in);

        System.out.println("이메일을 입력 하세요.");
        String email = scan.nextLine();
        System.out.println("주소을 입력 하세요.");
        String addr = scan.nextLine();
        System.out.println("이름을 입력 하세요.");
        String name = scan.nextLine();
        System.out.println("패스워드를 입력 하세요.");
        String password = scan.nextLine();

        return new Member(email,name,addr,password);
    }
}
