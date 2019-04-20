import java.io.*;
import java.util.*;

public class Bully {

	static boolean[] state = new boolean[5];

	public static void up(int up) {

		if(state[up-1])
			System.out.println("Process " + up + " is already up.");
		else {

			state[up-1] = true;
			for(int i=up+1; i<=5; i++)
				System.out.println("Sending election messages from process " + up + " to process" + i);

			for(int i=up+1; i<=5; i++) {

				if(state[i-1]) {

					System.out.println("Alive message sent from process " + i + " to process " + up);
					break;
				}
			}
		}
	}


	public static void down(int down) {

		if(state[down-1]) {

			Bully.state[down-1] = false;
		}
		else {

			System.out.println("Process " + down + " is already down");
		}
	}


	public static void mess(int mess) {

		if(state[mess-1]) {

			if(state[4])
				System.out.println("OK");
			else {

				System.out.println("Process " + mess + " requesting for election");
				for(int i=mess+1; i<=5; i++) {

					System.out.println("Election message sent from process " + mess + " to process " + i);
				}

				for(int i=5; i>=mess; i--) {

					if(state[i-1]) {

						System.out.println("Co-ordinator message sent from process " + i + " to all");
						break;
					}
				}
			}
		}
		else {

			System.out.println("Process " + mess + " is down");
		}
	}


	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int choice;

		for(int i=0;i<5;i++) {

			state[i] = true;
			System.out.println("Process " + (i+1) + " is up");
		}

		System.out.println("Process 5 is co-ordinator");

		do {

			System.out.println("=================");
			System.out.println("1. Up a process");
			System.out.println("2. Down a process");
			System.out.println("3. Send message");
			System.out.println("4. Exit");
			choice = sc.nextInt();

			switch(choice) {

				case 1:
					System.out.print("Bring process up:");
					int up = sc.nextInt();
					if(up==5) {

						System.out.println("Process 5 is co-ordinator");
						Bully.state[4] = true;
						break;
					}
					Bully.up(up);
					break;

				case 2:
					System.out.print("Bring process down: ");
					int down = sc.nextInt();
					Bully.down(down);
					break;

				case 3:
					System.out.print("Send messages to other processes: ");
					int mess = sc.nextInt();
					Bully.mess(mess);
					break;	
			}

		}while(choice!=4);
	}
}