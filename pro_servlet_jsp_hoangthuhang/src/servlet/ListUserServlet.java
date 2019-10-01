/**
 * Copyright(C) 2019 Luvina JSC
 * ListUserServlet.java, Sep 30, 2019, HangHT
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import model.UserDatabase;

/**
 * Servlet lấy danh sách user từ DB
 * @author HangHT
 *
 */
public class ListUserServlet extends HttpServlet{
	private UserDatabase userdb;
	
	@Override
	/**
	 * Ghi đè phương thức doGet của Servlet
	 * @param req: Yêu cầu của user
	 * @param resp: Câu trả lời của server
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			userdb = new UserDatabase();
			ArrayList<UserBean>lsUser = userdb.getListUser();
			// server lưu giá trị lsUser trên request
			// lưu trên session = cách req.getSession() => ss.setAttribute
			req.setAttribute("listUser", lsUser);
			RequestDispatcher rd = req.getRequestDispatcher("listUser.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			resp.sendRedirect("error?errdetail=" + e);
			e.printStackTrace();
		}
	}
}
