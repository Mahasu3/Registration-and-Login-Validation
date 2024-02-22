import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkusers")
public class  CheckUsernameAndPassword extends HttpServlet{

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");

			//System.out.println("connection ok");

			String gmail1=req.getParameter("gmail");
			String password1 = req.getParameter("password");

			// System.out.println("hello"+" " +gmail1);

			String query="SELECT name,gmail,password FROM usersdetails";

			Statement s=con.createStatement();
			ResultSet r2  =   s.executeQuery(query);





			boolean flag=false;
			String name="";
			while(r2.next()==true) {
				if(gmail1.equals(r2.getObject("gmail")) && password1.equals(r2.getObject("password"))) 
				{


					flag=true;
					name=(String) r2.getObject("name");
				}

			}


			if (flag) {
				// Redirect to welcome.html with name parameter
				resp.sendRedirect("welcome.html?name=" + name);
			} else {
				// Redirect to error.html
				resp.sendRedirect("Error.html");
			}

		} catch (SQLException e1) {
			e1.printStackTrace(); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); 
		}



	}



}




