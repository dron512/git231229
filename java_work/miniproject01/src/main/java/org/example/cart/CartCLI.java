package org.example.cart;

import org.example.Main;

import java.util.Scanner;

public class CartCLI {

    public int inputItem(){
        Main.id.select();
        Scanner scan = new Scanner(System.in);
        System.out.println("넣고 싶은 상품 번호 입력하세요");
        int idx = scan.nextInt();
        return idx;
    }
}
