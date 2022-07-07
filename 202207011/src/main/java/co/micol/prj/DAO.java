package co.micol.prj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAO {//데이터 엑세스 오브젝트
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;

	public void getConnect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//드라이버 공통

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");//데이터베이스의 물리적인 위치 ,아이디,패스워드
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {//conn psmt rs순으로 열고,닫는건 거꾸로

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}