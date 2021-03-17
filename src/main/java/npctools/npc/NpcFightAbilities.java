package npctools.npc;

public class NpcFightAbilities {

	private String fightTactic;
	private int oneHanded;
	private int twoHanded;
	private int bow;
	private int crossbow;
	private int magicCircle;
	
	public String getFightTactic() {
		return fightTactic;
	}
	
	public void setFightTactic(String fightTactic) {
		this.fightTactic = fightTactic;
	}
	
	public int getOneHanded() {
		return oneHanded;
	}
	
	public void setOneHanded(int oneHanded) {
		this.oneHanded = oneHanded;
	}
	
	public int getTwoHanded() {
		return twoHanded;
	}
	
	public void setTwoHanded(int twoHanded) {
		this.twoHanded = twoHanded;
	}
	
	public int getBow() {
		return bow;
	}
	
	public void setBow(int bow) {
		this.bow = bow;
	}
	
	public int getCrossbow() {
		return crossbow;
	}
	
	public void setCrossbow(int crossbow) {
		this.crossbow = crossbow;
	}
	
	public int getMagicCircle() {
		return magicCircle;
	}
	
	public void setMagicCircle(int magicCircle) {
		this.magicCircle = magicCircle;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("Fight Tactic:")
				.append(fightTactic)
				.append(" | One Handed:")
				.append(oneHanded)
				.append(" | Two Handed:")
				.append(twoHanded)
				.append(" | Bow:")
				.append(bow)
				.append(" | Crossbow:")
				.append(crossbow)
				.append(" | Magic Circle:")
				.append(magicCircle)
				.toString();
	}
}
