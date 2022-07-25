package com.payslip;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("emailID");
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String name;
		
		try {
			name = getEmployeeName(email);
			pw.println("Welcome, " + name);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.html");
			dispatcher.include(request, response);
			
			pw.println("<br><br><a href='Details' style='margin-left:80px;'>Employee Details</a>");
			pw.println("<a class = 'btn btn-primary' href='Logout' role='button' style='margin-bottom:80px; margin-left:500px;'>Logout</a>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getEmployeeName(String email) throws SQLException, ClassNotFoundException {
		
		Connection connect = getConnection();
		PreparedStatement ps = connect.prepareStatement("select EmpName from Employee where EmpNo = (Select EmpNo from LoginCredentials where emailID = ?)");
		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			return  rs.getString(1);
		return null;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sudhanshu", "root", "1234");
	}

}
