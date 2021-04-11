package ppp.javafx.moviebillboard.login;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import ppp.javafx.moviebillboard.model.Login;
import ppp.javafx.moviebillboard.util.ReadCSV;

/**
 * @author Ayoze Amaro
 * @version 1.0
 * @since 2021-06-04 (YYYY/DD/MM)
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard"> TheMovieBillboard Github </a>
 */
public class LoginController implements Initializable {

	private Login model = new Login();	// Model login
	private ArrayList<String> linesCSV = new ArrayList<>();	// ArrayList with CSV lines
	
	@FXML
	private GridPane view;	// GridPane view
	@FXML
	private Label userLBL, pswdLBL;	// Label of User and Password 
	@FXML
	private TextField userTXT;	// User TextField
	@FXML
	private PasswordField pswdTXT;	// Password Field
	@FXML
	private Button loginBTN, cancelBTN;	// Button of Login and Cancel
	
	/**
	 * LoginController constructor
	 * @throws IOException - Problem detected
	 */
	public LoginController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	/**
	 * Initialization of LoginController
	 * @param location - (URL)
	 * @param resources - (ResourceBundle)
	 */
	public void initialize(URL location, ResourceBundle resources) {
		ReadCSV.readUsersFile(linesCSV);

		Bindings.bindBidirectional(userTXT.textProperty(), model.userProperty());
		Bindings.bindBidirectional(pswdTXT.textProperty(), model.pswdProperty());
	}
	
	/**
	 * Allows the user to Login
	 * @param event - (ActionEvent)
	 * @throws IOException - Problem detected
	 */
	@FXML
	void onLoginAction(ActionEvent event) throws IOException { 
		Boolean verify = false;
		String md5Password = DigestUtils.md5Hex(model.getPswd()).toUpperCase();
		String md5User = model.getUser();
		
		for (int i = 0; i < linesCSV.size(); i++) {
			String[] dataFile = linesCSV.get(i).split(";");
		    String userEach = dataFile[0];
		    String passEach = dataFile[1];

		    if (userEach.equals(md5User) && passEach.equals(md5Password)) { 
		    	verify = true; 
		    }
		}
		
		if (verify == true) { 
			App.goToMovieBillboard(md5User);
		} else {
			ReadCSV.wrongCredentials();
		}
	}
	
	/**
	 * Reset the Text and Password Fields
	 * @param event - (ActionEvent)
	 * @throws IOException - Problem detected
	 */
	@FXML
	void onCancelAction(ActionEvent event) throws IOException { 
		userTXT.setText("");
		pswdTXT.setText("");
	}
	
	/**
	 * App thread method
	 * @return view - (GridPane)
	 */
	public GridPane getView() {
		return view;
	}

}
