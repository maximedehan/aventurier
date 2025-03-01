
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import utils.SpecialStringsUtils;

public class ReaderFiles {
	
  private String cartePath;
  private String guidePath;
	
  public ReaderFiles(String cartePath, String guidePath) {
	  this.cartePath = cartePath;
	  this.guidePath = guidePath;
  }
  
  public String getCartePath() {
      return this.cartePath;
  }

  public void setCartePath(String cartePath) {
      this.cartePath = cartePath;
  }
  
  public String getGuidePath() {
      return this.guidePath;
  }

  public void setGuidePath(String guidePath) {
      this.guidePath = guidePath;
  }

  /*
	Cette méthode lit le fichier de guide (ex : "guide test 1.txt") contenant les paramètres d'entrée ...
	Puis les retourne sous forme de tableau dynamique.
  */
  public ArrayList<String> getDataGuide() throws IOException {
      FileReader readerGuide = new FileReader(this.guidePath); 
	  BufferedReader bufferedReaderGuide = new BufferedReader(readerGuide);
	  
	  String line;
	  ArrayList<String> linesGuide = new ArrayList<String>();
	  while ((line = bufferedReaderGuide.readLine()) != null) {
		line.replaceAll(SpecialStringsUtils.ESC, SpecialStringsUtils.BLANK); // On enlève les espaces trouvés dans la ligne au cas où ...
		linesGuide.add(line);
      }
	  
	  // On libère toujours la mémoire des buffers après utilisation.
	  bufferedReaderGuide.close();
      readerGuide.close();	  
	  
	  return linesGuide;
  }
 
  /*
	Cette méthode lit le fichier contenant la carte (ex : "carte v2.txt") ...
	Puis la retourne sous forme d'une matrix plus facile à exploiter en liant le contenu de la carte à des coordonnées (x,y).
  */ 
  public String[][] getMatrixCarte() throws IOException {
	  FileReader readerCarte = new FileReader(this.cartePath); 
	  BufferedReader bufferedReaderCarte = new BufferedReader(readerCarte);
	  
	  String line;
	  int i = 0;
	  String[][] matrixCarte = new String[20][20]; // La taille 20 20 de la carte est en écrite en dur pour le moment.
	  while ((line = bufferedReaderCarte.readLine()) != null) {
		for (int j=0; j<line.split(SpecialStringsUtils.BLANK).length; j++) {
			matrixCarte[i][j] = line.split(SpecialStringsUtils.BLANK)[j];
		}
		i++;
	  }
	  
	  // On libère toujours la mémoire des buffers après utilisation.
	  bufferedReaderCarte.close();
      readerCarte.close();
	  
	  return matrixCarte;
  }
}
