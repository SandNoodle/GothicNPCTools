package npctools.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import npctools.Main;
import npctools.ui.controllers.MainController;
import npctools.utils.Logger;

import java.util.ResourceBundle;

public class WindowManager extends Application {
	
	private LocalizationManager langManager;
	
	public WindowManager() {
	
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		// TODO Delete hardcoded data - load from config file.
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainScreen.fxml"));
		
		// Localization
		langManager = new LocalizationManager(Main.getConfiguration());
		fxmlLoader.setResources(ResourceBundle.getBundle(("localization/lang"), langManager.getCurrentLanguage()));
		
		// Create a scene
		Parent root = fxmlLoader.load();
		Scene mainScene = new Scene(root);
		
		// Stylesheet and Color Theme
		mainScene.getStylesheets().clear();
		mainScene.getStylesheets().add("stylesheets/stylesheet.css");
		mainScene.getStylesheets().add("stylesheets/palettes/defaultDark.css");
		
		// Scene setup
		stage.setScene(mainScene);
		//stage.getIcons().add(new Image("res/favicon.png"));
		stage.setTitle("Sand Noodles' Gothic NPC Creator");
		stage.setResizable(false); //TODO - Currently not resizable due to mainScreen being not so responsive.
		stage.sizeToScene();
		stage.show();
	}
	
	public void launchApplication(String[] args) {
		Application.launch(args);
	}
}
