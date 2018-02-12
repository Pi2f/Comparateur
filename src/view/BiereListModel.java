package view;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import model.Biere;


/**
 * @author FRANC Pierre, GIBASSIER Romain
 * @version 1.0
 * 
 * Redéfinition du modèle de la liste de Bière pour gérer un tableau
 */
public class BiereListModel implements ListModel<Biere> {
	ArrayList<Biere> alb;
	
	public BiereListModel(ArrayList<Biere> alb) {
		this.alb = alb;
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
	}

	@Override
	public Biere getElementAt(int arg0) {
		return alb.get(arg0);
	}

	@Override
	public int getSize() {
		return alb.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
	}
}
