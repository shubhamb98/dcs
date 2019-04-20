import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient {

	public static void main(String[] args) {

		Socket s = null;
		int serverPort = 8888;

		try {

			s = new Socket(args[0], serverPort);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());

			Scanner sc = new Scanner(System.in);
			System.out.print("Enter username: ");
			String username = sc.nextLine();

			out.writeUTF(username);
			String data = "";
			while(data != "exit") {

				data = sc.nextLine();
				out.writeUTF(data);
			}
		}
		catch(Exception e) {

			System.out.println(e);
		}
		finally {

			try {

				s.close();
			}
			catch(Exception e) {

				System.out.println(e);
			}
		}
	}
}