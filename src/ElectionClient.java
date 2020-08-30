import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Vector;

public class ElectionClient {

	public static void main(String args[]) throws RemoteException {
		String eleitor = "Alberto Matias Junior";
		String candidato = "luke";
	
		try {
			Election eleicao = null;
			Registry registry = LocateRegistry.getRegistry("localhost");
			eleicao = (Election) registry.lookup("election");
			System.out.println("Eleicao Encontrado.");
			eleicao.vote(candidato, eleitor);

			
		} catch (RemoteException e) {
			System.out.println("Método votar: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Lookup: " + e.getMessage());
		}
	}

}
