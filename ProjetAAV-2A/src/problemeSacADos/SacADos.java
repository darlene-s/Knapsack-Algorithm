/*
 *Souccouchetty Darl�ne Groupe 204/ Merand Yoann Groupe 206
 *Projet AAV-2A : Probl�me du sac � dos 
 *Classe Sac � dos
 */
package problemeSacADos;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/*
 *Classe mod�lisant un sac � dos & ses attributs
 */
public class SacADos {
	private static float poidsMax;
	private static ArrayList<Objet> obj;
	private static ArrayList<Objet> objDuSac;

	/*
	 * Constructeur permettant d'initialiser un sac � dos vide
	 */
	public SacADos() {
		obj = new ArrayList<Objet>();
		objDuSac = new ArrayList<Objet>();
	}

	/*
	 * Constructeur permettant de g�n�rer un sac � dos, prennant en param�tre le
	 * chemin du fichier o� le poids maximal et la liste des objets du sac � dos
	 * (avec leurs caract�ristiques) sont renseign�s
	 */
	@SuppressWarnings("static-access")
	public SacADos(String chemin, float poidsMax) {
		this.poidsMax = poidsMax;
		objDuSac = new ArrayList<Objet>();
	}

	/*
	 * Getter renvoyant le poidsMax du sac
	 */
	public float getPoidsMax() {
		return poidsMax;
	}

	/*
	 * M�thode permettant d'ajouter un objet parmi la liste "obj" � l'int�rieur du
	 * sac
	 */
	public void ajouterObj(Objet element) {
		objDuSac.add(element);
	}

	/*
	 * M�thode permettant d'ajouter un objet suppl�mentaire dans la liste des objets
	 * disponibles
	 */
	public static void ajouterObjetSuppl(String nomObj, float poids, float val) {
		Objet element = new Objet(poids, val, nomObj);
		obj.add(element);
	}

	/*
	 * M�thode renvoyant la liste des noms des objets disponibles/restants � mettre
	 * dans le sac
	 */
	public void getListeElement() {
		int cpt = 1;

		for (Objet element : obj) {
			System.out.println(cpt + ";" + element.getNomObj());
			++cpt;
		}
	}

	/*
	 * M�thode renvoyant le nom des objets contenus dans le sac
	 */
	public void getNomElement() {
		int cpt = 1;
		for (Objet element : objDuSac) {
			System.out.println(cpt + " " + ";" + " " + element.getNomObj());
			++cpt;
		}
	}

	/*
	 * M�thode renvoyant la liste des objets disponibles
	 */
	public ArrayList<Objet> getElement() {
		return obj;
	}

	/*
	 * M�thode permettant de retourner une array list des objets contenus dans le
	 * sac
	 */
	public ArrayList<Objet> getObjDuSac() {
		return objDuSac;
	}

	/*
	 * M�thode permettant de lire/parcourir les �l�ments d'un fichier type
	 * "items.txt", prend en param�tre le chemin absolu du fichier
	 */
	public static void LireFichierTxt(String chemin) throws FileNotFoundException {
		try {
			File fichier = new File(chemin + ".txt");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(fichier).useDelimiter(" ; |\n");

			while (scanner.hasNext()) {

				ajouterObjetSuppl(scanner.next(), Float.parseFloat(scanner.next()), Float.parseFloat(scanner.next()));
			}
			scanner.close();
		} catch (FileNotFoundException NotFounded) {
			System.out.println("Fichier inexistant");
			System.out.println("Fin du programme");
			System.exit(0);
		}
	}
}