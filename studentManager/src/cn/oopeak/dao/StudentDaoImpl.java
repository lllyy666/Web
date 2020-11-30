package cn.oopeak.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.oopeak.bean.Student;
import cn.oopeak.tool.SqlInit;

/**
 * 数据处理类
 * 
 */
public class StudentDaoImpl implements StudentDao {
	/**
	 * 添加学生
	 */
	@Override
	public boolean addStudent(Student student) {
		SqlInit sqlInit = SqlInit.build();
		Connection connection = sqlInit.getConnection();
		String preSql = "insert into student(sno,sname,birthday,gender,bj) values(?,?,?,?,?)";
		// PreparedStatement可以防止sql注入
		PreparedStatement statement = null;
		boolean bool = false;
		try {
			statement = connection.prepareStatement(preSql);
			// 代表第一个'？' 下面同理
			statement.setInt(1, student.getSno());
			statement.setString(2, student.getSname());
			statement.setString(3, student.getBirthday());
			statement.setString(4, student.getGender());
			statement.setString(5, student.getBj());
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
	 * 查询全部学生
	 */
	@Override
	public List<Student> queryAllStudent() {
		SqlInit sqlInit = SqlInit.build();
		Connection connection = sqlInit.getConnection();
		String preSql = "select * from student";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		// 用List集合保存所有学生信息
		List<Student> list = new ArrayList<Student>();
		try {
			statement = connection.prepareStatement(preSql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student();
				student.setSno(resultSet.getInt("sno"));
				student.setSname(resultSet.getString("sname"));
				student.setBirthday(resultSet.getString("birthday"));
				student.setGender(resultSet.getString("gender"));
				student.setBj(resultSet.getString("bj"));
				// 添加到list集合中
				list.add(student);
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
		return list;
	}

	/**
	 * 根据sno删除学生
	 */
	@Override
	public boolean deleteStudent(int sno) {
		SqlInit sqlInit = SqlInit.build();
		Connection connection = sqlInit.getConnection();
		String preSql = "delete from student where sno = ?";
		PreparedStatement statement = null;
		boolean bool = false;
		try {
			statement = connection.prepareStatement(preSql);
			statement.setInt(1, sno);
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
	 * 修改学生
	 */
	@Override
	public boolean modifyStudent(Student student) {
		SqlInit sqlInit = SqlInit.build();
		Connection connection = sqlInit.getConnection();
		String refixSql = "update student set ";
		// 如果不为空 说明数据需要被修改
		if (student.getSname() != null) {
			refixSql += "sname = '" + student.getSname() + "',";
		}
		if (student.getGender() != null) {
			refixSql += "gender = '" + student.getGender() + "',";
		}
		if (student.getBirthday() != null) {
			refixSql += "birthday = '" + student.getBirthday() + "',";
		}
		if (student.getBj() != null) {
			refixSql += "bj = '" + student.getBj() + "',";
		}
		// 去除尾部多余的','
		if (refixSql.endsWith(",")) {
			refixSql = refixSql.substring(0, refixSql.length() - 1);
		}
		// 最后拼接要执行的SQL语句
		String preSql = refixSql += " where sno = " + student.getSno();
		PreparedStatement statement = null;
		boolean bool = false;
		try {
			statement = connection.prepareStatement(preSql);
			int i = statement.executeUpdate(preSql);
			if (i == 1) {
				bool = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			bool = false;
		} finally {
			// 数据库使用完后要关闭
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
	 * 根据学号查询单个学生
	 */
	@Override
	public Student queryStudent(int sno) {
		SqlInit sqlInit = SqlInit.build();
		Connection connection = sqlInit.getConnection();
		String preSql = "select * from student where sno = ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Student student = null;
		try {
			statement = connection.prepareStatement(preSql);
			statement.setInt(1, sno);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				student = new Student();
				student.setSno(resultSet.getInt("sno"));
				student.setSname(resultSet.getString("sname"));
				student.setBirthday(resultSet.getString("birthday"));
				student.setGender(resultSet.getString("gender"));
				student.setBj(resultSet.getString("bj"));
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
		return student;
	}

}
