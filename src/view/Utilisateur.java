package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.Reservation;
import model.Biere;

/**
 * @author FRANC Pierre, GIBASSIER Romain
 * @version 1.0
 * 
 * Affiche la liste de bières ou rien
 */
@SuppressWarnings("serial")
public class Utilisateur extends JPanel {
	JList<Biere> jlb;
	
	public Utilisateur() {
	
	}
	
	public Utilisateur(ArrayList<Biere> alb) {
		
		setLayout(new BorderLayout());
		
		JPanel title = new JPanel();
		title.setLayout(new FlowLayout());
		title.setBackground(new Color(196, 215, 237));
		JLabel[] jl= new JLabel[10];
		String[] s = {"Nom", "Marque", "Pays", "Type de Fermentation", "Couleur", "Degré", "Prix", "Amertume", "Douceur", "% de pertinence"};
		
		for(int i = 0; i < 10; i++) {
			jl[i] = new JLabel(s[i]);
			jl[i].setBorder(new EmptyBorder(10,10,10,10));
			jl[i].setFont(new Font("Dialog",Font.BOLD,14));
		}
		jl[0].setPreferredSize(new Dimension(300, 20));
		jl[1].setPreferredSize(new Dimension(300,20));
		jl[2].setPreferredSize(new Dimension(120,20));
		jl[3].setPreferredSize(new Dimension(130,20));
		jl[4].setPreferredSize(new Dimension(100,20));
		jl[5].setPreferredSize(new Dimension(100,20));
		jl[6].setPreferredSize(new Dimension(100,20));
		jl[7].setPreferredSize(new Dimension(100,20));
		jl[8].setPreferredSize(new Dimension(100,20));
		jl[9].setPreferredSize(new Dimension(100, 20));
		
		for(int i = 0; i < 10; i++) {
			title.add(jl[i]);		
		}
		
		JPanel j = new JPanel();
		j.setBackground(new Color(196, 215, 237));
		j.setBackground(new Color(196, 215, 237));
		BiereListModel blm = new BiereListModel(alb);
		BiereListRenderer blr = new BiereListRenderer();
		jlb = new JList<Biere>(blm);
		jlb.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jlb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlb.setCellRenderer(blr);
		j.add(jlb);
		
		jlb.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	JPanel j1 = new JPanel();
                	JButton res = new JButton("Réserver");
                	res.setFont(new Font("Dialog",Font.BOLD,14));
                	res.addActionListener(new Reservation(jlb.getSelectedValue()));
                	res.setPreferredSize(new Dimension(100,30));
                	j1.add(res);
                	j1.setBackground(new Color(196, 215, 237));
                	add(j1,BorderLayout.SOUTH);
                	
                	revalidate();
                }
            }
        });
		
		add(title,BorderLayout.NORTH);
		add(j, BorderLayout.CENTER);
	}
}
