package comparateur;

public abstract class Critere extends Selection {
	private Biere b;
	public Critere(Biere b) {
		this.b = b;
	}
}
