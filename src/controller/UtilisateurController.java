package controller;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

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
import view.Formulaire;
import view.Utilisateur;

public class UtilisateurController implements ActionListener {
	
	private Formulaire fo;
	private Selection b;
	private Score sc;
	private ConnexionBDD c;
	private JPanel content;
	private CardLayout cl;
	private String listContent;
	
	public UtilisateurController(Formulaire fo, JPanel content, CardLayout cl, String listContent) {
		this.fo = fo;
		this.cl = cl;
		this.content = content;
		this.listContent = listContent;
		b = new Selection();
	}
	
	private void enable() {
		Component[] c = fo.getComponents();
		for(int i = 0; i < c.length-2; i++) {
			c[i].setEnabled(true);
		}
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		enable();
		c = new ConnexionBDD();
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
		
		sc = new Score(fo.getBs1(), fo.getBs2(), fo.getJs1(), fo.getJs2());
		
		try {
			ArrayList<Biere> lb = c.lister(b.getS(),
					(String) fo.getJc1().getSelectedItem(),
					(String) fo.getJc2().getSelectedItem(),
					(String) fo.getJc3().getSelectedItem(),
					(String) fo.getJc4().getSelectedItem(),
					fo.getJtf().getText(),
					sc
					);
			c.terminer();
			content.add(new Utilisateur(lb), listContent);
			cl.show(content, listContent);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		b.clearS();
	}
}
