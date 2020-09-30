import java.util.HashMap;
import java.util.Map.Entry;

public class Formation {

	private String identifiant;
	private HashMap<String,Double> listMat=new HashMap<String,Double>();
	
	public Formation(String id, HashMap<String,Double> list) {
		identifiant = id;
		listMat = list;
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
}
