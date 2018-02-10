package model;

public class Nom extends Critere {
	public Nom(Selection b) {
		super(b);
		requete = "Nom LIKE ?";
	}
}