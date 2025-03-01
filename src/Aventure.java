import exceptions.ObstacleException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import utils.DirectionsUtils;
import utils.SpecialStringsUtils;

public class Aventure {
	
  String carteV2 = "files/carte v2.txt";
  String guide = "files/guide.txt";

  public Aventure() {
  }

  public void run() {
	
	// Initialisation des variables de déplacements
	int coordX = 0; // coordonnée déplacement horizontal
	int coordY = 0; // coordonnée déplacement vertical
	String[] directions = null; // directions de la 2ème ligne du fichier guide.txt
	String[][] matrixCarte = new String[20][20]; // représentation matricielle de la carte
	
    try {
	  // Lecture du fichier de guide
      FileReader readerGuide = new FileReader(guide); 
	  BufferedReader bufferedReaderGuide = new BufferedReader(readerGuide);
	  String line;
	  ArrayList<String> linesGuide = new ArrayList<String>();
	  while ((line = bufferedReaderGuide.readLine()) != null) {
		line.replaceAll(SpecialStringsUtils.ESC, SpecialStringsUtils.BLANK); // On enlève les espaces trouvés dans la ligne
		linesGuide.add(line);
      }
	  
	  // Sauvegarde des données (coordonnées x, y, les directions)
	  String[] coordXY = linesGuide.get(0).split(SpecialStringsUtils.COMMA);
	  coordX = Integer.parseInt(coordXY[0]); 
	  coordY = Integer.parseInt(coordXY[1]);
	  directions = linesGuide.get(1).split(SpecialStringsUtils.BLANK);
	  
	  bufferedReaderGuide.close();
      readerGuide.close();
	  
	  // Transformation de la carte en matrice pour faciliter le traitement des déplacements
	  FileReader readerCarte = new FileReader(carteV2); 
	  BufferedReader bufferedReaderCarte = new BufferedReader(readerCarte);
	  int i = 0;
	  while ((line = bufferedReaderCarte.readLine()) != null) {
		for (int j=0; j<line.split(SpecialStringsUtils.BLANK).length; j++) {
			matrixCarte[i][j] = line.split(SpecialStringsUtils.BLANK)[j];
		}
		i++;
	  }
	  
	  bufferedReaderCarte.close();
      readerCarte.close();

    } catch (IOException e) {
      System.out.println("There has been an IO exception!");
      System.out.println(e);
    }
		  
	// Déplacements sur la carte 
	System.out.printf("  Initialisation du déplacement en (%d,%d)\n", coordX, coordY);
	String labelDirection = SpecialStringsUtils.BLANK;
	try {
		for (String direction : directions) {
		switch (direction) {
			case DirectionsUtils.SUD:
				coordY++;
				labelDirection = DirectionsUtils.LABEL_SUD;
				break;
			case DirectionsUtils.EST:
				coordX++;
				labelDirection = DirectionsUtils.LABEL_EST;
				break;
			case DirectionsUtils.NORD:
				coordY--;
				labelDirection = DirectionsUtils.LABEL_NORD;
				break;
			case DirectionsUtils.OUEST:
				coordX--;
				labelDirection = DirectionsUtils.LABEL_OUEST;
				break;
		 }
		 String valMatrix = matrixCarte[coordY][coordX];
		 System.out.print(valMatrix); 
		 System.out.print(SpecialStringsUtils.ESC);
		 if (valMatrix.equals(SpecialStringsUtils.HASH)) {
			throw new ObstacleException();
		 } else if (coordX < 0 || coordX > 20 || coordY < 0 || coordY > 20) {
			throw new ArrayIndexOutOfBoundsException();
		 } else {
			 System.out.printf("Déplacement %s (%d,%d)\n", labelDirection, coordX, coordY);
		 }
	 }
	 System.out.printf("  Fin du déplacement en (%d,%d)\n", coordX, coordY);
	} catch (ArrayIndexOutOfBoundsException e) {
		System.out.printf("Déplacement %s impossible (vous sortez de la carte en (%d,%d)) \n", labelDirection, coordX, coordY);
	} catch (ObstacleException e) {
		System.out.printf("Déplacement %s impossible (bois imperméable en (%d,%d)) \n", labelDirection, coordX, coordY);
	}
  }
}
