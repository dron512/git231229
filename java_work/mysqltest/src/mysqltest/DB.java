package mysqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

	public void insert(String todo) {
		System.out.println("DB에 할일입력넣기");

		try {
			// 연결하기...
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			// SQL 구문 작성하기...
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO todo "
														+ "(`할일`,`상태`) "
														+ "VALUES "
														+ "(?,'준비')");
			pstmt.setString(1, todo);
			// SQL 구문 실행하기...
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void select() {
		System.out.println("DB에 할일목록 보여주기");
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM todo");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("idx"));
				System.out.print(rs.getString("할일"));
				System.out.println(rs.getString("상태"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}










