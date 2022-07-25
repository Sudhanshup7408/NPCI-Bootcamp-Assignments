package com.payslip;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PayslipGeneration
 */
@WebServlet("/Payslip")
public class PayslipGeneration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayslipGeneration() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("emailID");

		response.setContentType("text/html");

		int month = Integer.parseInt(request.getParameter("month"));
		int year = Integer.parseInt(request.getParameter("year"));
		System.out.println(month);
		System.out.println(year);
		try {

			Employee e1 = getEmployeeDetails(email);
			int joinMonth = Integer.parseInt(e1.getHireDate().substring(3, 4));
			int joinYear = Integer.parseInt(e1.getHireDate().substring(6));
			System.out.println(joinMonth);
			System.out.println(joinYear);

			if ((month >= joinMonth) && (year >= joinYear)) {
				LocalDate date = LocalDate.now();
				int currMonth = date.getMonthValue();
				int currYear = date.getYear();
				System.out.println(currMonth);
				System.out.println(currYear);
				if (year < currYear) {
					YearMonth ym = YearMonth.of(year, month);
					int totaldays = ym.lengthOfMonth();
					int workday = getWorkDayDetails(month, year, email);

					float basic = ((e1.getSalary() / 2) / totaldays) * workday;
					float hRA = (((e1.getSalary() / 4) / totaldays) * workday);
					float oA = (((e1.getSalary() / 4) / totaldays) * workday);

					pw.println(
							"<a class = 'btn btn-primary' href='Logout' role='button' style='float: right'>Logout</a>");
					pw.println(
							"<a class = 'btn btn-primary' href='HomePage' role='button' style='float: left'>Home Page</a><br>");
					pw.print("<head>\n" + "<meta charset=\"UTF-8\">\n"
							+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
							+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
							+ "<title>Salary Slip</title>\n"
							+ "<link rel=\"icon\" href=\"https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200X200.png\" type=\"image/x-icon\">\n"
							+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
							+ "integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
							+ "<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"\n"
							+ "integrity=\"sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p\" crossorigin=\"anonymous\">\n"
							+ "</script>\n"
							+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js\"\n"
							+ "integrity=\"sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF\" crossorigin=\"anonymous\">\n"
							+ " </script>\n" + "</head>\n" + "<body>\n" + "<div>\n"
							+ "<div class=\"container mt-5 mb-5\">\n" + "<div class=\"row\">\n"
							+ " <div class=\"col-md-12\">\n" + " <div class=\"text-center lh-1 mb-2\">\n"
							+ "<h6 class=\"fw-bold\">Payslip</h6>\n"
							+ "<Forspan class=\"fw-normal\">Payment Slip</span>\n" + "</div>\n"
							+ " <div class=\"d-flex justify-content-end\"> <span>Working Branch: Hyderabad</span> </div>\n"
							+ " <div class=\"row\">\n" + "<div class=\"col-md-10\">\n" + "<div class=\"row\">\n"
							+ " <div class=\"col-md-6\">\n"
							+ "<div> <span class=\"fw-bolder\">EMP Name</span> <small class=\"ms-3\">" + e1.getEmpName()
							+ "</small>\n" + "</div>\n" + "</div>\n" + "<div class=\"col-md-6\">\n"
							+ " <div> <span class=\"fw-bolder\">EMP Code</span> <small class=\"ms-3\">" + e1.getEmpNo()
							+ "</small>\n" + "</div>\n" + " </div>\n" + "</div>\n" + "<div class=\"col-md-6\">\n"
							+ "<div> <span class=\"fw-bolder\">Work Days</span> <small class=\"ms-3\">" + workday
							+ "</small> </div>\n" + " </div>\n" + "</div>\n" + " <div class=\"row\">\n"
							+ "<div class=\"col-md-6\">\n"
							+ " <div> <span class=\"fw-bolder\">Month</span> <small class=\"ms-3\">" + month
							+ "</small> </div>\n" + "  </div>\n"
							+ "<div class=\"col-md-2\" style=\"margin-left: 80px;\">\n"
							+ "<div> <span class=\"fw-bolder\">Year</span> <small class=\"ms-3\">" + year + "</small>\n"
							+ " </div>\n" + "  </div>\n" + " </div>\n" + "  <div class=\"col-md-6\">\n"
							+ " <div> <span class=\"fw-bolder\">Ac No.</span> <small class=\"ms-3\">***</small></div>\n"
							+ "</div>\n" + "  <div class=\"col-md-6\">\n"
							+ " <div> <span class=\"fw-bolder\">Salary</span> <small class=\"ms-3\">" + e1.getSalary()
							+ "</small></div>\n" + " </div>\n" + "</div>\n"
							+ "<table class=\"mt-4 table table-bordered\">\n"
							+ " <thead class=\"bg-dark text-white\">\n" + "<tr>\n" + "<th scope=\"col\">Earnings</th>\n"
							+ "<th scope=\"col\">Amount</th>\n" + "<th scope=\"col\">Deductions</th>\n"
							+ " <th scope=\"col\">Amount</th>\n" + " </tr>\n" + "</thead>\n" + " <tbody>\n" + "<tr>\n"
							+ " <th scope=\"row\">Basic</th>\n" + "<td>" + basic + "</td>\n" + "<td>PF</td>\n" + " <td>"
							+ (float) (0.12 * basic) + "</td>\n" + "   </tr>\n" + " <tr>\n"
							+ " <th scope=\"row\">HRA</th>\n" + " <td>" + hRA + "</td>\n" + " </tr>\n" + " <tr>\n"
							+ "  <th scope=\"row\">OA</th>\n" + " <td>" + oA + "</td>\n" + " </tr>\n"
							+ "<tr class=\"border-top\">\n" + "<th scope=\"row\">Total Earning</th>\n" + "<td>"
							+ (float) (basic + hRA + oA) + "</td>\n" + " <td>Total Deductions</td>\n" + "<td>"
							+ (float) (0.12 * basic) + "</td>\n" + " </tr>\n" + "   </tbody>\n" + " </table>\n"
							+ "</div>\n" + " <div class=\"row\">\n"
							+ " <div class=\"col-md-4\"> <br> <span class=\"fw-bold\">Net Pay :"
							+ (float) ((basic + hRA + oA) - (0.12 * basic)) + "</span> </div>\n" + " </div>\n"
							+ "<div class=\"d-flex justify-content-end\">\n"
							+ "<div class=\"d-flex flex-column mt-2\"> <span class=\"fw-bolder\">NPCI</span> <span\n"
							+ "class=\"mt-4\">Authorised Signatory</span> </div>\n" + "</div>\n" + "</div>\n"
							+ "</div>\n" + "</div>\n" + "</div>\n" + "</body>\n" + "</html>\n");
				} else if (year == currYear) {
					if (month <= currMonth) {
						YearMonth ym = YearMonth.of(year, month);
						int totaldays = ym.lengthOfMonth();
						int workday = getWorkDayDetails(month, year, email);

						float basic = ((e1.getSalary() / 2) / totaldays) * workday;
						float hRA = (((e1.getSalary() / 4) / totaldays) * workday);
						float oA = (((e1.getSalary() / 4) / totaldays) * workday);
						pw.println(
								"<a class = 'btn btn-primary' href='Logout' role='button' style='float: right'>Logout</a>");
						pw.println(
								"<a class = 'btn btn-primary' href='HomePage' role='button' style='float: left'>Home Page</a><br>");
						pw.print("<head>\n" + "<meta charset=\"UTF-8\">\n"
								+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
								+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
								+ "<title>Salary Slip</title>\n"
								+ "<link rel=\"icon\" href=\"https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200X200.png\" type=\"image/x-icon\">\n"
								+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
								+ "integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
								+ "<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"\n"
								+ "integrity=\"sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p\" crossorigin=\"anonymous\">\n"
								+ "</script>\n"
								+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js\"\n"
								+ "integrity=\"sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF\" crossorigin=\"anonymous\">\n"
								+ " </script>\n" + "</head>\n" + "<body>\n" + "<div>\n"
								+ "<div class=\"container mt-5 mb-5\">\n" + "<div class=\"row\">\n"
								+ " <div class=\"col-md-12\">\n" + " <div class=\"text-center lh-1 mb-2\">\n"
								+ "<h6 class=\"fw-bold\">Payslip</h6>\n"
								+ "<Forspan class=\"fw-normal\">Payment Slip</span>\n" + "</div>\n"
								+ " <div class=\"d-flex justify-content-end\"> <span>Working Branch: Hyderabad</span> </div>\n"
								+ " <div class=\"row\">\n" + "<div class=\"col-md-10\">\n" + "<div class=\"row\">\n"
								+ " <div class=\"col-md-6\">\n"
								+ "<div> <span class=\"fw-bolder\">EMP Name</span> <small class=\"ms-3\">"
								+ e1.getEmpName() + "</small>\n" + "</div>\n" + "</div>\n"
								+ "<div class=\"col-md-6\">\n"
								+ " <div> <span class=\"fw-bolder\">EMP Code</span> <small class=\"ms-3\">"
								+ e1.getEmpNo() + "</small>\n" + "</div>\n" + " </div>\n" + "</div>\n"
								+ "<div class=\"col-md-6\">\n"
								+ "<div> <span class=\"fw-bolder\">Work Days</span> <small class=\"ms-3\">" + workday
								+ "</small> </div>\n" + " </div>\n" + "</div>\n" + " <div class=\"row\">\n"
								+ "<div class=\"col-md-6\">\n"
								+ " <div> <span class=\"fw-bolder\">Month</span> <small class=\"ms-3\">" + month
								+ "</small> </div>\n" + "  </div>\n"
								+ "<div class=\"col-md-2\" style=\"margin-left: 80px;\">\n"
								+ "<div> <span class=\"fw-bolder\">Year</span> <small class=\"ms-3\">" + year
								+ "</small>\n" + " </div>\n" + "  </div>\n" + " </div>\n"
								+ "  <div class=\"col-md-6\">\n"
								+ " <div> <span class=\"fw-bolder\">Ac No.</span> <small class=\"ms-3\">***</small></div>\n"
								+ "</div>\n" + "  <div class=\"col-md-6\">\n"
								+ " <div> <span class=\"fw-bolder\">Salary</span> <small class=\"ms-3\">"
								+ e1.getSalary() + "</small></div>\n" + " </div>\n" + "</div>\n"
								+ "<table class=\"mt-4 table table-bordered\">\n"
								+ " <thead class=\"bg-dark text-white\">\n" + "<tr>\n"
								+ "<th scope=\"col\">Earnings</th>\n" + "<th scope=\"col\">Amount</th>\n"
								+ "<th scope=\"col\">Deductions</th>\n" + " <th scope=\"col\">Amount</th>\n"
								+ " </tr>\n" + "</thead>\n" + " <tbody>\n" + "<tr>\n"
								+ " <th scope=\"row\">Basic</th>\n" + "<td>" + basic + "</td>\n" + "<td>PF</td>\n"
								+ " <td>" + (float) (0.12 * basic) + "</td>\n" + "   </tr>\n" + " <tr>\n"
								+ " <th scope=\"row\">HRA</th>\n" + " <td>" + hRA + "</td>\n" + " </tr>\n" + " <tr>\n"
								+ "  <th scope=\"row\">OA</th>\n" + " <td>" + oA + "</td>\n" + " </tr>\n"
								+ "<tr class=\"border-top\">\n" + "<th scope=\"row\">Total Earning</th>\n" + "<td>"
								+ (float) (basic + hRA + oA) + "</td>\n" + " <td>Total Deductions</td>\n" + "<td>"
								+ (float) (0.12 * basic) + "</td>\n" + " </tr>\n" + "   </tbody>\n" + " </table>\n"
								+ "</div>\n" + " <div class=\"row\">\n"
								+ " <div class=\"col-md-4\"> <br> <span class=\"fw-bold\">Net Pay :"
								+ (float) ((basic + hRA + oA) - (0.12 * basic)) + "</span> </div>\n" + " </div>\n"
								+ "<div class=\"d-flex justify-content-end\">\n"
								+ "<div class=\"d-flex flex-column mt-2\"> <span class=\"fw-bolder\">NPCI</span> <span\n"
								+ "class=\"mt-4\">Authorised Signatory</span> </div>\n" + "</div>\n" + "</div>\n"
								+ "</div>\n" + "</div>\n" + "</div>\n" + "</body>\n" + "</html>\n");
					}
				} else {
					pw.println("Failed!! to generate");

					pw.println(
							"<a class = 'btn btn-primary' href='Logout' role='button' style='float: right'>Logout</a>");
				}
			} else {
				pw.println("Failed !! to generate");

				pw.println("<a class = 'btn btn-primary' href='Logout' role='button' style='float: right'>Logout</a>");
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

	public int getWorkDayDetails(int month, int year, String email) throws ClassNotFoundException, SQLException {

		Connection connect = getConnection();
		PreparedStatement ps = connect.prepareStatement(
				"select workingdays from workingdays where month = ? and year = ? and EmpNo = (Select EmpNo from LoginCredentials where emailID = ?)");
		ps.setInt(1, month);
		ps.setInt(2, year);
		ps.setString(3, email);

		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return rs.getInt(1);
		return 0;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sudhanshu", "root", "1234");
	}

}
