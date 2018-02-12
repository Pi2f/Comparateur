package model;

public class Pays extends Critere {
	
	public Pays(Requete b) {
		super(b);
		requete = "Pays = ?";
	}
}