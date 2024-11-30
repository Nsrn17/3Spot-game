package Jeu;
public class Plateau {
	private Case[][] plat;
	private final int taille_plat = 3;
	private final int nb_pointi = 5;
	
	
	/**
	 * Constructeur par défaut du plateau de jeu
	 */
	public Plateau() {
	    plat = new Case[taille_plat][taille_plat];
	    for (Case cases[] : plat) { 
	        for (int i = 0; i < cases.length; ++i) { 
	            cases[i] = new Case();
	            if (i + 1 == cases.length) { 
	                cases[i].initCroix();
	                //pour la derniere cas de chaque ligne 
	                //on initialise une croix qui servira 
	                //compter les points 
	            }
	        }
	        
	    }
	}

	
	/**
	 * permet de récuperer une case du 
	 * plateau à une certaine position
	 * @param pos1
	 * @param pos2
	 * @return la case du plateau
	 */
	public Case getTab(int pos1 , int pos2 ) {
		return plat[pos1][pos2];
	}
	
	/**
	 * permet simplement de récupérer le 
	 * plateau 
	 * @return le plateau
	 */
	public Case[][] getTab2() {
		return plat;
	}

	

	/**
	 * permet de mettre une lettre dans une case
	 * à la position donnée en param
	 * @param pos1
	 * @param pos2
	 * @param lettre
	 */
	public void setCase(int pos1 , int pos2 , String lettre ) {
		plat[pos1][pos2].setUtiliser(lettre , true);
	}

	
	/**
	 * permet de verifier si les positions donnée 
	 * respectent les dimensions du plateau
	 * @param pos
	 * @param pos2
	 * @return boolean permettant de le vérifier
	 */
	public boolean bonnePos (int pos, int pos2) {
		if(pos <= (this.plat.length - 1) && pos2 <= (this.plat[0].length - 1) && pos >= 0 && pos2 >= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * permet de modifier un tableau 
	 * de position afin d'obtenir les positions 
	 * des cases qui ne sont pas utiliser 
	 * @param pos
	 */
	public void libereCase (int[][] pos) {
		int i = 0;
		int y = 0;
		for(Case cases[] : this.plat) {
			for(int z = 0; z < cases.length; z++) {
				if(!cases[z].estUtiliser()) {
					pos[y][0] = i;
					pos[y][1] = z;
					y++;
				}
			}
		i++;
		}
	}
	
	/**
	 * on prends la position de deux pièces 
	 * pour savoir si elles sont à coté 
	 * @param pos
	 * @param pos2
	 * @return boolean indiquant si elles le sont 
	 */
	public boolean estAcote (int[] pos, int[] pos2) {
		if(this.bonnePos(pos[0], pos[1]) && this.bonnePos(pos2[0], pos2[1])) {
			if((pos[0] - 1) == pos2[0] && pos[1] == pos2[1] || (pos[0] + 1) == pos2[0] && pos[1] == pos2[1])
				return true;
			
			else if(pos[0] == pos2[0] && (pos[1] - 1) == pos2[1] || pos[0] == pos2[0] && (pos[1] + 1) == pos2[1])
				return true;
		}
		return false;
	}
	
	/**
	 * cette fois on renvoie la position 
	 * qui est à coté de la piece 
	 * @param pos de la lettre 
	 * @param lettre
	 * @return la position de la piece à côté sinon {-1, -1}
	 */
	//renvoie la position qui est à coté 
	public int[] posEstAcote (int[] pos, String lettre) {
		if(this.bonnePos(pos[0], pos[1])) {
			if(this.bonnePos((pos[0] - 1), pos[1]) && this.getTab((pos[0] - 1), pos[1]).getLettre().contentEquals(lettre)){
				int[] retour = {(pos[0] - 1), pos[1]};
				return retour;
			}
			else if(this.bonnePos((pos[0] + 1), pos[1]) && this.getTab((pos[0] + 1), pos[1]).getLettre().contentEquals(lettre)) 
			{
				int[] retour = {(pos[0] + 1), pos[1]};
				return retour;
			}
			else if(this.bonnePos(pos[0], (pos[1] - 1)) && this.getTab(pos[0], (pos[1] - 1)).getLettre().contentEquals(lettre)) 
			{
				int[] retour = {pos[0], (pos[1] - 1)};
				return retour;
			}
			else if(this.bonnePos(pos[0], (pos[1] + 1)) && this.getTab(pos[0], (pos[1] + 1)).getLettre().contentEquals(lettre)) 
			{
				int[] retour = {pos[0], (pos[1] + 1)};
				return retour;
			}
		}
		int[] retour = {-1, -1};
		return retour;
	}
	
	/**
	 * on déplace la piece possédant la lettre
	 * à la position predic 
	 * @param lettre 
	 * @param predic la position donnée par le joueur
	 */
	public void deplacerPiece(String lettre, int[] predic){
		for(Case cases []: this.plat) {
			for(Case cases2 : cases) {
				if(cases2.getLettre().contentEquals(lettre)) {
					cases2.setUtiliser("/0" , false); 
				}
			}
		}
		this.plat[predic[0]][predic[1]].setUtiliser(lettre , true ); 
		this.plat[predic[2]][predic[3]].setUtiliser(lettre , true );
	}
	
	/**
	 * on comptabilise le score du joueur 
	 * possédant la lettre
	 * @param lettre 
	 * @return le score du joueur
	 */
	public int score(String lettre){
		int scoreCount = 0;
		for(Case cases []: this.plat) {
			for(Case cases2 : cases)  {
				if(cases2.getLettre().contentEquals(lettre) && cases2.estUneCroix()) {
				//si la case possède la valeur joueur et est placé dans une case '0' on augmente le score 
					scoreCount++;
				}
			}
		}
		return scoreCount;
	}
	
	/**
	 * affiche le 1er plateau dans la console
	 * sans les prédiction
	 */
	 public void affichePlateau() {
	    String ligne = "* ";
	    int longueur = nb_pointi * this.plat.length - this.plat.length;
	    // Ajouter des séparateurs entre les cases
	    String separateur = "  ";
	    for(int y = 1; y <= longueur ; y++) {
	        ligne += "* ";
	    }
	    System.out.println(ligne);
	    for(Case[] cases : this.plat) {
	        ligne = "*";
	        String separateur2 = "   ";
	        String l = "* " + separateur2;
            for(int i=0 ; i < taille_plat; i++) {
            	l += separateur2 + "* " + separateur2;
            }
            System.out.println(l);
	        for(Case cases2 : cases) {
	            ligne+=" ";
	            if(cases2.estUneCroix() && !cases2.estUtiliser() && !cases2.estPredic()) {
	                ligne += separateur + "O" + separateur;
	            //si la case n'est pas '0' et ne possède rien et il n'y a aucune prédiction dessus 
	            //on met un 0
	            }
	            else if (cases2.estUtiliser() && !cases2.estPredic()) {
	                ligne += separateur + cases2.getLettre() + separateur;
	            //si la case est utilisé et ne possède pas ne prédiction
	            //on met la piece correspondante 
	            }
	            else if (cases2.estPredic()) {
	                if(cases2.getPredic().length() == 1) {
	                    ligne += separateur + cases2.getPredic() + separateur;
	                } else {
	                    ligne += cases2.getPredic();
	                }
	            }
	            else {
	               ligne += separateur + " " + separateur;;
	            }
	            
	            ligne += " *";   
	        }
	        System.out.println(ligne);
	        System.out.println(l);
	        ligne = "* ";
	        for(int y = 1; y <= longueur ; y++) {
	            ligne += "* ";
	        }
	        System.out.println(ligne);
	    }
	}

	/**
	 * affiche le plateau dans la console
	 * avec les prédiction en fonction de la lettre
	 * et donc du joueur 
	 * @param lettre
	 */
	public void affichePlateau(String lettre) {
		String ligne = "* ";
		int longueur = nb_pointi * this.plat.length - this.plat.length;
		String separateur = "  ";
		
		for(int y = 1; y <= longueur; y++) {
				ligne += "* ";
		}
		System.out.println(ligne);
		for(Case cases[] : this.plat) {
			ligne = "*";
			
			String separateur2 = "   ";
	        String l = "* " + separateur2;
            for(int i=0 ; i < taille_plat; i++) {
            	l += separateur2 + "* " + separateur2;
            }
            System.out.println(l);
			for(Case cases2 : cases) {
				ligne +=" ";
				if(cases2.estUneCroix() && !cases2.estUtiliser() && !cases2.estPredic() || 
						cases2.estUneCroix() && cases2.getLettre().contentEquals(lettre) && !cases2.estPredic()) {
					ligne += separateur + "O" + separateur;
				}
				else if (cases2.estUtiliser() && !cases2.estPredic() && !cases2.getLettre().contentEquals(lettre)) {
					ligne += separateur + cases2.getLettre() + separateur ;
				}
				else if (cases2.estPredic()) {
					if(cases2.getPredic().length() == 1) {
						ligne += separateur + cases2.getPredic() + separateur;
					} else {
						ligne += cases2.getPredic();
					}
				}
				
				else {
					ligne += separateur + " " + separateur;
				}
				
				ligne += " *";
			}
			
			System.out.println(ligne);
			System.out.println(l);
			ligne = "* ";
			for(int y = 1; y <= longueur; y++) {
				ligne +="* ";
			}
		
			System.out.println(ligne);
		
		}
	}
	
}

