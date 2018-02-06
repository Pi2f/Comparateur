package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.visutools.nav.bislider.BiSlider;
import com.visutools.nav.bislider.BiSliderEvent;
import com.visutools.nav.bislider.BiSliderListener;

import model.Biere;
import model.ConnexionBDD;
import model.Couleur;
import model.Critere;
import model.DegreAlcool;
import model.Marque;
import model.Nom;
import model.Pays;
import model.Prix;
import model.Selection;

public class Formulaire extends JPanel {
	
	JTextField jtf;
	BiSlider bs1;
	BiSlider bs2;
	JComboBox<String> jc1;
	JComboBox<String> jc2;
	JComboBox<String> jc3;
	JButton admin;
	JButton rech;
	ConnexionBDD c;
	Selection b;
	
	public Formulaire() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		c = new ConnexionBDD();
		
		JLabel lbs1 = new JLabel("Prix");
		bs1 = new BiSlider(BiSlider.RGB);
		bs1.setVisible(true);
		double seg = 1;
		try {
			bs1.setMinimumValue(c.getPrixMin());
			bs1.setMaximumValue(c.getPrixMax());
			seg = (c.getDegreMax() - c.getDegreMin())/10;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bs1.setSegmentSize(0.1);
		bs1.setUnit("€");
		bs1.setMinimumColor(Color.YELLOW);
		bs1.setMiddleColor(Color.ORANGE);
	    bs1.setMaximumColor(Color.RED);
		bs1.setMaximumSize(new Dimension(250, 30));
		bs1.setPrecise(true);
		
		JLabel lbs2 = new JLabel("Degré");
		bs2 = new BiSlider(BiSlider.RGB);
		try {
			bs2.setMinimumValue(c.getDegreMin());
			bs2.setMaximumValue(c.getDegreMax());
			seg = (c.getDegreMax()-c.getDegreMin())/10;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bs2.setSegmentSize(seg);
		bs2.setUnit("°");
		bs2.setMinimumColor(Color.YELLOW);
		bs2.setMiddleColor(Color.ORANGE);
	    bs2.setMaximumColor(Color.RED);
		bs2.setMaximumSize(new Dimension(250, 30));
		
		JLabel ljc1 = new JLabel("Pays");
		jc1 = null;
		try {
			jc1 = new JComboBox<String>(c.getPays());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		jc1.setMaximumSize(new Dimension(250, 25));
		
		JLabel ljc2 = new JLabel("Marque");
		jc2 = null;
		try {
			jc2 = new JComboBox<String>(c.getMarque());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		jc2.setMaximumSize(new Dimension(250, 25));
		
		JLabel ljtf = new JLabel("Nom");
		jtf = new JTextField();
		jtf.setMaximumSize(new Dimension(250, 25));
		
		JLabel ljc3 = new JLabel("Couleur");
		jc3 = null;
		try {
			jc3 = new JComboBox<String>(c.getCouleur());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		jc3.setMaximumSize(new Dimension(250, 25));
		
		rech = new JButton("Recherche");
		admin = new JButton("Administrateur");
		
		add(lbs1);
		add(bs1);
		
		add(lbs2);
		add(bs2);
		
		add(ljc1);
		add(jc1);
		
		add(ljc2);
		add(jc2);
		
		add(ljtf);
		add(jtf);
		
		add(ljc3);
		add(jc3);
		
		add(rech);
		add(admin);
		
		b = new Selection();
	}
	
	public void addListener(JPanel content, CardLayout cl, String listContent){
		admin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(content, listContent);
			}
		});
	}
	
	public void addListener2(JPanel content, CardLayout cl, String listContent){
		rech.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Critere ct = new Prix(b);
				ct.requete();
				b.addrequete();
				
				ct = new DegreAlcool(b);
				ct.requete();
				
				if(jc1.getSelectedIndex() != 0) {
					b.addrequete();
					ct = new Marque(b);
					ct.requete();
				}
				
				if(jc2.getSelectedIndex() != 0) {
					b.addrequete();
					ct = new Pays(b);
					ct.requete();
				}
				
				if(jc3.getSelectedIndex() != 0) {
					b.addrequete();
					ct = new Couleur(b);
					ct.requete();
				}
				
				if(jtf.getText() != "") {
					b.addrequete();
					ct = new Nom(b);
					ct.requete();
				}
				
				try {
					c.lister(b.getS(),
							bs1.getMinimumColoredValue(),
							bs1.getMaximumColoredValue(),
							bs2.getMinimumColoredValue(),
							bs2.getMaximumColoredValue(),
							(String) jc1.getSelectedItem(),
							(String) jc2.getSelectedItem(),
							(String) jc3.getSelectedItem(),
							jtf.getText()
							);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				b.clearS();
				cl.show(content, listContent);
			}
		});
	}
}
