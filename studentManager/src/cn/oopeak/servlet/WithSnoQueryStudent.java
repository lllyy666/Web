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
 * 根据sno查询学生信息   修改学生信息时使用
 */
@WebServlet("/WithSnoQueryStudent")
public class WithSnoQueryStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WithSnoQueryStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sno = Integer.parseInt(request.getParameter("sno"));
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		Student student = studentDaoImpl.queryStudent(sno);
		request.setAttribute("student", student);
		//将查询到的信息放入到session域中
		request.getSession().setAttribute(student.getSno().toString(), student);
		request.getRequestDispatcher("/modify.jsp").forward(request, response);
	}

}
