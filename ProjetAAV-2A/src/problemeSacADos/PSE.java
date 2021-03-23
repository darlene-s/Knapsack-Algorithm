/*
*Souccouchetty Darlène Groupe 204/ Merand Yoann Groupe 206
*Projet AAV-2A : Problème du sac à dos 
*Classe PSE
*/
package problemeSacADos;

import java.util.ArrayList;
/*
 * Création des sous-arbres droits et gauches de manière récursive
 */
public class PSE {
	public static void ajouterBranche(SacADos s, Arbre arbre, int tailleArbre) {
		if (s.getElement().size() > tailleArbre) {
			Arbre gauche = new Arbre(arbre.getObj());
			float t;
			float z1;
			t= (gauche.getNoeudPoids() + s.getElement().get(tailleArbre).getPoids());
			z1 = t/s.getPoidsMax();
			if (z1 <= 1) {
				gauche.getObj().add(s.getElement().get(tailleArbre));
				arbre.setbrancheG(gauche);
				PSE.ajouterBranche(s, arbre.getSAG(), tailleArbre + 1);
			}
			
			Arbre droite = new Arbre(arbre.getObj());
			arbre.setbrancheD(droite);
			PSE.ajouterBranche(s, arbre.getSAD(), tailleArbre + 1);
				
		}
		
	}
/*
 * Récupération des branches d'indice maximal pour stocker dans l'array maxBranche les différents parcours d'arbres possibles 
 */
	public static void getArbre(ArrayList<Arbre> maxBranche, Arbre s, int tailleArbre, int max) {
		if (tailleArbre == max) {
			maxBranche.add(s);
		}
		else {
			if (s.getSAD() != null)
				PSE.getArbre(maxBranche, s.getSAD(), tailleArbre + 1, max);
			if (s.getSAG() != null)
				PSE.getArbre(maxBranche, s.getSAG(), tailleArbre + 1, max);
		}
	}
	/*
	 * Récupération des différents parcours d'arbres possibles recherche du meilleur parcours de l'arbre, permettant d'obtenir la valeur optimale 
	 */	
	public void methodePSE(SacADos s) {
		Arbre racine = new Arbre();
		PSE.ajouterBranche(s, racine, 0);
		ArrayList<Arbre> val = new ArrayList<Arbre>();
		PSE.getArbre(val, racine, 0, s.getElement().size());
		
		float t = (float) 0;
		int ind = 0;
		for (int i = 0; i < val.size(); ++i) { 
			float z2 = t/val.get(i).getNoeudVal();
			if (z2 < 1) {
				ind = i;
				t = (float) val.get(i).getNoeudVal();
			}
		}
		
		for (int i = 0; i < val.get(ind).getObj().size(); ++i) {  
			s.ajouterObj(val.get(ind).getObj().get(i));
		}
	}
}