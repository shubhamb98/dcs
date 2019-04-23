import java.time.LocalTime;
import org.omg.CORBA.ORB;
import TimeApp.*;
public class GetTime extends TimeServerPOA
{ 
	private ORB orb;
	public void setORB(ORB orb_val) {
		orb = orb_val; 
	}
	public String getTime() 
	{
	    	LocalTime t=LocalTime.now();
	    	String time=t.toString();
		return time;
	}

}
