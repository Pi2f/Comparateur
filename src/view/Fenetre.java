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

import controller.AdminController;
import controller.UtilisateurController;
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
	
	public Fenetre(String title, int left, int top, int width, int height){
		setTitle(title);
		setBounds(top,left,width,height);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		Formulaire fo = new Formulaire();
		fo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		rech = new JButton("Recherche");
		admin = new JButton("Administrateur");
		fo.add(rech);
		fo.add(admin);
		
		admin.addActionListener(new AdminController(fo, content,cl,listContent[1]));
		rech.addActionListener(new UtilisateurController(fo,content,cl,listContent[2]));
		
		cl.setHgap(50);
	    content.setLayout(cl);
	    
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
