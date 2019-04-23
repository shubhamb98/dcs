import java.util.Scanner;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import TransferApp.Transfer;
import TransferApp.TransferHelper;
import TransferApp.TransferOperations;
public class StartClient 
{
	public static void main(String[] args) throws Exception 
	{
		ORB orb = ORB.init(args, null);
	    	org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
	    	NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	    	TransferOperations trans = (TransferOperations) TransferHelper.narrow(ncRef.resolve_str("Transfer"));
	    	Scanner sc=new Scanner(System.in);
	    	while(true)
	    	{
	    		System.out.println("***********************************");
	    		System.out.println("1.Download file");
	    		System.out.println("2.Transfer file");
	    		System.out.println("3.exit");
	    		System.out.println("Enter ur choice ");
	    		int i=sc.nextInt();
	    		if(i==1)
	    		{
	    			System.out.println("1.dept_File");
	    			System.out.println("2.Student_file");
	    			System.out.println("3.Teacher_file");
	    			System.out.println("Enter ur choice ");
		    		int j=sc.nextInt();
		    		String s = null;
		    		if(j==1){
		    		 	s="dept";	
		    		}
				else if(j==2){
		    		 	s="student";
		    		}
		  		else if(j==3){
		    		 	s="Teacher";
		    		}
		    		else 
		    			System.out.println("Wrong Choice");
		    			System.out.println(trans.transfer(s));
		    	}
	    		else if(i==2){
	    			sc.nextLine();
	    			System.out.println("Enter path of file ");
	    			String s1=sc.nextLine();
	    			if(trans.fileCreate(s1))
	    				System.out.println("File Transfer Successfully");
	    			else
	    				System.out.println("File is not Transfer Successfully");
	    		}
	    		else if(i==3){
	    			trans.shutdown();
	    			System.out.println("Connection closed");
	    		}
	    	}
	}
}
