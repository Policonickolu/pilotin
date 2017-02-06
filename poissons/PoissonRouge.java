package poissons;

import images.ImagesPoissonRouge;
import java.awt.Image;
import bassins.BassinPilotin;

/**
 * La classe du Poisson Rouge
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class PoissonRouge extends Poisson{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Si le poisson suit le Pilotin
	 */
	private boolean suivrePilotin;
	
	/**
	 * Images du poisson
	 */
	private static ImagesPoissonRouge imagesPoisson;
	
	/**
	 * thread moteur du poisson
	 */
	private Calcul calculPosition; 
	
	/**
	 * constructeur
	 * @param bassin
	 */
	public PoissonRouge(BassinPilotin bassin){
		super(bassin);
		this.suivrePilotin = false;
		imagesPoisson = new ImagesPoissonRouge();
		this.calculPosition = new Calcul();
		
	}
	
	/**
	 * constructeur
	 * @param p
	 */
	public PoissonRouge(PoissonRouge p){
		super(p);
		this.suivrePilotin = p.suivrePilotin;
		imagesPoisson = new ImagesPoissonRouge();
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
		
		Image image = imagesPoisson.getDroiteBasFace();
		if(z==1 || z==0){
			if(y==1 || y==0){
				if(x==1){
					image = imagesPoisson.getDroiteBasFace();
				}
				else if(x==-1 || x==0){
					image = imagesPoisson.getGaucheBasFace();
				}	
			}
			if(y==-1){
				if(x==1){
					image = imagesPoisson.getDroiteHautFace();
				}
				else if(x==-1 || x==0){
					image = imagesPoisson.getGaucheHautFace();
				}	
			}
		}
		else if(z==-1){			
			if(y==1 || y==0){
				if(x==1){
					image = imagesPoisson.getDroiteBasDos();
				}
				else if(x==-1 || x==0){
					image = imagesPoisson.getGaucheBasDos();
				}	
			}
			if(y==-1){
				if(x==1){
					image = imagesPoisson.getDroiteHautDos();
				}
				else if(x==-1 || x==0){
					image = imagesPoisson.getGaucheHautDos();
				}	
			}		
		}
		return image.getScaledInstance(pos,pos,Image.SCALE_DEFAULT);
	}

	/**
	 * recupere les images du poisson
	 * @return
	 */
	public ImagesPoissonRouge getImagesPoisson() {
		return imagesPoisson;
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
			// valeurs aleatoires utiles pour le calcul de position 
			double randomX = Math.random();
			double randomY = Math.random();
			double randomZ = Math.random();
			int randomX2 = (Math.random() > 0.5 ? 1 : -1);
			int randomY2 = (Math.random() > 0.5 ? 1 : -1);
			int randomZ2 = (Math.random() > 0.5 ? 1 : -1);
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
				// si le Pilotin est present dans le bassin
				if(((BassinPilotin) getBassin()).getPilotin()!=null){
					Pilotin p = ((BassinPilotin) getBassin()).getPilotin();
					// s'il se trouve dans le rayon du Poisson, le poisson le suit en se placant derriere a une certaine distance
					// calculee par les valeurs aleatoires
					if(Math.abs(getPosition().getX()-p.getPosition().getX())<=100 
							&& Math.abs(getPosition().getY()-p.getPosition().getY())<=100 
							&& Math.abs(getPosition().getZ()-p.getPosition().getZ())<=10){						
						int x = p.getPosition().getX() 
							+ ((int) (randomX * getPosition().getZ()) 
									* (p.getDirection().getX() != 0 ? p.getDirection().getX()*-1 : randomX2));                                              
						int y = p.getPosition().getY() 
							+ ((int) (randomY * getPosition().getZ()) 
									* (p.getDirection().getY() != 0 ? p.getDirection().getY()*-1 : randomY2)); 
						int z = p.getPosition().getZ() 
							+ ((int) (randomZ * 5) 
									* (p.getDirection().getZ() != 0 ? p.getDirection().getZ()*-1 : randomZ2)); 
						setDestination(new Point(x,y,z));
					}
				}
			}
		}
	}	
}
