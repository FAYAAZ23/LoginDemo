

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String n=request.getParameter("UName");  
		String p=request.getParameter("Password");  
		String e=request.getParameter("Email");  
		String c=request.getParameter("Country");  
		          
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection( "jdbc:oracle:thin:system/Zahara2323@localhost:1521:orcl");  
		  
		PreparedStatement ps=con.prepareStatement(  
		"insert into registeruser values(?,?,?,?)");  
		  
		ps.setString(1,n);  
		ps.setString(2,p);  
		ps.setString(3,e);  
		ps.setString(4,c);  
		          
		int i=ps.executeUpdate();  
		if(i>0)  
		out.print("You are successfully registered...");  
		      
		          
		}
		catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		}  
		  
		}  
