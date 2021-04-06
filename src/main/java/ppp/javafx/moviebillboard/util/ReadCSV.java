package ppp.javafx.moviebillboard.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author Ayoze Amaro
 * @version 06/04/2021
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard" /> TheMovieBillboard Github </a>
 */
public class ReadCSV {

	public static void readUsersFile(ArrayList<String> linesCSV) {
		try {
		    File file = new File ("src/main/resources/database/users.csv");
		    FileReader readFile = new FileReader(file, Charset.forName("UTF-8"));
		    BufferedReader usersRead = new BufferedReader(readFile);
		    String lines;
		    
		    while ((lines = usersRead.readLine()) != null) {
		    	linesCSV.add(lines);
		    }
		    usersRead.close();
		}
		catch (IOException error) { 
			error.printStackTrace();
		}
	}
	
	public static void wrongCredentials() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Credenciales erróneas");
		alert.setHeaderText(null);
		alert.setContentText("Ooops, tenemos un problema! \n" + "Credenciales erróneas. Por favor, vuelva a intentarlo");
		
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("/images/icon.png"));
		
		alert.showAndWait();
	}
}
