package npctools.ui;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import jdk.jfr.Description;
import npctools.ui.controllers.InventoryTabController;
import npctools.ui.controllers.MainController;
import npctools.ui.controllers.NpcTabController;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
@Disabled("Work in progress")
public class ControllersTest {
	
	private MainController mainController;
	private NpcTabController npcTabController;
	private InventoryTabController inventoryTabController;
	
	private static FXMLLoader fxmlLoader;
	
	@Tag ("Controllers")
	@BeforeAll
	@DisplayName ("Prepare Controllers for testing.")
	static void prepareControllers(Stage stage) {
		//fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainScreen.fxml"));
	
		
	}
	
	
	@Tag ("Controllers")
	@Test
	@DisplayName ("Testing if Controllers are NOT null.")
	@Order (1)
	void testMainControllerIfNull() {
		assertAll(
				() -> assertNotNull(mainController),
				() -> assertNotNull(npcTabController),
				() -> assertNotNull(inventoryTabController)
		);
	}
	
	@Tag ("Controllers")
	@Test
	@DisplayName ("Accessed field should not be null if Controller was initialized (and field was injected).")
	@Order (2)
	void testAccessOfField() {
	
	}
	
}
