import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) {

		ServerSocket s = null;
		int serverPort = 8888;

		try {

			s = new ServerSocket(serverPort);

			while(true) {
				Socket clientSocket = s.accept();
				Connection c = new Connection(clientSocket);
			}
		}
		catch(Exception e) {

			System.out.println(e);
		}
	}
}

class Connection extends Thread {

	Socket clientSocket;
	DataInputStream in;
	DataOutputStream out;

	Connection(Socket aClientSocket) {

		clientSocket = aClientSocket;

		try {

			in = new DataInputStream(aClientSocket.getInputStream());
			out = new DataOutputStream(aClientSocket.getOutputStream());
			this.start();
		}
		catch(Exception e) {

			System.out.println(e);
		}
	}

	public void run() {

		try {
			String clientName = in.readUTF();
			String data = "";
			while(data!="exit") {

				data = in.readUTF();
				System.out.println(clientName + ": " + data);
			}
			clientSocket.close();
		}
		catch(Exception e) {

			System.out.println(e);
		}
		finally {

			try {

				clientSocket.close();
			}
			catch(Exception e) {

				System.out.println(e);
			}
		}
	}
}