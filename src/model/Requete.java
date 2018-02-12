package model;

/**
 * @author FRANC Pierre, GIBASSIER Romain
 * @version 1.0
 * 
 * Requête utilisé pour la recherche dans la BDD
 */
public class Requete {
		private String s;
		
		public Requete() {
			s = "SELECT * FROM beer WHERE (1=1";
		}
		
		public String getS() {
			return s;
		}
		
		public void setS(String s) {
			this.s = s;
		}
		
		public Critere getNom() {
			return new Nom(this);
		}
		
		public Critere getPays() {
			return new Pays(this);
		}
		
		public Critere getMarque() {
			return new Marque(this);
		}
		
		public Critere getTypeFerm() {
			return new TyperFerm(this);
		}
		
		public Critere getCouleur() {
			return new Couleur(this);
		}
		
		public void andRequete() {
			setS(getS() + ") AND (");
		}
		
		public void finRequete() {
			setS(getS() + ")");
		}
		
		public void clearS() {
			s = "SELECT * FROM beer WHERE (1=1";
		}
}
