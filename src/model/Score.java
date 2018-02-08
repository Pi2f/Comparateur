package model;

import javax.swing.JSlider;

import com.visutools.nav.bislider.BiSlider;

public class Score {
	private int score;
	private double prixMin, prixMax;
	private double prixColoredMax, prixColoredMin;
	private double degreMin, degreMax;
	private double degreColoredMin, degreColoredMax;
	
	public Score(BiSlider b1, BiSlider b2, JSlider js1, JSlider js2) {
		prixMin = roundAvoid(b1.getMinimumValue(),2);
		prixMax = roundAvoid(b1.getMaximumValue(),2);
		prixColoredMax = roundAvoid(b1.getMaximumColoredValue(),2);
		prixColoredMin = roundAvoid(b1.getMinimumColoredValue(),2);
		
		degreMin = roundAvoid(b2.getMinimumValue(),2);
		degreMax = roundAvoid(b2.getMaximumValue(),2);
		degreColoredMax = roundAvoid(b2.getMaximumColoredValue(),2);
		degreColoredMin = roundAvoid(b2.getMinimumColoredValue(),2);
	}
	
	public int calculScore(Biere b) {	
		int valeur;
		double cond;
		double moy = roundAvoid((prixColoredMax + prixColoredMin)/2,2);
		double fourchette = prixColoredMax - prixColoredMin;
		double intervalle = prixColoredMax - prixColoredMin;
		double intervalleTotal = roundAvoid((prixMax - prixMin)/10,2);
		
		score = 0;
		
		int i = 0;
		while(fourchette > 0) {
			fourchette = fourchette - intervalleTotal;
			i++;
		}
		
		i--;
		intervalle = intervalle/i;
		valeur = 110 - i*10;
		int enleve = 11-i;
		cond = Math.abs(b.getPrix() - moy);
		while(cond > 0) {
			cond = cond - intervalle;
			valeur -= enleve;
		}
		score += valeur;
		
		return score;
	}
	
	public int calculScore2(Biere b) {	
		int valeur;
		double cond;
		double moy = roundAvoid((degreColoredMax + degreColoredMin)/2,2);
		double fourchette = degreColoredMax - degreColoredMin;
		double intervalle = degreColoredMax - degreColoredMin;
		double intervalleTotal = roundAvoid((degreMax - degreMin)/10,2);
		
		score = 0;
		
		int i = 0;
		while(fourchette > 0) {
			fourchette = fourchette - intervalleTotal;
			i++;
		}
		
		i--;
		intervalle = intervalle/i;
		valeur = 110 - i*10;
		int enleve = 11-i;
		cond = Math.abs(b.getDegre() - moy);
		while(cond > 0) {
			cond = cond - intervalle;
			valeur -= enleve;
		}
		score += valeur;
		return score;
	}
	
	public static double roundAvoid(double value, int places) {
	    double scale = Math.pow(10, places);
	    return Math.round(value * scale) / scale;
	}
}
