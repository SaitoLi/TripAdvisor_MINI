package lzz.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lzz.com.dao.StudentDao;
import lzz.com.vo.Student;

/**
 * Servlet implementation class InsertStuServlet
 */
@WebServlet("/InsertStuServlet")
public class InsertStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//设置格式，每个Servlet都需要声明
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String stuname = request.getParameter("stuname");
		int age = Integer.parseInt(request.getParameter("age"));
		double score = Double.parseDouble(request.getParameter("score"));
		
		Student s = new Student();
		s.setId(id);
		s.setStuname(stuname);
		s.setAge(age);
		s.setScore(score);
		
		StudentDao stuDao = new StudentDao();
		stuDao.insertStu(s);
		request.getRequestDispatcher("QueryAllServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
