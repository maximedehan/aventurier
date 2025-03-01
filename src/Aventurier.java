
import exceptions.ObstacleException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import utils.DirectionsUtils;
import utils.SpecialStringsUtils;

public class Aventurier {
	
  private int coordX;
  private int coordY;
  private String[] directions;
  private String[][] matrixCarte;
	
  public Aventurier(int coordX, int coordY, String[] directions, String[][] matrixCarte) {
	  this.coordX = coordX;
	  this.coordY = coordY;
	  this.directions = directions;
	  this.matrixCarte = matrixCarte;
  }
  
  public int getCoordX() {
      return this.coordX;
  }

  public void setCoordX(int coordX) {
      this.coordX = coordX;
  }
  
  public int getCoordY() {
      return this.coordY;
  }

  public void setCoordY(int coordY) {
      this.coordY = coordY;
  }
  
  public String[] getDirections() {
      return this.directions;
  }

  public void setDirections(String[] directions) {
      this.directions = directions;
  }
  
  public String[][] getMatrixCarte() {
      return this.matrixCarte;
  }

  public void setMatrixCarte(String[][] matrixCarte) {
      this.matrixCarte = matrixCarte;
  }
  
  public void move() {
	System.out.printf("  Initialisation du déplacement en (%d,%d)\n", coordX, coordY);
	String labelDirection = SpecialStringsUtils.BLANK;
	
	try {
		for (String direction : this.getDirections()) {
		 labelDirection = this.move1time(direction, this.getCoordX(), this.getCoordY());
		 String valMatrix = matrixCarte[this.getCoordY()][this.getCoordX()];
		 
		 System.out.print(valMatrix); 
		 System.out.print(SpecialStringsUtils.ESC);
		 
		 if (valMatrix.equals(SpecialStringsUtils.HASH)) {
			throw new ObstacleException();
		 } else if (this.getCoordX() < 0 || this.getCoordX() > 20 || this.getCoordY() < 0 || this.getCoordY() > 20) {
			throw new ArrayIndexOutOfBoundsException();
		 } else {
			System.out.printf("Déplacement %s (%d,%d)\n", labelDirection, this.getCoordX(), this.getCoordY());
		 }
	   }
	  System.out.printf("  Fin du déplacement en (%d,%d)\n", this.getCoordX(), this.getCoordY());
	} catch (ArrayIndexOutOfBoundsException e) {
		System.out.printf("Déplacement %s impossible (vous sortez de la carte en (%d,%d)) \n", labelDirection, this.getCoordX(), this.getCoordY());
	} catch (ObstacleException e) {
		System.out.printf("Déplacement %s impossible (bois imperméable en (%d,%d)) \n", labelDirection, this.getCoordX(), this.getCoordY());
	}
  }
  
  public String move1time(String direction, int currentX, int currentY) {
	switch (direction) {
			case DirectionsUtils.SUD:
				this.setCoordY(currentY++);
				labelDirection = DirectionsUtils.LABEL_SUD;
				break;
			case DirectionsUtils.EST:
				this.setCoordX(currentX++);
				labelDirection = DirectionsUtils.LABEL_EST;
				break;
			case DirectionsUtils.NORD:
				this.setCoordY(currentY--);
				labelDirection = DirectionsUtils.LABEL_NORD;
				break;
			case DirectionsUtils.OUEST:
				this.setCoordX(currentX--);
				labelDirection = DirectionsUtils.LABEL_OUEST;
				break;
	}
		 
	return labelDirection; 
  }
}
