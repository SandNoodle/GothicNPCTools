package npctools.npc;

public class Guild {
	
	private String name;
	private String value;
	
	public Guild(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
}
