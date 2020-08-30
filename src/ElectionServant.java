import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class ElectionServant implements Election {

	String[] candidatos = { "Luke", "Leia", "Jake", "Peter", "Patrick", "Robert" };
	int[] votes = new int[candidatos.length];
	ArrayList<String> eleitores = new ArrayList<String>();
	protected ElectionServant() throws RemoteException {
		super();
	}

	@Override
	public synchronized void vote(String candidato, String eleitor) throws RemoteException {

		String md5 = converteEleitor(eleitor);

		if (!eleitores.contains(md5)) {
			for (int i = 0; i < candidatos.length; i++) {
				if (candidato.equals(candidatos[i])) {
					votes[i]++;
				}
			}
			try {
				File file = new File("resultado.txt");
				file.createNewFile();
				PrintWriter output = new PrintWriter(new FileWriter(file));
				for (int i = 0; i < candidatos.length; i++) {
					output.println("Candidato: "+candidatos[i]+" - Voto: "+votes[i]);
				}
				
				output.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No such file exists.");
			}
			eleitores.add(md5);
		}

	}
	
	// Funcao para converter o nome do eleitor em MD5
	public synchronized static String converteEleitor(String eleitor) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(eleitor.getBytes());
			byte[] md5 = md.digest();
			BigInteger numMd5 = new BigInteger(1, md5);
			String hashMd5 = String.format("%022x", numMd5);
			return hashMd5;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

	}

	// Recupera os votos de determinado candidato
	public synchronized Result result(String candidato) throws RemoteException {
		// TODO Auto-generated method stub
		Result result = new Result();

		for (int i = 0; i < candidatos.length; i++) {
			if (candidato.equals(candidatos[i])) {
				result.setName(candidato);
				result.setVotes(votes[i]);
			}
		}
		return result;

	}

}