package model;

import com.visutools.nav.bislider.BiSlider;

public class Score {
	private int score;
	private double prixMin, prixMax;
	private double prixColoredMax, prixColoredMin;
	
	public Score(BiSlider b1) {
		prixMin = b1.getMinimumValue();
		prixMax = b1.getMaximumValue();
		prixColoredMax = b1.getMaximumColoredValue();
		prixColoredMin = b1.getMinimumValue();
	}
	
	public int calculScore(Biere b) {
		
		int valeur;
		double cond;
		double moy = (prixColoredMax - prixColoredMin)/2;
		double fourchette = prixColoredMax - prixColoredMin;
		double intervalle = (prixColoredMax - prixColoredMin)/10;
		double intervalleTotal = (prixMax - prixMin)/10;
		
		score = 0;
		
		if(fourchette >= 5*intervalleTotal) {
			cond = Math.abs(b.getPrix() - moy);
			valeur = 20;
			while(cond > 0) {
				cond = cond - intervalle;
				valeur -= 4;
			}
			score += valeur;
		} else {
			if(b.getPrix() < prixColoredMin) {
				valeur = 10;
				cond = Math.abs(b.getPrix() - prixColoredMin);
				while(cond > 0) {
					cond = cond - intervalle;
					valeur -= 2;
				}
				score += valeur;
			}
			
			if(b.getPrix() > prixColoredMax) {
				valeur = 10;
				cond = Math.abs(b.getPrix() - prixColoredMax);
				while(cond > 0) {
					cond = cond - intervalle;
					valeur -= 2;
				}
				score += valeur;
			}
			
			if(b.getPrix() >= prixColoredMin && b.getPrix() <= prixColoredMax) {
				valeur = 30;
				cond = Math.abs(b.getPrix() - moy);
				while(cond > 0) {
					cond = cond - intervalle;
					valeur -= 5;
				}
				score += valeur;
			}
		}
		
		return score;
	}
}
