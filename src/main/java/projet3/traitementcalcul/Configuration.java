package main.java.projet3.traitementcalcul;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * Created by i-tem on 21/11/2018.
 * Class permettant la création et la lecture de fichier de configuration
 * @author Haythem
 * @version 1.0
 */
public abstract class Configuration {

    final static Logger logger = Logger.getLogger(Configuration.class);
    protected String modeDeveloppeur = "false", saisieJoueur = "false", configurationJeux = "false";
    protected int nbrAleatoireMinimum, nbrAleatoireMaximum, nbrEssai = 10, nbrCases;

    /**
     * Methode permetant de lancer la configuration du jeux
     */
    public void runConfiguration() {
        // ecrireFichierConfiguration();
        lireFichierConfiguration();
    }


    /**
     * Methode permetant l ecriture d un fichier de configuration.properties pour configurer le jeux
     */
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


    /**
     * Methode permetant la lecture d un fichier de configuration config.properties existant
     */
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
