package com.projet3.menu;

import com.projet3.chiffremystere.ChiffreMystereChallengerMode;
import com.projet3.chiffremystere.ChiffreMystereDefenseurMode;
import com.projet3.chiffremystere.ChiffreMystereDuelMode;
import com.projet3.mastermind.MasterMindChallengerMode;
import com.projet3.mastermind.MasterMindDefenseurMode;
import com.projet3.mastermind.MasterMindDuelMode;

import java.util.Scanner;

/**
 * Created by i-tem on 21/11/2018.
 */
public abstract class MenuTraitement {

    protected Scanner sc = new Scanner(System.in);
    protected int choixJeux, choixModeJeux;




    public void SelectedGameMode(int choixJeux, int choixModeJeux){
        if ( choixJeux == 1){
            switch (choixModeJeux){
                case 1 :{
                    ChiffreMystereChallengerMode chiffreMystereChallengerMode = new ChiffreMystereChallengerMode();
                    chiffreMystereChallengerMode.runChiffreMystereChallengerMode();
                    break;
                }
                case 2 :{
                    ChiffreMystereDefenseurMode chiffreMystereDefenseurMode = new ChiffreMystereDefenseurMode();
                    chiffreMystereDefenseurMode.runChiffreMystereDefenseurMode();
                    break;

                }
                case 3 :{
                    ChiffreMystereDuelMode chiffreMystereDuelMode = new ChiffreMystereDuelMode();
                    chiffreMystereDuelMode.runChiffreMystereDuelMode();
                }
                default :{
                    System.out.println("Vous n'avez pas fait de choix valide, merci de faire un nouveau choix");
                    break;
                }
            }
        }else {
            switch (choixModeJeux){
                case 1 :{
                    MasterMindChallengerMode masterMindChallengerMode = new MasterMindChallengerMode();
                    masterMindChallengerMode.runMasterMindChallengerMode();
                    break;
                }
                case 2 :{
                    MasterMindDefenseurMode masterMindDefenseurMode = new MasterMindDefenseurMode();
                    masterMindDefenseurMode.runMasterMindDefenseurMode();
                    break;
                }
                case 3 :{
                    MasterMindDuelMode masterMindDuelMode = new MasterMindDuelMode();
                    masterMindDuelMode.runMasterMindDuelMode();
                    break;
                }
                default :{
                    System.out.println("Vous n'avez pas fait de choix valide, merci de faire un nouveaux choix");
                    break;
                }

            }
        }
    }
}
