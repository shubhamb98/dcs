package dcs;

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
			out.writeUTF("Hello World!!");
//UTF is a string encoding; see Sec 4.3
			String data = in.readUTF();
			System.out.println("Received: " + data);
			s.close();
		}
		catch (Exception e) {
		System.out.println(e);
		}
		}
	}
