package main.java.projet3.traitementcalcul;

import main.java.projet3.menu.MenuGameSelection;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by i-tem on 21/11/2018.
 * Class contenant les différents traitements et calculs de tous les modes de jeux
 *
 * @author Haythem
 * @version 1.0
 */
public class TraitementEtCalcul {


    protected static Logger logger = Logger.getLogger(TraitementEtCalcul.class);
    protected Configuration configuration = Configuration.getInstance();


    final long leftLimit = 0L;
    final long rightLimit = 10000000000L;
    final long generatedLong = 0L;
    protected long nombreAleatoire2;
    public int choixFinJeux;
    public int compteur = 0;
    public int[] tabChiffreMystereOrdinateur;
    public int[] tabPropositionChiffreMystereOrdinateur;
    public int[] tabPropositionChiffreJoueur;
    public int[] tabChiffreMystereJoueur;
    public Scanner sc = new Scanner(System.in);
    public String propositionChiffreJoueur;
    public String chiffreMystereJoueur;
    protected MenuGameSelection menuGameSelection = new MenuGameSelection();
    public String chiffreMystereOrdinateur = "", regex = "\\d+", propositionChiffreMystereOrdinateur = "";
    protected int tailleIdeale;
    protected String[] tableauZero = {"0", "00", "000", "0000", "00000", "000000", "0000000", "00000000", "000000000"};
    protected int placer;
    protected int present;


    //Chiffre Mystere

    /**
     * Methode permerttant de decouper et  stocker le chiffre mystere de l ordinateur dans un tableau d entier puis retourne ce tableau
     *
     * @param chiffreMystereOrdinateur variable de type String contenant le chiffre mystere de l ordinateur
     * @return
     */
    public int[] decoupeChiffreMystereOrdinateur(String chiffreMystereOrdinateur) {
        tabChiffreMystereOrdinateur = new int[chiffreMystereOrdinateur.length()];

        for (int i = 0; i < chiffreMystereOrdinateur.length(); i++) {
            tabChiffreMystereOrdinateur[i] = Integer.parseInt("" + chiffreMystereOrdinateur.charAt(i));
        }

        return tabChiffreMystereOrdinateur;
    }


    /**
     * Methode permettant de decouper et stocker la proposition du joueur dans un tableau d entier puis retourne ce tableau
     *
     * @param propositionChiffreJoueur variable de type String contenant la proposition du joueur
     * @return
     */
    public int[] decoupePropositionChiffreJoueur(String propositionChiffreJoueur) {
        tabPropositionChiffreJoueur = new int[propositionChiffreJoueur.length()];

        for (int i = 0; i < propositionChiffreJoueur.length(); i++) {
            tabPropositionChiffreJoueur[i] = Integer.parseInt("" + propositionChiffreJoueur.charAt(i));
        }

        return tabPropositionChiffreJoueur;
    }

    /**
     * Methode permattant de decouper et stocker le chiffre mystere du joueur dans un tableau d entier puis retournce ce tableau
     *
     * @param chiffreMystereJoueur variable de type String contenant le chiffre mystere du joueur
     * @return
     */
    public int[] decoupeChiffreMystereJoueur(String chiffreMystereJoueur) {
        tabChiffreMystereJoueur = new int[chiffreMystereJoueur.length()];

        for (int i = 0; i < chiffreMystereJoueur.length(); i++) {
            tabChiffreMystereJoueur[i] = Integer.parseInt("" + chiffreMystereJoueur.charAt(i));
        }

        return tabChiffreMystereJoueur;
    }


    /**
     * Methode permettant de decouper et stocker la proposition de chiffre mystere de l ordinateur  dans un tableau d entier puis retournce ce tableau
     *
     * @param propositionChiffreMystereOrdinateur variable de type String contenant la proposition de chiffre mystere de l ordinateur
     * @return
     */
    public int[] decoupePropositionChiffreMystereOrdinateur(String propositionChiffreMystereOrdinateur) {
        tabPropositionChiffreMystereOrdinateur = new int[propositionChiffreMystereOrdinateur.length()];

        for (int i = 0; i < propositionChiffreMystereOrdinateur.length(); i++) {
            tabPropositionChiffreMystereOrdinateur[i] = Integer.parseInt("" + propositionChiffreMystereOrdinateur.charAt(i));
        }
        return tabPropositionChiffreMystereOrdinateur;
    }

