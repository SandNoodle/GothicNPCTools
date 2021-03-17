package npctools.ui.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import npctools.npc.Guild;
import npctools.utils.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class NpcTabController extends BasicController implements Initializable {
	
	@FXML
	private ChoiceBox<Guild> npcGuild;
	
	@FXML
	private AnchorPane npcTab;
	
	@FXML
	private ChoiceBox npcType,
			npcVoice,
			npcFightTactic,
			npcWalkStyle,
			npcHeadMesh,
			npcFaceTexture,
			npcBodyTexture,
			npcPrimaryWeapon,
			npcSecondaryWeapon,
			npcArmor;
	
	@FXML
	private TextField npcID,
			npcName,
			npcLevel,
			npcChapterAttributes,
			npcStrength,
			npcDexterity,
			npcMaxHealth,
			npcMaxMana,
			npcCurrentHealth,
			npcCurrentMana,
			npcBluntProtection,
			npcEdgeProtection,
			npcFireProtection,
			npcPointProtection,
			npcMagicProtection,
			npcFlyProtection,
			npcOneHanded,
			npcTwoHanded,
			npcBow,
			npcCrossbow,
			npcMagicCircle,
			npcWeight;
	
	@FXML
	private CheckBox npcFlagInvulnerable,
			npcFlagGhost,
			npcFlagFriend,
			npcSenseSee,
			npcFlagHear,
			npcFlagSmell,
			npcPerChapterAttributes,
			npcEnableProtection;
	
	@FXML
	private RadioButton npcMale,
			npcFemale;
	
	@FXML
	private ToggleGroup genderGroup;
	
	// Observable Lists for choice boxes
	private ObservableList<Guild> guilds;
	
	private MainController mainController;
	
	public void injectMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@FXML
	private void initialize(){
	
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		
		
		// Prepare
		initTextFields();
		
		// Add Listeners
		npcEnableProtection.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
			npcBluntProtection.setDisable(oldValue);
			npcEdgeProtection.setDisable(oldValue);
			npcFireProtection.setDisable(oldValue);
			npcPointProtection.setDisable(oldValue);
			npcMagicProtection.setDisable(oldValue);
			npcFlyProtection.setDisable(oldValue);
		});
		
		npcPerChapterAttributes.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
			// Disable/Enable per Chater, enable/disable everything else in this category
			npcChapterAttributes.setDisable(oldValue);
			
			npcStrength.setDisable(newValue);
			npcDexterity.setDisable(newValue);
			npcMaxHealth.setDisable(newValue);
			npcMaxMana.setDisable(newValue);
			npcCurrentHealth.setDisable(newValue);
			npcCurrentMana.setDisable(newValue);
		});
	}
	
	public void initGuilds() {
		npcGuild = new ChoiceBox<>();
		
		/*
		
		// Try to load the data
		try {
			HashMap<String, String> loadedGuilds = (HashMap<String, String>) resourceLoader.loadDataByTag("G:\\G2GOLD\\_Work\\Data\\Scripts\\Content\\_intern\\Constants.d", "Guild");
			guilds = FXCollections.observableArrayList();
			
			// Add to the choice box
			//npcGuild.getItems().addAll(guilds);
			//guilds.add(new Guild("JEDEN", "WARTOSC"));
			//npcGuild.setItems(guilds);
			// Base value
			//npcGuild.setValue(npcGuild.getItems().get(0));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 */
	}
	
	private void initTextFields() {
		// Verbs
		textFieldAsVerbalOnly(npcName);
		
		// Numeric
		// Don't allow any letters - only numeric ID is allowed.
		// TODO UNAVAILABLE ID should color the outline red / [error color].
		textFieldAsNumericOnly(npcID);
		
		textFieldAsNumericOnly(npcLevel);
		textFieldAsNumericOnly(npcChapterAttributes);
		textFieldAsNumericOnly(npcStrength);
		textFieldAsNumericOnly(npcDexterity);
		textFieldAsNumericOnly(npcMaxHealth);
		textFieldAsNumericOnly(npcMaxMana);
		textFieldAsNumericOnly(npcCurrentHealth);
		textFieldAsNumericOnly(npcCurrentMana);
		textFieldAsNumericOnly(npcBluntProtection);
		textFieldAsNumericOnly(npcEdgeProtection);
		textFieldAsNumericOnly(npcFireProtection);
		textFieldAsNumericOnly(npcPointProtection);
		textFieldAsNumericOnly(npcMagicProtection);
		textFieldAsNumericOnly(npcFlyProtection);
		textFieldAsNumericOnly(npcOneHanded);
		textFieldAsNumericOnly(npcTwoHanded);
		textFieldAsNumericOnly(npcBow);
		textFieldAsNumericOnly(npcCrossbow);
		textFieldAsNumericOnly(npcMagicCircle);
		//TODO ALLOW NUMBERS
		textFieldAsNumericOnly(npcWeight);
	}
	
	public void clearTextFields() {
		Logger.log("CLEAR TEXT FIELDS!");
		
		//npcID.setText("012312");
	}
	
	
}
