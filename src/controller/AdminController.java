package controller;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.ConnexionBDD;
import view.Administrateur;
import view.Formulaire;

public class AdminController implements ActionListener {
	private Administrateur admin;
	private JPanel content;
	private CardLayout cl;
	private String listContent;
	Formulaire fo;
	
	public AdminController(Formulaire fo, JPanel content, CardLayout cl, String listContent) {
		this.cl = cl;
		this.content = content;
		this.listContent = listContent;
		this.fo = fo;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		admin = new Administrateur();
		content.add(admin,listContent);
		cl.show(content, listContent);
		disable();
	}
	
	private void disable() {
		Component[] c = fo.getComponents();
		for (int i = 0; i < c.length-2; i++) {
			c[i].setEnabled(false);
		}
	}
}
