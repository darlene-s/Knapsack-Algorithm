/*
*Souccouchetty Darl�ne Groupe 204/ Merand Yoann Groupe 206
*Projet AAV-2A : Probl�me du sac � dos 
*Classe Glouton
*/
package problemeSacADos;

import java.util.Collections;
import java.util.Comparator;

public class Glouton {
	/*
	 * Comparaison des rapports
	 */
	public static Comparator<Objet> ComparerRapportVP = new Comparator<Objet>() {
		@Override
		public int compare(Objet o1, Objet o2) {
			// TODO Auto-generated method stub
			return (int) (o2.getRapportVP() - o1.getRapportVP());
		}
	};
	/*
	 * Tri des objets de mani�re d�croissante par rapport � la comparaison des
	 * rapports (principe du tri par insertion)
	 */
	public void methodeGloutonne(SacADos s) {
		Collections.sort(s.getElement(), Glouton.ComparerRapportVP);
	}
	/*
	 * M�thode permettant de contr�ler le poids du sac de sorte � ce que "poids"<=
	 * "poidsMax", tout en ajoutant des �l�ments dans le sac 
	 */
	public static void controlePoids(SacADos s1, SacADos s2) {
		float poidsCourant = 0;
		for (Objet element : s1.getElement()) {
			if (element.getPoids() + poidsCourant <= s2.getPoidsMax()) {
				s2.getObjDuSac().add(element);
				poidsCourant = poidsCourant + element.getPoids();
				System.out.println("L'�lement" + " " + element.getNomObj() + " " + "a �t� ajout� dans le sac");
			} else if (element.getPoids() == 0) {
				System.out.println("Le sac est vide");
			} else if (poidsCourant >= s2.getPoidsMax()) {
				System.out
						.println("L'�lement" + " " + element.getNomObj() + " " + "ne peut pas �tre ajout� dans le sac");
			}
		}
		System.out.println("\nVotre sac a atteint son poids maximal");
	}
}
