package model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class Selection {
	ArrayList<Biere> selection;
	
	public Selection() {
		selection = new ArrayList<>();
	}
	
	public ArrayList<Biere> getSelection() {
		return selection;
	}
	
	public void setSelection(ArrayList<Biere> selection) {
		this.selection = selection;
	}
	
	public void ajouter(Biere s) {
		if(selection.size() < 20 && !selection.contains(s)) {
			selection.add(s);
		}
	}
	
	public void supprimer(Selection s) {
		if(selection.contains(s)) {
			selection.remove(s);
		}
	}
	
	public void clearSelection() {
		selection.clear();
	}
	
	public void tri(String s) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> critere = Class.forName(s);
		Constructor<?> ccritere = critere.getDeclaredConstructor(Biere.class);
		
		ArrayList<Critere> s1 = new ArrayList<>();
		for (Biere b : selection) {
			Object o = ccritere.newInstance(b.getB());
			s1.add(((Critere) o));
		}
		clearSelection();
		s1.sort(null);
		
		for (Critere b : s1) {
			selection.add(b.getB());
		}
	}
	
	public void fourchette(double min, double max, String meth) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = model.Biere.class.getDeclaredMethod(meth, null);
		
		ArrayList<Biere> s1 = new ArrayList<>();
		for (Biere b : selection) {
			s1.add(b);
		}
		clearSelection();
		
		for (Biere b : s1) {
			double valeur = (double) m.invoke(b, null);
			if(valeur >= min && valeur <= max) {
				selection.add(b.getB());
			}
			else {
				selection.remove(b.getB());
			}
		}
	}
	
	@Override
	public String toString() {
		String s;
		s = "";
		for (Iterator<?> iterator = selection.iterator(); iterator.hasNext();) {
			Biere bi = (Biere) iterator.next();
			s += bi.getStyle() + "\t" + bi.getCouleur() + "\t" + bi.getDegre() + "\t" + bi.getPrix() + "\n";
		}
		return s;
	}
}
