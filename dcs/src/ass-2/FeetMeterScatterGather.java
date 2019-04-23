import mpi.MPI;

public class FeetMeterScatterGather {

	public static void main(String[] args) {

		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();

		double sendbuf[] = new double[4];
		int root = 0;

		if(rank==root) {

			sendbuf[0] = 60.0;
			sendbuf[1] = 120.0;
			sendbuf[2] = 180.0;
			sendbuf[3] = 240.0;

			System.out.print("Process " + rank + " has data: ");
			for(int i=0;i<size;i++) {

				System.out.print(sendbuf[i] + " ");
			}
			System.out.println();
		}

		double recvbuf[] = new double[1];
		MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.DOUBLE, recvbuf, 0, 1, MPI.DOUBLE, root);

		System.out.println("Process " + rank + " has the data:" + recvbuf[0]);
		recvbuf[0] = recvbuf[0]*0.3048;

		MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.DOUBLE, sendbuf, 0, 1, MPI.DOUBLE, root);
		if(rank==root) {

			System.out.print("Data after convesion to meter is: ");
			for(int i=0;i<size;i++) {

				System.out.print(sendbuf[i] + " ");
			}
			System.out.println();
		}

		MPI.Finalize();
	}
}