package Test;
import static org.junit.Assert.*;
import org.junit.Test;

import Jeu.Joueur;
import Jeu.Piece;


public class TestJoueur {
	@Test
	public void TestPosition() {
		int [] pos1 = {1, 2}, pos2 = {2, 2};
		Piece p = new Piece(pos1, pos2);
		Joueur j = new Joueur(p.pos1,p.pos2);
		
		// test de chaque methodes de positionnement du joueur
		assertEquals(2, j.pos_colonne1());
		assertEquals(1, j.pos_ligne1());
		assertEquals(2, j.pos_colonne2());
		assertEquals(2, j.pos_ligne2());
		
	}
}


