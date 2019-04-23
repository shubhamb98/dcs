import java.util.Scanner;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import TimeApp.TimeServer;
import TimeApp.TimeServerHelper;

public class StartClient 
{
	public static void main(String[] args) throws Exception
	{
		ORB orb = ORB.init(args, null);
	    	org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
	    	NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	    	TimeServer gt = (TimeServer)TimeServerHelper.narrow(ncRef.resolve_str("TimeServer1"));
	    	Scanner c=new Scanner(System.in);
        	System.out.println("Welcome to the ServerTime system:"); 
        	while(true)
        	{
        		System.out.println("********************************");
        		System.out.println("1.getTime");
        		System.out.println("2.close connection(exit)");
        		System.out.println("Enter ur choice");
        		int i=c.nextInt();
        		if(i==1)
        		{
        			String t=gt.getTime();
                		System.out.println("Cureent Time of Server "+t);
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
