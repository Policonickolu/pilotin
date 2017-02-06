package images;

import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;

/**
 * La classe des images du Pilotin
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class ImagesPilotin extends Images{
	
	/**
	 * initialise les images du Pilotin pour chaque face et applique le filtre
	 */
	public ImagesPilotin(){
		setDroiteHautFace(Toolkit.getDefaultToolkit().getImage("DroiteHautFaceNoir.PNG"));
		setDroiteHautDos(Toolkit.getDefaultToolkit().getImage("DroiteHautDosNoir.PNG"));
		setDroiteBasFace(Toolkit.getDefaultToolkit().getImage("DroiteBasFaceNoir.PNG"));
		setDroiteBasDos(Toolkit.getDefaultToolkit().getImage("DroiteBasDosNoir.PNG"));
		setGaucheHautFace(Toolkit.getDefaultToolkit().getImage("GaucheHautFaceNoir.PNG"));
		setGaucheHautDos(Toolkit.getDefaultToolkit().getImage("GaucheHautDosNoir.PNG"));
		setGaucheBasFace(Toolkit.getDefaultToolkit().getImage("GaucheBasFaceNoir.PNG"));
		setGaucheBasDos(Toolkit.getDefaultToolkit().getImage("GaucheBasDosNoir.PNG"));
		
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
