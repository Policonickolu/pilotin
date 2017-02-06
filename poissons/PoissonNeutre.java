package poissons;

import images.ImagesPoissonRouge;
import java.awt.Image;
import java.util.ArrayList;
import bassins.BassinBanc;

/**
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class PoissonNeutre extends Poisson{

	private static final long serialVersionUID = 1L;
	
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
	public PoissonNeutre(BassinBanc bassin){
		super(bassin);
		imagesPoisson = new ImagesPoissonRouge();
		this.calculPosition = new Calcul();		
	}
	
	/**
	 * constructeur
	 * @param p
	 */
	public PoissonNeutre(PoissonNeutre p){
		super(p);
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
				
				//Parcours de la liste de poissons
				
				BassinBanc b = (BassinBanc) getBassin();
				ArrayList<Poisson> al = new ArrayList<Poisson>(b.getPoissons());
				ArrayList<Poisson> al2 = new ArrayList<Poisson>();					
				for(int i =0;i<al.size();i++){
					Poisson p = al.get(i);
					
					// si un poisson se trouve proche et qu'il est visible (pas dans le dos) ...
					if(Math.abs(getPosition().getX()-p.getPosition().getX())<=100 &&  Math.abs(getPosition().getX()-p.getPosition().getX())>10
							&& Math.abs(getPosition().getY()-p.getPosition().getY())<=100 && Math.abs(getPosition().getY()-p.getPosition().getY())>10
							&& Math.abs(getPosition().getZ()-p.getPosition().getZ())<=20 && Math.abs(getPosition().getZ()-p.getPosition().getZ())>10
							)
						{
						boolean b1 = true;
						boolean b2 = true;
						boolean b3 = true;
						if(getDirection().getX() != 0){
							if(getDirection().getX() != Math.signum(getDestination().getX()-getPosition().getX())){
								b1 = false;
							}
						}
						if(getDirection().getY() != 0){
							if(getDirection().getY() != Math.signum(getDestination().getY()-getPosition().getY())){
								b2 = false;
							}
						}
						if(getDirection().getZ() != 0){
							if(getDirection().getZ() != Math.signum(getDestination().getZ()-getPosition().getZ())){
								b3 = false;
							}
						}
						// ... il est recupere dans une liste de poissons proches
						if(b1 && b2 && b3) al2.add(p);
					}
				}
				// de cette liste de poissons proches on fait la moyenne de toutes les directions et des destinations
				// pour calculer la direction de ce Poisson. Il va suivre le groupe.
				if(al2.size()>0){
					double destX = 0;
					double destY = 0;
					double destZ = 0;
					double dirX = 0;
					double dirY = 0;
					double dirZ = 0;
					for(int i=0;i<al2.size();i++){
						Poisson p = al2.get(i);
						destX += p.getDestination().getX();
						destY += p.getDestination().getY();
						destZ += p.getDestination().getZ();
						dirX += p.getDirection().getX();
						dirY += p.getDirection().getY();
						dirZ += p.getDirection().getZ();
					}
					getDestination().setX((int) destX/al2.size());
					getDestination().setY((int) destY/al2.size());
					getDestination().setZ((int) destZ/al2.size());
					getDirection().setX((int) Math.signum(dirX));
					getDirection().setY((int) Math.signum(dirY));
					getDirection().setZ((int) Math.signum(dirZ));
					
					getDirection().setX((int) Math.signum(getDestination().getX()-getPosition().getX()+getDirection().getX()));
					getDirection().setY((int) Math.signum(getDestination().getY()-getPosition().getY()+getDirection().getY()));
					getDirection().setZ((int) Math.signum(getDestination().getZ()-getPosition().getZ()+getDirection().getZ()));		
					
					// deplacement du poisson en fonction de la direction et de la destination des poissons proches
					getPosition().deplacement(getDirection());
					
				}else{
					//si la liste de poissons proches est vide, le poisson se deplace normalement 
					// calcul de direction
					getDirection().setX((int) Math.signum(getDestination().getX()-getPosition().getX()));
					getDirection().setY((int) Math.signum(getDestination().getY()-getPosition().getY()));
					getDirection().setZ((int) Math.signum(getDestination().getZ()-getPosition().getZ()));		
					
					// changement de position
					getPosition().deplacement(getDirection());
					
					// nouvelle destination en cas d'arrivee a destination
					if(getDirection().isZero()){	
						nouvelleDestination();
					}
				}		
			}
		}
	}

	/**
	 * recupere les images du poisson
	 * @return
	 */
	public static ImagesPoissonRouge getImagesPoisson() {
		return imagesPoisson;
	}

}
