package ppp.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ppp.javafx.moviebillboard.model.Movie;

/**
 * @author Ayoze Amaro
 * @version 1.0
 * @since 2021-06-04 (YYYY/DD/MM)
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard" /> TheMovieBillboard Github </a>
 */
public class DBUtils {

	/**
	 * Handle errors method
	 * @param errorDetected - (Integer)
	 * @param view - (BorderPane)
	 */
	public static void solvedProblems(int errorDetected, BorderPane view) {
		switch (errorDetected) {
			case 1:
				Stage stage = (Stage)view.getScene().getWindow();
				
				Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Error al editar una película");
		    	alert.setHeaderText(null);
		    	alert.setContentText("Debe seleccionar una película si desea editar. Por favor, vuelva a intentarlo.");
		    	alert.initModality(Modality.APPLICATION_MODAL);
		    	alert.initOwner(stage);
		    	alert.showAndWait();
				break;
			case 2:
				stage = (Stage)view.getScene().getWindow();
				
				alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Error al eliminar una película");
		    	alert.setHeaderText(null);
		    	alert.setContentText("Debe seleccionar una película si desea eliminarla. Por favor, vuelva a intentarlo.");
		    	alert.initModality(Modality.APPLICATION_MODAL);
		    	alert.initOwner(stage);
		    	alert.showAndWait();
				break;
			case 3:
				stage = (Stage)view.getScene().getWindow();
				
				alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Error al ver los detalles una película");
		    	alert.setHeaderText(null);
		    	alert.setContentText("Debe seleccionar una película si desea ver sus detalles. Por favor, vuelva a intentarlo.");
		    	alert.initModality(Modality.APPLICATION_MODAL);
		    	alert.initOwner(stage);
		    	alert.showAndWait();
				break;
		}
	}
	
	/**
	 * Collect all the movies of database
	 * @param con - (Connection) Establish with database
	 * @param list - (ObservableList) List with all the movies
	 */
	public static void readData(Connection con, ObservableList<Movie> list) {
		try {
			String sql = "SELECT * FROM pelicula";
			PreparedStatement consult = con.prepareStatement(sql);
			ResultSet result = consult.executeQuery();
			
			while (result.next()) {
				list.add(
						new Movie(
								result.getInt("id"),
								result.getString("nombre"), 
								result.getInt("agno"),
								result.getString("pais"),
								result.getString("director"),
								result.getInt("idTipo")
						)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Insert new movies on database
	 * @param con - (Connection) Establish with database
	 * @param newMovie - (Movie) Get new movie params
	 */
	public static int createData(Connection con, Movie newMovie) {
		try {
			String sql = "INSERT INTO pelicula (id, nombre, agno, pais, director, idTipo) VALUES (?,?,?,?,?,?)";
			PreparedStatement insert = con.prepareStatement(sql);
		
			insert.setInt(1, newMovie.getId());
			insert.setString(2, newMovie.getNombre());
			insert.setInt(3, newMovie.getAgno());
			insert.setString(4, newMovie.getPais());
			insert.setString(5, newMovie.getDirector());
			insert.setInt(6, newMovie.getIdTipo());
			
			return insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	/**
	 * Update existing movies on database
	 * @param con - (Connection) Establish with database
	 * @param newMovie - (Movie) Get new movie params
	 */
	public static int updateData(Connection con, Movie selected) {
		try {
			String sql = "UPDATE pelicula SET id=?, nombre=?, agno=?, pais=?, director=?, idTipo=? WHERE id= " + selected.getId();
			PreparedStatement update = con.prepareStatement(sql);

			update.setInt(1, selected.getId());
			update.setString(2, selected.getNombre());
			update.setInt(3, selected.getAgno());
			update.setString(4, selected.getPais());
			update.setString(5, selected.getDirector());
			update.setInt(6, selected.getIdTipo());
			
			return update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	/**
	 * Show info about a movie
	 * @param con - (Connection) Establish with database
	 * @param selected - (Integer) Specific record to search on database
	 */
	public static void showInfo(Connection con, Integer selected) throws IOException {
		showInfoWindow(detailsData(con, selected));
	}
	
	/**
	 * New Window to show details information
	 * @param info - (String) Information about the movie
	 */
	public static void showInfoWindow(String info) throws IOException {
        HBox root = new HBox();
        Label infoComponent =  new Label();
        infoComponent.setText(info);
        root.setAlignment(Pos.CENTER);
        
        root.getChildren().addAll(infoComponent);
        Scene scene = new Scene(root, 250, 150);
        infoComponent.getStyleClass().add("info");
        Stage stage = new Stage();
        stage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("images/icon.png")));
        stage.setTitle("Detalles");
        stage.setScene(scene);
        stage.show();
	}
	
	/**
	 * Search info on database about the record selected
	 * @param con - (Connection) Establish with database
	 * @param selected - (Integer) Specific record to search on database
	 */
	public static String detailsData(Connection con, Integer selected) {
		String info = "";
		try {
			
			String sql = "SELECT * FROM pelicula INNER JOIN tipoPelicula on pelicula.idTipo = tipoPelicula.idTipo WHERE id=" + selected;
			PreparedStatement consult = con.prepareStatement(sql);
			ResultSet result = consult.executeQuery();
			info = "ID: " + result.getInt("id") 
				 + "\nNombre: " + result.getString("nombre") 
				 + "\nAño: " + result.getInt("agno") 
				 + "\nPaís: " + result.getString("pais") 
				 + "\nDirector: " + result.getString("director") 
				 + "\nGénero: " + result.getString("genero");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	/**
	 * Delete existing movies on database
	 * @param con - (Connection) Establish with database
	 * @param selected - (Integer) Specific record to search on database
	 */
	public static void deleteData(Connection con, Integer selected) {
		try {
			String sql = "DELETE FROM pelicula WHERE id= " + selected;
			PreparedStatement consult = con.prepareStatement(sql);
			consult.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
