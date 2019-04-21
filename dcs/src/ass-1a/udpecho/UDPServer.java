import java.io.*;
import java.net.*;


public class UDPServer {

	public static void main(String[] args) {

		DatagramSocket sc = null;

		try {

			sc = new DatagramSocket(8888);
			byte[] receivem = new byte[1000];
			DatagramPacket receivePkt = new DatagramPacket(receivem, receivem.length);

			while(true) {
				sc.receive(receivePkt);
				Connection cn = new Connection(sc, receivePkt);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}


class Connection extends Thread {

	DatagramSocket sc;
	DatagramPacket receivePkt;

	public Connection(DatagramSocket aSc, DatagramPacket aReceivePkt) {

		try {

			sc = aSc;
			receivePkt = new DatagramPacket(aReceivePkt.getData(), aReceivePkt.getLength(), aReceivePkt.getAddress(), aReceivePkt.getPort());;
			this.start();
		}
		catch(Exception e) {

			System.out.println(e);
		}
	}

	public void run() {

		try {

			System.out.println("Received: " + new String(receivePkt.getData()));
			DatagramPacket sendPkt = new DatagramPacket(receivePkt.getData(), receivePkt.getLength(), receivePkt.getAddress(), receivePkt.getPort());
			sc.send(sendPkt);
		}
		catch(Exception e) {

			System.out.println(e);
		}
	}
}