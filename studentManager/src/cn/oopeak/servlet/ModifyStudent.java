package cn.oopeak.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.oopeak.bean.Student;
import cn.oopeak.dao.StudentDaoImpl;

/**
 * 
 * 修改学生信息
 *
 */
@WebServlet("/ModifyStudent")
public class ModifyStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 防止乱码
		request.setCharacterEncoding("utf-8");
		Integer sno = Integer.parseInt(request.getParameter("sno"));
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String bj = request.getParameter("bj");
		// 保存修改了的学生信息
		Student modifyStudent = new Student();
		// 修改之前的学生信息
		Student priorToStudent = (Student) request.getSession().getAttribute(sno.toString());
		// 要修改的学生学号
		modifyStudent.setSno(sno);
		// 修改了哪一项
		if (!priorToStudent.getSname().equals(sname)) {
			modifyStudent.setSname(sname);
		}
		if (!priorToStudent.getGender().equals(gender)) {
			modifyStudent.setGender(gender);
		}
		if (!priorToStudent.getBirthday().equals(birthday)) {
			modifyStudent.setBirthday(birthday);
		}
		if (!priorToStudent.getBj().equals(bj)) {
			modifyStudent.setBj(bj);
		}
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		if (studentDaoImpl.modifyStudent(modifyStudent)) {
			request.setAttribute("message", "修改成功,");
		} else {
			request.setAttribute("message", "修改失败,");
		}
		// 修改完后删除session域中的学生信息
		request.getSession().removeAttribute(sno.toString());
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}
