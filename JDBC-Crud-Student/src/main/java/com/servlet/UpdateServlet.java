package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.Renderer;

import com.conn.DBConnect;
import com.dao.StudentDao;
import com.entity.Student;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		String qualification=req.getParameter("qualification");
		String email=req.getParameter("email");
		int id=Integer.parseInt(req.getParameter("id"));
		
		Student student=new Student(id,name,dob,address,qualification,email);
		
		StudentDao dao=new StudentDao(DBConnect.getConn());
		HttpSession session=req.getSession();
		boolean f= dao.updateStudent(student);
		
		if(f)
		{
			session.setAttribute("sucMsg", "data updated");
			resp.sendRedirect("index.jsp");
			//System.out.println("data inserted");
		}
		else {
			session.setAttribute("errorMsg", "update servlet issue");
			resp.sendRedirect("index.jsp");
			//System.out.println("Register servlet problem");
		
	}

	}
}
