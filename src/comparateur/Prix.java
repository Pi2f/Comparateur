package comparateur;

public class Prix extends Critere {
	
	public Prix(Biere b) {
		super(b);
	}

	@Override
	public int compareTo(Critere arg0) {
		return (int) (this.getB().getPrix() - ((Prix) arg0).getB().getPrix());
	}
	
	public boolean fourchette(double min, double max) {
		double prix = getB().getPrix();
		return prix >= min && prix <= max;
	}

}
