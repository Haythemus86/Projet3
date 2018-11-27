package com.projet3.traitementcalcul;

import com.projet3.menu.MenuGameSelection;
import com.projet3.opc.Main;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by i-tem on 21/11/2018.
 */
public abstract class TraitementEtCalcul extends Configuration {





    protected int nombreAleatoire, choixFinJeux, compteur = 0;
    protected int[] tabChiffreMystereOrdinateur,tabPropositionChiffreJoueur;
    protected Scanner sc = new Scanner(System.in);
    protected String propositionChiffreJoueur;
    protected MenuGameSelection menuGameSelection = new MenuGameSelection();
    protected String nombreAleatoireString, chiffreMystereOrdinateur, regex ="\\d+";
    private int tailleIdeale;
    private String[] tableauZero = {"0","00","000","0000","00000"};

    public void runTraitementEtCalcul(){
    }





    //Chiffre Mystere

    public int[] decoupeChiffreMystereOrdinateur(String chiffreMystereOrdinateur){
        tabChiffreMystereOrdinateur = new int[chiffreMystereOrdinateur.length()];

        for ( int i = 0 ; i < chiffreMystereOrdinateur.length(); i++){
            tabChiffreMystereOrdinateur[i] = Integer.parseInt(""+chiffreMystereOrdinateur.charAt(i));
        }

        return tabChiffreMystereOrdinateur;
    }

    public int[] decoupePropositionChiffreJoueur(String propositionChiffreJoueur){
        tabPropositionChiffreJoueur = new int[propositionChiffreJoueur.length()];

        for ( int i = 0 ; i < propositionChiffreJoueur.length(); i++){
            tabPropositionChiffreJoueur[i] = Integer.parseInt(""+propositionChiffreJoueur.charAt(i));
        }

        return tabPropositionChiffreJoueur;
    }

    public void compareTableauChiffreMystere (int[] tabChiffreMystereOrdinateur, int[] tabPropositionChiffreJoueur, String propositionChiffreJoueur){


        System.out.print("Proposition : " + propositionChiffreJoueur +" -> Réponse : ");
        for ( int i = 0 ; i < tabChiffreMystereOrdinateur.length; i++){
            if (tabPropositionChiffreJoueur[i] < tabChiffreMystereOrdinateur[i]){
                System.out.print("+");
            }else if (tabPropositionChiffreJoueur[i] > tabChiffreMystereOrdinateur[i]){
                System.out.print("-");
            }else {
                System.out.print("=");
            }

        }

        System.out.println();
    }




    //Master Mind


    //Fonctions pour les deux jeux


    protected String generateNumber(int nbrCases) {
        Random rand = new Random();



        switch ( nbrCases){
            case 4:{
                nombreAleatoire = rand.nextInt(9999 + 1) + 1;
                break;
            }
            case 5:{
                nombreAleatoire = rand.nextInt(99999 + 1) + 1;
                break;
            }
            default:{
                nombreAleatoire = rand.nextInt(999 + 1) + 1;
                break;
            }
        }

        nombreAleatoireString =""+nombreAleatoire;

        tailleIdeale = nbrCases - nombreAleatoireString.length();

        if ( tailleIdeale == 0){

        }
        else{
            nombreAleatoireString = tableauZero[tailleIdeale - 1]+ nombreAleatoire;
        }


        return nombreAleatoireString;




    }

    protected String generateNumber(){

        Random rand = new Random();

        nombreAleatoire = rand.nextInt(9999  - 0 + 1) + 1 ;

        nombreAleatoireString =""+nombreAleatoire;

        tailleIdeale = 4 - nombreAleatoireString.length();

        if ( tailleIdeale == 0){

        }
        else{
            nombreAleatoireString = tableauZero[tailleIdeale - 1]+ nombreAleatoire;
        }


        return nombreAleatoireString;
    }


    //Fonction Test

    public void parcourTableau( int[] tableau){
        System.out.println("verif tableau");
        for ( int i = 0 ; i < tableau.length; i++){
            System.out.print(tableau[i]);
        }
    }
}
