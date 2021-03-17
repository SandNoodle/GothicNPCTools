package npctools.npc;

public class NpcMainInformation {
	
	private int id;
	private int level;
	private String name;
	private String guild;
	private String npcType;
	private String voice;
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGuild() {
		return guild;
	}
	
	public void setGuild(String guild) {
		this.guild = guild;
	}
	
	public String getNpcType() {
		return npcType;
	}
	
	public void setNpcType(String npcType) {
		this.npcType = npcType;
	}
	
	public String getVoice() {
		return voice;
	}
	
	public void setVoice(String voice) {
		this.voice = voice;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("ID: ")
				.append(id)
				.append(" | Name: ")
				.append(name)
				.append(" | Level: ")
				.append(level)
				.append(" | Guild: ")
				.append(guild)
				.append(" | NPC Type: ")
				.append(npcType)
				.append(" | Voice: ")
				.append(voice)
				.toString();
	}
	
}
