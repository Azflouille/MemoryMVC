import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Principale {

	public static void main(String[] args) {

		/**********************************
		* Création des bords des composants
		***********************************/
		Border 			compound;
		Border raisedbevel 	= BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		compound 			= BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
					
		
		/***************************************************************
		*Creation de la liste de cartes avec un doublon de chaque carte
		****************************************************************/
		ArrayList<Carte> cartes = new ArrayList<Carte>();
		for (int i = 0; i < 20; i++) {
			Carte carte = new Carte((int) i / 2);
			cartes.add(carte);
		}
		// Mélange des cartes
		Collections.shuffle(cartes);  
		
		
		/*******************************************************************
		* Le JPanel plateau au nord dans lequel les cartes sont affichees
		* les JLabel avec une ImageIcon associee a chaque carte
		* Le choix du jeu de carte est fait selon la valeur de répertoire
		********************************************************************/
		JPanel plateau =new JPanel();
		plateau.setBorder(compound);
		plateau.setLayout(new GridLayout(4, 5));
		plateau.setSize(120 * 5, 120 * 4);
		
		//Création des JLabel associés aux cartes - affichage dans le JPanel Plateau
		String chemin ;
		String repertoire="smiley"; //ou "fruits" selon la série choisie
		for (int i = 0; i < 20; i++) {
			if(cartes.get(i).isVisible())  //si l'attribut visible de la carte est a true alors l'image de la carte apparaitra 
				chemin = "img/" + repertoire + "/im" + cartes.get(i).getNum()+".png";
			else
				chemin= "img/" + repertoire + "/fond.png";//sinon l'image de la carte retournée apparaitra
			plateau.add(new JLabel(new ImageIcon(chemin))); //association du fichier image avec le JLabel avec la classe ImageIcon
		}		

		
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
		panneauChoix.add(boutonSmiley);
		
		JButton boutonFruits = new JButton("Fruits");
		panneauChoix.add(boutonFruits);
		
		JButton boutonCacher = new JButton("Cacher");
		panneauChoix.add(boutonCacher);

		JButton boutonMelanger = new JButton("Melanger");		
		panneauChoix.add(boutonMelanger);
		
	 
		/**************************************
		* Construction de l'IG dans une JFrame	
		***************************************/	 
		JFrame frame=new JFrame("Memory MVC");
		frame.getContentPane().setBackground(Color.BLUE);	 
		
		frame.add(plateau,BorderLayout.NORTH);
		frame.add(panneauScore,BorderLayout.CENTER);
		frame.add(panneauChoix, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}

}
