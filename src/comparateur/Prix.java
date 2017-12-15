package comparateur;

public class Prix extends Critere {

	private int prix;
	
	public Prix(Biere b, int p) {
		super(b);
		prix = p;
	}
	
	@Override
	public void requete() {
		
	}
}
