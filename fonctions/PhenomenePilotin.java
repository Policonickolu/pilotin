package fonctions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import bassins.BassinPilotin;

/**
 * La classe simulant le phenomene Pilotin
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class PhenomenePilotin extends Fonction{
	

	private static final long serialVersionUID = 1L;

	/**
	 * Le bassin ou nagent les poissons
	 */
	private BassinPilotin bassin;
	
	/**
	 * panneau d'option d'ajout et de suppression de poissons rouges
	 */
	private JPanel optionPoissonsRouges;
		private JLabel l1;
		private JLabel l2;
		private JLabel l3;
	/**
	 * panneau d'option d'ajout et de suppression du Pilotin
	 */
	private JPanel optionPilotin;
		private JLabel l4;
		private JLabel l5;
		private JLabel l6;
		
	/**
	 * panneau d'option d'ajout et de suppression du Predateur
	 */	
	private JPanel optionPredateur;
		private JLabel l7;
		private JLabel l8;
		private JLabel l9;
		
	/**
	 * panneau d'option de la perspective en trois dimensions
	 */
	private JPanel option3D;
		private JLabel l10;
		private JLabel l11;
		private JLabel l12;
	
	/**
	 * panneau de description de la fonctionnalite	
	 */	
	private JTextArea texte;	
		
	/**
	 * constructeur de la fonctionnalite Phenomene Pilotin
	 */
	public PhenomenePilotin(){
		
		// initialisation du JPanel
        this.setLayout(null);		
		this.setBackground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension(600,600));		
		
		this.bassin = new BassinPilotin(this);
		this.bassin.setBounds(250, 50, 600, 600);
		
		this.add(this.bassin);
		
		
		//mise en place du panneau d'option des Poissons rouges 
		
		ImageIcon plus = new ImageIcon("plus.PNG");
		ImageIcon moins = new ImageIcon("moins.PNG");
		
		l2 = new JLabel(plus);
		l3 = new JLabel(moins);
		l1 = new JLabel(""+bassin.getPoissons().size());
		
		optionPoissonsRouges = new JPanel();
		optionPoissonsRouges.setLayout(null);
		optionPoissonsRouges.setPreferredSize(new Dimension(150,50));
		optionPoissonsRouges.setBackground(Color.LIGHT_GRAY);
		optionPoissonsRouges.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),"Poissons Rouges"));
		
		l1.setBounds(10, 20, 75, 20);
		l2.setBounds(120, 20, 22, 22);
		l3.setBounds(90,20, 22, 22);

		l2.addMouseListener(new MouseListener(){
			ImageIcon plus = new ImageIcon("plus.PNG");
			ImageIcon plusclicked = new ImageIcon("plusclicked.PNG");
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				l2.setIcon(plusclicked);	
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				l2.setIcon(plus);	
				bassin.addPoisson();
				l1.setText(""+bassin.getPoissons().size());
			}
			
		});
		
		l3.addMouseListener(new MouseListener(){
			ImageIcon moins = new ImageIcon("moins.PNG");
			ImageIcon moinsclicked = new ImageIcon("moinsclicked.PNG");
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				l3.setIcon(moinsclicked);
				bassin.removePoisson();
				l1.setText(""+bassin.getPoissons().size());
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				l3.setIcon(moins);				
			}
			
		});
		
		//mise en place du panneau d'option du Pilotin
		
		l5 = new JLabel(plus);
		l6 = new JLabel(moins);
		l4 = new JLabel("0");
		
		optionPilotin = new JPanel();
		optionPilotin.setLayout(null);
		optionPilotin.setPreferredSize(new Dimension(150,50));
		optionPilotin.setBackground(Color.LIGHT_GRAY);
		optionPilotin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),"Pilotin"));
		
		l4.setBounds(10, 20, 75, 20);
		l5.setBounds(120, 20, 22, 22);
		l6.setBounds(90,20, 22, 22);

		l5.addMouseListener(new MouseListener(){
			ImageIcon plus = new ImageIcon("plus.PNG");
			ImageIcon plusclicked = new ImageIcon("plusclicked.PNG");
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				l5.setIcon(plusclicked);
				bassin.addPilotin();
				l4.setText("1");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				l5.setIcon(plus);				
			}
			
		});
		
		l6.addMouseListener(new MouseListener(){
			ImageIcon moins = new ImageIcon("moins.PNG");
			ImageIcon moinsclicked = new ImageIcon("moinsclicked.PNG");
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				l6.setIcon(moinsclicked);
				bassin.removePilotin();
				l4.setText("0");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				l6.setIcon(moins);				
			}
			
		});
		
		//mise en place du panneau d'option du Predateur
		
		l8 = new JLabel(plus);
		l9 = new JLabel(moins);
		l7 = new JLabel("0");
		
		optionPredateur = new JPanel();
		optionPredateur.setLayout(null);
		optionPredateur.setPreferredSize(new Dimension(150,50));
		optionPredateur.setBackground(Color.LIGHT_GRAY);
		optionPredateur.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),"Predateur"));
		
		l7.setBounds(10, 20, 75, 20);
		l8.setBounds(120, 20, 22, 22);
		l9.setBounds(90,20, 22, 22);

		l8.addMouseListener(new MouseListener(){
			ImageIcon plus = new ImageIcon("plus.PNG");
			ImageIcon plusclicked = new ImageIcon("plusclicked.PNG");
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				l8.setIcon(plusclicked);
				bassin.addPredateur();
				l7.setText("1");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				l8.setIcon(plus);				
			}
			
		});
		
		l9.addMouseListener(new MouseListener(){
			ImageIcon moins = new ImageIcon("moins.PNG");
			ImageIcon moinsclicked = new ImageIcon("moinsclicked.PNG");
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				l9.setIcon(moinsclicked);
				bassin.removePredateur();
				l7.setText("0");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				l9.setIcon(moins);				
			}
			
		});
		
		//mise en place du panneau d'option de la perspective en trois dimensions 
		
		l11 = new JLabel(plus);
		l12 = new JLabel(moins);
		l10 = new JLabel("Desactive");
		
		option3D = new JPanel();
		option3D.setLayout(null);
		option3D.setPreferredSize(new Dimension(150,50));
		option3D.setBackground(Color.LIGHT_GRAY);
		option3D.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),"Deplacement 3D"));
		
		l10.setBounds(10, 20, 75, 20);
		l11.setBounds(120, 20, 22, 22);
		l12.setBounds(90,20, 22, 22);

		l11.addMouseListener(new MouseListener(){
			ImageIcon plus = new ImageIcon("plus.PNG");
			ImageIcon plusclicked = new ImageIcon("plusclicked.PNG");
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				l11.setIcon(plusclicked);
				bassin.set3D(true);
				l10.setText("Active");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				l11.setIcon(plus);				
			}
			
		});
		
		l12.addMouseListener(new MouseListener(){
			ImageIcon moins = new ImageIcon("moins.PNG");
			ImageIcon moinsclicked = new ImageIcon("moinsclicked.PNG");
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				l12.setIcon(moinsclicked);
				bassin.set3D(false);
				l10.setText("Desactive");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				l12.setIcon(moins);				
			}
			
		});
		
		//changement du font des panneaux d'option et ajout des Labels aux panneaux
		
		l1.setFont(new Font("",Font.BOLD,20));
		optionPoissonsRouges.add(l1);
		optionPoissonsRouges.add(l2);
		optionPoissonsRouges.add(l3);		
		
		l4.setFont(new Font("",Font.BOLD,20));
		optionPilotin.add(l4);
		optionPilotin.add(l5);
		optionPilotin.add(l6);

		l7.setFont(new Font("",Font.BOLD,20));
		optionPredateur.add(l7);
		optionPredateur.add(l8);
		optionPredateur.add(l9);
		
		l10.setFont(new Font("",Font.BOLD,12));
		option3D.add(l10);
		option3D.add(l11);
		option3D.add(l12);
		
		optionPoissonsRouges.setBounds(50, 50, 150, 50);
		optionPilotin.setBounds(50, 110, 150, 50);
		optionPredateur.setBounds(50,170,150,50);
		option3D.setBounds(50,230,150,50);
		
		
		//mise en place du texte descriptif de l'application
		
		this.texte = new JTextArea("Les poissons rouges se deplacent aleatoirement. " +
				"Lorsqu'ils croisent Pilotin le poisson noir, " +
				"ils se placent derriere lui et le suivent. Le predateur mange les poissons qu'il croise mais " +
				"il ne s'approche pas des groupes de poissons trop nombreux.");
		texte.setFont(new Font("",Font.BOLD,12));
		texte.setBounds(50, 290, 150, 360);
		texte.setBackground(Color.LIGHT_GRAY);
		texte.setFocusable(false);
		texte.setLineWrap(true);
		texte.setWrapStyleWord(true);
		texte.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),"Phenomene Pilotin"));
		
		
		// ajout des panneaux au JPanel principal
		
		this.add(optionPoissonsRouges);
		this.add(optionPilotin);	
		this.add(optionPredateur);
		this.add(option3D);
		this.add(texte);
		
	}

	/**
	 * recupere la reference du Label affichant le nombre de poissons rouges
	 * @return
	 */
	public JLabel getL1() {
		return l1;
	}

	/**
	 * recupere la reference du Label affichant le nombre de Pilotins
	 * @return
	 */
	public JLabel getL4() {
		return l4;
	}

	/**
	 * recupere la reference du Label affichant le nombre de Predateurs
	 * @return
	 */
	public JLabel getL7() {
		return l7;
	}	
	
}
