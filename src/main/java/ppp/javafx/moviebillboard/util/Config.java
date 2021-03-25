package ppp.javafx.moviebillboard.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;

/**
 * @author Ayoze Amaro
 *
 */
public class Config {

private static final String DB_NAME = "BillboardDB.db";
	
	private static File configDir = new File(System.getProperty("user.home"), ".TheMovieBillboard");
	private static File dbFile = new File(configDir, DB_NAME);

	public static File initDatabase() {
		try {
			System.out.println("initDatabase");
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
	
	public static File getDbFile() {
		return dbFile;
	}
	
	public static String getConfigDir() {
		return configDir.getAbsolutePath();
	}
}
