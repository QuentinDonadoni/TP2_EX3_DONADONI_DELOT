import java.util.HashMap;
import java.util.Map.Entry;

public class Formation {

	private String identifiant;
	private HashMap<String,Double> listMat;
	
	public Formation(String id, HashMap<String,Double> list) {
		identifiant = id;
		listMat = list;
	}
	
	public void addMat(String mat, Double coef) {
		HashMap<String,Double> map = new HashMap<String,Double>();
		map.put(mat,coef);
	}
	
	public void supMat(HashMap<String,Double> Mat) {
		HashMap<String,Double> map = new HashMap<String,Double>();
		map.remove(Mat);
	}
	
	public Double coeff(String mat) {
		Double c = null;
		if(listMat.containsKey(mat)) {
			c=listMat.get(mat);
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
