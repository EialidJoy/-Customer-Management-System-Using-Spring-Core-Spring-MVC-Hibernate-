package com.eialid.testDatabase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class testDatabaseServlet
 */
@WebServlet("/testDatabaseServlet")
public class testDatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public testDatabaseServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username="hbstudent";
		String password="hbstudent";
		
		String url="jdbc:mysql://localhost:3306/web_customer_tracker?useSSl=false";
		String driver="com.mysql.jdbc.Driver";
		try {
			PrintWriter out=response.getWriter();
			
			Class.forName(driver);
			Connection myConn=DriverManager.getConnection(url, username, password);
			
			System.out.println("connection succesfull!!!");
			myConn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
	}

}
