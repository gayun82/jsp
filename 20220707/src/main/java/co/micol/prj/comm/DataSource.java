package co.micol.prj.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {// 싱글톤 클래스 (기본패턴)
	private static DataSource dataSource = new DataSource();// 인스턴스 생성
	private Connection conn;

	private DataSource() {// private 생성자를 만들고

	}

	public static DataSource getInstance() {// get 인스턴스를 이용해서 인스턴스를 리턴한다.
		return dataSource;
	}

	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "micol", "1234");
			System.out.println("DB연결 성공!!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB연결 실패!!!");
		}
		return conn;
	}
}
