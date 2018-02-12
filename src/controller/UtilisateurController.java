package controller;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Biere;
import model.ConnexionBDD;

import view.Formulaire;
import view.Utilisateur;

public class UtilisateurController implements ActionListener {
	
	private Formulaire fo;
	private JPanel content;
	private CardLayout cl;
	private String listContent;
	private ConnexionBDD c = new ConnexionBDD();
	
	public UtilisateurController(Formulaire fo, JPanel content, CardLayout cl, String listContent) {
		this.fo = fo;
		this.cl = cl;
		this.content = content;
		this.listContent = listContent;
		c.createRequete();
		
		
		fo.getJc1().addItemListener(e -> {
	        String item = (String) e.getItem();
	        if (e.getStateChange() == ItemEvent.SELECTED && e.getItem() != "") {    
				fo.getCbr().setSelected(item,c.getRequete(),c.getRequete().getPays());
	        }
	    });
		
		fo.getJc2().addItemListener(e -> {
	        String item = (String) e.getItem();
	        if (e.getStateChange() == ItemEvent.SELECTED && e.getItem() != "") {
	        	fo.getCbr1().setSelected(item,c.getRequete(),c.getRequete().getMarque());
	        }
	    });
		
		fo.getJc3().addItemListener(e -> {
	        String item = (String) e.getItem();
	        if (e.getStateChange() == ItemEvent.SELECTED && e.getItem() != "") {
	        	fo.getCbr2().setSelected(item,c.getRequete(),c.getRequete().getTypeFerm());
	        }
	    });
		
		fo.getJc4().addItemListener(e -> {
	        String item = (String) e.getItem();
	        if (e.getStateChange() == ItemEvent.SELECTED && e.getItem() != "") {
	        	fo.getCbr3().setSelected(item,c.getRequete(),c.getRequete().getCouleur());
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
		if(c.getRequete() == null) {
			c.createRequete();
		}
		
		if(!fo.getJtf().getText().equalsIgnoreCase("")) {
			c.getRequete().andRequete();
			c.getRequete().getNom().requete(false);
		}
		c.getRequete().finRequete();
		try {
			ArrayList<Biere> lb = c.lister(c.getRequete().getS(),
					fo.getCbr().getSelectedItems(),
					fo.getCbr1().getSelectedItems(),
					fo.getJtf().getText()+"%",
					fo.getCbr2().getSelectedItems(),
					fo.getCbr3().getSelectedItems(),	
					c.getScore(fo.getBs1(), fo.getBs2(), fo.getJs1(), fo.getJs2())
					);
			
			if(lb.size() == 0) {
				JOptionPane.showMessageDialog(content,"Aucun élément ne correspond à la sélection", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			content.add(new Utilisateur(lb), listContent);
			cl.show(content, listContent);
			content.revalidate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		fo.resetForm();
		c.getRequete().clearS();
	}
}
