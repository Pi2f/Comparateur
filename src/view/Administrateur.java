package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.ConnexionBDD;

public class Administrateur extends JPanel {
	JButton jb1;
	JButton jb2;
	JButton jb3;
	
	public Administrateur() {
		
		setLayout(new GridLayout(20,1));
		
		jb1 = new JButton("Ajouter");
//		jb2 = new JButton("Modifier");
//		jb3 = new JButton("Supprimer");
		
		JLabel ljtf1 = new JLabel("Nom");
		JTextField jtf1 = new JTextField();
		JLabel ljtf2 = new JLabel("Marque");
		JTextField jtf2 = new JTextField();
		JLabel ljtf3 = new JLabel("Degré");
		JTextField jtf3 = new JTextField();
		JLabel ljtf4 = new JLabel("Prix");
		JTextField jtf4 = new JTextField();
		JLabel ljtf5 = new JLabel("Pays");
		JTextField jtf5 = new JTextField();
		JLabel ljtf6 = new JLabel("Couleur");
		JTextField jtf6 = new JTextField();
		JLabel ljtf7 = new JLabel("Type de fermentation");
		JTextField jtf7 = new JTextField();
		JLabel ljtf8 = new JLabel("Douceur");
		JTextField jtf8 = new JTextField();
		JLabel ljtf9 = new JLabel("Amertume");
		JTextField jtf9 = new JTextField();
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ConnexionBDD c = new ConnexionBDD();
				try {
					c.ajouter(jtf1.getText(), jtf2.getText(), jtf5.getText(),
							jtf4.getText(), jtf3.getText(), jtf6.getText(), jtf7.getText(),
							jtf8.getText(), jtf9.getText());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				jtf5.setText("");
				jtf6.setText("");
				jtf7.setText("");
				jtf8.setText("");
				jtf9.setText("");
				try {
					c.terminer();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
				
			}
		});
		
		add(ljtf1);
		add(jtf1);
		
		add(ljtf2);
		add(jtf2);
		
		add(ljtf3);
		add(jtf3);
		
		add(ljtf4);
		add(jtf4);
		
		add(ljtf5);
		add(jtf5);
		
		add(ljtf6);
		add(jtf6);
		
		add(ljtf7);
		add(jtf7);
		
		add(ljtf8);
		add(jtf8);
		
		add(ljtf9);
		add(jtf9);
		
		add(jb1);
//		add(jb2);
//		add(jb3);
	}
}
