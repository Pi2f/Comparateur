package model;

public class Style extends Critere {

	public Style(Biere b) {
		super(b);
	}

//	Ordre alphabétique
	@Override
	public int compareTo(Critere arg0) {
		int i = 0;
		while(i < getB().getStyle().length()-1 && 
				getB().getStyle().codePointAt(i) ==  arg0.getB().getStyle().codePointAt(i)) {
			i++;
		}
		return getB().getStyle().codePointAt(i) - arg0.getB().getStyle().codePointAt(i);
	}
}
