package ppp.javafx.moviebillboard.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * @author Ayoze Amaro
 *
 */
public class LoginController implements Initializable {

	// VIEW
	@FXML
	private BorderPane view;
	
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	// SHOW VIEW
	public BorderPane getView() {
		return view;
	}

}
