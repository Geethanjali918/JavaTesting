package com.db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class StudentDetails
 */
@WebServlet("/StudentDetails")
public class StudentDetails extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

    
        Map<Integer, String> stdmap = new HashMap<Integer, String>();
        stdmap.put(id, name);

        out.print("Data added successfully--------------");
    }
}
