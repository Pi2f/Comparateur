package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import model.Biere;

@SuppressWarnings("serial")
public class BiereListRenderer extends JPanel implements ListCellRenderer<Biere> {
	private JLabel nom;
	private JLabel marque;
	private JLabel pays;
	private JLabel typeferm;
	private JLabel couleur;
	private JLabel degre;
	private JLabel prix;
	private JLabel douceur;
	private JLabel amertume;
	private JLabel score;
	
	public BiereListRenderer() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		nom = new JLabel();
		marque = new JLabel();
		pays = new JLabel();
		typeferm = new JLabel();
		couleur = new JLabel();
		degre = new JLabel();
		prix = new JLabel();
		douceur = new JLabel();
		amertume = new JLabel();
		score = new JLabel();
		
		nom.setPreferredSize(new Dimension(300, 20));
		marque.setPreferredSize(new Dimension(300,20));
		pays.setPreferredSize(new Dimension(120,20));
		typeferm.setPreferredSize(new Dimension(130,20));
		couleur.setPreferredSize(new Dimension(60,20));
		degre.setPreferredSize(new Dimension(60,20));
		prix.setPreferredSize(new Dimension(60,20));
		douceur.setPreferredSize(new Dimension(60,20));
		amertume.setPreferredSize(new Dimension(60,20));
		score.setPreferredSize(new Dimension(60, 20));
		
		add(nom);
		add(marque);
		add(pays);
		add(typeferm);
		add(couleur);
		add(degre);
		add(prix);
		add(douceur);
		add(amertume);
		add(score);
		
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Biere> arg0, Biere arg1, int arg2, boolean arg3,
			boolean arg4) {
		
		if(arg3){
			setBackground(Color.LIGHT_GRAY);
		}
		else{
			setBackground(Color.WHITE);	
		}
		
		nom.setText(arg1.getNom());
		marque.setText(arg1.getMarque());
		pays.setText(arg1.getPays());
		typeferm.setText(arg1.getTypFerm());
		couleur.setText(arg1.getCouleur());
		degre.setText(String.valueOf(arg1.getDegre()));
		prix.setText(String.valueOf(arg1.getPrix()));
		douceur.setText(String.valueOf(arg1.getAmertume()));
		amertume.setText(String.valueOf(arg1.getDouceur()));
		score.setText(String.valueOf(arg1.getScore()));
		
		setOpaque(true);
		return this;
	}
	
	
	
}
