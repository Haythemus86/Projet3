package main.java.projet3.mastermind;

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
 * Class permettant de lancer le jeux Mastermind Duel Mode
 *
 * @author Haythem
 * @version 1.0
 */
public class MasterMindDuelMode {

    final Logger logger = Logger.getLogger(MasterMindDuelMode.class);
    protected Configuration configuration = Configuration.getInstance();
    protected TraitementEtCalcul traitementEtCalcul = new TraitementEtCalcul();
    protected MenuGameSelection menuGameSelection = new MenuGameSelection();
    protected MenuTraitement menuTraitement = new MenuTraitement();

    public void runMasterMindDuelMode() {
        //Lecture du fichier de configuration
        configuration.runConfiguration();


        //Affichage du mode de jeux
        System.out.println("**********        *******************************                     *******************");
        System.out.println("**********        **Master Mind Duel Mode      **                     *******************");
        System.out.println("**********        *******************************                     *******************");

        //Pré configuration de la partie
        if (configuration.getConfigurationJeux().equalsIgnoreCase("false")) {

            do {
                System.out.println("Veuillez saisir une combinaison  à 4 chiffres ");
                traitementEtCalcul.chiffreMystereJoueur = traitementEtCalcul.sc.nextLine();
                configuration.setNbrEssai(10);
            }
            while (!traitementEtCalcul.chiffreMystereJoueur.matches(traitementEtCalcul.regex) || traitementEtCalcul.chiffreMystereJoueur.length() != 4);
        } else {
            do {
                System.out.println("Veuillez sasir une combinaison à " + configuration.getNbrCases() + " chiffres , les chiffres utilisables vont de 0 a " + (configuration.getChiffreUtilisable() - 1));
                traitementEtCalcul.chiffreMystereJoueur = traitementEtCalcul.sc.nextLine();
            }
            while (!traitementEtCalcul.chiffreMystereJoueur.matches(configuration.getRegexFinal()) || traitementEtCalcul.chiffreMystereJoueur.length() != configuration.getNbrCases());
        }

        //Mode développeur activé ou non
        if (configuration.getModeDeveloppeur().equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("On")) {
            System.out.println("Votre combinaison secrète est " + traitementEtCalcul.chiffreMystereJoueur);
            ;
        }

        System.out.println("Votre combinaison est enregistré");

        //Découpe du chiffre mystere du joueur et passage dans un tableau
        traitementEtCalcul.tabChiffreMystereJoueur = traitementEtCalcul.decoupePropositionChiffreJoueur(traitementEtCalcul.chiffreMystereJoueur);

        System.out.println();
        //Partie Ordinateur
        System.out.println("L'ordinateur réfléchi à une combinaison");

        if (configuration.getConfigurationJeux().equalsIgnoreCase("false")) {
            traitementEtCalcul.chiffreMystereOrdinateur = traitementEtCalcul.generateNumberMasterMind(4, 10);

        } else {
            traitementEtCalcul.chiffreMystereOrdinateur = traitementEtCalcul.generateNumberMasterMind(configuration.getNbrCases(), configuration.getChiffreUtilisable());
        }

        traitementEtCalcul.tabChiffreMystereOrdinateur = traitementEtCalcul.decoupeChiffreMystereOrdinateur(traitementEtCalcul.chiffreMystereOrdinateur);
        System.out.println("La combinaison de l'ordinateur est enregistré");

        //Permet d'afficher la solution en mode développeur
        if (configuration.getModeDeveloppeur().equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("On")) {
            System.out.println("Le combinaison généré par l'ordinateur est " + traitementEtCalcul.chiffreMystereOrdinateur);
        }


        System.out.println();
        //Partie Joueur
        if (configuration.getConfigurationJeux().equalsIgnoreCase("false")) {
            do {
                System.out.println("Entrez une proposition à 4 chiffres");
                traitementEtCalcul.propositionChiffreJoueur = traitementEtCalcul.sc.nextLine();
                configuration.setNbrEssai(10);
            }
            while (!traitementEtCalcul.propositionChiffreJoueur.matches(traitementEtCalcul.regex) || traitementEtCalcul.propositionChiffreJoueur.length() != 4);
        } else {
            do {
                System.out.println("Entrez une proposition à " + configuration.getNbrCases() + " chiffres , les chiffres utilisables vont de 0 a " + (configuration.getChiffreUtilisable() - 1));
                traitementEtCalcul.propositionChiffreJoueur = traitementEtCalcul.sc.nextLine();
            }
            while (!traitementEtCalcul.propositionChiffreJoueur.matches(configuration.getRegexFinal()) || traitementEtCalcul.propositionChiffreJoueur.length() != configuration.getNbrCases());
        }
        traitementEtCalcul.tabPropositionChiffreJoueur = traitementEtCalcul.decoupePropositionChiffreJoueur(traitementEtCalcul.propositionChiffreJoueur);
        traitementEtCalcul.compteur++;
        //traitement joueur vs ordinateur
        traitementEtCalcul.compareMasterMind(traitementEtCalcul.tabChiffreMystereOrdinateur, traitementEtCalcul.tabPropositionChiffreJoueur, traitementEtCalcul.propositionChiffreJoueur);

        if (Arrays.equals(traitementEtCalcul.tabPropositionChiffreJoueur, traitementEtCalcul.tabChiffreMystereOrdinateur)) {
            System.out.println("bravo vous avez gagné ");

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
            menuTraitement.selectedEndGameMode(2, 3, traitementEtCalcul.choixFinJeux);

        }


        System.out.println();

        //Partie Ordinateur
        System.out.println("L'ordinateur réfléchi à une proposition");

        if (configuration.getConfigurationJeux().equalsIgnoreCase("false")) {
            traitementEtCalcul.propositionChiffreMystereOrdinateur = traitementEtCalcul.generateNumberMasterMind(4, 10);

        } else {
            traitementEtCalcul.propositionChiffreMystereOrdinateur = traitementEtCalcul.generateNumberMasterMind(configuration.getNbrCases(), configuration.getChiffreUtilisable());
        }

        traitementEtCalcul.tabPropositionChiffreMystereOrdinateur = traitementEtCalcul.decoupePropositionChiffreMystereOrdinateur(traitementEtCalcul.propositionChiffreMystereOrdinateur);
        System.out.println("Proposition de l'ordinateur " + traitementEtCalcul.propositionChiffreMystereOrdinateur);
        traitementEtCalcul.compareMasterMind(traitementEtCalcul.tabPropositionChiffreMystereOrdinateur, traitementEtCalcul.tabChiffreMystereJoueur, traitementEtCalcul.propositionChiffreMystereOrdinateur);
        System.out.println();
        traitementEtCalcul.remiseAzero();

        do {


            //Partie Joueur2
            if (configuration.getConfigurationJeux().equalsIgnoreCase("false")) {
                do {
                    System.out.println("Entrez une proposition à 4 chiffres");
                    traitementEtCalcul.propositionChiffreJoueur = traitementEtCalcul.sc.nextLine();

                }
                while (!traitementEtCalcul.propositionChiffreJoueur.matches(traitementEtCalcul.regex) || traitementEtCalcul.propositionChiffreJoueur.length() != 4);
            } else {
                do {
                    System.out.println("Entrez une proposition à " + configuration.getNbrCases() + " chiffres , les chiffres utilisables vont de 0 a " + (configuration.getChiffreUtilisable() - 1));
                    traitementEtCalcul.propositionChiffreJoueur = traitementEtCalcul.sc.nextLine();
                }
                while (!traitementEtCalcul.propositionChiffreJoueur.matches(configuration.getRegexFinal()) || traitementEtCalcul.propositionChiffreJoueur.length() != configuration.getNbrCases());
            }
            traitementEtCalcul.tabPropositionChiffreJoueur = traitementEtCalcul.decoupePropositionChiffreJoueur(traitementEtCalcul.propositionChiffreJoueur);
            traitementEtCalcul.compteur++;
            //traitement joueur vs ordinateur
            traitementEtCalcul.compareMasterMind(traitementEtCalcul.tabChiffreMystereOrdinateur, traitementEtCalcul.tabPropositionChiffreJoueur, traitementEtCalcul.propositionChiffreJoueur);
            System.out.println();
            if (Arrays.equals(traitementEtCalcul.tabPropositionChiffreJoueur, traitementEtCalcul.tabChiffreMystereOrdinateur)) {
                break;
            }

            //traitement ordinateur vs joueur
            traitementEtCalcul.testProposition();
            traitementEtCalcul.compareMasterMind(traitementEtCalcul.tabChiffreMystereJoueur, traitementEtCalcul.tabPropositionChiffreMystereOrdinateur, traitementEtCalcul.propositionChiffreMystereOrdinateur);
            System.out.println();

        }
        while (!Arrays.equals(traitementEtCalcul.tabChiffreMystereJoueur, traitementEtCalcul.tabPropositionChiffreMystereOrdinateur) && !Arrays.equals(traitementEtCalcul.tabPropositionChiffreJoueur, traitementEtCalcul.tabChiffreMystereOrdinateur) && traitementEtCalcul.compteur != configuration.getNbrEssai());

        if (Arrays.equals(traitementEtCalcul.tabPropositionChiffreJoueur, traitementEtCalcul.tabChiffreMystereOrdinateur)) {
            System.out.println("Bravo vous avez gagné la réponse est " + traitementEtCalcul.chiffreMystereOrdinateur);
        } else if (Arrays.equals(traitementEtCalcul.tabPropositionChiffreMystereOrdinateur, traitementEtCalcul.tabChiffreMystereJoueur)) {
            System.out.println("L'ordinateur à gagné, la réponse est " + traitementEtCalcul.chiffreMystereJoueur);
        } else {
            System.out.println("Désolé vous avez perdu tous les deux ");
            System.out.println("La combinaison du joueur était " + traitementEtCalcul.chiffreMystereJoueur);
            System.out.println("La combinaison de l'ordinateur était " + traitementEtCalcul.chiffreMystereOrdinateur);
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
        menuTraitement.selectedEndGameMode(2, 3, traitementEtCalcul.choixFinJeux);


    }

}
