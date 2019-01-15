package main.java.projet3.chiffremystere;

import main.java.projet3.menu.MenuGameSelection;
import main.java.projet3.menu.MenuTraitement;
import main.java.projet3.opc.Main;
import main.java.projet3.traitementcalcul.Configuration;
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
public class ChiffreMystereChallengerMode {


    final Logger logger = Logger.getLogger(ChiffreMystereChallengerMode.class);
    public Configuration configuration = Configuration.getInstance();
    protected TraitementEtCalcul traitementEtCalcul = new TraitementEtCalcul();
    protected MenuGameSelection menuGameSelection = new MenuGameSelection();
    protected MenuTraitement menuTraitement = new MenuTraitement();

    public void runChiffreMystereChallengerMode() {


        configuration.runConfiguration();

        //Affichage du mode de jeux
        System.out.println("**********        **********************************                 ************");
        System.out.println("**********        *Chiffre Mystere Challenger Mode *                 ************");
        System.out.println("**********        **********************************                 ************");
        System.out.println();


        //Pré configuration de la partie
        if (configuration.configurationJeux.equalsIgnoreCase("false")) {
            traitementEtCalcul.chiffreMystereOrdinateur = traitementEtCalcul.generateNumber();
            configuration.nbrEssai = 6;
        } else {
            traitementEtCalcul.chiffreMystereOrdinateur = traitementEtCalcul.generateNumberMasterMind(configuration.nbrCases,9);

        }

        traitementEtCalcul.tabChiffreMystereOrdinateur = traitementEtCalcul.decoupeChiffreMystereOrdinateur(traitementEtCalcul.chiffreMystereOrdinateur);

        //Lancement de la partie ( Ordinateur)
        System.out.println("L'ordinateur réfléchi à un chiffre Mystère");
        if (configuration.modeDeveloppeur.equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("On")) {
            System.out.println("Le chiffre mystère de l'ordinateur est " + traitementEtCalcul.chiffreMystereOrdinateur);

        }

        System.out.println("Devinez la combinaison Mystère de l'ordinateur");


        do {
            traitementEtCalcul.compteur++;
            //Partie Joueur
            do {

                System.out.println("Merci de saisir un nombre de " + traitementEtCalcul.chiffreMystereOrdinateur.length() + " chiffres");
                traitementEtCalcul.propositionChiffreJoueur = traitementEtCalcul.sc.nextLine();
            }
            while (!traitementEtCalcul.propositionChiffreJoueur.matches(traitementEtCalcul.regex) || traitementEtCalcul.propositionChiffreJoueur.length() != traitementEtCalcul.chiffreMystereOrdinateur.length());
            traitementEtCalcul.tabPropositionChiffreJoueur = traitementEtCalcul.decoupePropositionChiffreJoueur(traitementEtCalcul.propositionChiffreJoueur);

            //Analyse et traitement
            traitementEtCalcul.compareTableauChiffreMystere(traitementEtCalcul.tabChiffreMystereOrdinateur, traitementEtCalcul.tabPropositionChiffreJoueur, traitementEtCalcul.propositionChiffreJoueur);
        }
        while (!Arrays.equals(traitementEtCalcul.tabPropositionChiffreJoueur, traitementEtCalcul.tabChiffreMystereOrdinateur) && traitementEtCalcul.compteur != configuration.nbrEssai);


        if (Arrays.equals(traitementEtCalcul.tabPropositionChiffreJoueur, traitementEtCalcul.tabChiffreMystereOrdinateur)) {
            System.out.println("Bravo vous avez gagner");
        } else {
            System.out.println("Dommage vous avez perdu, la réponse était " + traitementEtCalcul.chiffreMystereOrdinateur);
        }

        System.out.println();


        //Fin du jeux
        do {

            menuGameSelection.displayEndGameSelection();
            System.out.println("Veuillez faire un choix svp");

            try {
                traitementEtCalcul.choixFinJeux = traitementEtCalcul.sc.nextInt();
            } catch (InputMismatchException e) {
                logger.debug("Erreur de saisie, veuillez saisir des chiffres svp");
            }
            traitementEtCalcul.sc.nextLine();
        } while (traitementEtCalcul.choixFinJeux < 1 || traitementEtCalcul.choixFinJeux > 3);

        menuTraitement.selectedEndGameMode(1, 1, traitementEtCalcul.choixFinJeux);

    }


}
