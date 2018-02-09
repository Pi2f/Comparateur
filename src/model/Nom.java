package model;

public class Nom extends Critere {
	public Nom(Selection b) {
		super(b);
	}
	
	@Override
	public void requete() {
		b.setS(b.getS() + "Nom LIKE ?");
	}
}