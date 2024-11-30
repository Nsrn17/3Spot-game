package Jeu;

public class Joueur {
	private int score;
	private String couleur;
	private Piece piece;
	

	/**
	 * Constructeur de la classe Joueur
	 * @param color
	 * @param pos1[]
	 * @param pos2[]
	 */
	public Joueur( int[] pos1 , int[] pos2) {
		this.score = 0; 
		this.piece = new Piece(pos1, pos2);  
	}
	
	/**
	 * @return la première position à la première ligne
	 */
	public int pos_ligne1() {
		return piece.getPosLigne1();
	}
	/**
	 * @return la première position à la première colonne
	 */
	public int pos_colonne1() {
		return piece.getPosColonne1(); 
	}
	/**
	 * @return la deuxième position à la deuxième ligne
	 */
	public int pos_ligne2() {
		return piece.getPosLigne2(); 
	}
	/**
	 * @return la deuxième position à la deuxième colonne
	 */
	public int pos_colonne2() {
		return piece.getPosColonne2(); 
	}
	
	/**
	 * @return couleur 
	 */
	public String getCouleur() {
		return couleur ;
	}
	
	/**
	 * @return score du joueur 
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * modifie le score 
	 * @param s
	 */
	public void setScore(int s) {
		this.score +=s;
	}
	
	/**
	 * modifie la couleur 
	 * @param c
	 */
	public void setCouleur(String c) {
		this.couleur = c ;
	}
	
}

