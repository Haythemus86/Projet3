package com.projet3.mastermind;

import com.projet3.opc.Main;
import com.projet3.traitementcalcul.TraitementEtCalcul;

import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 */
public class MasterMindDefenseurMode extends TraitementEtCalcul {

    public void runMasterMindDefenseurMode(){

        //Lecture du fichier de configuration
        runConfiguration();

        //Affichage du mode de jeux
        System.out.println("**********        *******************************                     *******************");
        System.out.println("**********        **Master Mind Defenseur Mode**                     *******************");
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

        //Découpe du chiffre mystere du joueur et passage dans un tableau
        tabChiffreMystereJoueur = decoupePropositionChiffreJoueur(chiffreMystereJoueur);

        //Partie Ordinateur
        System.out.println("L'ordinateur réfléchi à une proposition");

        if (configurationJeux.equalsIgnoreCase("false")){
            propositionChiffreMystereOrdinateur = generateNumber();

        }else{
            propositionChiffreMystereOrdinateur = generateNumber(nbrCases);
        }

        tabPropositionChiffreMystereOrdinateur = decoupeChiffreMystereOrdinateur(propositionChiffreMystereOrdinateur);
        System.out.println("Proposition de l'ordinateur " + propositionChiffreMystereOrdinateur);
        //Test resolution mastermind par ordinateur
        compareMasterMind(tabPropositionChiffreMystereOrdinateur,tabChiffreMystereJoueur,propositionChiffreMystereOrdinateur);
        remiseAzero();

        compteur = 1;
        do {
            compteur++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testProposition();
            compareMasterMind(tabChiffreMystereJoueur, tabPropositionChiffreMystereOrdinateur,propositionChiffreMystereOrdinateur);
            System.out.println();
        }while ( (!java.util.Arrays.equals(tabChiffreMystereJoueur,tabPropositionChiffreMystereOrdinateur ))&& compteur != nbrEssai);

        if ( java.util.Arrays.equals(tabPropositionChiffreMystereOrdinateur,tabChiffreMystereJoueur)){
            System.out.println("L'ordinateur à gagné !!! La réponse est " + chiffreMystereJoueur);
        }else{
            System.out.println("L'ordinateur à perdu, la réponse était " + chiffreMystereJoueur);
        }




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
        menuGameSelection.selectedEndGameMode(2,2,choixFinJeux);
    }


    }



