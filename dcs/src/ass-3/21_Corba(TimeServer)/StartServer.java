import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import TimeApp.*;
import TimeApp.TimeServerHelper;
import TimeApp.TimeServerPOA;

public class StartServer {
	public static void main(String[] args) throws Exception
	{
		ORB orb = ORB.init(args, null);      
	      	POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	      	rootpoa.the_POAManager().activate();
	      	GetTime gt=new GetTime();
	      	gt.setORB(orb);
	      
	      	org.omg.CORBA.Object ref = rootpoa.servant_to_reference(gt);
	      	TimeServer href = TimeServerHelper.narrow(ref);
	 
	      	org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
	      	NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	      	NameComponent path[] = ncRef.to_name( "TimeServer1" );
	      	ncRef.rebind(path, href);
	      	System.out.println("Addition Server ready and waiting ...");
	      
	      	for (;;){
		  	orb.run();
	      	}
	}

}
