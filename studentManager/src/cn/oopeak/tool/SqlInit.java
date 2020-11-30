package cn.oopeak.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接工具类
 *
 */
public class SqlInit {
	private Connection connection;

	private Statement statement;

	private SqlInit() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
			
			String user = "root";
			String password = "369789159";
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public Statement getStatement() {
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statement;
	}

	public static SqlInit build() {
		return new SqlInit();
	}
}
