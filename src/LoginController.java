

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{	  
			   PrintWriter out=response.getWriter();
			   String uname=request.getParameter("uname");
			   String pwd=request.getParameter("pwd");
			   LoginDao logindao = new LoginDao();
			   String output = logindao.isValidateUser(uname, pwd);
			   
			   if(out.equals(""))
			   {
				   RequestDispatcher dispatcher;
				   dispatcher = request.getRequestDispatcher("Login.html");
				   out.append("invalid Username and passowrd");
				   dispatcher.include(request, response);
			   }
			   else
			   {
				   out.println(output+"\n");
			   }
		}
}
			   
			   
			   