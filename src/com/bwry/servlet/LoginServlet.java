package com.bwry.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bwry.entity.Book;
import com.bwry.entity.User;
import com.bwry.entity.Users;
import com.bwry.repository.impl.BookRepositoryImpl;
import com.bwry.service.BookLoginService;
import com.bwry.service.LoginService;
import com.bwry.service.UserLoginService;
import com.bwry.service.impl.BookLoginServiceImpl;
import com.bwry.service.impl.LoginServiceImpl;
import com.bwry.service.impl.UserLoginServiceImpl;
import com.mysql.cj.conf.ConnectionUrl.Type;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet{
//注入Servlet对象
	private LoginService loginService =   new LoginServiceImpl();
	private UserLoginService userLoginService = new UserLoginServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
		//解决乱码
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String filename = "";
		//取到type值
		String types = req.getParameter("type");
		switch (types) {
		/*借书后图书数据刷新*/
		case "UsBookLook":
			List<Book> userlist = loginService.bookLook(null, null, 0);
			if (userlist != null) {
				req.setAttribute("list", userlist);
				req.getRequestDispatcher("/UserBookLook.jsp").forward(req, resp);
			}else {
				resp.sendRedirect("/BooksInfoSys/LendBook.jsp");
			}
			break;
			case "txt":
			
			filename = "编外人员图书馆设计说明书.docx";
			resp.setContentType("application/x-msdownload");
			// ������Ӧͷ
			resp.setHeader("Content-Disposition", "attachment;filename=" + filename);

			OutputStream outputStream = resp.getOutputStream();
			String path = req.getServletContext().getRealPath("/down/" + filename);
//			System.out.println(path);
			InputStream inputStream = new FileInputStream(path);
			int temp = 0;
			while ((temp = inputStream.read()) != -1) {
				outputStream.write(temp);
			}
			outputStream.close();
			inputStream.close();
			
			break;
			case "txt1":
				

				filename = "数据库.docx";
				resp.setContentType("application/x-msdownload");
				// ������Ӧͷ
				resp.setHeader("Content-Disposition", "attachment;filename=" + filename);

				OutputStream outputStream2 = resp.getOutputStream();
				String path2 = req.getServletContext().getRealPath("/down/" + filename);
//				System.out.println(path);
				InputStream inputStream2 = new FileInputStream(path2);
				int temp2 = 0;
				while ((temp2 = inputStream2.read()) != -1) {
					outputStream2.write(temp2);
				}
				outputStream2.close();
				inputStream2.close();
				
				break;
		default:
			break;
		}

	}
	
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
		//解决乱码
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
		//manage
			String mname = req.getParameter("mname");
			String mpassword = req.getParameter("mpassword");
			User user = loginService.login(mname, mpassword);
		//users
			String uname = req.getParameter("uname");
			String upassword = req.getParameter("upassword");
			Users users = userLoginService.userLogin(uname, upassword);
			//取到type值
			String types = req.getParameter("type");
			switch (types) {
			case "manage":
				if (user != null) {
					HttpSession session = req.getSession();
					session.setAttribute("User", user);
//					System.out.println("��¼�ɹ�");
					req.getRequestDispatcher("/ManageOptions.jsp").forward(req, resp);
				}else {
					resp.sendRedirect("/BooksInfoSys/Login.jsp");
				}
				break;
			case "users":
				List<Book> userlist = loginService.bookLook(null, null, 0);
				if (users != null) {
					HttpSession session = req.getSession();
					session.setAttribute("Users", users);
					 req.setAttribute("list", userlist);
//					System.out.println("��¼�ɹ�");
					req.getRequestDispatcher("/UserBookLook.jsp").forward(req, resp);
				}else {
					resp.sendRedirect("/BooksInfoSys/UserLogin.jsp");
				}
				break;
			default:
				break;
			}
			
		}
}
