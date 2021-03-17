package npctools.npc;

public class NpcSenses {
	
	private boolean see;
	private boolean hear;
	private boolean smell;
	
	public boolean isSee() {
		return see;
	}
	
	public void setSee(boolean see) {
		this.see = see;
	}
	
	public boolean isHear() {
		return hear;
	}
	
	public void setHear(boolean hear) {
		this.hear = hear;
	}
	
	public boolean isSmell() {
		return smell;
	}
	
	public void setSmell(boolean smell) {
		this.smell = smell;
	}
	
	@Override
	public String toString(){
		return new StringBuilder()
				.append("See: ")
				.append(see)
				.append(" | Hear: ")
				.append(hear)
				.append(" | Smell: ")
				.append(smell)
				.toString();
	}
}
