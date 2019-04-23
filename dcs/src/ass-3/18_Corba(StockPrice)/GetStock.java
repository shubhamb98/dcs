import org.omg.CORBA.ORB;

import StockApp.StockPOA;

public class GetStock extends StockPOA
{
	private ORB orb;
	 
	  public void setORB(ORB orb_val) {
	    orb = orb_val; 
	  }
	public String getStock()
	{
		String s= "Wipro Stock is 75% \t TCS stock is 98%";
		return s;
	}

}
