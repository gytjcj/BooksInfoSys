package com.bwry.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bwry.entity.Book;
import com.bwry.entity.LendBook;
import com.bwry.service.BookLoginService;
import com.bwry.service.impl.BookLoginServiceImpl;

@WebServlet("/Book")
public class BookServlet extends HttpServlet {
	//注入servlet对象
	private BookLoginService bookLoginService = new BookLoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//解决乱码
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String types = req.getParameter("type");
		if (types == null) {
			types = "BookLook";
		}
		switch (types) {
		/*图书查看*/
		case "BookLook":
			// books
			List<Book> list = bookLoginService.bookLook(null, null, 0);
			if (list != null) {
				req.setAttribute("list", list);
				// System.out.println(list.toString());
				// System.out.println("�鿴�ɹ�");
				req.getRequestDispatcher("/BooksLook.jsp").forward(req, resp);
				// req.getRequestDispatcher("/UserBookLook.jsp").forward(req,
				// resp);
			} else {
				resp.sendRedirect("/BooksInfoSys/Datum.jsp");
			}
			break;
		//图书修改
		case "UpdateBook":
			int uid = Integer.valueOf(req.getParameter("uid"));
			// String utype = req.getParameter("utype");
			// String uname = req.getParameter("uname");
			//// System.out.println(req.getParameter("ucount"));
			// String ucount = req.getParameter("ucount");
			Book books = new Book(uid, null, null, 0);
			List<Book> Blist = bookLoginService.bookUpdate(books);
			if (Blist != null) {
				req.setAttribute("ulist", Blist);
				//修改成功
				req.getRequestDispatcher("/UpdateBook.jsp").forward(req, resp);
				;
			} else {
				// 修改失败
				resp.sendRedirect("/BooksInfoSys/Datum.jsp");
			}

			break;
		/*下架处理*/
		case "DelBook":
			int did = Integer.valueOf(req.getParameter("did"));
			int Did = bookLoginService.bookDel(did);
			if (Did > 0) {
				//成功
				req.getRequestDispatcher("/Book?type=BookLook").forward(req, resp);
				;
			} else {
				//失败
				resp.sendRedirect("/BooksInfoSys/Datum.jsp");
			}
			break;
		
			/* ���� */
//		case "LendBook":
//			String Uname = req.getParameter("Uname");
//			String Bname = req.getParameter("Bname");
//			LendBook lend = new LendBook(Uname,Bname);
//			int resultCUD = bookLoginService.lend(lend);
//			if (resultCUD>0) {
////				HttpSession session = req.getSession();
////				session.setAttribute("lend", lend);
//				req.getRequestDispatcher("/LendBook.jsp").forward(req, resp);
//				System.out.println("�ɹ���");
//			}else {
//				System.out.println("ʧ����");
//				resp.sendRedirect("/BooksInfoSys/UserBookLook.jsp");
//			} 
//			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 解决乱码
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub

		/* 获取type值 */
		String types = req.getParameter("type");
		if (types == null) {
			types = "BookLook";
		}
		switch (types) {
		/*图书查看*/
		case "BookLook":
			// books
			List<Book> list = bookLoginService.bookLook(null, null, 0);
			if (list != null) {
				req.setAttribute("list", list);
				// System.out.println(list.toString());
				// System.out.println("�鿴�ɹ�");
				req.getRequestDispatcher("/BooksLook.jsp").forward(req, resp);
				// req.getRequestDispatcher("/UserBookLook.jsp").forward(req,
				// resp);
			} else {
				resp.sendRedirect("/BooksInfoSys/Datum.jsp");
			}
			break;
		/*添加图书 */
		case "AddBook":
			/* ��ȡ�����Ϣ */
			String Atype = req.getParameter("Atype");
			String Aname = req.getParameter("Aname");
			int Acount = Integer.valueOf(req.getParameter("Acount"));

			Book book1 = new Book(Atype, Aname, Acount);
			int result = bookLoginService.bookAdd(book1);
			if (result > 0) {
				// ͼ��
				// List<Book> list = bookLoginService.bookLook(null, null, 0);
				// req.setAttribute("list", list);
				// 成功
				req.getRequestDispatcher("/Book?type=BookLook").forward(req, resp);
				;
			} else {
				// 失败
				resp.sendRedirect("/BooksInfoSys/Datum.jsp");
			}
			break;
		// 修改图书
		case "UpdateBook":
			/* 拿到name */
			int uid = Integer.valueOf(req.getParameter("uid"));
			String utype = req.getParameter("utype");
			String uname = req.getParameter("uname");
			int ucount = Integer.valueOf(req.getParameter("ucount"));
			Book books = new Book(uid, utype, uname, ucount);
			int resultCUD = bookLoginService.bookChange(books);
			if (resultCUD > 0) {
				// req.setAttribute("list", ulist);
				// 成功
				req.getRequestDispatcher("/Book?type=BookLook").forward(req, resp);
				;
			} else {
				//失败
				resp.sendRedirect("/BooksInfoSys/Datum.jsp");
			}
			break;

		default:
			break;
		}
	}
}
