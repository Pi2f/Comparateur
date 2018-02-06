package model;

public class Biere {
	
	String s = "SELECT * FROM beer WHERE ";
	
	public String getS() {
		return s;
	}
	
	public void setS(String s) {
		this.s = s;
	}
	
	public void addrequete() {
		setS(getS() + " && ");
	}
}
