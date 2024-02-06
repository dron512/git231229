package org.example;

import org.example.enums.Role;

import java.sql.*;

public class ENUM_STUDY_DB {
    public void insert() {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.0.38/PMH", "pmh", "1234");
            pstmt = con.prepareStatement("INSERT INTO enum_study " +
                    "(role) " +
                    "VALUES " +
                    "(?)");
            pstmt.setString(1, Role.ADMIN.toString());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.0.38/PMH", "pmh", "1234");
            pstmt = con.prepareStatement("UPDATE enum_study SET ROLE='user' WHERE id=?");
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.0.38/PMH", "pmh", "1234");
            pstmt = con.prepareStatement("DELETE from enum_study WHERE id=?");
            pstmt.setLong(1,id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void select() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.0.38/PMH", "pmh", "1234");
            pstmt = con.prepareStatement("SELECT * FROM enum_study");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getLong("id"));
                System.out.println(rs.getString("ROLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