    /**
     * Methode permettant de comparer les tableaux contenant le chiffre mystere de l ordinateur et la proposition du joueur et affiche les indications + - =
     *
     * @param tabChiffreMystereOrdinateur tableau de int conteant le chiffre mystere de l ordinateur
     * @param tabPropositionChiffreJoueur tableau de int contenant la proposition du joueur
     * @param propositionChiffreJoueur    variable String contenant la proposition du joueur
     */
    public void compareTableauChiffreMystere(int[] tabChiffreMystereOrdinateur, int[] tabPropositionChiffreJoueur, String propositionChiffreJoueur) {


        System.out.print("Proposition : " + propositionChiffreJoueur + " -> Réponse : ");
        for (int i = 0; i < tabChiffreMystereOrdinateur.length; i++) {
            if (tabPropositionChiffreJoueur[i] < tabChiffreMystereOrdinateur[i]) {
                System.out.print("+");
            } else if (tabPropositionChiffreJoueur[i] > tabChiffreMystereOrdinateur[i]) {
                System.out.print("-");
            } else {
                System.out.print("=");
            }

        }

        System.out.println();
    }


    /**
     * Methode permettant de comparer les tableaux contenant le chiffre mystere du joueur et la proposition de l ordinateur et affiche les indications + - =
     *
     * @param tabChiffreMystereJoueur             tableau de int contenant le chiffre mystere du joueur
     * @param tabChiffreMystereOrdinateur         tableau de int contenant le chiffre mystere de l ordinateur
     * @param propositionChiffreMystereOrdinateur variable String contenant la proposition de l ordinateur
     * @param chiffreMystereJoueur                variable String contenant le chiffre mystere du joueur
     */
    public void compareTbaleauChiffreMystereDefenseur(int[] tabChiffreMystereJoueur, int[] tabChiffreMystereOrdinateur, String propositionChiffreMystereOrdinateur, String chiffreMystereJoueur) {


        System.out.print("Proposition : " + propositionChiffreMystereOrdinateur + "-> Réponse : ");

        do {
            compteur++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.debug("Problème avec la fonction ThreadSleep");
            }

            for (int i = 0; i < tabPropositionChiffreMystereOrdinateur.length; i++) {
                if (tabPropositionChiffreMystereOrdinateur[i] < tabChiffreMystereJoueur[i]) {
                    System.out.print("+");
                    tabPropositionChiffreMystereOrdinateur[i] += 1;
                } else if (tabPropositionChiffreMystereOrdinateur[i] > tabChiffreMystereJoueur[i]) {
                    System.out.print("-");
                    tabPropositionChiffreMystereOrdinateur[i] -= 1;
                } else {
                    System.out.print("=");
                }
            }

            System.out.println();


            System.out.print("Proposition : ");
            for (int i = 0; i < tabPropositionChiffreMystereOrdinateur.length; i++) {
                System.out.print(tabPropositionChiffreMystereOrdinateur[i]);
            }
            System.out.print("  Réponse  ->  : ");

        }
        while (!Arrays.equals(tabPropositionChiffreMystereOrdinateur, tabChiffreMystereJoueur) && compteur != configuration.getNbrEssai());

