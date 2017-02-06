package bassins;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import fonctions.PhenomenePilotin;
import poissons.Pilotin;
import poissons.Point;
import poissons.Poisson;
import poissons.PoissonRouge;
import poissons.Predateur;

/**
 * La classe representant le bassin ou nagent les poissons de la fonction Phenomene Pilotin
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class BassinPilotin extends Bassin{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * reference a la fonctionnalite Phenomene Pilotin
	 */
	private PhenomenePilotin phenomenePilotin;
	
	/**
	 * liste des poissons rouges dans le bassin
	 */
	private ArrayList<PoissonRouge> poissons;
	
	/**
	 * presence du Pilotin dans le bassin
	 */
	private boolean isPilotin = false;
	
	/**
	 * Pilotin
	 */
	private Pilotin pilotin = null;
	
	/**
	 * presence du Predateur dans le bassin
	 */
	private boolean isPredateur = false;
	
	/**
	 * predateur
	 */
	private Predateur predateur = null;
	
	/**
	 * choix de la perspective en trois dimensions
	 */
	private boolean is3D = false;
	
	/**
	 * constructeur
	 * @param pp reference a la fonctionnalite Phenomene Pilotin
	 */
	public BassinPilotin(PhenomenePilotin pp){
		
		this.poissons = new ArrayList<PoissonRouge>();
		this.phenomenePilotin = pp;

		// Ecouteur du deplacement du curseur sur le bassin
		
		this.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent arg0) {}

			@Override
			public void mouseMoved(MouseEvent e) {
				
				// le Pilotin va se diriger vers le curseur
				try{
					pilotin.setDestination(new Point(e.getX()-30,e.getY()-30,60));
				}catch(NullPointerException npe){}
			}
			
		});
		
		// thread d'affichage en continue des poissons
		Thread affichage = new Thread(){
						
			public void run(){
				// boucle continue
				while(true){
					// si 3D active
					if(is3D){
						for(int i=0;i<poissons.size();i++){						
							try{
								PoissonRouge p = poissons.get(i);
								// choix de l'image en fonction de la direction du poisson
								Image image = p.setImage(p.getDirection(),p.getPosition().getZ());
								ImageIcon ii = new ImageIcon(image);
								poissons.get(i).setIcon(ii);						
								int width = p.getPosition().getZ();
								int x = (p.getPosition().getX())-(width/2);
								int y = (p.getPosition().getY())-(width/2);
								// deplacement sur l'ecran du poisson en fonction de sa position calcule
								poissons.get(i).setBounds(25+x, 25+y, width, width);
								setLayer(poissons.get(i), new Integer(width));						
							}catch(IndexOutOfBoundsException e){}
							catch(IllegalArgumentException e){}
						}
						if(isPredateur){
							try {
								Predateur p = predateur;
								// choix de l'image en fonction de la direction du poisson
								Image image = p.setImage(p.getDirection(),p.getPosition().getZ());
								ImageIcon ii = new ImageIcon(image);
								p.setIcon(ii);						
								int width = p.getPosition().getZ();
								int x = (p.getPosition().getX())-(width/2);
								int y = (p.getPosition().getY())-(width/2);
								// deplacement sur l'ecran du poisson en fonction de sa position calcule
								p.setBounds(25+x, 25+y, width, width);
								setLayer(predateur, new Integer(width));
							} catch (Exception e) {}
						}
						if(isPilotin){
							try {
								Pilotin p = pilotin;	
								// choix de l'image en fonction de la direction du poisson
								Image image = p.setImage(p.getDirection(),p.getPosition().getZ());
								ImageIcon ii = new ImageIcon(image);
								p.setIcon(ii);						
								int width = p.getPosition().getZ();
								int x = (p.getPosition().getX())-(width/2);
								int y = (p.getPosition().getY())-(width/2);
								// deplacement sur l'ecran du poisson en fonction de sa position calcule
								p.setBounds(25+x, 25+y, width, width);
								setLayer(pilotin, new Integer(width));
							} catch (Exception e) {}
						}
					}else{
						for(int i=0;i<poissons.size();i++){						
							try{
								PoissonRouge p = poissons.get(i);			
								// choix de l'image
								Image image = p.getImagesPoisson().getGaucheBasFace();
								ImageIcon ii = new ImageIcon(image);
								poissons.get(i).setIcon(ii);						
								int width = 60;
								int x = (p.getPosition().getX())-(width/2);
								int y = (p.getPosition().getY())-(width/2);
								// deplacement sur l'ecran du poisson en fonction de sa position calcule
								poissons.get(i).setBounds(25+x, 25+y, width, width);
								setLayer(poissons.get(i), new Integer(width));						
							}catch(IndexOutOfBoundsException e){}
							catch(IllegalArgumentException e){}
						}
						if(isPredateur){
							try {
								Predateur p = predateur;
								// choix de l'image
								Image image = p.getImagesPredateur().getGaucheBasFace();								
								ImageIcon ii = new ImageIcon(image);
								p.setIcon(ii);						
								int width = 70;
								int x = (p.getPosition().getX())-(width/2);
								int y = (p.getPosition().getY())-(width/2);
								// deplacement sur l'ecran du poisson en fonction de sa position calcule
								p.setBounds(25+x, 25+y, width, width);
								setLayer(predateur, new Integer(width));
							} catch (Exception e) {}
						}
						if(isPilotin){
							try {
								Pilotin p = pilotin;	
								// choix de l'image
								Image image = p.getImagesPilotin().getGaucheBasFace();
								ImageIcon ii = new ImageIcon(image);
								p.setIcon(ii);						
								int width = 60;
								int x = (p.getPosition().getX())-(width/2);
								int y = (p.getPosition().getY())-(width/2);
								// deplacement sur l'ecran du poisson en fonction de sa position calcule
								p.setBounds(25+x, 25+y, width, width);
								setLayer(pilotin, new Integer(width));
							} catch (Exception e) {}
						}
					}
				}
			}
		};
		// lancement du thread
		affichage.start();	
	}
	
	/**
	 * ajout d'un poisson
	 */
	public void addPoisson(){
		if(this.poissons.size()<25){
			PoissonRouge p = new PoissonRouge(this);			
			this.poissons.add(p);			
			p.start();
			this.phenomenePilotin.getL1().setText(""+this.getPoissons().size());
			Poisson.setVitesse((int) (10+(this.poissons.size())));
		}		
	}
	
	/**
	 * ajout du Pilotin
	 */
	public void addPilotin(){
		if(this.pilotin == null){
			Pilotin p = new Pilotin(this);
			this.pilotin = p;
			this.isPilotin = true;
			p.start();
			this.phenomenePilotin.getL4().setText("1");
		}	
	}
	
	/**
	 * ajout du Predateur
	 */
	public void addPredateur(){
		if(this.predateur == null){
			Predateur p = new Predateur(this);
			this.predateur = p;	
			this.isPredateur = true;
			p.start();
			this.phenomenePilotin.getL7().setText("1");
		}	
	}
	
	/**
	 * retrait d'un poisson rouge quelconque
	 */
	public void removePoisson(){
		if(this.poissons.size()> 0){	
			this.poissons.get(0).setVisible(false);
			this.poissons.get(0).stop();
			this.remove(this.poissons.remove(0));
			this.phenomenePilotin.getL1().setText(""+this.getPoissons().size());
			Poisson.setVitesse((int) (10+(this.poissons.size())));
		}
	}
	
	/**
	 * retrait d'un poisson rouge en particulier
	 */
	public void removePoisson(PoissonRouge p){
		if(this.poissons.size()> 0){
			p.setVisible(false);
			p.stop();
			this.poissons.remove(p);
			this.remove(p);
			this.phenomenePilotin.getL1().setText(""+this.getPoissons().size());
			Poisson.setVitesse((int) (10+(this.poissons.size())));
		}
	}
	
	/**
	 * retrait du Pilotin
	 */
	public void removePilotin(){
		if(this.pilotin != null){
			this.pilotin.setVisible(false);
			this.pilotin.stop();
			this.remove(this.pilotin);			
			this.pilotin = null;
			this.isPilotin = false;
			this.phenomenePilotin.getL4().setText("0");
		}
	}
	
	/**
	 * retrait de Predateur
	 */
	public void removePredateur(){
		if(this.predateur != null){
			this.predateur.setVisible(false);
			this.predateur.stop();
			this.remove(this.predateur);
			this.predateur = null;
			this.isPredateur = false;
			this.phenomenePilotin.getL7().setText("0");
			
		}
	}	

	/**
	 * recupere la liste des poissons
	 * @return poissons la liste des poissons
	 */
	public ArrayList<PoissonRouge> getPoissons() {
		return poissons;
	}
	
	/**
	 * recupere le Pilotin
	 * @return pilotin
	 */
	public Pilotin getPilotin(){
		return this.pilotin;
	}

	/**
	 * active/desactive la perspective en trois dimensions
	 * @param is3d la nouvelle valeur booleenne
	 */
	public void set3D(boolean is3d) {
		is3D = is3d;
	}	

}
