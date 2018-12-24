package main.java.projet3.chiffremystere;

import main.java.projet3.opc.Main;
import main.java.projet3.traitementcalcul.TraitementEtCalcul;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 * Class permettant de lancer le jeux Chiffre Mystere Challenger mode
 * @author Haythem
 * @version 1.0
 */
public class ChiffreMystereChallengerMode extends TraitementEtCalcul {


    final static Logger logger = Logger.getLogger(ChiffreMystereChallengerMode.class);


    public void runChiffreMystereChallengerMode() {


        runConfiguration();

        //Affichage du mode de jeux
        System.out.println("**********        **********************************                 ************");
        System.out.println("**********        *Chiffre Mystere Challenger Mode *                 ************");
        System.out.println("**********        **********************************                 ************");
        System.out.println();


        //Pré configuration de la partie
        if (configurationJeux.equalsIgnoreCase("false")) {
            chiffreMystereOrdinateur = generateNumber();
        } else {
            chiffreMystereOrdinateur = generateNumber(nbrCases);

        }

        tabChiffreMystereOrdinateur = decoupeChiffreMystereOrdinateur(chiffreMystereOrdinateur);

        //Lancement de la partie ( Ordinateur)
        System.out.println("L'ordinateur réfléchi à un chiffre Mystère");
        if (modeDeveloppeur.equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("On")) {
            System.out.println("Le chiffre mystère de l'ordinateur est " + chiffreMystereOrdinateur);

        }

        System.out.println("Devinez la combinaison Mystère de l'ordinateur");


        do {
            compteur++;
            //Partie Joueur
            do {

                System.out.println("Merci de saisir un nombre de " + chiffreMystereOrdinateur.length() + " chiffres");
                propositionChiffreJoueur = sc.nextLine();
            }
            while (!propositionChiffreJoueur.matches(regex) || propositionChiffreJoueur.length() != chiffreMystereOrdinateur.length());
            tabPropositionChiffreJoueur = decoupePropositionChiffreJoueur(propositionChiffreJoueur);

            //Analyse et traitement
            compareTableauChiffreMystere(tabChiffreMystereOrdinateur, tabPropositionChiffreJoueur, propositionChiffreJoueur);
        }
        while (!Arrays.equals(tabPropositionChiffreJoueur, tabChiffreMystereOrdinateur) && compteur != nbrEssai);


        if (Arrays.equals(tabPropositionChiffreJoueur, tabChiffreMystereOrdinateur)) {
            System.out.println("Bravo vous avez gagner");
        } else {
            System.out.println("Dommage vous avez perdu, la réponse était " + chiffreMystereOrdinateur);
        }

        System.out.println();


        //Fin du jeux
        do {

            menuGameSelection.displayEndGameSelection();
            System.out.println("Veuillez faire un choix svp");

            try {
                choixFinJeux = sc.nextInt();
            } catch (InputMismatchException e) {
                logger.debug("Erreur de saisie, veuillez saisir des chiffres svp");
            }
            sc.nextLine();
        } while (choixFinJeux < 1 || choixFinJeux > 3);

        menuGameSelection.selectedEndGameMode(1, 1, choixFinJeux);

    }


}
