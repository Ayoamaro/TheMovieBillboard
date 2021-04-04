package ppp.javafx.moviebillboard.util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Ayoze Amaro
 *
 */
public class MenuFunctions {

	public static void exitAplication(Event event, BorderPane view) {
		Stage stage = (Stage)view.getScene().getWindow();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Salir");
    	alert.setHeaderText(null);
    	alert.setContentText("¿Seguro que desea salir de la aplicación?");
    	alert.initModality(Modality.APPLICATION_MODAL);
    	alert.initOwner(stage);
		
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if(result.get()==ButtonType.OK) {
    		stage.close();
    	} else {
    		event.consume();
    	}	
	}
	
	public static void openGitHub(Event event) {
		try {
			Desktop.getDesktop().browse(new URI("https://github.com/Ayoamaro"));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}	
	}
	
	public static void openLinkedIn(Event event) {
		try {
			Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/ayoamaro/"));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
