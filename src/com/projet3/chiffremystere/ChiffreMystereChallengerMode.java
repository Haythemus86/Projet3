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


        //Permet d afficher la reponse en mode developpeur
        if ( modeDeveloppeur.equalsIgnoreCase("Off") || Main.modeDeveloppeur.equalsIgnoreCase("Deoppeur")){
            System.out.println("ca marche");
        }else{
            System.out.println("ca marche pas");
        }



        //Affichage du mode de jeux
        System.out.println("**********        **********************************                 ************");
        System.out.println("**********        *Chiffre Mystere Challenger Mode *                 ************");
        System.out.println("**********        **********************************                 ************");
        System.out.println();

        System.out.println("L'ordinateur réfléchi à un nombre Mystère");

        if (configurationJeux.equalsIgnoreCase("false")){
            chiffreMystereOrdinateur = generateNumber();
            System.out.println("le chiffre mystere de l'ordi est " + chiffreMystereOrdinateur);
        }else{
            chiffreMystereOrdinateur = generateNumber(nbrAleatoireMinimum,nbrAleatoireMaximum);
            System.out.println("le chiffre mystere de l'ordi est " + chiffreMystereOrdinateur);
        }





        //Lancement de la partie ( Ordinateur)
        //System.out.println("L'ordinateur réfléchi à un chiffre Mystère");









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
