package ppp.javafx.moviebillboard.util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javafx.beans.property.ListProperty;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import ppp.javafx.moviebillboard.model.Movie;

/**
 * @author Ayoze Amaro
 * @version 1.0
 * @since 2021-06-04 (YYYY/DD/MM)
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard"> TheMovieBillboard Github </a>
 */
public class MenuFunctions {
	
	/**
	 * Activate buttons method
	 * @param createBTN - (Button) Create new movie
	 * @param editBTN - (Button) Update existing movie
	 * @param deleteBTN - (Button) Delete existing movie
	 * @param detailsBTN - (Button) Information about a movie
	 */
	public static void activateButtons(Button createBTN, Button editBTN, Button deleteBTN, Button detailsBTN) {
		createBTN.setDisable(false);
		editBTN.setDisable(false);
		deleteBTN.setDisable(false);
		detailsBTN.setDisable(false);
	}
	
	/**
	 * Disable buttons method
	 * @param createBTN - (Button) Create new movie
	 * @param editBTN - (Button) Update existing movie
	 * @param deleteBTN - (Button) Delete existing movie
	 */
	public static void disableButtons(Button createBTN, Button editBTN, Button deleteBTN) {
		createBTN.setDisable(true);
		editBTN.setDisable(true);
		deleteBTN.setDisable(true);
	}
	
	/**
	 * Show start information about the application
	 * @param text - (String) Create new movie
	 */
	public static void startAplication(String text) {
		HBox root = new HBox();
	    Label infoComponent =  new Label();
	    infoComponent.setText(text);
	    root.setAlignment(Pos.CENTER);
	    
	    root.getChildren().addAll(infoComponent);
	    Scene scene = new Scene(root, 425, 135);
	    infoComponent.getStyleClass().add("info");
	    Stage stage = new Stage();
	    stage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("images/icon.png")));
	    stage.setTitle("¡Comencemos!");
	    stage.setScene(scene);
	    stage.show();
	}
	
	/**
	 * Close application
	 * @param event - (Event)
	 * @param view - (BorderPane)
	 */
	public static void exitAplication(Event event, BorderPane view) {
		Stage stage = (Stage)view.getScene().getWindow();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Salir");
    	alert.setHeaderText(null);
    	alert.setContentText("¿Seguro que desea salir de la aplicación?");
    	alert.initModality(Modality.APPLICATION_MODAL);
    	alert.initOwner(stage);
		
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if(result.get() == ButtonType.OK) {
    		stage.close();
    	} else {
    		event.consume();
    	}	
	}
	
	/**
	 * Export list to PDF method
	 * @param event - (Event)
	 * @param movieList - (ListProperty) All the movies of database
	 */
	public static void exportPdf(Event event, ListProperty<Movie> movieList) {
		try {
			ReportMain.generatePdf(movieList);
		} catch (JRException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Open issues on GitHub repository
	 * @param event - (Event)
	 */
	public static void reportBug(Event event) {
		try {
			Desktop.getDesktop().browse(new URI("https://github.com/Ayoamaro/TheMovieBillboard/issues"));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Open profile on GitHub
	 * @param event - (Event)
	 */
	public static void openGitHub(Event event) {
		try {
			Desktop.getDesktop().browse(new URI("https://github.com/Ayoamaro"));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Open profile on LinkedIn
	 * @param event - (Event)
	 */
	public static void openLinkedIn(Event event) {
		try {
			Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/ayoamaro/"));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
