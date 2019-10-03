/**
 * Copyright(C) 2019 Luvina JSC
 * ErrorControllerServlet.java, Oct 1, 2019, HangHT
 */
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author HangHT
 *
 */
public class ErrorControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("error", req.getParameter("errdetail"));
		RequestDispatcher rd = req.getRequestDispatcher("jsp/showerror.jsp");
		rd.forward(req, resp);
	}
}
