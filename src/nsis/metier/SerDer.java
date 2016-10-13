package nsis.metier;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerDer {
	// un objet SerDer peut sérialiser et ré-instancier un objet quelconque
	static String nomFichier = "SerDer.ser";

	// nom du fichier pour la sérialisation
	public void serialise(Object unObjet) throws IOException {
		// sérialise unObjet dans le fichier
		ObjectOutputStream fluxEcrit = new ObjectOutputStream(
				new FileOutputStream(nomFichier));
		fluxEcrit.writeObject(unObjet);

		fluxEcrit.flush();
		fluxEcrit.close();
	}

	public Object reinstancie() throws IOException, ClassNotFoundException {
		// ré-instancie puis renvoie l'objet qui a été sérialisé
		ObjectInputStream fluxLu = new ObjectInputStream(new FileInputStream(
				nomFichier));
		Object obj = fluxLu.readObject();
		fluxLu.close();
		return obj;

	}

	public void identifie(Object unObjet) {
		// affiche des informations sur unObjet
		System.out
				.println("objet de la classe " + unObjet.getClass().getName());
		System.out.println("valeur : " + unObjet);
	}
}