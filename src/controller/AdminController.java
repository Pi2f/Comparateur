package controller;

import java.awt.CardLayout;
import java.awt.Component;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import model.ConnexionBDD;
import view.Administrateur;
import view.Formulaire;
import view.Utilisateur;

public class AdminController {
	private Administrateur admin;
	private JPanel content;
	private CardLayout cl;
	private String[] listContent;
	private Formulaire fo;
	private ConnexionBDD c;
	
	/**
	 * @author FRANC Pierre, GIBASSIER Romain
	 * @version 1.0
	 * 
	 * Contrôleur d'authentification
	 */
	public AdminController(Formulaire fo, JPanel content, CardLayout cl, String[] listContent) {
		this.cl = cl;
		this.content = content;
		this.listContent = listContent;
		this.fo = fo;
	}
	
	public void getAdmin(String login, char[] ds) {		
		boolean auth = false;
		c = new ConnexionBDD();
		try {
			auth = c.getAuth(login, ds);
			c.terminer();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        if(auth){
        	UIManager.put("OptionPane.okButtonText", "Suivant");
        	JOptionPane.showMessageDialog(null,"Connexion réussie ! ","Success",JOptionPane.PLAIN_MESSAGE);
            admin = new Administrateur();
    		content.add(admin,listContent[1]);
    		cl.show(content, listContent[1]);
    		disable();
        } else {
        	UIManager.put("OptionPane.okButtonText", "Quitter");
        	JOptionPane.showMessageDialog(null,"Login or Password incorrect ! ","Error",1);
        	content.add(new Utilisateur(),listContent[1]);
            cl.show(content, listContent[0]);
            enable();
        }
        content.revalidate();
	}
	
	private void disable() {
		Component[] c = fo.getComponents();
		for (int i = 0; i < c.length-1; i++) {
			c[i].setEnabled(false);
		}
	}
	
	private void enable() {
		Component[] c = fo.getComponents();
		for (int i = 0; i < c.length-1; i++) {
			c[i].setEnabled(true);
		}
	}
}
