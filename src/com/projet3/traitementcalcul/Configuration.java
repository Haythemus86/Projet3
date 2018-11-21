package com.projet3.traitementcalcul;

import java.io.*;
import java.util.Properties;

/**
 * Created by i-tem on 21/11/2018.
 */
public abstract class Configuration {

    protected String modeDeveloppeur = "false";
    protected int nbrAleatoireMinimum,nbrAleatoireMaximum,nbrEssai;

    public void runConfiguration(){
        lireFichierConfiguration();
    }


    protected void ecrireFichierConfiguration() {

        Properties p = new Properties();
        OutputStream os = null;
        try {
            os = new FileOutputStream("config.properties");
        } catch (FileNotFoundException e) {
            System.out.println("Fichier de configuration non trouvé");
            e.printStackTrace();
        }

        p.setProperty("DeveloppeurMode", "true");
        p.setProperty("nbrAleatoireMinimum", "100");
        p.setProperty("nbrAleatoireMaximum", "10000");
        p.setProperty("nbrEssai", "10");
        try {
            p.store(os, null);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur d'écriture dans le fichier");
        }


    }


    protected void lireFichierConfiguration() {

        Properties p = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            System.out.println("Fichier de configuration non trouvé");
            e.printStackTrace();
        }
        try {
            p.load(is);
        } catch (IOException e) {
            System.out.println("Impossible de charger le fichier de configuration");
            e.printStackTrace();
        }

        nbrAleatoireMinimum = Integer.parseInt(p.getProperty("nbrAleatoireMinimum"));
        nbrAleatoireMaximum = Integer.parseInt(p.getProperty("nbrAleatoireMaximum"));
        nbrEssai = Integer.parseInt(p.getProperty("nbrEssai"));
        modeDeveloppeur = p.getProperty("DeveloppeurMode");

    }
}
