package view;

import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;

import model.Biere;
import model.ConnexionBDD;

public class Utilisateur extends JPanel {
	ConnexionBDD c;
	JList<Biere> jlb;
	
	public Utilisateur() {
	
	}
	
	public Utilisateur(ArrayList<Biere> alb) {
		BiereListModel blm = new BiereListModel(alb);
		BiereListRenderer blr = new BiereListRenderer();
		jlb = new JList<Biere>(blm);
		jlb.setCellRenderer(blr);
		add(jlb);
	}
}
