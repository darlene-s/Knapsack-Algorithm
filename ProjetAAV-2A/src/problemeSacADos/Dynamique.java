/*
*Souccouchetty Darl�ne Groupe 204/ Merand Yoann Groupe 206
*Projet AAV-2A : Probl�me du sac � dos 
*Classe Dynamique
*/
package problemeSacADos;

import java.util.List;

public class Dynamique {
	private float poidsMax;
	private float[][] matrice;
	private List<Objet> obj;

	/*
	 * Initialisation des variables et de la liste d'objets pour s1 et s2
	 */
	public Dynamique(SacADos s1, SacADos s2) {
		this.poidsMax = s1.getPoidsMax();
		this.matrice = new float[s2.getElement().size()][(int) poidsMax + 1];
		this.obj = s2.getElement();
	}

	/*
	 * Adaptation du pseudo-code d'Openclassroom : Cr�ation d'un matrice
	 * (matrice de dimension nombre objets matrice[i][j]. Sachant
	 * que chaques cases repr�sente la valeur maximum qu'il est possible d'obtenir
	 * en mettant les i premiers objets de poids j dans le sac s.
	 * 
	 */
	public void methodeDynamique(SacADos s) {
		int i = 0;
		int j = 0;

		for (i = 0; i < obj.size(); ++i) {
			for (j = 0; j <= poidsMax; ++j) {
				if (i == 0) {
					if (obj.get(0).getPoids() > j)
						matrice[0][j] = 0;
					else
						matrice[0][j] = obj.get(0).getVal();
				}

				else if (i != 0) {
					if (obj.get(i).getPoids() > j)
						matrice[i][j] = matrice[i - 1][j];
					else
						matrice[i][j] = Math.max(matrice[i - 1][j],
								matrice[i - 1][(j - (int) (obj.get(i).getPoids()))] + (int) obj.get(i).getVal());
				}
			}
		}

		--i;
		--j;
		/*
		 * R�cuperation dans la derni�re ligne, du poids minimal avec les derni�res
		 * cases du matrice pour cette fois-ci obtenir de mani�re dynamique la valeurla
		 * plus optimale possible.
		 */
		while (matrice[i][j] == matrice[i][j - 1]) {
			--j;
		}
		/*
		 * R�cup�ration de la liste des objets du sac.
		 */
		while (j > 0) {
			while ((i > 0) && (matrice[i][j] == matrice[i - 1][j])) {
				--i;
			}

			j = (int) (j - (obj.get(i).getPoids()));

			if (j >= 0) {
				s.ajouterObj(obj.get(i));
				--i;
			}
		}
	}
}