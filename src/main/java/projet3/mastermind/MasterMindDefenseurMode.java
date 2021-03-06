package main.java.projet3.mastermind;

import main.java.projet3.menu.MenuGameSelection;
import main.java.projet3.menu.MenuTraitement;
import main.java.projet3.opc.Main;
import main.java.projet3.traitementcalcul.Configuration;
import main.java.projet3.traitementcalcul.TraitementEtCalcul;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 * Class permettant de lancer le jeux Mastermind Defenseur Mode
 * @author Haythem
 * @version 1.0
 */
public class MasterMindDefenseurMode {

    private final Logger logger = Logger.getLogger(MasterMindDefenseurMode.class);
    private Configuration configuration = Configuration.getInstance();
    private TraitementEtCalcul traitementEtCalcul = new TraitementEtCalcul();
    private MenuGameSelection menuGameSelection = new MenuGameSelection();
    private MenuTraitement menuTraitement = new MenuTraitement();

    public void runMasterMindDefenseurMode() {

        //Lecture du fichier de configuration
        configuration.runConfiguration();

        //Affichage du mode de jeux
        System.out.println("**********        *******************************                     *******************");
        System.out.println("**********        **Master Mind Defenseur Mode**                     *******************");
        System.out.println("**********        *******************************                     *******************");

        //Pré configuration de la partie
        if (configuration.getConfigurationJeux().equalsIgnoreCase("false")) {

            do {
                System.out.println("Veuillez saisir une combinaison  à 4 chiffres ");
                traitementEtCalcul.chiffreMystereJoueur = traitementEtCalcul.sc.nextLine();
                configuration.setNbrEssai(10);
            } while (!traitementEtCalcul.chiffreMystereJoueur.matches(traitementEtCalcul.regex) || traitementEtCalcul.chiffreMystereJoueur.length() != 4);
        } else {
            do {
                System.out.println("Veuillez sasir une combinaison à " + configuration.getNbrCases() + " chiffres , les chiffres utilisables vont de 0 a " + (configuration.getChiffreUtilisable() - 1));
                traitementEtCalcul.chiffreMystereJoueur = traitementEtCalcul.sc.nextLine();
            } while (!traitementEtCalcul.chiffreMystereJoueur.matches(configuration.getRegexFinal()) || traitementEtCalcul.chiffreMystereJoueur.length() != configuration.getNbrCases());
        }

        //Mode développeur activé ou non
        if (configuration.getModeDeveloppeur().equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("off")) {
            System.out.println("Votre combinaison secrète est " + traitementEtCalcul.chiffreMystereJoueur);
            ;
        }

        //Découpe du chiffre mystere du joueur et passage dans un tableau
        traitementEtCalcul.tabChiffreMystereJoueur = traitementEtCalcul.decoupePropositionChiffreJoueur(traitementEtCalcul.chiffreMystereJoueur);

        //Partie Ordinateur
        System.out.println("L'ordinateur réfléchi à une proposition");

        if (configuration.getConfigurationJeux().equalsIgnoreCase("false")) {
            traitementEtCalcul.propositionChiffreMystereOrdinateur = traitementEtCalcul.generateNumberX(4,10);

        } else {
            traitementEtCalcul.propositionChiffreMystereOrdinateur = traitementEtCalcul.generateNumberX(configuration.getNbrCases(),configuration.getChiffreUtilisable());
        }

        traitementEtCalcul.tabPropositionChiffreMystereOrdinateur = traitementEtCalcul.decoupeChiffreMystereOrdinateur(traitementEtCalcul.propositionChiffreMystereOrdinateur);
        System.out.println("Proposition de l'ordinateur " + traitementEtCalcul.propositionChiffreMystereOrdinateur);
        //Test resolution mastermind par ordinateur
        traitementEtCalcul.compareMasterMind(traitementEtCalcul.tabPropositionChiffreMystereOrdinateur, traitementEtCalcul.tabChiffreMystereJoueur, traitementEtCalcul.propositionChiffreMystereOrdinateur);
        traitementEtCalcul.remiseAzero();

        traitementEtCalcul.compteur = 1;
        do {
            traitementEtCalcul.compteur++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.debug("problème avec le threadsleep");
            }
            traitementEtCalcul.testProposition();
            traitementEtCalcul.compareMasterMind(traitementEtCalcul.tabChiffreMystereJoueur, traitementEtCalcul.tabPropositionChiffreMystereOrdinateur, traitementEtCalcul.propositionChiffreMystereOrdinateur);
            System.out.println();
        }
        while ((!Arrays.equals(traitementEtCalcul.tabChiffreMystereJoueur, traitementEtCalcul.tabPropositionChiffreMystereOrdinateur)) && traitementEtCalcul.compteur != configuration.getNbrEssai());

        if (Arrays.equals(traitementEtCalcul.tabPropositionChiffreMystereOrdinateur, traitementEtCalcul.tabChiffreMystereJoueur)) {
            System.out.println("L'ordinateur à gagné !!! La réponse est " + traitementEtCalcul.chiffreMystereJoueur);
        } else {
            System.out.println("L'ordinateur à perdu, la réponse était " + traitementEtCalcul.chiffreMystereJoueur);
        }


        //Affichage Menu fin de Jeux
        do {
            menuGameSelection.displayEndGameSelection();
            System.out.println("Veuillez faire un choix svp");

            try {
                traitementEtCalcul.choixFinJeux = traitementEtCalcul.sc.nextInt();
            } catch (InputMismatchException e) {
                logger.debug("Erreur de saisie, veuillez saisir des chiffres svp");
            }
            traitementEtCalcul.sc.nextLine();
        } while (traitementEtCalcul.choixFinJeux < 1 || traitementEtCalcul.choixFinJeux > 3);
        menuTraitement.selectedEndGameMode(2, 2, traitementEtCalcul.choixFinJeux);
    }


}



