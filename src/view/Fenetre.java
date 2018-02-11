package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.AdminController;
import controller.Login;
import controller.UtilisateurController;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {
		
	  CardLayout cl = new CardLayout();
	  JPanel content = new JPanel();
	  String[] listContent = {"CARD_1", "CARD_2"};
	  JButton admin;
	  JButton rech;
	
	public Fenetre(String title, int left, int top, int width, int height){
		setTitle(title);
		setBounds(top,left,width,height);
		setLocationRelativeTo(null);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		Formulaire fo = new Formulaire();
		fo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		rech = new JButton("Recherche");
		admin = new JButton("Administrateur");
		fo.add(rech);
		fo.add(admin);
		
		admin.addActionListener(new Login(new AdminController(fo, content, cl, listContent), this));
		rech.addActionListener(new UtilisateurController(fo,content,cl,listContent[0]));
		
		cl.setHgap(50);
	    content.setLayout(cl);
	    
	    getContentPane().add(fo, BorderLayout.WEST);
	    
	    JScrollPane jsp = new JScrollPane(content);
	    getContentPane().add(jsp, BorderLayout.CENTER);
	    
	    pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Fenetre("BeerComparator", 0, 0, MAXIMIZED_HORIZ, MAXIMIZED_VERT);
	}
}
