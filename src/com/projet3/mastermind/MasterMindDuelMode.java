package com.projet3.mastermind;

import com.projet3.opc.Main;
import com.projet3.traitementcalcul.TraitementEtCalcul;

import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 */
public class MasterMindDuelMode extends TraitementEtCalcul {

    public void runMasterMindDuelMode(){
        //Lecture du fichier de configuration
        runConfiguration();

        //Affichage du mode de jeux
        System.out.println("**********        *******************************                     *******************");
        System.out.println("**********        **Master Mind Duel Mode      **                     *******************");
        System.out.println("**********        *******************************                     *******************");

        //Pré configuration de la partie
        if (configurationJeux.equalsIgnoreCase("false")){

            do {
                System.out.println("Veuillez saisir une combinaison  à 4 chiffres ");
                chiffreMystereJoueur = sc.nextLine();
            }while (!chiffreMystereJoueur.matches(regex) || chiffreMystereJoueur.length() != 4);
        }else{
            do {
                System.out.println("Veuillez sasir une combinaison à " + nbrCases + " chiffres");
                chiffreMystereJoueur = sc.nextLine();
            }while ( !chiffreMystereJoueur.matches(regex) || chiffreMystereJoueur.length() != nbrCases);
        }

        //Mode développeur activé ou non
        if ( modeDeveloppeur.equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("off")){
            System.out.println("Votre combinaison secrète est " + chiffreMystereJoueur);;
        }

        System.out.println("Votre combinaison est enregistré");

        //Découpe du chiffre mystere du joueur et passage dans un tableau
        tabChiffreMystereJoueur = decoupePropositionChiffreJoueur(chiffreMystereJoueur);

        System.out.println();
        //Partie Ordinateur
        System.out.println("L'ordinateur réfléchi à une combinaison");

        if (configurationJeux.equalsIgnoreCase("false")){
            chiffreMystereOrdinateur = generateNumber();

        }else{
            chiffreMystereOrdinateur = generateNumber(nbrCases);
        }

        tabChiffreMystereOrdinateur = decoupeChiffreMystereOrdinateur(chiffreMystereOrdinateur);
        System.out.println("La combinaison de l'ordinateur est enregistré");

        //Permet d'afficher la solution en mode développeur
        if ( modeDeveloppeur.equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("Deoppeur")){
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

        //traitement joueur vs ordinateur
        compareMasterMind(tabChiffreMystereOrdinateur, tabPropositionChiffreJoueur, propositionChiffreJoueur);
        System.out.println();

        //Partie Ordinateur
        System.out.println("L'ordinateur réfléchi à une proposition");

        if (configurationJeux.equalsIgnoreCase("false")){
            propositionChiffreMystereOrdinateur = generateNumber();

        }else{
            propositionChiffreMystereOrdinateur = generateNumber(nbrCases);
        }

        tabPropositionChiffreMystereOrdinateur = decoupeChiffreMystereOrdinateur(propositionChiffreMystereOrdinateur);
        System.out.println("Proposition de l'ordinateur " + propositionChiffreMystereOrdinateur);
        compareMasterMind(tabPropositionChiffreMystereOrdinateur,tabChiffreMystereJoueur,propositionChiffreMystereOrdinateur);
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

            //traitement joueur vs ordinateur
            compareMasterMind(tabChiffreMystereOrdinateur, tabPropositionChiffreJoueur, propositionChiffreJoueur);
            System.out.println();

            //traitement ordinateur vs joueur
            testProposition();
            compareMasterMind(tabChiffreMystereJoueur, tabPropositionChiffreMystereOrdinateur,propositionChiffreMystereOrdinateur);
            System.out.println();

        }while ( !java.util.Arrays.equals(tabChiffreMystereJoueur,tabPropositionChiffreMystereOrdinateur) );







        //Affichage Menu fin de Jeux
        do {
            menuGameSelection.displayEndGameSelection();
            System.out.println("Veuillez faire un choix svp");

            try {
                choixFinJeux = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erreur de saisie, veuillez saisir des chiffres svp");
            }
            sc.nextLine();
        }while (choixFinJeux < 1 || choixFinJeux > 3);
        menuGameSelection.selectedEndGameMode(2,3,choixFinJeux);



    }

}
