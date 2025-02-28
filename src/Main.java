import java.io.FileReader;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
	
  public static void main(String[] args) {
    String path = "carte v2.txt";
	
    try {
      FileReader reader = new FileReader(path);  
	  
      while (reader.ready()) {    
        System.out.print((char) reader.read());  
      }    
	  
      reader.close();
    } catch (IOException e) {
      System.out.println("There has been an IO exception!");
      System.out.println(e);
    }
  }
  
}