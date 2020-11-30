package cn.oopeak.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.oopeak.bean.Student;
import cn.oopeak.dao.StudentDaoImpl;

/**
 * 查询全部学生信息
 */
@WebServlet("/QueryAllStudent")
public class QueryAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryAllStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		//返回是一个集合，传给jsp页面 通过foreach循环渲染出来
		List<Student> studentLists = studentDaoImpl.queryAllStudent();
		request.setAttribute("studentLists", studentLists);
		request.getRequestDispatcher("/showall.jsp").forward(request, response);
	}

}
