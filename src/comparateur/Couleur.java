package comparateur;

public class Couleur extends Critere {
	public Couleur(Biere b) {
		super(b);
	}
	
	
//	Ordre alphabétique
	@Override
	public int compareTo(Critere arg0) {
		int i = 0;
		while(getB().getCouleur().codePointAt(i) 
				==  arg0.getB().getCouleur().codePointAt(i)) {
			i++;
		}
		return getB().getCouleur().codePointAt(i) - arg0.getB().getCouleur().codePointAt(i);
	}
}
