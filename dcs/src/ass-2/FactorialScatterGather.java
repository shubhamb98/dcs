import mpi.MPI;

public class FactorialScatterGather {

	public static int fact(int num) {

		if(num==1)
			return 1;
		return num * fact(num-1);
	}

	public static void main(String[] args) {

		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();

		int sendbuf[] = new int[4];
		int root = 0;
		if(rank == root) {

			sendbuf[0] = 1;
			sendbuf[1] = 2;
			sendbuf[2] = 3;
			sendbuf[3] = 4;

			System.out.print("Process " + rank + " has data: ");
			for(int i=0;i<size;i++) {

				System.out.print(sendbuf[i] + " ");
			}
		}

		int recvbuf[] = new int[1];
		MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.INT, recvbuf, 0, 1, MPI.INT, root);

		System.out.println("Process " + rank + " has data:" + recvbuf[0]);

		recvbuf[0] = FactorialScatterGather.fact(recvbuf[0]);
		MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.INT, sendbuf, 0, 1, MPI.INT, root);

		if(rank == root) {

			System.out.print("root has data after factorial: ");

			for(int i=0;i<size;i++) {

				System.out.print(sendbuf[i] + " ");
			}
		}

		MPI.Finalize();
	}
}