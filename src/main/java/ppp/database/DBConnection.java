package ppp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ppp.javafx.moviebillboard.util.Config;

/**
 * This class is used to connect the data base
 * 
 * @author Melania, Alexis, Ayoze & Aarón
 * @version 01/02/2021
 * @see <a href = "https://github.com/dam-dad/OwnComputerTPV" /> OwnComputer
 *      Github </a>
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
