package images;

import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;

/**
 * La classe des images du Predateur
 * 
 * @author BEN YAHIA Heidy
 * @author DEHALANI Seny
 */
public class ImagesPredateur extends Images{
	
	/**
	 * initialise les images du Predateur pour chaque face et applique le filtre
	 */
	public ImagesPredateur(){
		
		setDroiteHautFace(Toolkit.getDefaultToolkit().getImage("DroiteHautFacePredateur.PNG"));
		setDroiteHautDos(Toolkit.getDefaultToolkit().getImage("DroiteHautDosPredateur.PNG"));
		setDroiteBasFace(Toolkit.getDefaultToolkit().getImage("DroiteBasFacePredateur.PNG"));
		setDroiteBasDos(Toolkit.getDefaultToolkit().getImage("DroiteBasDosPredateur.PNG"));
		setGaucheHautFace(Toolkit.getDefaultToolkit().getImage("GaucheHautFacePredateur.PNG"));
		setGaucheHautDos(Toolkit.getDefaultToolkit().getImage("GaucheHautDosPredateur.PNG"));
		setGaucheBasFace(Toolkit.getDefaultToolkit().getImage("GaucheBasFacePredateur.PNG"));
		setGaucheBasDos(Toolkit.getDefaultToolkit().getImage("GaucheBasDosPredateur.PNG"));
		
		setDroiteHautFace(Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(getDroiteHautFace().getSource(), new imageTransparente()))); 
		setDroiteHautDos(Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(getDroiteHautDos().getSource(), new imageTransparente()))); 
		setDroiteBasFace(Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(getDroiteBasFace().getSource(), new imageTransparente()))); 
		setDroiteBasDos(Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(getDroiteBasDos().getSource(), new imageTransparente()))); 
		setGaucheHautFace(Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(getGaucheHautFace().getSource(), new imageTransparente()))); 
		setGaucheHautDos(Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(getGaucheHautDos().getSource(), new imageTransparente()))); 
		setGaucheBasFace(Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(getGaucheBasFace().getSource(), new imageTransparente()))); 
		setGaucheBasDos(Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(getGaucheBasDos().getSource(), new imageTransparente()))); 
	}	
	
}
