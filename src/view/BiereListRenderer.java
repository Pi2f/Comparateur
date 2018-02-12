package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import model.Biere;

/**
 * @author FRANC Pierre, GIBASSIER Romain
 * @version 1.0
 * 
 * Redéfinition du rendu de la liste, pour afficher une bière
 */
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
		couleur.setPreferredSize(new Dimension(100,20));
		degre.setPreferredSize(new Dimension(100,20));
		prix.setPreferredSize(new Dimension(100,20));
		douceur.setPreferredSize(new Dimension(100,20));
		amertume.setPreferredSize(new Dimension(100,20));
		score.setPreferredSize(new Dimension(100,20));
		
		nom.setBorder(new EmptyBorder(10,10,10,10));
		marque.setBorder(new EmptyBorder(10,10,10,10));
		pays.setBorder(new EmptyBorder(10,10,10,10));
		typeferm.setBorder(new EmptyBorder(10,10,10,10));
		couleur.setBorder(new EmptyBorder(10,10,10,10));
		degre.setBorder(new EmptyBorder(10,10,10,10));
		prix.setBorder(new EmptyBorder(10,10,10,10));
		douceur.setBorder(new EmptyBorder(10,10,10,10));
		amertume.setBorder(new EmptyBorder(10,10,10,10));
		score.setBorder(new EmptyBorder(10,10,10,10));
		
		nom.setFont(new Font("Dialog",Font.PLAIN,14));
		marque.setFont(new Font("Dialog",Font.PLAIN,14));
		pays.setFont(new Font("Dialog",Font.PLAIN,14));
		typeferm.setFont(new Font("Dialog",Font.PLAIN,14));
		couleur.setFont(new Font("Dialog",Font.PLAIN,14));
		degre.setFont(new Font("Dialog",Font.PLAIN,14));
		prix.setFont(new Font("Dialog",Font.PLAIN,14));
		douceur.setFont(new Font("Dialog",Font.PLAIN,14));
		amertume.setFont(new Font("Dialog",Font.PLAIN,14));
		score.setFont(new Font("Dialog",Font.PLAIN,14));
		
		nom.setBackground(new Color(196, 215, 237));
		pays.setBackground(new Color(196, 215, 237));
		couleur.setBackground(new Color(196, 215, 237));
		prix.setBackground(new Color(196, 215, 237));
		amertume.setBackground(new Color(196, 215, 237));
		
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
		
		if(arg2 % 2 == 0) {
			setBackground(new Color(225, 230, 250));
		} else {
			setBackground(Color.WHITE);
		}
		
		if(arg3){
			setBackground(Color.LIGHT_GRAY);
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
