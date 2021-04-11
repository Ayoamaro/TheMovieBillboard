package ppp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ppp.javafx.moviebillboard.util.Config;

/**
 * @author Ayoze Amaro
 * @version 1.0
 * @since 2021-06-04 (YYYY/DD/MM)
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard"> TheMovieBillboard Github </a>
 */
public class DBConnection {

	private Connection con;	// Connection with database
	private static String nom = Config.getDbFile().getAbsolutePath();	// String nom
	private static String url = "jdbc:sqlite:";	// String url

	/**
     * @return con - (Connection)
     */
	public Connection getCon() {
		return con;
	}
	
	/**
     * Set new connection
     * @param con - (Connection)
     */
	public void setCon(Connection con) {
		this.con = con;
	}
	
	/**
     * Establish a new connection with database
     */
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
	
	/**
     * Finish a connection with database
     */
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
