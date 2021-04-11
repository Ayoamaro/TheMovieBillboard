package ppp.javafx.moviebillboard.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ppp.javafx.moviebillboard.main.MainController;
import ppp.javafx.moviebillboard.util.Config;

/**
 * @author Ayoze Amaro
 * @version 1.0
 * @since 2021-06-04 (YYYY/DD/MM)
 * @see <a href = "https://github.com/Ayoamaro/TheMovieBillboard"> TheMovieBillboard Github </a>
 */
public class App extends Application {

	private static Stage primaryStage;	// Application stage
	
	private static LoginController loginController;	// Login controller
	private static MainController mainController;	// Main controller
	
	private static Scene loginScene;	// Login scene implementation
	private static Scene mainScene;	// Main scene implementation
	
	/**
     * Application and Database initialization
     * @throws Exception - Problem detected
     */
	@Override
	public void init() throws Exception {
		Config.initDatabase();
		super.init();
	}
	
	/**
     * Application start
     * @param primaryStage - (Stage) Main scene of the application
     * @throws Exception - Problem detected
     */
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
	
	/**
    * Returns a new stage
    * @return primaryStage - (Stage)
    */
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/**
     * Main thread method
     * @return mainController - (MainController) Controller based on MainController.java
     */
	public static MainController getMainController() {
		return mainController;
	}
	
	/**
     * Set new scene
     * @param md5User - (String) Type user connected
     */
	public static void goToMovieBillboard(String md5User) {
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("The Movie Billboard - " + md5User);
		primaryStage.setResizable(true);
	}

	/**
     * Main thread method
     * @param args - Array value
     */
	public static void main(String[] args) {
		launch(args);
	}

}
