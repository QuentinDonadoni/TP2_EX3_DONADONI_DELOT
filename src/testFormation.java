
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class testFormation {

	Formation f;
	@Before
	public void initialiseFormation() {
		HashMap<String,Double> h=new HashMap<String,Double>();
		f= new Formation("01",h);
	}
	
	
	@Test
	public void testInstancier() {
		assertTrue("la liste devrait etre vide",f.getListeMat().isEmpty());
	}
	
	
	@Test
	public void testAjout() throws Exception {
		f.addMat("Math", 2.5);
		assertEquals(f.coeff("Math"),2.5,0.1);
	}
	
	@Test (expected = Exception.class)
	public void testAjoutNegatif() throws Exception {
		f.addMat("Nega", -1.0);
	}
	
	@Test
	public void testSuppression() throws Exception {
		f.addMat("Math", 2.5);
		f.supMat("Math");
		assertTrue(f.getListeMat().isEmpty());
	}
	
	
	
	@Test (expected = Exception.class)
	public void testDemandeCoeff() throws Exception {
		f.coeff("pas");
	}
}
