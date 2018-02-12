package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ConnexionBDD;

/**
 * @author FRANC Pierre, GIBASSIER Romain
 * @version 1.0
 * 
 * Panneau qui permet la modification des bières de la BDD.
 */
@SuppressWarnings("serial")
public class Ajouter extends JPanel{
	private JButton jb1;
	private ConnexionBDD c;
	
	public Ajouter() {
		JLabel aj = new JLabel("Ajouter une Bière");
		aj.setFont(new Font("Dialog",Font.BOLD,20));
		add(aj);
		
		JLabel[] lajout = new JLabel[9];
		String[] sAjout = {"Nom" ,"Marque","Pays","Prix","Degré","Couleur","Type de fermentation","Amertume","Douceur"};
		JTextField[] iajout = new JTextField[9];
		jb1 = new JButton("Ajouter");
		jb1.setFont(new Font("Dialog",Font.BOLD,14));
		
		for(int i = 0; i < 9; i++) {
			lajout[i] = new JLabel(sAjout[i]);
			iajout[i] = new JTextField();
			iajout[i].setMaximumSize(new Dimension(500, 30));
			lajout[i].setFont(new Font("Dialog",Font.PLAIN,18));
		}
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					c = new ConnexionBDD();
					c.ajouter(iajout[0].getText(), iajout[1].getText(), iajout[2].getText(),
							iajout[3].getText(), iajout[4].getText(), iajout[5].getText(), iajout[6].getText(),
							iajout[7].getText(), iajout[8].getText());
					c.terminer();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				for(int i = 0; i < 9; i++) {
					iajout[i].setText("");
				}
				revalidate();
				
			}
		});
		
		for(int i = 0; i < 9; i++) {
			add(lajout[i]);
			add(iajout[i]);
		}
		
		add(jb1);
	}
}
