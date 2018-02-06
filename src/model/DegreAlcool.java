package model;

public class DegreAlcool extends Critere {
	public DegreAlcool(Selection b) {
		super(b);
	}
	
	@Override
	public void requete() {
		b.setS(b.getS() + "Degre >= ? && Degre <= ?");
	}
}
