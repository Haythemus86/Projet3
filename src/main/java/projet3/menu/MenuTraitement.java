package main.java.projet3.menu;


import main.java.projet3.chiffremystere.ChiffreMystereChallengerMode;
import main.java.projet3.chiffremystere.ChiffreMystereDefenseurMode;
import main.java.projet3.chiffremystere.ChiffreMystereDuelMode;
import main.java.projet3.mastermind.MasterMindChallengerMode;
import main.java.projet3.mastermind.MasterMindDefenseurMode;
import main.java.projet3.mastermind.MasterMindDuelMode;

import java.util.Scanner;

/**
 * Created by i-tem on 21/11/2018.
 * Class contenant les traitements des différents menu du jeux
 *
 * @author Haythem
 * @version 1.0
 */
public class MenuTraitement {

    protected Scanner sc = new Scanner(System.in);
    protected int choixJeux, choixModeJeux;


    /**
     * Methode traitant le choix du jeux ainsi que le mode de jeux
     *
     * @param choixJeux     variable recevant le jeux auquel le joueur souhaite jouer
     * @param choixModeJeux variable recevant le mode de jeux auquel le joueur souhaite jouer
     */
    public void selectedGameMode(int choixJeux, int choixModeJeux) {
        if (choixJeux == 1) {
            switch (choixModeJeux) {
                case 1: {
                    ChiffreMystereChallengerMode chiffreMystereChallengerMode = new ChiffreMystereChallengerMode();
                    chiffreMystereChallengerMode.runChiffreMystereChallengerMode();
                    break;
                }
                case 2: {
                    ChiffreMystereDefenseurMode chiffreMystereDefenseurMode = new ChiffreMystereDefenseurMode();
                    chiffreMystereDefenseurMode.runChiffreMystereDefenseurMode();
                    break;

                }
                case 3: {
                    ChiffreMystereDuelMode chiffreMystereDuelMode = new ChiffreMystereDuelMode();
                    chiffreMystereDuelMode.runChiffreMystereDuelMode();
                }
                default: {
                    System.out.println("Vous n'avez pas fait de choix valide, merci de faire un nouveau choix");
                    break;
                }
            }
        } else {
            switch (choixModeJeux) {
                case 1: {
                    MasterMindChallengerMode masterMindChallengerMode = new MasterMindChallengerMode();
                    masterMindChallengerMode.runMasterMindChallengerMode();
                    break;
                }
                case 2: {
                    MasterMindDefenseurMode masterMindDefenseurMode = new MasterMindDefenseurMode();
                    masterMindDefenseurMode.runMasterMindDefenseurMode();
                    break;
                }
                case 3: {
                    MasterMindDuelMode masterMindDuelMode = new MasterMindDuelMode();
                    masterMindDuelMode.runMasterMindDuelMode();
                    break;
                }
                default: {
                    System.out.println("Vous n'avez pas fait de choix valide, merci de faire un nouveaux choix");
                    break;
                }

            }
        }
    }


    /**
     * Methode traitant la fin du jeux
     *
     * @param choixJeux     variable recevant le jeux auquel le joueur etait entrain de jouer
     * @param choixModeJeux variable recevant le mode de jeux auquel le joueur etait entrain de jouer
     * @param choixFinJeux  variable recevant le choix du jouer en fin de partie
     */
    public void selectedEndGameMode(int choixJeux, int choixModeJeux, int choixFinJeux) {

        if (choixJeux == 1 && choixModeJeux == 1) {
            switch (choixFinJeux) {
                case 1: {
                    ChiffreMystereChallengerMode chiffreMystereChallengerMode = new ChiffreMystereChallengerMode();
                    chiffreMystereChallengerMode.runChiffreMystereChallengerMode();
                    break;
                }
                case 2: {
                    MenuGameSelection menuGameSelection = new MenuGameSelection();
                    menuGameSelection.runMenuGameSelection();
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Choix Invalide, merci de saisir un nouveau choix");
                }
            }
        } else if (choixJeux == 1 && choixModeJeux == 2) {
            switch (choixFinJeux) {
                case 1: {
                    ChiffreMystereDefenseurMode chiffreMystereDefenseurMode = new ChiffreMystereDefenseurMode();
                    chiffreMystereDefenseurMode.runChiffreMystereDefenseurMode();
                    break;
                }
                case 2: {
                    MenuGameSelection menuGameSelection = new MenuGameSelection();
                    menuGameSelection.runMenuGameSelection();
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Choix non valide");
                    break;
                }

            }
        } else if (choixJeux == 1 && choixModeJeux == 3) {
            switch (choixFinJeux) {
                case 1: {
                    ChiffreMystereDuelMode chiffreMystereDuelMode = new ChiffreMystereDuelMode();
                    chiffreMystereDuelMode.runChiffreMystereDuelMode();
                    break;
                }
                case 2: {
                    MenuGameSelection menuGameSelection = new MenuGameSelection();
                    menuGameSelection.runMenuGameSelection();
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Choix invalide");
                }
            }
        } else if (choixJeux == 2 && choixModeJeux == 1) {
            switch (choixFinJeux) {
                case 1: {
                    MasterMindChallengerMode masterMindChallengerMode = new MasterMindChallengerMode();
                    masterMindChallengerMode.runMasterMindChallengerMode();
                    break;
                }
                case 2: {
                    MenuGameSelection menuGameSelection = new MenuGameSelection();
                    menuGameSelection.runMenuGameSelection();
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
            }

        } else if (choixJeux == 2 && choixModeJeux == 2) {
            switch (choixFinJeux) {
                case 1: {
                    MasterMindDefenseurMode masterMindDefenseurMode = new MasterMindDefenseurMode();
                    masterMindDefenseurMode.runMasterMindDefenseurMode();
                    break;
                }
                case 2: {
                    MenuGameSelection menuGameSelection = new MenuGameSelection();
                    menuGameSelection.runMenuGameSelection();
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
            }

        } else if (choixJeux == 2 && choixModeJeux == 3) {
            switch (choixFinJeux) {
                case 1: {
                    MasterMindDuelMode masterMindDuelMode = new MasterMindDuelMode();
                    masterMindDuelMode.runMasterMindDuelMode();
                    break;
                }
                case 2: {
                    MenuGameSelection menuGameSelection = new MenuGameSelection();
                    menuGameSelection.runMenuGameSelection();
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
            }
        } else {
        }

    }
}
