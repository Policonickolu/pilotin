package images;

import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;

/**
 * La classe des images du poisson rouge simple
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class ImagesPoissonRouge extends Images{

	/**
	 * initialise les images du Pilotin pour chaque face et applique le filtre
	 */
	public ImagesPoissonRouge(){

			setDroiteHautFace(Toolkit.getDefaultToolkit().getImage("DroiteHautFace.PNG"));
			setDroiteHautDos(Toolkit.getDefaultToolkit().getImage("DroiteHautDos.PNG"));
			setDroiteBasFace(Toolkit.getDefaultToolkit().getImage("DroiteBasFace.PNG"));
			setDroiteBasDos(Toolkit.getDefaultToolkit().getImage("DroiteBasDos.PNG"));
			setGaucheHautFace(Toolkit.getDefaultToolkit().getImage("GaucheHautFace.PNG"));
			setGaucheHautDos(Toolkit.getDefaultToolkit().getImage("GaucheHautDos.PNG"));
			setGaucheBasFace(Toolkit.getDefaultToolkit().getImage("GaucheBasFace.PNG"));
			setGaucheBasDos(Toolkit.getDefaultToolkit().getImage("GaucheBasDos.PNG"));
			
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
