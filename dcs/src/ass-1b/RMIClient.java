import java.io.*;
import java.rmi.*;
import java.net.*;

public class RMIClient {

	public static void main(String[] args) throws Exception {

		try {

			String s = "rmi://localhost/palin";
			one onex = (one)Naming.lookup(s);
			int ans = onex.palin("ada");
			System.out.println("Print: " + ans);

			if(ans==1) {

				System.out.println("The given string is palindrome");
			}
			else {

				System.out.println("The given string is not palindrome");
			}
		}
		catch(Exception e) {

			System.out.println(e);
		}
	}
}