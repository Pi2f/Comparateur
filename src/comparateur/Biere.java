package comparateur;

public class Biere extends Selection {
	double prix;
	double degre;
	String couleur;
	String style;
	
	public Biere(String s, String c, double d, double p) {
		style = s;
		couleur = c;
		degre = d;
		prix = p;
	}
	
	public Biere getB() {
		return this;
	}
	
	public String getCouleur() {
		return couleur;
	}
	
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public double getDegre() {
		return degre;
	}
	
	public void setDegre(double degre) {
		this.degre = degre;
	}
	
	public String getStyle() {
		return style;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}

}
