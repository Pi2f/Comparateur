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

public class Reservation implements ActionListener {
	
	JLabel nom;
	JTextField nom1;
	JLabel prenom;
	JTextField prenom1;
	
	public Reservation() {	
		nom = new JLabel("Nom");
        nom1 = new JTextField(25);
         
        prenom = new JLabel("Prenom");
        prenom1 = new JPasswordField(25);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
        JPanel j = new JPanel();
        j.setLayout(new FlowLayout());
        j.add(nom);
        j.add(nom1);
        j.add(prenom);
        j.add(prenom1);
        
        UIManager.put("OptionPane.okButtonText", "Réserver");
        JOptionPane.showMessageDialog(j.getParent(), j,"Réserver",JOptionPane.NO_OPTION);
        nom1.setText("");
        prenom1.setText("");
	}
}
