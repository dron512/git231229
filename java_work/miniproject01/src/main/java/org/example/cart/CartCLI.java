package org.example.cart;

import org.example.Main;

import java.util.Scanner;

public class CartCLI {

    public void inputItem(){
        Main.id.select();
        Scanner scan = new Scanner(System.in);
        System.out.println("넣고 싶은 상품 번호 입력하세요");
        String nm = scan.nextLine();
    }
}
