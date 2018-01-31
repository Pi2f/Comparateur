package model;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException {

		ConnexionBDD c = new ConnexionBDD();
		
		Selection sel = new Selection();
		
		c.supprimer("Lindemans faro");
		sel.setSelection(c.lister());
		c.terminer();
		
		System.out.println("Tri Couleur");
		sel.tri("model.Couleur");
		System.out.println(sel);
		
		System.out.println();
		System.out.println("Tri Style");
		sel.tri("model.Style");
		System.out.println(sel);
		
		System.out.println();
		System.out.println("Tri Prix");
		sel.tri("model.Prix");
		System.out.println(sel);
		
		System.out.println();
		System.out.println("Tri Degré");
		sel.tri("model.DegreAlcool");
		System.out.println(sel);
		
		System.out.println();
		System.out.println("Tri Prix fourchette (5 et 10)");
		sel.fourchette(0, 13, "getPrix");
		System.out.println(sel);

	}

}
