package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

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
