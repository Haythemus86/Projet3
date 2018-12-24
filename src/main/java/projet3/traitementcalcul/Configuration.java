package main.java.projet3.traitementcalcul;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * Created by i-tem on 21/11/2018.
 */
public abstract class Configuration {

    final static Logger logger = Logger.getLogger(Configuration.class);
    protected String modeDeveloppeur = "false", saisieJoueur = "false", configurationJeux = "false";
    protected int nbrAleatoireMinimum, nbrAleatoireMaximum, nbrEssai = 10, nbrCases;

    public void runConfiguration() {
        // ecrireFichierConfiguration();
        lireFichierConfiguration();
    }


    protected void ecrireFichierConfiguration() {

        Properties p = new Properties();
        OutputStream os = null;
        try {
            os = new FileOutputStream("./src/main/resources/config.properties");
        } catch (FileNotFoundException e) {
            logger.debug("Fichier de configuration non trouvé");


        }

        p.setProperty("DeveloppeurMode", "true");
        p.setProperty("nbrEssai", "10");
        try {
            p.store(os, null);
        } catch (IOException e) {
            logger.debug("Erreur d'écriture dans le fichier");
        }


    }


    protected void lireFichierConfiguration() {

        Properties p = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream("./src/main/resources/config.properties");
        } catch (FileNotFoundException e) {
            logger.debug("Fichier de configuration non trouvé");
        }
        try {
            p.load(is);
        } catch (IOException e) {
            logger.debug("Impossible de charger le fichier de configuration");
        }


        nbrEssai = Integer.parseInt(p.getProperty("nbrEssai"));
        modeDeveloppeur = p.getProperty("developpeurMode");
        nbrCases = Integer.parseInt(p.getProperty("nbrCases"));
        configurationJeux = p.getProperty("configurationJeux");
    }
}