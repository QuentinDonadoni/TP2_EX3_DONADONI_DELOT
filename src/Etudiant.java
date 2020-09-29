import java.util.ArrayList;
import java.util.HashMap;

public class Etudiant extends HashMap<String,ArrayList<Double>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Identite identite;
	//private Formation formation;
	private HashMap<String,ArrayList<Double>> résultat=new HashMap<String,ArrayList<Double>>();
	
	
	public Etudiant(Identite i/*,Formation f*/) {
		identite=i;
		//formation=f;
	}
	
	public void calculMoy(){
		
	}
}
