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
			System.out.println("connecting to psysical database...");
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
	
	public void ajouter() throws SQLException {
            PreparedStatement statement = conn.prepareStatement(
            		"INSERT INTO beer (nom,marque,pays,prix,degre,couleur,typeferm) "
            		+ "VALUES(?,?,?,?,?,?,?)");
            System.out.println("Connection has been made");
            
            Scanner keyBoardScanner = new Scanner(System.in);
              
            System.out.println("Nom :");
            statement.setString(1,keyBoardScanner.nextLine());
            System.out.println("Marque :");
            statement.setString(2,keyBoardScanner.nextLine());
            System.out.println("Pays :");
            statement.setString(3,keyBoardScanner.nextLine());
              
            System.out.println("Prix :");
            statement.setFloat(4,Float.parseFloat(keyBoardScanner.nextLine()));
            System.out.println("Degré :");
            statement.setFloat(5,Float.parseFloat(keyBoardScanner.nextLine()));
            
            System.out.println("Couleur :");
            statement.setString(6,keyBoardScanner.nextLine());
            System.out.println("TypeFerm :");
            statement.setString(7,keyBoardScanner.nextLine());
              
            System.out.println("Inserting data into beertable ...");
              
            statement.executeUpdate();
            keyBoardScanner.close();
            statement.close();
		}
	
		public void supprimer(String nom) throws SQLException {
			PreparedStatement statement = conn.prepareStatement(
            		"DELETE FROM beer WHERE nom=?");
            statement.setString(1,nom);
            statement.executeUpdate();
            statement.close();
		}
	
		public void lister(String s,double a, double b, double c, double d,
				String e, String f, String g, String h) throws SQLException {
			PreparedStatement st = conn.prepareStatement(s);
			st.setDouble(1, a);
			st.setDouble(2, b);
			st.setDouble(3, c);
			st.setDouble(4, d);
			st.setString(5, e);
			st.setString(6, f);
			st.setString(7, g);
			st.setString(8, h);
			
			System.out.println(st);
			
			
			ResultSet res = st.executeQuery();
			
			while(res.next()){
				System.out.println(
						res.getString(2) + "\t" +
		        		res.getString(7) + "\t" +
		        		res.getDouble(6) + "\t" +
		        		res.getDouble(5));
		    }
			st.close();
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
		
		public void terminer() throws SQLException {
			conn.close();
		}
}
