package npctools.temptorewrite;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import npctools.npc.Npc;
import npctools.npc.NpcBuilder;
import npctools.npc.inventory.Item;
import npctools.npc.routine.Routine;
import npctools.utils.Globals;

import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

/**
 * Manager class used for Creating NPCs.
 * <p>
 * Ideally should be initialized only once!
 */
//TODO Delete all hardcoded stuff, every talent name etc, should be loaded from file
// 	Or otherwise loaded from config file!
public class NpcCreator {
	
	private FileWriter writer;
	private StringBuilder sb;
	
	//TODO Move filename to NpcManager
	// because we want to pass correct file names to sub classes
	private String fileName;
	
	private Npc npc;
	
	public NpcCreator(FileWriter writer) {
		this.writer = writer;
	}
	
	public void passNPC(Npc npc) {
		this.npc = npc;
	}
	
	//TODO beautify the generated script with tabs
	public void generateScript(int gothicVersion, Npc npc) {
		try {
			// Create file with correct name
			writer = new FileWriter(constructFilename(npc));
			// File tagging - "Generated with..."
			writer.write(tagFile());
			
			// Construct instance
			writer.write(constructInstance(npc));
			writer.write("{");
			
			// Primary Data
			writer.write("\n\t// -------- Primary Data --------\n");
			writer.write(constructPrimaryData(npc));
			
			// Attributes
			writer.write("\n\t// -------- Attributes --------\n");
			writer.write(constructAttributes(npc));
			
			// Protection
			writer.write("\n\t// -------- Protection --------\n");
			writer.write(constructProtection(npc));
			
			// Visuals
			writer.write("\n\t// -------- Visuals --------\n");
			writer.write(constructVisuals(npc));
			
			// Talents
			writer.write("\n\t// -------- Talents --------\n");
			writer.write(constructTalents(npc));
			
			// Inventory
			writer.write("\n\t// -------- Inventory --------\n");
			//		Equipped items
			writer.write(constructEquipped(npc));
			// Separate equipped and rest of the inventory
			writer.write("\n");
			//		Inventory items
			writer.write(constructInventory(npc));
			
			// Daily Routine
			writer.write("\n\t// -------- Daily Routine --------\n");
			writer.write(constructDailyRoutine(npc));
			writer.write("};\n");
			
			// Routines
			writer.write(constructRoutines(npc));
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private String constructFilename(Npc npc) {
		sb = new StringBuilder();
		sb.append(npc.getMainInformation().getGuild().replace("GIL_", ""));
		sb.append("_").append(npc.getMainInformation().getID());
		sb.append("_").append(npc.getMainInformation().getName());
		sb.append(".d");
		
		return sb.toString();
	}
	
	private String tagFile() {
		//TODO Center string with something other than tab
		sb = new StringBuilder();
		sb.append("//--------------------- ").append("Sand Noodles' Gothic NPC Creator").append(" " +
				"---------------------\n");
		sb.append("// \t\t\t\t\tGenerated: ");
		sb.append(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME)).append("\n");
		sb.append("//----------------------------------------------------------------------------\n\n");
		
		return sb.toString();
	}
	
	private String constructInstance(Npc npc) {
		//	String guild = npc.parseGuild(npc.getGuild());
		//	guild = guild.replace("GIL_", ""); // Trim
		
		sb = new StringBuilder("instance ");
		sb.append(npc.getMainInformation().getGuild().replace("GIL_", ""))
				.append("_")
				.append(npc.getMainInformation().getID())
				.append("_")
				.append(npc.getMainInformation().getName()) // TODO check if special characters are allowed.
				.append(" (Npc_Default)\n");
		
		return sb.toString();
	}
	
	private String constructPrimaryData(Npc npc) {
		sb = new StringBuilder("\n");
		sb.append("\tname = \"").append(npc.getMainInformation().getName()).append("\"");
		sb.append(";\n\tguild = ").append(npc.getMainInformation().getGuild());
		sb.append(";\n\tnpctype = ").append(npc.getMainInformation().getNpcType());
		sb.append(";\n\tid = ").append(npc.getMainInformation().getID());
		sb.append(";\n\tlevel = ").append(npc.getMainInformation().getLevel());
		sb.append(";\n\tvoice = ").append(npc.getMainInformation().getVoice());
		sb.append(";\n\tflags = ");
		
		/*
		// TODO FLAGS!
		// 	In Gothic I there's not FRIENDLY flag for Npc.
		for (Map.Entry<String, JsonElement> entry : flags.entrySet()) {
			if (entry.getValue().getAsBoolean()) {
				sb.append(entry.getKey());
				sb.append(" | ");
			}
		}
		// Trim the last | and end
		sb.setLength(sb.length() - 3);
		sb.append(";\n");
		 */
		
		
		// Fight Tactic
		sb.append("\tfight_tactic = ").append(npc.getFightAbilities().getFightTactic()).append(";\n");
		
		
		return sb.toString();
	}
	
	private String constructAttributes(Npc npc) {
		sb = new StringBuilder("\n");
		
		if (npc.getAttributes().isPerChapter()) {
			sb.append("\tB_SetAttributesToChapter (self, ");
			sb.append(npc.getAttributes().getChapter()).append(");\n");
		} else {
			sb.append(createField("attribute", "ATR_STRENGTH", npc.getAttributes().getStrength()));
			sb.append(createField("attribute", "ATR_DEXTERITY", npc.getAttributes().getDexterity()));
			sb.append(createField("attribute", "ATR_MANA_MAX", npc.getAttributes().getMaxMana()));
			sb.append(createField("attribute", "ATR_MANA", npc.getAttributes().getCurrentMana()));
			sb.append(createField("attribute", "ATR_HITPOINTS_MAX", npc.getAttributes().getMaxHealth()));
			sb.append(createField("attribute", "ATR_HITPOINTS", npc.getAttributes().getCurrentHealth()));
		}
		
		return sb.toString();
	}
	
	private String constructProtection(Npc npc) {
		sb = new StringBuilder("\n");
		
		if (npc.getProtection().isEnabled()) {
			sb.append(createField("protection", "PROT_BLUNT", npc.getProtection().getBlunt()));
			sb.append(createField("protection", "PROT_EDGE", npc.getProtection().getEdge()));
			sb.append(createField("protection", "PROT_POINT", npc.getProtection().getPoint()));
			sb.append(createField("protection", "PROT_FIRE", npc.getProtection().getFire()));
			sb.append(createField("protection", "PROT_FLY", npc.getProtection().getFly()));
			sb.append(createField("protection", "PROT_MAGIC", npc.getProtection().getMagic()));
		}
		
		return sb.toString();
	}
	
	//TODO setting variables and applying them should be separate.
	//	Finish it asap!
	private String constructVisuals(Npc npc) {
		sb = new StringBuilder("\n");
		
		// Walk Style
		sb.append("\tMdl_ApplyOverlayMds (self, ")
				.append(npc.getVisual().getWalkStyle())
				.append(");\n");
		
		// Body 3D model used
		sb.append("\tMdl_SetVisual (self, ");
		if ((npc.getVisual().getGender() == Globals.FEMALE) && (npc.getGothicVersion() == Globals.GOTHIC_ONE)) {
			// Only female body in Gothic I uses other file than HUMANS.mds (BABE.mds)
			// in Gothic II it's the part of HUMANS.mds
			sb.append("\"BABE.MDS\"");
		} else { // Gothic I Male or Gothic II Npc (Male and Female)
			sb.append("\"HUMANS.MDS\"");
		}
		sb.append(");\n");
		
		// Visual Appearance
		if (npc.getGothicVersion() == Globals.GOTHIC_ONE) {
			//	Gothic I
			sb.append("\tMdl_SetVisualBody (self, ")
					.append("").append(", ")                                // Body Mesh	TODO FIX
					.append(npc.getVisual().getBodyTexture()).append(", ")    // Body Texture
					.append("0")                                            // Skin-Palette TODO FIX?????
					.append(", ")
					.append(npc.getVisual().getHeadMesh()).append(", ")    // Head Mesh
					.append(npc.getVisual().getFaceTexture())                // Face Texture
					.append(", ")
					.append("DEFAULT, ")                                    // Teeth-texture
					.append(npc.getVisual().getArmorWorn())                // Armor Worn
					.append(");\n");
			
			// If NPC is male then add scaling by attribute
			// Don't do anything if npc's female
			if (npc.getVisual().getGender() == Globals.MALE) {
				sb.append("\tB_Scale (self);\n");
			}
		} else {
			//	Gothic II
			sb.append("\tB_SetNpcVisual (self, ")
					.append(npc.getVisual().getGender()).append(", ")
					.append(npc.getVisual().getHeadMesh()).append(", ")
					.append(npc.getVisual().getFaceTexture()).append(", ")
					.append(npc.getVisual().getBodyTexture()).append(", ")
					.append(npc.getVisual().getArmorWorn()).append(");\n");
		}
		
		// Model Fatness
		sb.append("\tMdl_SetModelFatness (self, ")
				.append(npc.getVisual().getFatness())
				.append(");\n");
		
		return sb.toString();
	}
	
	private String constructTalents(Npc npc) {
		sb = new StringBuilder("\n");
		
		if (npc.getGothicVersion() == Globals.GOTHIC_ONE) {
			// Gothic I
			sb.append("\tNpc_SetTalentSkill (self, NPC_TALENT_MAGE, ")
					.append(npc.getFightAbilities().getMagicCircle()).append(");\n");
			sb.append("\tNpc_SetTalentSkill (self, NPC_TALENT_1H, ")
					.append(npc.getFightAbilities().getOneHanded()).append(");\n");
			sb.append("\tNpc_SetTalentSkill (self, NPC_TALENT_2H, ")
					.append(npc.getFightAbilities().getTwoHanded()).append(");\n");
			sb.append("\tNpc_SetTalentSkill (self, NPC_TALENT_BOW, ")
					.append(npc.getFightAbilities().getBow()).append(");\n");
			sb.append("\tNpc_SetTalentSkill (self, NPC_TALENT_CROSSBOW, ")
					.append(npc.getFightAbilities().getCrossbow()).append(");\n");
			
		} else {
			// Gothic II
			sb.append("\tB_GiveNpcTalents (self);\n\n");
			sb.append("\tHitChance [NPC_TALENT_1H] = ").append(npc.getFightAbilities().getOneHanded()).append(";\n");
			sb.append("\tHitChance [NPC_TALENT_2H] = ").append(npc.getFightAbilities().getTwoHanded()).append(";\n");
			sb.append("\tHitChance [NPC_TALENT_BOW] = ").append(npc.getFightAbilities().getBow()).append(";\n");
			sb.append("\tHitChance [NPC_TALENT_CROSSBOW] = ").append(npc.getFightAbilities().getCrossbow()).append(";\n");
		}
		
		return sb.toString();
	}
	
	private String constructEquipped(Npc npc) {
		
		sb = new StringBuilder("\n");
		
		/*
		TODO
		JsonObject eq = npc.getEquippedItems();
		
		for (Map.Entry<String, JsonElement> entry : eq.entrySet()) {
			sb.append("\tEquipItem  (self, ");
			sb.append(entry.getValue());
			sb.append(");\n");
		}
		 */
		return sb.toString();
	}
	
	private String constructInventory(Npc npc) {
		sb = new StringBuilder("\n");
		ArrayList<Item> inventory = npc.getInventory();
		
		for (Item i : inventory) {
			sb.append("\tCreateInvItems (self, ");
			sb.append(i.getName()).append(", ");
			sb.append(i.getQuantity()).append(");\n");
		}
		
		return sb.toString();
	}
	
	private String constructDailyRoutine(Npc npc) {
		sb = new StringBuilder("\t");
		//Craft daily Routine
		sb.append("daily_routine = Rtn_")
				.append(npc.getRoutines().get(0).getName())
				.append("_")
				.append(npc.getMainInformation().getID())
				.append(";\n");
		
		return sb.toString();
	}
	
	private String constructRoutines(Npc npc) {
		sb = new StringBuilder("\t");
		
		/*
			TODO
		ArrayList<Routine> routines = npc.getRoutines();
		JsonArray activities;
		JsonObject activity;
		
		// Loop through each routine
		for (Routine r : routines) {
			// Get list of activities in each routine
			activities = r.getActivities();
			
			//Create routine body
			sb.append("\nFUNC VOID Rtn_")
					.append(r.getName())
					.append("_")
					.append(npc.getMainInformation().getID())
					.append(" ()\n");
			// Open routine body
			sb.append("{\n");
			
			// Loop through each activity
			for (int i = 0; i < activities.size(); i++) {
				// Get an activity from all of activities
				activity = activities.get(i).getAsJsonObject();
				
				//Create an activity
				//TODO Even indent between activity name and "( ... )"
				sb.append("\t");
				sb.append(activity.get("ACTIVITY_NAME").getAsString()).append("\t(");
				sb.append(activity.get("ACTIVITY_START").getAsString()).append(", ");
				sb.append(activity.get("ACTIVITY_END").getAsString()).append(", ");
				sb.append(activity.get("ACTIVITY_WAYPOINT").toString()).append(");\n");
			}
			
			//Close routine body
			sb.append("};\n");
		}
		
		
		 */
		
		return sb.toString();
	}
	
	private String createField(String tag, String key, Object value) {
		return "\t" + tag + "[" + key + "] = " + value + ";\n";
	}
	
	
}
