package model;

public class Marque extends Critere {
	public Marque(Selection b) {
		super(b);
	}
	
	@Override
	public void requete() {
		b.setS(b.getS() + "Marque = ?");
	}
}
