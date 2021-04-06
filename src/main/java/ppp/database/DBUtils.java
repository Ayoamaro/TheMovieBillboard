package ppp.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ppp.javafx.moviebillboard.model.Movie;

/**
 * @author Ayoze Amaro
 *
 */
public class DBUtils {

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
	
	public static void showInfo(Connection con, Integer selected) throws IOException {
		showInfoWindow(detailsData(con, selected));
	}
	
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
