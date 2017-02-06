package poissons;

/**
 * La classe Point representant un point (x,y,z) dans l'espace
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class Point {
	
	/**
	 * position axe X
	 */
	private int x;
	
	/**
	 * position axe Y
	 */
	private int y;
	
	/**
	 * position axe Z
	 */
	private int z;
	
	/**
	 * constructeur
	 * @param x 
	 * @param y
	 * @param z
	 */
	public Point(int x, int y, int z){		
		this.x = x;
		this.y = y;
		this.z = z;		
	}
	
	/**
	 * constructeur
	 * @param p
	 */
	public Point(Point p){
		this.x = p.x;
		this.y = p.y;
		this.z = p.z;
	}

	/**
	 * modification de la position du point en fonction d'un autre point
	 * @param p
	 */
	public void deplacement(Point p){
		this.x += p.x;
		this.y += p.y;
		this.z += p.z;
	}
	
	/**
	 * modification de la position du point en fonction d'un autre point
	 * @param x
	 * @param y
	 * @param z
	 */
	public void deplacement(int x, int y, int z){
		this.x += x;
		this.y += y;
		if(this.z + z >= 20)this.z += z;

	}
	
	/**
	 * verifie si le point est nul : x = y = z = 0
	 * @return
	 */
	public boolean isZero(){
		return x == 0 && y == 0 && z == 0;
	}

	/**
	 * recupere X
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * change X
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * recupere Y
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * change Y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * recupere Z
	 * @return
	 */
	public int getZ() {
		return z;
	}

	/**
	 * change Z
	 * @param z
	 */
	public void setZ(int z) {
		this.z = z;
	}	
	
	/**
	 * verifie que deux points sont confondus
	 * @param p
	 * @return
	 */
	public boolean equals(Point p){
		return x == p.x && y == p.y && z == p.z;
	}
	
	/**
	 * retourne une chaine de caracteres x/y/z
	 */
	public String toString(){
		return x + "/" + y + "/" + z; 
	}
	
}
