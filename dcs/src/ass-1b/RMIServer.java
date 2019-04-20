import java.io.*;
import java.net.*;
import java.rmi.*;

public class RMIServer {

	public static void main(String[] args) throws Exception {

		try {

			two twox = new two();
			Naming.bind("palin", twox);
			System.out.println("Object registered");
		}
		catch(Exception e) {

			System.out.println(e);
		}
	}
}