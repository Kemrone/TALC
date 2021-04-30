package model;

public class FichierFactory {
	
	public Fichier getFichier(String nom,TEAMSProcessor T) {
		if("HTML".equalsIgnoreCase(nom)) {
			return new FichierHtml(T);
		}
		else if("CSV".equalsIgnoreCase(nom)) {
			return new FichierCsv(T);
		}
		else {
			return null;
		}
	}

}
