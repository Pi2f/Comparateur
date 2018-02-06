package model;

public class Couleur extends Critere {
	public Couleur(Selection b) {
		super(b);
	}
	
	@Override
	public void requete() {
		b.setS(b.getS() + "Couleur = ?");
	}
}
