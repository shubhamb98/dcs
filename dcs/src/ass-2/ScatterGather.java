import mpi.MPI;

public class ScatterGather {

	public static void main(String[] args) {

		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();

		int sendbuf[] = new int[4];
		int root = 0;
		if(rank == root) {

			sendbuf[0] = 10;
			sendbuf[1] = 20;
			sendbuf[2] = 30;
			sendbuf[3] = 40;

			System.out.print("Process " + rank + " has data: ");
			for(int i=0;i<size;i++) {

				System.out.print(sendbuf[i] + " ");
			}
		}

		int recvbuf[] = new int[1];
		MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.INT, recvbuf, 0, 1, MPI.INT, root);

		System.out.println("Process " + rank + " has data:" + recvbuf[0]);
		System.out.println("Process " + rank + " is squaring the data");

		recvbuf[0] = recvbuf[0] * recvbuf[0];
		MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.INT, sendbuf, 0, 1, MPI.INT, root);

		if(rank == root) {

			System.out.print("root has data: ");

			for(int i=0;i<size;i++) {

				System.out.print(sendbuf[i] + " ");
			}
		}

		MPI.Finalize();
	}
}