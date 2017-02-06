package images;

import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.RGBImageFilter;

/**
 * La classe des images des poissons
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class Images {
	
	/**
	 * 
	 */
	private Image droiteHautFace;
	/**
	 * 
	 */
	private Image droiteHautDos;
	/**
	 * 
	 */
	private Image droiteBasFace;
	/**
	 * 
	 */
	private Image droiteBasDos;
	/**
	 * 
	 */
	private Image gaucheHautFace;
	/**
	 * 
	 */
	private Image gaucheHautDos;
	/**
	 * 
	 */
	private Image gaucheBasFace;
	/**
	 * 
	 */
	private Image gaucheBasDos;

	/**
	 * recupere l'image pour le profil indique
	 * @return
	 */
	public Image getDroiteHautFace() {
		return droiteHautFace;
	}
	
	/**
	 * change l'image pour le profil indique
	 * @param droiteHautFace
	 */
	public void setDroiteHautFace(Image droiteHautFace) {
		this.droiteHautFace = droiteHautFace;
	}

	/**
	 * recupere l'image pour le profil indique
	 * @return
	 */
	public Image getDroiteHautDos() {
		return droiteHautDos;
	}

	/**
	 * change l'image pour le profil indique
	 * @param droiteHautDos
	 */
	public void setDroiteHautDos(Image droiteHautDos) {
		this.droiteHautDos = droiteHautDos;
	}

	/**
	 * recupere l'image pour le profil indique
	 * @return
	 */
	public Image getDroiteBasFace() {
		return droiteBasFace;
	}

	/**
	 * change l'image pour le profil indique
	 * @param droiteBasFace
	 */
	public void setDroiteBasFace(Image droiteBasFace) {
		this.droiteBasFace = droiteBasFace;
	}

	/**
	 * recupere l'image pour le profil indique
	 * @return
	 */
	public Image getDroiteBasDos() {
		return droiteBasDos;
	}

	/**
	 * change l'image pour le profil indique
	 * @param droiteBasDos
	 */
	public void setDroiteBasDos(Image droiteBasDos) {
		this.droiteBasDos = droiteBasDos;
	}

	/**
	 * recupere l'image pour le profil indique
	 * @return
	 */
	public Image getGaucheHautFace() {
		return gaucheHautFace;
	}

	/**
	 * change l'image pour le profil indique
	 * @param gaucheHautFace
	 */
	public void setGaucheHautFace(Image gaucheHautFace) {
		this.gaucheHautFace = gaucheHautFace;
	}

	/**
	 * recupere l'image pour le profil indique
	 * @return
	 */
	public Image getGaucheHautDos() {
		return gaucheHautDos;
	}

	/**
	 * change l'image pour le profil indique
	 * @param gaucheHautDos
	 */
	public void setGaucheHautDos(Image gaucheHautDos) {
		this.gaucheHautDos = gaucheHautDos;
	}

	/**
	 * recupere l'image pour le profil indique
	 * @return
	 */
	public Image getGaucheBasFace() {
		return gaucheBasFace;
	}

	/**
	 * change l'image pour le profil indique
	 * @param gaucheBasFace
	 */
	public void setGaucheBasFace(Image gaucheBasFace) {
		this.gaucheBasFace = gaucheBasFace;
	}

	/**
	 * recupere l'image pour le profil indique
	 * @return
	 */
	public Image getGaucheBasDos() {
		return gaucheBasDos;
	}

	/**
	 * change l'image pour le profil indique
	 * @param gaucheBasDos
	 */
	public void setGaucheBasDos(Image gaucheBasDos) {
		this.gaucheBasDos = gaucheBasDos;
	}
	
	/**
	 * Classe gerent la transparence des images
	 * 
	 * tutoriel http://www.siteduzero.com
	 */
	public class imageTransparente extends RGBImageFilter {
	    public imageTransparente () {
	    	canFilterIndexColorModel = true;
	    }
	    //filtre la couleur RGB 25,25,25 pour rendre le fond de l'image transparent
	    public int filterRGB(int x, int y, int rgb) {
	        ColorModel cm = ColorModel.getRGBdefault();
	        int alpha = cm.getAlpha(rgb); 
	        int rouge = cm.getRed(rgb);
	        int vert = cm.getGreen(rgb);
	        int bleu = cm.getBlue(rgb);
	        if (rouge == 25 && vert == 25 && bleu == 25) {
	            alpha = 0 & 0xFF;
	            return  alpha | rouge | vert | bleu;
	        } else{
	        	return rgb;
	        }
	    }
	}
}
