import org.omg.CORBA.ORB;
import Interest.RatesPOA;
public class Intrest_imp extends RatesPOA
{
	private ORB orb;
	public void setORB(ORB orb_val) {
	    orb = orb_val; 
	}
	@Override
	public float getHomeLoan() {
		float f=12.3f;
		return f;
	}
	@Override
	public float getPersonalLoan() {
		float f=9.89f;
		return 0;
	}
	@Override
	public float getCarLoan() {
		float f=10.23f;
				return f;
	}
	@Override
	public float getGoldLoan() {
		float f=11.90f;
		return 0;
	}
}
