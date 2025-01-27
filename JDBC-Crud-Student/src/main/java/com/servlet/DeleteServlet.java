package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.StudentDao;

@WebServlet("/delete_student")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		StudentDao dao = new StudentDao(DBConnect.getConn());
		HttpSession session = req.getSession();
		boolean f = dao.deleteStudent(id);

		if (f) {
			session.setAttribute("sucMsg", "data deleted");
			resp.sendRedirect("index.jsp");
			// System.out.println("data inserted");
		} else {
			session.setAttribute("errorMsg", "Delete servlet problem");
			resp.sendRedirect("index.jsp");
			// System.out.println("Register servlet problem");
		}

	}
}
