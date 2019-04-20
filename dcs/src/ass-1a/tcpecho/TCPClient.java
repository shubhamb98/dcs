import java.io.*;
import java.net.*;

public class TCPClient {

	public static void main(String[] args) {

		Socket s = null;
		int serverPort = 8888;

		try {

			s = new Socket(args[1], serverPort);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());

			out.writeUTF(args[0]);
			String data = in.readUTF();

			System.out.println("Received: " + data);
		}
		
		catch(Exception e) {

			System.out.println(e);
		}
		
		finally {

			if(s!=null) {
				try {

					s.close();
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}