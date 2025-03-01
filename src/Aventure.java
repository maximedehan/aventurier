
import exceptions.ObstacleException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import utils.DirectionsUtils;
import utils.SpecialStringsUtils;

public class Aventure {

  public Aventure() {
  }

  public void run() {
	
	String cartePath = "files/carte v2.txt";
	String guidePath = "files/guide.txt";
	
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
      System.out.println("IO exception retournée !");
      System.out.println(e);
    }
		  
	// Déplacements sur la carte 
	Aventurier paul = new Aventurier(coordX, coordY, directions, matrixCarte);
	paul.move();
  }
}
