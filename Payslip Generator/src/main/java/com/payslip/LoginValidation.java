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

@WebServlet("/LoginValidation")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginValidation() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String emailID = request.getParameter("emailID");
		String password = request.getParameter("pswd");
		
		try {
			if(validate(emailID, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("emailID", emailID); // email = emailID
				response.sendRedirect("HomePage");
			}
			else {
				out.print("<script type=\"text/javascript\">alert(\"Invalid Credentials!!\");</script>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.include(request, response);
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean validate(String emailID, String password) throws SQLException, ClassNotFoundException {
		
		Connection connect = getConnection();
		PreparedStatement p = connect.prepareStatement("select emailID , password from LoginCredentials where emailID = ? and password = ?;");
		p.setString(1, emailID);
		p.setString(2, password);
		
		ResultSet r = p.executeQuery();
		if(r.next())
			return true;
		
		return false;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sudhanshu","root","1234");
	}

}

