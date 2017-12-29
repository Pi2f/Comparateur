package comparateur;

import java.util.ArrayList;
import java.util.Iterator;


public class Main {

	public static void main(String[] args) {

//		Bières
		ArrayList<Biere> tabBiere = new ArrayList<>();
		Biere b = new Biere("A","Blonde",6,12);
		Biere b1 = new Biere("B","Brune",3,15);
		Biere b2 = new Biere("C","Rousse",8,6);


//		Tableaux prenant en compte les différents critères
		ArrayList<Prix> p = new ArrayList<>();
		p.add(new Prix(b));
		p.add(new Prix(b1));
		p.add(new Prix(b2));

		ArrayList<DegreAlcool> d = new ArrayList<>();
		d.add(new DegreAlcool(b));
		d.add(new DegreAlcool(b1));
		d.add(new DegreAlcool(b2));

		ArrayList<Couleur> c = new ArrayList<>();
		c.add(new Couleur(b));
		c.add(new Couleur(b1));
		c.add(new Couleur(b2));

		ArrayList<Style> s = new ArrayList<>();
		s.add(new Style(b));
		s.add(new Style(b1));
		s.add(new Style(b2));

		tabBiere.add(b);
		tabBiere.add(b1);
		tabBiere.add(b2);

		p.sort(null);
		c.sort(null);

		System.out.println();
		System.out.println("Trier par Prix");
		for (Iterator<Prix> iterator = p.iterator(); iterator.hasNext();) {
			Prix prix = (Prix) iterator.next();
			System.out.print(prix.getB().getPrix());
			System.out.print("\t" + prix.getB().getStyle());
			System.out.print("\t" + prix.getB().getCouleur());
			System.out.print("\t" + prix.getB().getDegre()+"\n");
//			System.out.println(prix.fourchette(10, 15));
		}

		System.out.println();
		System.out.println("Trier par degré");
		for (Iterator<DegreAlcool> iterator = d.iterator(); iterator.hasNext();) {
			DegreAlcool degre = (DegreAlcool) iterator.next();
			System.out.print(degre.getB().getDegre());
			System.out.print("\t" + degre.getB().getStyle());
			System.out.print("\t" + degre.getB().getCouleur());
			System.out.print("\t" + degre.getB().getPrix()+"\n");
//			System.out.println(degre.fourchette(10, 15));
		}

		System.out.println();
		System.out.println("Trier par Couleur");
		for (Iterator<Couleur> iterator = c.iterator(); iterator.hasNext();) {
			Couleur couleur = (Couleur) iterator.next();
			System.out.print(couleur.getB().getCouleur());
			System.out.print("\t" + couleur.getB().getStyle());
			System.out.print("\t" + couleur.getB().getDegre());
			System.out.print("\t" + couleur.getB().getPrix()+"\n");
		}

		System.out.println();
		System.out.println("Trier par Style");
		for (Iterator<Style> iterator = s.iterator(); iterator.hasNext();) {
			Style style = (Style) iterator.next();
			System.out.print(style.getB().getStyle());
			System.out.print("\t" + style.getB().getCouleur());
			System.out.print("\t" + style.getB().getDegre());
			System.out.print("\t" + style.getB().getPrix()+"\n");
		}



	}

}
