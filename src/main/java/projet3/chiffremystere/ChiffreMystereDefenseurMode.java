package main.java.projet3.chiffremystere;

import main.java.projet3.menu.MenuGameSelection;
import main.java.projet3.menu.MenuTraitement;
import main.java.projet3.opc.Main;
import main.java.projet3.traitementcalcul.Configuration;
import main.java.projet3.traitementcalcul.TraitementEtCalcul;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 * Class permettant de lancer le jeux Chiffre Mystere Defenseur mode
 * @author Haythem
 * @version 1.0
 */
public class ChiffreMystereDefenseurMode {

    final Logger logger = Logger.getLogger(ChiffreMystereChallengerMode.class);
    protected Configuration configuration = Configuration.getInstance();
    protected TraitementEtCalcul traitementEtCalcul = new TraitementEtCalcul();
    protected MenuGameSelection menuGameSelection = new MenuGameSelection();
    protected MenuTraitement menuTraitement = new MenuTraitement();

    public void runChiffreMystereDefenseurMode() {

        //Lecture du fichier de configuration
        configuration.runConfiguration();

        //Affichage du mode de jeux
        System.out.println("**********        **********************************                 ************");
        System.out.println("**********        *Chiffre Mystere Defenseur Mode  *                 ************");
        System.out.println("**********        **********************************                 ************");
        System.out.println();

        //Pré configuration de la partie
        if (configuration.getConfigurationJeux().equalsIgnoreCase("false")) {

            do {
                System.out.println("Veuillez saisir un nombre mystère à 4 chiffres ");
                traitementEtCalcul.chiffreMystereJoueur = traitementEtCalcul.sc.nextLine();
                configuration.setNbrEssai(6);
            } while (!traitementEtCalcul.chiffreMystereJoueur.matches(traitementEtCalcul.regex) || traitementEtCalcul.chiffreMystereJoueur.length() != 4);
        } else {
            do {
                System.out.println("Veuillez sasir un nombre Mystère à " + configuration.getNbrCases() + " chiffres");
                traitementEtCalcul.chiffreMystereJoueur = traitementEtCalcul.sc.nextLine();
            } while (!traitementEtCalcul.chiffreMystereJoueur.matches(traitementEtCalcul.regex) || traitementEtCalcul.chiffreMystereJoueur.length() != configuration.getNbrCases());
        }

        //Mode développeur activé ou non
        if (configuration.getModeDeveloppeur().equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("On")) {
            System.out.println("Votre chiffre Mystere est " + traitementEtCalcul.chiffreMystereJoueur);
        }

        //Découpe du chiffre mystere du joueur et passage dans un tableau
        traitementEtCalcul.tabChiffreMystereJoueur = traitementEtCalcul.decoupePropositionChiffreJoueur(traitementEtCalcul.chiffreMystereJoueur);

        //Partie Ordinateur
        System.out.println("L'ordinateur réfléchi à un chiffre Mystère");

        if (configuration.getConfigurationJeux().equalsIgnoreCase("false")) {
            traitementEtCalcul.propositionChiffreMystereOrdinateur = traitementEtCalcul.generateNumber();
        } else {
            traitementEtCalcul.propositionChiffreMystereOrdinateur = traitementEtCalcul.generateNumberMasterMind(configuration.getNbrCases(),10);
        }

        traitementEtCalcul.tabPropositionChiffreMystereOrdinateur = traitementEtCalcul.decoupeChiffreMystereOrdinateur(traitementEtCalcul.propositionChiffreMystereOrdinateur);

        //Comparaison et calcul
        traitementEtCalcul.compareTbaleauChiffreMystereDefenseur(traitementEtCalcul.tabChiffreMystereJoueur, traitementEtCalcul.tabChiffreMystereOrdinateur, traitementEtCalcul.propositionChiffreMystereOrdinateur, traitementEtCalcul.chiffreMystereJoueur);

        //Fin du jeux
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

        menuTraitement.selectedEndGameMode(1, 2, traitementEtCalcul.choixFinJeux);

    }
}
