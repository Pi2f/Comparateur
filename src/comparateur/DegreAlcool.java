package comparateur;

public class DegreAlcool extends Critere {
	
	public DegreAlcool(Biere b) {
		super(b);
	}

	@Override
	public int compareTo(Critere arg0) {
		return (int) (getB().getDegre() - arg0.getB().getDegre());
	}
	
	public boolean fourchette(double min, double max) {
		double deg = getB().getDegre();
		return deg >= min && deg <= max;
	}

}
