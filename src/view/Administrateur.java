package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Administrateur extends JPanel {
	JButton jb1;
	JButton jb2;
	JButton jb3;
	
	public Administrateur() {
		
		setLayout(new FlowLayout());
		
		jb1 = new JButton("Ajouter");
		jb2 = new JButton("Modifier");
		jb3 = new JButton("Supprimer");
		
		add(jb1);
		add(jb2);
		add(jb3);
	}
}
