package com.projet3.menu;

import com.projet3.chiffremystere.ChiffreMystereChallengerMode;

import java.util.Scanner;

/**
 * Created by i-tem on 21/11/2018.
 */
public abstract class MenuTraitement {

    protected Scanner sc = new Scanner(System.in);
    protected int choixJeux, choixModeJeux;


    public void selectGame(int choixJeux){

        switch (choixJeux){
            case 1 :{
                MenuChiffreMystere menuChiffreMystere = new MenuChiffreMystere();
                menuChiffreMystere.runMenuChiffreMystere();
                break;
            }
            case 2:{
                MenuMasterMind menuMasterMind = new MenuMasterMind();
                menuMasterMind.runMenuMasterMind();
                break;
            }
            default :{
                System.out.println("Vous n'avez pas fait de choix valide, merci de saisir un nouveau choix");
            }
        }
    }

    public void SelectedGameMode(int choixJeux, int choixModeJeux){
        if ( choixJeux == 1){
            switch (choixModeJeux){
                case 1 :{
                    ChiffreMystereChallengerMode chiffreMystereChallengerMode = new ChiffreMystereChallengerMode();
                    chiffreMystereChallengerMode.runChiffreMystereChallengerMode();
                    break;
                }
                case 2 :{

                }
            }
        }else {
            switch (choixModeJeux){

            }
        }
    }
}
