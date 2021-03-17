package npctools.npc;

public class NpcAttributes {
	
	private boolean perChapter;
	private int chapter;
	private int strength;
	private int dexterity;
	private int maxHealth;
	private int maxMana;
	private int currentHealth;
	private int currentMana;
	
	// Getters
	public boolean isPerChapter() {
		return perChapter;
	}
	
	public int getChapter() {
		return chapter;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getDexterity() {
		return dexterity;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public int getMaxMana() {
		return maxMana;
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	public int getCurrentMana() {
		return currentMana;
	}
	
	
	// Setters
	
	public void setPerChapter(boolean perChapter) {
		this.perChapter = perChapter;
	}
	
	public void setChapter(int chapter) {
		this.chapter = chapter;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}
	
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	public void setCurrentMana(int currentMana) {
		this.currentMana = currentMana;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("Per Chapter?: ")
				.append(perChapter)
				.append(" | Chapter: ")
				.append(chapter)
				.append(" | Strength: ")
				.append(strength)
				.append(" | Dexterity: ")
				.append(dexterity)
				.append(" | Max Health: ")
				.append(maxHealth)
				.append(" | Max Mana: ")
				.append(maxMana)
				.append(" | Current Health: ")
				.append(currentHealth)
				.append(" | Current Mana: ")
				.append(currentMana)
				.toString();
	}
}
