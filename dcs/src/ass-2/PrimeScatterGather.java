import mpi.MPI;

public class PrimeScatterGather {

	public static int isPrime(int num) {

		for(int i=2;i<num;i++) {

			if(num%i==0)
				return 0;
		}

		return 1;
	}

	public static void main(String[] args) {

		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();

		int sendbuf1[] = new int[4];
		int root = 0;

		if(rank == root) {

			sendbuf1[0] = 4;
			sendbuf1[1] = 5;
			sendbuf1[2] = 6;
			sendbuf1[3] = 7;

			System.out.print("Process " + rank + " has data: ");
			for(int i=0;i<size;i++) {

				System.out.print(sendbuf1[i] + " ");
			}
			System.out.println();
		}

		int recvbuf[] = new int[1];
		MPI.COMM_WORLD.Scatter(sendbuf1, 0, 1, MPI.INT, recvbuf, 0, 1, MPI.INT, root);

		System.out.println("Process " + rank + " has data:" + recvbuf[0]);
		recvbuf[0] = PrimeScatterGather.isPrime(recvbuf[0]);

		int sendbuf2[] = new int[4];
		MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.INT, sendbuf2, 0, 1, MPI.INT, root);

		if(rank==root) {

			for(int i=0;i<size;i++) {
				
				if(sendbuf2[i]==0)
					System.out.println(sendbuf1[i] + " is not a prime number");
				else
					System.out.println(sendbuf1[i] + " is a prime number");
			}
		}

		MPI.Finalize();
	}
}