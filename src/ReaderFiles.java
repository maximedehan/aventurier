
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import utils.SpecialStringsUtils;

public class ReaderFiles {
	
  public ReaderFiles() {
  }
  
  public ArrayList<String> readGuide(String guide) throws IOException {
	  // Lecture du fichier de guide
      FileReader readerGuide = new FileReader(guide); 
	  BufferedReader bufferedReaderGuide = new BufferedReader(readerGuide);
	  
	  String line;
	  ArrayList<String> linesGuide = new ArrayList<String>();
	  while ((line = bufferedReaderGuide.readLine()) != null) {
		line.replaceAll(SpecialStringsUtils.ESC, SpecialStringsUtils.BLANK); // On enlève les espaces trouvés dans la ligne
		linesGuide.add(line);
      }
	  
	  bufferedReaderGuide.close();
      readerGuide.close();	  
	  
	  return linesGuide;
  }

}
