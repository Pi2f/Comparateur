package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ConnexionBDD;
import model.Biere;

/**
 * @author FRANC Pierre, GIBASSIER Romain
 * @version 1.0
 * 
 * Panneau qui permet la modification des bières de la BDD.
 */
@SuppressWarnings("serial")
public class Modifier extends JPanel {
	
	private JButton jb2;
	private JButton jb3;
	private JButton save;
	private JTextField[] in;
	private JComboBox<String> lmodifier;
	private ConnexionBDD c;
	private Biere b;
	
	public Modifier() {
		c = new ConnexionBDD();
		JLabel mo = new JLabel("Modifier ou supprimer une Bière");
		mo.setFont(new Font("Dialog",Font.BOLD,20));
		add(mo);
		
		lmodifier = new JComboBox<>();
		try {
			 lmodifier = new JComboBox<String>(c.getNom());
			 c.terminer();
			 lmodifier.setMaximumSize(new Dimension(500, 30));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		add(lmodifier);
		jb2 = new JButton("Modifier");
		jb2.setFont(new Font("Dialog",Font.BOLD,14));
		jb3 = new JButton("Supprimer");
		jb3.setFont(new Font("Dialog",Font.BOLD,14));
		
		add(jb2);
		add(jb3);
		
		save = new JButton("Enregistrer");
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					c = new ConnexionBDD();
					c.supprimer(b.getNom());
					c.ajouter(in[0].getText(),
							in[1].getText(),
							in[2].getText(),
							in[3].getText(),
							in[4].getText(),
							in[5].getText(),
							in[6].getText(),
							in[7].getText(),
							in[8].getText());
					c.terminer();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				for(int i = 0; i < 9; i++) {
					in[i].setText("");
				}
			}
			
		});
		
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c = new ConnexionBDD();
				jb3.setEnabled(false);
				b = null;
				JLabel[] jl = new JLabel[9];
				String[] s = {"Nom" ,"Marque","Pays","Prix","Degré","Couleur","Type de fermentation","Amertume","Douceur"};
				in = new JTextField[9];
				try {
					 b = c.getBiere((String) lmodifier.getSelectedItem());
					 c.terminer();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				for(int i = 0; i < 9; i++) {
					jl[i] = new JLabel(s[i]);
					jl[i].setFont(new Font("Dialog",Font.BOLD,14));
				}
				in[0] = new JTextField(b.getNom());
				in[1] = new JTextField(b.getMarque());
				in[2] = new JTextField(b.getPays());
				in[3] = new JTextField(String.valueOf(b.getPrix()));
				in[4] = new JTextField(String.valueOf(b.getDegre()));
				in[5] = new JTextField(b.getCouleur());
				in[6] = new JTextField(b.getTypFerm());
				in[7] = new JTextField(String.valueOf(b.getAmertume()));
				in[8] = new JTextField(String.valueOf(b.getDouceur()));
				
				for(int i = 0; i < 9; i++) {
					in[i].setMaximumSize(new Dimension(500, 30));
				}
				
				for(int i = 0; i < 9; i++) {
					add(jl[i]);
					add(in[i]);
				}
				save.setFont(new Font("Dialog",Font.BOLD,18));
				add(save);
				revalidate();
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c = new ConnexionBDD();
				try {
					c.supprimer((String) lmodifier.getSelectedItem());
					c.terminer();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				revalidate();
			}
		});
	}
}
