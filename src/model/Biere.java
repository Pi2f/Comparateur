package model;

public class Biere implements Comparable<Biere>{
	private double prix;
	private double degre;
	private String nom;
	private String marque;
	private String pays;
	private String couleur;
	private String typFerm;
	private int douceur;
	private int amertume;
	private int score;
	
	public Biere(double prix, double degre, String nom, String marque,
			String pays, String couleur, String typFerm, int douceur, int amertume) {
		this.prix = prix;
		this.degre = degre;
		this.nom = nom;
		this.marque = marque;
		this.pays = pays;
		this.couleur = couleur;
		this.typFerm = typFerm;
		this.douceur = douceur;
		this.amertume = amertume;
	}
	
	public double getPrix() {
		return prix;
	}
	public double getDegre() {
		return degre;
	}
	public String getNom() {
		return nom;
	}
	public String getMarque() {
		return marque;
	}
	public String getPays() {
		return pays;
	}
	public String getCouleur() {
		return couleur;
	}
	public String getTypFerm() {
		return typFerm;
	}
	
	public int getAmertume() {
		return amertume;
	}
	
	public int getDouceur() {
		return douceur;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public int compareTo(Biere arg0) {
		return arg0.score-score;
	}
}
