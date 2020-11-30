package cn.oopeak.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.oopeak.bean.Teacher;
import cn.oopeak.tool.SqlInit;

/**
 * 数据处理类
 * 
 */
public class TeacherDaoImpl implements TeacherDao {
	/**
	 * 添加教师
	 */
	@Override
	public boolean addTeacher(Teacher teacher) {
		SqlInit sqlInit = SqlInit.build();
		Connection connection = sqlInit.getConnection();
		String preSql = "insert into teacher(tno,tname,gender,password) values(?,?,?,?)";
		// PreparedStatement可以防止sql注入
		PreparedStatement statement = null;
		boolean bool = false;
		try {
			statement = connection.prepareStatement(preSql);
			// 代表第一个'？' 下面同理
			statement.setInt(1, teacher.getTno());
			statement.setString(2, teacher.getTname());
			statement.setString(3, teacher.getGender());
			statement.setString(4, teacher.getPassword());
			// 查询到了会返回查询到的记录数
			int i = statement.executeUpdate();
			if (i == 1) {
				bool = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			bool = false;
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return bool;
	}

	/**
	 * 教师教师登陆验证
	 */
	@Override
	public Teacher loginTeacher(int tno,String password) {
		SqlInit sqlInit = SqlInit.build();
		Connection connection = sqlInit.getConnection();
		String preSql = "select  *  from  teacher where tno =? and password =?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Teacher teacher = null;
		
		try {
			statement = connection.prepareStatement(preSql);
			statement.setInt(1, tno);
			statement.setString(2,password);  
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				teacher = new Teacher();
				teacher.setTno(resultSet.getInt("tno"));
				teacher.setTname(resultSet.getString("tname"));
				teacher.setGender(resultSet.getString("gender"));
				teacher.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return teacher;
	}

	/**
	 * 根据教工号查询单个教师
	 */
	@Override
	public Teacher queryTeacher(int tno) {
		SqlInit sqlInit = SqlInit.build();
		Connection connection = sqlInit.getConnection();
		String preSql = "select * from teacher where tno = ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Teacher teacher = null;
		try {
			statement = connection.prepareStatement(preSql);
			statement.setInt(1, tno);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				teacher = new Teacher();
				teacher.setTno(resultSet.getInt("tno"));
				teacher.setTname(resultSet.getString("tname"));
				teacher.setGender(resultSet.getString("gender"));
				teacher.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return teacher;
	}
	
	
}
