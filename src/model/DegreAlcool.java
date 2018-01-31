package model;

public class DegreAlcool extends Critere {
	
	public DegreAlcool(Biere b) {
		super(b);
	}

	@Override
	public int compareTo(Critere arg0) {
		return (int) (getB().getDegre() - arg0.getB().getDegre());
	}
	
	public void fourchette(Selection s, double min, double max) {
		double deg = getB().getDegre();
		if(deg >= min && deg <= max) {
			s.ajouter(getB());
		} else {
			s.supprimer(getB());
		}
	}

}
