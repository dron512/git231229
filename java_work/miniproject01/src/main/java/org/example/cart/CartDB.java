package org.example.cart;

import org.example.DBINFO;
import org.example.util.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

public class CartDB {
    private CartCLI cartCLI = new CartCLI();

    public void insert() {
        //장바구니 만들기
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(DBINFO.url, DBINFO.user, DBINFO.password);
            pstmt = con.prepareStatement("INSERT into cart  " +
                                            "(reg_time,update_time,member_id) " +
                                            "VALUES " +
                                            "(NOW(),NOW(),?)");
            pstmt.setLong(1, Login.member.getMember_id());
            pstmt.executeUpdate();
        }
        catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("장바구니가 이미 있습니다.");
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 장부구니 안에 아이템 넣기
    }

    public void insertItem(){

    }
}
