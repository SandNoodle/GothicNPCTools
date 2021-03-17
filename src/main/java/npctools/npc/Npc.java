package npctools.npc;


import com.google.gson.JsonObject;
import npctools.npc.inventory.Item;
import npctools.npc.routine.Routine;

import java.util.ArrayList;

/**
 * This class holds every information about NPC ID, Name, Attributes, Talents, Visuals, etc. It does not hold
 * information about Routines (with exception to daily routine variable) or Dialogues - only the data that are important
 * to creating a NPC.
 */

public class Npc {

	/*
		Due to subtle changes between Gothic I and Gothic II
		We have to determine version for which we are generating a
		script.
		Changes include added parameters, modified method of making
		npc's visuals, etc.
 	*/
	private int gothicVersion;
	
	private NpcMainInformation mainInformation;
	private NpcFlags flags;
	private NpcSenses senses;
	private NpcAttributes attributes;
	private NpcProtection protection;
	private NpcFightAbilities fightAbilities;
	private NpcVisual visual;
	
	// TODO
	private ArrayList<Item> npcInventory;
	private ArrayList<Routine> npcRoutines;
	
	protected Npc(final int gothicVersion) {
		this.gothicVersion = gothicVersion;
	}
	
	public int getGothicVersion() {
		return gothicVersion;
	}
	
	public NpcMainInformation getMainInformation() {
		return mainInformation;
	}
	
	public NpcFlags getFlags() {
		return flags;
	}
	
	public NpcSenses getSenses() {
		return senses;
	}
	
	public NpcAttributes getAttributes() {
		return attributes;
	}
	
	public NpcProtection getProtection() {
		return protection;
	}
	
	public NpcFightAbilities getFightAbilities() {
		return fightAbilities;
	}
	
	public NpcVisual getVisual() {
		return visual;
	}
	
	public ArrayList<Item> getInventory() {
		return npcInventory;
	}

	public ArrayList<Routine> getRoutines() {
		return npcRoutines;
	}

}
