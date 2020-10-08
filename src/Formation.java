import java.util.HashMap;
import java.util.Map.Entry;

public class Formation {

	private String identifiant;
	private HashMap<String,Double> listMat=new HashMap<String,Double>();
	
	public Formation(String id) {
		identifiant = id;
	}
	
	public void addMat(String mat, Double coef) throws Exception {
		if(coef>=0) {
		listMat.put(mat,coef);
		}else {
			throw new Exception("coef negatif");
		}
	}
	
	public void supMat(String mat) {
		if(listMat.containsKey(mat))
		listMat.remove(mat);
	}
	
	public Double coeff(String mat) throws Exception {
		Double c = null;
		if(listMat.containsKey(mat)) {
			c=listMat.get(mat);
		}else {
			throw new Exception("la matière n'est pas dans la formation");
		}
		return c;
	}
	
	public boolean isMat(String mat) {
		return listMat.containsKey(mat);
	}
	
	public HashMap<String,Double> getListeMat(){
		return listMat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifiant == null) ? 0 : identifiant.hashCode());
		result = prime * result + ((listMat == null) ? 0 : listMat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formation other = (Formation) obj;
		if (identifiant == null) {
			if (other.identifiant != null)
				return false;
		} else if (!identifiant.equals(other.identifiant))
			return false;
		if (listMat == null) {
			if (other.listMat != null)
				return false;
		} else if (!listMat.equals(other.listMat))
			return false;
		return true;
	}

	


	
}
