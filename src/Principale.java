import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Le mène
 */
public class Principale {

	public static void main(String[] args) {


		/**********************************
		 * Création des bords des composants
		 ***********************************/
		Border 			compound;
		Border raisedbevel 	= BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		compound 			= BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);

		/**********************************
		 * Création des attributs MVC
		 ***********************************/
		Model model = new Model();
		VueGraphique vueGraphique = new VueGraphique();
		ControleurBoutons ControleurB = new ControleurBoutons(model);
		ControleurClick ControleurC = new ControleurClick(model);
		model.enregistrerObservateur(vueGraphique);
		vueGraphique.addMouseListener(ControleurC);

		/*******************************************************************
		 * Le JPanel plateau (maintenant vueGarphique) au nord dans lequel les cartes sont affichees
		 ********************************************************************/
		vueGraphique.setBorder(compound);
		vueGraphique.setLayout(new GridLayout(4, 5));
		vueGraphique.setSize(120 * 5, 120 * 4);

		/********************************************************************
		 * Le JPanel panneauScore au centre de l'IG contenant des informations
		 * sur le nombre de coups joues et le nombre de paires decouvertes
		 ********************************************************************/
		JPanel 			panneauScore;
		panneauScore= new JPanel(new GridLayout(2,1));

		VuePaires nbPaires = new VuePaires();
		model.enregistrerObservateur(nbPaires);
		nbPaires.setPreferredSize(new Dimension(605,55));
		nbPaires.setOpaque(true);
		nbPaires.setForeground(Color.blue);
		nbPaires.setBorder(compound);
		panneauScore.add(nbPaires);

		VueCoups nbCoups = new VueCoups();
		model.enregistrerObservateur(nbCoups);
		nbCoups.setPreferredSize(new Dimension(605,55));
		nbCoups.setOpaque(true);
		nbCoups.setForeground(Color.blue);
		nbCoups.setBorder(compound);
		panneauScore.add(nbCoups);

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
