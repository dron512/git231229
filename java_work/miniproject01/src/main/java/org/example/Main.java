package org.example;

import org.example.cart.CartDB;
import org.example.item.ItemDB;
import org.example.member.Member;
import org.example.member.MemberDB;
import org.example.orders.OrderDB;
import org.example.util.Login;

import java.util.Scanner;

public class Main {

    // 회원관리 DB
    public static MemberDB md = new MemberDB();
    // 상품 관리 DB
    public static ItemDB id = new ItemDB();
    // 장바구니 관리 DB
    public static CartDB cd = new CartDB();
    // 주문 관리 DB
    public static OrderDB od = new OrderDB();

    public static void main(String[] args) {
        // 선택
        while (true) {
            int select = 0;

            if (Login.member != null
                    && Login.getRole().equalsIgnoreCase("admin"))
                select = printMenuAdmin();
            else
                select = printMenuUesr();

            if (select == 1) {
                md.insert();
            } else if (select == 2) {
                if (!Login.login) {
                    Member dbMember = md.login();
                    System.out.println("dbMember = " + dbMember);
                    if (dbMember != null) {
                        Login.login = true;
                        Login.member = dbMember;
                    }
                } else {
                    System.out.println("이미 로그인하셨습니다.");
                }
            } else if (select == 3) {
                if (!Login.login) {
                    System.out.println("로그인 하셔야 로그아웃 할 수 있습니다.");
                } else {
                    Login.login = false;
                    Login.member = null;
                    System.out.println("로그아웃 하셨습니다.");
                }
            } else if (select == 4) {
                id.select();
            } else if (select == 5) {
                if (Login.login) {
                    while (true) {
                        int cartSelect = printMenuCart();
                        if (cartSelect == 1) {
                            cd.insert();// 장바구니 만들기

                            // 장바구니 아이템 넣는 로직
                            // 없는 상품을 선택할시 등록 종료...
                            // 아니면 상품 보여주면서 계속 상품 등록...
                            cd.insertItem();
                        }
                        else if(cartSelect == 5){
                            System.out.println("장바구니를 종료합니다.");
                            break;
                        }
                    }
                } else {
                    System.out.println("로그인하셔야 장바구니 메뉴를 볼수 있습니다.");
                }
            } else if (select == 7) {
                System.out.println("시스템 종료됩니다.");
                System.exit(0);
            } else if (select == 8 && Login.member != null && Login.getRole().equalsIgnoreCase("admin")) {
                try {
                    id.insert();
                    System.out.println("상품등록되었습니다.");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }

    // user 로 로그인 하면 상품 등록 X
    // admin으로 로그인하면 상품 등록 O, 회원목록
    public static int printMenuCart() {
        System.out.println("1.등록");
        System.out.println("2.수정");
        System.out.println("3.삭제");
        System.out.println("4.목록");
        System.out.println("5.뒤로");
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        return menu;
    }

    public static int printMenuUesr() {
        System.out.println("1.회원가입");
        System.out.println("2.로그인");
        System.out.println("3.로그아웃");
        System.out.println("4.물품보기");
        System.out.println("5.장바구니");
        System.out.println("6.주문목록");
        System.out.println("7.종료");
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        return menu;
    }

    public static int printMenuAdmin() {
        System.out.println("1.회원가입");
        System.out.println("2.로그인");
        System.out.println("3.로그아웃");
        System.out.println("4.물품보기");
        System.out.println("5.장바구니");
        System.out.println("6.주문목록");
        System.out.println("7.종료");
        System.out.println("8.상품등록");
        System.out.println("9.회원목록");
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        return menu;
    }
}