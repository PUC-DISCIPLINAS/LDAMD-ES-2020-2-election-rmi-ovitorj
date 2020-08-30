import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Vector;

public class ElectionClient {

	public static void main(String args[]) throws RemoteException {
		ArrayList<String> eleitores = new ArrayList<String>();
		
		String eleitor = "Alberto Matias Junior";
		String candidato = "luke";
	
		String eleitor1 = "Roberto Assis Junior";
		String candidato1 = "leia";
	
		String eleitor2 = "Lucas Maia Matias Junior";
		String candidato2 = "jake";
	
		try {
			Election eleicao = null;
			Registry registry = LocateRegistry.getRegistry("localhost");
			eleicao = (Election) registry.lookup("eleicao");
			System.out.println("Eleicao Encontrado.");
			eleicao.vote(candidato, eleitor);
			eleicao.vote(candidato1, eleitor1);
			eleicao.vote(candidato2, eleitor2);
			
			Result r = eleicao.result(candidato);
			Result r1 = eleicao.result(candidato1);
			Result r2 = eleicao.result(candidato2);
			
			System.out.println("nome:"+r.name+" - Votos"+r.votes );
			System.out.println("nome:"+r1.name+" - Votos"+r1.votes );
			System.out.println("nome:"+r2.name+" - Votos"+r2.votes );
			
			System.out.println( );

			
		} catch (RemoteException e) {
			System.out.println("Método votar: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Lookup: " + e.getMessage());
		}
	}
	

	

}
