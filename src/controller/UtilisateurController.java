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
		
		fo.getJc1().addItemListener(e -> {
	        String item = (String) e.getItem();
	        if (e.getStateChange() == ItemEvent.SELECTED) {
	            try {
					fo.getCbr().setSelected(item,c,b,Pays.class.getConstructor(Selection.class));
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
	            	fo.getCbr1().setSelected(item,c,b,Marque.class.getConstructor(Selection.class));
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
	            	fo.getCbr2().setSelected(item,c,b,Couleur.class.getConstructor(Selection.class));
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
	            	fo.getCbr3().setSelected(item,c,b,TyperFerm.class.getConstructor(Selection.class));
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e1) {
					e1.printStackTrace();
				}
	        }
	    });
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
					fo.getCbr().getSelectedItems(),
					fo.getCbr1().getSelectedItems(),
					fo.getJtf().getText()+"%",
					fo.getCbr2().getSelectedItems(),
					fo.getCbr3().getSelectedItems(),					
					sc
					);
			c.terminer();
			
			if(lb.size() == 0) {
				JOptionPane.showMessageDialog(content,"Aucun �l�ment ne correspond � la s�lection", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			content.add(new Utilisateur(lb), listContent);
			cl.show(content, listContent);
			content.revalidate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		fo.getCbr().resetSelectedItems();
		fo.getCbr1().resetSelectedItems();
		fo.getCbr2().resetSelectedItems();
		fo.getCbr3().resetSelectedItems();
		b.clearS();
	}
}
