package model;

public abstract class Critere {
	protected Selection b;
	
	public Critere(Selection b) {
		this.b = b;
	}
	
	public abstract void requete();
}
