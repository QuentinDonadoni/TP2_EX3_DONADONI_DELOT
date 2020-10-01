import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Etudiant extends HashMap<String,ArrayList<Double>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Identite identite;
	private Formation formation;
	private HashMap<String,ArrayList<Double>> r�sultat=new HashMap<String,ArrayList<Double>>();


	public Etudiant(Identite i,Formation f) {
		identite=i;
		formation=f;
		HashMap<String,Double> listMat=formation.getListeMat();
		Set<String> cl�=listMat.keySet();
		Iterator<String> it=cl�.iterator();
		while(it.hasNext()) {
			r�sultat.put(it.next(), new ArrayList<Double>());
		}
	}

	public void ajouterNote(String mat,Double note) throws Exception {
		if((formation.isMat(mat))) {
			if((note>=0)&&(note<=20)) {
				ArrayList<Double> list=new ArrayList<Double>();
				if(!r�sultat.get(mat).isEmpty()) {
					list=r�sultat.get(mat);
				}
				list.add(note);
				r�sultat.remove(mat);
				r�sultat.put(mat, list);
			}else {
				throw new Exception("Ajout d'une note non valide (n�gative ou sup�rieur � 20)");
			}
		}else {
			throw new Exception("la mati�re n'existe pas");
		}
	}

	public Double calculMoyMat(String mat) throws Exception {
		Double moy=0.0;
		if(formation.isMat(mat)) {
			ArrayList<Double> list=r�sultat.get(mat);
			if(list.size()==0) {
				throw new Exception("pas de note dans cette mati�re");
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
			throw new Exception("la mati�re n'est pas dans la formation");
		}
	}

	public Double calculMoyGeneral() throws Exception {
		HashMap<String,Double> listMat=formation.getListeMat();
		Set<String> cl�=listMat.keySet();
		Iterator<String> it=cl�.iterator();
		Double total=0.0;
		Double toCoef=0.0;
		String matiere=it.next();
		while(it.hasNext()) {
			int compteur=0;
			Double toMat=0.0;
			ArrayList<Double> list=r�sultat.get(matiere);
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
		ArrayList<Double> list=r�sultat.get(matiere);
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
		if(r�sultat.containsKey(mat)) {
			return r�sultat.get(mat);
		}else {
			throw new Exception("Il n'y a pas cette mati�re");
		}
	}
}
