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
 * 添加学生
 * @author 12563
 *
 */
@WebServlet("/AddServlet")

public class AddServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sno = Integer.parseInt(request.getParameter("sno"));
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		Student student = studentDaoImpl.queryStudent(sno);
		if (student == null) {
			// 防止乱码
		request.setCharacterEncoding("utf-8");
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String bj = request.getParameter("bj");
		Student student1 = new Student();
		student1.setSno(sno);
		student1.setSname(sname);
		student1.setGender(gender);
		student1.setBirthday(birthday);
		student1.setBj(bj);
		StudentDaoImpl studentDaoImpl1 = new StudentDaoImpl();
		if (studentDaoImpl1.addStudent(student1)) {
			request.setAttribute("message", "添加成功,");
		} else {
			request.setAttribute("message", "添加失败,");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
		request.setAttribute("message", "该学生已存在,");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
}
		
		
		

}
