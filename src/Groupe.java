import java.util.ArrayList;
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
		if(listeEtu.isEmpty()) {
			for(int i=0;i<listeEtu.size();i++) {
				moy+=listeEtu.get(i).calculMoyMat(mat);
			}
		}else {
			throw new Exception("Pas d'etudiant dans le groupe");
		}
		return moy/listeEtu.size();
	}

	public Double calculerMoyenneGene() throws Exception {
		Double moy=0.0;
		if(listeEtu.isEmpty()) {
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

	
	
}
