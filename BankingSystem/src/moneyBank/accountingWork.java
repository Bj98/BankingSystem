package moneyBank;
import java.util.*;
import java.sql.*;


public class accountingWork {

	public void createAccount()throws Exception
	{
		int n=0,an=0,pin=0,deposite=0;
		Scanner z=new Scanner(System.in);
		Random rd=new Random();
		System.out.println("Lets fill up the form!");
		Connection cn=new databaseConnection().getConnection();
		Statement stat=cn.createStatement();
		String query="select AccountNumber from bankingdetails";
		ResultSet rs=stat.executeQuery(query);
		label:
			do
			{
				n=rd.nextInt(10000000)+10000000;
				while(rs.next())
				{	
				an=rs.getInt("AccountNumber");
				if(an==n)
					continue label;
				}
			}while(an==n);
		System.out.println("The ACCOUNT NUMBER selected for you is:"+n);
		System.out.println("Enter your first name:");
		String fname=z.nextLine();
		System.out.println("Enter your last name:");
		String lname=z.nextLine();
		System.out.println("Enter your phone number:");
		String pnum=z.nextLine();
		System.out.println("Enter your address:");
		String add=z.nextLine();
		System.out.println("Enter 4 digit ATM PIN NUMBER:");
		pin=z.nextInt();
		String sql="INSERT INTO bankingdetails(AccountNumber,FirstName,LastName,PhoneNumber,Address,ATM_PIN) VALUES ("+n+",'"+fname+"','"+lname+"','"+pnum+"','"+add+"',"+pin+")";
		stat.executeUpdate(sql);
	}
	public void depositeMoney() throws Exception
	{
		int y=0,t,d,i=1;
		Connection cn=new databaseConnection().getConnection();
		Statement stat=cn.createStatement();
		Scanner z=new Scanner(System.in);
		do {
		System.out.println("Enter your account number:");
		int n=z.nextInt();
		String query="select * from bankingdetails";
		ResultSet rs=stat.executeQuery(query);
		Boolean hasNext=rs.next();
		while(hasNext)
		{
			int an=rs.getInt("AccountNumber");
			if(an==n)
			{
				System.out.println("Deposite amount:");
				d=z.nextInt();
				query="select * from bankingdetails where AccountNumber="+an+"";
		       rs=stat.executeQuery(query);
				rs.next();
				t=rs.getInt("Balance");
				y=t+d;
				String sql="update bankingdetails set Balance="+y+",Latest_Deposite_Amount="+d+" where AccountNumber="+n+"";
				stat.executeUpdate(sql);
				i=4;
				break;
					
			}
			else {
				hasNext=rs.next();
				if(!hasNext) 
				{
				i++;
				System.out.println("Wrong account number.Try again.");
				}
				if(i==4)
					System.out.println("Reached maximum time.");
			}
			
		}
			
			
		}while(i<4);
		
	  	
		
		
		
		
		
		
	}

}
