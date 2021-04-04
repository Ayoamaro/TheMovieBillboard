package ppp.javafx.moviebillboard.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ppp.javafx.moviebillboard.main.MainController;
import ppp.javafx.moviebillboard.util.Config;

/**
 * @author Ayoze Amaro
 *
 */
public class App extends Application {

	private static Stage primaryStage;
	
	private static LoginController loginController;
	private static MainController mainController;
	
	private static Scene loginScene;
	private static Scene mainScene;
	
	@Override
	public void init() throws Exception {
		Config.initDatabase();
		super.init();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		App.primaryStage = primaryStage;
		
		loginController = new LoginController();
		mainController = new MainController();
		
		loginScene = new Scene(loginController.getView());
		mainScene = new Scene(mainController.getView());
		
		primaryStage.setScene(loginScene);
		primaryStage.setTitle("¡Bienvenido a The Movie Billboard!");
		primaryStage.getIcons().add(new Image("/images/icon.png"));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void goToMovieBillboard() {
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("The Movie Billboard");
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static MainController getMainController() {
		return mainController;
	}
}
