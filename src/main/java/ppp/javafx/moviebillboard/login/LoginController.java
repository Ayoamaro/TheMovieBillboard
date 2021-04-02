package ppp.javafx.moviebillboard.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

/**
 * @author Ayoze Amaro
 *
 */
public class LoginController implements Initializable {

	// VIEW
	@FXML
	private GridPane view;
	
	// CONSTRUCTOR
	public LoginController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	// SHOW VIEW
	public GridPane getView() {
		return view;
	}

}
