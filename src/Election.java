import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Election extends Remote {

	void vote(String name, long number) throws RemoteException;

	void result(String name, long votes) throws RemoteException;
}
