package view;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.AdminController;
import controller.Login;
import controller.UtilisateurController;



/**
 * @author FRANC Pierre, GIBASSIER Romain
 * @version 1.0
 *
 *Cette classe a pour but de lancer le comparateur de bière et d'afficher le 
 *formulaire ainsi que deux boutons (un pour rechercher et un pour l'administrateur).
 */
@SuppressWarnings("serial")
public class Fenetre extends JFrame {
		
	  CardLayout cl = new CardLayout();
	  JPanel content = new JPanel();
	  String[] listContent = {"CARD_1", "CARD_2"};
	  JButton admin;
	  JButton rech;
	
	  
 /**
 * @param title Titre de la fenêtre
 * @param left Position sur l'axe des abscisses de la fenêtre
 * @param top Position sur l'axe des ordonnées de la fenêtre
 * @param width Largeur de la fenêtre
 * @param height Hauteur de la fenêtre
 */
public Fenetre(String title, int left, int top, int width, int height){
		setTitle(title);
		setBounds(top,left,width,height);
		setLocationRelativeTo(null);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		Formulaire fo = new Formulaire();
		fo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		rech = new JButton("Recherche");
		rech.setFont(new Font("Dialog",Font.BOLD,18));
		rech.setPreferredSize(new Dimension(200, 40));
		rech.setBorder(new EmptyBorder(10,10,10,10));
		admin = new JButton("Administrateur");
		admin.setFont(new Font("Dialog",Font.BOLD,18));
		admin.setPreferredSize(new Dimension(200, 40));
		
		JPanel r = new JPanel();
		JPanel a = new JPanel();
		r.setBackground(new Color(255, 182, 184));
		a.setBackground(new Color(255, 182, 184));
		r.add(rech);
		a.add(admin);
		fo.add(r);
		fo.add(a);
		
		admin.addActionListener(new Login(new AdminController(fo, content, cl, listContent), this));
		rech.addActionListener(new UtilisateurController(fo,content,cl,listContent[0]));
		
		cl.setHgap(50);
	    content.setLayout(cl);
	    content.setBackground(new Color(196, 215, 237));
	    
	    getContentPane().add(fo, BorderLayout.WEST);
	    
	    JScrollPane jsp = new JScrollPane(content);
	    getContentPane().add(jsp, BorderLayout.CENTER);
	    
	    pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Début de l'application
	 */
	public static void main() {
		new Fenetre("BeerComparator", 0, 0, MAXIMIZED_HORIZ, MAXIMIZED_VERT);
	}
}
