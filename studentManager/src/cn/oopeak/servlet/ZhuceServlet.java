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
 * 教师注册
 * @author 12563
 *
 */
@WebServlet("/ZhuceServlet")
public class ZhuceServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tno = Integer.parseInt(request.getParameter("tno"));
		TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
		Teacher teacher = teacherDaoImpl.queryTeacher(tno);
		if (teacher == null) {
			// 防止乱码
		request.setCharacterEncoding("utf-8");
		String tname = request.getParameter("tname");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		Teacher teacher1 = new Teacher();
		teacher1.setTno(tno);
		teacher1.setTname(tname);
		teacher1.setGender(gender);
		teacher1.setPassword(password);
		TeacherDaoImpl teacherDaoImpl1 = new TeacherDaoImpl();
		if (teacherDaoImpl1.addTeacher(teacher1)) {
			request.setAttribute("message", "注册成功,");
		} else {
			request.setAttribute("message", "注册失败,");
		}
		request.getRequestDispatcher("/loginmessage.jsp").forward(request, response);
	}
		request.setAttribute("message", "该教师已存在,");
		request.getRequestDispatcher("/zhucemessage.jsp").forward(request, response);
}
		
}
