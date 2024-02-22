import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/home")

public class SignupStore extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		Connection con;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			
		System.out.println("Connection is Established");
		
		String QUERY="INSERT INTO usersdetails(name, gmail, phone, password, degree, branch, yearOfPassing) "
				+ "VALUES(?,?,?,?,?,?,?)";
	   
		
		
		String name=req.getParameter("name");
		
		String gmail=req.getParameter("gmail");
		long phone=Long.parseLong(req.getParameter("phone"));
		String password=req.getParameter("password");
		String degree=req.getParameter("degree");
		String branch=req.getParameter("branch");
		int yearOfPassing =Integer.parseInt(req.getParameter("year"));
		
		try {
			PreparedStatement ps=con.prepareStatement(QUERY);
			
			ps.setString(1, name);
			ps.setString(2,gmail);
			ps.setLong(3, phone);
			ps.setString(4, password);
			ps.setString(5, degree);
			ps.setString(6, branch);
			ps.setInt(7,yearOfPassing );
			
			ps.executeUpdate();
			
         } catch (SQLException e1) {
			
		     }
			
		} catch (SQLException e) {
		
		} catch (ClassNotFoundException e) {
			
		}
		catch(NumberFormatException e) {} 
		
		PrintWriter w=res.getWriter();
		
		
		
		w.print("Successfully Inserted");
	}
}
