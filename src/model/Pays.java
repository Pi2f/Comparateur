package model;

public class Pays extends Critere {
	
	public Pays(Selection b) {
		super(b);
		requete = "Pays = ?";
	}
}