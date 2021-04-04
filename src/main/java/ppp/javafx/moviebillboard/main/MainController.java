package ppp.javafx.moviebillboard.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import ppp.javafx.moviebillboard.model.Movie;
import ppp.javafx.moviebillboard.util.MenuFunctions;

/**
 * @author Ayoze Amaro
 *
 */
public class MainController implements Initializable {

	// VIEW
	@FXML
	private BorderPane view;
	@FXML
	private TableView<Movie> movieTBL;
	@FXML
	private TableColumn<Movie, Integer> idCOL, yearCOL;
	@FXML
	private TableColumn<Movie, String> nameCOL, countryCOL, directorCOL;
	@FXML
	private Button createBTN, editBTN, deleteBTN, detailsBTN;
	
	
	// CONSTRUCTOR
	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	// MENU BAR
	@FXML
	void onExportPDFAction(ActionEvent event) throws IOException { }
	@FXML
	void onReportProblemAction(ActionEvent event) throws IOException { }
	
	@FXML
	void onExitAction(ActionEvent event) throws IOException { 
    	MenuFunctions.exitAplication(event, view);
	}
	
	@FXML
	void onGitHubAction(ActionEvent event) throws IOException { 
		MenuFunctions.openGitHub(event);
	}
	
	@FXML
	void onLinkedInAction(ActionEvent event) throws IOException { 
		MenuFunctions.openLinkedIn(event);
	}

	
	// BUTTONS (CRUD)
	@FXML
	void onCreateAction(ActionEvent event) throws IOException { }
	@FXML
	void onUpdateAction(ActionEvent event) throws IOException { }
	@FXML
	void onDeleteAction(ActionEvent event) throws IOException { }
	@FXML
	void onReadAction(ActionEvent event) throws IOException { }

	
	// SHOW VIEW
	public BorderPane getView() {
		return view;
	}

}
