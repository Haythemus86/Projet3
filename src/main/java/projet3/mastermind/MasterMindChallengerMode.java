package main.java.projet3.mastermind;

import main.java.projet3.menu.MenuGameSelection;
import main.java.projet3.opc.Main;
import main.java.projet3.traitementcalcul.Configuration;
import main.java.projet3.traitementcalcul.TraitementEtCalcul;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 * Class permettant de lancer le jeux Mastermind Challenger Mode
 * @author Haythem
 * @version 1.0
 */
public class MasterMindChallengerMode {

    final Logger logger = Logger.getLogger(MasterMindChallengerMode.class);
    protected Configuration configuration = new Configuration();
    protected TraitementEtCalcul traitementEtCalcul = new TraitementEtCalcul();
    protected MenuGameSelection menuGameSelection = new MenuGameSelection();

    public void runMasterMindChallengerMode() {

        //Lecture du fichier de configuration
        configuration.runConfiguration();

        //Affichage du mode de jeux
        System.out.println("**********        *******************************                     *******************");
        System.out.println("**********        **Master Mind Challenger Mode**                     *******************");
        System.out.println("**********        *******************************                     *******************");

        //Pré configuration de la partie
        if (configuration.configurationJeux.equalsIgnoreCase("false")) {
            traitementEtCalcul.chiffreMystereOrdinateur = traitementEtCalcul.generateNumber();
        } else {
            traitementEtCalcul.chiffreMystereOrdinateur = traitementEtCalcul.generateNumber(configuration.nbrCases);

        }

        //Permet d'afficher la solution en mode développeur
        if (configuration.modeDeveloppeur.equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("On")) {
            System.out.println("Le combinaison généré par l'ordinateur est  " + traitementEtCalcul.chiffreMystereOrdinateur);
        }
        traitementEtCalcul.tabChiffreMystereOrdinateur = traitementEtCalcul.decoupeChiffreMystereOrdinateur(traitementEtCalcul.chiffreMystereOrdinateur);


        do {
            traitementEtCalcul.compteur++;

            //Partie joueur
            if (configuration.configurationJeux.equalsIgnoreCase("false")) {
                do {
                    System.out.println("Entrez une combinaison à 4 chiffres");
                    traitementEtCalcul.propositionChiffreJoueur = traitementEtCalcul.sc.nextLine();
                    traitementEtCalcul.nbrEssai = 10;
                } while (!traitementEtCalcul.propositionChiffreJoueur.matches(traitementEtCalcul.regex) || traitementEtCalcul.propositionChiffreJoueur.length() != 4);
            } else {
                do {
                    System.out.println("Entrez une combinaison à " + configuration.nbrCases + " chiffres");
                    traitementEtCalcul.propositionChiffreJoueur = traitementEtCalcul.sc.nextLine();
                } while (!traitementEtCalcul.propositionChiffreJoueur.matches(traitementEtCalcul.regex) || traitementEtCalcul.propositionChiffreJoueur.length() != configuration.nbrCases);
            }
            traitementEtCalcul.tabPropositionChiffreJoueur = traitementEtCalcul.decoupePropositionChiffreJoueur(traitementEtCalcul.propositionChiffreJoueur);


            //Comparaison et calcul
            traitementEtCalcul.compareMasterMind(traitementEtCalcul.tabChiffreMystereOrdinateur, traitementEtCalcul.tabPropositionChiffreJoueur, traitementEtCalcul.propositionChiffreJoueur);
        } while (!traitementEtCalcul.propositionChiffreJoueur.equalsIgnoreCase(traitementEtCalcul.chiffreMystereOrdinateur) && traitementEtCalcul.compteur != configuration.nbrEssai);

        if (traitementEtCalcul.propositionChiffreJoueur.equalsIgnoreCase(traitementEtCalcul.chiffreMystereOrdinateur)) {
            System.out.println("Bravo vous avez gagné!!!!!");
        } else {
            System.out.println("Dommage vous avez perdu!! la réponse était " + traitementEtCalcul.chiffreMystereOrdinateur);
        }


        //Affichage Menu fin de Jeux
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
        menuGameSelection.selectedEndGameMode(2, 1, traitementEtCalcul.choixFinJeux);
    }


}


