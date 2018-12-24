package main.java.projet3.chiffremystere;

import main.java.projet3.opc.Main;
import main.java.projet3.traitementcalcul.TraitementEtCalcul;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 * Class permettant de lancer le jeux Chiffre Mystere Defenseur mode
 * @author Haythem
 * @version 1.0
 */
public class ChiffreMystereDefenseurMode extends TraitementEtCalcul {

    final Logger logger = Logger.getLogger(ChiffreMystereChallengerMode.class);

    public void runChiffreMystereDefenseurMode() {

        //Lecture du fichier de configuration
        runConfiguration();

        //Affichage du mode de jeux
        System.out.println("**********        **********************************                 ************");
        System.out.println("**********        *Chiffre Mystere Defenseur Mode  *                 ************");
        System.out.println("**********        **********************************                 ************");
        System.out.println();

        //Pré configuration de la partie
        if (configurationJeux.equalsIgnoreCase("false")) {

            do {
                System.out.println("Veuillez saisir un nombre mystère à 4 chiffres ");
                chiffreMystereJoueur = sc.nextLine();
            } while (!chiffreMystereJoueur.matches(regex) || chiffreMystereJoueur.length() != 4);
        } else {
            do {
                System.out.println("Veuillez sasir un nombre Mystère à " + nbrCases + " chiffres");
                chiffreMystereJoueur = sc.nextLine();
            } while (!chiffreMystereJoueur.matches(regex) || chiffreMystereJoueur.length() != nbrCases);
        }

        //Mode développeur activé ou non
        if (modeDeveloppeur.equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("On")) {
            System.out.println("Votre chiffre Mystere est " + chiffreMystereJoueur);
        }

        //Découpe du chiffre mystere du joueur et passage dans un tableau
        tabChiffreMystereJoueur = decoupePropositionChiffreJoueur(chiffreMystereJoueur);

        //Partie Ordinateur
        System.out.println("L'ordinateur réfléchi à un chiffre Mystère");

        if (configurationJeux.equalsIgnoreCase("false")) {
            propositionChiffreMystereOrdinateur = generateNumber();
        } else {
            propositionChiffreMystereOrdinateur = generateNumber(nbrCases);
        }

        tabPropositionChiffreMystereOrdinateur = decoupeChiffreMystereOrdinateur(propositionChiffreMystereOrdinateur);

        //Comparaison et calcul
        compareTbaleauChiffreMystereDefenseur(tabChiffreMystereJoueur, tabChiffreMystereOrdinateur, propositionChiffreMystereOrdinateur, chiffreMystereJoueur);

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

        menuGameSelection.selectedEndGameMode(1, 2, choixFinJeux);

    }
}
