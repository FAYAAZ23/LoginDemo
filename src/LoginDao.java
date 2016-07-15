
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;  
  
public class LoginDao { 
	String s;
public String isValidateUser(String uname,String pwd){  
  
try
{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection("jdbc:oracle:thin:system/Zahara2323@localhost:1521:orcl");  
      
Statement st =con.createStatement(); 
System.out.println("Connection Established successfully..");  

      
ResultSet rs=  st.executeQuery("Select *from registeruser where UNAME='"+uname+"'and PASSWORD='"+pwd+"'");  
while (rs.next()){
	s="First name:"+rs.getString(1)+"\nLast name:"+rs.getString(2)+"\nUsername:"+rs.getString(3)+"\nEmail:"+rs.getString(4);
}
          
}
catch(Exception e)
{
	e.printStackTrace();
	}  
return s;  
}  
} 

