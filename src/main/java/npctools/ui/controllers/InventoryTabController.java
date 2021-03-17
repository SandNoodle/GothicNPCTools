package npctools.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

public class InventoryTabController {
	
	@FXML
	private AnchorPane inventoryTab;
	
	@FXML
	private ChoiceBox invItem;
	
	private MainController mainController;
	
	@FXML
	private void initialize() {
	
	}
	
	public void injectMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
}
