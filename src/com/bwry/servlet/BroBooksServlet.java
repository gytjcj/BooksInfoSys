package com.bwry.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bwry.entity.BroBooks;
import com.bwry.service.BroBooksService;
import com.bwry.service.impl.BroBooksServiceImpl;

@SuppressWarnings({ "serial", "unused" })
@WebServlet("/BroBooksServlet")
public class BroBooksServlet extends HttpServlet{
	private String userName,bookName,method ;
	private BroBooksService broBooksService=new BroBooksServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* 解决乱码 */
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		List<BroBooks> broBookslist= broBooksService.BroBooks( 0, userName, bookName);
		
		method=req.getParameter("method");
		switch (method) {
		case "select":
			if (broBookslist != null) {
			    req.setAttribute("list", broBookslist);
				req.getRequestDispatcher("/BroBooks.jsp").forward(req, resp);
			}else {
				resp.sendRedirect("/");
			}
			break;
		/* 借书 */
		case "borrow":	
			userName=req.getParameter("userName");
			bookName=req.getParameter("bookName");
			broBooksService.BroBooks(userName, bookName);
			/* 查看 */
			List<BroBooks> usbroBookslist= broBooksService.UBroBooks( 0, userName, bookName);
			if (usbroBookslist != null) {
			
			req.setAttribute("list", usbroBookslist);
			req.getRequestDispatcher("/LendBook.jsp").forward(req, resp);
			}else {
				resp.sendRedirect("/");
			}
			break;
		/* 还书 */
		case "return":
			int id= Integer.parseInt(req.getParameter("Did"));
			userName=req.getParameter("userName");
			bookName=req.getParameter("bookName");
			int Did = broBooksService.returnBooks(id);
			broBooksService.ReturnBooks(userName, bookName);
			if (broBookslist != null) {
//				req.setAttribute("list", broBookslist);
				req.getRequestDispatcher("/BroBooksServlet?method=select").forward(req, resp);
			}else{
			req.getRequestDispatcher("").forward(req, resp);
			}
			break;
		default:
			break;
		}
	}
}
