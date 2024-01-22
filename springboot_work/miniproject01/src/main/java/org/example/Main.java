package org.example;

import org.example.mh.Member;
import org.example.mh.MemberDB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MemberDB md = new MemberDB();

        System.out.println("이메일을 입력 하세요.");
        String email = scan.nextLine();
        System.out.println("주소을 입력 하세요.");
        String addr = scan.nextLine();
        System.out.println("이름을 입력 하세요.");
        String name = scan.nextLine();
        System.out.println("패스워드를 입력 하세요.");
        String password = scan.nextLine();

        Member member = new Member(email,name,addr,password);

        md.insert(member);
    }
}