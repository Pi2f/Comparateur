package model;

public class Nom extends Critere {
	public Nom(Requete b) {
		super(b);
		requete = "Nom LIKE ?";
	}
}