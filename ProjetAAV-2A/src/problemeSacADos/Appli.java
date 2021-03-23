/*
*Souccouchetty Darl�ne Groupe 204/ Merand Yoann Groupe 206
*Projet AAV-2A : Probl�me du sac � dos 
*Classe Appli : (main)
*/
package problemeSacADos;

import java.io.IOException;
import java.util.*;

public class Appli {

	public static void main(String[] args) throws IOException {
		/*
		 * D�claration des variables
		 */
		float poidsMax;
		String algorithme = null;
		String chemin;
		SacADos s1 = new SacADos();

		/*
		 * R�cup�ration des entr�es console
		 */
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Veuillez entrer le chemin absolu du fichier contenant les �l�ments du sac � dos :\n");
		chemin = sc1.nextLine();
		SacADos.LireFichierTxt(chemin);// R�cup�ration du chemin absolu du fichier et lecture
		s1.getListeElement();

		System.out.println("Quel est le poids maximum du sac � dos ?");
		poidsMax = sc1.nextFloat();

		SacADos s2 = new SacADos(chemin, poidsMax);
		System.out.println("Veuillez choisir votre algorithme de r�solution :");
		System.out.println("Pour l'algorithme Glouton �crivez 'Glouton', pour l'algorithme Dynamique �crivez 'Dynamique', pour l'algorithme PSE �crivez 'PSE'\n");
		algorithme = sc2.nextLine();

		algorithme = algorithme.toUpperCase();
		// Algorithme Glouton
		if (algorithme.equals("GLOUTON")) {
			float poidsG = 0;
			float valeurG = 0;
			System.out.println("Liste des �l�ments dans le sac:\n");
			Glouton g = new Glouton();
			g.methodeGloutonne(s1);
			Glouton.controlePoids(s1, s2);
			s1.getNomElement();
			for (Objet obj : s1.getObjDuSac()) {
				poidsG = poidsG + obj.getPoids();
				valeurG = valeurG + obj.getVal();
			}
			System.out.println("Poids atteint :" + " " + poidsG);
			System.out.println("Valeur atteinte :" + " " + valeurG);
		}
		// Algorithme Dynamique
		else if (algorithme.equals("DYNAMIQUE")) {
			float poidsD = 0;
			float valeurD = 0;
			System.out.println("Liste des �l�ments dans le sac:\n");
			Dynamique d = new Dynamique(s2, s1);
			d.methodeDynamique(s1);
			s1.getNomElement();
			for (Objet obj : s1.getObjDuSac()) {
				poidsD = poidsD + obj.getPoids();
				valeurD = valeurD + obj.getVal();
			}
			System.out.println("Poids atteint :" + " " + poidsD);
			System.out.println("Valeur atteinte :" + " " + valeurD);
		}
		// Algorithme PSE
		else if (algorithme.equals("PSE")) {
			float poidsP = 0;
			float valeurP = 0;
			System.out.println("Liste des �l�ments dans le sac:\n");
			PSE p = new PSE();
			p.methodePSE(s1);
			s1.getNomElement();
			for (Objet obj : s1.getObjDuSac()) {
				poidsP = poidsP + obj.getPoids();
				valeurP = valeurP + obj.getVal();
			}
			System.out.println("Poids atteint :" + " " + poidsP);
			System.out.println("Valeur atteinte :" + " " + valeurP);
		} else
			System.out.println("Cet algorithme n'est pas trait� par le programme !");
	}
}
