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

	public static Connection connect() {
		Connection con = null;
		try {
			String connectionString = "jdbc:sqlite:" + Config.getDbFile().getAbsolutePath();
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(connectionString);
			System.out.println("Connected to " + connectionString);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
