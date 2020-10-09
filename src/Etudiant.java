import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Etudiant extends HashMap<String,ArrayList<Double>>{

	/**
	 * 
	 */
	private Identite identite;
	private Formation formation;
	private HashMap<String,ArrayList<Double>> résultat=new HashMap<String,ArrayList<Double>>();


	public Etudiant(Identite i,Formation f) {
		identite=i;
		formation=f;
		HashMap<String,Double> listMat=formation.getListeMat();
		Set<String> clé=listMat.keySet();
		Iterator<String> it=clé.iterator();
		while(it.hasNext()) {
			résultat.put(it.next(), new ArrayList<Double>());
		}
	}

	public void ajouterNote(String mat,Double note) throws Exception {
		if((formation.isMat(mat))) {
			if((note>=0)&&(note<=20)) {
				ArrayList<Double> list=new ArrayList<Double>();
				if(!résultat.get(mat).isEmpty()) {
					list=résultat.get(mat);
				}
				list.add(note);
				résultat.remove(mat);
				résultat.put(mat, list);
			}else {
				throw new Exception("Ajout d'une note non valide (négative ou supérieur à 20)");
			}
		}else {
			throw new Exception("la matière n'existe pas");
		}
	}

	public Double calculMoyMat(String mat) throws Exception {
		Double moy=0.0;
		if(formation.isMat(mat)) {
			ArrayList<Double> list=résultat.get(mat);
			if(list.size()==0) {
				throw new Exception("pas de note dans cette matière");
			}else {
				int compteur=0;
				for(int i=0;i<list.size();i++) {
					moy+=list.get(i);
					compteur++;
				}
				moy=moy/compteur;
				return moy;
			}
		}else {
			throw new Exception("la matière n'est pas dans la formation");
		}
	}

	public Double calculMoyGeneral() throws Exception {
		HashMap<String,Double> listMat=formation.getListeMat();
		Set<String> clé=listMat.keySet();
		Iterator<String> it=clé.iterator();
		Double total=0.0;
		Double toCoef=0.0;
		String matiere=it.next();
		while(it.hasNext()) {
			int compteur=0;
			Double toMat=0.0;
			ArrayList<Double> list=résultat.get(matiere);
			if(!list.isEmpty()) {
			for(int j=0;j<list.size();j++) {
				compteur++;
				toMat+=list.get(j);
			}
			toMat=toMat/compteur;
			total+=toMat*formation.coeff(matiere);
			toCoef+=formation.coeff(matiere);
			}
			matiere=it.next();
		}
		int compteur=0;
		Double toMat=0.0;
		ArrayList<Double> list=résultat.get(matiere);
		if(!list.isEmpty()) {
			for(int j=0;j<list.size();j++) {
				compteur++;
				toMat+=list.get(j);
			}
			toMat=toMat/compteur;
			total+=toMat*formation.coeff(matiere);
			toCoef+=formation.coeff(matiere);
		}
		total=total/toCoef;
		return total;
	}

	public ArrayList<Double> getResultat(String mat) throws Exception{
		if(résultat.containsKey(mat)) {
			return résultat.get(mat);
		}else {
			throw new Exception("Il n'y a pas cette matière");
		}
	}
	
	public Formation getFormation() {
		return formation;
	}

	/**
	 * @return the identite
	 */
	public Identite getIdentite() {
		return identite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((formation == null) ? 0 : formation.hashCode());
		result = prime * result + ((identite == null) ? 0 : identite.hashCode());
		result = prime * result + ((résultat == null) ? 0 : résultat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (formation == null) {
			if (other.formation != null)
				return false;
		} else if (!formation.equals(other.formation))
			return false;
		if (identite == null) {
			if (other.identite != null)
				return false;
		} else if (!identite.equals(other.identite))
			return false;
		if (résultat == null) {
			if (other.résultat != null)
				return false;
		} else if (!résultat.equals(other.résultat))
			return false;
		return true;
	}
	
	public int compareToAlpha (Object o) {
        if (!this.identite.getNom().equals(((Etudiant) o).identite.getNom())) {
        	return this.identite.getNom().compareTo(((Etudiant) o).identite.getNom());
        } else {
        	return this.identite.getPrenom().compareTo(((Etudiant) o).identite.getPrenom());
        }
    }
	
	
	public int compareParMerite(Object o) throws Exception {
		if(this.calculMoyGeneral()<((Etudiant)o).calculMoyGeneral()) {
			return 1;
		} else if (this.calculMoyGeneral()>=((Etudiant)o).calculMoyGeneral()) {
			return -1;
		}else {
			return 0;
		}
	}
}
