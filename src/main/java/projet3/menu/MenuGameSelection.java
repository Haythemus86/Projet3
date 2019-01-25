package main.java.projet3.menu;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 * Class contenant l'affichage des différents menu du jeux
 *
 * @author Haythem
 * @version 1.0
 */
public class MenuGameSelection {

    protected MenuTraitement menuTraitement = new MenuTraitement();

    final static Logger logger = Logger.getLogger(MenuGameSelection.class);

    /**
     * methode permetant de lancer la selection des jeux
     */
    public void runMenuGameSelection() {


        do {


            displayGameSelection();
            System.out.println("Merci de faire un choix");

            try {
                menuTraitement.choixJeux = menuTraitement.sc.nextInt();
            } catch (InputMismatchException e) {
                logger.debug("Erreur de saisie, merci de saisir des chiffres");

            }
            menuTraitement.sc.nextLine();
        } while (menuTraitement.choixJeux < 1 || menuTraitement.choixJeux > 2);


        do {
            displayGameModeSelection();
            System.out.println("Merci de faire un choix");

            try {
                menuTraitement.choixModeJeux = menuTraitement.sc.nextInt();
            } catch (InputMismatchException e) {
                logger.debug("Erreur de saisie, merci de saisir des chiffres");
            }
            menuTraitement.sc.nextLine();

            menuTraitement.selectedGameMode(menuTraitement.choixJeux, menuTraitement.choixModeJeux);
        } while (menuTraitement.choixModeJeux < 1 || menuTraitement.choixModeJeux > 3);


    }


    /**
     * Methode affichant les jeux disponibles
     */
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

    /**
     * Methode affichant les modes de jeux disponibles
     */
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


    /**
     * Methode affichant le menu de fin de jeux
     */
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
