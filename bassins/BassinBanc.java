package bassins;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import fonctions.BancPoissons;
import poissons.Poisson;
import poissons.PoissonNeutre;

/**
 * La classe representant le bassin ou nagent les poissons de la fonction Banc de Poissons
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class BassinBanc extends Bassin{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * reference a la fonctionnalite Banc de Poissons
	 */
	private BancPoissons bancPoissons;
	
	/**
	 * liste des poissons rouges dans le bassin
	 */
	private ArrayList<PoissonNeutre> poissons;
	
	/**
	 * choix de la perspective en trois dimensions
	 */
	private boolean is3D = false;
	
	
	/**
	 * constructeur
	 * @param pp reference a la fonctionnalite Banc de Poissons
	 */
	public BassinBanc(BancPoissons bp){
		
		this.poissons = new ArrayList<PoissonNeutre>();
		this.bancPoissons = bp;
		
		// thread d'affichage en continue des poissons
		
		Thread affichage = new Thread(){
			
			public void run(){
				// boucle continue
				while(true){
					// si 3D active
					if(is3D){
						for(int i=0;i<poissons.size();i++){						
							try{
								PoissonNeutre p = poissons.get(i);	
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
					}else{
						for(int i=0;i<poissons.size();i++){						
							try{
								PoissonNeutre p = poissons.get(i);
								// choix de l'image
								Image image = PoissonNeutre.getImagesPoisson().getGaucheBasFace();
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
			PoissonNeutre p = new PoissonNeutre(this);			
			this.poissons.add(p);			
			p.start();
			this.bancPoissons.getL1().setText(""+this.getPoissons().size());
			Poisson.setVitesse((int) (10+(this.poissons.size())));
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
			this.bancPoissons.getL1().setText(""+this.getPoissons().size());
			Poisson.setVitesse((int) (10+(this.poissons.size())));
		}
	}	

	/**
	 * recupere la liste des poissons
	 * @return poissons la liste des poissons
	 */
	public ArrayList<PoissonNeutre> getPoissons() {
		return poissons;
	}

	/**
	 * active/desactive la perspective en trois dimensions
	 * @param is3d la nouvelle valeur booleenne
	 */
	public void set3D(boolean is3d) {
		is3D = is3d;
	}	
	
}
