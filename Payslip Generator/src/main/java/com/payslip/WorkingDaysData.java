package com.payslip;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WorkingDaysData
 */
@WebServlet("/WorkingDaysData")
public class WorkingDaysData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkingDaysData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("emailID");

		response.setContentType("text/html");
		
		int day = Integer.parseInt(request.getParameter("day"));
		int month = Integer.parseInt(request.getParameter("month"));
		int year = Integer.parseInt(request.getParameter("year"));
		
		try {
			if(isWorkDayDetailsInserted(month, year, email)){
				pw.println("Details are already Present");
				pw.println("<a class = 'btn btn-primary' href='HomePage' role='button' style='float: right'>Back to Timesheet </a><br>");
				pw.println(" ");
				pw.println("<a class = 'btn btn-primary' href='Logout' role='button' style='float: right'>Logout</a>");
			}
			else if(isJoiningInvalid(month, year, email)) {
				pw.println("You can't enter details before joining date.");
				pw.println("<a class = 'btn btn-primary' href='Logout' role='button' style= margin-left:1000px;'>Logout</a><br>");
				
				pw.println("<a class = 'btn btn-primary' href='HomePage' role='button' style=margin-left:1200px;'>Back to Timesheet</a>");
				
			}
			else {
				Employee e1 = getEmployeeDetails(email);
				Connection connect = getConnection();
				
				PreparedStatement ps1 = connect.prepareStatement("insert into workingdays values(?,?,?,?);");
				ps1.setInt(1, e1.getEmpNo());
				ps1.setInt(2, month);
				ps1.setInt(3, year);
				ps1.setInt(4, day);
				ps1.executeUpdate();
				pw.println("Details updated Succesfully.");	
				pw.println("<a class = 'btn btn-primary' href='HomePage' role='button' style= margin-left:1000px;'>HomePage</a><br>");
				pw.println("<a class = 'btn btn-primary' href='HomePage' role='button' style= margin-left:1200px;>Generate PaySlip</a><br>");
				pw.println("<a class = 'btn btn-primary' href='Logout' role='button' style= margin-left:1400px;'>Logout</a><br>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Employee getEmployeeDetails(String email) throws ClassNotFoundException, SQLException {

		Connection connect = getConnection();
		PreparedStatement ps = connect.prepareStatement(
				"select * from Employee where EmpNo = (Select EmpNo from LoginCredentials where emailID = ?)");
		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getInt(6), rs.getInt(7), rs.getInt(8));
		return null;
	}
	
	public boolean isWorkDayDetailsInserted(int month, int year, String email) throws ClassNotFoundException, SQLException {

		Connection connect = getConnection();
		PreparedStatement ps = connect.prepareStatement(
				"select workingdays from workingdays where month = ? and year = ? and EmpNo = (Select EmpNo from LoginCredentials where emailID = ?)");
		ps.setInt(1, month);
		ps.setInt(2, year);
		ps.setString(3, email);

		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return true;
		return false;
	}
	
	public boolean isJoiningInvalid(int month, int year, String email) throws ClassNotFoundException, SQLException {
		
		Employee e1 = getEmployeeDetails(email);
		int joinMonth = Integer.parseInt(e1.getHireDate().substring(3,4));
		int joinYear = Integer.parseInt(e1.getHireDate().substring(6));
		
		
		if((month <= joinMonth) && (year <= joinYear)) {
			return true;
		}
		return false;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sudhanshu", "root", "1234");
	}

}
