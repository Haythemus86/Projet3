package main.java.projet3.chiffremystere;

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
 * Class permettant de lancer le jeux Chiffre Mystere Duel Mode
 * @author Haythem
 * @version 1.0
 */
public class ChiffreMystereDuelMode {

    final Logger logger = Logger.getLogger(ChiffreMystereDuelMode.class);
    protected Configuration configuration = Configuration.getInstance();
    protected TraitementEtCalcul traitementEtCalcul = new TraitementEtCalcul();
    protected MenuGameSelection menuGameSelection = new MenuGameSelection();
    protected MenuTraitement menuTraitement = new MenuTraitement();

    public void runChiffreMystereDuelMode() {

        //Lecture du fichier de configuration
        configuration.runConfiguration();

        //Affichage du mode de jeux
        System.out.println("**********        **********************************                 ************");
        System.out.println("**********        *   Chiffre Mystere Duel Mode    *                 ************");
        System.out.println("**********        **********************************                 ************");
        System.out.println();

        //Partie Joueur
        if (configuration.getConfigurationJeux().equalsIgnoreCase("false")) {

            do {
                System.out.println("Veuillez saisir un nombre mystère à 4 chiffres ");
                traitementEtCalcul.chiffreMystereJoueur = traitementEtCalcul.sc.nextLine();
                configuration.setNbrEssai(6);
            } while (!traitementEtCalcul.chiffreMystereJoueur.matches(traitementEtCalcul.regex) || traitementEtCalcul.chiffreMystereJoueur.length() != 4);
        } else {
            do {
                System.out.println("Veuillez saisir un nombre Mystère à " + configuration.getNbrCases() + " chiffres");
                traitementEtCalcul.chiffreMystereJoueur = traitementEtCalcul.sc.nextLine();
            } while (!traitementEtCalcul.chiffreMystereJoueur.matches(traitementEtCalcul.regex) || traitementEtCalcul.chiffreMystereJoueur.length() != configuration.getNbrCases());
        }
        traitementEtCalcul.tabChiffreMystereJoueur = traitementEtCalcul.decoupeChiffreMystereJoueur(traitementEtCalcul.chiffreMystereJoueur);
        System.out.println("Le chiffre mystere du joueur est enregistré");

        //Mode développeur activé ou non
        if (configuration.getModeDeveloppeur().equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("On")) {
            System.out.println("Votre chiffre Mystere est " + traitementEtCalcul.chiffreMystereJoueur);
        }


        //Partie Ordinateur
        if (configuration.getConfigurationJeux().equalsIgnoreCase("false")) {
            traitementEtCalcul.chiffreMystereOrdinateur = traitementEtCalcul.generateNumber();
        } else {
            traitementEtCalcul.chiffreMystereOrdinateur = traitementEtCalcul.generateNumberMasterMind(configuration.getNbrCases(), 10);
        }
        traitementEtCalcul.tabChiffreMystereOrdinateur = traitementEtCalcul.decoupeChiffreMystereOrdinateur(traitementEtCalcul.chiffreMystereOrdinateur);

        System.out.println("Le chiffre mystere de l'ordinateur est enregistré");


        //Mode développeur activé ou non
        if (configuration.getModeDeveloppeur().equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("On")) {
            System.out.println("Le chiffre mystere de l'ordinateur est " + traitementEtCalcul.chiffreMystereOrdinateur);
        }


        //Partie Ordinateur proposition
        if (configuration.getConfigurationJeux().equalsIgnoreCase("false")) {
            traitementEtCalcul.propositionChiffreMystereOrdinateur = traitementEtCalcul.generateNumber();
            configuration.setNbrEssai(6);

        } else {
            traitementEtCalcul.propositionChiffreMystereOrdinateur = traitementEtCalcul.generateNumberMasterMind(configuration.getNbrCases(),10);
        }

        traitementEtCalcul.tabPropositionChiffreMystereOrdinateur = traitementEtCalcul.decoupePropositionChiffreMystereOrdinateur(traitementEtCalcul.propositionChiffreMystereOrdinateur);


        do {
            traitementEtCalcul.compteur++;

            if (configuration.getConfigurationJeux().equalsIgnoreCase("false")) {
                do {
                    System.out.println("Proposition Joueur nombre à 4 chiffres ");
                    traitementEtCalcul.propositionChiffreJoueur = traitementEtCalcul.sc.nextLine();
                } while (!traitementEtCalcul.propositionChiffreJoueur.matches(traitementEtCalcul.regex) || traitementEtCalcul.propositionChiffreJoueur.length() != 4);
            } else {
                do {
                    System.out.println("Proposition Joueur nombre à " + configuration.getNbrCases() + " chiffres ");
                    traitementEtCalcul.propositionChiffreJoueur = traitementEtCalcul.sc.nextLine();
                } while (!traitementEtCalcul.propositionChiffreJoueur.matches(traitementEtCalcul.regex) || traitementEtCalcul.propositionChiffreJoueur.length() != configuration.getNbrCases());

            }
            traitementEtCalcul.tabPropositionChiffreJoueur = traitementEtCalcul.decoupePropositionChiffreJoueur(traitementEtCalcul.propositionChiffreJoueur);

            //Comparaison et calcul joueur --> Ordinateur
            traitementEtCalcul.compareTableauChiffreMystere(traitementEtCalcul.tabChiffreMystereOrdinateur, traitementEtCalcul.tabPropositionChiffreJoueur, traitementEtCalcul.propositionChiffreJoueur);


            //Comparaison et calcul ordinateur --> joueur
            compareTbaleauChiffreMystereDefenseur(traitementEtCalcul.tabPropositionChiffreMystereOrdinateur, traitementEtCalcul.tabChiffreMystereJoueur);
        }
        while (!traitementEtCalcul.propositionChiffreJoueur.equalsIgnoreCase(traitementEtCalcul.chiffreMystereOrdinateur) && !Arrays.equals(traitementEtCalcul.tabPropositionChiffreMystereOrdinateur, traitementEtCalcul.tabChiffreMystereJoueur) && traitementEtCalcul.compteur != configuration.getNbrEssai());

        if (traitementEtCalcul.propositionChiffreJoueur.equalsIgnoreCase(traitementEtCalcul.chiffreMystereOrdinateur)) {
            System.out.println("Bravo vous avez gagné !!!!");
        } else if (Arrays.equals(traitementEtCalcul.tabPropositionChiffreMystereOrdinateur, traitementEtCalcul.tabChiffreMystereJoueur)) {
            System.out.println("L'ordinateur a gagné !!!!");
        } else {
            System.out.println("Personne na gagné, nombre d'essai dépassé");
        }

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

        menuTraitement.selectedEndGameMode(1, 3, traitementEtCalcul.choixFinJeux);

    }


    public void compareTbaleauChiffreMystereDefenseur(int[] tabPropositionChiffreMystereOrdinateur, int[] tabChiffreMystereJoueur) {

        System.out.print("Proposition  Ordinateur : ");
        for (int i = 0; i < tabPropositionChiffreMystereOrdinateur.length; i++) {
            System.out.print(tabPropositionChiffreMystereOrdinateur[i]);

        }
        System.out.print(" Réponse : -> ");

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
        System.out.println();
    }


}
