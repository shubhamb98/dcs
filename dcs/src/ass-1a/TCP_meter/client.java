package TCP_meter;

import java.util.Scanner;
import java.net.*;
import java.io.*;

public class client {
	public static void main(String args[]) {
//arguments supply message and hostname of destination
		Socket s = null;
		try {
			int serverPort = 7896;
			s = new Socket("localhost", serverPort);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter Feet:");
			float feet=sc.nextFloat();
			out.writeFloat(feet);
//UTF is a string encoding; see Sec 4.3
			float meter = in.readFloat();
			System.out.println("Meter: " + meter);
			s.close();
		}
		catch (Exception e) {
		System.out.println(e);
		}
		}
	}

