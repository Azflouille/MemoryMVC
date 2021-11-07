import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Principale {

	public static void main(String[] args) {

		Border 			compound;
		Border raisedbevel 	= BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		compound 			= BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
		Model model = new Model();
		VueGraphique vueGraphique = new VueGraphique();
		ControleurBoutons ControleurB = new ControleurBoutons(model);
		model.enregistrerObservateur(vueGraphique);

		vueGraphique.setBorder(compound);
		vueGraphique.setLayout(new GridLayout(4, 5));
		vueGraphique.setSize(120 * 5, 120 * 4);
		
		/********************************************************************
		* Le JPanel panneauScore au centre de l'IG contenant des informations
		* sur le nombre de coups joues et le nombre de paires decouvertes
		********************************************************************/
		JPanel 			panneauScore;
		panneauScore= new JPanel(new GridLayout(2,1));
		
		JLabel 			nbCoups;
		nbCoups=new JLabel(" Nombre de coups joués : 0 ",JLabel.CENTER);
		nbCoups.setPreferredSize(new Dimension(605,55));
		nbCoups.setOpaque(true);
		nbCoups.setForeground(Color.blue);
		nbCoups.setBorder(compound);
		panneauScore.add(nbCoups);
	
		JLabel		 	nbPaires;
		nbPaires=new JLabel("Nombre de paires découvertes :  0 ",JLabel.CENTER);
		nbPaires.setPreferredSize(new Dimension(605,55));
		nbPaires.setOpaque(true);
		nbPaires.setForeground(Color.blue);
		nbPaires.setBorder(compound);
		panneauScore.add(nbPaires);
				
		
		/********************************************************************
		* Le JPanel panneauChoix au sud de l'IG contenant les 4 boutons
		********************************************************************/
		JPanel panneauChoix=new JPanel();
		

		JButton boutonSmiley = new JButton("Smiley");
		boutonSmiley.addActionListener(ControleurB);
		panneauChoix.add(boutonSmiley);
		
		JButton boutonFruits = new JButton("Fruits");
		boutonFruits.addActionListener(ControleurB);
		panneauChoix.add(boutonFruits);
		
		JButton boutonCacher = new JButton("Cacher");
		boutonCacher.addActionListener(ControleurB);
		panneauChoix.add(boutonCacher);

		JButton boutonMelanger = new JButton("Melanger");
		boutonMelanger.addActionListener(ControleurB);
		panneauChoix.add(boutonMelanger);
		
	 
		/**************************************
		* Construction de l'IG dans une JFrame	
		***************************************/	 
		JFrame frame=new JFrame("Memory MVC");
		frame.getContentPane().setBackground(Color.BLUE);	 
		
		frame.add(vueGraphique,BorderLayout.NORTH);
		frame.add(panneauScore,BorderLayout.CENTER);
		frame.add(panneauChoix, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}

}
