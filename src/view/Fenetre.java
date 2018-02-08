package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Biere;
import model.ConnexionBDD;
import model.Couleur;
import model.Critere;
import model.Marque;
import model.Nom;
import model.Pays;
import model.Score;
import model.Selection;
import model.TyperFerm;

public class Fenetre extends JFrame {
		
	  CardLayout cl = new CardLayout();
	  JPanel content = new JPanel();
	  String[] listContent = {"CARD_1", "CARD_2", "CARD_3"};
	  JButton admin;
	  JButton rech;
	  Selection b;
	  Score sc;
	  ConnexionBDD c = new ConnexionBDD();
	
	public Fenetre(String title, int left, int top, int width, int height){
		setTitle(title);
		setBounds(top,left,width,height);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		Formulaire fo = new Formulaire(c);
		fo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		rech = new JButton("Recherche");
		admin = new JButton("Administrateur");
		fo.add(rech);
		fo.add(admin);
		
		admin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(content, listContent[1]);
			}
		});
			
		rech.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				b = new Selection();
				Critere ct;
				
				if(fo.getJc1().getSelectedIndex() != 0) {
					b.addrequete();
					ct = new Pays(b);
					ct.requete();
				}
				
				if(fo.getJc2().getSelectedIndex() != 0) {
					b.addrequete();
					ct = new Marque(b);
					ct.requete();
				}
				
				if(fo.getJc3().getSelectedIndex() != 0) {
					b.addrequete();
					ct = new Couleur(b);
					ct.requete();
				}
				
				if(fo.getJc4().getSelectedIndex() != 0) {
					b.addrequete();
					ct = new TyperFerm(b);
					ct.requete();
				}
				
				if(!fo.getJtf().getText().equalsIgnoreCase("")) {
					b.addrequete();
					ct = new Nom(b);
					ct.requete();
				}
				
				sc = new Score(fo.getBs1());
				
				try {
					ArrayList<Biere> lb = c.lister(b.getS(),
							(String) fo.getJc1().getSelectedItem(),
							(String) fo.getJc2().getSelectedItem(),
							(String) fo.getJc3().getSelectedItem(),
							(String) fo.getJc4().getSelectedItem(),
							fo.getJtf().getText(),
							sc
							);
					content.add(new Utilisateur(lb), listContent[2]);
					cl.show(content, listContent[2]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				b.clearS();
			}
		});
		
		//On définit le layout
		cl.setHgap(50);
	    content.setLayout(cl);
	    //On ajoute les cartes à la pile avec un nom pour les retrouver
	    Administrateur ad = new Administrateur();
	    Utilisateur us = new Utilisateur();
	    content.add(us, listContent[0]);
	    content.add(ad, listContent[1]);
	    
	    getContentPane().add(fo, BorderLayout.WEST);
	    
	    JScrollPane jsp = new JScrollPane(content);
	    getContentPane().add(jsp, BorderLayout.CENTER);
	    
	    pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Fenetre f = new Fenetre("BeerComparator", 0, 0, MAXIMIZED_HORIZ, MAXIMIZED_VERT);
	}
}
