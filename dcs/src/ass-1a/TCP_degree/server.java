package TCP_degree;


import java.net.*;
import java.io.*;

public class server {
	
	private static ServerSocket listenSocket;
	private static Connection c;

	public static void main(String args[]) {
		try {
			int serverPort = 7896;
			listenSocket = new ServerSocket(serverPort);
			while (true) {
				Socket clientSocket = listenSocket.accept();
				c = new Connection(clientSocket);
			}
		} catch (IOException e) {
			System.out.println("Listen :" + e.getMessage());
		}
	}
}

class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;

	public Connection(Socket aClientSocket) {
		try {
			clientSocket = aClientSocket;
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.out.println("Connection:" + e.getMessage());
		}
	}

	public void run() {
		try {
// an echo server
			Float degree=in.readFloat();
			System.out.println("Degree : "+degree);
			
			out.writeFloat( (float) (degree*(3.14/180)));
			clientSocket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
