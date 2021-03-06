package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JSlider;

import com.visutools.nav.bislider.BiSlider;

import model.Biere;
import model.Requete;
import model.Score;

public class ConnexionBDD {
	private Connection conn;
	private Requete s;
	
	public ConnexionBDD() {
		String connectionURL = "jdbc:mysql://localhost:3306/comparateur";
        try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Connexion � la base de donn�es...");
	        conn = DriverManager.getConnection(connectionURL, "root",
	                "comparator");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		return conn;
	}
	
	public void createRequete() {
		s = new Requete();
	}
	
	public Requete getRequete() {
		return s;
	}
	
	public Score getScore(BiSlider bs1, BiSlider bs2, JSlider s1, JSlider s2) {
		return new Score(bs1,bs2,s1,s2);
	}
	
	public boolean getAuth(String login, char[] mdp) throws SQLException {
		PreparedStatement statement =  conn.prepareStatement("SELECT password FROM authentification WHERE login ='"+login+"'");
        ResultSet resultat = statement.executeQuery();
        if(resultat.next()){
        	String motDePasse = resultat.getString(1);
            if(motDePasse.equals(new String(mdp))) {
                return true; 
            } else {
                return false;
            }
        } else {
        	return false;
        }
        
	}
	
	public void ajouter(String nom, String marque, String pays,
			String prix, String degre, String couleur, String typeferm,
			String amertume, String douceur) throws SQLException {
            PreparedStatement statement = conn.prepareStatement(
            		"INSERT INTO beer (nom,marque,pays,prix,degre,couleur,typeferm,amertume,douceur) "
            		+ "VALUES(?,?,?,?,?,?,?,?,?)");
            statement.setString(1,nom);
            statement.setString(2,marque);
            statement.setString(3,pays);             
            statement.setDouble(4,Double.parseDouble(prix));
            statement.setDouble(5,Double.parseDouble(degre));
            statement.setString(6,couleur);
            statement.setString(7,typeferm);
            statement.setInt(8,Integer.parseInt(amertume));
            statement.setInt(9,Integer.parseInt(douceur));
              
            statement.executeUpdate();
            statement.close();
		}
	
		public void supprimer(String nom) throws SQLException {
			PreparedStatement statement = conn.prepareStatement(
            		"DELETE FROM beer WHERE Nom =?");
            statement.setString(1,nom);
            statement.executeUpdate();
            statement.close();
		}
		
		public Biere getBiere(String nom) throws SQLException {
			PreparedStatement s = conn.prepareStatement(
            		"SELECT * FROM beer WHERE Nom =?");
			s.setString(1, nom);
			ResultSet res = s.executeQuery();
			res.next();
			Biere b = new Biere(
					res.getString(2),
	        		res.getString(3),
	        		res.getString(4),
	        		res.getDouble(5),
	        		res.getDouble(6),
	        		res.getString(7),
	        		res.getString(8),
	        		res.getInt(9),
	        		res.getInt(10));
			return b;
		}
	
		public ArrayList<Biere> lister(String requete, String[] pays, String[] marque,
				String nom, String[] couleur, String[] typeferm, Score sc) throws SQLException {
			PreparedStatement st = conn.prepareStatement(requete);
			int i = 0;
			
			i = addCond(pays, st, i);
			i = addCond(marque, st, i);
			if(!nom.equals("%")) {
				i++;
				st.setString(i, nom);
			}
			i = addCond(couleur, st, i);
			i = addCond(typeferm, st, i);
			
			
			System.out.println(st);
			ResultSet res = st.executeQuery();
			ArrayList<Biere> lb = new ArrayList<>();
			int j = 0;
			while(res.next() && j < 10){
				j++;
				Biere bi = new Biere(
						res.getString(2),
		        		res.getString(3),
		        		res.getString(4),
		        		res.getDouble(5),
		        		res.getDouble(6),
		        		res.getString(7),
		        		res.getString(8),
		        		res.getInt(9),
		        		res.getInt(10));
				bi.setScore(sc.getScore(bi));
				lb.add(bi);
		    }
			
			lb.sort(null);
			st.close();
			return lb;
		}
		
		private int addCond(String[] s, PreparedStatement st, int i) {
			if(s.length != 0) {
				for(String s1 : s) {
					i++;
					try {
						st.setString(i, s1);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return i;
		}
		
		public Double getPrixMax() throws SQLException {
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery("SELECT MAX(Prix) FROM beer");
            s.close();
            res.next();
            return res.getDouble(1);
		}
		
		public Double getPrixMin() throws SQLException {
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery("SELECT MIN(Prix) FROM beer");
            s.close();
            res.next();
            return res.getDouble(1);
		}
		
		public Double getDegreMax() throws SQLException {
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery("SELECT MAX(Degre) FROM beer");
            s.close();
            res.next();
            return res.getDouble(1);
		}
		
		public Double getDegreMin() throws SQLException {
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery("SELECT MIN(Degre) FROM beer");
            s.close();
            res.next();
            return res.getDouble(1);
		}
		
		public String[] getPays() throws SQLException {
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery("SELECT COUNT(DISTINCT(Pays)) FROM beer");
			res.next();
			String[] ret = new String[res.getInt(1)+1];
			
			res = s.executeQuery("SELECT DISTINCT(Pays) FROM beer");
			
			ret[0]="";
			int i = 1;
			while(res.next()) {
				ret[i] = res.getString(1);
				i++;
			}
			s.close();
			return ret;
		}
		
		
		public String[] getNom() throws SQLException {
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery("SELECT COUNT(Nom) FROM beer");
			res.next();
			String[] ret = new String[res.getInt(1)+1];
			
			res = s.executeQuery("SELECT Nom FROM beer");
			
			ret[0]="";
			int i = 1;
			while(res.next()) {
				ret[i] = res.getString(1);
				i++;
			}
			s.close();
			return ret;
		}
		
		public String[] getMarque() throws SQLException {
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery("SELECT COUNT(DISTINCT(Marque)) FROM beer");
			res.next();
			String[] ret = new String[res.getInt(1)+1];
			
			res = s.executeQuery("SELECT DISTINCT(Marque) FROM beer");
			ret[0]="";
			int i = 1;
			while(res.next()) {
				ret[i] = res.getString(1);
				i++;
			}
			s.close();
			return ret;
		}
		
		public String[] getCouleur() throws SQLException {
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery("SELECT COUNT(DISTINCT(Couleur)) FROM beer");
			res.next();
			String[] ret = new String[res.getInt(1)+1];
			
			res = s.executeQuery("SELECT DISTINCT(Couleur) FROM beer");
			ret[0]="";
			int i = 1;
			while(res.next()) {
				ret[i] = res.getString(1);
				i++;
			}
			s.close();
			return ret;
		}
		
		public String[] getTypeFerm() throws SQLException {
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery("SELECT COUNT(DISTINCT(TypeFerm)) FROM beer");
			res.next();
			String[] ret = new String[res.getInt(1)+1];
			
			res = s.executeQuery("SELECT DISTINCT(TypeFerm) FROM beer");
			ret[0]="";
			int i = 1;
			while(res.next()) {
				ret[i] = res.getString(1);
				i++;
			}
			s.close();
			return ret;
		}
		
		public void terminer() throws SQLException {
			System.out.println("D�connexion de la base de donn�es.");
			conn.close();
		}
}
