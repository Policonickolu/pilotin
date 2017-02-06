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
import bassins.BassinBanc;

/**
 * La classe simulant le phenomene de banc de poisson naturel sans meneur
 * 
* @author BEN YAHIA Heidy
* @author DEHALANI Seny
*/
public class BancPoissons extends Fonction{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Le bassin ou nagent les poissons
	 */
	private BassinBanc bassin;
	/**
	 * panneau d'option d'ajout et de suppression de poissons rouges
	 */
	private JPanel optionPoissonsRouges;
		private JLabel l1;
		private JLabel l2;
		private JLabel l3;
		
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
	 * constructeur de la fonctionnalite du Banc de Poissons
	 */
	public BancPoissons(){
		
		// initialisation du JPanel
        this.setLayout(null);		
		this.setBackground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension(600,600));		
		
		this.bassin = new BassinBanc(this);
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
		optionPoissonsRouges.setBounds(50, 50, 150, 50);

		l10.setFont(new Font("",Font.BOLD,12));
		option3D.add(l10);
		option3D.add(l11);
		option3D.add(l12);
		option3D.setBounds(50,110,150,50);
		
		
		//mise en place du texte descriptif de l'application
		
		this.texte = new JTextArea("Les poissons rouges se deplacent aleatoirement. " +
				"Lorsqu'un poisson en croise d'autres, il adopte la même direction que celle du groupe.");				
		texte.setFont(new Font("",Font.BOLD,12));
		texte.setBounds(50, 290, 150, 360);
		texte.setBackground(Color.LIGHT_GRAY);
		texte.setFocusable(false);
		texte.setLineWrap(true);
		texte.setWrapStyleWord(true);
		texte.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),"Banc de Poissons"));
		
		
		// ajout des panneaux au JPanel principal
		
		this.add(optionPoissonsRouges);
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

}
