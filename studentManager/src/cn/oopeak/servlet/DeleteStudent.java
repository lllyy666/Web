package cn.oopeak.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.oopeak.dao.StudentDaoImpl;

/**
 * 删除学生
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sno = Integer.parseInt(request.getParameter("sno"));
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		if (studentDaoImpl.deleteStudent(sno)) {
			request.setAttribute("message", "删除成功,");
		} else {
			request.setAttribute("message", "删除失败，请检查,");
		}
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
