package npctools.ui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import npctools.npc.Npc;
import npctools.utils.Logger;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
	
	@FXML
	private NpcTabController npcTabController;
	@FXML
	private InventoryTabController inventoryTabController;
	
	private Npc npc;
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

	}
	
	@FXML
	private void initialize() {
		npcTabController.injectMainController(this);
		inventoryTabController.injectMainController(this);
	}
	
	// Toolbar buttons
	// Basic operations
	@FXML
	private void newNPC() {
		// Clear all input fields
		
		Logger.log("Clearing all Text fields.");
		Logger.logError("is NpcTabController null? " + (npcTabController == null));
		
		//npcTabController.clearTextFields();
		// Set Choiceboxes and ComboBoxes to default values
	}
	
	@FXML
	private void saveNPC() {
		// Collect all field values
		// Serialize to JSON using GSON
		// Save the File
	}
	
	@FXML
	private void openNPC() {
		// Load the file
		// Deserialize from JSON using GSON
		// Put every value to correct place
	}
	
	//NPC Creation
	@FXML
	private void generateNPC() {
		// Get values from every field
		// Create NPC using NPC Builder class
		// Pass the NPC to NPCCreator
		// Let it handle and generate the script file
		// Save it to specified location
	}
	
	@FXML
	private void generateDialogues() {
	
	}
	
	// Program operations
	@FXML
	private void openPreferences() {
	
	}
	
	@FXML
	private void openAbout() {
	
	}
	
	@FXML
	private void openGithub() {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI("https://github.com/SandNoodle/GothicNPCTools"));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@FXML
	private void switchGothicVersion() {
	
	}
}
