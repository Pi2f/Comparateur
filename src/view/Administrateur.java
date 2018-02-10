package view;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Administrateur extends JPanel {
	public Administrateur() {
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
