package view;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.ConnexionBDD;
import model.Critere;
import model.Pays;
import model.Selection;


public class CheckBoxRenderer  implements ListCellRenderer<Object> {
    private Map<String, JCheckBox> items = new HashMap<>();
    private int i = 0;
    
    public CheckBoxRenderer(String[] items) {
        for (String item : items) {
            JCheckBox box = new JCheckBox(item);
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

    public void setSelected(String item, ConnexionBDD c, Selection b) {
    	JCheckBox cb = items.get(item);
    	if (item.contains(item) && cb.isSelected()) {
            cb.setSelected(false);
        } else {
        	cb.setSelected(true);
        	Critere ct;
        	i++;
        	if(i > 1) {
        		b.orRequete();
        		ct = new Pays(b);
    			ct.requete();
        	} else {
        		b.andRequete();
        		b.parentheseOpen();
        		ct = new Pays(b);
    			ct.requete();
        	}    		
        }
    }
    
    public String[] getSelectedItems() {
    	ArrayList<String> ret = new ArrayList<>();
    	items.forEach((s,c) -> {if(c.isSelected()) ret.add(s);});
    	return ret.toArray(new String[0]);
    }
    
    public void resetSelectedItems() {
    	items.forEach((s,c) -> {if(c.isSelected()) c.setSelected(false);});
    	i = 0;
    }
}