
public class Identite {
	
	private String NIP,nom,prenom;

	/**
	 * @return the nIP
	 */
	public String getNIP() {
		return NIP;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	public Identite(String nip,String n,String p) {
		NIP=nip;
		nom=n;
		prenom=p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NIP == null) ? 0 : NIP.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Identite other = (Identite) obj;
		if (NIP == null) {
			if (other.NIP != null)
				return false;
		} else if (!NIP.equals(other.NIP))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
	
	
}
