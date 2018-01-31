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
	
		public ArrayList<Biere> lister() throws SQLException {
			ArrayList<Biere> list = new ArrayList();
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM beer");
			ResultSetMetaData resm = res.getMetaData();
			
			while(res.next()){
				list.add(new Biere(
						res.getString(2),
		        		res.getString(7), 
		        		res.getDouble(6), 
		        		res.getDouble(5)));
		    }
			s.close();
			return list;
		}
		
		public void terminer() throws SQLException {
			conn.close();
		}
}
