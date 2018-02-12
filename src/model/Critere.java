package model;

/**
 * @author FRANC Pierre, GIBASSIER Romain
 * @version 1.0
 * 
 * Objet permettant d'ajouter des conditions à une requête
 */
public abstract class Critere {
	protected Requete b;	
	String requete;
	
	public Critere(Requete b) {
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
