package Test;

import static org.junit.Assert.*;
import org.junit.Test;

import Jeu.Plateau;

public class TestPlateau {

    @Test
    public void testConstructeurPlateau() {
        Plateau plateau = new Plateau();

        // Test de la taille du plateau
        assertEquals(3, plateau.getTab2().length);
        assertEquals(3, plateau.getTab2()[0].length);

        // Test de l'initialisation des cases
        assertEquals(false, plateau.getTab2()[0][0].estUtiliser());
        assertEquals(false, plateau.getTab2()[0][0].estUneCroix());

    }

    @Test
    public void testBonnePos() {
        Plateau plateau = new Plateau();

        // Test de bonnes positions
        assertEquals(true, plateau.bonnePos(0, 0));
        assertEquals(true, plateau.bonnePos(1, 2));
        assertEquals(true, plateau.bonnePos(2, 1));

        // Test de mauvaises positions
        assertEquals(false, plateau.bonnePos(-1, 0));
        assertEquals(false, plateau.bonnePos(0, -1));
        assertEquals(false, plateau.bonnePos(3, 0));
        assertEquals(false, plateau.bonnePos(0, 3));
    }

   
}
