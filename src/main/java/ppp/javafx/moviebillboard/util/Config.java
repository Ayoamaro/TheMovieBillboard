package ppp.javafx.moviebillboard.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;

/**
 * @author Ayoze Amaro
 * @version 1.0
 * @since 2021-06-04 (YYYY/DD/MM)
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard"> TheMovieBillboard Github </a>
 */
public class Config {

	private static final String DB_NAME = "BillboardDB.db";	// String DB_NAME
	private static File configDir = new File(System.getProperty("user.home"), ".TheMovieBillboard");	// File configDir
	private static File dbFile = new File(configDir, DB_NAME);	// File dbFile

	/**
	 * Initialization of Database File 
	 * @return dbFile - Database file at resources
	 */
	public static File initDatabase() {
		try {
			if (!dbFile.exists()) { 
				if (!configDir.exists()) {
					configDir.mkdir();
				}
				InputStream is = Config.class.getResourceAsStream("/database/" + DB_NAME);
				FileUtils.copyInputStreamToFile(is, dbFile);
			}
			return dbFile;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns database name file
	 * @return dbFile - (File)
	 */
	public static File getDbFile() {
		return dbFile;
	}
	
	/**
	 * Returns the directory path
	 * @return configDir - (String)
	 */
	public static String getConfigDir() {
		return configDir.getAbsolutePath();
	}
}
