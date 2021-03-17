package npctools.npc;

import npctools.utils.Globals;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
@Disabled("Rewriting NPC and NPC Builder.")
public class NpcTest {
	
	private static Npc npc;
	
	@BeforeAll
	@Tag("Npc")
	@DisplayName("Prepare dummy NPC for tests.")
	static void prepareNPC(){
		npc = new NpcBuilder(Globals.GOTHIC_ONE)
				.build();
	}
	
	@Test
	@Tag("Npc")
	@DisplayName("Check if dummy NPC is not null.")
	void npcBuilderTest(){
		assertNotNull(npc);
	}

}
