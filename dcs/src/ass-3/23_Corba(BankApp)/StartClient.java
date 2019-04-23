import java.util.Scanner;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import Bank.Account;
import Bank.AccountHelper;
import Bank.CheckingsAccount;
import Bank.CheckingsAccountHelper;
public class StartClient{
	public static void main(String[] args) throws Exception 
	{
		ORB orb = ORB.init(args, null);
	    	org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
	    	NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	    	Account account = (Account) AccountHelper.narrow(ncRef.resolve_str("Account"));
	    
	   	 //NamingContextExt ncRef1 = NamingContextExtHelper.narrow(objRef);
	    	CheckingsAccount ca = (CheckingsAccount) CheckingsAccountHelper.narrow(ncRef.resolve_str("Account1"));
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("Open New Acoount");
	    	System.out.println("Enter Account holder Name: ");
	    	String name=sc.nextLine();
	    	System.out.println("Enter Amount: ");
	    	float amt=sc.nextFloat();
	    	ca.create(name, amt);
	    	while(true){
	    		System.out.println("1.Credit");
	    		System.out.println("2.Debit");
	    		System.out.println("3.Check Balance");
	    		System.out.println("4.exit");
	        	System.out.println("Enter ur choice");
	        	int i=sc.nextInt();
	        	if(i==1){	
	        		System.out.println("Enter Amount to credit ");
	        		float am=sc.nextFloat();
	        		ca.credit(name, am);
	        	}
	        	else if(i==2){
	        		System.out.println("Enter Amount to debit ");
	        		float am=sc.nextFloat();
	        		ca.debit(name, am);
	        	}
	        	else if(i==3){
	        		float f=account.getBalance();
	        		System.out.println("Your Current Balance is: "+f);
	        	}
	        	else if(i==4){
	        		System.out.println("Close Connection");
	        		break;
	        	}	
	        	else{
	        		System.out.println("Wrong choice");
	        	}
	    	}
	}
}
