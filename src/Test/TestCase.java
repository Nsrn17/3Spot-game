package Test;
import org.junit.Test;
import Jeu.Case;
import static org.junit.Assert.*;



public class TestCase {


	@Test
	public void TestPrediction() {
		Case c1 = new Case();
		c1.setPredic("Test" , true);
		assertEquals("Test", c1.getPredic());
	}
	
	
	@Test
	public void TestCroix() {
		Case c1 = new Case();
		c1.initCroix();
        assertTrue(c1.estUneCroix());
	}
	
	@Test
	public void TestUtiliser() {
		Case c1 = new Case();
		String j = " j1";
		c1.setUtiliser(j ,true);
		assertEquals(j,c1.getLettre());
	}
}