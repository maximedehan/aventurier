import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
  public static void main(String[] args) {
    String carteV2 = "carte v2.txt";
	String guide = "guide.txt";
	
	int coordX = 0;
	int coordY = 0;
	String[] arrayDirections = null;
	String[][] matrixCarte = new String[20][20];;
	
    try {
	  // Lecture du fichier de guide
      FileReader readerGuide = new FileReader(guide); 
	  BufferedReader bufferedReaderGuide = new BufferedReader(readerGuide);
	  String line;
	  ArrayList<String> linesGuide = new ArrayList<String>();
	  while ((line = bufferedReaderGuide.readLine()) != null) {
		line.replaceAll(" ", ""); // On enlève les espaces de la ligne
		linesGuide.add(line);
      }
	  
	  // Sauvegarde des données (coordonnées x, y, les directions)
	  String[] coordXY = linesGuide.get(0).split(",");
	  coordX = Integer.parseInt(coordXY[0]); 
	  coordY = Integer.parseInt(coordXY[1]);
	  arrayDirections = linesGuide.get(1).split("");
	  
	  bufferedReaderGuide.close();
      readerGuide.close();
	  
	  // Transformation de la carte en matrice pour faciliter le traitement des déplacements
	  FileReader readerCarte = new FileReader(carteV2); 
	  BufferedReader bufferedReaderCarte = new BufferedReader(readerCarte);
	  int i = 0;
	  while ((line = bufferedReaderCarte.readLine()) != null) {
		for (int j=0; j<line.split("").length; j++) {
			matrixCarte[i][j] = line.split("")[j];
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
	System.out.printf("Initialisation du déplacement en (%d,%d)\n", coordX, coordY);
	String nomDirection = "";
	try {
		for (String direction : arrayDirections) {
		switch (direction) {
			case "S":
				coordY++;
				nomDirection = "au Sud";
				break;
			case "E":
				coordX++;
				nomDirection = "à l\'Est";
				break;
			case "N":
				coordY--;
				nomDirection = "au Nord";
				break;
			case "O":
				coordX--;
				nomDirection = "à l\'Ouest";
				break;
		 }
		 String valMatrix = matrixCarte[coordY][coordX];
		 System.out.print(valMatrix); 
		 System.out.print(" ");
		 if (valMatrix.equals("#")) {
			throw new Exception();
		 } else if (coordX < 0 || coordX > 20 || coordY < 0 || coordY > 20) {
			throw new ArrayIndexOutOfBoundsException();
		 } else {
			 System.out.printf("Déplacement %s (%d,%d)\n", nomDirection, coordX, coordY);
		 }
	 }
	 System.out.printf("Fin du déplacement en (%d,%d)\n", coordX, coordY);
	} catch (ArrayIndexOutOfBoundsException e) {
		System.out.printf("Déplacement %s impossible (vous sortez de la carte en (%d,%d)) \n", nomDirection, coordX, coordY);
	} catch (Exception e) {
		System.out.printf("Déplacement %s impossible (bois imperméable en (%d,%d)) \n", nomDirection, coordX, coordY);
	}
  }
  
}
