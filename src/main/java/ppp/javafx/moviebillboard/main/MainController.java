package ppp.javafx.moviebillboard.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

/**
 * @author Ayoze Amaro
 *
 */
public class MainController implements Initializable {

	// VIEW
	@FXML
	private GridPane view;
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	// SHOW VIEW
	public GridPane getView() {
		return view;
	}

}
