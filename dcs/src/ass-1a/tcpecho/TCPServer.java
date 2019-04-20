import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) {

		ServerSocket s = null;
		int serverPort = 8888;

		try {

		 	s = new ServerSocket(serverPort);

		 	while(true){
		 		Socket clientSocket = s.accept();
		 		Connection cn = new Connection(clientSocket);
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

		try {
			clientSocket = aClientSocket;
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
			this.start();
		}
		catch(Exception e) {

			System.out.println(e);
		}
	}

	public void run() {

		try {
			String data = in.readUTF();
			System.out.println("Received: " + data);
			out.writeUTF(data);
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