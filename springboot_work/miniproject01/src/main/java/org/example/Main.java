package org.example;

import org.example.mh.Member;
import org.example.mh.MemberDB;
import org.example.util.MyCLI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MyCLI cli = new MyCLI();
        MemberDB md = new MemberDB();
//        Member member = cli.inputMember();

        boolean result = md.findByEmail("qcwliekjrn@naver.com");
        System.out.println(result);
//        md.insert(member);

    }
}