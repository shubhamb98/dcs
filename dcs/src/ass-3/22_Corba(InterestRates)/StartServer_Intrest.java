import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import Interest.Rates;
import Interest.RatesHelper;

public class StartServer_Intrest 
{
	public static void main(String[] args) throws Exception
	{
		ORB orb = ORB.init(args, null);   
	      	POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));//proper type
		rootpoa.the_POAManager().activate();//activate object
		Intrest_imp ir=new Intrest_imp();
          	ir.setORB(orb);
          	org.omg.CORBA.Object ref = rootpoa.servant_to_reference(ir);
          	Rates rate=RatesHelper.narrow(ref);//activate
          
		org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");//naming context
          	NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
     		NameComponent path[] = ncRef.to_name( "Intrest" );//name to object
		ncRef.rebind(path, rate);
     
          	System.out.println("Addition Server ready and waiting ...");
     		// wait for invocations from clients
          	for (;;){
    	  		orb.run();
          	}
	}
}
