package lzz.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lzz.com.dao.StudentDao;
import lzz.com.vo.Student;

/**
 * Servlet implementation class QueryAllServlet
 */
@WebServlet("/QueryAllServlet")
public class QueryAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		StudentDao stuDao = new StudentDao();
		List<Student> list = stuDao.queryAllstu();
		
		
		
		
		out.print("<table border='1' align='center' width='60%'>");
		out.print("<tr><td>id</td><td>姓名</td><td>年龄</td><td>成绩</td><td>删除</td></tr>");
		for(Student s : list) {
			out.print("<tr>");
			out.print("<td>"+s.getId()+"</td>");
			out.print("<td>"+s.getStuname()+"</td>");
			out.print("<td>"+s.getAge()+"</td>");
			out.print("<td>"+s.getScore()+"</td>");
			out.print("<td><a href='DelStuServlet?id="+s.getId()+"'>删除</a></td>");
			out.print("</tr>");
		}
		out.print("<tr><td colspan='5'><a href='insertStu.html'>增加</a></td></tr>");
		out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
