import java.rmi.*;
import java.rmi.server.*;
import java.lang.*;

public class two extends UnicastRemoteObject implements one {

	public two() throws RemoteException { }

	public int palin(String a) throws RemoteException {

		StringBuffer str1 = new StringBuffer(a);
		String str2 = str1.toString();
		System.out.println("Print: " + str2);

		StringBuffer str3 = str1.reverse();
		int ans = str2.compareTo(str3.toString());
		System.out.println("Print: " + ans);

		if(ans==0)
			return 1;
		else
			return 0;
	}
}