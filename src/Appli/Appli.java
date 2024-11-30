package Appli;

import Jeu.Jeu;

public class Appli {
	public static void main (String [] args) {
		
		Jeu jeu = new Jeu();  // instance d'un nouveau jeu
		jeu.faireChoix();     // on fait choisir la piece au joueur 1
		jeu.lancer();		  // on lance le jeu
		jeu.vainqueur();      // on affiche le gagnant
		
	
	}
}
