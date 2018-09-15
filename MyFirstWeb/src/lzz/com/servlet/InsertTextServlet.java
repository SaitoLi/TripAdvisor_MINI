package lzz.com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lzz.com.dao.PagesDao;
import lzz.com.vo.Pages;


/**
 * Servlet implementation class InsertTextServlet
 */
@WebServlet("/InsertTextServlet")
public class InsertTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTextServlet() {
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
		String title = request.getParameter("title");
		String imgname = request.getParameter("imgname");
		String destination = request.getParameter("destination");
		String maintxt	 = request.getParameter("maintxt");
		System.out.println(title + "\n" + destination + "\n" + maintxt);
		
		Pages p = new Pages();
		p.setTitle(title);
		p.setImgname(imgname);
		p.setDestination(destination);
		p.setMaintxt(maintxt);
		
		PagesDao pDao = new PagesDao();
		pDao.insertPage(p);
		
		request.getRequestDispatcher("dialog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
