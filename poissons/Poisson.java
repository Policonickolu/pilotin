package poissons;

import javax.swing.JLabel;
import bassins.Bassin;
import bassins.BassinBanc;
import bassins.BassinPilotin;

/**
 * La classe Poisson
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class Poisson extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * position du poisson
	 */
	private Point position;
	
	/**
	 * destination du poisson
	 */
	private Point destination;
	
	/**
	 * direction du poisson
	 */
	private Point direction;
	
	/**
	 * reference au bassin
	 */
	private Bassin bassin;
	
	/**
	 * vitesse du poisson, parametre du sleep() du thread 
	 */
	private static int vitesse = 10;
	
	/**
	 * constructeur d'un nouveau poisson avec une position et une detination aleatoires
	 * @param bassin du Phenomene Pilotin
	 */
	public Poisson(BassinPilotin bassin){

		this.bassin = bassin;
		this.position = new Point((int) (Math.random() * 550),(int) (Math.random() * 550),(int) ((Math.random() * 40)+20));
		this.destination = new Point((int) (Math.random() * 550),(int) (Math.random() * 550),(int) ((Math.random() * 40)+20));
		this.direction = new Point(0,0,0);		
		this.bassin.add(this, new Integer(2));
		
	}
	
	/**
	 * constructeur d'un nouveau poisson avec une position et une detination aleatoires
	 * @param bassin du Banc de Poissons
	 */
	public Poisson(BassinBanc bassin){

		this.bassin = bassin;
		this.position = new Point((int) (Math.random() * 550),(int) (Math.random() * 550),(int) ((Math.random() * 40)+20));
		this.destination = new Point((int) (Math.random() * 550),(int) (Math.random() * 550),(int) ((Math.random() * 40)+20));
		this.direction = new Point(0,0,0);		
		this.bassin.add(this, new Integer(2));
		
	}
	
	/**
	 * constructeur a partir d'un autre Poisson
	 * @param p
	 */
	public Poisson(Poisson p){
		
		this.bassin = p.bassin;
		this.position = p.position;
		this.destination = p.destination;
		this.direction = p.direction;
		
	}
	
	/**
	 * choisit une nouvelle destination aleatoirement
	 */
	public void nouvelleDestination(){
		this.destination = new Point((int) (Math.random() * (550)), (int) (Math.random() * (550)),(int) ((Math.random() * 40)+20));
	}

	/**
	 * recupere la position du poisson
	 * @return
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * definit la position du poisson
	 * @param position
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * recupere la destination du poisson
	 * @return
	 */
	public Point getDestination() {
		return destination;
	}

	/**
	 * definit la destination du poisson
	 * @param destination
	 */
	public void setDestination(Point destination) {
		this.destination = destination;
	}

	/**
	 * recupere la direction du poisson
	 * @return
	 */
	public Point getDirection() {
		return direction;
	}

	/**
	 * definit la direction du poisson
	 * @param direction
	 */
	public void setDirection(Point direction) {
		this.direction = direction;
	}

	/**
	 * modifie la vitesse des Poissons
	 * @param vitesse
	 */
	public static void setVitesse(int vitesse) {
		Poisson.vitesse = vitesse;
	}

	/**
	 * recupere la vitesse des Poissons
	 * @return
	 */
	public static int getVitesse() {
		return vitesse;
	}

	/**
	 * recupere la reference au bassin
	 * @return
	 */
	public Bassin getBassin() {
		return bassin;
	}
	
}
