package view;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import model.ConnexionBDD;

public class Administrateur extends JPanel {
	ConnexionBDD c;
	public Administrateur() {
		c = new ConnexionBDD();
		GridLayout gl = new GridLayout(1,2,50,50);
		setLayout(gl);
		Ajouter ajouter = new Ajouter();
		Modifier modifier = new Modifier();
		
		ajouter.setLayout(new BoxLayout(ajouter, BoxLayout.PAGE_AXIS));
		modifier.setLayout(new BoxLayout(modifier, BoxLayout.PAGE_AXIS));
		
		add(ajouter);
		add(modifier);
	}
}
