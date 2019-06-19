package moneyBank;
import java.sql.*;
public class databaseConnection 
{

     public Connection getConnection() throws Exception
     {		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
		return cn;
     }
		
}     
