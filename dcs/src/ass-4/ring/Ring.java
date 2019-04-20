import java.util.*;


class process {

	public int id;
	public boolean state;
};

class token {

	public int cordId;
	public int cordNo;
};

class Ring {

	public static process proc[] = new process[10];
	public static token tok = new token();
	public static int num;


	public static void up(int up) {

		if(proc[up-1].state) {

			System.out.println("Process" + up + " is already up.");
		}
		else {

			proc[up-1].state = true;
			System.out.println("Process" + up + " is now up.");
		}
	}


	public static void down(int down) {

		if(proc[down-1].state) {

			proc[down-1].state = false;
			System.out.println("Process" + down + " is now down.");
		}
		else {

			System.out.println("Process" + down + " is already down.");
		}
	}


	public static void election(int ele) {

		int proc1 = ele-1;
		int proc2 = ele%num;
		tok.cordId = proc[ele-1].id;
		tok.cordNo = ele;

		if(proc[proc1].state) {

			while((proc2+1)!=ele) {

				if(proc[proc2].state) {
					System.out.println("process" + (proc1+1) + " send token to process" + (proc2+1));
					if(proc[proc2].id > tok.cordId) {
						tok.cordId = proc[proc2].id;
						tok.cordNo = proc2+1;
					}
					
					proc1 = proc2;
					proc2 = (proc2+1)%num;
				}
				else
					proc2 = (proc2+1)%num;
			} 

			System.out.println("process" + tok.cordNo + " with id " + tok.cordId + " is selected as co-ordinator");
		}
		else {

			System.out.println("process" + ele + " is down");
		}
	}


	public static void main(String[] args) {

		int choice;

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of Processes: ");
		num = sc.nextInt();

		for(int i=0; i<num; i++) {

			proc[i] = new process();
			System.out.print("Enter id of process " + (i+1) + ": ");
			proc[i].id = sc.nextInt();
			proc[i].state = true;
		}

		for(int i=0;i<num;i++) {

			System.out.println("process" + (i+1) + " with id " + proc[i].id + " is up.");
		}


		do {

			System.out.println("=================");
			System.out.println("1. Up a process");
			System.out.println("2. Down a process");
			System.out.println("3. Election");
			System.out.println("4. Exit");
			choice = sc.nextInt();
			
				
			switch(choice) {

				case 1:
				System.out.println("Enter process number to up:");
				int up = sc.nextInt();
				Ring.up(up);
				break;

				case 2:
				System.out.println("Enter process number to down:");
				int down = sc.nextInt();
				Ring.down(down);
				break;

				case 3:
				System.out.println("Enter process number who will start election:");
				int ele = sc.nextInt();
				Ring.election(ele);
				break;
			}
		}while(choice!=4);
	}
}
