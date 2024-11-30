package Jeu;
import java.util.Scanner;
public class Jeu {
	private Plateau p;
	private Joueur j1;
	private Joueur j2;
	private Piece neutre;
	private final int nb_predic = 4;

	

	/**
	 * Constructeur par défaut du jeu
	 */
	public Jeu(){
		p = new Plateau();
		
		int pos_j1[][] = {{0,1} , {0,2}};
		j1 = new Joueur( pos_j1[0], pos_j1[1]);
		
		int pos_j2[][] = {{1,1} , {1,2}};
		j2 = new Joueur( pos_j2[0] , pos_j2[1]);
		
		int pos_neutre[][] = {{2,1} , {2,2}};
		neutre = new Piece(pos_neutre[0] , pos_neutre[1]);
		
		p.setCase(j1.pos_ligne1(), j1.pos_colonne1(), "B");
		p.setCase(j1.pos_ligne2(), j1.pos_colonne2(), "B");
				

		p.setCase(j2.pos_ligne1(), j2.pos_colonne1(), "R");
		p.setCase(j2.pos_ligne2(), j2.pos_colonne2(), "R");
				 
		p.setCase(neutre.getPosLigne1(), neutre.getPosColonne1(), "W");
		p.setCase(neutre.getPosLigne2(), neutre.getPosColonne2(), "W");
	}
	
	
	/**
	 * Indique le vainqueur 
	 */
	public void vainqueur() {
		if(j1.getScore() >= 12) {
			if(this.j2.getScore() >= 6) {
				System.out.println("Le joueur '" + j1.getCouleur() + "' a gagné la partie !");
				System.out.println("Le joueur '" +j1.getCouleur() + "' a obtenu : " + j1.getScore() + "points");
				System.out.println("Le joueur '" + j2.getCouleur() +  "' a obtenue : " + j2.getScore() + "points");
				System.out.println("Bravo, vous avez su gérer les points de l'adversaire.");
			}
			else {
				System.out.println("Le joueur '" + j2.getCouleur() + "' a gagné la partie !");
				System.out.println("Le joueur '" +j2.getCouleur() + "' a obtenu : " + j2.getScore() + "points");
				System.out.println("Le joueur '" + j1.getCouleur() +  "' a obtenu : " + j1.getScore() + "points");
			}
		}
		else {
			if(j1.getScore() >= 6) {
				System.out.println("Le joueur '" + j2.getCouleur() + "' a gagné la partie !");
				System.out.println("Le joueur '" +j2.getCouleur() + "' a obtenu : " + j2.getScore() + "points");
				System.out.println("Le joueur '" + j1.getCouleur() +  "' a obtenu : " + j1.getScore() + "points");
			}
			else {
				System.out.println("Le joueur '" + j1.getCouleur() + "' a gagné la partie !");
				System.out.println("Le joueur '" +j1.getCouleur() + "' a obtenu : " + j1.getScore() + "points");
				System.out.println("Le joueur '" + j2.getCouleur() +  "' a obtenu : " + j2.getScore() + "points");
			}
		}
		
	}
	
	/**
	 * Choix de la piece pour le joueur 1 (B ou R)
	 */
	public void faireChoix() {
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.print("Bienvenue sur le 3 Spot Game ! (réalisé par Alya et Nesrine) \n");
	    System.out.print("Joueur 1, choisissez votre couleur (B ou R) : ");
	    String couleurJoueur1 = sc.nextLine().toUpperCase();
	    while (!couleurJoueur1.equals("B") && !couleurJoueur1.equals("R")) {
	        System.out.print("Veuillez choisir entre B et R : ");
	        couleurJoueur1 = sc.nextLine().toUpperCase();
	    }
	    j1.setCouleur(couleurJoueur1);
	    j2.setCouleur(j1.getCouleur().equals("B") ? "R" : "B"); 
	    
	   
	}

	
	/**
	 * Lancement du jeu 
	 */
	public void lancer() {
		System.out.println("  - Le joueur 1 jouera la couleur " + j1.getCouleur());
		System.out.println("  - Le joueur 2 jouera la couleur " +  j2.getCouleur());
		System.out.println();
		p.affichePlateau();
		while(j1.getScore() < 12 && j2.getScore() < 12) {
			System.out.println("Joueur '" + j1.getCouleur() + "' à votre tour de jouer !");
			predire(j1.getCouleur() + "");
			System.out.println("Joueur '" + j1.getCouleur() + "' déplacez le pion blanc");
			predire("W");
			j1.setScore(p.score(j1.getCouleur()));
			System.out.println("Joueur " + j1.getCouleur());
			System.out.println("Points gagnés ce tour : " + p.score(j1.getCouleur()));
			System.out.println("Score total : " + j1.getScore());
			System.out.println("\n_ _ _ _ _ _ _ _ _ _ _ _ _ _\n" );
			if(j1.getScore() < 12) 
			{
				
				System.out.println("Joueur '" + j2.getCouleur() + "' à votre tour de jouer !");
				predire(j2.getCouleur() );
				System.out.println("Joueur '" + j2.getCouleur() + "' déplacez le pion blanc");
				predire("W");
				j2.setScore(p.score(j2.getCouleur()));
				System.out.println("Joueur " + j2.getCouleur());
				System.out.println("Points gagnés ce tour : " + p.score(j2.getCouleur() ));
				System.out.println("Score total : " + j2.getScore());
				System.out.println("\n_ _ _ _ _ _ _ _ _ _ _ _ _ _\n" );
			}
		}
	}
	
