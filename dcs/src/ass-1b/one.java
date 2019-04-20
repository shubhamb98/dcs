import java.rmi.*;

public interface one extends Remote {

	public int palin(String a) throws RemoteException;
}