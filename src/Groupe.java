import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Groupe {

	private List<Etudiant> listeEtu;
	private Formation formation;

	public Groupe(Formation f) {
		listeEtu= new ArrayList<Etudiant>();
		formation=f;
	}

	public void addEtudiant(Etudiant e) throws Exception {
		if(formation.equals(e.getFormation())) {
			if(e.isEmpty()) {
				listeEtu.add(e);
			}else {
				throw new Exception("l'etudiant est null");
			}
		}else {
			throw new Exception("l'etudiant ne posssède pas la meme formation");
		}
	}

	public void supEtudiant(Etudiant e) throws Exception {
		if(listeEtu.contains(e)) {
			listeEtu.remove(e);
		}else {
			throw new Exception("l'etudiant n'est pas dans le groupe");
		}
	}

	public Double calculerMoyenneMat(String mat) throws Exception {
		Double moy=0.0;
		int sansNote=0;
		if(!listeEtu.isEmpty()) {
			for(int i=0;i<listeEtu.size();i++) {
				try {
				moy+=listeEtu.get(i).calculMoyMat(mat);
				}catch (Exception e) {
					sansNote++;
				}
			}
		}else {
			throw new Exception("Pas d'etudiant dans le groupe");
		}
		if(sansNote==listeEtu.size()) {
			return null;
		}else {
		return moy/(listeEtu.size()-sansNote);
		}
	}

	public Double calculerMoyenneGene() throws Exception {
		Double moy=0.0;
		if(!listeEtu.isEmpty()) {
			for(int i=0;i<listeEtu.size();i++) {
				moy+=listeEtu.get(i).calculMoyGeneral();
			}
		}else {
			throw new Exception("Pas d'etudiant dans le groupe");
		}
		return moy/listeEtu.size();
	}

	/**
	 * @return the listeEtu
	 */
	public List<Etudiant> getListeEtu() {
		return listeEtu;
	}

	public void triAlpha() {
		Collections.sort(listeEtu, new Comparator<Etudiant>() {
			@Override
			public int compare(Etudiant e1, Etudiant e2) {
				return e1.compareToAlpha(e2);
			}
		});
	}
	
	public void triParMerite() {
		Collections.sort(listeEtu, new Comparator<Etudiant>() {
			@Override
			public int compare(Etudiant e1, Etudiant e2) {
				try {
					return e1.compareParMerite(e2);
				} catch (Exception e) {
					return -2;
		}
	}
});
	}
}
