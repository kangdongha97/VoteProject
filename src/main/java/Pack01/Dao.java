package Pack01;

import java.sql.*;

public class Dao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;

	public void userCheck(String uname, String utel) {
		try {
			connect();
			String sql = String.format(
					"select count(*) from userinfo where uname ='%s', utel='%s', vote=false;",
					uname, utel);

			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void vote(User user) {
		try {
			connect();
			String sql = String.format(
					"update userinfo set check = true where uname ='%s', utel='%s';",
					user.uname, user.utel);
			String sql1 = String.format(
					"insert into election %d;",
					user.num);
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
			close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//String url = "jdbc:mysql://118.38.27.198:7777/db01";
			String url = "jdbc:mysql://localhost:3306/db01";
			//conn = DriverManager.getConnection(url, "gang", "1234");
			conn = DriverManager.getConnection(url, "root", "1234");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	void close() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if (result != null && !result.isClosed()) {
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}