import java.io.*;
import java.net.*;

public class UDPClient {

	public static void main(String[] args) {

		DatagramSocket sc = null;
		int serverPort = 8888;

		try {

			sc = new DatagramSocket();
			InetAddress addr = InetAddress.getByName(args[1]);
			byte[] m = args[0].getBytes();
			
			DatagramPacket pkt = new DatagramPacket(m, m.length, addr, serverPort);
			sc.send(pkt);

			byte[] receivem = new byte[1000];
			DatagramPacket receivepkt = new DatagramPacket(receivem, receivem.length);
			sc.receive(receivepkt);

			System.out.println("Received: " + new String(receivepkt.getData()));
		}
		catch(Exception e) {

			System.out.println(e);
		}
		finally {

			sc.close();
		}
	}
}