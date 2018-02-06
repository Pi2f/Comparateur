package model;

public class Prix extends Critere {
	public Prix(Selection b) {
		super(b);
	}
	
	@Override
	public void requete() {
		b.setS(b.getS() + "Prix >= ? && Prix <= ?");
	}
}
