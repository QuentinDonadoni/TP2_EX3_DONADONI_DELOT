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
		HashMap<String,Double> map = new HashMap<String,Double>();
		for (Entry<String, Double> entry : map.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            c = value;
		}
		return c;
	}
	
	public boolean isMat(String mat) {
		return true;
	}
}
