Projet 3 - Mettez votre logique à l'épreuve
===========================================



### Compiler l'application dans Intellij###
1. Ouvrir le projet dans Intellij 
2. Dans la colonne projet, faire un clique droit sur Projet3
3. Séléctionner Open module settings
4. Dans la nouvelle fenêtre séléctionner Artifacts
5. Dans la colonne du milieu cliqué sur le + et selectionné Jar -> From modules with dependencies
6. Dans la nouvelle fenêtre séléctionné votre classe Main dans la case Main Class
7. Cochez en dessous extract to the target jar puis cliquez sur OK pour validé
8. Puis de nouveau cliquez sur OK
9. Un fichier jar contenant l'application sera généré dans le repertoire de sortie.
10. Dans ce meme repertoire, collez le fichier config.properties.
11. Lancez un invité de commande ms-dos et tappez java -jar Projet3.jar
12. L'application se lance, vous pouvez jouer.

###Lancer l'application dans Intellij###
1. Ouvrir le projet dans Intellij
2.Se positionner sur la class Main
3.Cliquez sur Run, puis sur Run Main
4.Le programme se lance dans la console.

##*Attention*##
Si vous souhaitez lancer l'application en mode console dans Intellij, vous devez vous rendre dans le fichier Configuration.java et modifier dans la méthode LireFichierConfiguration la ligne
	  
	  is = new FileInputStream("config.properties");
	   
	   par cette ligne
	   
	   is = new FileInputStream("./src/main/resources/config.properties");
	   
 	  
 	  
 	  
 	  
 	




