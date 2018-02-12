package controller;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import view.Fenetre;

/**
 * @author FRANC Pierre, GIBASSIER Romain
 * @version 1.0
 * 
 * Demande d'authentification
 */

public class Login implements ActionListener {
	Fenetre f;
	AdminController ad;
	JLabel login;
	JTextField login1;
	JLabel mdp;
	JPasswordField mdp1;
	
	public Login(AdminController ad, Fenetre f) {
		this.f = f;
		this.ad = ad;
		
		login = new JLabel("Login");
        login1 = new JTextField(25);
         
        mdp = new JLabel("Mot de Passe");
        mdp1 = new JPasswordField(25);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
        JPanel j = new JPanel();
        j.setLayout(new FlowLayout());
        j.add(login);
        j.add(login1);
        j.add(mdp);
        j.add(mdp1);
        
        UIManager.put("OptionPane.okButtonText", "Se connecter");
        JOptionPane.showMessageDialog(f, j, "Login", JOptionPane.NO_OPTION);
        ad.getAdmin(login1.getText(), mdp1.getPassword());
        login1.setText("");
        mdp1.setText("");
	}
}
