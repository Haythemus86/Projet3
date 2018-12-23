package main.java.projet3.mastermind;

import main.java.projet3.opc.Main;
import main.java.projet3.traitementcalcul.TraitementEtCalcul;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 */
public class MasterMindDuelMode extends TraitementEtCalcul {

    final static Logger logger = Logger.getLogger(MasterMindDuelMode.class);

    public void runMasterMindDuelMode() {
        //Lecture du fichier de configuration
        runConfiguration();


        //Affichage du mode de jeux
        System.out.println("**********        *******************************                     *******************");
        System.out.println("**********        **Master Mind Duel Mode      **                     *******************");
        System.out.println("**********        *******************************                     *******************");

        //Pré configuration de la partie
        if (configurationJeux.equalsIgnoreCase("false")) {

            do {
                System.out.println("Veuillez saisir une combinaison  à 4 chiffres ");
                chiffreMystereJoueur = sc.nextLine();
                nbrEssai = 10;
            } while (!chiffreMystereJoueur.matches(regex) || chiffreMystereJoueur.length() != 4);
        } else {
            do {
                System.out.println("Veuillez sasir une combinaison à " + nbrCases + " chiffres");
                chiffreMystereJoueur = sc.nextLine();
            } while (!chiffreMystereJoueur.matches(regex) || chiffreMystereJoueur.length() != nbrCases);
        }

        //Mode développeur activé ou non
        if (modeDeveloppeur.equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("off")) {
            System.out.println("Votre combinaison secrète est " + chiffreMystereJoueur);
            ;
        }

        System.out.println("Votre combinaison est enregistré");

        //Découpe du chiffre mystere du joueur et passage dans un tableau
        tabChiffreMystereJoueur = decoupePropositionChiffreJoueur(chiffreMystereJoueur);

        System.out.println();
        //Partie Ordinateur
        System.out.println("L'ordinateur réfléchi à une combinaison");

        if (configurationJeux.equalsIgnoreCase("false")) {
            chiffreMystereOrdinateur = generateNumber();

        } else {
            chiffreMystereOrdinateur = generateNumber(nbrCases);
        }

        tabChiffreMystereOrdinateur = decoupeChiffreMystereOrdinateur(chiffreMystereOrdinateur);
        System.out.println("La combinaison de l'ordinateur est enregistré");

        //Permet d'afficher la solution en mode développeur
        if (modeDeveloppeur.equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("On")) {
            System.out.println("Le combinaison généré par l'ordinateur est  ici " + chiffreMystereOrdinateur);
        }


        System.out.println();
        //Partie Joueur
        if (configurationJeux.equalsIgnoreCase("false")) {
            do {
                System.out.println("Entrez une proposition à 4 chiffres");
                propositionChiffreJoueur = sc.nextLine();
                nbrEssai = 10;
            } while (!propositionChiffreJoueur.matches(regex) || propositionChiffreJoueur.length() != 4);
        } else {
            do {
                System.out.println("Entrez une proposition à " + nbrCases + " chiffres");
                propositionChiffreJoueur = sc.nextLine();
            } while (!propositionChiffreJoueur.matches(regex) || propositionChiffreJoueur.length() != nbrCases);
        }
        tabPropositionChiffreJoueur = decoupePropositionChiffreJoueur(propositionChiffreJoueur);
        compteur++;
        //traitement joueur vs ordinateur
        compareMasterMind(tabChiffreMystereOrdinateur, tabPropositionChiffreJoueur, propositionChiffreJoueur);

        if (Arrays.equals(tabPropositionChiffreJoueur, tabChiffreMystereOrdinateur)) {
            System.out.println("bravo vous avez gagné ");

            //Affichage Menu fin de Jeux
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
            menuGameSelection.selectedEndGameMode(2, 3, choixFinJeux);

        }


        System.out.println();

        //Partie Ordinateur
        System.out.println("L'ordinateur réfléchi à une proposition");

        if (configurationJeux.equalsIgnoreCase("false")) {
            propositionChiffreMystereOrdinateur = generateNumber();

        } else {
            propositionChiffreMystereOrdinateur = generateNumber(nbrCases);
        }

        tabPropositionChiffreMystereOrdinateur = decoupePropositionChiffreMystereOrdinateur(propositionChiffreMystereOrdinateur);
        System.out.println("Proposition de l'ordinateur " + propositionChiffreMystereOrdinateur);
        compareMasterMind(tabPropositionChiffreMystereOrdinateur, tabChiffreMystereJoueur, propositionChiffreMystereOrdinateur);
        System.out.println();
        remiseAzero();

        do {


            //Partie Joueur2
            if (configurationJeux.equalsIgnoreCase("false")) {
                do {
                    System.out.println("Entrez une proposition à 4 chiffres");
                    propositionChiffreJoueur = sc.nextLine();

                } while (!propositionChiffreJoueur.matches(regex) || propositionChiffreJoueur.length() != 4);
            } else {
                do {
                    System.out.println("Entrez une proposition à " + nbrCases + " chiffres");
                    propositionChiffreJoueur = sc.nextLine();
                } while (!propositionChiffreJoueur.matches(regex) || propositionChiffreJoueur.length() != nbrCases);
            }
            tabPropositionChiffreJoueur = decoupePropositionChiffreJoueur(propositionChiffreJoueur);
            compteur++;
            //traitement joueur vs ordinateur
            compareMasterMind(tabChiffreMystereOrdinateur, tabPropositionChiffreJoueur, propositionChiffreJoueur);
            System.out.println();
            if (Arrays.equals(tabPropositionChiffreJoueur, tabChiffreMystereOrdinateur)) {
                break;
            }

            //traitement ordinateur vs joueur
            testProposition();
            compareMasterMind(tabChiffreMystereJoueur, tabPropositionChiffreMystereOrdinateur, propositionChiffreMystereOrdinateur);
            System.out.println();

        }
        while (!Arrays.equals(tabChiffreMystereJoueur, tabPropositionChiffreMystereOrdinateur) && !Arrays.equals(tabPropositionChiffreJoueur, tabChiffreMystereOrdinateur) && compteur != nbrEssai);

        if (Arrays.equals(tabPropositionChiffreJoueur, tabChiffreMystereOrdinateur)) {
            System.out.println("Bravo vous avez gagné la réponse est " + chiffreMystereOrdinateur);
        } else if (Arrays.equals(tabPropositionChiffreMystereOrdinateur, tabChiffreMystereJoueur)) {
            System.out.println("L'ordinateur à gagné, la réponse est " + chiffreMystereJoueur);
        } else {
            System.out.println("Désolé vous avez perdu tous les deux ");
            System.out.println("La combinaison du joueur était " + chiffreMystereJoueur);
            System.out.println("La combinaison de l'ordinateur était " + chiffreMystereOrdinateur);
        }


        //Affichage Menu fin de Jeux
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
        menuGameSelection.selectedEndGameMode(2, 3, choixFinJeux);


    }

}
