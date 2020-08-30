import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Election extends Remote {
	void vote(String candidato, String eleitor) throws RemoteException;

	Result result(String candidato) throws RemoteException;
};