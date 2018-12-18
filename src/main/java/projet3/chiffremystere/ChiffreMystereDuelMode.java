package main.java.projet3.chiffremystere;

import main.java.projet3.opc.Main;
import main.java.projet3.traitementcalcul.TraitementEtCalcul;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;

/**
 * Created by i-tem on 21/11/2018.
 */
public class ChiffreMystereDuelMode extends TraitementEtCalcul {

    final static Logger logger = Logger.getLogger(ChiffreMystereDuelMode.class);

    public void runChiffreMystereDuelMode(){

        //Lecture du fichier de configuration
        runConfiguration();


        //Affichage du mode de jeux
        System.out.println("**********        **********************************                 ************");
        System.out.println("**********        *   Chiffre Mystere Duel Mode    *                 ************");
        System.out.println("**********        **********************************                 ************");
        System.out.println();

        //Partie Joueur
        if (configurationJeux.equalsIgnoreCase("false")){

            do {
                System.out.println("Veuillez saisir un nombre mystère à 4 chiffres ");
                chiffreMystereJoueur = sc.nextLine();
            }while (!chiffreMystereJoueur.matches(regex) || chiffreMystereJoueur.length() != 4);
        }else{
            do {
                System.out.println("Veuillez sasir un nombre Mystère à " + nbrCases + " chiffres");
                chiffreMystereJoueur = sc.nextLine();
            }while ( !chiffreMystereJoueur.matches(regex) || chiffreMystereJoueur.length() != nbrCases);
        }
        tabChiffreMystereJoueur = decoupeChiffreMystereJoueur( chiffreMystereJoueur);
        System.out.println("Le chiffre mystere du joueur est enregistré");

        //Mode développeur activé ou non
        if ( modeDeveloppeur.equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("Developpeur")){
            System.out.println("Votre chiffre Mystere est " + chiffreMystereJoueur);;
        }


        //Partie Ordinateur
        if (configurationJeux.equalsIgnoreCase("false")){
            chiffreMystereOrdinateur = generateNumber();
            System.out.println("verification du chiffre généré " + chiffreMystereOrdinateur);
        }else{
            chiffreMystereOrdinateur = generateNumber(nbrCases);

        }
        tabChiffreMystereOrdinateur = decoupeChiffreMystereOrdinateur(chiffreMystereOrdinateur);

        //Mode développeur activé ou non
        if ( modeDeveloppeur.equalsIgnoreCase("On") || Main.modeDeveloppeur.equalsIgnoreCase("Developpeur")){
            System.out.println("Le chiffre mystere de l'ordinateur est " + chiffreMystereOrdinateur);
        }

        //Partie Ordinateur proposition
        if (configurationJeux.equalsIgnoreCase("false")) {
            propositionChiffreMystereOrdinateur = generateNumber();
            System.out.println("verification du chiffre généré " + propositionChiffreMystereOrdinateur);
        } else {
            propositionChiffreMystereOrdinateur = generateNumber(nbrCases);

        }
        tabPropositionChiffreMystereOrdinateur = decoupePropositionChiffreMystereOrdinateur(propositionChiffreMystereOrdinateur);


        do {
            compteur++;

            if (configurationJeux.equalsIgnoreCase("false")) {
                do {
                    System.out.println("Proposition Joueur nombre à 4 chiffres ");
                    propositionChiffreJoueur = sc.nextLine();
                } while (!propositionChiffreJoueur.matches(regex) || propositionChiffreJoueur.length() != 4);
            } else {
                do {
                    System.out.println("Proposition Joueur nombre à " + nbrCases + " chiffres ");
                    propositionChiffreJoueur = sc.nextLine();
                } while (!propositionChiffreJoueur.matches(regex) || propositionChiffreJoueur.length() != nbrCases);

            }
            tabPropositionChiffreJoueur = decoupePropositionChiffreJoueur(propositionChiffreJoueur);

            //Comparaison et calcul joueur --> Ordinateur
            compareTableauChiffreMystere(tabChiffreMystereOrdinateur, tabPropositionChiffreJoueur, propositionChiffreJoueur);



            //Comparaison et calcul ordinateur --> joueur
            compareTbaleauChiffreMystereDefenseur(tabPropositionChiffreMystereOrdinateur, tabChiffreMystereJoueur);
        }while ( !propositionChiffreJoueur.equalsIgnoreCase(chiffreMystereOrdinateur)  && !java.util.Arrays.equals(tabPropositionChiffreMystereOrdinateur,tabChiffreMystereJoueur) && compteur != nbrEssai);

        if (propositionChiffreJoueur.equalsIgnoreCase(chiffreMystereOrdinateur)){
            System.out.println("Bravo vous avez gagné !!!!");
        }else if (java.util.Arrays.equals(tabPropositionChiffreMystereOrdinateur,tabChiffreMystereJoueur)){
            System.out.println("L'ordinateur a gagné !!!!");
        }else{
            System.out.println("Personne na gagné, nombre d'essai dépassé");
        }

        //Fin du jeux
        do {
            menuGameSelection.displayEndGameSelection();
            System.out.println("Veuillez faire un choix svp");
            try {
                choixFinJeux = sc.nextInt();
            } catch (InputMismatchException e) {
                logger.debug("Erreur de saisie, veuillez saisir des chiffres svp");
            }
            sc.nextLine();
        }while (choixFinJeux < 1 || choixFinJeux > 3);

        menuGameSelection.selectedEndGameMode(1,3,choixFinJeux);

    }








    public void compareTbaleauChiffreMystereDefenseur(int[] tabPropositionChiffreMystereOrdinateur, int[] tabChiffreMystereJoueur) {

        System.out.print("Proposition  Ordinateur : ");
        for ( int i = 0 ; i < tabPropositionChiffreMystereOrdinateur.length; i++){
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
