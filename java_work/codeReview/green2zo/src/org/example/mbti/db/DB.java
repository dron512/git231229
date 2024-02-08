package org.example.mbti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB implements DBINFO {

	public DB(String name, String gender, String age, String mbti, String type) {

		Connection con = null;

		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String spl = " INSERT INTO MEMBER(name,gender,age,mbti,type) " + " VALUES (?, ?, ?, ?, ?) ";

		PreparedStatement pstm = null;

		try {
			pstm = con.prepareStatement(spl);
			pstm.setString(1, name);
			pstm.setString(2, gender);
			pstm.setString(3, age);
			pstm.setString(4, mbti);
			pstm.setString(5, type);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