	/**
	 * permet de récupérer les prédictions 
	 * pour la pièce possédant la lettre
	 * @param lettre
	 */
	public void predire(String lettre) {
		int Caseslibres [][] = new int[3][3];
		this.p.libereCase(Caseslibres);
		int posPredic = 0;
		int[][] predictions  = new int[4][4]; 
		int[] posTest = {0,0,0,0};
		for(int i = 0; i < Caseslibres.length; i++) {
			for(int z = 0; z < Caseslibres.length; z++) {
				if(z!=i) {
					if(this.p.estAcote(Caseslibres[i], Caseslibres[z])){
						posTest[0] = Caseslibres[i][0];
						posTest[1] = Caseslibres[i][1];
						posTest[2] = Caseslibres[z][0];
						posTest[3] = Caseslibres[z][1];
						if(!this.estDejaPredit(predictions, posTest)) {
							for(int y=0 ; y < nb_predic ; y++)
								predictions[posPredic][y] = posTest[y];
							posPredic++;
							this.setPredicSuite(posPredic, posTest);
						}
					}
				}
			}
			posTest[0] = this.p.posEstAcote(Caseslibres[i], lettre)[0];
			posTest[1] = this.p.posEstAcote(Caseslibres[i], lettre)[1];
			if(posTest[0] != -1 && posTest[1] != -1){
				posTest[2] = Caseslibres[i][0];
				posTest[3] = Caseslibres[i][1];
				if(!this.estDejaPredit(predictions, posTest)) {
					for(int y=0 ; y < nb_predic ; y++)
						predictions[posPredic][y] = posTest[y];
					posPredic++;
					this.setPredicSuite(posPredic, posTest);
				}
			}
		}
		this.p.affichePlateau(lettre);
		for(Case cases []: this.p.getTab2()) {
			for(Case cases2 : cases) {
				cases2.setPredic("", false);;
			}
		}
		this.choisirOption(predictions, posPredic, lettre);
	}
	
	
	
	/**
	 * pour savoir si les positions
	 * de la piece possède déjà des prédictions
	 * @param predictions
	 * @param pos
	 * @return boolean si cela corresponds ou non 
	 */
	public boolean estDejaPredit(int[][] predictions, int pos[]) {
		for(int[] tabl : predictions) {
			if(tabl[0] == pos[0] && tabl[1] == pos[1] && tabl[2] == pos[2] && tabl[3] == pos[3] || 
					tabl[0] == pos[2] && tabl[1] == pos[3] && tabl[2] == pos[0] && tabl[3] == pos[1]) {
				return true;
			}
		}
		return false;
	}
	

	/**
	 * permet de mettre dans le plateaux la prédiction
	 * à l'aide de son numéro et sa position 
	 * @param numPrediction , pos
	 */
	public void setPredicSuite(int numPrediction, int pos[]) {
		if(pos[0] > pos[2] && pos[1] == pos[3] || pos[1] < pos[3] && pos[0] == pos[2])
		{
			if(this.p.getTab(pos[0], pos[1]).estPredic()) 
			{
				if(pos[0] == pos[2]) {
					this.p.getTab(pos[0],pos[1]).setPredic(this.p.getTab(pos[0],pos[1]).getPredic() + " - " + numPrediction , true);
				}
				else {
					this.p.getTab(pos[0],pos[1]).setPredic(numPrediction + " - " + this.p.getTab(pos[0],pos[1]).getPredic() , true);
				}
			} 
			else 
			{
				this.p.getTab(pos[0],pos[1]).setPredic(numPrediction + "" , true);
			}
		}
		else if (pos[0] < pos[2] && pos[1] == pos[3] || pos[1] > pos[3] && pos[0] == pos[2])
		{
			if(this.p.getTab(pos[2],pos[3]).estPredic()) 
			{
				this.p.getTab(pos[2],pos[3]).setPredic(this.p.getTab(pos[2],pos[3]).getPredic() + " - " + numPrediction , true );
			} 
			else 
			{
				this.p.getTab(pos[2],pos[3]).setPredic(numPrediction + "" , true);
			}
		}
	}

	
	/**
	 * permet au joueur de déplacer sa piece en fonction 
	 * du chiffre donnée
	 * @param predic
	 * @param nbPredic
	 * @param lettre
	 */
	public void choisirOption(int[][] predic, int nbPredic, String lettre) {
	    System.out.print("Sélectionnez un déplacement (1 à " + nbPredic + ") : ");
	    Scanner sc = new Scanner(System.in);
	    boolean choixCorrect = false;
	    do {
	        if (sc.hasNextLine()) { 
	            switch(sc.nextLine().charAt(0)) {
	            case '1':
	                    this.p.deplacerPiece(lettre, predic[0]);
	                    choixCorrect = true;
	                    break;
	                    
				case '2':
	                    this.p.deplacerPiece(lettre, predic[1]);
	                    choixCorrect = true;
	                    break;
				case '3':
	                    this.p.deplacerPiece(lettre, predic[2]);
	                    choixCorrect = true;
	                    break;
				case '4':
	                    if (nbPredic == 4) {
	                        this.p.deplacerPiece(lettre, predic[3]);
	                        choixCorrect = true;
	                    } else {
	                        System.out.print("Entrez une valeur proposée : ");
	                    }
	                    break;
	            default:	
	                    System.out.print("Entrez une valeur proposée : ");
	                    break;
	            }
	           
	        }
	        
	    } while (!choixCorrect);
	    this.p.affichePlateau();
	    
	} 


}

