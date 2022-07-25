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

@WebServlet("/Details")
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("emailID");
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		try {
			Employee e = getEmployeeDetails(email);
			System.out.println(email);
						pw.print("<head>\n" + "\n" + "<meta charset=\"UTF-8\">\n" + "<title>Home Page</title>\n"
					+ "<!-- Latest compiled and minified CSS -->\n"
					+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n"

					+ "<!-- Latest compiled JavaScript -->\n"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\n"
					+ "</head>\n"

					+ "<body>\n" + "<div class=\"header\">\n"
					+ "<h1 style=\"text-align:center; background-color: blanchedalmond;\">Employee Details</h1>\n"
					+ "</div>\n" + "<div class=\"row\">\n"
					+ " <div class=\"card\" style=\"width:500px;margin-left:500px;margin-top:60px;\">\n"
					+ "<h2 class=\"bg-danger text-light card-header\">TimeSheet</h2>\n" + " <form action=\"form\">\n"
					+ " <table class=\"table table-hover table-striped table-responsive col-md-6\">\n" + " <tr>\n"
					+ " <td>Employee Name</td>\n" + "<td>" + e.getEmpName() + "</td>\n" + " </tr>\n" + "   <tr>	\n"
					+ "<td>Employee No</td>\n" + "<td>" + e.getEmpNo() + "</td>\n" + "</tr>\n" + " <tr>\n"
					+ " <td>Designation</td>\n" + "<td>" + e.getJob() + "</td>\n" + " </tr>\n" + "<tr>\n"
					+ " <td>Joining Date</td>\n" + "<td>" + e.getHireDate() + "</td>\n" + "</tr>\n" + " <tr>\n"
					+ "<td>Manager Id</td>\n" + "<td>" + e.getManagerId() + "</td>\n" + " </tr>\n" + " <tr>\n"
					+ " <td>Salary</td>\n" + " <td>" + e.getSalary() + "</td>\n" + "</tr>\n" + "<tr>\n"
					+ "<td>Commission</td>\n" + "<td>" + e.getCommision() + "</td>\n" + "  </tr>\n" + " <tr>\n"
					+ " <td>Department ID</td>\n" + " <td>" + e.getDeptNo() + "</td>\n" + " </tr>\n" + "</table>\n"
					+ "</form>\n" + "</div>\n" + "</div>\n" + "</body>\n");
					pw.println("<br><br><a class = 'btn btn-primary' href='HomePage' role='button' style='margin-left:600px;'>Home Page</a><br>");
					pw.println("<br><br><a class = 'btn btn-primary' href='Logout' role='button' style='float:right; margin-right:780px;'>Logout</a>");


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

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sudhanshu", "root", "1234");
	}

}
