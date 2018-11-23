package com.projet3.opc;

import com.projet3.menu.MenuGameSelection;

public class Main {

    public static String modeDeveloppeur ="";

    public static void main(String[] args) {

        //Parametre qui permet d'activer le mode developpeur au lancement de l'application
        modeDeveloppeur = args[0];

        //Lancement du jeux
        MenuGameSelection menuGameSelection = new MenuGameSelection();
        menuGameSelection.runMenuGameSelection();




    }
}
