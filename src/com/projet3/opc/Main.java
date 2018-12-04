package com.projet3.opc;

import com.projet3.menu.MenuGameSelection;

public class Main {

    public static String modeDeveloppeur ="";

    public static void main(String[] args) {


        //Parametre qui permet d'activer le mode developpeur au lancement de l'application
        try{
            if ( args[0] != null){
                modeDeveloppeur = args[0];
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("pas de parametre au lancement de l'appli");
        }finally {
            modeDeveloppeur ="false";
        }




        //Lancement du jeux
        MenuGameSelection menuGameSelection = new MenuGameSelection();
        menuGameSelection.runMenuGameSelection();




    }
}
