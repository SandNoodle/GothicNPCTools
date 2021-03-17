package npctools.ui;

import org.junit.jupiter.api.*;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LocalizationTest {
	
	private static ResourceBundle locBundle;
	
	private String resourceBundle = "localization/lang";
	
	@Test
	@Order(1)
	@Tag("Language")
	@DisplayName("Test if I18N Resource Bundle exists.")
	void prepareLocalization(){
		assertNotNull(ResourceBundle.getBundle(resourceBundle));
	}
	
	@Test
	@Order(2)
	@Tag("Language")
	@DisplayName("Test Polish language.")
	public void testPolish(){
		locBundle = ResourceBundle.getBundle(resourceBundle, new Locale("pl"));
		
		assertEquals(locBundle.getString("npc.characteristicsLabel"), "Cechy Charakterystyczne");
	}
	
	@Test
	@Order(3)
	@Tag("Language")
	@DisplayName("Test English language.")
	public void testEnglish(){
		locBundle = ResourceBundle.getBundle(resourceBundle, new Locale("en"));
		
		assertEquals(locBundle.getString("npc.characteristicsLabel"), "Characteristics");
	}
	
}
