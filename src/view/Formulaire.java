package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.visutools.nav.bislider.BiSlider;

public class Formulaire extends JPanel {
	
	JButton admin;
	JButton rech;
	
	public Formulaire() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JLabel lbs1 = new JLabel("Prix");
		BiSlider bs1 = new BiSlider();
		
		JLabel lbs2 = new JLabel("Degré");
		BiSlider bs2 = new BiSlider();
		
		JLabel ljc1 = new JLabel("Pays");
		JComboBox<String> jc1 = new JComboBox();
		
		JLabel ljc2 = new JLabel("Marque");
		JComboBox<String> jc2 = new JComboBox();
		
		JLabel ljtf = new JLabel("Nom");
		JTextField jtf = new JTextField();
		
		JLabel ljc3 = new JLabel("Couleur");
		JComboBox<String> jc3 = new JComboBox();
		
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
	}
	
	public void addListener(JPanel content, CardLayout cl, String listContent){
		admin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(content, listContent);
			}
		});
	}
}
