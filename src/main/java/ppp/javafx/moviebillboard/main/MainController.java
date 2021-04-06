package ppp.javafx.moviebillboard.main;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ppp.database.DBConnection;
import ppp.database.DBUtils;
import ppp.javafx.moviebillboard.login.App;
import ppp.javafx.moviebillboard.model.Movie;
import ppp.javafx.moviebillboard.util.MenuFunctions;

/**
 * @author Ayoze Amaro
 *
 */
public class MainController implements Initializable {

	// MODEL
	private ListProperty<Movie> movieList = new SimpleListProperty<Movie>(FXCollections.observableArrayList());
	private DBConnection con;
	private Integer errorDetected = 1;
	
	// VIEW
	@FXML
	private BorderPane view;
	@FXML
	private TableView<Movie> movieTBL;
	@FXML
	private TableColumn<Movie, Integer> idCOL, yearCOL, typeCOL;
	@FXML
	private TableColumn<Movie, String> nameCOL, countryCOL, directorCOL;
	@FXML
	private Button startBTN, createBTN, editBTN, deleteBTN, detailsBTN;
	
	
	// CONSTRUCTOR
	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		con = new DBConnection();
		con.establishConnection();

		DBUtils.readData(con.getCon(), movieList);
		movieTBL.setItems(movieList);
		
