package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class ConnexionBDD {
	Connection conn;
	
	public ConnexionBDD() {
		String connectionURL = "jdbc:mysql://localhost:3306/comparateur";
        try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Connexion à la base de données...");
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
	
	public void ajouter(String nom, String marque, String pays,
			String prix, String degre, String couleur, String typeferm,
			String douceur, String amertume) throws SQLException {
            PreparedStatement statement = conn.prepareStatement(
            		"INSERT INTO beer (nom,marque,pays,prix,degre,couleur,typeferm) "
            		+ "VALUES(?,?,?,?,?,?,?)");
            statement.setString(1,nom);
            statement.setString(2,marque);
            statement.setString(3,pays);             
            statement.setDouble(4,Double.parseDouble(prix));
            statement.setDouble(5,Double.parseDouble(degre));
            statement.setString(6,couleur);
            statement.setString(7,typeferm);
            statement.setInt(8,Integer.parseInt(douceur));
            statement.setInt(9,Integer.parseInt(amertume));
              
            statement.executeUpdate();
            statement.close();
		}
	
		public void supprimer(String nom) throws SQLException {
			PreparedStatement statement = conn.prepareStatement(
            		"DELETE FROM beer WHERE nom=?");
            statement.setString(1,nom);
            statement.executeUpdate();
            statement.close();
		}
	
		public ArrayList<Biere> lister(String s, String e, String f,
				String g, String h, String j, Score sc) throws SQLException {
			PreparedStatement st = conn.prepareStatement(s);
			
			int i = 0;
				
			if(e != "") {
				i++;
				st.setString(i, e);
			}
			if(f != "") {
				i++;
				st.setString(i, f);
			}
			if(g != "") {
				i++;
				st.setString(i, g);
			}
			if(h != "") {
				i++;
				st.setString(i, h);
			}
			
			ResultSet res = st.executeQuery();
			
			ArrayList<Biere> lb = new ArrayList();
			while(res.next()){
				Biere bi = new Biere(
						res.getDouble(5),
		        		res.getDouble(6),
		        		res.getString(2),
		        		res.getString(3),
		        		res.getString(4),
		        		res.getString(7),
		        		res.getString(8),
		        		res.getInt(9),
		        		res.getInt(10));
				
				
				bi.setScore(sc.calculScore2(bi));
				
				lb.add(bi);
		    }
			
			lb.sort(null);
			st.close();
			return lb;
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
			System.out.println("Déconnexion de la base de données.");
			conn.close();
		}
}
