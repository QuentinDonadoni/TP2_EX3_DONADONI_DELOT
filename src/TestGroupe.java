import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestGroupe {

	Groupe g;
	Etudiant e,e1,e2;
	Formation f,f1;
	Identite id,id1,id2;
	
	@Before
	public void initialiseGroupe() throws Exception {
		f=new Formation("1");
		f1=new Formation("2");
		id=new Identite("1","test1","TEST1");
		id1=new Identite("2","test2","TEST2");
		id2=new Identite("3","test3","TEST3");
		e= new Etudiant(id,f);
		e1=new Etudiant(id1,f);
		g= new Groupe(f);
		g.addEtudiant(e);
		g.addEtudiant(e1);
	}
	
	@Test
	public void ajouterEtudiantValide() throws Exception{
		e2=new Etudiant(id2,f);
		g.addEtudiant(e2);
		assertTrue("il devrait y avoir l'etudiant e2",g.getListeEtu().contains(e2));
	}
	
	@Test (expected = Exception.class)
	public void ajouterEtudiantVide() throws Exception{
		g.addEtudiant(e2);
	}
	
	@Test (expected = Exception.class)
	public void ajouterEtudiantMauvaiseForma() throws Exception{
		e2=new Etudiant(id2,f1);
		g.addEtudiant(e2);
	}
	
	
	@Test
	public void supprimerEtudiantValide() throws Exception {
		g.supEtudiant(e1);
		assertFalse("la liste ne devrait plus contenir e1",g.getListeEtu().contains(e1));
	}
	
	@Test (expected = Exception.class)
	public void supprimerEtudiantFaux() throws Exception {
		e2=new Etudiant(id2,f);
		g.supEtudiant(e2);
	}
	
	@Test
	public void calculerMoyenneMatiere() throws Exception {
		f.addMat("Info", 2.0);
		e= new Etudiant(id,f);
		e1=new Etudiant(id1,f);
		e.ajouterNote("Info", 10.0);
		e.ajouterNote("Info", 8.0);
		e1.ajouterNote("Info", 11.0);
		assertEquals(10.00,g.calculerMoyenneMat("Info"),0.01);
	}
}
