package com.projet3.chiffremystere;

import com.projet3.traitementcalcul.TraitementEtCalcul;

import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 */
public class ChiffreMystereChallengerMode extends TraitementEtCalcul {





    public void runChiffreMystereChallengerMode(){
        runConfiguration();


        System.out.println("**********        *******************************                     *******************");
        System.out.println("**********        **Master Mind Challenger Mode**                     *******************");
        System.out.println("**********        *******************************                     *******************");
        System.out.println();

        if ( saisieJoueur.equalsIgnoreCase("true" )){
            chiffreMystereOrdinateur = generateNumber(nbrAleatoireMinimum,nbrAleatoireMaximum);
            System.out.println("Le chiffre Mystere de l'ordinateur est enregistré");
            tabChiffreMystereOrdinateur = decoupeChiffreMystereOrdinateur(chiffreMystereOrdinateur);

            System.out.println("Saisie de votre proposition");

            try {
                propositionChiffreJoueur = sc.nextLine();
            } catch ( NumberFormatException e ) {
                System.out.println("Erreur de saisie ");;
            }


        }
        System.out.println("L'ordinateur réfléchi à un chiffre mystère\n");
        chiffreMystereOrdinateur = generateNumber();

        if ( modeDeveloppeur.equalsIgnoreCase("true")){
            System.out.println("Mode développeur activé");
            System.out.println("Le chiffre mystère de l'ordinateur est " + chiffreMystereOrdinateur);
        }else
        {
            System.out.println("pas de mode particulier");
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
        }while (choixFinJeux < 1 || choixFinJeux > 3);

        menuGameSelection.selectedEndGameMode(1,1,choixFinJeux);


    }


}
