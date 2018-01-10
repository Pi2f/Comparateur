package comparateur;

import java.lang.reflect.InvocationTargetException;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Selection sel = new Selection();
		
//		Bières
		Biere b = new Biere("A","Blonde",6,12);
		Biere b1 = new Biere("B","Brune",3,15);
		Biere b2 = new Biere("C","Rousse",8,13);
		Biere b3 = new Biere("D","Verte",2,3);


//		Tableaux prenant en compte les différents critères
		sel.ajouter(b);
		sel.ajouter(b1);
		sel.ajouter(b2);
		sel.ajouter(b3);
		
		System.out.println("Tri Couleur");
		sel.tri("comparateur.Couleur");
		System.out.println(sel);
		
		System.out.println();
		System.out.println("Tri Style");
		sel.tri("comparateur.Style");
		System.out.println(sel);
		
		System.out.println();
		System.out.println("Tri Prix");
		sel.tri("comparateur.Prix");
		System.out.println(sel);
		
		System.out.println();
		System.out.println("Tri Degré");
		sel.tri("comparateur.DegreAlcool");
		System.out.println(sel);
		
		System.out.println();
		System.out.println("Tri Prix fourchette (5 et 10)");
		sel.fourchette(0, 13, "getPrix");
		System.out.println(sel);

	}

}
