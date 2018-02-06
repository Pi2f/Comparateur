package model;

public class Pays extends Critere {
	public Pays(Selection b) {
		super(b);
	}
	
	@Override
	public void requete() {
		b.setS(b.getS() + "Pays = ?");
	}
}