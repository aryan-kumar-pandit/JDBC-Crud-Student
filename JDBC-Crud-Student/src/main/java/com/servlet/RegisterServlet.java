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
import com.entity.Student;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		String qualification=req.getParameter("qualification");
		String email=req.getParameter("email");
		
		Student student=new Student(name,dob,address,qualification,email);
		
		StudentDao dao=new StudentDao(DBConnect.getConn());
		HttpSession session=req.getSession();
		boolean f= dao.addStudent(student);
		
		if(f)
		{
			session.setAttribute("sucMsg", "data inserted");
			resp.sendRedirect("add_student.jsp");
			//System.out.println("data inserted");
		}
		else {
			session.setAttribute("errorMsg", "Register servlet problem");
			resp.sendRedirect("add_student.jsp");
			//System.out.println("Register servlet problem");
		}
	}

}
