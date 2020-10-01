import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class testEtudiant {

	Etudiant e;
	Formation f;
	@Before
	public void initialiseEtudiant() throws Exception {
		f=new Formation("1",new HashMap<String,Double>());
		f.addMat("math", 1.0);
		f.addMat("info", 2.0);
		f.addMat("test", 2.0);
		e=new Etudiant(new Identite("01","Test","cest un test"),f);
	}
	
	@Test
	public void testAjouterNote() throws Exception{
		e.ajouterNote("math", 20.0);
		e.ajouterNote("math", 19.0);
		assertEquals(19.0,e.getResultat("math").get(1),0.1);
	}
	
	@Test (expected = Exception.class)
	public void testAjouterDepasse() throws Exception{
		e.ajouterNote("math", 40.0);
	}
	
	@Test (expected = Exception.class)
	public void testAjouterNégatif() throws Exception{
		e.ajouterNote("math", -1.0);
	}
	
	@Test (expected = Exception.class)
	public void testAjouterMatNonValide() throws Exception{
		e.ajouterNote("faux", 19.0);
	}
	
	@Test (expected = Exception.class)
	public void testMoyenneSansNote() throws Exception{
		e.calculMoyMat("math");
	}
	
	@Test
	public void testMoyenne() throws Exception{
		e.ajouterNote("math", 20.0);
		e.ajouterNote("math", 19.0);
		e.ajouterNote("math", 18.0);
		e.calculMoyMat("math");
		assertEquals(19.0,e.calculMoyMat("math"),0.1);
	}
	
	@Test
	public void testMoyenneGene() throws Exception{
		e.ajouterNote("math", 15.0);
		e.ajouterNote("math", 14.0);
		e.ajouterNote("math", 16.0);
		e.ajouterNote("info", 20.0);
		e.ajouterNote("test", 18.33);
		assertEquals(18.33,e.calculMoyGeneral(),0.01);
	}
	
	@Test
	public void testMoyenneGeneSansNote() throws Exception{
		e.ajouterNote("math", 15.0);
		e.ajouterNote("math", 14.0);
		e.ajouterNote("math", 16.0);
		e.ajouterNote("test", 20.0);
		assertEquals(18.33,e.calculMoyGeneral(),0.01);
	}
}