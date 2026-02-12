package com.db;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class TestingClass
 */
@WebServlet("/TestingClass")
public class TestingClass extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String branch=request.getParameter("branch");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306:stdetails","root", branch);
			System.out.println(con);
			
			PreparedStatement pst=con.prepareStatement("insert into student values(?,?)");
			pst.setString(1, name);
			pst.setString(2, branch);
			
			int count=pst.executeUpdate();
			
			System.out.println("updated:-->"+count);
			response.setContentType("text/html");
			response.getWriter().write("<h1>updated: rows -> </h1>"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
