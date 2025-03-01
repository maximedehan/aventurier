
import java.io.IOException;
import java.util.ArrayList;
import utils.SpecialStringsUtils;

public class Aventure {

  /*
    Cette méthode contient toute la logique du code avec son algorithme décrit grâce aux commentaires.
  */
  public void run(String fileTest) {
	
	String cartePath = "files/carte v2.txt"; // La carte ne bouge pas donc cette string est écrite en dur ...
	String guidePath = "files/" + fileTest; // Par contre, ici, nous avons besoin de donner la main à l'utilisateur pour faciliter les tests.
	
	// Initialisation des variables de déplacements
	int coordX = 0; // coordonnée du déplacement horizontal
	int coordY = 0; // coordonnée du déplacement vertical
	String[] directions = null; // directions du fichier guide.txt
	String[][] matrixCarte = null; // contiendra la représentation matricielle de la carte (plus facile à manipuler)
	
    try {
	  ReaderFiles reader = new ReaderFiles(cartePath, guidePath);
	  
	  // Récupération des données du fichier guide.txt (les coordonnées (x,y) et les directions)
	  ArrayList<String> dataGuide = reader.getDataGuide();
	  String[] coordXY = dataGuide.get(0).split(SpecialStringsUtils.COMMA);	
	  coordX = Integer.parseInt(coordXY[0]);
	  coordY = Integer.parseInt(coordXY[1]);
	  directions = dataGuide.get(1).split(SpecialStringsUtils.BLANK);
	  
	  // Transformation de la carte en matrice pour faciliter le traitement des déplacements
	  matrixCarte = reader.getMatrixCarte();
    } catch (IOException e) {
	  // Au cas où un problème technique survient au niveau du reader ou du buffer ou si un fichier n'existe pas ...
      System.err.println("Erreur sur un fichier détectée !");
      System.err.println(e);
	  System.exit(0); // On sort du code dans le cas d'une erreur technique.
    }
		  
	// Paul peut se déplacer sur la carte grâce à ses coordonnées d'origine, son "gps" (les directions) et grâce à la carte matrixée
	Aventurier paul = new Aventurier(coordX, coordY, directions, matrixCarte);
	paul.move();
  }
}
