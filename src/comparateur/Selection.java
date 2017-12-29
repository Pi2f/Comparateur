package comparateur;

import java.util.ArrayList;

public abstract class Selection {
	ArrayList<Biere> selection;
	ArrayList<Critere> criteres;
	
	public Selection() {
		selection = new ArrayList<>();
	}
	
	public void ajouter(Biere b) {
		if(selection.size() < 20) {
			selection.add(b);
		}
	}
	
	public void supprimer(Biere b) {
		if(selection.contains(b)) {
			selection.remove(b);
		}
	}
}
