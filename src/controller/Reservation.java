package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import model.Biere;

public class Reservation implements ActionListener {
	
	JLabel biere;
	JLabel nom;
	JTextField nom1;
	JLabel prenom;
	JTextField prenom1;
	
	public Reservation(Biere b) {
		biere = new JLabel("Voulez-vous réserver " + b.getNom() + " ?");
		nom = new JLabel("Nom");
        nom1 = new JTextField(25);
         
        prenom = new JLabel("Prenom");
        prenom1 = new JPasswordField(25);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JPanel res = new JPanel();
		res.setLayout(new BorderLayout());
        JPanel j = new JPanel();
        JPanel j1 = new JPanel();
        JPanel j2 = new JPanel();
        j.add(biere);
        j2.add(nom);
        j1.add(nom1);
        j2.add(prenom);
        j1.add(prenom1);
        
        res.add(j,BorderLayout.NORTH);
        res.add(j2,BorderLayout.WEST);
        res.add(j1,BorderLayout.CENTER);
        
        
        UIManager.put("OptionPane.okButtonText", "Réserver");
        JOptionPane.showMessageDialog(res.getParent(), res,"Réserver",JOptionPane.NO_OPTION);
        nom1.setText("");
        prenom1.setText("");
	}
}
