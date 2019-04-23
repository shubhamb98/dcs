import org.omg.CORBA.ORB;
import Bank.AccountPOA;
public class Bank_imp extends AccountPOA
{
	private ORB orb;
	public void setORB(ORB orb_val) {
	    	orb = orb_val; 
	}
	@Override
	public float getBalance() {
		return Customer.cut_bal;
		
	}
	@Override
	public void setBalance(float balance) {	
		Customer.cut_bal=Customer.cut_bal+balance;
	}
}
