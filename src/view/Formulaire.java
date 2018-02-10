package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import com.visutools.nav.bislider.BiSlider;

import model.ConnexionBDD;

public class Formulaire extends JPanel {
	
	JTextField jtf;
	BiSlider bs1;
	BiSlider bs2;
	JComboBox<String> jc1;
	JComboBox<String> jc2;
	JComboBox<String> jc3;
	JComboBox<String> jc4;
	
	JSlider js1;
	JSlider js2;
	
	public Formulaire() {
		
		ConnexionBDD c = new ConnexionBDD();
		GridLayout gl = new GridLayout(0,1,0,0);
		setLayout(gl);
		
		JLabel lbs1 = new JLabel("Prix");
		bs1 = new BiSlider(BiSlider.RGB);
		bs1.setVisible(true);
		double seg = 1;
		try {
			bs1.setMinimumValue(c.getPrixMin());
			bs1.setMaximumValue(c.getPrixMax());
			seg = (c.getPrixMax() - c.getPrixMin())/10;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bs1.setSegmentSize(seg);
		bs1.setUnit("€");
		bs1.setMinimumColor(Color.YELLOW);
		bs1.setMiddleColor(Color.ORANGE);
	    bs1.setMaximumColor(Color.RED);
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
		
		JLabel ljc1 = new JLabel("Pays");
		jc1 = null;
		try {
			jc1 = new JComboBox<String>(c.getPays());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel ljc2 = new JLabel("Marque");
		jc2 = null;
		try {
			jc2 = new JComboBox<String>(c.getMarque());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel ljtf = new JLabel("Nom");
		jtf = new JTextField();
		
		JLabel ljc3 = new JLabel("Couleur");
		jc3 = null;
		try {
			jc3 = new JComboBox<String>(c.getCouleur());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel ljc4 = new JLabel("Type de fermentation");
		jc4 = null;
		try {
			jc4 = new JComboBox<String>(c.getTypeFerm());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		JLabel ljs1= new JLabel("Douceur");
		js1 = new JSlider(JSlider.HORIZONTAL, 1, 5, 3);
	    js1.setPaintLabels(true);
	    js1.setLabelTable(js1.createStandardLabels(1));
		JLabel ljs2= new JLabel("Amertume");
		js2 = new JSlider(JSlider.HORIZONTAL, 1, 5, 3);
	    js2.setPaintLabels(true);
	    js2.setLabelTable(js1.createStandardLabels(1));
	    
	    try {
			c.terminer();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		
		add(ljc4);
		add(jc4);
		
		add(ljs1);
		add(js1);
		
		add(ljs2);
		add(js2);
	}

	public JTextField getJtf() {
		return jtf;
	}

	public BiSlider getBs1() {
		return bs1;
	}

	public BiSlider getBs2() {
		return bs2;
	}

	public JComboBox<String> getJc1() {
		return jc1;
	}

	public JComboBox<String> getJc2() {
		return jc2;
	}

	public JComboBox<String> getJc3() {
		return jc3;
	}
	
	public JComboBox<String> getJc4() {
		return jc4;
	}
	
	public JSlider getJs1() {
		return js1;
	}
	
	public JSlider getJs2() {
		return js2;
	}
	
	@Override
	public Insets insets() {
		return new Insets(30, 30, 30, 30);
	}
}
