package main.java.projet3.menu;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 */
public class MenuGameSelection extends MenuTraitement {

    final static Logger logger = Logger.getLogger(MenuGameSelection.class);

    public void runMenuGameSelection() {


        do {


            displayGameSelection();
            System.out.println("Merci de faire un choix");

            try {
                choixJeux = sc.nextInt();
            } catch (InputMismatchException e) {
                logger.debug("Erreur de saisie, merci de saisir des chiffres");

            }
            sc.nextLine();
        } while (choixJeux < 1 || choixJeux > 2);


        do {
            displayGameModeSelection();
            System.out.println("Merci de faire un choix");

            try {
                choixModeJeux = sc.nextInt();
            } catch (InputMismatchException e) {
                logger.debug("Erreur de saisie, merci de saisir des chiffres");
            }
            sc.nextLine();

            selectedGameMode(choixJeux, choixModeJeux);
        } while (choixModeJeux < 1 || choixModeJeux > 3);


    }


    public void displayGameSelection() {
        System.out.println("*********         *******************          **********");
        System.out.println("*********         *Menu De Selection*          **********");
        System.out.println("*********         *******************          **********");
        System.out.println("*********                                      **********");
        System.out.println("*********          1_ Jeux Combinaison Mystère   ********");
        System.out.println("*********          2_ Jeux du MasterMind         ********");
        System.out.println("*********                                        ********");
        System.out.println("*********                                        ********");
        System.out.println("*********************************************************");
    }

    public void displayGameModeSelection() {
        System.out.println("*********     *******************              **********");
        System.out.println("*********     *MENU MODE DE JEUX*              **********");
        System.out.println("*********     *******************              **********");
        System.out.println("*********                                      **********");
        System.out.println("*********    1_ Mode Challenger                **********");
        System.out.println("*********    2_ Mode Défenseur                 **********");
        System.out.println("*********    3_ Mode Duel                      **********");
        System.out.println("*********                                      **********");
        System.out.println("*********                                      **********");
        System.out.println("*********************************************************");
    }


    public void displayEndGameSelection() {
        System.out.println("*********     ******************                **********");
        System.out.println("*********     *MENU FIN DE JEUX*                **********");
        System.out.println("*********     ******************                **********");
        System.out.println("*********                                       **********");
        System.out.println("*********    1_ Recommencer                     **********");
        System.out.println("*********    2_ Retour Choix Jeux               **********");
        System.out.println("*********    3_ Quitter l'application           **********");
        System.out.println("*********                                       **********");
        System.out.println("*********                                       **********");
        System.out.println("**********************************************************");

    }


}