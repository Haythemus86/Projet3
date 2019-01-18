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
public class Configuration {

    private final static Logger logger = Logger.getLogger(Configuration.class);
    private String modeDeveloppeur = "false", saisieJoueur = "false", configurationJeux = "false";
    private int nbrEssai = 10;
    private int nbrCases;
    private int chiffreUtilisable;
    private String regexFinal = new String();
    private static Configuration instance = new Configuration();

    private Configuration (){


    }

    public void setNbrEssai(int nbrEssai) {
        this.nbrEssai = nbrEssai;
    }

    public String getModeDeveloppeur() {
        return modeDeveloppeur;
    }

    public String getSaisieJoueur() {
        return saisieJoueur;
    }

    public String getConfigurationJeux() {
        return configurationJeux;
    }

    public int getNbrEssai() {
        return nbrEssai;
    }

    public int getNbrCases() {
        return nbrCases;
    }

    public int getChiffreUtilisable() {
        return chiffreUtilisable;
    }

    public String getRegexFinal() {
        return regexFinal;
    }

    public static Configuration getInstance(){
        return instance;

    }

    /**
     * Methode permetant de lancer la configuration du jeux
     */
    public void runConfiguration() {
        // ecrireFichierConfiguration();
        lireFichierConfiguration();


        regexFinal = "[0-" + Integer.toString(chiffreUtilisable - 1)+"]+";
    }


    /**
     * Methode permetant l ecriture d un fichier de configuration.properties pour configurer le jeux
     */
    protected void ecrireFichierConfiguration() {

        Properties p = new Properties();
        OutputStream os = null;
        try {
            os = new FileOutputStream("./src/main/resources/config.properties");

            p.setProperty("DeveloppeurMode", "true");
            p.setProperty("nbrEssai", "10");
            p.setProperty("chiffreUtilisable","4");
            p.store(os, null);
        } catch (FileNotFoundException e) {
            logger.debug("Fichier de configuration non trouvé");


        } catch (IOException e) {
            logger.debug("Erreur ecriture fichier");


        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }


    /**
     * Methode permetant la lecture d un fichier de configuration config.properties existant
     */
    protected void lireFichierConfiguration() {

        Properties p = new Properties();

        try (InputStream is = new FileInputStream("./src/main/resources/config.properties")) {

            p.load(is);
        } catch (FileNotFoundException e) {
            logger.debug("Fichier de configuration non trouvé");
        } catch (IOException e) {
            logger.debug("Impossible de charger le fichier de configuration");
        }



        nbrEssai = Integer.parseInt(p.getProperty("nbrEssai"));
        modeDeveloppeur = p.getProperty("developpeurMode");
        nbrCases = Integer.parseInt(p.getProperty("nbrCases"));
        configurationJeux = p.getProperty("configurationJeux");
        chiffreUtilisable = Integer.parseInt(p.getProperty("chiffreUtilisable"));

        //Permet de forcer la valeur de chiffreUtilisable si la  valeur saisi dans config.properties est  < 4 ou > 10
        if ( this.chiffreUtilisable < 4 ){
            this.chiffreUtilisable = 10;
        }else if ( this.chiffreUtilisable > 10){
            this.chiffreUtilisable = 10 ;
        }else{}



    }
}
