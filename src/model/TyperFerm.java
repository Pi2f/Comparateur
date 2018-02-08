package model;

public class TyperFerm extends Critere {
	public TyperFerm(Selection b) {
		super(b);
	}
	
	@Override
	public void requete() {
		b.setS(b.getS() + "TypeFerm = ?");
	}
}
