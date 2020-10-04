import java.util.ArrayList;

public class Groupe {

	private ArrayList<Etudiant> listeEtu=new ArrayList<Etudiant>();
	private Formation formation;

	public Groupe(Formation f) {
		formation=f;
	}

	public void addEtudiant(Etudiant e) {
		if(formation.equals(e)) {
			listeEtu.add(e);
		}
	}

	public void supEtudiant(Etudiant e) {
		if(formation.equals(e)) {
			listeEtu.remove(e);
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

}
