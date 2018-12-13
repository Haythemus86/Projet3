package main.java.projet3.mastermind;

import main.java.projet3.opc.Main;
import main.java.projet3.traitementcalcul.TraitementEtCalcul;

import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 */
public class MasterMindChallengerMode extends TraitementEtCalcul{

    public void runMasterMindChallengerMode(){
       //Lecture du fichier de configuration
        runConfiguration();

        //Affichage du mode de jeux
        System.out.println("**********        *******************************                     *******************");
        System.out.println("**********        **Master Mind Challenger Mode**                     *******************");
        System.out.println("**********        *******************************                     *******************");

        //Pré configuration de la partie
        if (configurationJeux.equalsIgnoreCase("false")){
            chiffreMystereOrdinateur = generateNumber();
        }else{
            chiffreMystereOrdinateur = generateNumber(nbrCases);

        }

        //Permet d'afficher la solution en mode développeur
        if ( modeDeveloppeur.equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("Deoppeur")){
            System.out.println("Le combinaison généré par l'ordinateur est  " + chiffreMystereOrdinateur);
        }
        tabChiffreMystereOrdinateur = decoupeChiffreMystereOrdinateur(chiffreMystereOrdinateur);


        do {
            compteur++;

            //Partie joueur
            if (configurationJeux.equalsIgnoreCase("false")) {
                do {
                    System.out.println("Entrez une combinaison à 4 chiffres");
                    propositionChiffreJoueur = sc.nextLine();
                    nbrEssai = 10;
                } while (!propositionChiffreJoueur.matches(regex) || propositionChiffreJoueur.length() != 4);
            } else {
                do {
                    System.out.println("Entrez une combinaison à " + nbrCases + " chiffres");
                    propositionChiffreJoueur = sc.nextLine();
                } while (!propositionChiffreJoueur.matches(regex) || propositionChiffreJoueur.length() != nbrCases);
            }
            tabPropositionChiffreJoueur = decoupePropositionChiffreJoueur(propositionChiffreJoueur);


            //Comparaison et calcul
           // compareMasterMind(tabChiffreMystereOrdinateur, tabPropositionChiffreJoueur, propositionChiffreJoueur);
        }while (!propositionChiffreJoueur.equalsIgnoreCase(chiffreMystereOrdinateur) && compteur != nbrEssai);

        if (propositionChiffreJoueur.equalsIgnoreCase(chiffreMystereOrdinateur)){
            System.out.println("Bravo vous avez gagné!!!!!");
        }else{
            System.out.println("Dommage vous avez perdu!! la réponse était " + chiffreMystereOrdinateur);
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
        menuGameSelection.selectedEndGameMode(2,1,choixFinJeux);
    }



    }


