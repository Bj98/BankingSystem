package moneyBank;
import java.util.*;
public class mainBank 
{
 public static void main(String args[])throws Exception
 {
	Scanner z=new Scanner(System.in);	
	int choice;
	do
	{
	System.out.println("MENU\n\nWhat you want to do?\tChoice Number\nCREATE ACCOUNT\t\t\t1\nDEPOSITE\t\t\t2\nATM\t\t\t\t3\nEXIT\t\t\t\t4");
    System.out.println("\nEnter your choice number:");
    choice=z.nextInt();
    switch(choice)
    {
    case 1:
    	accountingWork a=new accountingWork();
    	a.createAccount();
    	break;
    case 2:
    	accountingWork b=new accountingWork();
    	b.depositeMoney();
    	break;
    case 3:
    	atmWork c=new atmWork();
    	c.atmWorking();
    	break;
    case 4:
    	System.exit(0);
        break;
    }
	}while(choice<7);
    
 }
}
