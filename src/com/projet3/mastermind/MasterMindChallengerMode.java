package com.projet3.mastermind;

import com.projet3.traitementcalcul.TraitementEtCalcul;
import com.projet3.menu.MenuGameSelection;

import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 */
public class MasterMindChallengerMode extends TraitementEtCalcul{

    public void runMasterMindChallengerMode(){
        System.out.println("**********        *******************************                     *******************");
        System.out.println("**********        **Master Mind Challenger Mode**                     *******************");
        System.out.println("**********        *******************************                     *******************");




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


