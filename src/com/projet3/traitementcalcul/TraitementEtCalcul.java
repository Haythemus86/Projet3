package com.projet3.traitementcalcul;

import java.util.Random;

/**
 * Created by i-tem on 21/11/2018.
 */
public abstract class TraitementEtCalcul extends Configuration {


    private int nombreAleatoire;


    public void runTraitementEtCalcul(){

    }





    //Chiffre Mystere


    //Master Mind


    //Fonctions pour les deux jeux

    private int generateNumber(int nbrAleatoireMinimum, int nbrAleatoireMaximum){

        Random rand = new Random();

        nombreAleatoire = rand.nextInt( nbrAleatoireMaximum - nbrAleatoireMinimum + 1 ) + nbrAleatoireMinimum ;

        return  nombreAleatoire;
    }

    private int generateNumber(){

        Random rand = new Random();

        nombreAleatoire = rand.nextInt(10000  - 1000 + 1) + 1000 ;

        return nombreAleatoire;
    }


    //Fonction Test
}
