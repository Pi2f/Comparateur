package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
		
	  CardLayout cl = new CardLayout();
	  JPanel content = new JPanel();
	  String[] listContent = {"CARD_1", "CARD_2"};
	  JButton j = new JButton("Admin");
	
	public Fenetre(String title, int left, int top, int width, int height){
		setTitle(title);
		setBounds(top,left,width,height);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		Formulaire fo = new Formulaire();
		fo.addListener(content, cl, listContent[1]);
		fo.addListener2(content, cl, listContent[0]);
		
		//On définit le layout
	    content.setLayout(cl);
	    //On ajoute les cartes à la pile avec un nom pour les retrouver
	    Administrateur ad = new Administrateur();
	    Utilisateur us = new Utilisateur();
	    content.add(us, listContent[0]);
	    content.add(ad, listContent[1]);

	    getContentPane().add(fo, BorderLayout.WEST);
	    getContentPane().add(content, BorderLayout.CENTER);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Fenetre f = new Fenetre("BeerComparator", 0, 0, MAXIMIZED_HORIZ, MAXIMIZED_VERT);
	}
}
