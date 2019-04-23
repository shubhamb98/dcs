import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import Bank.Account;
import Bank.AccountHelper;
import Bank.CheckingsAccount;
import Bank.CheckingsAccountHelper;

public class StartServer
{
	public static void main(String args[]) throws Exception
	{
		ORB orb = ORB.init(args, null);      
	      	POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	      	rootpoa.the_POAManager().activate();
	      
	      	Bank_imp bi=new Bank_imp();
	      	bi.setORB(orb);
	      
	      	CheckingAccount_imp  ci=new CheckingAccount_imp();
	      	ci.setORB(orb);
	      
	      
	      	org.omg.CORBA.Object ref = rootpoa.servant_to_reference(bi);
	      	Account href = AccountHelper.narrow(ref);
	 
	      	org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
	      	NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	 
	      	NameComponent path[] = ncRef.to_name( "Account" );
	      	ncRef.rebind(path, href);
	  
	      	org.omg.CORBA.Object ref1 = rootpoa.servant_to_reference(ci);
	      	CheckingsAccount href1 = CheckingsAccountHelper.narrow(ref1);
	 
	      	org.omg.CORBA.Object objRef1 =  orb.resolve_initial_references("NameService");
	      	NamingContextExt ncRef1 = NamingContextExtHelper.narrow(objRef);
	 
	      	NameComponent path1[] = ncRef.to_name( "Account1" );
	 
	  	ncRef.rebind(path1, href1);
	  	System.out.println("Server ready and waiting ...");
	  	for (;;){
		  	orb.run();
	      	}
	}
}
