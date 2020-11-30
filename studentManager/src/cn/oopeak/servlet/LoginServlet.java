package cn.oopeak.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.oopeak.bean.Teacher;
import cn.oopeak.dao.TeacherDaoImpl;

/**
 * 根据tno和password查询教师信息
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取tno,password 可以做一下错误处理，防止前台发送非法数据
		int tno = Integer.parseInt(request.getParameter("tno"));
		String password=request.getParameter("password").trim(); 
		TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
		Teacher teacher = teacherDaoImpl.loginTeacher(tno, password);
		if (teacher == null) {
			request.setAttribute("message", "登录失败,");
			request.getRequestDispatcher("/loginmessage.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