		idCOL.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("id"));
		nameCOL.setCellValueFactory(new PropertyValueFactory<Movie, String>("nombre"));
		yearCOL.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("agno"));
		countryCOL.setCellValueFactory(new PropertyValueFactory<Movie, String>("pais"));
		directorCOL.setCellValueFactory(new PropertyValueFactory<Movie, String>("director"));
		typeCOL.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("idTipo"));
		
		MenuFunctions.disableButtons(createBTN, editBTN, deleteBTN);
		
		con.closeConnection();
	}
	
	// MENU BAR
	@FXML
	void onExportPDFAction(ActionEvent event) throws IOException { 
		
	}
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
	
	@FXML
	void onStartAction(ActionEvent event) throws IOException { 
		String title = App.getPrimaryStage().getTitle();
		String userConnected = title.substring(22);
		String text = "";
		
		if (userConnected.equals("user")) {
			MenuFunctions.disableButtons(createBTN, editBTN, deleteBTN);
			text = "Siendo '" + userConnected + "' podrás ver la lista actualizada de las mejores películas\n"
					+ "del momento y de funcionalidades especiales que te ofrece \nGRATUITAMENTE la aplicación. "
					+ "¿A qué estás esperando?";
		} else {
			MenuFunctions.activateButtons(createBTN, editBTN, deleteBTN, detailsBTN);
			startBTN.setDisable(true);
			text = "Siendo '" + userConnected + "' podrás crear nuevas películas, editarlas y sobretodo \neliminarlas "
					+ "de la aplicación. No dudes en tener el control de la APP\n en tu mano y demuestra de que estás hecho. "
					+ "¡A por ello!";
		}
		
		MenuFunctions.startAplication(text);
	}
	
	
	// BUTTONS (CRUD)
	@FXML
	void onCreateAction(ActionEvent event) throws IOException { 
		Dialog<Movie> tab = new Dialog<Movie>();
		tab.setTitle("Nueva película");
		
		ButtonType createButton = new ButtonType("Crear", ButtonData.OK_DONE);
		tab.getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);

		Stage stage = (Stage) tab.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(this.getClass().getResource("/images/icon.png").toString()));
		
		// CREATE SCENE TAB WITH GRIDPANE
		GridPane scene = new GridPane();
		scene.setHgap(10);
		scene.setVgap(10);
		scene.setPadding(new Insets(15, 150, 15, 15));

		Spinner<Integer> id = new Spinner<Integer>(0, 10000, 0);
		id.setEditable(true);
		TextField nombre = new TextField();
		Spinner<Integer> agno = new Spinner<Integer>(0, 10000, 0);
		agno.setEditable(true);
		TextField pais = new TextField();
		TextField director = new TextField();
		Spinner<Integer> idTipo = new Spinner<Integer>(0, 10000, 0);
		idTipo.setEditable(true);
		
		scene.addRow(0, new Label("ID: "), id);
		scene.addRow(1, new Label("Nombre: "), nombre);
		scene.addRow(2, new Label("Año: "), agno);
		scene.addRow(3, new Label("País: "), pais);
		scene.addRow(4, new Label("Director: "), director);
		scene.addRow(5, new Label("Género: "), idTipo);

		tab.getDialogPane().setContent(scene);
		
		tab.setResultConverter(tabButton -> {
			if (tabButton == createButton) {
				Movie newMovie = new Movie();
				
				newMovie.setId(id.getValue());
				newMovie.setNombre(nombre.getText());
				newMovie.setAgno(agno.getValue());
				newMovie.setPais(pais.textProperty().get());
				newMovie.setDirector(director.textProperty().get());
				newMovie.setIdTipo(idTipo.getValue());
				
				con.establishConnection();
				DBUtils.createData(con.getCon(), newMovie);
				con.closeConnection();
	        	
	    		return newMovie;
			}
			return null;
		});

		Optional<Movie> result = tab.showAndWait();
		if (result.isPresent()) {
			movieTBL.getItems().add(result.get());
		}
	}
	
	@FXML
	void onUpdateAction(ActionEvent event) throws IOException { 
		Movie selected = movieTBL.getSelectionModel().getSelectedItem();
		
		if (selected == null) {
			errorDetected = 1;
			DBUtils.solvedProblems(errorDetected, view);
		} else {
			Dialog<Movie> tab = new Dialog<Movie>();
			tab.setTitle("Editar película: " + selected.getNombre().toString());
			
			ButtonType createButton = new ButtonType("Confirmar cambios", ButtonData.OK_DONE);
			tab.getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);

			Stage stage = (Stage) tab.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image(this.getClass().getResource("/images/icon.png").toString()));
			
			// CREATE SCENE TAB WITH GRIDPANE
			GridPane scene = new GridPane();
			scene.setHgap(10);
			scene.setVgap(10);
			scene.setPadding(new Insets(15, 150, 15, 15));

			Spinner<Integer> id = new Spinner<Integer>(0, 10000, 0);
			id.setEditable(true);
			TextField nombre = new TextField();
			Spinner<Integer> agno = new Spinner<Integer>(0, 10000, 0);
			agno.setEditable(true);
			TextField pais = new TextField();
			TextField director = new TextField();
			Spinner<Integer> idTipo = new Spinner<Integer>(0, 10000, 0);
			idTipo.setEditable(true);
			
			id.getValueFactory().setValue(selected.getId());
			nombre.setText(selected.getNombre().toString());
			agno.getValueFactory().setValue(selected.getAgno());
			pais.setText(selected.getPais().toString());
			director.setText(selected.getDirector().toString());
			idTipo.getValueFactory().setValue(selected.getIdTipo());
			
			
			scene.addRow(0, new Label("ID: "), id);
			scene.addRow(1, new Label("Nombre: "), nombre);
			scene.addRow(2, new Label("Año: "), agno);
			scene.addRow(3, new Label("País: "), pais);
			scene.addRow(4, new Label("Director: "), director);
			scene.addRow(5, new Label("Género: "), idTipo);

			tab.getDialogPane().setContent(scene);
			
			tab.setResultConverter(tabButton -> {
				if (tabButton == createButton) {
					Movie newMovie = new Movie();
					
					newMovie.setId(id.getValue());
					newMovie.setNombre(nombre.getText());
					newMovie.setAgno(agno.getValue());
					newMovie.setPais(pais.textProperty().get());
					newMovie.setDirector(director.textProperty().get());
					newMovie.setIdTipo(idTipo.getValue());
					
					con.establishConnection();
					DBUtils.updateData(con.getCon(), selected);
					con.closeConnection();
		        	
		    		return newMovie;
				}
				return null;
			});

			Optional<Movie> result = tab.showAndWait();
			if (result.isPresent()) {
				movieTBL.getItems().clear();
				con.establishConnection();
				DBUtils.readData(con.getCon(), movieList);
				movieTBL.setItems(movieList);
				con.closeConnection();
			}
		}
	}
	
	@FXML
	void onDeleteAction(ActionEvent event) throws IOException { 
		Movie movieSelected = movieTBL.getSelectionModel().getSelectedItem();

		if (movieSelected == null) {
			errorDetected = 2;
			DBUtils.solvedProblems(errorDetected, view);
		} else {
			Integer selected = movieSelected.getId();
			
			Stage stage = (Stage)view.getScene().getWindow();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Borrar película");
	    	alert.setHeaderText(null);
	    	alert.setContentText("¿Está seguro que desea borrar (" + movieSelected.getNombre() + ") de la aplicación?");
	    	alert.initModality(Modality.APPLICATION_MODAL);
	    	alert.initOwner(stage);
			
	    	Optional<ButtonType> result = alert.showAndWait();
	    	
	    	if(result.get() == ButtonType.OK) {
	    		con.establishConnection();
	    		DBUtils.deleteData(con.getCon(), selected);
	    		con.closeConnection();
	    	}
	    	
	    	movieTBL.getItems().clear();
	    	con.establishConnection();
			DBUtils.readData(con.getCon(), movieList);
			movieTBL.setItems(movieList);
			con.closeConnection();
		}
	}
	
	@FXML
	void onDetailsAction(ActionEvent event) throws IOException {
		Movie movieSelected = movieTBL.getSelectionModel().getSelectedItem();
		
		if (movieSelected == null) {
			errorDetected = 3;
			DBUtils.solvedProblems(errorDetected, view);
		} else {
			Integer selected = movieSelected.getId();
			
			con.establishConnection();
			DBUtils.showInfo(con.getCon(), selected);
			con.closeConnection();
		}
		
		
	}
	
	// SHOW VIEW
	public BorderPane getView() {
		return view;
	}
}
