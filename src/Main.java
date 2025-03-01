import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
  public static void main(String[] args) {
    String carteV2 = "carte v2.txt";
	String guide = "guide.txt";
	
    try {
	  // Lecture du fichier de guide et sauvegarde des données (coordonnées x, y, les directions)
      FileReader readerGuide = new FileReader(guide); 
	  BufferedReader bufferedReaderGuide = new BufferedReader(readerGuide);
	  String line;
	  ArrayList<String> linesGuide = new ArrayList<String>();
	  while ((line = bufferedReaderGuide.readLine()) != null) {
		line.replaceAll(" ", ""); // On enlève les espaces de la ligne
		linesGuide.add(line);
      }
	  String[] coordXY = linesGuide.get(0).split(",");
	  int coordX = Integer.parseInt(coordXY[0]), coordY = Integer.parseInt(coordXY[1]);
	  String[] arrayDirections = linesGuide.get(1).split("");
	  bufferedReaderGuide.close();
      readerGuide.close();
	  
	  // On transforme la carte en matrice pour faciliter le traitement des déplacements sur la carte
	  FileReader readerCarte = new FileReader(carteV2); 
	  BufferedReader bufferedReaderCarte = new BufferedReader(readerCarte);
	  String[][] matrixCarte = new String[20][20];
	  int i = 0;
	  while ((line = bufferedReaderCarte.readLine()) != null) {
		for (int j=0; j<line.split("").length; j++) {
			matrixCarte[i][j] = line.split("")[j];
		}
		i++;
	  }
	  bufferedReaderCarte.close();
      readerCarte.close();
	  
	  // Déplacement sur la carte 
	  

    } catch (IOException e) {
      System.out.println("There has been an IO exception!");
      System.out.println(e);
    }
  }
  
}
