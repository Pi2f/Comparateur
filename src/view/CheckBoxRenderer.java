package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Critere;
import model.Requete;

/**
 * @author FRANC Pierre, GIBASSIER Romain
 * @version 1.0
 * 
 * Red�finition du rendu d'un �l�ment d'une liste JComboBox sous forme de case � cocher
 */
public class CheckBoxRenderer  implements ListCellRenderer<Object> {
    private Map<String, JCheckBox> items = new HashMap<>();
    private int i = 0;
    
    public CheckBoxRenderer(String[] items) {
        for (String item : items) {
            JCheckBox box = new JCheckBox(item);
            box.setFont(new Font("Dialog",Font.PLAIN,14));
            box.setBackground(new Color(255, 182, 184));
            box.setOpaque(true);
            this.items.put(item, box);
        }
    }
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {
        if (items.containsKey(value)) {
            return (Component) items.get(value);
        } else {
            return null;
        }
    }
    
    
    /**
     * Possibilit� de s�lectionner plusieurs �l�ments d'un crit�re de s�lection
     * @param item �l�ment courant de la liste
     * @param b s�lection � modifier
     * @param ct Type de crit�re de s�lection
     */
    public void setSelected(String item,Requete b, Critere ct) {
    	JCheckBox cb = items.get(item);
    	if (item.contains(item) && cb.isSelected()) {
            cb.setSelected(false);
        } else {
        	cb.setSelected(true);
        	i++;
        	if(i > 1) {
        		ct.requete(true);
        	} else {
        		b.andRequete();
        		ct.requete(false);
        	}
        }
    }
    
    
    /**
     * @return les multiples s�lections du crit�re
     */
    public String[] getSelectedItems() {
    	ArrayList<String> ret = new ArrayList<>();
    	items.forEach((s,c) -> {if(c.isSelected()) ret.add(s);});
    	return ret.toArray(new String[0]);
    }
    
    /**
     * R�initialise les �l�ments s�lectionn�s 
     */
    public void resetSelectedItems() {
    	items.forEach((s,c) -> {if(c.isSelected()) c.setSelected(false);});
    	i = 0;
    }
}