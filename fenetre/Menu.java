package fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import fonctions.BancPoissons;
import fonctions.PhenomenePilotin;

/**
 * Classe de la barre du menu du programme.
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class Menu extends JMenuBar{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * reference a la fenetre principale
	 */
	private FenetrePrincipale vue;
	
	/**
	 * premier sous-menu
	 */
	private JMenu m1 = new JMenu("Simulation...");
	
	/**
	 * option de la fonction Phenomene Pilotin
	 */
	private JRadioButtonMenuItem mi1 = new JRadioButtonMenuItem("Phenomene Pilotin");
	
	/**
	 * option de la fonction Banc de Poissons
	 */
	private JRadioButtonMenuItem mi2 = new JRadioButtonMenuItem("Banc Poisson");	
	
	/**
	 * option pour quitter le programme
	 */
	private JMenuItem mi10 = new JMenuItem("Quitter");
	
	/**
	 * constructeur du menu
	 * @param v la fenetre principale
	 */
	public Menu(FenetrePrincipale v){
		
		this.vue = v;
		
		// ecouteur de clique sur le bouton qui lance la fonction Phenomene Pilotin
		this.mi1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				vue.getFonction().setVisible(false);
				vue.getContentPane().remove(vue.getFonction());
				vue.setFonction(new PhenomenePilotin());
				vue.getContentPane().add(vue.getFonction());
				vue.getContentPane().setVisible(true);
			}
			
		});
		
		// ecouteur de clique sur le bouton qui lance la fonction Banc Poisson
		this.mi2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				vue.getFonction().setVisible(false);
				vue.getContentPane().remove(vue.getFonction());
				vue.setFonction(new BancPoissons());
				vue.getContentPane().add(vue.getFonction());
				vue.getContentPane().setVisible(true);
			}
			
		});
		
		// ecouteur de clique sur le bouton qui ferme le programme
		this.mi10.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);			
			}
			
		});
		
		// groupe de bouttons radio
		ButtonGroup bg = new ButtonGroup();
        bg.add(mi1);
        bg.add(mi2);
        
        // ajout au JMenuBar 
		this.m1.add(mi1);
		this.m1.add(mi2);
		this.m1.addSeparator();
		this.m1.add(mi10);
		
		this.add(m1);
	}

}
