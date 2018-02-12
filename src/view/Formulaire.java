package view;

import java.awt.Color;
import java.awt.Font;
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

/**
 * @author FRANC Pierre, GIBASSIER Romain
 * @version 1.0
 *
 *	Panneau comportant le formulaire de sélection des critères
 */
@SuppressWarnings("serial")
public class Formulaire extends JPanel {
	
	private JTextField jtf;
	private BiSlider bs1;
	private BiSlider bs2;
	private JComboBox<String> jc1;
	private JComboBox<String> jc2;
	private JComboBox<String> jc3;
	private JComboBox<String> jc4;
	
	private JSlider js1;
	private JSlider js2;
	
	private CheckBoxRenderer cbr, cbr1, cbr2, cbr3;
	
	public Formulaire() {
		
		ConnexionBDD c = new ConnexionBDD();
		GridLayout gl = new GridLayout(0,1,0,0);
		setLayout(gl);
		
		setBackground(new Color(255, 182, 184));
		
		JLabel lbs1 = new JLabel("Prix");
		lbs1.setFont(new Font("Dialog",Font.BOLD,18));
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
		lbs2.setFont(new Font("Dialog",Font.BOLD,18));
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
		ljc1.setFont(new Font("Dialog",Font.BOLD,18));
		jc1 = null;
		try {
			jc1 = new JComboBox<String>(c.getPays());
			jc1.setBackground(new Color(255, 182, 184));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel ljc2 = new JLabel("Marque");
		ljc2.setFont(new Font("Dialog",Font.BOLD,18));
		jc2 = null;
		try {
			jc2 = new JComboBox<String>(c.getMarque());
			jc2.setBackground(new Color(255, 182, 184));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel ljtf = new JLabel("Nom");
		ljtf.setFont(new Font("Dialog",Font.BOLD,18));
		jtf = new JTextField();
		
		JLabel ljc3 = new JLabel("Couleur");
		ljc3.setFont(new Font("Dialog",Font.BOLD,18));
		jc3 = null;
		try {
			jc3 = new JComboBox<String>(c.getCouleur());
			jc3.setBackground(new Color(255, 182, 184));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel ljc4 = new JLabel("Type de fermentation");
		ljc4.setFont(new Font("Dialog",Font.BOLD,18));
		jc4 = null;
		try {
			jc4 = new JComboBox<String>(c.getTypeFerm());
			jc4.setBackground(new Color(255, 182, 184));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel ljs1= new JLabel("Douceur");
		ljs1.setFont(new Font("Dialog",Font.BOLD,18));
		js1 = new JSlider(JSlider.HORIZONTAL, 1, 5, 3);
	    js1.setPaintLabels(true);
	    js1.setLabelTable(js1.createStandardLabels(1));
	    js1.setBackground(new Color(255, 182, 184));
	    
		JLabel ljs2= new JLabel("Amertume");
		ljs2.setFont(new Font("Dialog",Font.BOLD,18));
		js2 = new JSlider(JSlider.HORIZONTAL, 1, 5, 3);
	    js2.setPaintLabels(true);
	    js2.setLabelTable(js1.createStandardLabels(1));
	    js2.setBackground(new Color(255, 182, 184));
	    
	    try {
	    	cbr = new CheckBoxRenderer(c.getPays());
			jc1.setRenderer(cbr);
			cbr1 = new CheckBoxRenderer(c.getMarque());
			jc2.setRenderer(cbr1);
			cbr2 = new CheckBoxRenderer(c.getCouleur());
			jc3.setRenderer(cbr2);
			cbr3 = new CheckBoxRenderer(c.getTypeFerm());
			jc4.setRenderer(cbr3);
			c.terminer();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
		add(lbs1);
		add(bs1);
		
		add(lbs2);
		add(bs2);
		
		add(ljs1);
		add(js1);
		
		add(ljs2);
		add(js2);
		
		add(ljtf);
		add(jtf);
		
		add(ljc1);
		add(jc1);
		
		add(ljc2);
		add(jc2);
		
		add(ljc3);
		add(jc3);
		
		add(ljc4);
		add(jc4);
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

	public CheckBoxRenderer getCbr() {
		return cbr;
	}
	
	public CheckBoxRenderer getCbr1() {
		return cbr1;
	}
	
	public CheckBoxRenderer getCbr2() {
		return cbr2;
	}
	
	public CheckBoxRenderer getCbr3() {
		return cbr3;
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
	
	
	/**
	 * Réinitialise les champs du formulaire
	 */
	public void resetForm() {
		cbr.resetSelectedItems();
		jc1.setSelectedIndex(0);
		cbr1.resetSelectedItems();
		jc2.setSelectedIndex(0);
		cbr2.resetSelectedItems();
		jc3.setSelectedIndex(0);
		cbr3.resetSelectedItems();
		jc4.setSelectedIndex(0);
		jtf.setText("");
	}
	
	@Override
	public Insets insets() {
		return new Insets(30, 30, 30, 30);
	}
}
