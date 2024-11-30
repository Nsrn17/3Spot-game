package Test;

import static org.junit.Assert.*;
import org.junit.Test;

import Jeu.Jeu;



public class TestJeu {

	@Test
	 public void testEstDejaPredit() {
		Jeu j = new Jeu();
		
        // Création d'un tableau de prédictions
        int[][] predictions = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        // Création de la position à tester
        int[] pos = {5, 6, 7, 8};

        // Test de la fonction estDejaPredit avec la position existante
        assertTrue(j.estDejaPredit(predictions, pos));

        // Test de la fonction estDejaPredit avec une position inexistante
        int[] posInexistant = {13, 14, 15, 16};
        assertFalse(j.estDejaPredit(predictions, posInexistant));
    }
	

}


