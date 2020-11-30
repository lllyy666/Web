package cn.oopeak.dao;

import java.util.List;

import cn.oopeak.bean.Student;


public interface StudentDao {
	public boolean addStudent(Student user);

	public List<Student> queryAllStudent();

	public boolean deleteStudent(int sno);

	public boolean modifyStudent(Student user);
	
	public Student queryStudent(int sno);
}