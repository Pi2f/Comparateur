package model;

public abstract class Critere {
	protected Selection b;	
	String requete;
	
	public Critere(Selection b) {
		this.b = b;
	}
	
	public void requete(boolean add) {
		
		if(add) {
			b.setS(b.getS() + " OR " + requete);
		} else {
			b.setS(b.getS() + requete);
		}
		
	}
}
