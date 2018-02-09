package controller;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
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
import view.CheckBoxRenderer;
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
	CheckBoxRenderer cbr;
	
	public UtilisateurController(Formulaire fo, JPanel content, CardLayout cl, String listContent) {
		this.fo = fo;
		this.cl = cl;
		this.content = content;
		this.listContent = listContent;
		b = new Selection();
		c = new ConnexionBDD();
		
		String[] pays = null;
		try {
			pays = c.getPays();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		cbr = new CheckBoxRenderer(pays);
		fo.getJc1().setRenderer(cbr);
		fo.getJc1().addItemListener(e -> {
	        String item = (String) e.getItem();
	        if (e.getStateChange() == ItemEvent.SELECTED) {
	            cbr.setSelected(item,c,b);
	        }
	    });
		try {
			c.terminer();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
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
		Critere ct;
		
		if(cbr.getSelectedItems().length != 0) {
			b.parentheseClose();
		}
		
		if(fo.getJc2().getSelectedIndex() != 0) {
			b.andRequete();
			ct = new Marque(b);
			ct.requete();
		}
		
		if(fo.getJc3().getSelectedIndex() != 0) {
			b.andRequete();
			ct = new Couleur(b);
			ct.requete();
		}
		
		if(fo.getJc4().getSelectedIndex() != 0) {
			b.andRequete();
			ct = new TyperFerm(b);
			ct.requete();
		}
		
		if(!fo.getJtf().getText().equalsIgnoreCase("")) {
			b.andRequete();
			ct = new Nom(b);
			ct.requete();
		}
		
		sc = new Score(fo.getBs1(), fo.getBs2(), fo.getJs1(), fo.getJs2());
		
		try {
			ArrayList<Biere> lb = c.lister(b.getS(),
					cbr.getSelectedItems(),
					(String) fo.getJc2().getSelectedItem(),
					fo.getJtf().getText()+"%",
					(String) fo.getJc3().getSelectedItem(),
					(String) fo.getJc4().getSelectedItem(),					
					sc
					);
			c.terminer();
			content.add(new Utilisateur(lb), listContent);
			cl.show(content, listContent);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cbr.resetSelectedItems();
		b.clearS();
	}
}
