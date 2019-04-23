import org.omg.CORBA.ORB;//map omg corba to java
import org.omg.CORBA.ORBPackage.InvalidName;//exception
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;//provided class make portable
import StockApp.*;
import StockApp.StockHelper;


public class StartServer 
{
	public static void main(String[] args) throws Exception 
	{
		ORB orb = ORB.init(args, null);   //null = properties   //initialization
	      	POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      		//rootpoa manage by orb
		rootpoa.the_POAManager().activate();//new poa manager due to activate
		GetStock gs=new GetStock();
       	        gs.setORB(orb);//servent cteate
		org.omg.CORBA.Object ref = rootpoa.servant_to_reference(gs);
   		//get obj ref from servent
		Stock href = StockHelper.narrow(ref);//obj ref from servent
	 	org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
	      	NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);//root naming context
	 	NameComponent path[] = ncRef.to_name( "Stock" );
		ncRef.rebind(path, href);
	 	System.out.println("Addition Server ready and waiting ...");
	        for(;;)
	        {
	    		orb.run();
	        }
	}
}
