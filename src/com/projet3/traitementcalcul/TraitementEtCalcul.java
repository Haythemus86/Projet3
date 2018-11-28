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
    protected int[] tabChiffreMystereOrdinateur, tabPropositionChiffreMystereOrdinateur;
    protected int[] tabPropositionChiffreJoueur, tabChiffreMystereJoueur;
    protected Scanner sc = new Scanner(System.in);
    protected String propositionChiffreJoueur, chiffreMystereJoueur;
    protected MenuGameSelection menuGameSelection = new MenuGameSelection();
    protected String nombreAleatoireString, chiffreMystereOrdinateur, regex ="\\d+", propositionChiffreMystereOrdinateur;
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

    public int[] decoupeChiffreMystereJoueur ( String chiffreMystereJoueur){
        tabChiffreMystereJoueur = new int[chiffreMystereJoueur.length()];

        for ( int i = 0 ; i < chiffreMystereJoueur.length(); i++){
            tabChiffreMystereJoueur[i] = Integer.parseInt(""+chiffreMystereJoueur.charAt(i));
        }

        return tabChiffreMystereJoueur;
    }


    public int[] decoupePropositionChiffreMystereOrdinateur(String propositionChiffreMystereOrdinateur){
        tabPropositionChiffreMystereOrdinateur = new int[propositionChiffreMystereOrdinateur.length()];

        for ( int i = 0 ; i < propositionChiffreMystereOrdinateur.length(); i++){
            tabPropositionChiffreMystereOrdinateur[i] = Integer.parseInt(""+propositionChiffreMystereOrdinateur.charAt(i));
        }
        return tabPropositionChiffreMystereOrdinateur;
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


    public void compareTbaleauChiffreMystereDefenseur( int[] tabChiffreMystereJoueur , int[] tabChiffreMystereOrdinateur , String propositionChiffreMystereOrdinateur,String chiffreMystereJoueur){

        System.out.print("Proposition : " + propositionChiffreMystereOrdinateur + "-> Réponse : " );

        do {
            compteur++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < tabPropositionChiffreMystereOrdinateur.length; i++) {
                if (tabPropositionChiffreMystereOrdinateur[i] < tabChiffreMystereJoueur[i]) {
                    System.out.print("+");
                    tabPropositionChiffreMystereOrdinateur[i] += 1;
                } else if (tabPropositionChiffreMystereOrdinateur[i] > tabChiffreMystereJoueur[i]) {
                    System.out.print("-");
                    tabPropositionChiffreMystereOrdinateur[i] -= 1;
                } else {
                    System.out.print("=");
                }
            }

            System.out.println();


            System.out.print("Proposition : ");
            for (int i = 0; i < tabPropositionChiffreMystereOrdinateur.length; i++) {
                System.out.print(tabPropositionChiffreMystereOrdinateur[i]);
            }
            System.out.print("  Réponse  ->  : ");

        }while (! java.util.Arrays.equals(tabPropositionChiffreMystereOrdinateur, tabChiffreMystereJoueur) && compteur != nbrEssai );

        if (java.util.Arrays.equals(tabPropositionChiffreMystereOrdinateur, tabChiffreMystereJoueur)) {
            System.out.println();
            System.out.print("L'ordinateur a trouver la réponse ! ");
            for (int i = 0; i < tabPropositionChiffreMystereOrdinateur.length; i++) {
                System.out.print(tabPropositionChiffreMystereOrdinateur[i]);
            }
        }else{
            System.out.println("L'ordinateur à perdu");
            System.out.println("La bonne réponse était " + chiffreMystereJoueur );
        }



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
            case 6:{
                nombreAleatoire = rand.nextInt(999999 + 1) + 1;
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
