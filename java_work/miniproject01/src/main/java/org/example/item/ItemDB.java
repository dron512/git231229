package org.example.item;

import org.example.DBINFO;
import org.example.util.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ItemDB {

    private ItemCLI icli = new ItemCLI();

    public void insert() throws Exception{
        System.out.println("상품 등록 기능 만들계획");
        Item item = icli.inputItem();

        Connection con = null;// db연결객체
        PreparedStatement pstmt = null; // sql 문장 담기

        try{
            con = DriverManager.getConnection(DBINFO.url,DBINFO.user,DBINFO.password);
            pstmt = con.prepareStatement("" +
                    "INSERT INTO item " +
                    "(reg_time, update_time, created_by, modified_by, " +
                    "item_detail, item_nm, item_sell_status, price, stock_number) " +
                    "VALUES  " +
                    "( NOW(), NOW(), ?, ?, " +
                    "?, ?, ?, ?, ?)" +
                    "");
            pstmt.setString(1, Login.member.getName());
            pstmt.setString(2, Login.member.getName());

            pstmt.setString(3, item.getItem_detail());
            pstmt.setString(4, item.getItem_nm());

            pstmt.setString(5, item.getItem_sell_status());
            pstmt.setInt(6, item.getPrice());
            pstmt.setInt(7, item.getStock_number());

            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            con.close();
            pstmt.close();
        }
    }

}
