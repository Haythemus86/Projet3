package com.projet3.chiffremystere;

import com.projet3.traitementcalcul.TraitementEtCalcul;

/**
 * Created by i-tem on 21/11/2018.
 */
public class ChiffreMystereChallengerMode extends TraitementEtCalcul {


    public void runChiffreMystereChallengerMode(){
        runConfiguration();


        System.out.println("**********        *******************************                     *******************");
        System.out.println("**********        **Master Mind Challenger Mode**                     *******************");
        System.out.println("**********        *******************************                     *******************");

        System.out.println("la variable mode dev contient " + modeDeveloppeur);

        System.out.println("L'ordinateur réfléchi à un chiffre mystère\n");

        chiffreMystereOrdinateur = generateNumber();

        if ( modeDeveloppeur.equalsIgnoreCase("true")){
            System.out.println("Mode développeur activé");
            System.out.println("Le chiffre mystère de l'ordinateur est " + chiffreMystereOrdinateur);
        }else
        {
            System.out.println("pas de mode particulier");
        }










    displayEndGameSelection();

    }

    public void displayEndGameSelection(){








        System.out.println("**********************************************************");
        System.out.println("*********    *MENU FIN DE JEUX*                ***********");
        System.out.println("*********     ******************               ***********");
        System.out.println("*********                                      ***********");
        System.out.println("*********    1_ Recommencer la partie           **********");
        System.out.println("*********    2_ Retour à l'écran Titre         ***********");
        System.out.println("*********    3_ Quitter l'application          ***********");
        System.out.println("*********                                      ***********");
        System.out.println("*********                                      ***********");
        System.out.println("**********************************************************");
    }
}
