import mpi.MPI;

public class ReciprocalScatterGather {

	public static void main(String[] args) {

		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();

		int sendbuf1[] = new int[4];
		int root = 0;

		if(rank == root) {

			sendbuf1[0] = 10;
			sendbuf1[1] = 20;
			sendbuf1[2] = 30;
			sendbuf1[3] = 40;

			System.out.print("Process " + rank + " has data: ");
			for(int i=0;i<size;i++) {

				System.out.print(sendbuf1[i] + " ");
			}
			System.out.println();
		}

		int recvbuf1[] = new int[1];
		MPI.COMM_WORLD.Scatter(sendbuf1, 0, 1, MPI.INT, recvbuf1, 0, 1, MPI.INT, root);

		System.out.println("Process " + rank + " has data:" + recvbuf1[0]);
		
		double recvbuf2[] = new double[1];
		recvbuf2[0] = 1.0/recvbuf1[0];

		double sendbuf2[] = new double[4];
		MPI.COMM_WORLD.Gather(recvbuf2, 0, 1, MPI.DOUBLE, sendbuf2, 0, 1, MPI.DOUBLE, root);

		if(rank==root) {

			System.out.print("root has data after reciprocal: ");
			for(int i=0;i<size;i++) {
				
				System.out.print(sendbuf2[i] + " ");
			}
		}

		MPI.Finalize();
	}
}