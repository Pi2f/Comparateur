package model;

public class Couleur extends Critere {
	public Couleur(Selection b) {
		super(b);
		requete = "Couleur = ?";
	}
}
