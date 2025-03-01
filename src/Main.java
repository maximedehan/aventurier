
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.SpecialStringsUtils;

/* 
  Point d'entrée du programme avec pré-filtre 
  sur le nom du fichier de guide saisi par 
  l'utilisateur dans la commande. 
*/
public class Main {
  public static void main(String[] args) {
	 try {
		 Pattern pattern = Pattern.compile(SpecialStringsUtils.PATTERN_NAME_REPO);
		 Matcher matcher = pattern.matcher(args[0]);
		 if (!matcher.find()) {
			 throw new ArrayIndexOutOfBoundsException();
		 }
		 
		 // Si tout est ok, l'aventure peut commencer ...
		 (new Aventure()).run(args[0]);
	 } catch(ArrayIndexOutOfBoundsException e) {
		 // Juste un petit rappel de la façon de lancer le programme en cas de commande erronée.
		 System.err.println("Veuillez saisir un nom de fichier valide à la fin de votre commande.\n Exemple de commande : java Main \"guide test 1.txt\"");
		 System.exit(0); // On sort du code dans le cas d'une erreur technique.
	 }
  }
}
