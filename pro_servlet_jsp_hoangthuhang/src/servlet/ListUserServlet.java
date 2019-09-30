/**
 * Copyright(C) 2019 Luvina JSC
 * ListUserServlet.java, Sep 30, 2019, HangHT
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import model.UserLogic;

/**
 * @author HangHT
 *
 */
public class ListUserServlet extends HttpServlet{
	private UserLogic ul;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ul = new UserLogic();
			ArrayList<UserBean>lsUser = ul.getListUser();
			req.setAttribute("listUser", lsUser);
			RequestDispatcher rd = req.getRequestDispatcher("listUser.jsp");
			rd.forward(req, resp);
			System.out.println(lsUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("doget");
	}
}
