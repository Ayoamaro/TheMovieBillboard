package ppp.javafx.moviebillboard.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * @author Ayoze Amaro
 *
 */
public class MainController implements Initializable {

	// VIEW
	@FXML
	private BorderPane view;
	
	// CONSTRUCTOR
	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	// SHOW VIEW
	public BorderPane getView() {
		return view;
	}

}
