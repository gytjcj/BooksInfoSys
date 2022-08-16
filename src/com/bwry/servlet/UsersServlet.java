package com.bwry.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bwry.entity.Users;
import com.bwry.service.UserLoginService;

import com.bwry.service.impl.UserLoginServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/Users")
public class UsersServlet extends HttpServlet {
	/* 注入servlet对象 */
	private UserLoginService userLoginService = new UserLoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* 解决乱码 */
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");


		/* 拿到数据库返回的users */
		List<Users> ulist = userLoginService.usersLook(null, null, null);

		String types = req.getParameter("type");
		switch (types) {
		case "UserLook":
			if (ulist != null) {
				req.setAttribute("ulist", ulist);
				// System.out.println(ulist.toString());
				// System.out.println("锟介看锟缴癸拷");
				req.getRequestDispatcher("/UserLook.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("/BooksInfoSys/Datum.jsp");
			}
			break;
		/* 修改用户 */
		case "UpdateUsers":
			/* 修改对象取值 */
			int uid = Integer.valueOf(req.getParameter("uid"));
			String uname = req.getParameter("uname");
			String usex = req.getParameter("usex");
			String uphone = req.getParameter("uphone");
			/* 封装为一个类 */
			Users users1 = new Users(uid, uname, usex, uphone);
			/* 拿到数据库返回的结果 */
			List<Users> uplist = userLoginService.usersUpdate(users1);
			if (uplist != null) {
				/* 刷新数据 */
				req.setAttribute("ulist", uplist);
				/* 成功，进行页面跳转 */
				req.getRequestDispatcher("/UsersUpdate.jsp").forward(req, resp);
				;
			} else {
				/* 失败 */
				resp.sendRedirect("/BooksInfoSys/Datum.jsp");
			}

			break;
		/* 删除用户 */
		case "DelUsers":
			int did = Integer.valueOf(req.getParameter("did"));
			int Did = userLoginService.usersDel(did);
			if (Did > 0) {
				/* 成功 */
				req.getRequestDispatcher("/Users?type=UserLook").forward(req, resp);
				;
			} else {
				/* 失败 */
				resp.sendRedirect("/BooksInfoSys/Datum.jsp");
			}
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* 解决乱码 */
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub

		/*拿到递过来的type值 */
		String types = req.getParameter("type");
		if (types == null) {
			types = "UserLook";
		}
		switch (types) {
		case "UserLook":
			/* 拿到数据库返回的users结果集 */
			List<Users> ulist = userLoginService.usersLook(null, null, null);
			if (ulist != null) {
				req.setAttribute("ulist", ulist);
				// System.out.println(ulist.toString());
				// System.out.println("锟介看锟缴癸拷");
				req.getRequestDispatcher("/UserLook.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("/BooksInfoSys/Datum.jsp");
			}
			break;
		/* 添加用户 */
		case "AddUser":
			/* 拿到页面input的name值*/
			String Aname = req.getParameter("name");
			String Apass = req.getParameter("password");
			String Asex = req.getParameter("accountr");
			String Aphone = req.getParameter("account");
			/* int Acount = Integer.valueOf(req.getParameter("Acount")); */
			/* 封装添加类 */
			Users user = new Users(Aname, Apass, Asex, Aphone);
			/* 取到数据库递回的结果 */
			int result = userLoginService.usersAdd(user);

			if (result > 0) {
				// req.setAttribute("ulist", ulist);
				/* 成功则进行页面跳转 */
				req.getRequestDispatcher("/UserLogin.jsp").forward(req, resp);
			} else {
				/* 失败 */
				// System.out.println("失锟斤拷");
				resp.sendRedirect("/UserLook.jsp");
			}
			break;
		/* 修改 */
		case "UpdateUsers":
			/*拿到页面input的name值 */
			int uid = Integer.valueOf(req.getParameter("uid"));
			String uname = req.getParameter("uname");
			// String upassword = req.getParameter("upassword");
			String usex = req.getParameter("usex");
			String uphone = req.getParameter("uphone");
			/* 封装修改类 */	
			Users users1 = new Users(uid, uname, usex, uphone);
			/* 接收返回值 */
			int resultCUD = userLoginService.usersChange(users1);
			if (resultCUD > 0) {
				// req.setAttribute("list", ulist);
				/* 成功，跳转 */
				req.getRequestDispatcher("/Users?type=UserLook").forward(req, resp);
				;
			} else {
				/* 失败 */
				resp.sendRedirect("/BooksInfoSys/Datum.jsp");
			}
			break;
		default:
			break;
		}
	}
}
