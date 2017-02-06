package bassins;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;

/**
 * La classe du bassin ou nagent les poissons
 * 
 * @author BEN YAHIA Heidy
 * @author DEHALANI Seny
 */
public class Bassin extends JLayeredPane{
		
	private static final long serialVersionUID = 1L;

	/**
	 * constructeur du bassin, place simplement l'image de fond
	 */
	public Bassin(){
		Image i = Toolkit.getDefaultToolkit().getImage("fondmarin.jpg");
		JLabel l = new JLabel(new ImageIcon(i));
		l.setBounds(0, 0, 600, 600);
		l.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		this.add(l,new Integer(1));
	}

}
