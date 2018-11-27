package com.projet3.chiffremystere;

import com.projet3.opc.Main;
import com.projet3.traitementcalcul.TraitementEtCalcul;


import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 */
public class ChiffreMystereChallengerMode extends TraitementEtCalcul {






    public void runChiffreMystereChallengerMode(){


        runConfiguration();
/*
        //Permet d afficher la reponse en mode developpeur
        if ( modeDeveloppeur.equalsIgnoreCase("Off") || Main.modeDeveloppeur.equalsIgnoreCase("Deoppeur")){
            System.out.println("ca marche");
        }else{
            System.out.println("ca marche pas");
        }
*/


        //Affichage du mode de jeux
        System.out.println("**********        **********************************                 ************");
        System.out.println("**********        *Chiffre Mystere Challenger Mode *                 ************");
        System.out.println("**********        **********************************                 ************");
        System.out.println();


        //Pré configuration de la partie
        if (configurationJeux.equalsIgnoreCase("false")){
                chiffreMystereOrdinateur = generateNumber();
                System.out.println("verification du chiffre généré " + chiffreMystereOrdinateur);
        }else{
            chiffreMystereOrdinateur = generateNumber(nbrCases);

        }

        tabChiffreMystereOrdinateur = decoupeChiffreMystereOrdinateur(chiffreMystereOrdinateur);

        //Lancement de la partie ( Ordinateur)
        System.out.println("L'ordinateur réfléchi à un chiffre Mystère");
        if ( modeDeveloppeur.equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("off")){
            System.out.println("Le chiffre mystère de l'ordinateur est " + chiffreMystereOrdinateur);;
        }

        //Verification
        //parcourTableau(tabChiffreMystereOrdinateur);

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
        }while (!java.util.Arrays.equals(tabPropositionChiffreJoueur,tabChiffreMystereOrdinateur) && compteur != nbrEssai);


        if( java.util.Arrays.equals(tabPropositionChiffreJoueur,tabChiffreMystereOrdinateur)){
            System.out.println("Bravo vous avez gagner");
        }else
        {
            System.out.println("Dommage vous avez perdu");
        }


        //Fin du jeux

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

        menuGameSelection.selectedEndGameMode(1,1,choixFinJeux);


    }


}
