package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import model.Biere;

@SuppressWarnings("serial")
public class Utilisateur extends JPanel {
	JList<Biere> jlb;
	
	public Utilisateur() {
	
	}
	
	public Utilisateur(ArrayList<Biere> alb) {
		
		setLayout(new BorderLayout());
		
		
		JPanel title = new JPanel();
		title.setLayout(new FlowLayout());
		JLabel[] jl= new JLabel[10];
		String[] s = {"Nom", "Marque", "Pays", "Type de Fermentation", "Couleur", "Degré", "Prix", "Amertume", "Douceur", "Score"};
		
		for(int i = 0; i < 10; i++) {
			jl[i] = new JLabel(s[i]);			
		}
		jl[0].setPreferredSize(new Dimension(300, 20));
		jl[1].setPreferredSize(new Dimension(300,20));
		jl[2].setPreferredSize(new Dimension(120,20));
		jl[3].setPreferredSize(new Dimension(130,20));
		jl[4].setPreferredSize(new Dimension(60,20));
		jl[5].setPreferredSize(new Dimension(60,20));
		jl[6].setPreferredSize(new Dimension(60,20));
		jl[7].setPreferredSize(new Dimension(60,20));
		jl[8].setPreferredSize(new Dimension(60,20));
		jl[9].setPreferredSize(new Dimension(60, 20));
		for(int i = 0; i < 10; i++) {
			title.add(jl[i]);		
		}
		
		JPanel j = new JPanel();
		BiereListModel blm = new BiereListModel(alb);
		BiereListRenderer blr = new BiereListRenderer();
		jlb = new JList<Biere>(blm);
		jlb.setCellRenderer(blr);
		j.add(jlb);
		
		add(title,BorderLayout.NORTH);
		add(j, BorderLayout.CENTER);
		
	}
}
