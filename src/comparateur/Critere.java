package comparateur;

public abstract class Critere extends Selection implements Comparable<Critere>  {
	protected Biere b;
	
	public Critere(Biere b) {
		super();
		this.b = b;
	}
	
	public Biere getB() {
		return b;
	}
}
