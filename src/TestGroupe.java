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
		id=new Identite("1","Ftest1","TEST1");
		id1=new Identite("2","Atest2","TEST2");
		id2=new Identite("3","Ztest3","TEST3");
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
	
	/**
	 * test le calcul de la moyenne des matiere meme si un etudiant n'a pas de note
	 * @throws Exception
	 */
	@Test
	public void calculerMoyenneMatiere() throws Exception {
		g.supEtudiant(e);
		g.supEtudiant(e1);
		f.addMat("Info", 2.0);
		g=new Groupe(f);
		e= new Etudiant(id,f);
		e1=new Etudiant(id1,f);
		e2=new Etudiant(id2,f);
		e.ajouterNote("Info", 10.0);
		e.ajouterNote("Info", 8.0);
		e1.ajouterNote("Info", 11.0);
		g.addEtudiant(e);
		g.addEtudiant(e1);
		g.addEtudiant(e2);
		assertEquals(10.00,g.calculerMoyenneMat("Info"),0.01);
	}
	
	@Test
	public void calculerMoyenneMatiereSansNote() throws Exception {
		g.supEtudiant(e);
		g.supEtudiant(e1);
		f.addMat("Info", 2.0);
		g=new Groupe(f);
		e= new Etudiant(id,f);
		e1=new Etudiant(id1,f);
		g.addEtudiant(e);
		g.addEtudiant(e1);
		assertNull("devrait etre null",g.calculerMoyenneMat("Info"));
	}
	
	@Test
	public void calculerMoyenneGeneral() throws Exception {
		g.supEtudiant(e);
		g.supEtudiant(e1);
		f.addMat("Info", 2.0);
		f.addMat("Math", 4.0);
		g=new Groupe(f);
		e= new Etudiant(id,f);
		e1=new Etudiant(id1,f);
		e.ajouterNote("Info", 10.0);
		e.ajouterNote("Info", 8.0);
		e.ajouterNote("Math", 16.0);
		e1.ajouterNote("Info", 11.0);
		e1.ajouterNote("Math", 16.0);
		g.addEtudiant(e);
		g.addEtudiant(e1);
		assertEquals(14.00,g.calculerMoyenneGene(),0.01);
	}
	
	@Test
	public void calculerTrieAlpha() throws Exception {
		e2=new Etudiant(id2,f);
		g.addEtudiant(e2);
		g.triAlpha();
		assertEquals("Le nom devrait etre celui de ATest2",g.getListeEtu().get(0).getIdentite().getNom(),"Atest2");
	}
	
	@Test
	public void calculerTrieParMerite() throws Exception {
		e2=new Etudiant(id2,f);
		g.supEtudiant(e);
		g.supEtudiant(e1);
		f.addMat("Info", 2.0);
		f.addMat("Math", 4.0);
		g=new Groupe(f);
		e= new Etudiant(id,f);
		e1=new Etudiant(id1,f);
		e.ajouterNote("Info", 10.0);
		e.ajouterNote("Info", 8.0);
		e.ajouterNote("Math", 16.0);
		e1.ajouterNote("Info", 20.0);
		e1.ajouterNote("Math", 20.0);
		g.addEtudiant(e);
		g.addEtudiant(e1);
		g.triParMerite();
		assertEquals("Le nom devrait etre celui de Atest2",g.getListeEtu().get(0).getIdentite().getNom(),"Atest2");
	}
	
	
}
