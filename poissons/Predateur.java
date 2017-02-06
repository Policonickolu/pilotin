package poissons;

import images.ImagesPredateur;
import java.awt.Image;
import java.util.ArrayList;
import bassins.BassinPilotin;

/**
 * La classe du Predateur
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class Predateur extends Poisson{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Images du poisson
	 */
	private ImagesPredateur imagesPredateur;
	
	/**
	 * si le predateur poursuit une proie
	 */
	private boolean isProie = false;
	
	/**
	 * la proie du predateur
	 */
	private Poisson proie = null;
	
	/**
	 * thread moteur du poisson
	 */
	private Calcul calculPosition; 
	
	/**
	 * vitesse du predateur, il est plus rapide que la plupart des poissons
	 */
	private static int vitesse = 8;
	
	/**
	 * constructeur
	 * @param b
	 */
	public Predateur(BassinPilotin b){
		super(b);
		
		imagesPredateur = new ImagesPredateur();
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
		
		Image image = this.imagesPredateur.getDroiteBasFace();
		if(z==1 || z==0){
			if(y==1 || y==0){
				if(x==1){
					image = this.imagesPredateur.getDroiteBasFace();
				}
				else if(x==-1 || x==0){
					image = this.imagesPredateur.getGaucheBasFace();
				}	
			}
			if(y==-1){
				if(x==1){
					image = this.imagesPredateur.getDroiteHautFace();
				}
				else if(x==-1 || x==0){
					image = this.imagesPredateur.getGaucheHautFace();
				}	
			}
		}
		else if(z==-1){			
			if(y==1 || y==0){
				if(x==1){
					image = this.imagesPredateur.getDroiteBasDos();
				}
				else if(x==-1 || x==0){
					image = this.imagesPredateur.getGaucheBasDos();
				}	
			}
			if(y==-1){
				if(x==1){
					image = this.imagesPredateur.getDroiteHautDos();
				}
				else if(x==-1 || x==0){
					image = this.imagesPredateur.getGaucheHautDos();
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
				// pause de "vitesse" millisecondes
				try {
					sleep(vitesse);
				} catch (InterruptedException e) {}
						
				// deplacement du Poisson d'apres la direction
				getPosition().deplacement(getDirection());
				
				// calcul de la direction par la difference entre la destination et la position
				getDirection().setX((int) Math.signum(getDestination().getX()-getPosition().getX()));
				getDirection().setY((int) Math.signum(getDestination().getY()-getPosition().getY()));
				getDirection().setZ((int) Math.signum(getDestination().getZ()-getPosition().getZ()));
				
				// si la direction est nulle, le Poisson est arrive a destination, on remet une nouvelle destination
				if(getDirection().isZero()){
					nouvelleDestination();
				}
				
				
				BassinPilotin b = (BassinPilotin) getBassin();
				if(isProie == false){
					// recherche d'une proie
					ArrayList<Poisson> al = new ArrayList<Poisson>(b.getPoissons());
					if(b.getPilotin() != null)al.add(b.getPilotin());
					ArrayList<Poisson> al2 = new ArrayList<Poisson>();					
					// parcours de la liste de poissons
					for(int i =0;i<al.size();i++){
						Poisson p = al.get(i);		
						// si un poisson est proche
						if(Math.abs(getPosition().getX()-p.getPosition().getX())<=100 
								&& Math.abs(getPosition().getY()-p.getPosition().getY())<=100 
								&& Math.abs(getPosition().getZ()-p.getPosition().getZ())<=20){
							// il rejoint la liste des poisson proches
							al2.add(p);
						}
					}	
					if(al2.size() < 10 && al2.size() > 0){
						// si le poisson est isole, il devient une proie 
						proie = al2.get(0);
						setDestination(proie.getPosition());
						isProie = true;
					}
				}
				else{
					ArrayList<PoissonRouge> al = new ArrayList<PoissonRouge>(b.getPoissons());
					ArrayList<PoissonRouge> al2 = new ArrayList<PoissonRouge>();
					// calcul du nombre de poisson autour du predateur
					for(int i =0;i<al.size();i++){
						PoissonRouge p = al.get(i);
						if(Math.abs(getPosition().getX()-p.getPosition().getX())<=150 
								&& Math.abs(getPosition().getY()-p.getPosition().getY())<=150 
								&& Math.abs(getPosition().getZ()-p.getPosition().getZ())<=25){
							al2.add(p);
						}
					}
					// en cas de collision avec la proie
					if(collision(proie)){
						// le predateur mange la proie
						if(proie.equals(b.getPilotin())){
							b.removePilotin();
						}
						else{
							b.removePoisson((PoissonRouge)proie);
						}
						isProie = false;
					}
					// si la proie fait partie d'un banc de poisson, le predateur abandonne sa proie 
					if(al2.size() >= 7){
						isProie = false;
						proie = null;
						nouvelleDestination();
						while(!getDirection().isZero()){		
							try {
								sleep(vitesse);
							} catch (InterruptedException e) {}
							getDirection().setX((int) Math.signum(getDestination().getX()-getPosition().getX()));
							getDirection().setY((int) Math.signum(getDestination().getY()-getPosition().getY()));
							getDirection().setZ((int) Math.signum(getDestination().getZ()-getPosition().getZ()));
							
							getPosition().deplacement(getDirection());
						}
					}		
				}
			}
		}
	}
	
	/**
	 * test la collision entre le predateur et sa proie
	 * si vrai, le predateur mange sa proie
	 * 
	 * @param p
	 * @return
	 */
	public boolean collision(Poisson p){

		int z1 = getPosition().getZ();
		int z2 = p.getPosition().getZ();
		int width1 = z1/3;
		int width2 = z2/3;
		int x1 = getPosition().getX()+(z1/3);
		int x2 = p.getPosition().getX()+(z2/3);
		int y1 = getPosition().getY()+(z1/3);
		int y2 = p.getPosition().getY()+(z2/3);
		double x1Xx2 = Math.signum((x1-(x2+width2))*((x1+width1)-x2));
		double y1Xy2 = Math.signum((y1-(y2+width2))*((y1+width1)-y2));
		double z1Xz2 = Math.signum((z1-(z2+width2))*((z1+width1)-z2));
		return (x1Xx2 == y1Xy2 && x1Xx2  == -1.0 && y1Xy2 == -1.0) && (x1Xx2 == z1Xz2 && x1Xx2  == -1.0 && z1Xz2 == -1.0);
	}

	/**
	 * recupere les images du predateur
	 * @return
	 */
	public ImagesPredateur getImagesPredateur() {
		return imagesPredateur;
	}
	
	
}
