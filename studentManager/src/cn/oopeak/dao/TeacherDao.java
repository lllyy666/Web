package cn.oopeak.dao;

import cn.oopeak.bean.Teacher;


public interface TeacherDao {
	public boolean addTeacher(Teacher user);
	
	public Teacher loginTeacher(int tno,String password);
	
	public Teacher queryTeacher(int tno);
}