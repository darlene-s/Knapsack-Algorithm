/*
*Souccouchetty Darlène Groupe 204/ Merand Yoann Groupe 206
*Projet AAV-2A : Problème du sac à dos 
*Classe Arbre
*/
package problemeSacADos;

import java.util.ArrayList;

public class Arbre {
	private ArrayList<Objet> obj;
	private Arbre brancheG;
	private Arbre brancheD;

	/*
	 * Constructeur permettant d'initialiser un arbre vide
	 */
	public Arbre() {
		this.obj = new ArrayList<Objet>();
	}

	/*
	 * Constructeur permettant de générer un arbre, prennant en paramètre le sous
	 * arbre gauche et droit du père
	 */
	public Arbre(Arbre SAG, Arbre SAD) {
		this.obj = new ArrayList<Objet>();
		this.brancheG = SAG;
		this.brancheD = SAD;
	}

	/*
	 * Méthode permettant d'ajouter un objet à la racine de l'arbre père
	 */
	public Arbre(ArrayList<Objet> obj) {
		this.obj = new ArrayList<Objet>();
		for (int i = 0; i < obj.size(); ++i) {
			this.getObj().add(obj.get(i));
		}
	}

	/*
	 * Méthode permettant d'ajouter un objet aux sous arbres droit et gauche
	 */
	public Arbre(ArrayList<Objet> obj, Arbre SAG, Arbre SAD) {
		this(SAG, SAD);
		for (int i = 0; i < obj.size(); ++i) {
			this.getObj().add(obj.get(i));
		}
	}

	/*
	 * Setter de la branche gauche (SAG)
	 */
	public void setbrancheG(Arbre SAG) {
		this.brancheG = SAG;
	}

	/*
	 * Setter de la branche droite (SAD)
	 */
	public void setbrancheD(Arbre SAD) {
		this.brancheD = SAD;
	}

	public void setObj(ArrayList<Objet> obj) {
		for (int i = 0; i < obj.size(); ++i) {
			this.getObj().set(i, obj.get(i));
		}
	}

	/*
	 * Getter qui permet de retourner la racine de l'arbre
	 */
	Arbre getRacine() {
		return this;
	}

	/*
	 * Getter qui permet de retourner la branche droite de l'arbre (SAD)
	 */
	public Arbre getSAD() {
		return this.brancheD;
	}

	/*
	 * Getter qui permet de retourner la branche gauche de l'arbre (SAG)
	 */
	public Arbre getSAG() {
		return this.brancheG;
	}

	/*
	 * Getter qui permet un objet de l'Array list obj
	 */
	public ArrayList<Objet> getObj() {
		return this.obj;
	}

	/*
	 * Méthode qui permet d'obtenir la valeur des noeuds de l'arbre
	 */
	public float getNoeudVal() {
		float val = 0;
		for (int i = 0; i < this.getObj().size(); ++i) {
			val = val + this.getObj().get(i).getVal();
		}
		return val;
	}

	/*
	 * Méthode qui permet d'obtenir le poids des noeuds de l'arbre
	 */
	public float getNoeudPoids() {
		float poids = 0;
		for (int i = 0; i < this.getObj().size(); ++i) {
			poids = poids + this.getObj().get(i).getPoids();
		}

		return poids;
	}

}