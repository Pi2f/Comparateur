package model;

public class Selection {
		String s = "SELECT * FROM beer WHERE (1=1";
		
		public String getS() {
			return s;
		}
		
		public void setS(String s) {
			this.s = s;
		}
		
		public void andRequete() {
			setS(getS() + ") AND (");
		}
		
		public void finRequete() {
			setS(getS() + ")");
		}
		
		public void clearS() {
			s = "SELECT * FROM beer WHERE (1=1";
		}
}
