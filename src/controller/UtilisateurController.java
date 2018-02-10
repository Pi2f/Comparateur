package controller;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
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
	CheckBoxRenderer cbr, cbr1, cbr2, cbr3;
	
	public UtilisateurController(Formulaire fo, JPanel content, CardLayout cl, String listContent) {
		this.fo = fo;
		this.cl = cl;
		this.content = content;
		this.listContent = listContent;
		b = new Selection();
		c = new ConnexionBDD();
		
		String[] pays = null;
		String[] marque = null;
		String[] couleur = null;
		String[] typeferm = null;
		try {
			pays = c.getPays();
			marque = c.getMarque();
			couleur = c.getCouleur();
			typeferm = c.getTypeFerm();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		cbr = new CheckBoxRenderer(pays);
		fo.getJc1().setRenderer(cbr);
		cbr1 = new CheckBoxRenderer(marque);
		fo.getJc2().setRenderer(cbr1);
		cbr2 = new CheckBoxRenderer(couleur);
		fo.getJc3().setRenderer(cbr2);
		cbr3 = new CheckBoxRenderer(typeferm);
		fo.getJc4().setRenderer(cbr3);
		
		fo.getJc1().addItemListener(e -> {
	        String item = (String) e.getItem();
	        if (e.getStateChange() == ItemEvent.SELECTED) {
	            try {
					cbr.setSelected(item,c,b,Pays.class.getConstructor(Selection.class));
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e1) {
					e1.printStackTrace();
				}
	        }
	    });
		
		fo.getJc2().addItemListener(e -> {
	        String item = (String) e.getItem();
	        if (e.getStateChange() == ItemEvent.SELECTED) {
	            try {
					cbr1.setSelected(item,c,b,Marque.class.getConstructor(Selection.class));
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e1) {
					e1.printStackTrace();
				}
	        }
	    });
		
		fo.getJc3().addItemListener(e -> {
	        String item = (String) e.getItem();
	        if (e.getStateChange() == ItemEvent.SELECTED) {
	            try {
					cbr2.setSelected(item,c,b,Couleur.class.getConstructor(Selection.class));
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e1) {
					e1.printStackTrace();
				}
	        }
	    });
		
		fo.getJc4().addItemListener(e -> {
	        String item = (String) e.getItem();
	        if (e.getStateChange() == ItemEvent.SELECTED) {
	            try {
					cbr3.setSelected(item,c,b,TyperFerm.class.getConstructor(Selection.class));
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e1) {
					e1.printStackTrace();
				}
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
		
		if(!fo.getJtf().getText().equalsIgnoreCase("")) {
			b.andRequete();
			ct = new Nom(b);
			ct.requete(false);
		}
		
		sc = new Score(fo.getBs1(), fo.getBs2(), fo.getJs1(), fo.getJs2());
		b.finRequete();
		try {
			ArrayList<Biere> lb = c.lister(b.getS(),
					cbr.getSelectedItems(),
					cbr1.getSelectedItems(),
					fo.getJtf().getText()+"%",
					cbr2.getSelectedItems(),
					cbr3.getSelectedItems(),					
					sc
					);
			c.terminer();
			
			if(lb.size() == 0) {
				JOptionPane.showMessageDialog(content,"Aucun élément ne correspond à la sélection", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			content.add(new Utilisateur(lb), listContent);
			cl.show(content, listContent);
			content.revalidate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cbr.resetSelectedItems();
		cbr1.resetSelectedItems();
		cbr2.resetSelectedItems();
		cbr3.resetSelectedItems();
		b.clearS();
	}
}
