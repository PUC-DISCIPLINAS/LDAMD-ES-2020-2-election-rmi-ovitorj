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

		String eleitor = "Alberto Matias Junior";
		String candidato = "Luke";

		String eleitor1 = "Roberto Assis Junior";
		String candidato1 = "Leia";

		String eleitor2 = "Lucas Maia Matias Junior";
		String candidato2 = "Jake";

		String eleitor3 = "Junior Garcia";

		String eleitor4 = "Pedro Paulo";
		String candidato3 = "Robert";
		try {
			Election eleicao = null;
			Registry registry = LocateRegistry.getRegistry("localhost");
			eleicao = (Election) registry.lookup("eleicao");
			System.out.println("Eleicao Encontrado.");
			eleicao.vote(candidato, eleitor);
			eleicao.vote(candidato1, eleitor1);
			eleicao.vote(candidato2, eleitor2);
			eleicao.vote(candidato3, eleitor4);
			eleicao.vote(candidato3, eleitor3);

			Result r = eleicao.result(candidato);
			Result r1 = eleicao.result(candidato1);
			Result r2 = eleicao.result(candidato2);
			Result r3 = eleicao.result(candidato3);

			System.out.println("Nome: " + r.name + " - Votos: " + r.votes);
			System.out.println("Nome: " + r1.name + " - Votos: " + r1.votes);
			System.out.println("Nome: " + r2.name + " - Votos: " + r2.votes);
			System.out.println("Nome: " + r3.name + " - Votos: " + r3.votes);

			System.out.println();

		} catch (RemoteException e) {
			System.out.println("Método votar: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Lookup: " + e.getMessage());
		}
	}

}
