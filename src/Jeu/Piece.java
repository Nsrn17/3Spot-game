package Jeu;

public class Piece {
	public int[] pos1; //[0]:ligne ; [1] : colonne
	public int[] pos2;
	//une piece possède deux emplacements c'est pour cela qu'on a 2 positions
	
	/**
	 * @brief Constructeur de la classe Piece
	 * @param position1
	 * @param position2
	 */
	public Piece(int[] pos1  , int[] pos2 ) {
		this.pos1 = pos1;
		this.pos2 = pos2;
	}
	
	/**
	 * la premiere position à la premiere ligne 
	 * @return pos1[0]
	 */
	public int getPosLigne1() {
		return pos1[0];//cela concerne cette case : ({0,x},{x,x})
	}
	
	/**
	 * la premiere position à la première colonne
	 * @return pos1[1]
	 */
	public int getPosColonne1() {
		return pos1[1]; //cela concerne cette case : ({x,0},{x,x})
	}
	
	/**
	 * la deuxième position à la deuxieme ligne 
	 * @return pos2[0]
	 */
	public int getPosLigne2() {
		return pos2[0];//cela concerne cette case : ({x,x},{0,x})
	}
	
	/**
	 * la deuxième position à la deuxieme colonne
	 * @return pos2[1]
	 */
	public int getPosColonne2() {
	 	return pos2[1]; //cela concerne cette case : ({x,x},{x,0})
	}

}

