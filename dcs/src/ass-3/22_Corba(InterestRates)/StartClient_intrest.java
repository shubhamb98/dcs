import java.util.Scanner;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import Interest.Rates;
import Interest.RatesHelper;
public class StartClient_intrest
{
	public static void main(String[] args) throws Exception
	{
		ORB orb = ORB.init(args, null);
	    	org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
	    	NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	    	Rates rate = (Rates) RatesHelper.narrow(ncRef.resolve_str("Intrest"));//proper type
	    	Scanner sc=new Scanner(System.in);
	    	while(true)
	    	{
	    		System.out.println("1.Home Loan");
	    		System.out.println("2.Car Loan");
	    		System.out.println("3.Personal Loan");
	    		System.out.println("4.Gold Loan");
	    		System.out.println("5.exit");
	    		System.out.println("Enter ur choice");
	    		int i;
	    		i=sc.nextInt();
	    		if(i==1){
	    			float f=rate.getHomeLoan();
	    			System.out.println("Intrest rate of Home Loan: "+f+"%");
	    		}
	    		else if(i==2){
	    			float f=rate.getCarLoan();
	    			System.out.println("Intrest rate of Car Loan: "+f+"%");
	    		}
	    		else if(i==3){
	    			float f=rate.getPersonalLoan();
	    			System.out.println("Intrest rate of Personal Loan: "+f+"%");
	    		}
	    		else if(i==4){
	    			float f=rate.getGoldLoan();
	    			System.out.println("Intrest rate of Gold Loan: "+f+"%");
	    		}
	    		else if(i==5){
	    			System.out.println("Connection close");
	    			break;
	    		}
	    		else{
	    			System.out.println("Wrong Chioce");
	    		}
	    }	    
	}
}
