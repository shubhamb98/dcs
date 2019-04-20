package TCP_degree;


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
			System.out.println("Enter Degrees:");
			float degree=sc.nextFloat();
			out.writeFloat(degree);
//UTF is a string encoding; see Sec 4.3
			float rad = in.readFloat();
			System.out.println("Radian: " + rad);
			s.close();
		}
		catch (Exception e) {
		System.out.println(e);
		}
		}
	}

