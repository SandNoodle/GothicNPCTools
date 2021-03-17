package npctools.npc;

public class NpcBuilder {
	
	private int gothicVersion;
	
	private NpcMainInformation mainInformation;
	private NpcFlags flags;
	private NpcSenses senses;
	private NpcAttributes attributes;
	private NpcProtection protection;
	private NpcFightAbilities fightAbilities;
	private NpcVisual visual;
	
	public NpcBuilder(final int gothicVersion) {
		this.gothicVersion = gothicVersion;
	}
	
	public NpcBuilder setMainInformation(final NpcMainInformation mainInformation) {
		this.mainInformation = mainInformation;
		return this;
	}
	
	public NpcBuilder setFlags(final NpcFlags flags) {
		this.flags = flags;
		return this;
	}
	
	public NpcBuilder setSenses(final NpcSenses senses) {
		this.senses = senses;
		return this;
	}
	
	public NpcBuilder setAttributes(final NpcAttributes attributes) {
		this.attributes = attributes;
		return this;
	}
	
	public NpcBuilder setProtection(final NpcProtection protection) {
		this.protection = protection;
		return this;
	}
	
	public NpcBuilder setFightAbilities(final NpcFightAbilities fightAbilities) {
		this.fightAbilities = fightAbilities;
		return this;
	}
	
	public NpcBuilder setVisual(final NpcVisual visual) {
		this.visual = visual;
		return this;
	}
	
	public Npc build() {
		return new Npc(gothicVersion);
	}
}
