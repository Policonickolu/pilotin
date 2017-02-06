package poissons;

import images.ImagesPilotin;
import java.awt.Image;
import bassins.BassinPilotin;

/**
 * La classe du poisson noir Pilotin
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class Pilotin extends Poisson{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Images du poisson
	 */
	private ImagesPilotin imagesPilotin;	
	
	/**
	 * thread moteur du poisson
	 */
	private Calcul calculPosition; 
		
	/**
	 * constructeur
	 * @param bassin
	 */
	public Pilotin(BassinPilotin bassin){
		super(bassin);
		this.imagesPilotin = new ImagesPilotin();
		this.calculPosition = new Calcul();
		
	}	
	
	/**
	 * constructeur
	 * @param p
	 */
	public Pilotin(Pilotin p){
		super(p);
		this.imagesPilotin = new ImagesPilotin();
		this.calculPosition = new Calcul();
		
	}	
	
	/**
	 * lancement du thread moteur
	 */
	public void start(){
		this.calculPosition.start();
	}
	
	/**
	 * arret du thread moteur
	 */
	public void stop(){
		this.calculPosition.arret(false);
	}
	
	/**
	 * choisit l'image du poisson en fonction de sa direction
	 * @param p direction
	 * @param pos taille de l'image
	 * @return
	 */
	public Image setImage(Point p, int pos){
		int x = p.getX();
		int y = p.getY();
		int z = p.getZ();
		
		Image image = this.imagesPilotin.getDroiteBasFace();
		if(z==1 || z==0){
			if(y==1 || y==0){
				if(x==1){
					image = this.imagesPilotin.getDroiteBasFace();
				}
				else if(x==-1 || x==0){
					image = this.imagesPilotin.getGaucheBasFace();
				}	
			}
			if(y==-1){
				if(x==1){
					image = this.imagesPilotin.getDroiteHautFace();
				}
				else if(x==-1 || x==0){
					image = this.imagesPilotin.getGaucheHautFace();
				}	
			}
		}
		else if(z==-1){			
			if(y==1 || y==0){
				if(x==1){
					image = this.imagesPilotin.getDroiteBasDos();
				}
				else if(x==-1 || x==0){
					image = this.imagesPilotin.getGaucheBasDos();
				}	
			}
			if(y==-1){
				if(x==1){
					image = this.imagesPilotin.getDroiteHautDos();
				}
				else if(x==-1 || x==0){
					image = this.imagesPilotin.getGaucheHautDos();
				}	
			}		
		}
		return image.getScaledInstance(pos,pos,Image.SCALE_DEFAULT);
	}
	
	/**
	 * thread moteur du poisson
	 * 
	 * @author BEN YAHIA Heidy
	 * @author DEHALANI Seny
	 */
	public class Calcul extends Thread{
		
		private boolean b = true;
		
		public void arret(boolean b){
			this.b = b;
		}
				
		public void run(){
			//tant que b est vrai
			while(b){
				// pause de "getVitesse()" millisecondes
				try {
					sleep(getVitesse());
				} catch (InterruptedException e) {}
						
				// calcul de la direction par la difference entre la destination et la position
				getDirection().setX((int) Math.signum(getDestination().getX()-getPosition().getX()));
				getDirection().setY((int) Math.signum(getDestination().getY()-getPosition().getY()));
				getDirection().setZ((int) Math.signum(getDestination().getZ()-getPosition().getZ()));		
				
				// deplacement du Poisson d'apres la direction
				getPosition().deplacement(getDirection());
				
				// si la direction est nulle, le Poisson est arrive a destination, on remet une nouvelle destination
				if(getDirection().isZero()){	
					nouvelleDestination();
				}
			}
		}
	}

	/**
	 * recupere les images du Pilotin
	 * @return
	 */
	public ImagesPilotin getImagesPilotin() {
		return imagesPilotin;
	}
	
}
