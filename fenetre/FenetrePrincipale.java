package fenetre;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import fonctions.Fonction;
import fonctions.PhenomenePilotin;

/**
 * Classe de la fenetre principale du programme.
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class FenetrePrincipale extends JFrame{
	
	private static final long serialVersionUID = 1L;
	 
	/**
	 * Le menu du programme
	 */
	private Menu menu;
	
	/**
	 * La fonctionnalite du programme en cours
	 */
	private Fonction fonction;
	
	
	/**
	 * constructeur de la fenetre principale
	 */
	public FenetrePrincipale(){		
		
		// initialisation de la fenetre (taille, titre etc)
		this.setSize(906, 755);
		this.setTitle("Pilotin");
		Image i = Toolkit.getDefaultToolkit().getImage("Icone.PNG");
		ImageIcon ii = new ImageIcon(i);
		this.setIconImage(ii.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
		
        // initialisation des variables et affichage
        this.menu = new Menu(this);
		this.fonction = new PhenomenePilotin();

		this.setJMenuBar(this.menu);
		this.getContentPane().add(this.fonction);
		this.setVisible(true);
	}

	/**
	 * 
	 * @return fonction la fonctionnalite du programme en cours
	 */
	public Fonction getFonction() {
		return fonction;
	}

	/**
	 * change la fonctionnalite du programme en cours
	 * @param fonction la nouvelle fonctionnalite
	 */
	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}
	
	

}
