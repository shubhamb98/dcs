import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import TransferApp.Transfer;
import TransferApp.TransferHelper;

public class StartServer_transfer_file
{
	public static void main(String args[]) throws Exception 
	{
	  	ORB orb = ORB.init(args, null);      
	      	POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	      	rootpoa.the_POAManager().activate();
	      
	      	Transfer_imp ti=new Transfer_imp();
	      	ti.setORB(orb);
	      
	      	org.omg.CORBA.Object ref = rootpoa.servant_to_reference(ti);
	      	Transfer href = TransferHelper.narrow(ref);
	      
	      	org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
	      	NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	 
	      	NameComponent path[] = ncRef.to_name( "Transfer" );
	      	ncRef.rebind(path, href);
	 	System.out.println("Addition Server ready and waiting ...");
		// wait for invocations from clients
	      	for (;;){
			orb.run();
	      	}
	}
}
