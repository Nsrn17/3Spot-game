package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Jeu.Piece;


public class TestPiece {

	@Test
	public void TestPositon() {
		int pos[][] = {{0,1} , {3,2}};
		Piece p = new Piece(pos[0] , pos[1]);
		
		// test de chaque methodes de positionnement du joueur
		assertEquals(0, p.getPosLigne1());
		assertEquals(1, p.getPosColonne1());
		assertEquals(3, p.getPosLigne2());
		assertEquals(2, p.getPosColonne2());
		
		
	}

}
