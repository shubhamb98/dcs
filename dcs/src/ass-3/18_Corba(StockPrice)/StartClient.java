import java.util.Scanner;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import StockApp.*;

public class StartClient {

	public static void main(String[] args) throws Exception
	{
		ORB orb = ORB.init(args, null);
	    org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
	    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	    Stock s1 = (Stock) StockHelper.narrow(ncRef.resolve_str("Stock"));
	    Scanner c=new Scanner(System.in);
	    while(true)
	    {
	    	System.out.println("********************************");
        	System.out.println("1.Get Stock Price");
        	System.out.println("2.close connection(exit)");
        	System.out.println("Enter ur choice");
        	int i=c.nextInt();
        	if(i==1)
        	{
        		String t=s1.getStock();
                System.out.println("Current Stocks are  "+t);
        	}
        	else if(i==2)
        	{
        		System.out.println("Close connection");
        		break;
        	}
        	else
        	{
        		System.out.println("Enter correct choice");
        	}
        
	    }
	}

}
