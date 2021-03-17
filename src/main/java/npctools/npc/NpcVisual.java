package npctools.npc;

public class NpcVisual {
	
	private boolean gender;
	private int fatness;
	
	private String walkStyle;
	private String headMesh;
	private String faceTexture;
	private String bodyTexture;
	private String armorWorn;
	
	// Getters
	public boolean getGender() {
		return gender;
	}
	
	public String getHeadMesh() {
		return headMesh;
	}
	
	public String getWalkStyle() {
		return walkStyle;
	}
	
	public String getFaceTexture() {
		return faceTexture;
	}
	
	public String getBodyTexture() {
		return bodyTexture;
	}
	
	public String getArmorWorn() {
		return armorWorn;
	}
	
	public int getFatness() {
		return fatness;
	}
	
	
	// Setters
	public void setHeadMesh(String headMesh) {
		this.headMesh = headMesh;
	}
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	public void setWalkStyle(String walkStyle) {
		this.walkStyle = walkStyle;
	}
	
	public void setArmorWorn(String armorWorn) {
		this.armorWorn = armorWorn;
	}
	
	public void setFaceTexture(String faceTexture) {
		this.faceTexture = faceTexture;
	}
	
	public void setBodyTexture(String bodyTexture) {
		this.bodyTexture = bodyTexture;
	}
	
	public void setFatness(int fatness) {
		this.fatness = fatness;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("Gender: ")
				.append(gender ? "MALE" : "FEMALE")
				.append(" | Walk Style: ")
				.append(walkStyle)
				.append(" | Head Mesh: ")
				.append(headMesh)
				.append(" | Face Texture: ")
				.append(faceTexture)
				.append(" | Body Texture: ")
				.append(bodyTexture)
				.append(" | Armor Worn: ")
				.append(armorWorn)
				.toString();
	}
	
}
