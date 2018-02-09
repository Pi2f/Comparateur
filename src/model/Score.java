package model;

import javax.swing.JSlider;

import com.visutools.nav.bislider.BiSlider;

public class Score {
	private int score;
	private BiSlider bs1;
	private BiSlider bs2;
	private JSlider s1;
	private JSlider s2;
	
	public Score(BiSlider bs1, BiSlider bs2, JSlider s1, JSlider s2) {
		this.bs1 = bs1;
		this.bs2 = bs2;
		this.s1 = s1;
		this.s2 = s2;
	}
	
	public int getScore(Biere b) {
		score = 0;
		calculScore(b.getPrix(), bs1);
		calculScore(b.getDegre(), bs2);
		return score;
	}
	
	public void calculScore(double valEchelle, BiSlider bs) {	
		int valeur;
		double cond;
		int enleve;
		double Min = roundAvoid(bs.getMinimumValue(),2);
		double Max = roundAvoid(bs.getMaximumValue(),2);
		double ColoredMax = roundAvoid(bs.getMaximumColoredValue(),2);
		double ColoredMin = roundAvoid(bs.getMinimumColoredValue(),2);
		double moy = roundAvoid((ColoredMax + ColoredMin)/2,2);
		double fourchette = ColoredMax - ColoredMin;
		double intervalle = ColoredMax - ColoredMin;
		double intervalleTotal = roundAvoid((Max - Min)/10,2);
		
		
		int i = 0;
		while(fourchette > 0) {
			fourchette = fourchette - intervalleTotal;
			i++;
		}
		
		if(i > 1) {
			i--;
		}
		
		intervalle = intervalle/i;
		valeur = 110 - i*10;
		enleve = 11-i;
		cond = Math.abs(valEchelle - moy);
		while(cond > 0) {
			cond = cond - intervalle;
			valeur -= enleve;
		}
		score += valeur;
	}
	
	public static double roundAvoid(double value, int places) {
	    double scale = Math.pow(10, places);
	    return Math.round(value * scale) / scale;
	}
}
