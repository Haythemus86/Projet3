package main.java.projet3.opc;


import main.java.projet3.menu.MenuGameSelection;
import org.apache.log4j.Logger;


public class Main {

    public static String modeDeveloppeur ="";



    public static void main(String[] args) {


        //Parametre qui permet d'activer le mode developpeur au lancement de l'application


                if ( args.length == 0){
                    modeDeveloppeur ="false";
                }else{
                    modeDeveloppeur = args[0];
                }



        //Lancement du jeux
        MenuGameSelection menuGameSelection = new MenuGameSelection();
        menuGameSelection.runMenuGameSelection();






    }
}