        if (Arrays.equals(tabPropositionChiffreMystereOrdinateur, tabChiffreMystereJoueur)) {
            System.out.println();
            System.out.print("L'ordinateur a trouver la réponse ! ");
            for (int i = 0; i < tabPropositionChiffreMystereOrdinateur.length; i++) {
                System.out.print(tabPropositionChiffreMystereOrdinateur[i]);
            }
        } else {
            System.out.println("L'ordinateur à perdu");
            System.out.println("La bonne réponse était " + chiffreMystereJoueur);
        }


    }


    //Master Mind

    /**
     * Methode permettant de comparer les tableaux contenants la combinaison mystere de  l ordinateur et la proposition du joueur et retourne les indications
     *
     * @param tabChiffreMystereOrdinateur tableau de int contenant la combinaison de l ordinateur
     * @param tabPropositionChiffreJoueur tableau de int contenant la proposition du joueur
     * @param propositionChiffreJoueur    variable String contenant la proposition du joueur
     */
    public void compareMasterMind(int[] tabChiffreMystereOrdinateur, int[] tabPropositionChiffreJoueur, String propositionChiffreJoueur) {
        placer = 0;
        present = 0;
        System.out.print("Réponse : ");

        boolean[] bienPlacer = new boolean[tabChiffreMystereOrdinateur.length];


        for (int i = 0; i < tabChiffreMystereOrdinateur.length; i++) {
            if (tabPropositionChiffreJoueur[i] == tabChiffreMystereOrdinateur[i]) {
                bienPlacer[i] = true;
                placer++;
            } else {
                bienPlacer[i] = false;
            }
        }

        for (int i = 0; i < tabChiffreMystereOrdinateur.length; i++) {
            for (int j = 0; j < tabPropositionChiffreJoueur.length; j++) {
                if (tabPropositionChiffreJoueur[i] == tabChiffreMystereOrdinateur[j] && (!bienPlacer[j])) {
                    present++;
                }
            }
        }

        if (present > 0 && placer > 0) {
            System.out.println(" présent " + present + ", bien placé " + placer);
        } else if (present > 0 && placer == 0) {
            System.out.println(" present " + present);
        } else if (present == 0 && placer > 0) {
            System.out.println(" bien placé " + placer);
        } else {
            System.out.println("Rien à afficher");
        }
    }

    /**
     * Methode permettant d initialiser a zero le tableau de int contenant la proposition de combinaison de l ordinateur
     */
    public void remiseAzero() {
        for (int i = 0; i < tabPropositionChiffreMystereOrdinateur.length; i++) {
            if (tabPropositionChiffreMystereOrdinateur[i] != tabChiffreMystereJoueur[i]) {
                tabPropositionChiffreMystereOrdinateur[i] = 0;
            }
        }
    }

    /**
     * Methode permettant de comparer les tableaux contenant la proposition de combinaison de l ordinateur a la combinaison du joueur et d incrementer
     * le tableau de proposition de l ordinateur de 1 en fonction du resultat
     */
    public void testProposition() {


        for (int i = 0; i < tabPropositionChiffreMystereOrdinateur.length; i++) {
            if (tabPropositionChiffreMystereOrdinateur[i] != tabChiffreMystereJoueur[i]) {
                tabPropositionChiffreMystereOrdinateur[i] += 1;
                System.out.println();
            }
        }
        System.out.print("Proposition de l'ordinateur : ");
        for (int i = 0; i < tabPropositionChiffreMystereOrdinateur.length; i++) {
            System.out.print(tabPropositionChiffreMystereOrdinateur[i]);
        }
        System.out.println();

    }


    public String generateNumberMasterMind(int nbrCases, int chiffreUtilisable) {
        Random random = new Random();
        String nombreAleatoireString = new String();
        do {
            for (int i = 0; i < nbrCases; i++) {
                int nombreAleatoire = random.nextInt(chiffreUtilisable);
                nombreAleatoireString = nombreAleatoireString + nombreAleatoire;
            }
        } while (nombreAleatoireString.length() != nbrCases);

        return nombreAleatoireString;
    }


    //Fonctions pour les deux jeux


    /**
     * Methode permettant de généré un nombre aléatoire en fonction de la configuration du nombre de cases
     * @param nbrCases variable contenant le nombre de cases selectionner par le joueur
     * @return un nombre aleatoire de type String
     */


    /**
     * Methode permettant de générer un nombre aleatoire de 4 chiffres
     *
     * @return un nombre aleatoire de type String
     */
    public String generateNumber() {

        return this.generateNumberMasterMind(4, 9);
    }


    //Fonction Test

    public void parcourTableau(int[] tableau) {
        System.out.println("verif tableau");
        for (int i = 0; i < tableau.length; i++) {
            System.out.print(tableau[i]);
        }
    }
}
