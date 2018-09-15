package lzz.com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lzz.com.dao.PagesDao;
import lzz.com.service.PagesService;
import lzz.com.vo.Page;
import lzz.com.vo.Pages;
import lzz.com.vo.Person;

/**
 * Servlet implementation class PagesQueryServlet
 */
@WebServlet("/PagesQueryServlet")
public class PagesQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagesQueryServlet() {
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
		PagesService pService = new PagesService();
		PagesDao pDao = new PagesDao(); 
		
		int pagenum = 1;  //第一次访问第一页
		
		if(request.getParameter("pagenum")!=null){   //修改当前页数
			pagenum = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		int start = pagenum * 4 - 4;  //开始位置
		
				
		Map<String, Object> map = pService.pageQuery(start);
		List<Pages> list = (List<Pages>)map.get("list");
		int recordCount = (Integer)map.get("count");  //总记录数
		int pageCount = (recordCount-1)/4+1;     //总页数
		Page page = new Page();
		page.setPagenum(pagenum);
		page.setRecordCount(recordCount);
		page.setPageCount(pageCount);
		
		
		System.out.println(pageCount + "\n" + recordCount+ "\n" +list);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.getRequestDispatcher("share.jsp").forward(request, response);
		
	    
 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
