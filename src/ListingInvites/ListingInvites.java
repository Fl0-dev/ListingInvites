package ListingInvites;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Menu avec inscrit le nom des invités dans un tableau jusqu'à 500 affiche la
 * liste entière par inscription recherche par le nom d'un invité affiche la
 * liste par ordre alphabétique
 * @date 16 avril 2021
 * @author Florian Girard
 * @version v1.0
 */
public class ListingInvites {

	static final int TAILLE = 500;
	static final byte INSCRIPTION = 1;
	static final byte AFF_NOM_IND = 2;
	static final byte AFF_NOM_ALPHA = 3;
	static final byte RECHERCHE = 4;
	static final byte ENTREE_VERIF = 1;
	static final byte SORTIE_VERIF = 0;
	static final String SORTIE = "N";
	static Scanner scan = new Scanner(System.in);
	static String liste[] = new String[TAILLE];
	static int placesRestantes = 0;
	static int place = 0;

	public static void main(String[] args) {
		
		//initialisation de la liste
			Arrays.fill(liste, null);
		
		
		// affichage menu
		System.out.println("Voulez vous lancer le programme d'inscription ? ("+ENTREE_VERIF+"/"+SORTIE_VERIF+")");
		byte verifprog = scan.nextByte();
		scan.nextLine();
		do {
			int saisie = affichageMenu();
			
			switch (saisie) {
				case INSCRIPTION :
					inscription();		
					break;
				case AFF_NOM_IND :
					affichageListe();
					break;
				case AFF_NOM_ALPHA :
					affichageListeAlpha();
					break;
				case RECHERCHE :
					recherche();
					break;
			}
			System.out.println("Voulez-vous continuez ? ("+ENTREE_VERIF+"/"+ SORTIE_VERIF+")");
			verifprog = scan.nextByte();
			scan.nextLine();
		}while(verifprog == 1);	
	}
/////////////////////////// METHODES////////////////////////////
	/**
	 * demande de saisie des invités
	 */
	public static void inscription() {
		System.out.println("Veuilliez saisir le nom de l'invité ("+SORTIE+" pour sortir)");
		String nom = scan.nextLine();
		while(! nom.equals(SORTIE) & place<TAILLE){
			liste = inscriptionliste(nom);
			System.out.println("Veuilliez saisir un autre nom de l'invité ("+SORTIE+" pour sortir)");
			nom = scan.nextLine();
		}
	}

	/**
	 * recherche dans la liste un nom et affiche si oui ou non il est inscrit
	 */
	public static void recherche() {
		boolean verif = false;
		System.out.println("Veuillez saisir le nom recherché :");
		String nomR = scan.nextLine();
		for (int i = 0; i < place; i++) {
			if (nomR.equals(liste[i])) {
				verif = true;
				break;
			}
		}
		if (verif == true) {
			System.out.println(nomR + " est bien dans la liste");
		} else {
			System.out.println(nomR + " n'est pas dans la liste");
		}
	}

	/**
	 *  inscription dans la liste
	 * @param name
	 * @return liste
	 */
	public static String[] inscriptionliste(String name) {
		liste[place] = name;
		place++;
		return liste;
	}

	/**
	 * affichage liste
	 */
	public static void affichageListe() {
		for (int i = 0; i < place; i++) {
			System.out.println(liste[i]);
		}
	}

	/**
	 * affichage liste par ordre alphabétique
	 */
	public static void affichageListeAlpha() {
		String inter [] = new String [place];
		inter = Arrays.copyOf(liste, place);
		Arrays.sort(inter);
		//Arrays.sort(liste);
		for (int i = 0; i < place; i++) {
			System.out.println(inter[i]);
		}
	}

	/**
	 * affichage menu
	 * @return saisieM
	 */
	public static int affichageMenu() {
		int placesRestantes = TAILLE - place;
		int saisieM = 0;
		while (saisieM != INSCRIPTION & saisieM != AFF_NOM_IND & saisieM != AFF_NOM_ALPHA & saisieM != RECHERCHE) {
			System.out.println("Faites votre choix");
			System.out.println("Tapez " + INSCRIPTION + " pour inscrire un invité (" + placesRestantes + " places restantes)");
			System.out.println("Tapez " + AFF_NOM_IND + " pour afficher la liste des invités");
			System.out.println("Tapez " + AFF_NOM_ALPHA + " pour afficher la liste des invités par ordre alphabétique");
			System.out.println("Tapez " + RECHERCHE + " pour rechercher un nom dans la liste des invités");
			saisieM = scan.nextByte();
			scan.nextLine();
		}
		return saisieM;
	}
}
