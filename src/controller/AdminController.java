package controller;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.ConnexionBDD;
import view.Administrateur;
import view.Formulaire;
import view.Utilisateur;

public class AdminController implements ActionListener {
	private Administrateur admin;
	private JPanel content;
	private CardLayout cl;
	private String[] listContent;
	private Formulaire fo;
	private ConnexionBDD c;
	private JTextField login;
	private JPasswordField passwd;
	
	
	public AdminController(Formulaire fo, JPanel content, CardLayout cl, String[] listContent, JTextField login, JPasswordField passwd) {
		this.cl = cl;
		this.content = content;
		this.listContent = listContent;
		this.fo = fo;
		this.login = login;
		this.passwd = passwd;
		c = new ConnexionBDD();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String login1 = login.getText();
		String password = passwd.getText();
            try {
                PreparedStatement statement =  c.getConn().prepareStatement("SELECT password FROM authentification WHERE login ='"+login1+"'");
                ResultSet resultat = statement.executeQuery();
                 
                if(resultat.next()){
                    String motDePasse = resultat.getString(1);
	                if(motDePasse.equals(password)) {
	                    JOptionPane.showMessageDialog(null,"Connexion réussie ! ","Success",JOptionPane.PLAIN_MESSAGE);
	                    admin = new Administrateur();
	            		content.add(admin,listContent[1]);
	            		cl.show(content, listContent[1]);
	            		disable(); 
	                } else {   
	                    JOptionPane.showMessageDialog(null,"Mot de passe incorrect ! ","Error",JOptionPane.ERROR_MESSAGE);
	                    content.add(new Utilisateur(),listContent[1]);
	                    cl.show(content, listContent[0]);
	                    enable();
	                }
                } else {
                	JOptionPane.showMessageDialog(null,"Login incorrect ! ","Error",1);
                	content.add(new Utilisateur(),listContent[1]);
                    cl.show(content, listContent[0]);
                    enable();
                }
                content.revalidate();
                   	c.terminer();
            } catch (SQLException e4) {
                System.out.println(e4.getMessage());
            }
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
