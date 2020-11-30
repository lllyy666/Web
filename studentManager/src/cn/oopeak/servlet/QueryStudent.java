package cn.oopeak.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.oopeak.bean.Student;
import cn.oopeak.dao.StudentDaoImpl;

/**
 * 根据sno查询学生信息 查询单个学生信息时使用
 */
@WebServlet("/QueryStudent")
public class QueryStudent extends HttpServlet {
	// 序列化才会使用 不用管 可以删除
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取sno 可以做一下错误处理，防止前台发送非法数据 例如：a123
		int sno = Integer.parseInt(request.getParameter("sno"));
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		Student student = studentDaoImpl.queryStudent(sno);
		if (student == null) {
			request.setAttribute("message", "没有该学生,");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		List<Student> studentLists = new ArrayList<Student>();
		studentLists.add(student);
		request.setAttribute("studentLists", studentLists);
		request.getRequestDispatcher("/showall.jsp").forward(request, response);
	}

}
