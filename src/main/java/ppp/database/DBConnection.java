package ppp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ppp.javafx.moviebillboard.util.Config;

/**
 * @author Ayoze Amaro
 *
 */
public class DBConnection {

	private Connection con;
	private static String nom = Config.getDbFile().getAbsolutePath();
	private static String url = "jdbc:sqlite:";

	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public void establishConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(url + nom);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
