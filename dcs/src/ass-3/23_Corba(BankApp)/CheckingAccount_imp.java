import org.omg.CORBA.ORB;
import Bank.Account;
import Bank.CheckingsAccountPOA;
public class CheckingAccount_imp extends CheckingsAccountPOA
{
	private ORB orb;
	public void setORB(ORB orb_val) {
	    	orb = orb_val; 
	}
	@Override
	public void open(String name){
	    Customer.name=name;		
	}

	@Override
	public  void create(String name, float balance) {
		Customer.name=name;
		Customer.cut_bal=balance;
	}

	@Override
	public void credit(String name, float amount) {
		Customer.name=name;
		Customer.cut_bal=Customer.cut_bal+ amount;
	}

	@Override
	public void debit(String name, float amount) {
		Customer.name=name;
		Customer.cut_bal=Customer.cut_bal-amount;
	}
}
