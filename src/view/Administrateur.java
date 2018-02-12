package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * @author FRANC Pierre, GIBASSIER Romain
 * @version 1.0
 * 
 * Affichage des panneaux pour ajouter ou modifier une bière en tant qu'administrateur
 */
@SuppressWarnings("serial")
public class Administrateur extends JPanel {
	public Administrateur() {
		setBackground(new Color(196, 215, 237));
		GridLayout gl = new GridLayout(1,2,50,50);
		setLayout(gl);
		Ajouter ajouter = new Ajouter();
		Modifier modifier = new Modifier();
		
		ajouter.setLayout(new BoxLayout(ajouter, BoxLayout.PAGE_AXIS));
		ajouter.setBackground(new Color(196, 215, 237));
		modifier.setLayout(new BoxLayout(modifier, BoxLayout.PAGE_AXIS));
		modifier.setBackground(new Color(196, 215, 237));
		
		add(ajouter);
		add(modifier);
	}
}
