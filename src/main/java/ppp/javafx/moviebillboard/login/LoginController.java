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
 * @version 06/04/2021
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard" /> TheMovieBillboard Github </a>
 */
public class LoginController implements Initializable {

	// MODEL
	private Login model = new Login();
	private ArrayList<String> linesCSV = new ArrayList<>();
	
	// VIEW
	@FXML
	private GridPane view;
	@FXML
	private Label userLBL, pswdLBL;
	@FXML
	private TextField userTXT;
	@FXML
	private PasswordField pswdTXT;
	@FXML
	private Button loginBTN, cancelBTN;
	
	// CONSTRUCTOR
	public LoginController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ReadCSV.readUsersFile(linesCSV);

		Bindings.bindBidirectional(userTXT.textProperty(), model.userProperty());
		Bindings.bindBidirectional(pswdTXT.textProperty(), model.pswdProperty());
	}
	
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
	
	@FXML
	void onCancelAction(ActionEvent event) throws IOException { 
		userTXT.setText("");
		pswdTXT.setText("");
	}
	
	// SHOW VIEW
	public GridPane getView() {
		return view;
	}

}
