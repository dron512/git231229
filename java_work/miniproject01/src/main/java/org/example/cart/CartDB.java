package org.example.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CartDB {
    private CartCLI cartCLI = new CartCLI();

    public void insert() {
        //장바구니 만들기
        Connection con = null;
        PreparedStatement pstmt = null;
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                pstmt.close();
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        // 장부구니 안에 아이템 넣기


    }
}
