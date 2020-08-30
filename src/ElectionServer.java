import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ElectionServer {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
	
		try {
			ElectionServant eleicao = new ElectionServant();
			Election stub = (Election) UnicastRemoteObject.exportObject(eleicao, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("Eleicao", stub);
			System.out.println("Servidor Eleicao pronto...");
		} catch (Exception e) {
			System.err.println("Eleicao: método main " + e.getMessage());
			e.printStackTrace();
		}

	}
}	