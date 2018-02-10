package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.AdminController;
import controller.UtilisateurController;

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
		
		admin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel login = new JLabel("Login");
		        JTextField login1 = new JTextField(25);
		         
		        JLabel mdp = new JLabel("Mot de Passe");
		        JPasswordField mdp1 = new JPasswordField(25);
		        
		        JPanel j = new JPanel();
		        j.setLayout(new FlowLayout());
		        j.add(login);
		        j.add(login1);
		        j.add(mdp);
		        j.add(mdp1);
		        
		        setLocationRelativeTo(null);
		        JOptionPane.showMessageDialog(fo, j, "Login", JOptionPane.NO_OPTION);
		        
		        
				AdminController ad = new AdminController(fo, content, cl, listContent, login1, mdp1);
				ad.actionPerformed(null);
			}
		});
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
		Fenetre f = new Fenetre("BeerComparator", 0, 0, MAXIMIZED_HORIZ, MAXIMIZED_VERT);
	}
}
