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
	}
	
	public void ajouterNote(String mat,Double note) {
		if((formation.isMat(mat))&&(note>=0)&&(note<=20)) {
			ArrayList<Double> list=r�sultat.get(mat);
			list.add(note);
			r�sultat.remove(mat);
			r�sultat.put(mat, list);
		}
	}

	public Double calculMoyMat(String mat) {
		Double moy=0.0;
		if(formation.isMat(mat)) {
			ArrayList<Double> list=r�sultat.get(mat);
			if(list.size()==0) {
				return null;
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
			return null;
		}
	}
	
	public Double calculMoyGeneral() {
		HashMap<String,Double> listMat=formation.getListeMat();
		Set<String> cl�=listMat.keySet();
		Iterator<String> it=cl�.iterator();
		Double total=0.0;
		Double toCoef=0.0;
		for(int i=0;i<listMat.size();i++) {
			int compteur=0;
			Double toMat=0.0;
			String matiere=it.next();
			ArrayList<Double> list=r�sultat.get(it.next());
			for(int j=0;j<list.size();j++) {
				compteur++;
				toMat+=list.get(j);
			}
			toMat=toMat/compteur;
			total+=r�sultat*formation.getCoef(matiere);
		}
		return null;
	}

}
